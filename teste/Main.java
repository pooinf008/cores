package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifba.inf008.color.persistencia.SQLColor;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		String sql = "SELECT NOME FROM COR";
		
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
		Connection conn = DriverManager.getConnection(SQLColor.URI, SQLColor.USER, SQLColor.PWD);
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
			System.out.println(rs.getString("NOME"));
		ps.close();
		conn.close();	
		System.out.println("Finalizando");	
	}

}
