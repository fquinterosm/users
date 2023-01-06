package com.bci.users.infraestructure.controller.exception;

import com.bci.users.api.model.ApiErrorResponse;
import com.bci.users.infraestructure.exception.RepositoryException;
import com.bci.users.infraestructure.exception.ValidationException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<ApiErrorResponse> handleError(RepositoryException ex) {
        return new ResponseEntity<>(new ApiErrorResponse().mensaje(ex.getMessage()), HttpStatus.BAD_GATEWAY);
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleError(ValidationException ex) {
        return new ResponseEntity<>(new ApiErrorResponse().mensaje(ex.getMessage()), HttpStatus.BAD_GATEWAY);
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorResponse> handleError(RuntimeException ex) {
        return new ResponseEntity<>(new ApiErrorResponse().mensaje(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        //
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        final ApiResponseMessagesList apiError = new ApiResponseMessagesList(errors);
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }


}
