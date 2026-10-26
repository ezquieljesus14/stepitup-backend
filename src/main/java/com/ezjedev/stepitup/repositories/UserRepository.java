package com.ezjedev.stepitup.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ezjedev.stepitup.models.Api_user;
import java.util.Optional;


public interface UserRepository extends JpaRepository<Api_user, UUID> {

	Optional<Api_user> findByEmail(String email);
}
