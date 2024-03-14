package com.murilovieira.testesicred.service.impl;

import com.murilovieira.testesicred.dto.DiscussionCreateDto;
import com.murilovieira.testesicred.dto.SessionCreateDto;
import com.murilovieira.testesicred.dto.VoteCreateDto;
import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.Session;
import com.murilovieira.testesicred.entity.enums.SessionState;
import com.murilovieira.testesicred.exception.SessionNotFoundException;
import com.murilovieira.testesicred.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionServiceImpl {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(SessionCreateDto sessionCreateDto) {
        Session discussionSession = Session.builder()
                .discussion(sessionCreateDto.discussion())
                .sessionStart(LocalDateTime.now())
                .sessionDuration(sessionCreateDto.sessionDuration())
                .sessionState(SessionState.OPEN)
                .build();
        calculateSessionEnd(discussionSession);
        return sessionRepository.save(discussionSession);
    }

    private void calculateSessionEnd(Session session) {
        session.validateSessionDuration();
    }
}