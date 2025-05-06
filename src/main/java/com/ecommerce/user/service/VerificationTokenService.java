package com.ecommerce.user.service;

/**
 * @author Hitesh
 */

import com.ecommerce.user.entity.User;
import com.ecommerce.user.entity.VerificationToken;
import com.ecommerce.user.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository tokenRepository;

    public VerificationToken createToken(User user) {
        VerificationToken token = new VerificationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(LocalDateTime.now().plusHours(24)); // Token valid for 24 hours
        return tokenRepository.save(token);
    }
}