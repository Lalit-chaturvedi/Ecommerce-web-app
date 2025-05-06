package com.ecommerce.user.controller;


/**
 * @author Hitesh
 */
import com.ecommerce.user.entity.VerificationToken;
import com.ecommerce.user.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
@RestController
public class VerificationController {
    @Autowired
    private VerificationTokenRepository tokenRepository;

    @GetMapping("/api/v1/auth/verify-email")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Invalid token"));

        if (verificationToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            return ResponseEntity.badRequest().body("Token expVerificationTokenired");
        }

        verificationToken.getUser().setEmailVerified(true);
        tokenRepository.delete(verificationToken); // Optional: Delete token after verification

        return ResponseEntity.ok("Email verified successfully");
    }
}