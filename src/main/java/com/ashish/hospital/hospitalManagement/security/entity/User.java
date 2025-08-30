package com.ashish.hospital.hospitalManagement.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String role;

    @PrePersist
    @PreUpdate
    public void ensureRolePrefix() {
        if (role != null && !role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
    }
}
