package com.ezjedev.stepitup.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezjedev.stepitup.models.Activity;

public interface ActivityRepository extends JpaRepository<Activity, UUID> {

	List<Activity> findAllByRoutineIdOrderByStepOrder(UUID routineId);
}
