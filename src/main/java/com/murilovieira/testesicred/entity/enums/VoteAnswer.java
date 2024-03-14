package com.murilovieira.testesicred.entity.enums;

public enum VoteAnswer {
    SIM(true),
    NAO(false);

    private final boolean value;

    VoteAnswer(boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return value;
    }
}
