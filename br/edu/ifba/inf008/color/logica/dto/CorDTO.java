package br.edu.ifba.inf008.color.logica.dto;

public class CorDTO {
	
	private String idCor;
	private String nomeCor;
	private double valor;
	
	public CorDTO(String idCor, String nomeCor, double valor) {
		super();
		this.setIdCor(idCor);
		this.setNomeCor(nomeCor);
		this.setValor(valor);
	}
	private void setIdCor(String idCor) {
		this.idCor = idCor;
	}
	private void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}
	private void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getIdCor() {
		return idCor;
	}
	public String getNomeCor() {
		return nomeCor;
	}
	public double getValor() {
		return valor;
	}
	
	
	
	
	
	
	

}
