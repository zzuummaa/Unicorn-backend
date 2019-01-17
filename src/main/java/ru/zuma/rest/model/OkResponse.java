package ru.zuma.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class OkResponse {
    private Integer status;

    public OkResponse() {
        this.status = HttpStatus.OK.value();
    }

    public OkResponse(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ResponseEntity<OkResponse> toEntity() {
        return ResponseEntity.status(HttpStatus.valueOf(status)).body(this);
    }
}
