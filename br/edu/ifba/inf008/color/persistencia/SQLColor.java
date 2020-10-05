package br.edu.ifba.inf008.color.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.edu.ifba.inf008.color.logica.Cor;
import br.edu.ifba.inf008.color.logica.CorRGB;

public class SQLColor implements ColorDAO{
	private static final int COR_RGB = 0;
	
	private static String URI = "jdbc:h2:~/color";

	private static String SAVE_SQL = "INSERT INTO COR(ID, NOME, ESTOQUE, PRECO, RED,\r\n" + 
	                                 " GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
	                                 " KEY, TIPO_COR)\r\n" + 
	                                 " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	
	public SQLColor() throws SQLException {
		DriverManager.registerDriver(new org.h2.Driver());
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URI);
		return conn;
	}
	
	
	@Override
	public void salvar(Cor cor) throws Exception {
		if(cor instanceof CorRGB) {
		  this.salvarRGB((CorRGB)cor);	
		}
	}
	
	private void salvarRGB(CorRGB cor) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SAVE_SQL);
		ps.setString(1, cor.getId());
		ps.setString(2, cor.getNome());
		ps.setDouble(3, cor.getEstoque());
		ps.setDouble(4, cor.getPreco());
		ps.setInt(5, cor.getRed());
		ps.setInt(6, cor.getGreen());
		ps.setInt(7, cor.getBlue());
		ps.setInt(8, 0);
		ps.setInt(9, 0);
		ps.setInt(10, 0);
		ps.setInt(11, 0);
		ps.setInt(12, SQLColor.COR_RGB);
		ps.executeUpdate();
	}

	@Override
	public List<Cor> buscarCorQtdeMinima(double qtde) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cor buscar(String codCor) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Cor cor) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
