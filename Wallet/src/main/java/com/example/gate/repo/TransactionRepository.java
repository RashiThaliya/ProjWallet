package com.example.gate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gate.entityclass.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
