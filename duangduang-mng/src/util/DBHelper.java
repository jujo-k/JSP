package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
   
	private static final String driver = "com.mysql.jdbc.Driver"; //���ݿ�����
	//�������ݿ��URL��ַ
	private static final String url="jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF-8&useSSL=true"; 
	private static final String username="root";//���ݿ���û���
	private static final String password="123456";//���ݿ������
    
	private static Connection conn=null;
	
	//��̬����鸺���������
	static 
	{
		try
		{
			Class.forName(driver);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws Exception
	{
		if(conn==null)
		{
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}
	

}
