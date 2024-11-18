package com.example.volleyball.models;

public abstract class CustomException extends RuntimeException {
    private String code;
    private String message;
    private String details;
    public CustomException(Exception e) {
    }
}
