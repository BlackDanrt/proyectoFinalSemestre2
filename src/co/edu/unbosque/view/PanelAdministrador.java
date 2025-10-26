package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.*;

public class PanelAdministrador extends JPanel {
	private JLabel lblFondo;
	private JComboBox<String> cmbUss;
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
		
		cmbUss = new JComboBox<String>();
		cmbUss.addItem("Usuarios*");
		
		btnElimUss = new JButton("Desactivar Cuenta");
		btnDescargarPdf.setBounds(70, 470, 140, 35);
		

		this.add(lblFondo);
		this.add(btnDescargarPdf);
		this.add(cmbUss);
		this.add(btnElimUss);
		
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JComboBox<String> getCmbUss() {
		return cmbUss;
	}

	public void setCmbUss(JComboBox<String> cmbUss) {
		this.cmbUss = cmbUss;
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