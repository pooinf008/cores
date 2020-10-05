package br.edu.ifba.inf008.color.logica;

public abstract class Cor{

    private String id;
    private String nome;
    private double estoque;
    private double preco;
    
    public Cor(String id, String nome, double estoque, double preco) {
        super();
        this.setId(id);
        this.setNome(nome);
        this.setEstoque(estoque);
        this.setPreco(preco);
    }
    
    public Cor(String id, String nome, double preco) {
        this(id, nome, 0, preco);
    }    

    
    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public double getEstoque() {
        return this.estoque;
    }

    public double getPreco() {
        return this.preco;
    }



    private void setId(String id) {
        this.id = id;
    }



    private void setNome(String nome) {
        this.nome = nome;
    }


    private void setEstoque(double estoque) {
        this.estoque = estoque;
    }
    
    public double getDistancia(Cor cor) {
    	return this.getDistancia(cor.toRGB());
    }
    
    public double getDistancia(RGB rgb) {
    	RGB me = this.toRGB();
    	return Math.sqrt(Math.pow(me.getRed() - rgb.getRed(), 2) +
    			         Math.pow(me.getGreen() - rgb.getGreen(), 2) + 
    	                 Math.pow(me.getBlue() - rgb.getBlue(), 2)); 
    }
    
    
    public abstract RGB toRGB();

    private void setPreco(double preco) {
        this.preco = preco;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cor other = (Cor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public void abastecerEstoque(double estoque) {
		this.estoque += estoque;
	}
	
	public void decrementarEstoque(double estoque) {
		this.estoque -= estoque;
	}
	
	public double getPreco(double qtde) {
		return this.getPreco() * qtde;
	}
    
}
