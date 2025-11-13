package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPlantilla extends JPanel {

	private JLabel lblAlias, lblNombre, lblApellido, lblEdad, lblIngresos, lblLikes;
	private JLabel lblNombreCuenta, lblApellidoCuenta, lblEdadCuenta, lblIngresosCuenta, lblLikesCuenta;
	private JLabel lblImagenCuenta; // ✅ Nueva imagen
	private JButton btnDarDeBaja;

	public PanelPlantilla() {
		this.setLayout(null);
		this.setSize(1080, 142);
		this.setVisible(true);
		inicializarComponentes();
	}

	public void inicializarComponentes() {
		// ✅ Imagen en el lado izquierdo
		lblImagenCuenta = new JLabel();
		lblImagenCuenta.setBounds(10, 10, 90, 120); // Espacio para imagen
		lblImagenCuenta.setBorder(javax.swing.BorderFactory.createLineBorder(Color.GRAY));

		lblAlias = new JLabel();
		lblAlias.setBounds(115, 10, 150, 30);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(115, 50, 80, 30);

		lblNombreCuenta = new JLabel();
		lblNombreCuenta.setBounds(205, 50, 80, 30);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(295, 50, 80, 30);

		lblApellidoCuenta = new JLabel();
		lblApellidoCuenta.setBounds(385, 50, 120, 30); // ✅ Extendido de 80 a 120

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(515, 50, 80, 30); // ✅ Movido más a la derecha (de 475 a 515)

		lblEdadCuenta = new JLabel();
		lblEdadCuenta.setBounds(595, 50, 80, 30); // ✅ Movido más a la derecha (de 555 a 595)

		lblLikes = new JLabel("Likes:");
		lblLikes.setBounds(645, 50, 80, 30);

		lblLikesCuenta = new JLabel();
		lblLikesCuenta.setBounds(715, 50, 80, 30);

		lblIngresos = new JLabel("Ingresos:");
		lblIngresos.setBounds(795, 50, 80, 30); // ✅ Movido a la izquierda

		lblIngresosCuenta = new JLabel();
		lblIngresosCuenta.setBounds(875, 50, 80, 30); // ✅ Movido a la izquierda

		btnDarDeBaja = new JButton("Dar de Baja");
		btnDarDeBaja.setBounds(965, 10, 100, 120);
		btnDarDeBaja.setBackground(Color.decode("#F44336"));
		btnDarDeBaja.setFocusPainted(false);

		lblAlias.setForeground(Color.BLACK);
		lblNombreCuenta.setForeground(Color.BLACK);
		lblApellidoCuenta.setForeground(Color.BLACK);
		lblLikesCuenta.setForeground(Color.BLACK);
		lblIngresosCuenta.setForeground(Color.BLACK);

		this.add(lblImagenCuenta); // ✅ Agregar imagen
		this.add(lblAlias);
		this.add(lblNombre);
		this.add(lblNombreCuenta);
		this.add(lblApellido);
		this.add(lblApellidoCuenta);
		this.add(lblEdad);
		this.add(lblEdadCuenta);
		this.add(lblLikes);
		this.add(lblLikesCuenta);
		this.add(lblIngresos);
		this.add(lblIngresosCuenta);
		this.add(btnDarDeBaja);
	}

	// ✅ Getter y Setter para la imagen
	public JLabel getLblImagenCuenta() {
		return lblImagenCuenta;
	}

	public void setLblImagenCuenta(JLabel lblImagenCuenta) {
		this.lblImagenCuenta = lblImagenCuenta;
	}

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	public JLabel getLblLikes() {
		return lblLikes;
	}

	public void setLblLikes(JLabel lblLikes) {
		this.lblLikes = lblLikes;
	}

	public JLabel getLblNombreCuenta() {
		return lblNombreCuenta;
	}

	public void setLblNombreCuenta(JLabel lblNombreCuenta) {
		this.lblNombreCuenta = lblNombreCuenta;
	}

	public JLabel getLblApellidoCuenta() {
		return lblApellidoCuenta;
	}

	public void setLblApellidoCuenta(JLabel lblApellidoCuenta) {
		this.lblApellidoCuenta = lblApellidoCuenta;
	}

	public JLabel getLblEdadCuenta() {
		return lblEdadCuenta;
	}

	public void setLblEdadCuenta(JLabel lblEdadCuenta) {
		this.lblEdadCuenta = lblEdadCuenta;
	}

	public JLabel getLblIngresosCuenta() {
		return lblIngresosCuenta;
	}

	public void setLblIngresosCuenta(JLabel lblIngresosCuenta) {
		this.lblIngresosCuenta = lblIngresosCuenta;
	}

	public JLabel getLblLikesCuenta() {
		return lblLikesCuenta;
	}

	public void setLblLikesCuenta(JLabel lblLikesCuenta) {
		this.lblLikesCuenta = lblLikesCuenta;
	}

	public JButton getBtnDarDeBaja() {
		return btnDarDeBaja;
	}

	public void setBtnDarDeBaja(JButton btnDarDeBaja) {
		this.btnDarDeBaja = btnDarDeBaja;
	}

}