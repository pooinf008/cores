package br.edu.ifba.inf008.color.ui;

import br.edu.ifba.inf008.color.logica.ColorLogica;

public interface ColorUI {

	public void setLogica(ColorLogica logica) throws Exception;
	public void run() throws Exception;

}
