package com.apiservices;

public class Transaction {
	private long transaction_id;
	private double amount;
	private String type;
	private long parent_id;
	
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", amount=" + amount + ", type=" + type
				+ ", parent_id=" + parent_id + "]";
	}
	
	
}
