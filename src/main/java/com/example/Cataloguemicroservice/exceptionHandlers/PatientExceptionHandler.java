package com.example.Cataloguemicroservice.exceptionHandlers;


import com.example.Cataloguemicroservice.Exceptions.MyEntityNotFoundException;
import com.example.Cataloguemicroservice.customErrors.PatientErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<PatientErrorResponse> handleException(MyEntityNotFoundException exception){
        PatientErrorResponse errorResponse=new PatientErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStampoftheError(System.currentTimeMillis()+"");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<PatientErrorResponse> handleException(Exception exception){
        PatientErrorResponse errorResponse=new PatientErrorResponse();
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStampoftheError(System.currentTimeMillis()+"");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }




}
