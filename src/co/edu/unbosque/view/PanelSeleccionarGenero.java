package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSeleccionarGenero extends JPanel {

	private JButton btnHombre, btnMujer, btnVolver;
	private JLabel lblTitulo, lblHombre, lblMujer;

	public PanelSeleccionarGenero() {
		this.setLayout(null);
		this.setSize(1280, 860);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		lblTitulo = new JLabel();
		lblTitulo.setBounds(326, 120, 628, 69);

		btnHombre = new JButton();
		btnHombre.setBounds(326, 256, 261, 240);

		ImageIcon iconoHombre = new ImageIcon("files/hombre.png");
		Image imgHombre = iconoHombre.getImage().getScaledInstance(171, 176, Image.SCALE_SMOOTH);
		btnHombre.setIcon(new ImageIcon(imgHombre));

		btnMujer = new JButton();
		btnMujer.setBounds(693, 256, 261, 240);

		ImageIcon iconoMujer = new ImageIcon("files/mujer.png");
		Image imgMujer = iconoMujer.getImage().getScaledInstance(169, 176, Image.SCALE_SMOOTH);
		btnMujer.setIcon(new ImageIcon(imgMujer));

		btnVolver = new JButton();
		btnVolver.setBounds(71, 750, 90, 25);

		lblHombre = new JLabel();
		lblHombre.setBounds(379, 521, 153, 35);

		lblMujer = new JLabel();
		lblMujer.setBounds(747, 521, 153, 35);

		this.add(lblTitulo);
		this.add(btnHombre);
		this.add(btnMujer);
		this.add(btnVolver);
		this.add(lblHombre);
		this.add(lblMujer);
	}

	public JButton getBtnHombre() {
		return btnHombre;
	}

	public void setBtnHombre(JButton btnHombre) {
		this.btnHombre = btnHombre;
	}

	public void setBtnTextoHombre(String texto) {
		btnHombre.setText(texto);
	}

	public JButton getBtnMujer() {
		return btnMujer;
	}

	public void setBtnMujer(JButton btnMujer) {
		this.btnMujer = btnMujer;
	}

	public void setBtnTextoMujer(String texto) {
		btnMujer.setText(texto);
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public void setBtnTextoVolver(String texto) {
		btnVolver.setText(texto);
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public void setLblTextoTitulo(String texto) {
		lblTitulo.setText(texto);
	}

	public JLabel getLblHombre() {
		return lblHombre;
	}

	public void setLblHombre(JLabel lblHombre) {
		this.lblHombre = lblHombre;
	}

	public void setLblTextoHombre(String texto) {
		lblHombre.setText(texto);
	}

	public JLabel getLblMujer() {
		return lblMujer;
	}

	public void setLblMujer(JLabel lblMujer) {
		this.lblMujer = lblMujer;
	}

	public void setLblTextoMujer(String texto) {
		lblMujer.setText(texto);
	}

}