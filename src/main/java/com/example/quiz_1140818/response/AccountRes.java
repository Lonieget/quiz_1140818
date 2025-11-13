package com.example.quiz_1140818.response;

public class AccountRes extends BasicRes{
	
	private String account;
	
	private String password;

	public AccountRes() {
		super();
	}

	public AccountRes(int code, String message) {
		super(code, message);
	}

	public AccountRes(int code, String message, String account, String password) {
		super(code, message);
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
