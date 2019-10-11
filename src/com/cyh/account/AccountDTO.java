package com.cyh.account;

import java.util.Calendar;

public class AccountDTO {
	
	private String accountNumber;//계좌번호
	private String accountName;//계좌명
	private long accountBalance;//잔액
	private String id;//처음 로그인할때 id
 

	public String getAccountNumber() {//가져오는것/
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {//집어넣는것
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long l) {
		this.accountBalance = l;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
