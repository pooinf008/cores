package br.edu.ifba.inf008.color.logica;
public class CorRGB extends Cor{
	
    private int red;
    private int green;
    private int blue;   
    
   
    public CorRGB(String id, String nome, double estoque, double preco, int red, int green, int blue) {
        super(id, nome, estoque, preco);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }    
    
    public CorRGB(String id, String nome, double preco, int red, int green, int blue) {
        super(id, nome, preco);
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }    
   
    
    private void setRed(int red){
        if(red >=0 && red<256)
          this.red = red;
    } 
    
    private void setGreen(int green){
        if(green >=0 && green<256)
          this.green = green;
    } 

    private void setBlue(int blue){
        if(blue >=0 && blue<256)
          this.blue = blue;
    }  
    
    public int getRed(){
        return this.red;
    } 
    
    public int getGreen(){
        return this.green;
    } 

    public int getBlue(){
        return this.blue;
    } 
    
    public String toString() {
    	return "< r=" + this.getRed() + ", g=" + this.getGreen() + ", b=" + this.getBlue() + ">";   
    }


	@Override
	public RGB toRGB() {
		return new RGB(this.getRed(), this.getGreen(), this.getBlue()) ;
	}

    
    
}

