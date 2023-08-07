package com.devsuperior.challenges.crudclients.dtos;

public class FieldErrorMessage {

    private String fieldName;
    private String message;

    public FieldErrorMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
