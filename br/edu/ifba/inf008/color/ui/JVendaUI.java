package br.edu.ifba.inf008.color.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.ifba.inf008.color.logica.AppPintor;
import br.edu.ifba.inf008.color.logica.ColorLogica;
import br.edu.ifba.inf008.color.logica.RGB;
import br.edu.ifba.inf008.color.logica.dto.CorDTO;

public class JVendaUI extends JFrame implements ActionListener, ColorUI{
	
	private JLabel lblColor;
	private JTextField txtColor;
	private JLabel lblQtde;
	private JTextField txtQtde;
	
	private JPanel corBase;
	private JPanel corEncontrada;
	private JPanel pnlCorEncontrada;
	private JLabel nomeCorEncontrada;
	
	private JButton btnBuscar;
	private JButton btnVender;
	
	private ColorLogica pintor;
	private CorDTO cor;
	
	
	private void instantiate() throws Exception {
		this.lblColor = new JLabel("Cor:");
		this.txtColor = new JTextField();
		this.lblQtde = new JLabel("Quantidade:");
		this.txtQtde = new JTextField();
		this.btnBuscar = new JButton("Buscar...");
		this.btnBuscar.addActionListener(this);
		this.btnVender = new JButton("Vender...");
		this.btnVender.addActionListener(this);
		this.corBase = new JPanel();
		this.pnlCorEncontrada = new JPanel();
		this.corEncontrada = new JPanel();
		this.nomeCorEncontrada = new JLabel();
		
		this.cor = null;
	}
	
	private void render() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(">>>Sistema de Vendas<<<");
		this.setSize(600, 300);
		this.setVisible(true);
		
	}
	
	
	private void asmBorder() {
		
		JPanel pnlNorth = new JPanel();
		JPanel pnlNorth1 = new JPanel();
		JPanel pnlCenter = new JPanel();
		
		pnlNorth1.setLayout(new GridLayout(2, 2));
		pnlNorth1.add(this.lblColor);
		pnlNorth1.add(this.txtColor);
		pnlNorth1.add(this.lblQtde);
		pnlNorth1.add(this.txtQtde);
		
		pnlNorth.setLayout(new GridLayout(2, 1));
		pnlNorth.add(pnlNorth1);
		pnlNorth.add(this.btnBuscar);
		
		pnlCorEncontrada.setLayout(new BorderLayout());
		pnlCorEncontrada.add(corEncontrada, BorderLayout.CENTER);
		pnlCorEncontrada.add(nomeCorEncontrada, BorderLayout.SOUTH);
		
		
		pnlCenter.setLayout(new GridLayout(1, 2));
		pnlCenter.add(corBase);
		pnlCenter.add(pnlCorEncontrada);
		
		this.setLayout(new BorderLayout());
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(this.btnVender, BorderLayout.SOUTH);
		
	}
	
	
	public void run() throws Exception {
		this.instantiate();
		this.asmBorder();
		this.render();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(this.btnBuscar)) {
			doBuscar();
		}else if(arg0.getSource().equals(this.btnVender)) {
			doVender();
		}
		this.repaint();
		
	}

	private void doVender() {
		Double qtdeCor = Double.valueOf(this.txtQtde.getText());
		try {
			this.pintor.vender(this.cor.getIdCor(), qtdeCor);
			this.corBase.setBackground(new Color(125,125,125));
			this.corEncontrada.setBackground(new Color(125,125,125));
			this.nomeCorEncontrada.setText("VENDIDO");
			this.cor = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void doBuscar() {
		String textCor = this.txtColor.getText();
		Double qtdeCor;
		try {
			qtdeCor = Double.valueOf(this.txtQtde.getText());
			this.cor = this.pintor.getValor(textCor, qtdeCor);
			RGB rgb = RGB.getSampleColor(textCor);
			this.corBase.setBackground(new Color(rgb.getRed(),rgb.getGreen(),rgb.getBlue()));
			this.corEncontrada.setBackground(new Color(cor.getRgb().getRed(),
													   cor.getRgb().getGreen(),
													   cor.getRgb().getBlue()));
			this.nomeCorEncontrada.setText(cor.getNomeCor());
		}catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(this,
				    "Formato de Litragem Invalida.",
				    "Tipo Errado",
				    JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setLogica(ColorLogica logica) throws Exception {
		 this.pintor = logica;
		
	}
	

}
