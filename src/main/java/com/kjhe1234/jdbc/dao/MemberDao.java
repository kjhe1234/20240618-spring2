package com.kjhe1234.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kjhe1234.jdbc.dto.MemberDto;

public class MemberDao {
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/spring_projectdb";
	String username = "root";
	String password = "12345";
	
	//회원가입, 회원탈퇴, 회원리스트조회, 회원검색, 회원정보수정
	//1. 회원가입
	public int joinMember(String mid, String mpw, String mname, String memail) {  //회원 가입 메소드
		
		String sql = "INSERT INTO members(mid,mpw,mname,memail) VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int success = 0;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			pstmt.setString(3, mname);
			pstmt.setString(4, memail);
			
			success = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return success;

}



		
		
		//2. 회원탈퇴
		public int deleteMember(String mid) {  
			
			String sql = "DELETE FROM members WHERE mid = ?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			int success = 0;
			
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, username, password);
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mid);

				success = pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			return success;
		
	}
	


	
	
	
	
}
