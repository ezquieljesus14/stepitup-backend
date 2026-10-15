package com.ezjedev.stepitup.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezjedev.stepitup.models.Session;
import com.ezjedev.stepitup.models.Status;

public interface SessionRepository extends JpaRepository<Session, UUID> {

	Optional<Session> findByUserIdAndStatus(UUID userId, Status status);
}
