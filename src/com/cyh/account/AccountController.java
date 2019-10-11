package com.cyh.account;


import java.util.Scanner;

import com.cyh.bankView.BankView;
import com.cyh.member.MemberDTO;

public class AccountController {

	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountInput accountInput;
	private AccountDTO accountDTO;
	private BankView bankView;


	public AccountController() {
		sc= new Scanner(System.in);
		accountDAO = new AccountDAO();
		bankView = new BankView();
		accountInput =new AccountInput();

	}


	public void start( MemberDTO memberDTO) {

		boolean check =true;

		int select=0;

		while(check) {

			System.out.println("1. 계좌 개설");
			System.out.println("2. 계좌 조회");
			System.out.println("3. 종료");
			select = sc.nextInt();

			switch(select){

			case 1:
				accountDTO= accountInput.accountCreate();
				accountDTO.setId(memberDTO.getId());

				try {
					select = accountDAO.accountCreate(accountDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					select=0;
				}
				String str = "Create Fail";
				if(select>0) {
					str = "Create Success";
				}
				bankView.view(str);
				break;

			case 2:


				break;

			default:
				check=false;//!check;

				break;
			}
		}


	}


}
