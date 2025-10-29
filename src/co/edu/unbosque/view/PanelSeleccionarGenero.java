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
		this.setSize(560, 620);
		this.setBackground(Color.decode("#BB82CF"));
		this.setVisible(true);
		inicializarComponentes();

	}

	public void inicializarComponentes() {
		lblTitulo = new JLabel();
		lblTitulo.setBounds(194, 69, 412, 50);

		btnHombre = new JButton();
		btnHombre.setBounds(194, 169, 171, 176);

		ImageIcon iconoHombre = new ImageIcon("files/hombre.png");
		Image imgHombre = iconoHombre.getImage().getScaledInstance(171, 176, Image.SCALE_SMOOTH);
		btnHombre.setIcon(new ImageIcon(imgHombre));

		btnMujer = new JButton();
		btnMujer.setBounds(435, 171, 169, 176);

		ImageIcon iconoMujer = new ImageIcon("files/mujer.png");
		Image imgMujer = iconoMujer.getImage().getScaledInstance(169, 176, Image.SCALE_SMOOTH);
		btnMujer.setIcon(new ImageIcon(imgMujer));

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(35, 512, 90, 25);

		lblHombre = new JLabel();
		lblHombre.setBounds(230, 363, 100, 25);

		lblMujer = new JLabel();
		lblMujer.setBounds(470, 363, 100, 25);

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

	public JButton getBtnMujer() {
		return btnMujer;
	}

	public void setBtnMujer(JButton btnMujer) {
		this.btnMujer = btnMujer;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblHombre() {
		return lblHombre;
	}

	public void setLblHombre(JLabel lblHombre) {
		this.lblHombre = lblHombre;
	}

	public JLabel getLblMujer() {
		return lblMujer;
	}

	public void setLblMujer(JLabel lblMujer) {
		this.lblMujer = lblMujer;
	}

}
