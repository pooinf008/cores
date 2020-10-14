package br.edu.ifba.inf008.color.persistencia;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf008.color.exception.CorNaoEncontradaException;
import br.edu.ifba.inf008.color.logica.Cor;
import br.edu.ifba.inf008.color.logica.CorCMYK;
import br.edu.ifba.inf008.color.logica.CorRGB;

public class SQLColor implements ColorDAO{
	private static final int COR_RGB = 0;
	private static final int COR_CMYK = 1;	
	
	public static final String URI = "jdbc:hsqldb:http://localhost";
	public static final String USER = "SA";
	public static final String PWD = "";
	public static final String DRIVE = "org.hsqldb.jdbc.JDBCDriver";

	private static String SAVE = "INSERT INTO COR(ID, NOME, ESTOQUE, PRECO, RED,\r\n" + 
	                                 " GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
	                                 " KEY, TIPO_COR)\r\n" + 
	                                 " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static String RECOVERY_BY_ID = "SELECT ID, NOME, ESTOQUE, PRECO, RED,\r\n" + 
            					     	   " GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
            					     	   " KEY, TIPO_COR \r\n" + 
            					     	   " FROM COR \r\n" +
            					     	   " WHERE ID = ? \r\n";	

	private static String RECOVERY_BY_QTDE = "SELECT ID, NOME, ESTOQUE, PRECO, RED,\r\n" + 
	     	   " GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
	     	   " KEY, TIPO_COR \r\n" + 
	     	   " FROM COR \r\n" +
	     	   " WHERE ESTOQUE >= ? \r\n";	
	
	private static String UPDATE = "UPDATE COR \r\n" +
			" SET NOME = ?, ESTOQUE = ?, PRECO = ?, \r\n" + 
            " RED = ?, GREEN = ?, BLUE = ?, \r\n" +
			" CYAN = ?, MAGENTA = ?, YELLOW = ?, KEY = ?\r\n" +
            " WHERE ID = ? \r\n";

	
	public SQLColor() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DriverManager.registerDriver((Driver) Class.forName(SQLColor.DRIVE).newInstance());
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(SQLColor.URI, SQLColor.USER, SQLColor.PWD);
		return conn;
	}
	
	
	@Override
	public void salvar(Cor cor) throws Exception {
		if(cor instanceof CorRGB) {
		  this.saveRGB((CorRGB)cor);	
		}else if(cor instanceof CorCMYK) {
		  this.saveCMYK((CorCMYK)cor);	
		}
	}
	
	private void saveCMYK(CorCMYK cor) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.SAVE);
		ps.setString(1, cor.getId());
		ps.setString(2, cor.getNome());
		ps.setDouble(3, cor.getEstoque());
		ps.setDouble(4, cor.getPreco());
		ps.setInt(5, 0);
		ps.setInt(6, 0);
		ps.setInt(7, 0);
		ps.setInt(8, cor.getCyan());
		ps.setInt(9, cor.getMagenta());
		ps.setInt(10, cor.getYellow());
		ps.setInt(11, cor.getKey());
		ps.setInt(12, SQLColor.COR_CMYK);
		ps.executeUpdate();
	}
	
	private void saveRGB(CorRGB cor) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.SAVE);
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
		List<Cor> cores = new ArrayList<Cor>();
		Cor cor = null;
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.RECOVERY_BY_QTDE);
		ps.setDouble(1, qtde);
		ResultSet rSet = ps.executeQuery();
		while(rSet.next()) {
			cor = null;
			int tipo = rSet.getInt("TIPO_COR");
			if(tipo == SQLColor.COR_CMYK)
			  cor = new CorCMYK(rSet.getString("ID"),
					  			rSet.getString("NOME"),
					  			rSet.getDouble("ESTOQUE"),
					  			rSet.getDouble("PRECO"),
					  			rSet.getInt("CYAN"),
					  			rSet.getInt("MAGENTA"),
					  			rSet.getInt("YELLOW"),
					  			rSet.getInt("KEY"));
			else if(tipo == SQLColor.COR_RGB)
				  cor = new CorRGB(rSet.getString("ID"),
				  			rSet.getString("NOME"),
				  			rSet.getDouble("ESTOQUE"),
				  			rSet.getDouble("PRECO"),
				  			rSet.getInt("RED"),
				  			rSet.getInt("GREEN"),
				  			rSet.getInt("BLUE"));
			cores.add(cor);
		}
		return cores;
	}

	@Override
	public Cor buscar(String codCor) throws Exception {
		Cor cor = null;
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.RECOVERY_BY_ID);
		ps.setString(1, codCor);
		ResultSet rSet = ps.executeQuery();
		if(!rSet.next())
			throw new CorNaoEncontradaException();
		int tipo = rSet.getInt("TIPO_COR");
		if(tipo == SQLColor.COR_CMYK)
		  cor = new CorCMYK(rSet.getString("ID"),
				  			rSet.getString("NOME"),
				  			rSet.getDouble("ESTOQUE"),
				  			rSet.getDouble("PRECO"),
				  			rSet.getInt("CYAN"),
				  			rSet.getInt("MAGENTA"),
				  			rSet.getInt("YELLOW"),
				  			rSet.getInt("KEY"));
		else if(tipo == SQLColor.COR_RGB)
			  cor = new CorRGB(rSet.getString("ID"),
			  			rSet.getString("NOME"),
			  			rSet.getDouble("ESTOQUE"),
			  			rSet.getDouble("PRECO"),
			  			rSet.getInt("RED"),
			  			rSet.getInt("GREEN"),
			  			rSet.getInt("BLUE"));
		return cor;
			
	}
	


	@Override
	public void atualizar(Cor cor) throws Exception {
		if(cor instanceof CorRGB) {
			  this.updateRGB((CorRGB)cor);	
		}else if(cor instanceof CorCMYK) {
			  this.updateCMYK((CorCMYK)cor);	
		}
	}

	private void updateRGB(CorRGB cor) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.UPDATE);
		ps.setString(1, cor.getNome());
		ps.setDouble(2, cor.getEstoque());
		ps.setDouble(3, cor.getPreco());
		ps.setInt(4, cor.getRed());
		ps.setInt(5, cor.getGreen());
		ps.setInt(6, cor.getBlue());
		ps.setInt(7, 0);
		ps.setInt(8, 0);
		ps.setInt(9, 0);
		ps.setInt(10, 0);
		ps.setString(11, cor.getId());
		ps.executeUpdate();
	}
	
	private void updateCMYK(CorCMYK cor) throws SQLException {
		PreparedStatement ps = this.getConnection().prepareStatement(SQLColor.UPDATE);
		ps.setString(1, cor.getNome());
		ps.setDouble(2, cor.getEstoque());
		ps.setDouble(3, cor.getPreco());
		ps.setInt(4, 0);
		ps.setInt(5, 0);
		ps.setInt(6, 0);
		ps.setInt(7, cor.getCyan());
		ps.setInt(8, cor.getMagenta());
		ps.setInt(9, cor.getYellow());
		ps.setInt(10, cor.getKey());
		ps.setString(11, cor.getId());
		ps.executeUpdate();
	}	
	
	
	public void salveOuAtualize(Cor cor) throws Exception {
		try {
			this.buscar(cor.getId());
			this.atualizar(cor);
		} catch (CorNaoEncontradaException e) {
			this.salvar(cor);
		}
	}
	
	

}
