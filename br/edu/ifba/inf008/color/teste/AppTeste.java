package br.edu.ifba.inf008.color.teste;

import java.sql.SQLException;

import br.edu.ifba.inf008.color.logica.CorCMYK;
import br.edu.ifba.inf008.color.logica.CorRGB;
import br.edu.ifba.inf008.color.logica.AppPintor;
import br.edu.ifba.inf008.color.logica.dto.CorDTO;
import br.edu.ifba.inf008.color.ui.JVendaUI;

public class AppTeste {
	
	private AppPintor pintor;
	
	public AppTeste(boolean mem) throws Exception {
		this.pintor = new AppPintor(mem);
	}
	
	public void run() throws Exception {
		double qtde = 20;
//		this.asm();
		CorDTO corDTO = this.pintor.getValor("#4d8c07", qtde);
		System.out.println(corDTO.getNomeCor());
		System.out.println(corDTO.getValor());
		this.pintor.vender(corDTO.getIdCor(), qtde);
		
	}

	private void asm() throws Exception {
		this.pintor.addCorRGB("WHITE", "BRANCO PURO", 100, 10, 255, 255, 255);
		this.pintor.addCorRGB("RED", "VERMELHO PURO", 100, 10, 255, 0, 0);
		this.pintor.addCorRGB("GREEN", "VERDE PURO", 100, 10, 0, 255, 0);
		this.pintor.addCorRGB("AZUL", "AZUL PURO", 100, 10, 0, 0, 255);
		this.pintor.addCorCMYK("CYAN", "CIANO PURO", 100, 10, 100, 0, 0, 0);
		this.pintor.addCorCMYK("MAGENTA", "MAGENTA PURO", 100, 10, 0, 100, 0, 0);
		this.pintor.addCorCMYK("YELLOW", "AMARELO PURO", 100, 10, 0, 0, 100, 0);
		this.pintor.addCorCMYK("BLACK", "PRETO", 100, 10, 0, 0, 0, 100);		
	}
	
	
	public void run2(boolean memory) throws Exception{
		JVendaUI ui = new JVendaUI();
		ui.run(memory);
	}
	
	
	public static void main(String[] args) throws Exception {
		(new AppTeste(true)).run2(false);
		System.out.println("Finalizando...");
	}
	

}
