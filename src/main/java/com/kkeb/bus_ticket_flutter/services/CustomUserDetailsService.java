package com.kkeb.bus_ticket_flutter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kkeb.bus_ticket_flutter.entities.AppUser;
import com.kkeb.bus_ticket_flutter.repos.AppUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{


    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final AppUser appUser = appUserRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User doesn't exist"));
        return User.builder().username(appUser.getUserName()).password(appUser.getPassword()).roles(appUser.getRole()).build();
    }
    
}
