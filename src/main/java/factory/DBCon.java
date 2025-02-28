package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCon {
	static Connection con;
	public static Connection getCon() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbb7_todo","root","");
		return con;
	}

}
