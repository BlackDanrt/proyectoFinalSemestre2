package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Ventana extends JFrame {
	private JLabel fondo;
	private JLayeredPane capas;

	public Ventana() {
		setTitle("🔥BosTinder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 920);
		setLocationRelativeTo(null);
		setLayout(null); // DÉJALO como estaba

		capas = getLayeredPane();

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1280, 920);

		// La capa más baja
		capas.add(fondo, JLayeredPane.DEFAULT_LAYER);

		setVisible(true);
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JLayeredPane getCapas() {
		return capas;
	}

	public void setCapas(JLayeredPane capas) {
		this.capas = capas;
	}
}