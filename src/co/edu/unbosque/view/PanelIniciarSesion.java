package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelIniciarSesion extends JPanel {
	private Image imagenFondo;
	private JTextField txtEmail;
	private JPasswordField jpfContrasenia;
	private JLabel lblEmail;
	private JLabel lblContrasenia;
	private JButton btnIniciarSesion;
	private JButton btnRegistrar;

	public PanelIniciarSesion() {
		this.setLayout(null);
		this.setSize(560, 620);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
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

		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(btnIniciarSesion);
		this.add(btnRegistrar);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) { // Verifica que exista
			g.drawImage(imagenFondo, 0, 0, this);
		}
	}

	public Image getImagenFondo() {
		return imagenFondo;
	}

	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
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

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

}