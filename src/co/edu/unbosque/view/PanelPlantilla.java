package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Representa un panel de plantilla que muestra la información básica de un
 * usuario, incluyendo su alias, nombre, apellido, edad, ingresos, likes y una
 * imagen de perfil. También incluye un botón para dar de baja la cuenta
 * correspondiente.
 * 
 * <p>
 * Este panel está diseñado para ser utilizado dentro de una interfaz gráfica
 * donde se muestren múltiples cuentas con sus respectivos datos.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelPlantilla extends JPanel {

	/** Etiqueta que muestra el alias del usuario. */
	private JLabel lblAlias;

	/** Etiqueta que muestra el texto "Nombre:". */
	private JLabel lblNombre;

	/** Etiqueta que muestra el texto "Apellido:". */
	private JLabel lblApellido;

	/** Etiqueta que muestra el texto "Edad:". */
	private JLabel lblEdad;

	/** Etiqueta que muestra el texto "Ingresos:". */
	private JLabel lblIngresos;

	/** Etiqueta que muestra el texto "Likes:". */
	private JLabel lblLikes;

	/** Etiqueta que muestra el nombre real del usuario. */
	private JLabel lblNombreCuenta;

	/** Etiqueta que muestra el apellido real del usuario. */
	private JLabel lblApellidoCuenta;

	/** Etiqueta que muestra la edad del usuario. */
	private JLabel lblEdadCuenta;

	/** Etiqueta que muestra los ingresos del usuario. */
	private JLabel lblIngresosCuenta;

	/** Etiqueta que muestra la cantidad de likes del usuario. */
	private JLabel lblLikesCuenta;

	/** Etiqueta que muestra la imagen de perfil del usuario. */
	private JLabel lblImagenCuenta;

	/**
	 * Botón que permite dar de baja (eliminar o desactivar) la cuenta del usuario.
	 */
	private JButton btnDarDeBaja;

	/**
	 * Crea un nuevo panel de plantilla y configura su diseño y componentes.
	 */
	public PanelPlantilla() {
		this.setLayout(null);
		this.setSize(1080, 142);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa y configura todos los componentes gráficos del panel, incluyendo
	 * las etiquetas, la imagen de perfil y el botón.
	 */
	public void inicializarComponentes() {
		lblImagenCuenta = new JLabel();
		lblImagenCuenta.setBounds(10, 10, 90, 120);
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
		lblApellidoCuenta.setBounds(385, 50, 120, 30);

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(515, 50, 80, 30);

		lblEdadCuenta = new JLabel();
		lblEdadCuenta.setBounds(595, 50, 80, 30);

		lblLikes = new JLabel("Likes:");
		lblLikes.setBounds(645, 50, 80, 30);

		lblLikesCuenta = new JLabel();
		lblLikesCuenta.setBounds(715, 50, 80, 30);

		lblIngresos = new JLabel("Ingresos:");
		lblIngresos.setBounds(795, 50, 80, 30);

		lblIngresosCuenta = new JLabel();
		lblIngresosCuenta.setBounds(875, 50, 80, 30);

		btnDarDeBaja = new JButton("Dar de Baja");
		btnDarDeBaja.setBounds(965, 10, 100, 120);
		btnDarDeBaja.setBackground(Color.decode("#F44336"));
		btnDarDeBaja.setFocusPainted(false);

		lblAlias.setForeground(Color.BLACK);
		lblNombreCuenta.setForeground(Color.BLACK);
		lblApellidoCuenta.setForeground(Color.BLACK);
		lblLikesCuenta.setForeground(Color.BLACK);
		lblIngresosCuenta.setForeground(Color.BLACK);

		this.add(lblImagenCuenta);
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

	/** @return la etiqueta con la imagen de la cuenta. */
	public JLabel getLblImagenCuenta() {
		return lblImagenCuenta;
	}

	/** @param lblImagenCuenta etiqueta con la imagen del usuario. */
	public void setLblImagenCuenta(JLabel lblImagenCuenta) {
		this.lblImagenCuenta = lblImagenCuenta;
	}

	/** @return la etiqueta con el alias del usuario. */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/** @param lblAlias etiqueta con el alias del usuario. */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/** @return la etiqueta del texto "Nombre:". */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/** @param lblNombre etiqueta del texto "Nombre:". */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/** @return la etiqueta del texto "Apellido:". */
	public JLabel getLblApellido() {
		return lblApellido;
	}

	/** @param lblApellido etiqueta del texto "Apellido:". */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	/** @return la etiqueta del texto "Edad:". */
	public JLabel getLblEdad() {
		return lblEdad;
	}

	/** @param lblEdad etiqueta del texto "Edad:". */
	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	/** @return la etiqueta del texto "Ingresos:". */
	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	/** @param lblIngresos etiqueta del texto "Ingresos:". */
	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	/** @return la etiqueta del texto "Likes:". */
	public JLabel getLblLikes() {
		return lblLikes;
	}

	/** @param lblLikes etiqueta del texto "Likes:". */
	public void setLblLikes(JLabel lblLikes) {
		this.lblLikes = lblLikes;
	}

	/** @return la etiqueta con el nombre de la cuenta. */
	public JLabel getLblNombreCuenta() {
		return lblNombreCuenta;
	}

	/** @param lblNombreCuenta etiqueta con el nombre de la cuenta. */
	public void setLblNombreCuenta(JLabel lblNombreCuenta) {
		this.lblNombreCuenta = lblNombreCuenta;
	}

	/** @return la etiqueta con el apellido de la cuenta. */
	public JLabel getLblApellidoCuenta() {
		return lblApellidoCuenta;
	}

	/** @param lblApellidoCuenta etiqueta con el apellido de la cuenta. */
	public void setLblApellidoCuenta(JLabel lblApellidoCuenta) {
		this.lblApellidoCuenta = lblApellidoCuenta;
	}

	/** @return la etiqueta con la edad de la cuenta. */
	public JLabel getLblEdadCuenta() {
		return lblEdadCuenta;
	}

	/** @param lblEdadCuenta etiqueta con la edad de la cuenta. */
	public void setLblEdadCuenta(JLabel lblEdadCuenta) {
		this.lblEdadCuenta = lblEdadCuenta;
	}

	/** @return la etiqueta con los ingresos de la cuenta. */
	public JLabel getLblIngresosCuenta() {
		return lblIngresosCuenta;
	}

	/** @param lblIngresosCuenta etiqueta con los ingresos de la cuenta. */
	public void setLblIngresosCuenta(JLabel lblIngresosCuenta) {
		this.lblIngresosCuenta = lblIngresosCuenta;
	}

	/** @return la etiqueta con los likes de la cuenta. */
	public JLabel getLblLikesCuenta() {
		return lblLikesCuenta;
	}

	/** @param lblLikesCuenta etiqueta con los likes de la cuenta. */
	public void setLblLikesCuenta(JLabel lblLikesCuenta) {
		this.lblLikesCuenta = lblLikesCuenta;
	}

	/** @return el botón para dar de baja la cuenta. */
	public JButton getBtnDarDeBaja() {
		return btnDarDeBaja;
	}

	/** @param btnDarDeBaja botón para dar de baja la cuenta. */
	public void setBtnDarDeBaja(JButton btnDarDeBaja) {
		this.btnDarDeBaja = btnDarDeBaja;
	}

}