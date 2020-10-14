package br.edu.ifba.inf008.color.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.ifba.inf008.color.logica.Cor;
import br.edu.ifba.inf008.color.logica.CorCMYK;
import br.edu.ifba.inf008.color.logica.CorRGB;

public class MemColor implements ColorDAO{
	
    private Map<String, Cor> cores;
    
    public MemColor() {
        this.cores = new HashMap<String, Cor>();
        try {
			this.populate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
    }
    
    private void populate() throws Exception {
		this.salvar(new CorRGB("Alizarina", "ALIZARINA", 100, 10, 227, 38, 54));
		this.salvar(new CorRGB("Azul camarada", "Azul camarada", 100, 10, 5, 79, 119));
		this.salvar(new CorCMYK("DOURADO", "DOURADO", 100, 10, 0, 16, 100, 0));
		this.salvar(new CorCMYK("OLIVA", "OLIVA", 100, 10, 0, 0, 100, 50));	    	
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
