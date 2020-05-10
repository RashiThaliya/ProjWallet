package com.example.gate.service;

import java.util.List;

import com.example.gate.entityclass.Transaction;
import com.example.gate.entityclass.Wallet;

public interface WalletService {

	public Wallet getUser(String mobileNo);
	public Wallet updateUser(Wallet newUser);
	public String transferFund (String sendersId,String receiversId,int amount, String explanation);
	public String addBalanceToWallet(String id,int amount);
	public List<Transaction> getTransaction(String id);
	public String addBalanceToBank(String id, int amount );
	public Wallet addUser(Wallet newUser);
}
