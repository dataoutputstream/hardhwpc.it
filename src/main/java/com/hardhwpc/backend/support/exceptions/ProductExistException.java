package com.hardhwpc.backend.support.exceptions;

public class ProductExistException extends Exception {
    private static final long serialVersionUID = 1885653349235601203L;

    public ProductExistException() {
    }
    public ProductExistException(String message) {
        super(message);
    }
}
