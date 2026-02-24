package com.salaryapp.userservice.in.security;

import com.practiseapp.userservice.model.Role;
import com.practiseapp.userservice.model.User;
import lombok.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;
import java.util.stream.Collectors;

public record UserSecurityAdapter(User user) implements UserDetails {

    @Override
    public @NonNull Set<GrantedAuthority> getAuthorities() {
        return user.roles().stream()
                .map(Role::name)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @Override
    public @Nullable String getPassword() {
        return user.password();
    }

    @Override
    public @NonNull String getUsername() {
        return user.id().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
