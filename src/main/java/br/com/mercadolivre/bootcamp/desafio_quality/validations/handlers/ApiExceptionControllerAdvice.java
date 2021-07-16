package br.com.mercadolivre.bootcamp.desafio_quality.validations.handlers;

import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictAlreadySavedException;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.DistrictNotFoundException;
import br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ApiExceptionControllerAdvice {

    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionControllerAdvice(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationException> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<ValidationException> errors = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError -> {
            String message = messageSource.getMessage(fieldError, Locale.ENGLISH);
            errors.add(new ValidationException(fieldError.getField(), message));
        });

        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DistrictAlreadySavedException.class)
    public String handleDistrictAlreadySaved(DistrictAlreadySavedException exception){
        return exception.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DistrictNotFoundException.class)
    public String handleDistrictNotFound(DistrictNotFoundException exception){
        return exception.getMessage();
    }
}
