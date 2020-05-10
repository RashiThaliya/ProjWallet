package com.example.gate.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.gate.dao.WalletDao;
import com.example.gate.entityclass.Transaction;
import com.example.gate.entityclass.Wallet;
import com.example.gate.logger.GlobalLogger;



@Service
public class WalletServiceImpl implements WalletService{
private Logger logger=GlobalLogger.getLogger(WalletServiceImpl.class);
	
	@Autowired
	WalletDao dao;
	
	@Override
	public Wallet addUser(Wallet newUser) {
		// TODO Auto-generated method stub
		String method="addUser(Wallet newUser)";
		logger.info(method + "called..");
		
		return dao.addUser(newUser);
	}
	
	@Override
	public Wallet getUser(String mobileNo) {
		// TODO Auto-generated method stub
		String method="getUser(String mobileNo)";
		logger.info(method + "called..");
		
		return dao.getUser(mobileNo);
	}
	
	@Override
	public Wallet updateUser(Wallet newUser) {
		// TODO Auto-generated method stub
		String method="updateUser(Wallet newUser)";
		logger.info(method + "called..");
		
		return dao.updateUser(newUser);
	}
	
	@Override
	public String transferFund(String sendersId, String receiversId, int amount, String explanation) {
		// TODO Auto-generated method stub
		String method="transferFund(String sendersId,String receiversId,int amount, String explanation)";
		logger.info(method + "called..");
		
		return dao.transferFund(sendersId, receiversId, amount, explanation);
	}
	
	@Override
	public String addBalanceToWallet(String id, int amount) {
		// TODO Auto-generated method stub
		String method="addBalanceToWallet(String id,int amount)";
		logger.info(method + "called..");
		
		return dao.addBalanceToWallet(id, amount);
	}
	
	@Override
	public List<Transaction> getTransaction(String id) {
		// TODO Auto-generated method stub
		String method="getTransaction(String id)";
		logger.info(method + "called.."); 
		
		return dao.getTransaction(id);
	}
	
	@Override
	public String addBalanceToBank(String id, int amount) {
		// TODO Auto-generated method stub
		String method="addBalanceToBank(String id,int amount)";
		logger.info(method + "called.."); 	
		
		return dao.addBalanceToBank(id, amount);
	}
}
