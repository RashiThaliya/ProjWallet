package com.example.gate.testing;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.gate.controller.WalletController;
import com.example.gate.entityclass.Transaction;
import com.example.gate.entityclass.Wallet;
import com.example.gate.repo.TransactionRepository;
import com.example.gate.repo.WalletRepository;

@Transactional
@SpringBootTest
public class ControllerTests {

	private static Logger logger=LogManager.getRootLogger();
		
		@Autowired
		WalletController walletController;
		
		@Autowired
		private TransactionRepository transactionRepository;
		
		@Autowired
		WalletRepository walletRepository;

		
		@BeforeAll
		static void setUpBeforeClass() {
			logger = LogManager.getRootLogger();
			System.out.println("Fetching resources for testing ...");
		}
		
		@BeforeEach
		void setup() {
			logger.info("Test Case Started");
			
			Wallet wallet = new Wallet("8087090595","rt@gmail.com","555566664444","Rashi",1000,"1015", null);
			Transaction transaction = new Transaction();
			List<Transaction> newSet = new ArrayList<>();
			newSet.add(transaction);
			wallet.setTransaction(newSet);
			Wallet walletRepo = walletRepository.save(wallet);
			Transaction transRepo = transactionRepository.save(transaction);
//		System.out.println("Test Case Started");
		}

		@AfterEach
		void tearDown() {
			logger.info("Test Case Over");
			System.out.println("Test Case Over");
		}

		@Test
		public void TestingGetUser(){
			logger.info("Test case - Add User successful");
			String mobileNo = "8087090595";
			Wallet wallet = walletController.getUser(mobileNo);
			assertNotNull(wallet);
		}
		@Test
		public void TestingGetUser2(){
			logger.info("Test case - Get User unsuccessful");
			String mobileNo = "8087090595";
			Wallet wallet = walletController.getUser(mobileNo);
			assertEquals(null, wallet);
		}
		
		@Test
		public void TestingAddUser1(){
			logger.info("Test case - Add user successful");
			String mobile= "8087090595";
			Wallet wallet = walletController.getUser("8087090595");
			wallet.setMobileNo(mobile);
			Wallet check = walletController.addUser(wallet);
			assertEquals(true, check);
		}
	
		@Test
		public void TestingAddUser2(){
			logger.info("Test case - Add user unsuccessful");
			String mobile= "8087090595";
			Wallet wallet = walletController.getUser("8087090595");
			wallet.setMobileNo(mobile);
			Wallet check = walletController.addUser(wallet);
			assertEquals(null, check);
		}
	
		@Test
		public void TestingAddBalanceToWallet1(){
			logger.info("Test case - Add balance to wallet successful");
			String mobile= "8087090595";
			Wallet wallet = walletController.getUser(mobile);
			wallet.setWalletAmount(1000);
			Wallet check = walletController.addUser(wallet);
			assertEquals(true, check);
		}
	
		@Test
		public void TestingAddBalanceToWallet2(){
			logger.info("Test case - Add balance to wallet unsuccessful");
			String mobile = "8087090595";
			Wallet wallet = walletController.getUser(mobile);
			wallet.setWalletAmount(1000);
			Wallet check = walletController.addUser(wallet);
			assertEquals(null, check);
		}
	
		@Test
		public void TestingGetTransaction1(){
			logger.info("Test case - Get transaction successful");
			String mobileNo = "8087090595";
			List<Transaction> transaction = walletController.getTransaction(mobileNo);
			assertNotNull(transaction);
		}
	
		@Test
		public void TestingGetTransaction2(){
			logger.info("Test case - Get transaction unsuccessful");
			String mobileNo = "8087090595";
			List<Transaction> transaction = walletController.getTransaction(mobileNo);
			assertEquals(null,transaction);
		}
}
