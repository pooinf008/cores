package br.edu.ifba.inf008.color.persistencia;

import java.util.List;

import br.edu.ifba.inf008.color.logica.Cor;

public interface ColorDAO {
	public void salvar(Cor cor) throws Exception;
	public List<Cor> buscarCorQtdeMinima(double qtde) throws Exception;
	public Cor buscar(String codCor) throws Exception;
	public void atualizar(Cor cor) throws Exception;
	public void salveOuAtualize(Cor cor) throws Exception;
}
