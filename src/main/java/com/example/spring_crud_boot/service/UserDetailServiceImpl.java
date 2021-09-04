package com.example.spring_crud_boot.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final AppServiceImpl appService;

    public UserDetailServiceImpl(AppServiceImpl appService) {
        this.appService = appService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appService.loadUserByUsername(username);
    }
}