package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelPerfil extends JPanel {

	private JButton btnActualizar, btnCerrarSesion, btnEliminarCuenta;

	private JComboBox<String> cmbEsVisible, cmbCantidadDeDivorcio;

	private JTextField txtfAlias, txtfIngresos, txtfEstatura, txtfEstaturaIdeal, txtfEdadMinima, txtfEdadMaxima;

	private JLabel lblTitulo, lblFotoPerfil, lblNombre, lblApellido, lblAlias, lblIngresos, lblEstatura,
			lblEstaturaIdeal, lblCantidadDeDivorcio, lblEdadMinima, lblEdadMaxima, lblEsVisible;

	public PanelPerfil() {
		this.setLayout(null);
		this.setSize(560, 620);
		this.setBackground(Color.decode("#BB82CF"));
		this.setVisible(true);
		inicializarComponentes();
	}

	// Diagrama de ganhv
	public void inicializarComponentes() {

		// Propios
		lblTitulo = new JLabel("Perfil");
		lblTitulo.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblFotoPerfil = new JLabel();
		lblFotoPerfil.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblNombre = new JLabel();
		lblNombre.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblApellido = new JLabel();
		lblApellido.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblAlias = new JLabel("Alias");
		lblAlias.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblEstatura = new JLabel("Estatura");
		lblEstatura.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblEsVisible = new JLabel("Visibilidad");
		lblEsVisible.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		cmbEsVisible = new JComboBox<String>();
		cmbEsVisible.addItem("Yes");
		cmbEsVisible.addItem("No");
		cmbEsVisible.setLightWeightPopupEnabled(false);

		// Gustos
		lblEstaturaIdeal = new JLabel("Estatura ideal");
		lblEstaturaIdeal.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblEdadMinima = new JLabel("Edad minima");
		lblEdadMinima.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		lblEdadMaxima = new JLabel("Edad Maxima");
		lblEdadMaxima.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		cmbCantidadDeDivorcio = new JComboBox<String>();
		cmbCantidadDeDivorcio.addItem("Yes");
		cmbCantidadDeDivorcio.addItem("No");

		cmbCantidadDeDivorcio.setLightWeightPopupEnabled(false);

		lblIngresos = new JLabel("Ingresos mensuales");

		lblCantidadDeDivorcio = new JLabel("Cantidad de Divorcios");

		btnActualizar = new JButton();
		btnActualizar.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		btnCerrarSesion = new JButton();
		btnCerrarSesion.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		btnEliminarCuenta = new JButton();
		btnEliminarCuenta.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
	}

	public void inicializarComponentesHombre() {

		// Propios
		lblIngresos.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		txtfIngresos.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		// Gustos
		lblCantidadDeDivorcio.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		cmbCantidadDeDivorcio.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
	}

	public void inicializarComponentesMujer() {

		// Propios
		lblCantidadDeDivorcio.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		cmbCantidadDeDivorcio.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

		// Gustos
		lblIngresos.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);
		txtfIngresos.setBounds(ALLBITS, ABORT, WIDTH, HEIGHT);

	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	public JButton getBtnEliminarCuenta() {
		return btnEliminarCuenta;
	}

	public void setBtnEliminarCuenta(JButton btnEliminarCuenta) {
		this.btnEliminarCuenta = btnEliminarCuenta;
	}

	public JComboBox<String> getCmbEsVisible() {
		return cmbEsVisible;
	}

	public void setCmbEsVisible(JComboBox<String> cmbEsVisible) {
		this.cmbEsVisible = cmbEsVisible;
	}

	public JComboBox<String> getCmbCantidadDeDivorcio() {
		return cmbCantidadDeDivorcio;
	}

	public void setCmbCantidadDeDivorcio(JComboBox<String> cmbCantidadDeDivorcio) {
		this.cmbCantidadDeDivorcio = cmbCantidadDeDivorcio;
	}

	public JTextField getTxtfAlias() {
		return txtfAlias;
	}

	public void setTxtfAlias(JTextField txtfAlias) {
		this.txtfAlias = txtfAlias;
	}

	public JTextField getTxtfIngresos() {
		return txtfIngresos;
	}

	public void setTxtfIngresos(JTextField txtfIngresos) {
		this.txtfIngresos = txtfIngresos;
	}

	public JTextField getTxtfEstatura() {
		return txtfEstatura;
	}

	public void setTxtfEstatura(JTextField txtfEstatura) {
		this.txtfEstatura = txtfEstatura;
	}

	public JTextField getTxtfEstaturaIdeal() {
		return txtfEstaturaIdeal;
	}

	public void setTxtfEstaturaIdeal(JTextField txtfEstaturaIdeal) {
		this.txtfEstaturaIdeal = txtfEstaturaIdeal;
	}

	public JTextField getTxtfEdadMinima() {
		return txtfEdadMinima;
	}

	public void setTxtfEdadMinima(JTextField txtfEdadMinima) {
		this.txtfEdadMinima = txtfEdadMinima;
	}

	public JTextField getTxtfEdadMaxima() {
		return txtfEdadMaxima;
	}

	public void setTxtfEdadMaxima(JTextField txtfEdadMaxima) {
		this.txtfEdadMaxima = txtfEdadMaxima;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	public void setLblFotoPerfil(JLabel lblFotoPerfil) {
		this.lblFotoPerfil = lblFotoPerfil;
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

	public JLabel getLblAlias() {
		return lblAlias;
	}

	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	public JLabel getLblEstaturaIdeal() {
		return lblEstaturaIdeal;
	}

	public void setLblEstaturaIdeal(JLabel lblEstaturaIdeal) {
		this.lblEstaturaIdeal = lblEstaturaIdeal;
	}

	public JLabel getLblCantidadDeDivorcio() {
		return lblCantidadDeDivorcio;
	}

	public void setLblCantidadDeDivorcio(JLabel lblCantidadDeDivorcio) {
		this.lblCantidadDeDivorcio = lblCantidadDeDivorcio;
	}

	public JLabel getLblEdadMinima() {
		return lblEdadMinima;
	}

	public void setLblEdadMinima(JLabel lblEdadMinima) {
		this.lblEdadMinima = lblEdadMinima;
	}

	public JLabel getLblEdadMaxima() {
		return lblEdadMaxima;
	}

	public void setLblEdadMaxima(JLabel lblEdadMaxima) {
		this.lblEdadMaxima = lblEdadMaxima;
	}

	public JLabel getLblEsVisible() {
		return lblEsVisible;
	}

	public void setLblEsVisible(JLabel lblEsVisible) {
		this.lblEsVisible = lblEsVisible;
	}

}
