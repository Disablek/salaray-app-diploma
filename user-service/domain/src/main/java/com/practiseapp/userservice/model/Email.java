package com.practiseapp.userservice.model;

import java.util.Objects;

public record Email(String value) {
    public Email {
        if (value == null || !value.matches("^.+@.+\\..+$")) {
            throw new IllegalArgumentException("Invalid email: " + value);
        }
    }

    public String getUsername() {
        return value.split("@")[0];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Email(String finalValue))) return false;
        return value.equals(finalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
