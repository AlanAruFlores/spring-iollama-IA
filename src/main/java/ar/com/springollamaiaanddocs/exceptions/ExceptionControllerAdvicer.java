package ar.com.springollamaiaanddocs.exceptions;

import ar.com.springollamaiaanddocs.dto.response.MessageResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/*
* Manejador de excepciones en las APIs
* */
@ControllerAdvice(annotations = RestController.class)
public class ExceptionControllerAdvicer{

    @ExceptionHandler(ResponseNotExistsException.class)
    public ResponseEntity<?> handleResponseNotExistsException(ResponseNotExistsException ex){
        return ResponseEntity.badRequest().body(new MessageResponseDto(ex.getMessage()));
    }
}
