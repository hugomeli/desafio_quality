package br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions;

public class DistrictAlreadySavedException extends RuntimeException{

    public DistrictAlreadySavedException(String message){
        super(message);
    }
}
