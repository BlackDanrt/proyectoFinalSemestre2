package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * La clase {@code PanelIniciarSesion} representa el panel gráfico encargado de
 * mostrar la interfaz para que el usuario pueda iniciar sesión en el sistema.
 * 
 * <p>
 * Incluye campos para el correo electrónico y la contraseña, así como botones
 * para iniciar sesión y registrarse. Este panel también admite la asignación de
 * una imagen de fondo.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelIniciarSesion extends JPanel {

	/**
	 * Imagen que se usa como fondo del panel.
	 */
	private Image imagenFondo;

	/**
	 * Campo de texto donde el usuario ingresa su correo electrónico.
	 */
	private JTextField txtEmail;

	/**
	 * Campo de texto donde el usuario ingresa su contraseña.
	 */
	private JPasswordField jpfContrasenia;

	/**
	 * Etiqueta que muestra el texto asociado al campo de correo electrónico.
	 */
	private JLabel lblEmail;

	/**
	 * Etiqueta que muestra el texto asociado al campo de contraseña.
	 */
	private JLabel lblContrasenia;

	/**
	 * Botón que permite al usuario iniciar sesión.
	 */
	private JButton btnIniciarSesion;

	/**
	 * Botón que permite al usuario acceder a la opción de registro.
	 */
	private JButton btnRegistrar;

	/**
	 * Crea una nueva instancia del panel de inicio de sesión, configurando su
	 * tamaño, diseño y componentes gráficos.
	 */
	public PanelIniciarSesion() {
		this.setLayout(null);
		this.setSize(560, 620);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa todos los componentes gráficos del panel, incluyendo etiquetas,
	 * campos de texto y botones.
	 */
	private void inicializarComponentes() {
		lblEmail = new JLabel();
		lblEmail.setBounds(115, 250, 340, 40);
		lblEmail.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));

		txtEmail = new JTextField();
		txtEmail.setBounds(115, 300, 340, 40);

		lblContrasenia = new JLabel();
		lblContrasenia.setBounds(115, 365, 340, 40);
		lblContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(115, 415, 340, 40);

		btnIniciarSesion = new JButton();
		btnIniciarSesion.setBounds(130, 490, 140, 60);
		btnIniciarSesion.setBackground(Color.decode("#8F8B8B"));
		btnIniciarSesion.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 12));

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(290, 490, 140, 60);
		btnRegistrar.setBackground(Color.decode("#8F8B8B"));
		btnRegistrar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 12));

		this.add(lblEmail);
		this.add(txtEmail);
		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(btnIniciarSesion);
		this.add(btnRegistrar);
	}

	/**
	 * Pinta el componente, incluyendo la imagen de fondo si está definida.
	 * 
	 * @param g el contexto gráfico usado para dibujar
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) { // Verifica que exista
			g.drawImage(imagenFondo, 0, 0, this);
		}
	}

	/** @return la imagen de fondo del panel */
	public Image getImagenFondo() {
		return imagenFondo;
	}

	/**
	 * Establece una nueva imagen de fondo para el panel.
	 * 
	 * @param imagenFondo la imagen que se desea usar como fondo
	 */
	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	/** @return el campo de texto del correo electrónico */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * Asigna un nuevo campo de texto para el correo electrónico.
	 * 
	 * @param txtEmail el campo de texto que contendrá el correo
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/** @return el campo de la contraseña */
	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	/**
	 * Asigna un nuevo campo de contraseña.
	 * 
	 * @param jpfContrasenia el campo de contraseña a establecer
	 */
	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	/** @return la etiqueta del correo electrónico */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * Define una nueva etiqueta para el campo de correo.
	 * 
	 * @param lblEmail la etiqueta que mostrará el texto asociado al correo
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/** @return la etiqueta de la contraseña */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/**
	 * Define una nueva etiqueta para el campo de contraseña.
	 * 
	 * @param lblContrasenia la etiqueta que mostrará el texto asociado a la
	 *                       contraseña
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/** @return el botón para iniciar sesión */
	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	/**
	 * Asigna un nuevo botón de inicio de sesión.
	 * 
	 * @param btnIniciarSesion el botón que se desea asignar
	 */
	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}

	/** @return el botón para registrar un nuevo usuario */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Asigna un nuevo botón para registrarse.
	 * 
	 * @param btnRegistrar el botón que se desea asignar
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

}