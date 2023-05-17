package com.example.springbootshoppingcart.exception;

public class UploadFailException extends RuntimeException{
    public UploadFailException(String message) {
        super(message);
    }

    public UploadFailException(String message, Throwable cause) {
        super(message, cause);
    }
}
