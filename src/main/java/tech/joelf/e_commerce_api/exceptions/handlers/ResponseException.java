package tech.joelf.e_commerce_api.exceptions.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ResponseException {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public ResponseException() {
    }

    public ResponseException(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

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
}
