package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		String sql = "SELECT NOME FROM COR";
		
		DriverManager.registerDriver(new org.h2.Driver());
		Connection conn = DriverManager.getConnection("jdbc:h2:~/color");
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString("NOME"));
		ps.close();
		conn.close();	
		System.out.println("Finalizando");	
	}

}
