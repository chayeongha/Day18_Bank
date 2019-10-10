package com.cyh.account;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cyh.util.DBConnector;

public class AccountDAO {

	public void accountCreate(AccountDTO accountDTO) {

		Connection con=null;
		PreparedStatement  st=null;
		int result =0;


		con= DBConnector.getConnection();
		String sql="insert into account values(? , ? ,?,?) ";
		st=con.prepareStatement(sql);

		//계좌번호대신 날짜입력.
		st.setString(1, accountDTO.getAccountNumber());










	}
}
