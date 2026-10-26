package com.ezjedev.stepitup.services;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ezjedev.stepitup.models.Api_user;
import com.ezjedev.stepitup.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Api_user apiUser = userRepository.findByEmail(username).orElseThrow(
				() -> new UsernameNotFoundException("ERROR: Usuario no encontrado"));
		
		return User.builder().
				username(apiUser.getEmail()).
				password(apiUser.getPassword()).
				authorities(List.of()).
				build()
				;
	}
	
	
}
