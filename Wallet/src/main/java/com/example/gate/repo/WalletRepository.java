package com.example.gate.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gate.entityclass.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, String> {

}
