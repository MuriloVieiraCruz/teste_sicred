package com.murilovieira.testesicred.exception;

public class AlreadyVotedException extends RuntimeException {

    public AlreadyVotedException() {
        super("You have already voted in this session");
    }}
