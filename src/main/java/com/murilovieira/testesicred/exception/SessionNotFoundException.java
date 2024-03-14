package com.murilovieira.testesicred.exception;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException() {
        super("Session not found");
    }
}
