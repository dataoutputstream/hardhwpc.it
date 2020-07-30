package com.hardhwpc.backend.controllers.rest;

public class ResponseMessage {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
    public ResponseMessage(String s) {
        message=s;
    }
}
