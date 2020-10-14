package br.edu.ifba.inf008.color.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.edu.ifba.inf008.color.logica.AppPintor;
import br.edu.ifba.inf008.color.logica.ColorLogica;
import br.edu.ifba.inf008.color.logica.dto.CorDTO;

public class VendaConsole implements ColorUI{
	
	private ColorLogica pintor;
	private CorDTO cor;	
	
	public VendaConsole() throws Exception {
		this.cor = null;		
	}
	
	
	@Override
	public void setLogica(ColorLogica logica) throws Exception {
		 this.pintor = logica;
		
	}
	
	
	
	public void run() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Informe o código da cor:");
		String textCor = br.readLine();
		System.out.println("Informe a quatidade:");
		Double qtdeCor = Double.parseDouble(br.readLine());
		this.cor = this.pintor.getValor(textCor, qtdeCor);
		System.out.println(this.cor.getNomeCor());
		
	}
	
	public static void main(String[] args) throws Exception {
		VendaConsole console = new VendaConsole();
		console.run();
	}
	
	

}
