package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelBanner extends JPanel {

	private JButton btnModoOscuro;
	private JComboBox<String> cmbIdioma;

	public PanelBanner() {
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		this.setLayout(null);
		this.setSize(1280, 80);
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4458")));
		this.setVisible(true);

		/**
		 * Español: español, Inglés: English, Portugués: português Ruso: русский Chino:
		 * 中文 Hebreo: עברית
		 */
		
		cmbIdioma = new JComboBox<String>();
		cmbIdioma.addItem("Español ES");
		cmbIdioma.addItem("English US");
		cmbIdioma.addItem("Portugués BR");
		cmbIdioma.addItem("русский RU");
		cmbIdioma.addItem("中文 CN");
		cmbIdioma.addItem("עברית IL");
		cmbIdioma.setBounds(1000, 22, 245, 36);
		cmbIdioma.setLightWeightPopupEnabled(false);

		btnModoOscuro = new JButton();
		btnModoOscuro.setBounds(915, 15, 50, 50);
		btnModoOscuro.setFocusPainted(false);
		btnModoOscuro.setContentAreaFilled(false);
		btnModoOscuro.setBorderPainted(false);

		this.add(cmbIdioma);
		this.add(btnModoOscuro);

	}

	public JButton getBtnModoOscuro() {
		return btnModoOscuro;
	}

	public void setBtnModoOscuro(JButton btnModoOscuro) {
		this.btnModoOscuro = btnModoOscuro;
	}

	public JComboBox<String> getCmbIdioma() {
		return cmbIdioma;
	}

	public void setCmbIdioma(JComboBox<String> cmbIdioma) {
		this.cmbIdioma = cmbIdioma;
	}

}
