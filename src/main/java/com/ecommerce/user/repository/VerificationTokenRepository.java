package com.ecommerce.user.repository;

/**
 * @author Hitesh
 */
// File: src/main/java/com/ecommerce/user/repository/VerificationTokenRepository.java

import com.ecommerce.user.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}