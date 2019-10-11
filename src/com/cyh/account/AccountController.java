package com.cyh.account;

import java.util.ArrayList;
import java.util.Scanner;

import com.cyh.accountInput.AccountInput;
import com.cyh.bankView.BankView;
import com.cyh.member.MemberDTO;

public class AccountController {
	
	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountDTO accountDTO;
	private AccountInput accountInput;
	private BankView bankView;
	
	
	public AccountController() {
		sc= new Scanner(System.in);
		accountDAO = new AccountDAO();
		bankView = new BankView();
		accountInput =new AccountInput();
		accountDTO = new AccountDTO();
	}
	
	
	public void start( MemberDTO memberDTO) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean check =true;
		
		int select=0;
		
		while(check) {
			
			System.out.println("1. 계좌 개설");
			System.out.println("2. 종료");
			
			switch(select){
				
			case 1:
				accountDTO= accountInput.accountCreate();
				accountDTO.setId(memberDTO.getId());
				select=accountDAO.accountCreate(accountDTO);
						
				
				//catch 문에  select=0;이라써준다.
				
				String str= "Create Fail";
				if(select >0) {			
				}
						
				break;
				
				
			default:
				check=false;//!check;
				
				break;
			}
		}
		
		
	}
		
	
}
