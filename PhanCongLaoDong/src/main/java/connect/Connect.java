package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public Connect() {
		// TODO Auto-generated constructor stub
	}
	public Connection getConnect() {
		Connection con=null;
		try {
			String url="jdbc:sqlserver://localhost:1433;databaseName=PhanCongLaoDong";
			con=DriverManager.getConnection(url,"sa","sapassword");
		} catch (Exception e) {
			System.out.println("1111");
		}
		return con;
	}
		
}
