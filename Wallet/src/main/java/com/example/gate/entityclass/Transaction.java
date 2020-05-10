package com.example.gate.entityclass;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;*/
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*import org.hibernate.annotations.CascadeType;
*/

@Entity
public class Transaction {
	@Id
	private String transactionId;
	@Column(length = 10)
	private int transactionAmount;
	@Column(length = 30)
	private String explanation;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 20)
	private java.util.Date transactionDate;
	
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(String transactionId, int transactionAmount, String explanation, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.transactionAmount = transactionAmount;
		this.explanation = explanation;
		this.transactionDate = transactionDate;
	}
	
	/*
	 * public Wallet getWallet() { return wallet; } public void setWallet(Wallet
	 * wallet) { this.wallet = wallet; }
	 */
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", explanation=" + explanation + ", transactionDate=" + transactionDate + "]";
	}
	
	
	
	  @ManyToOne (cascade=javax.persistence.CascadeType.ALL)
	  
	  @JoinColumn(name="Transaction_of_wallet") private Wallet wallet;
	 
	 
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public java.util.Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
}
