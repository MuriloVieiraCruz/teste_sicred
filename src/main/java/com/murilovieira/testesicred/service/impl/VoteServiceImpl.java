package com.murilovieira.testesicred.service.impl;

import com.murilovieira.testesicred.dto.VoteCreateDto;
import com.murilovieira.testesicred.entity.Session;
import com.murilovieira.testesicred.entity.Vote;
import com.murilovieira.testesicred.exception.AlreadyVotedException;
import com.murilovieira.testesicred.exception.SessionNotFoundException;
import com.murilovieira.testesicred.repository.SessionRepository;
import com.murilovieira.testesicred.repository.VoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Transactional
    public void voteInSession(Long sessionId, VoteCreateDto voteCreateDto) {
        Session sessionFound = sessionRepository.findById(sessionId).orElseThrow(SessionNotFoundException::new);
        boolean hasVoted = voteRepository.isAlreadyVoted(sessionFound.getId(), voteCreateDto.associate().getId());
        if (hasVoted) {
            throw new AlreadyVotedException();
        }
        Vote newVote = Vote.builder()
                .voteAnswer(voteCreateDto.voteAnswer().getValue())
                .session(sessionFound)
                .associate(voteCreateDto.associate())
                .build();
        voteRepository.save(newVote);
    }
}
