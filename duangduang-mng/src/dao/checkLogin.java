package dao;

import java.sql.ResultSet;

import com.mysql.jdbc.*;

import entity.My_GoodsAdminuser;
import entity.My_Users;
import util.DBHelper;

public class checkLogin {
	
	public boolean checkUsers(My_Users u) {
		DBHelper db = new DBHelper();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String username = u.getUserName();
		String password = u.getPassWord();
		sql = "select * from My_Users where username = ?";

		try {
			conn = (Connection) DBHelper.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					String psw = rs.getString(3);
				System.out.println(psw);
				if(psw.equals(password)) {
					return true;
				}
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
	public boolean checkAdmin(My_GoodsAdminuser u) {
		DBHelper db = new DBHelper();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		String username = u.getAdminUser();
		String password = u.getAdminPass();
		sql = "select * from My_GoodsAdminuser where AdminUser = ?";

		try {
			conn = (Connection) DBHelper.getConnection();
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			while(rs.next()) {
					String psw = rs.getString(3);
				System.out.println(psw);
				if(psw.equals(password)) {
					return true;
				}
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	
}
