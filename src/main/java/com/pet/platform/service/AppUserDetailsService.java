package com.pet.platform.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserService userService = new UserService();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.find(username);
    }
}
