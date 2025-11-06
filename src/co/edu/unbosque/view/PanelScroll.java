package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

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
		lblFondo.setBounds(70, 40, 170, 450);
		
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
		
		Font currentFont = btnPass.getFont();
		Font boldFont = new Font(currentFont.getName(), Font.BOLD, currentFont.getSize());
		btnPass = new JButton();
		btnPass.setBackground(Color.decode("#F23C29"));
		btnPass.setForeground(Color.white);
		btnPass.setFont(boldFont);
		btnPass.setBounds(230, 720, 140, 35);
		
		btnSmash = new JButton();
		btnSmash.setBackground(Color.decode("#44F533"));
		btnPass.setForeground(Color.white);
		btnPass.setFont(boldFont);
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
	
	public void setLblTextoAlias(String texto) {
		lblAlias.setText(texto);
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}
	
	public void setLblTextoEdad(String texto) {
		lblEdad.setText(texto);
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}
	
	public void setLblTextoEstatura(String texto) {
		lblEstatura.setText(texto);
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}
	
	public void setLblTextoIngresos(String texto) {
		lblIngresos.setText(texto);
	}

	public JLabel getLblDivorcios() {
		return lblDivorcios;
	}

	public void setLblDivorcios(JLabel lblDivorcios) {
		this.lblDivorcios = lblDivorcios;
	}
	
	public void setLblTextoDivorcios(String texto) {
		lblDivorcios.setText(texto);
	}

	public JButton getBtnSmash() {
		return btnSmash;
	}

	public void setBtnSmash(JButton btnSmash) {
		this.btnSmash = btnSmash;
	}
	
	public void setBtnTextoSmash(String texto) {
		btnSmash.setText(texto);
	}

	public JButton getBtnPass() {
		return btnPass;
	}

	public void setBtnPass(JButton btnPass) {
		this.btnPass = btnPass;
	}
	
	public void setBtnTextoPass(String texto) {
		btnPass.setText(texto);
	}

}