package com.cyh.bank;

import java.sql.Connection;

import com.cyh.account.AccountController;
import com.cyh.accountInfo.AccountInfoDAO;
import com.cyh.accountInfo.AccountInfoDTO;
import com.cyh.member.MemberController;
import com.cyh.member.MemberDAO;
import com.cyh.member.MemberDTO;
import com.cyh.util.DBConnector;

public class BanckMain {

	public static void main(String[] args) throws Exception{

	MemberController memberController = new MemberController();
	memberController.start();
	
		//AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
		//AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
		//accountInfoDTO.setIncome(200);
		//accountInfoDTO.setAccountBalance(200);
		//accountInfoDTO.setIncomeKind(1);
		//accountInfoDTO.setAccountNumber();//계좌번호 생성해서 가로안에넣어주면됨.
		
		//int result = accountInfoDAO .income(accountInfoDTO);
		//System.out.println(result); 
		
		
		
	//AccountController accountController = new AccountController();
	//accountController.start();
	
	//MemberDAO memberDAO = new MemberDAO();
		//MemberDTO memberDTO = new MemberDTO();
		//memberDTO.setId("iu");
		//memberDTO.setPw("iu");
		
		//try {
		//	memberDAO.memberJoin(memberDTO);
		//} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		
	}

}
