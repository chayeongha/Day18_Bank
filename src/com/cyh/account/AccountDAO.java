package com.cyh.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import com.cyh.util.DBConnector;

public class AccountDAO {

	public int accountCreate(AccountDTO accountDTO) {
		// 리턴은 인트타입 
		//준비단계
		Connection con=null;
		PreparedStatement  st=null;
		int result =0;

		//계좌번호
		//계좌명
		//잔액
		//처음 로그인할때 id

		try {
			con= DBConnector.getConnection();
			String sql="insert into account values(? , ? ,0,?) ";//받아온데이터를 집어넣음.//상황에따라 잔액이 달라질수있음
			
			st=con.prepareStatement(sql);
			//insert 일땐   executeUpdate -결과값이 int
			//select 일땐  executeQuery- 결과값이 MemberDTO


			st.setString(1, accountDTO.getAccountNumber());
			//계좌번호대신 날짜로 변형

			st.setString(2, accountDTO.getAccountName());
			//st.setLong(3, accountDTO.getAccountBalance());-0을 집어넣어줘서 만들필요가없음.
			st.setString(3, accountDTO.getId());

			result = st.executeUpdate();


			st.close();
			con.close();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;


	}
}
