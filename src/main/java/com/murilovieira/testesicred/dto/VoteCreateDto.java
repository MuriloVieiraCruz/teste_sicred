package com.murilovieira.testesicred.dto;

import com.murilovieira.testesicred.entity.Associate;
import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.enums.VoteAnswer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record VoteCreateDto(
        @NotNull(message = "Associate ID must be informed")
        Associate associate,

        @NotNull(message = "Vote answer must be informed")
        VoteAnswer voteAnswer) {
}
