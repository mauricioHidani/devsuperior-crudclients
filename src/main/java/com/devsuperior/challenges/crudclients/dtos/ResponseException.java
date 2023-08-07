package com.devsuperior.challenges.crudclients.dtos;

import java.time.Instant;

public class ResponseException {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    //region Constructor
    public ResponseException(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }
    //endregion

    //region Access Methods
    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
    //endregion

    //region Builder
    public static ResponseExceptionBuilder builder() {
        return new ResponseExceptionBuilder();
    }

    public static class ResponseExceptionBuilder {
        private Instant timestamp;
        private Integer status;
        private String error;
        private String path;

        public ResponseExceptionBuilder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResponseExceptionBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ResponseExceptionBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ResponseExceptionBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ResponseException build() {
            return new ResponseException(
                    timestamp,
                    status,
                    error,
                    path
            );
        }
    }
    //endregion
}
