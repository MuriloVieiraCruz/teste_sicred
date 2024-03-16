package com.murilovieira.testesicred.exception;

public class DiscussionNotFoundException extends RuntimeException {

    public DiscussionNotFoundException() {
        super("Discussion not found");
    }
}
