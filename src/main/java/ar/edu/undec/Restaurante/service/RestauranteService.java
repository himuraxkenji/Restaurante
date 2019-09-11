package ar.edu.undec.Restaurante.service;

import ar.edu.undec.Restaurante.dto.Response;
import ar.edu.undec.Restaurante.model.Restaurante;
import ar.edu.undec.Restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Response findAllRestaurante()throws Exception{
        Response response = new Response();
        List<Restaurante> listRestaurante = restauranteRepository.findAll();

        if(listRestaurante == null)
            throw new NoSuchElementException();

        setResponse(response, 200, "Listado - Todos", listRestaurante);

        return response;
    }


    public  Response findOneById(Integer id)throws Exception{
        Response response = new Response();
        Restaurante restaurante = restauranteRepository.findById(id).get();

        if(restaurante == null)
            throw new EntityNotFoundException();

        setResponse(response, 20, "Restaurante", restaurante);

        return response;

    }

    public Response findAllByNombre(String nombre)throws Exception{
        Response response = new Response();
        List<Restaurante> listRestaurante = restauranteRepository.findAllByNombreContains(nombre);

        if(listRestaurante == null)
            throw new NoSuchElementException();

        setResponse(response, 200, "Listado - Nombre", listRestaurante);

        return response;
    }

    public Response findAllByDireccion(String direccion)throws Exception{
        Response response = new Response();
        List<Restaurante> listRestaurante = restauranteRepository.findAllByDireccion(direccion);

        if(listRestaurante == null)
            throw new NoSuchElementException();

        setResponse(response, 200, "Listado - Direccion", listRestaurante);

        return response;
    }

    public Response findAllByPrecio(String precio)throws Exception{
        Response response = new Response();
        List<Restaurante> listRestaurante = restauranteRepository.findAllByPrecio(precio);

        if(listRestaurante == null)
            throw new NoSuchElementException();

        setResponse(response, 200, "Listado - Precio", listRestaurante);

        return response;
    }

    public Response createRestaurante(Restaurante restaurante)throws Exception{
        Response response = new Response();

        Restaurante created = restauranteRepository.save(restaurante);
        if (created == null)
            throw new RuntimeException();
        setResponse(response, 200, "Created", created);

        return response;
    }

    public Response updateRestaurante(Integer idRestaurante , Restaurante restaurante)throws Exception{
        Response response = new Response();
        Restaurante updated = restauranteRepository.save(restaurante);

        if (updated == null)
            throw new RuntimeException();

        updated.setNombre(restaurante.getNombre());
        updated.setDescripcion(restaurante.getDescripcion());
        updated.setDireccion(restaurante.getDireccion());
        updated.setImagen(restaurante.getImagen());
        updated.setPrecio(restaurante.getPrecio());

        setResponse(response, 200, "Updated", updated);

        return response;
    }

    public Response deleteResto(Restaurante restaurante){
        Response response = new Response();
        restauranteRepository.delete(restaurante);

        setResponse(response, 200, "deleted", restaurante);

        return response;
    }

    private void setResponse(Response response, Integer code, String msg, Object data){
        response.setCode(code);
        response.setMessage(msg);
        response.setData(data);

    }


}
