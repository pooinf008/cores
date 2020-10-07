package br.edu.ifba.inf008.color.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf008.color.logica.Cor;

public class MemColor implements ColorDAO{
	
    private Map<String, Cor> cores;
    
    public MemColor() {
        this.cores = new HashMap<String, Cor>();
    }
    
    public List<Cor> buscarCorQtdeMinima(double qtde) throws Exception{
    	List<Cor> corQtde = new ArrayList<Cor>(); 
        for(Cor cor : this.cores.values())
          if(cor.getEstoque() >= qtde)
            corQtde.add(cor);  
        return corQtde;
    }

	public void salvar(Cor cor) throws Exception {
		this.cores.put(cor.getId(), cor);
	}

	@Override
	public Cor buscar(String codCor) throws Exception {
		return this.cores.get(codCor);
	}

	@Override
	public void atualizar(Cor cor) throws Exception {
		this.cores.put(cor.getId(), cor);
	}

	@Override
	public void salveOuAtualize(Cor cor) throws Exception {
		this.cores.put(cor.getId(), cor);
	}    
    


}
