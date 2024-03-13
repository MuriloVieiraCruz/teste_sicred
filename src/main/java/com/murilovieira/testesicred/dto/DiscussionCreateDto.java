package com.murilovieira.testesicred.dto;

import jakarta.validation.constraints.NotNull;

public record DiscussionCreateDto(
        @NotNull
        String subject,
        @NotNull
        String description,
        @NotNull
        Integer sessionDuration) {
}