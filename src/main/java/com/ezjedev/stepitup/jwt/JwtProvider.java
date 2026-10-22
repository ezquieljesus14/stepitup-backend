package com.ezjedev.stepitup.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.ezjedev.stepitup.exceptions.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration-ms}")
	private long expiration;
	
	public String generateToken(Authentication authentication) {
		
		String username = authentication.getName();
		Date tokenCreation = new Date();
		Date tokenExpiration = new Date(tokenCreation.getTime() + expiration);
		
		String token = Jwts.builder()
				.subject(username)
				.issuedAt(tokenCreation)
				.expiration(tokenExpiration)
				.signWith(getSignInKey(), Jwts.SIG.HS256).compact();
		
		return token;
	}
	
	private SecretKey getSignInKey() {
		byte[] keyBites = secret.getBytes(StandardCharsets.UTF_8);		
		return Keys.hmacShaKeyFor(keyBites);
	}
	
	public String extractSubject(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser()
				   .verifyWith(getSignInKey())
				   .build()
				   .parseSignedClaims(token)
				   .getPayload();
	}
	
	public void validateToken(String token) {
		try {
			Jwts.parser()
		    .verifyWith(getSignInKey())
		    .build()
		    .parseSignedClaims(token);
		} catch (ExpiredJwtException e) {
			throw new UnauthorizedException("La sesión a expirado");
		} catch (JwtException e) {
			throw new UnauthorizedException("La sesión está corrupta, por favor vuelva a inicarla.");
		}
	}
}
