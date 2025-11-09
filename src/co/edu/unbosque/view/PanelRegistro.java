package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

public class PanelRegistro extends JPanel {

	// Componentes de visualización
	private JLabel lblFondo;

	// Labels de formulario
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblAlias;
	private JLabel lblEmail;
	private JLabel lblFechaNacimiento;
	private JLabel lblContrasenia;
	private JLabel lblConfirmarContrasenia;

	// Campos de entrada
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtAlias;
	private JTextField txtEmail;
	private JTextField txtFechaNacimiento;
	private JPasswordField jpfContrasenia;
	private JPasswordField jpfConfirmarContrasenia;

	// Botones
	private JButton btnRegistrar;
	private JButton btnCancelar;

	// FileChooser para cargar imagen de perfil
	private JFileChooser fileChooser;

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
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setText("REGISTRO"); // Texto temporal
		lblFondo.setFont(new Font("Arial", Font.BOLD, 36));
		lblFondo.setForeground(Color.WHITE);

		// ============ COLUMNA IZQUIERDA ============

		// Nombre
		lblNombre = new JLabel();
		lblNombre.setBounds(200, 220, 340, 20);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 245, 340, 35);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));

		// Apellido
		lblApellido = new JLabel();
		lblApellido.setBounds(200, 295, 340, 20);
		lblApellido.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);

		txtApellido = new JTextField();
		txtApellido.setBounds(200, 320, 340, 35);
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 14));

		// Alias
		lblAlias = new JLabel();
		lblAlias.setBounds(200, 370, 340, 20);
		lblAlias.setFont(new Font("Arial", Font.BOLD, 14));
		lblAlias.setForeground(Color.WHITE);

		txtAlias = new JTextField();
		txtAlias.setBounds(200, 395, 340, 35);
		txtAlias.setFont(new Font("Arial", Font.PLAIN, 14));

		// Email
		lblEmail = new JLabel();
		lblEmail.setBounds(200, 445, 340, 20);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setForeground(Color.WHITE);

		txtEmail = new JTextField();
		txtEmail = new JTextField();
		txtEmail.setBounds(200, 470, 340, 35);
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));

		// Fecha de Nacimiento
		lblFechaNacimiento = new JLabel();
		lblFechaNacimiento.setBounds(200, 520, 340, 20);
		lblFechaNacimiento.setFont(new Font("Arial", Font.BOLD, 14));
		lblFechaNacimiento.setForeground(Color.WHITE);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(200, 545, 340, 35);
		txtFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFechaNacimiento.setToolTipText("Formato: dd/mm/aaaa");

		// ============ COLUMNA DERECHA ============

		// Contraseña
		lblContrasenia = new JLabel();
		lblContrasenia.setBounds(740, 220, 340, 20);
		lblContrasenia.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasenia.setForeground(Color.WHITE);

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(740, 245, 340, 35);
		jpfContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));

		// Confirmar Contraseña
		lblConfirmarContrasenia = new JLabel();
		lblConfirmarContrasenia.setBounds(740, 295, 340, 20);
		lblConfirmarContrasenia.setFont(new Font("Arial", Font.BOLD, 14));
		lblConfirmarContrasenia.setForeground(Color.WHITE);

		jpfConfirmarContrasenia = new JPasswordField();
		jpfConfirmarContrasenia.setBounds(740, 320, 340, 35);
		jpfConfirmarContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));

		// ============ BOTONES CENTRADOS ============

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(440, 640, 180, 45);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.decode("#4CAF50"));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancelar = new JButton();
		btnCancelar.setBounds(660, 640, 180, 45);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// FileChooser
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png"));

		// ============ AGREGAR COMPONENTES AL PANEL ============

		this.add(lblFondo);

		// Columna Izquierda
		this.add(lblNombre);
		this.add(txtNombre);
		this.add(lblApellido);
		this.add(txtApellido);
		this.add(lblAlias);
		this.add(txtAlias);
		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblFechaNacimiento);
		this.add(txtFechaNacimiento);

		// Columna Derecha
		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(lblConfirmarContrasenia);
		this.add(jpfConfirmarContrasenia);

		// Botones
		this.add(btnRegistrar);
		this.add(btnCancelar);
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
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

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	public JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JLabel getLblConfirmarContrasenia() {
		return lblConfirmarContrasenia;
	}

	public void setLblConfirmarContrasenia(JLabel lblConfirmarContrasenia) {
		this.lblConfirmarContrasenia = lblConfirmarContrasenia;
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

	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
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

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

}