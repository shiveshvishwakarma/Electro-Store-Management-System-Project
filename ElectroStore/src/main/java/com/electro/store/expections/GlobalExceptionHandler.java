package com.electro.store.expections;

import com.electro.store.dtos.ApiResponceMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    //handle resource not found exception

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponceMessage> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){

        logger.info("Exception Handler invoked !!");
        ApiResponceMessage responce = ApiResponceMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity(responce,HttpStatus.NOT_FOUND);


    }

    //MethodArgumentNotValidException
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        Map<String, Object> responce= new HashMap<>();
        allErrors.stream().forEach(objectError -> {
            String message = objectError.getDefaultMessage();
            String field = ((FieldError) objectError).getField();

            responce.put(field,message);
        });

        return new ResponseEntity<>(responce,HttpStatus.BAD_REQUEST);

    }

    //handle bad api exception

    @ExceptionHandler(BadApiRequest.class)
    public ResponseEntity<ApiResponceMessage> handleBadApiRequest(BadApiRequest ex){

        logger.info("Bad api request !!");
        ApiResponceMessage responce = ApiResponceMessage.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).success(false).build();
        return new ResponseEntity(responce,HttpStatus.BAD_REQUEST);


    }


}
