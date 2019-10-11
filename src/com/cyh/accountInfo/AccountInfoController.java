package com.cyh.accountInfo;

import java.util.ArrayList;
import java.util.Scanner;

import com.cyh.account.AccountDAO;
import com.cyh.bankView.AccountInfoView;
import com.cyh.bankView.BankView;

public class AccountInfoController {

	private Scanner sc;
	private AccountInfoDTO accountInfoDTO;
	private AccountInfoDAO accountInfoDAO;
	private AccountInfoInput accountInfoInput;
	private AccountInfoView accountInfoView;
	private AccountDAO accountDAO;
	private BankView bankView;

	public  AccountInfoController() {
		sc= new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInfoDTO =  new AccountInfoDTO();
		accountInfoView = new AccountInfoView();
		accountInfoInput = new AccountInfoInput();
		accountDAO = new AccountDAO();
		bankView = new BankView();
	}

	public void start(String accountNumber) throws Exception{
		//계좌번호를매개변수를 받아주자 start 안에 
		boolean check=true;


		while(check) {

			System.out.println("1. 입출금내역 조회");//
			System.out.println("2. 입금"); //입금할금액을 받는다  //dao에서 잔액을 가져와서 잔액을 확인후
			System.out.println("3. 출금");//출금할금액을 받는다.
			System.out.println("4. 종료");
			int select=0;

			select= sc.nextInt();

			switch (select) {
			case 1:
				ArrayList<AccountInfoDTO> ar= accountInfoDAO.incomeSelect(accountNumber);
				accountInfoView.view(ar);
				break;

			case 2://입금
				long income = accountInfoInput.incomeInput(sc);
				long balance = accountDAO.getAccountBalance(accountNumber);
			
				AccountInfoDTO accountInfoDTO  = new AccountInfoDTO();
				accountInfoDTO.setIncomeKind(1);//입금할떈 숫자 1
				accountInfoDTO.setAccountNumber(accountNumber);
				accountInfoDTO.setIncome(income);
				accountInfoDTO.setAccountBalance(balance+income);//현재잔액에다 입금한금액을넣어야함
				select = accountInfoDAO.income(accountInfoDTO);//
				if(select >0){
					select= accountInfoDTO.updateBalance(accountInfoDTO);
				}
			
			
				break;
				
			case 3://출금
				
				long income = accountInfoInput.incomeInput(sc);
				long balance = accountDAO.getAccountBalance(accountNumber);
				AccountInfoDTO accountInfoDTO  = new AccountInfoDTO();
				accountInfoDTO.setIncomeKind(0);//입금할떈 숫자 1
				accountInfoDTO.setAccountNumber(accountNumber);
				accountInfoDTO.setIncome(income);
				accountInfoDTO.setAccountBalance(balance-income);//현재잔액에다 입금한금액을넣어야함
				select = accountInfoDAO.income(accountInfoDTO);//
				if(select >0){
					select= accountInfoDTO.updateBalance(accountInfoDTO);
				}
			
				
				break;

			default:
				break;
			}

		}

	}
}
