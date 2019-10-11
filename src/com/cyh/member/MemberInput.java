package com.cyh.member;

import java.util.Scanner;

public class MemberInput {
	//로그인 입력
	
	public MemberDTO memberLogin(Scanner sc) {
		
		MemberDTO memberDTO =  new  MemberDTO();
		System.out.println("ID를 입력");
		memberDTO.setId(sc.next());
		System.out.println("PW를 입력");
		memberDTO.setPw(sc.next());
		
		return memberDTO;
		
	}
	
	//멤버에관련된 인풋

	//스캐너를 선언하거나 뱅크메인에있는 스캐너를 받아온다.

	// 회원가입
	public MemberDTO memberJoin(Scanner sc) {
		MemberDTO memberDTO = new MemberDTO();
		System.out.println("ID를 입력하세요");
		memberDTO.setId(sc.next());	
		System.out.println("PW를 입력하세요");
		memberDTO.setPw(sc.next());
		System.out.println("이름을 입력하세요");
		memberDTO.setName(sc.next());
		System.out.println("전화번호를 입력하세요");
		memberDTO.setPhone(sc.next());
		System.out.println("이메일을 입력하세요");
		memberDTO.setEmail(sc.next());
		// 누구간호출하면 호출한쪽으로 보내준다

		return memberDTO;
	}
	
	
	

}
