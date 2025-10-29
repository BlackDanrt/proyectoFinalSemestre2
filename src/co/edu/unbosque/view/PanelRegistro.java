package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {

	private JLabel lblFondo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JPasswordField jpfContrasenia;
	private JPasswordField jpfConfirmarContrasenia;
	private JTextField txtFechaNacimiento;
	private JTextField txtEstatura;
	private JTextField txtIngresosMensuales;
	private JCheckBox chkDivorciada;
	private JButton btnRegistrar;
	private JButton btnCancelar;

	public PanelRegistro() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setBackground(Color.decode("#BB82CF"));
		this.setVisible(true);
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		// Logo/Fondo centrado
		lblFondo = new JLabel();
		lblFondo.setBounds(440, 30, 400, 150);

		// COLUMNA IZQUIERDA
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(200, 220, 340, 20);
		txtNombre = new JTextField();
		txtNombre.setBounds(200, 245, 340, 35);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(200, 295, 340, 20);
		txtApellido = new JTextField();
		txtApellido.setBounds(200, 320, 340, 35);

		JLabel lblAlias = new JLabel("Alias (único e irrepetible):");
		lblAlias.setBounds(200, 370, 340, 20);
		txtAlias = new JTextField();
		txtAlias.setBounds(200, 395, 340, 35);

		JLabel lblEmail = new JLabel("Correo Electrónico:");
		lblEmail.setBounds(200, 445, 340, 20);
		txtEmail = new JTextField();
		txtEmail.setBounds(200, 470, 340, 35);

		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento (DD/MM/YYYY):");
		lblFechaNacimiento.setBounds(200, 520, 340, 20);
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(200, 545, 340, 35);

		// COLUMNA DERECHA
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(740, 220, 340, 20);
		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(740, 245, 340, 35);

		JLabel lblConfirmarContrasenia = new JLabel("Confirmar Contraseña:");
		lblConfirmarContrasenia.setBounds(740, 295, 340, 20);
		jpfConfirmarContrasenia = new JPasswordField();
		jpfConfirmarContrasenia.setBounds(740, 320, 340, 35);

		JLabel lblEstatura = new JLabel("Estatura (cm):");
		lblEstatura.setBounds(740, 445, 160, 20);
		txtEstatura = new JTextField();
		txtEstatura.setBounds(740, 470, 160, 35);

		JLabel lblIngresosMensuales = new JLabel("Ingresos Mensuales ($):");
		lblIngresosMensuales.setBounds(920, 445, 180, 20);
		txtIngresosMensuales = new JTextField();
		txtIngresosMensuales.setBounds(920, 470, 160, 35);

		chkDivorciada = new JCheckBox("¿Ha tenido divorcios?");
		chkDivorciada.setBounds(740, 520, 220, 30);
		chkDivorciada.setOpaque(false);

		// BOTONES CENTRADOS
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(440, 640, 180, 45);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(660, 640, 180, 45);

		this.add(lblFondo);
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblApellido);
		this.add(txtApellido);
		this.add(lblAlias);
		this.add(txtAlias);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(lblConfirmarContrasenia);
		this.add(jpfConfirmarContrasenia);
		this.add(lblFechaNacimiento);
		this.add(txtFechaNacimiento);
		this.add(lblEstatura);
		this.add(txtEstatura);
		this.add(lblIngresosMensuales);
		this.add(txtIngresosMensuales);
		this.add(chkDivorciada);
		this.add(btnRegistrar);
		this.add(btnCancelar);
	}

	// Getters y Setters
	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtAlias() {
		return txtAlias;
	}

	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	public JPasswordField getJpfConfirmarContrasenia() {
		return jpfConfirmarContrasenia;
	}

	public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
		this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
	}

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	public JTextField getTxtEstatura() {
		return txtEstatura;
	}

	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	public JTextField getTxtIngresosMensuales() {
		return txtIngresosMensuales;
	}

	public void setTxtIngresosMensuales(JTextField txtIngresosMensuales) {
		this.txtIngresosMensuales = txtIngresosMensuales;
	}

	public JCheckBox getChkDivorciada() {
		return chkDivorciada;
	}

	public void setChkDivorciada(JCheckBox chkDivorciada) {
		this.chkDivorciada = chkDivorciada;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
}