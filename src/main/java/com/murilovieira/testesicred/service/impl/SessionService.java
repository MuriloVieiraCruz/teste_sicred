package com.murilovieira.testesicred.service.impl;

import com.murilovieira.testesicred.dto.SessionCreateDto;
import com.murilovieira.testesicred.entity.Discussion;
import com.murilovieira.testesicred.entity.Session;
import com.murilovieira.testesicred.entity.enums.SessionState;
import com.murilovieira.testesicred.exception.DiscussionNotFoundException;
import com.murilovieira.testesicred.repository.DiscussionRepository;
import com.murilovieira.testesicred.repository.SessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private DiscussionRepository discussionRepository;

    @Transactional
    public Session createSession(SessionCreateDto sessionCreateDto) {
        Discussion discussionFound = discussionRepository.findById(sessionCreateDto.discussionId()).orElseThrow(DiscussionNotFoundException::new);
        Session discussionSession = Session.builder()
                .discussion(discussionFound)
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