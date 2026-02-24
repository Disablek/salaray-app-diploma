package com.salaryapp.userservice.port.out.persistence;

import com.practiseapp.userservice.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String email);

    void create(User user);

    User save(User user);

    void deleteById(String email);

    boolean existsByEmail(String email);
}
