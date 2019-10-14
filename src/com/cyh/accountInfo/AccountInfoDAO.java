package com.cyh.accountInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.cyh.util.DBConnector;

public class AccountInfoDAO {
	
	
	//내역조회 incomeSelect //자기계좌 입출금내역을 최신순으로 조회하는 메서드 

	public ArrayList<AccountInfoDTO> incomeSelect (String accountNumber) throws Exception{
		Connection con=null;
		PreparedStatement st= null;
		ResultSet rs=null;//select 문을 담는 것은 resultset
		ArrayList<AccountInfoDTO> ar = new ArrayList<AccountInfoDTO>();		
	
		con= DBConnector.getConnection();
		
		
		
		String sql="select * from accountInfo where accountNumber=?  "+
		"Order by date desc";
		
		st= con.prepareStatement(sql);//미리보내라
		
		st.setString(1,accountNumber );
		
		rs= st.executeQuery();//최종 결과물을 담음.
		
		while(rs.next()) {
			AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.setTradeNumber(rs.getLong("Trade Number"));
			accountInfoDTO.setAccountNumber(rs.getString("Account Number"));
			accountInfoDTO.setIncome(rs.getLong("Income"));
			accountInfoDTO.setAccountBalance(rs.getLong("Account Balance"));
			accountInfoDTO.setIncomeKind(rs.getInt("incomeKind"));
			accountInfoDTO.setTradeDate(rs.getDate("tradeDate"));

			ar.add(accountInfoDTO);
			
		}
		rs.close();
		st.close();
		con.close();
		return ar;
	}
	
	
	//입출금하는 메서드
	public int income(AccountInfoDTO accountInfoDTO) throws Exception {//int타입 리절트 리턴
		//준비단계 순서는외울것.
		int result=0;
		Connection con =null;
		PreparedStatement st =null;
		
		
		con = DBConnector.getConnection();
		String sql = "insert into accountInfo valuses(trade_seq.nextval,?,?,? ,?,sysdate)";
		
		//sysdate 오라클내에서 현재시간을 알아서넣어라.
		//인서트해라 accountinfo 테이블에 
		
		st = con.prepareStatement(sql);//미리보낸다.
		
		st.setString(1,accountInfoDTO.getAccountNumber());//계좌번호를 어디서 받아와야된다.
		st.setLong(2, accountInfoDTO.getIncome());
		st.setLong(3, accountInfoDTO.getAccountBalance());
		st.setInt(4, accountInfoDTO.getIncomeKind());
		
		return result;
		
	}

}
