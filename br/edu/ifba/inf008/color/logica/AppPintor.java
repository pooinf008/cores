package br.edu.ifba.inf008.color.logica;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import br.edu.ifba.inf008.color.logica.dto.CorDTO;
import br.edu.ifba.inf008.color.persistencia.ColorDAO;
import br.edu.ifba.inf008.color.persistencia.MemColor;
import br.edu.ifba.inf008.color.persistencia.SQLColor;

public class AppPintor implements ColorLogica{
    
	private ColorDAO colorDAO; 
	
    public AppPintor(){
    }   
    
    
    public void addCorCMYK(String id, String nome, double estoque, double preco, int cyan, int magenta, int yellow, int key) throws Exception{
    	CorCMYK cor = new CorCMYK(id , nome, estoque, preco, cyan, magenta, yellow, key);
    	this.colorDAO.salvar(cor);
    }
    
    public void addCorRGB(String id, String nome, double estoque, double preco, int red, int green, int blue) throws Exception{
    	CorRGB cor = new CorRGB(id , nome, estoque, preco, red, green, blue);
    	this.colorDAO.salvar(cor);
    }

    
    public CorDTO getValor(String codCor, double qtde) throws Exception{
      List<Cor> cores = this.colorDAO.buscarCorQtdeMinima(qtde);
      RGB corExemplo = RGB.getSampleColor(codCor);
      Collections.sort(cores, new OrderColorByRef(corExemplo));  
      Cor corProxima = cores.get(0);
      return new CorDTO(corProxima.getId(), corProxima.getNome(), 
    		            corProxima.getPreco(qtde), corProxima.toRGB());
    }
    
    public void vender(String codCor, double qtde) throws Exception{
        Cor cor = this.colorDAO.buscar(codCor);
        if(cor.getEstoque() >= qtde)
        	cor.decrementarEstoque(qtde);
        this.colorDAO.atualizar(cor);
      }

	@Override
	public void setPersistencia(ColorDAO persistencia) throws Exception {
		this.colorDAO = persistencia;
	}

}
