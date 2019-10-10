package com.cyh.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cyh.util.DBConnector;

public class MemberDAO {

	//회원가입 메서드 memberJoin
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		//리턴값이 int

		Connection con=null;
		PreparedStatement st =null;//쿼리문미리보내줌.
		int result=0; //결과값이 인서트이기때문에 int값

		con=DBConnector.getConnection();
		String sql="insert into member values(?,?,?,?.?)";
		st = con.prepareStatement(sql);

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;

	}
	// 로그인 메서드 memberLogin
	public MemberDTO memberLogin(MemberDTO memberDTO)throws Exception {
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;// select문을 사용

		con= DBConnector.getConnection();
		String sql="select * from member where id=? and pw=?";

		st= con.prepareStatement(sql); //미리보내곰

		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());

		rs= st.executeQuery();//select문은 executeQery로

		if(rs.next()) {
			memberDTO.setName(rs.getString("name"));
			memberDTO.setPhone(rs.getString("phone"));
			memberDTO.setEmail(rs.getString("email"));

		}else {
			memberDTO=null;
		}
		rs.close();
		st.close();
		con.close();
		return memberDTO;
	}

}
