package br.edu.ifba.inf008.color.logica;

public class RGB {
	

	public static RGB getSampleColor(String codCor){
    	
        String sRed = codCor.substring(0,2);
        String sGreen = codCor.substring(2,4);        
        String sBlue = codCor.substring(4,6);   
        
        int iRed =   Integer.decode("0x" + sRed);
        int iGreen = Integer.decode("0x" + sGreen);
        int iBlue = Integer.decode("0x" + sBlue);        
        
        return new RGB(iRed, iGreen, iBlue);
    }  	
	
    private int red;
    private int green;
    private int blue;  
    
    
    public RGB(int iRed, int iGreen, int iBlue) {
        this.setRed(iRed);
        this.setGreen(iGreen);
        this.setBlue(iBlue);
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
    

}
