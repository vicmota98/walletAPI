package com.victoria.wallet.security.service;

import com.victoria.wallet.entity.User;
import com.victoria.wallet.security.JwtUserFactory;
import com.victoria.wallet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(email);

        if(user.isPresent()) {
            return JwtUserFactory.create(user.get());
        }
        throw new UsernameNotFoundException("Email não encontrado.");
    }
}
