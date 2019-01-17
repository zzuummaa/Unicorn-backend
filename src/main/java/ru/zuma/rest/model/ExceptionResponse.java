package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExceptionResponse {
    private Integer status;
    private String errorMessage;

    public ExceptionResponse() {

    }

    public ExceptionResponse(String errorMessage) {
        this.status = HttpStatus.BAD_REQUEST.value();
        this.errorMessage = errorMessage;
    }

    public ExceptionResponse(HttpStatus status, String errorMessage) {
        this.status = status.value();
        this.errorMessage = errorMessage;
    }

    @JsonGetter(value = "er_msg")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ResponseEntity<ExceptionResponse> toEntity() {
        return ResponseEntity.status(HttpStatus.valueOf(status)).body(this);
    }

    public void write(HttpServletResponse response) throws IOException {
        response.setStatus(status);
        PrintWriter writer = response.getWriter();
        writer.println(new ObjectMapper().writeValueAsString(this));
    }
}
