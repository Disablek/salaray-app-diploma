package com.practiseapp.userservice.model;

import java.util.Objects;
import java.util.Set;

public record User(
        Email id,
        String firstName,
        String lastName,
        String surName,
        String password,
        Set<Role> roles,
        Boolean isEnabled
)
{

    public String getFullName() {
        return firstName + " " + lastName + (surName != null ? surName : "");
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User user)) {
            return false;
        }
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
