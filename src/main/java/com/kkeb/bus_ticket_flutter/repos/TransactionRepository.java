package com.kkeb.bus_ticket_flutter.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kkeb.bus_ticket_flutter.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
