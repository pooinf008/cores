package br.edu.ifba.inf008.color.logica;
public class CorCMYK extends Cor{
    
    private int cyan;
    private int magenta;
    private int yellow;    
    private int key;    
   
    public CorCMYK(String id, String nome, double estoque, double preco, int cyan, int magenta, int yellow, int key) {
        super(id, nome, estoque, preco);
        this.setCyan(cyan);
        this.setMagenta(magenta);
        this.setYellow(yellow);
        this.setKey(key);
    }    
    
    public CorCMYK(String id, String nome, double preco, int cyan, int magenta, int yellow, int key) {
        super(id, nome, preco);
        this.setCyan(cyan);
        this.setMagenta(magenta);
        this.setYellow(yellow);
        this.setKey(key);

    }      
    
 
    
    private void setCyan(int cyan){
        if(cyan >=0 && cyan<=100)
          this.cyan = cyan;
    } 
    
    private void setMagenta(int magenta){
        if(magenta >=0 && magenta<=100)
          this.magenta = magenta;
    } 

    private void setYellow(int yellow){
        if(yellow >=0 && yellow<=100)
          this.yellow = yellow;
    } 
    
    private void setKey(int key){
        if(key >=0 && key<=100)
          this.key = key;
    } 
    
    public int getCyan(){
        return this.cyan;
    } 

    public int getMagenta(){
        return this.magenta;
    }     
    
    public int getYellow(){
        return this.yellow;
    } 

    public int getKey(){
        return this.key;
    }

	@Override
	public RGB toRGB() {
		int red = (int)(255 * (1 - this.getCyan() / 100.0) *  (1 - this.getKey() / 100.0));
		int green = (int)(255 * (1 - this.getMagenta() / 100.0) *  (1 - this.getKey() / 100.0));
		int blue = (int)(255 * (1 - this.getYellow() / 100.0) *  (1 - this.getKey() / 100.0));
		return new RGB(red, green, blue);
	}     
    
	
	public static void main(String[] args) {
		CorCMYK cor = new CorCMYK("YE01", "Yellow", 10, 0, 0, 100, 0);
//		CorCMYK cor = new CorCMYK("EA", "Especiaria Antiga", 0, 0, 40, 37, 29);		
		System.out.println(cor.getDistancia(RGB.getSampleColor("#FFFF00")));
	}
    
}
