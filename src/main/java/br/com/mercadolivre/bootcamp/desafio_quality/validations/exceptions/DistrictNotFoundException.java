package br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions;

public class DistrictNotFoundException extends RuntimeException{

    public DistrictNotFoundException(String message) {
        super(message);
    }
}
