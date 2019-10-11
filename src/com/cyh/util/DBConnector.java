package com.cyh.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector  {
	
	//메서드명 getConnection
	public static Connection getConnection() throws Exception{
	//void를 --> static으로 변경후 con값을 리턴하기위해 Connection 입력	
		
		
	//준비단계	
		String user="user01";
		String password="user01";
		String url="jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
		//"oracle.jdbc.driver.OracleDriver";
	Connection con =null;//Connection 선언
	
	Class.forName(driver);//exception발생--throws Exception
	con=DriverManager.getConnection(url,user,password);
	
	return con; //con값을 반환
	}
}
