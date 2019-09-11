package ar.edu.undec.Restaurante.controller;

import ar.edu.undec.Restaurante.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;
import java.util.NoSuchElementException;

@ControllerAdvice(basePackages = "ar.edu.undec.Restaurante.controller")
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestauranteExceptionHandler {

    Logger LOG = LoggerFactory.getLogger(RestauranteExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGeneralException(Exception ex) {
        Response response = new Response();
        response.setCode(501);
        response.setMessage("Error General");
        response.setData(ex.getMessage());

        LOG.error("Error de tipo Exception:");
        LOG.error(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Response> handleNoSuchElementException(Exception ex) {
        Response response = new Response();
        response.setCode(404);
        response.setMessage("Elemento no localizado");
        response.setData(ex.getMessage());

        LOG.warn("El elemento no se encuentra en la BD");
        LOG.error(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Response> handleEntityNotFoundException(Exception ex) {
        Response response = new Response();
        response.setCode(405);
        response.setMessage("No se obtuvo ningun resultado");
        response.setData(ex.getMessage());

        LOG.warn("Consulta mal realizada a la  BD");
        LOG.error(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handleRuntimeException(Exception ex){
        Response response = new Response();
        response.setCode(505);
        response.setMessage("Problemas en el servido");
        response.setData(ex.getMessage());

        LOG.warn("Error del servido deberia revisar DB");
        LOG.error(ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
