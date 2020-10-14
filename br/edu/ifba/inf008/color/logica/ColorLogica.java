package br.edu.ifba.inf008.color.logica;

import br.edu.ifba.inf008.color.logica.dto.CorDTO;
import br.edu.ifba.inf008.color.persistencia.ColorDAO;

public interface ColorLogica {

	public void setPersistencia(ColorDAO persistencia) throws Exception;
	public void vender(String idCor, double qtdeCor) throws Exception;
	public CorDTO getValor(String textCor, double qtdeCor) throws Exception;

}
