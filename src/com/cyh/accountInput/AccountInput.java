package com.cyh.accountInput;

import java.util.Calendar;
import java.util.Scanner;

import com.cyh.account.AccountDTO;

public class AccountInput {
	//이것을 어카운트 컨트롤러에 보내서 화면으로 띄워야함.
	public AccountDTO accountCreate() {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);

		// 현재시간을 캘린더객체를 - 스트링타입으로 변환후 이것을
		//accountDTO에 넣어준뒤 
		// 반환시키자.
		AccountDTO accountDTO =new AccountDTO();

		Calendar calendar =Calendar.getInstance();//캘린더 클래스는 추상클래스이기때문에 객체를 못만들기때문에 
																									  //이방식으로 만듬.
	
		long l1 =calendar.getTimeInMillis();
		String cal =String.valueOf(l1);
		//accountDTO.setAccountNumber(String.valueOf(l1));//다른방법
		accountDTO.setAccountNumber(cal);
		//AccountDTO에 캘렌더값을 set시킴


		System.out.println("계좌명을 입력하시오");
		accountDTO.setAccountName(sc.next());
		System.out.println("잔액을 입력하시오");
		accountDTO.setAccountBalance(sc.nextInt());
		System.out.println("ID를 입력하시오");
		accountDTO.setId(sc.next());

		return accountDTO;
	}


}
