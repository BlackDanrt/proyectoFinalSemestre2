package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelScroll extends JPanel{
	
	private JLabel lblFondo;
	private JLabel lblAlias;
	private JLabel lblEdad;
	private JLabel lblEstatura;
	private JLabel lblIngresos;
	private JLabel lblDivorcios;	
	private JButton btnSmash;
	private JButton btnPass;
		
	public PanelScroll() {
		 this.setLayout(null);
	        this.setSize(560, 700);
	        this.setBackground(Color.decode("#BB82CF"));
	        this.setVisible(true);
	        inicializarComponentes();
	}
	
	private void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(70, 40, 450, 170);
		
		lblAlias = new JLabel();
		lblAlias.setBounds(70, 250, 340, 20);
		
		lblEdad = new JLabel();
		lblEdad.setBounds(70, 250, 340, 20);
		
		lblEstatura = new JLabel();
		lblEstatura.setBounds(70, 250, 340, 20);
		
		lblIngresos = new JLabel();
		lblIngresos.setBounds(70, 250, 340, 20);
		
		lblDivorcios = new JLabel();
		lblDivorcios.setBounds(70, 250, 340, 20);
		
		//Recordar volver circulo (Preguntar a Davincho si se le olvido mencionarlo)
		btnPass = new JButton("X");
		btnPass.setBackground(Color.decode("#F23C29"));
		btnPass.setForeground(Color.white);
		btnPass.setBounds(230, 720, 140, 35);
		
		btnSmash = new JButton("<3");
		btnSmash.setBackground(Color.decode("#44F533"));
		btnPass.setForeground(Color.white);
		btnSmash.setBounds(230, 720, 140, 35);
		
		this.add(lblFondo);
		this.add(lblAlias);
		this.add(lblEdad);
		this.add(lblEstatura);
		this.add(lblIngresos);
		this.add(lblDivorcios);
		this.add(btnPass);
		this.add(btnSmash);
		
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	public JLabel getLblDivorcios() {
		return lblDivorcios;
	}

	public void setLblDivorcios(JLabel lblDivorcios) {
		this.lblDivorcios = lblDivorcios;
	}

	public JButton getBtnSmash() {
		return btnSmash;
	}

	public void setBtnSmash(JButton btnSmash) {
		this.btnSmash = btnSmash;
	}

	public JButton getBtnPass() {
		return btnPass;
	}

	public void setBtnPass(JButton btnPass) {
		this.btnPass = btnPass;
	}

}