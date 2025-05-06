package com.ecommerce.user.service;

/**
 * @author Hitesh
 */

import com.ecommerce.user.entity.User;
import com.ecommerce.user.entity.VerificationToken;
import com.ecommerce.user.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Value("${app.email.token.expiry.minutes:15}")
    private int tokenExpiryMinutes;


    public VerificationToken createToken(User user) {
        VerificationToken token = new VerificationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(LocalDateTime.now().plusMinutes(tokenExpiryMinutes)); // Token valid for 15 minutes
        return tokenRepository.save(token);
    }
}