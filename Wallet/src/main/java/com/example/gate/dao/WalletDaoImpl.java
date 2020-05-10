package com.example.gate.dao;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.gate.entityclass.Transaction;
import com.example.gate.entityclass.Wallet;
import com.example.gate.logger.GlobalLogger;
import com.example.gate.repo.TransactionRepository;
import com.example.gate.repo.WalletRepository;



@Repository
public class WalletDaoImpl implements WalletDao{
	private Logger logger=GlobalLogger.getLogger(WalletDaoImpl.class);
	
	@Autowired
	private WalletRepository walletRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Wallet addUser(Wallet newUser) {
		
		String method="addUser(Wallet newUser)";
		logger.info(method + "called.."); 
		
		System.out.println(newUser); //
		newUser.setWalletAmount(0);;
		return walletRepository.save(newUser);
	}
	
	public Wallet getUser(String mobileNo) {

		String method="getUser(String mobileNo)";
		logger.info(method + "called.."); 
		
		Wallet w1 =  walletRepository.getOne(mobileNo);
		System.out.println(w1);
		return w1;
	}
	
	public Wallet updateUser(Wallet newUser) {
		
		String method="updateUser(Wallet newUser)";
		logger.info(method + "called..");
		
		return walletRepository.save(newUser);
	}
	
	public String transferFund(String sendersId, String receiversId, int amount, String explanation) { 
		
		String method="transferFund(String sendersId,String receiversId,int amount, String explanation)";
		logger.info(method + "called..");
		
        Wallet send = walletRepository.getOne(sendersId);
		
		System.out.println("this is sending onj :- "+send);
		Wallet rec = walletRepository.getOne(receiversId);
		
		System.out.println("this is reciver :- "+ rec);
		
		if ( send.getWalletAmount() >= amount) {
		
		String id = sendersId+"#"+Calendar.getInstance().getTime()+"#"+receiversId;
		
		//---------------- debit process --------------
		Transaction sendbal = new Transaction(id,amount, explanation, Calendar.getInstance().getTime());
		send.setWalletAmount(send.getWalletAmount() - sendbal.getTransactionAmount());
		
		List<Transaction> t = send.getTransaction();
		t.add(sendbal);
		send.setTransaction(t);
		
		transactionRepository.save(sendbal);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ----------------credit process-------------------------
		String id1 = sendersId+"#"+Calendar.getInstance().getTime()+"#"+receiversId;
		Transaction recbal = new Transaction(id1,amount, explanation, Calendar.getInstance().getTime());
		
		rec.setWalletAmount(rec.getWalletAmount() + recbal.getTransactionAmount());
		
		
		
		List<Transaction> t2 = rec.getTransaction();
		t2.add(recbal);
		rec.setTransaction(t2);
		
		
		transactionRepository.save(recbal);
		//----------------------------------------------------
		
		//wallet update
		
		walletRepository.save(send);
		walletRepository.save(rec);
	
		return "fund transfer successful";
		}
		else
		{
			return "transaction failed  'Insufficient balance'. ";
		}
		
	}
	
	public String addBalanceToWallet(String id, int amount) {
		
		String method="addBalanceToWallet(String id,int amount)";
		logger.info(method + "called..");
		
        Wallet w1 = walletRepository.getOne(id);
		
		String sid = id+"#"+Calendar.getInstance().getTime()+"#balanceAdded";
		
		Transaction addbal = new Transaction(sid,amount, "wallet_balance_added", Calendar.getInstance().getTime());
		
		w1.setWalletAmount(w1.getWalletAmount() + addbal.getTransactionAmount());
		List<Transaction> t = w1.getTransaction();
		t.add(addbal);
		w1.setTransaction(t);
		
		transactionRepository.save(addbal);
		walletRepository.save(w1);
		
		return "Balance added to Wallet successful...";
	}
	
	public List<Transaction> getTransaction(String id) {
		
		String method="getTransaction(String id)";
		logger.info(method + "called.."); 
		
		Wallet w1 = walletRepository.getOne(id);
		return w1.getTransaction();
	}
	
	public String addBalanceToBank(String id, int amount) {
		
		String method="addBalanceToBank(String id,int amount)";
		logger.info(method + "called.."); 	
		
        Wallet w1 = walletRepository.getOne(id);
		
		if (w1.getWalletAmount()>=amount)
		{

		String sid = id+"#"+Calendar.getInstance().getTime()+"#bankDeposited";

		Transaction addbal = new Transaction(sid,amount, "wallet_balance_Deposited", Calendar.getInstance().getTime());

		w1.setWalletAmount(w1.getWalletAmount() - addbal.getTransactionAmount());
		List<Transaction> t = w1.getTransaction();
		t.add(addbal);
		w1.setTransaction(t);
		transactionRepository.save(addbal);
		walletRepository.save(w1);
		return "Balance added to Bank successful...";
		}   
		else
		{
			return "Insufficient balance...";
		}
	}

}
