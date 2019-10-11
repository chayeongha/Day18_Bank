package com.cyh.bankView;

import java.util.ArrayList;

import com.cyh.accountInfo.AccountInfoDTO;

public class AccountInfoView {
	
	public void view(ArrayList<AccountInfoDTO>ar) {
		System.out.println("TradeNumber\t\tIncome\tAccountBalance\tIncomeKind\tTradeDate");
		for(AccountInfoDTO accountInfoDTO:ar) {
			System.out.print(accountInfoDTO.getTradeNumber());
			System.out.print(accountInfoDTO.getIncome());
			System.out.print(accountInfoDTO.getAccountBalance());
			System.out.print(accountInfoDTO.getIncomeKind());
			System.out.println(accountInfoDTO.getTradeDate());
		}
	}
}
