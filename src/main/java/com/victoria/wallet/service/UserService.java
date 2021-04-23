package com.victoria.wallet.service;

import com.victoria.wallet.entity.User;

import java.util.Optional;

public interface UserService {
    User save(User u);
    Optional<User> findByEmail(String email);
}
