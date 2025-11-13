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
		lblEmail.setBounds(115, 250, 340, 40);
		lblEmail.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));

		txtEmail = new JTextField();
		txtEmail.setBounds(115, 300, 340, 40);

		lblContrasenia = new JLabel();
		lblContrasenia.setBounds(115, 365, 340, 40);
		lblContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(115, 415, 340, 40);

		btnIniciarSesion = new JButton();	
		btnIniciarSesion.setBounds(130, 490, 140, 60);
		btnIniciarSesion.setBackground(Color.decode("#FF8A00"));
		btnIniciarSesion.setForeground(Color.decode("#8F8B8B"));
		btnIniciarSesion.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 12));

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(290, 490, 140, 60);
		btnRegistrar.setBackground(Color.decode("#FF8A00"));
		btnRegistrar.setForeground(Color.decode("#8F8B8B"));
		btnRegistrar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 12));

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