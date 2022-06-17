package com.example.demo.Exception;

public class ResourceNotFound extends RuntimeException{

    String message;
    public ResourceNotFound(String user_does_not_exists) {
        message = user_does_not_exists;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
