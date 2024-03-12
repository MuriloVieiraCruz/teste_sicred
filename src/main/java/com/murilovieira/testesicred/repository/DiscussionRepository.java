package com.murilovieira.testesicred.repository;

import com.murilovieira.testesicred.entity.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}