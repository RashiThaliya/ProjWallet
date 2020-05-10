package com.example.gate.entityclass;

import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Wallet {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(length = 15, unique = true)
	private String mobileNo;

	@Column(length = 30, unique = true)
	private String emailId;
	
	@Column(length = 12, unique = true)
	private String aadharNo;
	@Column(length = 40)
	private String custName;
	@Column(length = 15)
	private float walletAmount;
	@Column(length = 4)
	private String walletPin;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToMany(targetEntity = Transaction.class)
	private List<Transaction> transaction;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public float getWalletAmount() {
		return walletAmount;
	}

	public void setWalletAmount(float walletAmount) {
		this.walletAmount = walletAmount;
	}

	public String getWalletPin() {
		return walletPin;
	}

	public void setWalletPin(String walletPin) {
		this.walletPin = walletPin;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "Wallet [mobileNo=" + mobileNo + ", emailId=" + emailId + ", aadharNo=" + aadharNo + ", custName="
				+ custName + ", walletAmount=" + walletAmount + ", walletPin=" + walletPin + ", transaction="
				+ transaction + "]";
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet(String mobileNo, String emailId, String aadharNo, String custName, float walletAmount,
			String walletPin, List<Transaction> transaction) {
		super();
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.aadharNo = aadharNo;
		this.custName = custName;
		this.walletAmount = walletAmount;
		this.walletPin = walletPin;
		this.transaction = transaction;
	}
	
	
	
}
