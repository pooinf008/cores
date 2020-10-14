package br.edu.ifba.inf008.color;

import java.io.FileInputStream;
import java.util.Properties;
import br.edu.ifba.inf008.color.logica.ColorLogica;
import br.edu.ifba.inf008.color.persistencia.ColorDAO;
import br.edu.ifba.inf008.color.ui.ColorUI;


public class AppColor {

	private ColorUI ui;
	private ColorLogica logica;
	private ColorDAO persistencia;
	
	
	public void  loadClasses(String fileConfName) throws Exception {
		Properties prop = new Properties();
		prop.load(new FileInputStream(fileConfName));
		System.out.println();
		
		this.persistencia = (ColorDAO) (Class.forName((String)prop.get("PERSISTENCIA")).newInstance());
		this.logica = (ColorLogica) (Class.forName((String)prop.get("LOGICA")).newInstance());
		this.ui = (ColorUI) (Class.forName((String)prop.get("UI")).newInstance());
	}
	
	
	public void asm(String fileConfName) throws Exception {
		this.loadClasses(fileConfName);
		this.logica.setPersistencia(this.persistencia);
		this.ui.setLogica(this.logica);
		this.ui.run();
	}
	
	
	public static void main(String[] args) throws Exception {
		(new AppColor()).asm(args[0]);
	}


	

}
