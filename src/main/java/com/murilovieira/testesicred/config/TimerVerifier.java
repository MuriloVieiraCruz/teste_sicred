package com.murilovieira.testesicred.config;

import com.murilovieira.testesicred.entity.Session;
import com.murilovieira.testesicred.entity.enums.SessionState;
import com.murilovieira.testesicred.entity.enums.VoteAnswer;
import com.murilovieira.testesicred.repository.DiscussionRepository;
import com.murilovieira.testesicred.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
@EnableAsync
public class TimerVerifier {

    @Autowired
    private SessionRepository sessionRepository;

    public void endSession(Session session) {
        session.setSessionState(SessionState.CLOSED);
    }

    public void setResultVotesOnDiscussion(Session session) {
        int totalPositiveVotes = sessionRepository.countVoteSession(session.getId(), VoteAnswer.SIM.getValue());
        int totalNegativeVotes = sessionRepository.countVoteSession(session.getId(), VoteAnswer.NAO.getValue());
        session.getDiscussion().setTotalVotesYes(totalPositiveVotes);
        session.getDiscussion().setTotalVotesNo(totalNegativeVotes);
    }

    @Async
    @Scheduled(fixedRate = 30000)
    public void verifyTime() {
        boolean existSessionClosed = sessionRepository.isAlreadyVoted();
        if (existSessionClosed) {
            List<Session> sessionList = sessionRepository.findBySessionsExpired();
            sessionList.forEach(actualSession -> {
                endSession(actualSession);
                setResultVotesOnDiscussion(actualSession);
            });
            sessionRepository.saveAll(sessionList);
        }
    }
}
