package com.ezjedev.stepitup.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezjedev.stepitup.models.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, UUID> {

	List<ActivityLog> findAllBySessionId(UUID sessionId);
}
