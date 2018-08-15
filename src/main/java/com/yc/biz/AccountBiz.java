package com.yc.biz;

import com.yc.bean.Account;

public interface AccountBiz {
	// 存
	public void deposite(int accountid, double money);
	//取
	public void withdraw(int accountid, double money);
	//转
	public void transfer(int inaccountid, int outaccountid,double money);
	//查
	public Account findAccount(int accountid);
	
	//开户
	public Account openAccount(double money);
}
