package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.*;

public class PanelAdministrador extends JPanel {
	private JLabel lblFondo;
	private JComboBox<String> cmbUssHombre;
	private JComboBox<String> cmbUssMujer;
	private JButton btnElimUss;
	private JButton btnDescargarPdf;
	
	public PanelAdministrador() {
		this.setLayout(null);
		this.setSize(560, 620);
		this.setBackground(Color.decode("#BB82CF"));
		this.setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(70, 40, 450, 170);

		btnDescargarPdf = new JButton("Descargar PDF");
		btnDescargarPdf.setBounds(70, 470, 140, 35);
	
		cmbUssHombre = new JComboBox<String>();
		//cmbUssHombre.add();
		
		cmbUssMujer = new JComboBox<String>();
		//cmbUssMujer.add();
		
		btnElimUss = new JButton("Desactivar Cuenta");
		btnDescargarPdf.setBounds(70, 470, 140, 35);
		

		this.add(lblFondo);
		this.add(btnDescargarPdf);
		this.add(cmbUssHombre);
		this.add(cmbUssMujer);
		this.add(btnElimUss);
		
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JComboBox<String> getCmbUssHombre() {
		return cmbUssHombre;
	}

	public void setCmbUssHombre(JComboBox<String> cmbUssHombre) {
		this.cmbUssHombre = cmbUssHombre;
	}

	public JComboBox<String> getCmbUssMujer() {
		return cmbUssMujer;
	}

	public void setCmbUssMujer(JComboBox<String> cmbUssMujer) {
		this.cmbUssMujer = cmbUssMujer;
	}

	public JButton getBtnElimUss() {
		return btnElimUss;
	}

	public void setBtnElimUss(JButton btnElimUss) {
		this.btnElimUss = btnElimUss;
	}

	public JButton getBtnDescargarPdf() {
		return btnDescargarPdf;
	}

	public void setBtnDescargarPdf(JButton btnDescargarPdf) {
		this.btnDescargarPdf = btnDescargarPdf;
	}


}