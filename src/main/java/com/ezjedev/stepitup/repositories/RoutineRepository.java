package com.ezjedev.stepitup.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezjedev.stepitup.models.Routine;

public interface RoutineRepository extends JpaRepository<Routine, UUID> {

	List<Routine> findAllByUserId(UUID userId);
}
