package com.cyh.account;


import java.util.ArrayList;
import java.util.Scanner;

import com.cyh.accountInfo.AccountInfoController;
import com.cyh.bankView.AccountView;
import com.cyh.bankView.BankView;
import com.cyh.member.MemberDTO;

public class AccountController {

	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountInput accountInput;
	private AccountDTO accountDTO;
	private BankView bankView;
	private AccountView accountView;
	private AccountInfoController accountInfoController;

	public AccountController() {
		sc= new Scanner(System.in);
		accountDAO = new AccountDAO();
		bankView = new BankView();
		accountInput =new AccountInput();
		accountView = new AccountView();
		accountDTO =  new AccountDTO();
		accountInfoController = new AccountInfoController();
		
	}


	public void start( MemberDTO memberDTO) {

		boolean check =true;

		int select=0;

		while(check) {

			System.out.println("1. 계좌 개설");
			System.out.println("2. 계좌 조회");
			System.out.println("3. 은행 업무");//입금할거냐 출금할거냐 입출금내역을 조회할것이냐 
			System.out.println("4. 종료");
			
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
			
				try {
					ArrayList<AccountDTO> ar = accountDAO.accountSelect(memberDTO.getId());
					accountView.view(ar);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;

			case 3://계좌를 선택해서 조회
				ArrayList<AccountDTO> ar=null;
				try {
					for(int i=0;i<ar.size();i++) {
						
						System.out.println(i+1+"."+ar.get(i).getAccountNumber());//i번째 계좌정보가 쭉 출력
						
					}
					select = sc.nextInt();//입력하면 i번째 계좌번호가 선택
					
					accountInfoController.start(ar.get(select-1).getAccountNumber());
					ar = accountDAO.accountSelect(memberDTO.getId());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				break;
			default:
				check=false;//!check;

				break;
			}
		}


	}


}
