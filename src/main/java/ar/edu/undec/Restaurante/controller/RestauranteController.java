package ar.edu.undec.Restaurante.controller;

import ar.edu.undec.Restaurante.dto.Response;
import ar.edu.undec.Restaurante.model.Restaurante;
import ar.edu.undec.Restaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<Restaurante> findAllRestaurantes() throws Exception {
        Response response = restauranteService.findAllRestaurante();
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> findById(@PathVariable(name = "id") Integer idRestaurante) throws Exception {
        Response response = restauranteService.findOneById(idRestaurante);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Restaurante> findAllByNombre(@PathVariable(name = "nombre")
                                                                   String nombre) throws Exception {
        Response response = restauranteService.findAllByNombre(nombre);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/direcciones/{direccion}")
    public ResponseEntity<Restaurante> findAllByDireccion(@PathVariable(name = "direccion")
                                                                      String direccion) throws Exception {
        Response response = restauranteService.findAllByDireccion(direccion);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/precios/{precio}")
    public ResponseEntity<Restaurante> findAllByPrecio(@PathVariable(name = "precio")
                                                                  String precio) throws Exception {
        Response response = restauranteService.findAllByPrecio(precio);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Restaurante> createRestaurante(@Valid @RequestBody Restaurante restaurante) throws Exception {
        Response response = restauranteService.createRestaurante(restaurante);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Restaurante> updateRestaurante(@PathVariable(name = "id") Integer idRestaurante,
                                                         @Valid @RequestBody Restaurante restaurante) throws Exception {

        Response response = restauranteService.updateRestaurante(idRestaurante, restaurante);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @DeleteMapping
    public ResponseEntity<Restaurante> deleteRestaurante(@Valid @RequestBody Restaurante restaurante) {
        Response response = restauranteService.deleteResto(restaurante);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
