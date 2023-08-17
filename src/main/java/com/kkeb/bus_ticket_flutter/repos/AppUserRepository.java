package com.kkeb.bus_ticket_flutter.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kkeb.bus_ticket_flutter.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
    Optional<AppUser> findByUserName(String userName);
    
}
