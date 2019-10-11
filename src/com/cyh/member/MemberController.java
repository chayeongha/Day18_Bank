package com.cyh.member;

import java.util.Scanner;

import com.cyh.bank.BanckMain;
import com.cyh.bankInput.MemberInput;
import com.cyh.bankView.BankView;

public class MemberController {

	private Scanner sc;//스캐너 멤버변수선언
	private MemberDAO memberDAO;
	private MemberInput memberInput;
	private BankView bankView;

	public  MemberController() {

		sc= new Scanner(System.in);
		memberDAO= new MemberDAO();
		memberInput = new MemberInput();
		bankView= new BankView();
	}

	//1.누르면 회원가입 //2.누르면 로그인

	public void start() {
		boolean check = true;

		while(check) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 종료");
			int select = sc.nextInt();
			//번호를 입력받으면
			
			MemberDTO memberDTO =null;


			switch (select) {//번호입력시 
			case 1:
				//번호가 1일때  멤버DAO 멤버조인 메서드 실행
				memberDTO =memberInput.memberJoin(sc);

				try {
					select = memberDAO.memberJoin(memberDTO);
				}

				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				    select =0;
				}

				String msg= "Member Join Fail";//이문구가 발생할려면 SELECT가 0보다작을때나와야된다.
				if(select >0) {

					msg = "Member join Success";
				}
				bankView.view(msg);

				break;
			case 2: 
				//멤버dao 멤버 로그인 메서드실행
				memberDTO=memberInput.memberJoin(sc);//멤버조인 메서드에서 객체를 만들어주어 널값이나올 가능성이없다
				try {
					memberDTO=memberDAO.memberLogin(memberDTO);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					memberDTO=null;
				}
				String msg2 = "Login Fail";
				if(memberDTO!= null) {
					msg2="Login Success";
					//계좌명을 입력하세요 accountname 추가
					//2번로그인이 실행됐을때 accountController의 메서드가 실행 
					
				}
				bankView.view(msg2);
				
				break;

			case 3:

				check=false;
				//check =! check
				break;


			}


		}

	}

}
