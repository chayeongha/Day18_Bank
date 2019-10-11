package com.cyh.accountInfo;

import java.util.Scanner;

public class AccountInfoInput {
	
	
	
	
	
	public long incomeInput(Scanner sc) {
		System.out.println("금액을 입력");
		long income = sc.nextLong();
		return income;
	}
	
	
	
	
	
	
	
	//계좌입출금내역 조회 메서드
	public AccountInfoDTO incomeSelect( ) {
		Scanner sc = new Scanner(System.in);
		
		
		//정보를 입력받아 값에 맞는 정보를 출력
		AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
		
		System.out.println("계좌번호를 입력하시오");
		accountInfoDTO.setAccountNumber(sc.next());
		
		return accountInfoDTO;
	}

}
