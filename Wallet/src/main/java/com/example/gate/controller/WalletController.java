package com.example.gate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.gate.entityclass.Transaction;
import com.example.gate.entityclass.Wallet;
import com.example.gate.logger.GlobalLogger;
import com.example.gate.service.WalletServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController	
public class WalletController {

	private Logger logger=GlobalLogger.getLogger(WalletController.class);
	
	@Autowired
	WalletServiceImpl wpsi;
	
	@CrossOrigin
	@PostMapping(path="/createNewUser",consumes ="application/json")
	public Wallet addUser(@RequestBody Wallet newUser)
	{
		String method="addUser(Wallet newUser)";
		logger.info(method + "called.."); 
		
		return wpsi.addUser(newUser);
		
		
	}
	
	@GetMapping("/getUser/{mobileNo}")
	public Wallet getUser(@PathVariable String mobileNo)
	{
		String method="getUser(String mobileNo)";
		logger.info(method + "called.."); 	
		
		return wpsi.getUser(mobileNo);
	
	}
	
	@PutMapping("/updateUser")
	public Wallet updateUser(@RequestBody Wallet newUser)
	{
		String method="updateUser(Wallet newUser)";
		logger.info(method + "called.."); 
		
		return wpsi.updateUser(newUser);
	
		
	}
	
	@PutMapping("/fundTransfer/{sendersId}/{receiversId}/{amount}/{explanation}")
	public String transferFund (@PathVariable("sendersId") String sendersId,@PathVariable("receiversId") String receiversId, @PathVariable("amount") int amount, @PathVariable("explanation") String explanation) 
	{
		String method="transferFund(String sendersId, String receiversId, int amount, String explanation)";
		logger.info(method + "called.."); 
		
		return wpsi.transferFund(sendersId, receiversId, amount, explanation);
	
		
	}
	
	@PutMapping("/addBalanceToWallet/{mobileNo}/{amount}")

	public String addBalanceToWallet(@PathVariable("mobileNo") String id, @PathVariable int amount)
	{
		String method="addBalanceToWallet(String id,int amount)";
		logger.info(method + "called.."); 	
		
		return wpsi.addBalanceToWallet(id, amount);
		
		
	}
	
	@GetMapping("/getTransaction/{mobileNo}")
	public List<Transaction> getTransaction(@PathVariable("mobileNo") String id)
	{
		String method="getTransaction(String id)";
		logger.info(method + "called.."); 	
				 
		return wpsi.getTransaction(id); 
	
		
	}
	
	@PutMapping("/BankDeposit/{id}/{amount}")
	public String addBalanceToBank(@PathVariable String id, @PathVariable int amount )
	{
		String method="addBalanceToBank(String id,int amount)";
		logger.info(method + "called.."); 	
		
		return wpsi.addBalanceToBank(id, amount);
		
	}

}
