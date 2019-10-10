package com.cyh.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

import com.cyh.util.DBConnector;

public class AccountDAO {

	public void accountCreate(AccountDTO accountDTO) {

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
			String sql="insert into account values(? , ? ,?,?) ";
			st=con.prepareStatement(sql);
			//insert 일땐   executeUpdate -결과값이 int
			//select 일땐  executeQuery- 결과값이 MemberDTO

		
			
			st.setString(1, accountDTO.getAccountNumber());
			//계좌번호대신 날짜로 변형

			st.setString(2, accountDTO.getAccountName());
			st.setInt(3, accountDTO.getAccountBalance());
			st.setString(4, accountDTO.getId());

			result = st.executeUpdate();

			st.close();
			con.close();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}










	}
}
