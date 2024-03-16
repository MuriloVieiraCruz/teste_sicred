package com.murilovieira.testesicred.repository;

import com.murilovieira.testesicred.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}