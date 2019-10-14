package com.cyh.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

import com.cyh.accountInfo.AccountInfoDTO;
import com.cyh.member.MemberDTO;
import com.cyh.util.DBConnector;

public class AccountDAO {
  
	//update Balance -잔액을 
	public int updateBalance()throws Exception{
		Connection con=null;
		PreparedStatement st=null;
		int result=0;
		
		con= DBConnector.getConnection();
		
		String sql="update account set accountBalance =?where account=?";
		
		st= con.prepareStatement(sql);
		
		st= setLong(1,AccountInfoDTO.getAccountNumber());
		st= setString(2,accountInfoDTO);
		
				
				return result;
		
	}
	
	//accountBalance-계좌번호를 입력해서 계좌정보를 조회
	public long getAccountBalance() throws Exception{
		Connection con = DBConnector.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		long balance=0;
		
		con = DBConnector.getConnection();
		
		String sql = " select accountBalance from account where accountNumber=?";
		
				st= con.prepareStatement(sql);
				
				rs= st.executeQuery();
				
				if(rs.next()) {
					balance =rs.getLong("accountBalance");
				}
				
				rs.close();
				st.close();
				con.close();
				
		return balance;
	}
	

	
	
	//accountSelect 조회 메서드 실행
	public ArrayList<AccountDTO>  accountSelect(String id)throws Exception{
		
		Connection con= null;
		PreparedStatement st=null;
		ResultSet rs=null;
		ArrayList<AccountDTO>ar =new ArrayList<AccountDTO>();
		
		
		
			con=DBConnector.getConnection();
			// id를 입력해서 정보를 조회
			
			String sql = "select *from account  where id=?";
			st= con.prepareStatement(sql);
			// 입력받은값을 set?
			st.setString(1,id);
			
			rs= st.executeQuery();
			
			//id가 여러개이므로 와일문진행
			while(rs.next()) {
					AccountDTO  accountDTO = new AccountDTO();
					accountDTO.setAccountNumber(rs.getString("accountNumber"));
					accountDTO.setAccountName(rs.getString("accountName"));
					accountDTO.setAccountBalance(rs.getLong("accountBalance"));
					ar.add(accountDTO);
				
					
			}
			rs.close();	
			st.close();
			con.close();
			return ar;
			
		
	}
	

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
