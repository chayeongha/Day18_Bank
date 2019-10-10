package com.cyh.bank;

import java.sql.Connection;

import com.cyh.member.MemberController;
import com.cyh.member.MemberDAO;
import com.cyh.member.MemberDTO;
import com.cyh.util.DBConnector;

public class BanckMain {

	public static void main(String[] args) {

	MemberController memberController = new MemberController();
	memberController.start();
		
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
