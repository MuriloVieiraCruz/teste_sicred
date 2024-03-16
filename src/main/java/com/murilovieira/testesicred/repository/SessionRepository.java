package com.murilovieira.testesicred.repository;

import com.murilovieira.testesicred.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM tb_session WHERE nr_session_state = 'OPEN' AND dt_session_end <= NOW())", nativeQuery = true)
    public boolean isAlreadyVoted();

    @Query(value = "UPDATE tb_session SET nr_session_state = 'CLOSED' WHERE nr_session_state = 'OPEN' AND dt_session_end <= NOW()", nativeQuery = true)
    public Session updateSessionsClosed();

    @Query(value = "SELECT COUNT(*) FROM tb_vote WHERE session_id = :sessionId AND vl_vote_answer = :value", nativeQuery = true)
    public int countVoteSession(Long sessionId, Boolean value);
}
