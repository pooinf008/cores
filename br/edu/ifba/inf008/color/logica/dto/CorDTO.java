package br.edu.ifba.inf008.color.logica.dto;

import br.edu.ifba.inf008.color.logica.RGB;

public class CorDTO {
	
	private String idCor;
	private String nomeCor;
	private double valor;
	private RGB rgb;
	
	public CorDTO(String idCor, String nomeCor, double valor, RGB rgb) {
		super();
		this.setIdCor(idCor);
		this.setNomeCor(nomeCor);
		this.setValor(valor);
		this.setRGB(rgb);
	}
	
	private void setRGB(RGB rgb) {
		this.rgb = rgb;
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

	public RGB getRgb() {
		return rgb;
	}
	
	
	
	
	
	
	

}
