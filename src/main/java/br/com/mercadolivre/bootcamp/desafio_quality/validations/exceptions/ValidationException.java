package br.com.mercadolivre.bootcamp.desafio_quality.validations.exceptions;

public class ValidationException {

    private String field;
    private String message;

    public ValidationException() {
    }

    public ValidationException(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
