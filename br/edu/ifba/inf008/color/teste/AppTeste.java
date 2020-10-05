package br.edu.ifba.inf008.color.teste;

import java.sql.SQLException;

import br.edu.ifba.inf008.color.logica.CorCMYK;
import br.edu.ifba.inf008.color.logica.CorRGB;
import br.edu.ifba.inf008.color.logica.Pintor;
import br.edu.ifba.inf008.color.logica.dto.CorDTO;

public class AppTeste {
	
	private Pintor pintor;
	
	public AppTeste() throws SQLException {
		this.pintor = new Pintor();
	}
	
	public void run() throws Exception {
		this.asm();
//		CorDTO corDTO = this.pintor.getValor("#4d8c07", 5);
//		System.out.println(corDTO.getNomeCor());
		
	}

	private void asm() throws Exception {
//		this.pintor.addCorRGB("WHITE", "Branco PURO", 100, 10, 255, 255, 255);
//		this.pintor.addCorRGB("RED", "Vermelho PURO", 100, 10, 255, 0, 0);
//		this.pintor.addCorRGB("GREEN", "Verde PURO", 100, 10, 0, 255, 0);
		this.pintor.addCorRGB("ROXO", "ROXO PURO", 100, 10, 0, 0, 255);
//		this.pintor.addCorCMYK("CYAN", "Ciano PURO", 100, 10, 100, 0, 0, 0);
//		this.pintor.addCorCMYK("MAGENTA", "Verde PURO", 100, 10, 0, 100, 0, 0);
//		this.pintor.addCorCMYK("YELLOW", "AMARELO PURO", 100, 10, 0, 0, 100, 0);
//		this.pintor.addCorCMYK("BLACK", "PRETO", 100, 10, 0, 0, 0, 100);		
	}
	
	
	public static void main(String[] args) throws Exception {
		(new AppTeste()).run();
		System.out.println("Finalizando...");
	}
	

}
