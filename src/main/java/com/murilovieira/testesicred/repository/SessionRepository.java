package com.murilovieira.testesicred.repository;

import com.murilovieira.testesicred.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
