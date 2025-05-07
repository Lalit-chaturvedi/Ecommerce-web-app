package com.ecommerce.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    private boolean emailVerified;
    @NotBlank
    @Column(nullable = false)
    private String password;

    private String role = "USER";

    private String phoneNumber;
    private boolean phoneVerified;

    private boolean active;

}