package ar.edu.undec.Restaurante.repository;

import ar.edu.undec.Restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer> {

    List<Restaurante> findAllByDireccion(String direccion);
    List<Restaurante> findAllByNombreContains(String nombre);

    @Query("SELECT r from Restaurante r where r.precio =(:precio) ")
    List<Restaurante> findAllByPrecio(@Param("precio") String precio);

}
