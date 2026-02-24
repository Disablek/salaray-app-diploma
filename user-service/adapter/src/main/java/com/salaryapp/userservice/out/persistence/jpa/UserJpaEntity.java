package com.salaryapp.userservice.out.persistence.jpa;

import com.practiseapp.userservice.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.jspecify.annotations.Nullable;

import java.util.Set;

@Entity
@Data
@Table(name="users")
public class UserJpaEntity {

    @Id
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Nullable
    private String surName;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private Boolean isEnabled = true;
}
