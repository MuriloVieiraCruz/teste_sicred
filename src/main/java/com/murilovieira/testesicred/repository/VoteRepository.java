package com.murilovieira.testesicred.repository;

import com.murilovieira.testesicred.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM tb_vote WHERE session_id = :sessionId AND associate_id = :associateId)", nativeQuery = true)
    public boolean isAlreadyVoted(Long sessionId, Long associateId);
}
