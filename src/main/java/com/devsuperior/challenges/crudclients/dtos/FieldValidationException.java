package com.devsuperior.challenges.crudclients.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FieldValidationException extends ResponseException {

    private List<FieldErrorMessage> errors = new ArrayList<>();

    //region Constructor
    public FieldValidationException(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }
    //endregion

    //region Access Method
    public List<FieldErrorMessage> getErrors() {
        return errors;
    }
    //endregion

    //region Builder
    public static FieldValidationExceptionBuilder builder() {
        return new FieldValidationExceptionBuilder();
    }

    public static class FieldValidationExceptionBuilder extends ResponseExceptionBuilder {

        private Instant timestamp;
        private Integer status;
        private String error;
        private String path;

        public FieldValidationExceptionBuilder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public FieldValidationExceptionBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public FieldValidationExceptionBuilder error(String error) {
            this.error = error;
            return this;
        }

        public FieldValidationExceptionBuilder path(String path) {
            this.path = path;
            return this;
        }

        public FieldValidationException build() {
            return new FieldValidationException(
                    timestamp,
                    status,
                    error,
                    path
            );
        }
    }
    //endregion

    public void addError(String fieldName, String message) {
        errors.add(
                new FieldErrorMessage(fieldName, message)
        );
    }
}
