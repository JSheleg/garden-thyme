package com.company.growzoneservice.dto;

import java.time.LocalDateTime;

public class CustomErrorResponse {
    
    private String errorMsg;
    private int status;
    private String errorCode;
    private LocalDateTime timestamp;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String errorMsg, int status, String errorCode, LocalDateTime timestamp) {
        this.errorMsg = errorMsg;
        this.status = status;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    public CustomErrorResponse(String toString, String defaultMessage) {
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
