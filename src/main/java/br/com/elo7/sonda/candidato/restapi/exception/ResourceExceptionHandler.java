package br.com.elo7.sonda.candidato.restapi.exception;

import br.com.elo7.sonda.candidato.restapi.controller.dto.FieldErrorDTO;
import br.com.elo7.sonda.candidato.restapi.controller.dto.StandardErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                  HttpServletRequest request){

        List<FieldErrorDTO> errors = new ArrayList<>();

        ex.getFieldErrors()
          .forEach(fe-> errors.add(new FieldErrorDTO(fe.getField(), fe.getDefaultMessage())));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(new StandardErrorDTO(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), errors));
    }
}
