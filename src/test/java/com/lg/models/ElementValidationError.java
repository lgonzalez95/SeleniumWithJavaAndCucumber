package com.lg.models;

public class ElementValidationError {
    private String fieldName;
    private String validationMessage;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationError) {
        this.validationMessage = validationError;
    }
}
