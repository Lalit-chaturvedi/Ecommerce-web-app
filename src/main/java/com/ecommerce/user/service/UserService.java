package com.ecommerce.user.service;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.entity.VerificationToken;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenService verificationTokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${app.email.verification.link}")
    private String verificationUrl;

    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPhoneVerified(false);

        User createdUser= userRepository.save(user);
        String token = verificationTokenService.createToken(createdUser).getToken();
        sendEmailForVerification(createdUser, token);
        return createdUser;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return user;
    }

    @Autowired
    private VerificationTokenService tokenService;

    @Autowired
    private EmailService emailService;

    private void sendEmailForVerification(User user,String token) {
        // Send verification email
        emailService.sendVerificationEmail(user.getEmail(), verificationUrl+ token);
    }
}