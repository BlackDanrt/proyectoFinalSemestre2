package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCodigoVerificacion extends JPanel {

	private JTextField txtfnum1, txtfnum2, txtfnum3, txtfnum4, txtfnum5, txtfnum6;
	private JButton btnVerificar, btnCerrarSesion;
	private JLabel lbltitulo;

	public PanelCodigoVerificacion() {
		this.setLayout(null);
		this.setSize(1280, 860);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		lbltitulo = new JLabel();
		lbltitulo.setBounds(270, 120, 739, 127);

		txtfnum1 = new JTextField();
		txtfnum1.setBounds(68, 310, 133, 181);

		txtfnum2 = new JTextField();
		txtfnum2.setBounds(270, 310, 133, 181);

		txtfnum3 = new JTextField();
		txtfnum3.setBounds(472, 310, 133, 181);

		txtfnum4 = new JTextField();
		txtfnum4.setBounds(674, 310, 133, 181);

		txtfnum5 = new JTextField();
		txtfnum5.setBounds(876, 310, 133, 181);

		txtfnum6 = new JTextField();
		txtfnum6.setBounds(1078, 310, 133, 181);

		btnCerrarSesion = new JButton();
		btnCerrarSesion.setBounds(54, 714, 160, 50);

		btnVerificar = new JButton();
		btnVerificar.setBounds(560, 570, 160, 50);

		this.add(lbltitulo);
		this.add(txtfnum1);
		this.add(txtfnum2);
		this.add(txtfnum3);
		this.add(txtfnum4);
		this.add(txtfnum5);
		this.add(txtfnum6);
		this.add(btnCerrarSesion);
		this.add(btnVerificar);
	}

	public JTextField getTxtfnum1() {
		return txtfnum1;
	}

	public void setTxtfnum1(JTextField txtfnum1) {
		this.txtfnum1 = txtfnum1;
	}

	public JTextField getTxtfnum2() {
		return txtfnum2;
	}

	public void setTxtfnum2(JTextField txtfnum2) {
		this.txtfnum2 = txtfnum2;
	}

	public JTextField getTxtfnum3() {
		return txtfnum3;
	}

	public void setTxtfnum3(JTextField txtfnum3) {
		this.txtfnum3 = txtfnum3;
	}

	public JTextField getTxtfnum4() {
		return txtfnum4;
	}

	public void setTxtfnum4(JTextField txtfnum4) {
		this.txtfnum4 = txtfnum4;
	}

	public JTextField getTxtfnum5() {
		return txtfnum5;
	}

	public void setTxtfnum5(JTextField txtfnum5) {
		this.txtfnum5 = txtfnum5;
	}

	public JTextField getTxtfnum6() {
		return txtfnum6;
	}

	public void setTxtfnum6(JTextField txtfnum6) {
		this.txtfnum6 = txtfnum6;
	}

	public JButton getBtnVerificar() {
		return btnVerificar;
	}

	public void setBtnVerificar(JButton btnVerificar) {
		this.btnVerificar = btnVerificar;
	}
	
	public void setBtnTextoVerificar(String texto) {
		btnVerificar.setText(texto);
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}
	
	public void setBtnTextoCerrarSesion(String texto) {
		btnCerrarSesion.setText(texto);
	}

	public JLabel getLbltitulo() {
		return lbltitulo;
	}

	public void setLbltitulo(JLabel lbltitulo) {
		this.lbltitulo = lbltitulo;
	}
	
	public void setLabelTextoTitulo(String texto) {
		lbltitulo.setText(texto);
	}

}
