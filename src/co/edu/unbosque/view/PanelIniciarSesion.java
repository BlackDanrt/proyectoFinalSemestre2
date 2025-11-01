package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelIniciarSesion extends JPanel {
	private JLabel lblFondo;
	private JTextField txtEmail;
	private JPasswordField jpfContrasenia;
	private JLabel lblEmail;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	private JButton btnRegistrar;

	public PanelIniciarSesion() {
		this.setLayout(null);
		this.setSize(560, 620);
		this.setBackground(Color.decode("#BB82CF"));
		this.setVisible(true);
		inicializarComponentes();

	}

	private void inicializarComponentes() {

		lblFondo = new JLabel();
		lblFondo.setBounds(70, 40, 450, 170);

		lblEmail = new JLabel();
		lblEmail.setBounds(70, 250, 340, 40);

		txtEmail = new JTextField();
		txtEmail.setBounds(70, 300, 340, 40);

		lblContrasenia = new JLabel();
		lblContrasenia.setBounds(70, 365, 340, 40);

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(70, 415, 340, 40);

		btnIniciarSesion = new JButton();
		btnIniciarSesion.setBounds(70, 470, 140, 35);

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(70, 560, 140, 35);

		this.add(lblFondo);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(btnIniciarSesion);
		this.add(btnRegistrar);

	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}
	
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}
	
	public void setLblTextoEmail(String texto) {
		lblEmail.setText(texto);
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}
	
	public void setLblTextoContra(String texto) {
		lblContrasenia.setText(texto);
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}
	

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public void setBtnTextoIniciarSesion(String texto) {
		btnIniciarSesion.setText(texto);
	}
	
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	
	public void setBtnTextoRegistrar(String texto) {
		btnRegistrar.setText(texto);
	}
	
	
}