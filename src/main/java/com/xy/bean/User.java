package com.xy.bean;

public class User {

	private String account;
	private String password;
	private boolean remme;
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
	public boolean isRemme() {
		return remme;
	}
	public void setRemme(boolean remme) {
		this.remme = remme;
	}
	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", remme=" + remme + "]";
	}
	
	
}
