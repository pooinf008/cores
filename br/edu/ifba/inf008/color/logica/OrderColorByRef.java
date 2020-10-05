package br.edu.ifba.inf008.color.logica;

import java.util.Comparator;

public class OrderColorByRef implements Comparator<Cor> {

	
	private RGB corExemplo;
	
	public OrderColorByRef(RGB corExemplo) {
		this.corExemplo = corExemplo;
	}

	@Override
	public int compare(Cor cor1, Cor cor2) {
		if(cor1.getDistancia(this.corExemplo) > cor2.getDistancia(this.corExemplo))
		  return 1;
		else if(cor1.getDistancia(this.corExemplo) < cor2.getDistancia(this.corExemplo))
		  return -1;
		else
		  return 0;	
	}

}
