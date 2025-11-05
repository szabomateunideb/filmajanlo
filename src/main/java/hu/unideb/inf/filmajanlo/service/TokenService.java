package hu.unideb.inf.filmajanlo.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.security.SecureRandom;

public interface TokenService {
    String generateToken(UserDetails user);
    String extractUsername(String token);
    Boolean validateToken(String token, UserDetails user);
}
