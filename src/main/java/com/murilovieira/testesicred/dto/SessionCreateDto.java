package com.murilovieira.testesicred.dto;

import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.enums.SessionState;
import jakarta.validation.constraints.NotNull;

public record SessionCreateDto(

        Long sessionDuration,

        @NotNull
        Long discussionId) {
}
