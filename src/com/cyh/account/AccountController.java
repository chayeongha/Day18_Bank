package com.cyh.account;

import java.util.ArrayList;
import java.util.Scanner;

import com.cyh.accountInput.AccountInput;
import com.cyh.bankView.BankView;
import com.cyh.member.MemberDTO;

public class AccountController {
	
	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountInput accountInput;
	private BankView bankView;
	private AccountController accountController;
	
	public AccountController() {
		sc= new Scanner(System.in);
		accountDAO = new AccountDAO();
		bankView = new BankView();
		accountInput =new AccountInput();
		accountController =new AccountController();
	}
	
	
	public void start( MemberDTO memberDTO) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean check =true;
		
		int select=0;
		
		while(check) {
			
			System.out.println("1. 계좌 개설");
			System.out.println("2. 종료");
			select = sc.nextInt();
			switch(select){
				
			case 1:
				accountDTO= accountInput.accountCreate();
				accountDTO.setId(memberDTO.getId());
				select=accountDAO.accountCreate(accountDTO);
						
				
				//catch 문에  select=0;이라써준다.
				
				String str= "Create Fail";
				if(select >0) {			
					str="Create Success";
					accountController.start(memberDTO);
				}
						
			bankView.view(str);	
				break;
				
				
			default:
				check=false;//!check;
				
				break;
			}
		}
		
		
	}
		
	
}
