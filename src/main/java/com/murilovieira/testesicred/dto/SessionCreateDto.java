package com.murilovieira.testesicred.dto;

import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.enums.SessionState;

public record SessionCreateDto(Integer sessionDuration, SessionState sessionState, Discussion discussion) {
}
