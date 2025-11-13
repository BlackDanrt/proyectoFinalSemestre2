package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * La clase {@code PanelCodigoVerificacion} representa el panel de la interfaz
 * donde el usuario debe ingresar el código de verificación enviado por correo
 * electrónico.
 * 
 * <p>
 * Contiene seis campos de texto para el código, un botón para verificarlo y
 * otro para cerrar sesión. También permite mostrar un fondo y un título
 * personalizable.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelCodigoVerificacion extends JPanel {

	/**
	 * Imagen de fondo del panel.
	 */
	private Image imagenFondo;

	/**
	 * Campos de texto para ingresar los seis dígitos del código de verificación.
	 */
	private JTextField txtfnum1, txtfnum2, txtfnum3, txtfnum4, txtfnum5, txtfnum6;

	/**
	 * Botón para verificar el código ingresado.
	 */
	private JButton btnVerificar;

	/**
	 * Botón para cerrar sesión.
	 */
	private JButton btnCerrarSesion;

	/**
	 * Etiqueta que muestra el título del panel.
	 */
	private JLabel lbltitulo;

	/**
	 * Crea una nueva instancia del panel de código de verificación, inicializando
	 * su diseño y componentes.
	 */
	public PanelCodigoVerificacion() {
		this.setLayout(null);
		this.setSize(1280, 860);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes del panel, incluyendo los campos de texto, los
	 * botones y la etiqueta de título.
	 */
	public void inicializarComponentes() {

		lbltitulo = new JLabel();
		lbltitulo.setBounds(270, 120, 739, 127);
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 36));
		lbltitulo.setForeground(Color.WHITE);

		txtfnum1 = new JTextField();
		txtfnum1.setBounds(68, 310, 133, 181);
		txtfnum1.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 42));
		txtfnum1.setHorizontalAlignment(JTextField.CENTER);
		txtfnum1.setOpaque(false);
		txtfnum1.setBorder(null);

		txtfnum2 = new JTextField();
		txtfnum2.setBounds(270, 310, 133, 181);
		txtfnum2.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 42));
		txtfnum2.setHorizontalAlignment(JTextField.CENTER);
		txtfnum2.setOpaque(false);
		txtfnum2.setBorder(null);

		txtfnum3 = new JTextField();
		txtfnum3.setBounds(472, 310, 133, 181);
		txtfnum3.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 42));
		txtfnum3.setHorizontalAlignment(JTextField.CENTER);
		txtfnum3.setOpaque(false);
		txtfnum3.setBorder(null);

		txtfnum4 = new JTextField();
		txtfnum4.setBounds(674, 310, 133, 181);
		txtfnum4.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 42));
		txtfnum4.setHorizontalAlignment(JTextField.CENTER);
		txtfnum4.setOpaque(false);
		txtfnum4.setBorder(null);

		txtfnum5 = new JTextField();
		txtfnum5.setBounds(876, 310, 133, 181);
		txtfnum5.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 42));
		txtfnum5.setHorizontalAlignment(JTextField.CENTER);
		txtfnum5.setOpaque(false);
		txtfnum5.setBorder(null);

		txtfnum6 = new JTextField();
		txtfnum6.setBounds(1078, 310, 133, 181);
		txtfnum6.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 42));
		txtfnum6.setHorizontalAlignment(JTextField.CENTER);
		txtfnum6.setOpaque(false);
		txtfnum6.setBorder(null);

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

	/**
	 * Dibuja el fondo del panel si se ha asignado una imagen.
	 * 
	 * @param g el contexto gráfico donde se pintará el fondo.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) { // Verifica que exista
			g.drawImage(imagenFondo, 0, 0, this);
		}
	}

	/** @return el campo de texto del primer dígito. */
	public JTextField getTxtfnum1() {
		return txtfnum1;
	}

	/** @param txtfnum1 el nuevo campo de texto del primer dígito. */
	public void setTxtfnum1(JTextField txtfnum1) {
		this.txtfnum1 = txtfnum1;
	}

	/** @return el campo de texto del segundo dígito. */
	public JTextField getTxtfnum2() {
		return txtfnum2;
	}

	/** @param txtfnum2 el nuevo campo de texto del segundo dígito. */
	public void setTxtfnum2(JTextField txtfnum2) {
		this.txtfnum2 = txtfnum2;
	}

	/** @return el campo de texto del tercer dígito. */
	public JTextField getTxtfnum3() {
		return txtfnum3;
	}

	/** @param txtfnum3 el nuevo campo de texto del tercer dígito. */
	public void setTxtfnum3(JTextField txtfnum3) {
		this.txtfnum3 = txtfnum3;
	}

	/** @return el campo de texto del cuarto dígito. */
	public JTextField getTxtfnum4() {
		return txtfnum4;
	}

	/** @param txtfnum4 el nuevo campo de texto del cuarto dígito. */
	public void setTxtfnum4(JTextField txtfnum4) {
		this.txtfnum4 = txtfnum4;
	}

	/** @return el campo de texto del quinto dígito. */
	public JTextField getTxtfnum5() {
		return txtfnum5;
	}

	/** @param txtfnum5 el nuevo campo de texto del quinto dígito. */
	public void setTxtfnum5(JTextField txtfnum5) {
		this.txtfnum5 = txtfnum5;
	}

	/** @return el campo de texto del sexto dígito. */
	public JTextField getTxtfnum6() {
		return txtfnum6;
	}

	/** @param txtfnum6 el nuevo campo de texto del sexto dígito. */
	public void setTxtfnum6(JTextField txtfnum6) {
		this.txtfnum6 = txtfnum6;
	}

	/** @return el botón de verificación. */
	public JButton getBtnVerificar() {
		return btnVerificar;
	}

	/** @param btnVerificar el nuevo botón de verificación. */
	public void setBtnVerificar(JButton btnVerificar) {
		this.btnVerificar = btnVerificar;
	}

	/**
	 * Asigna un texto al botón de verificación.
	 * 
	 * @param texto el texto que se mostrará en el botón.
	 */
	public void setBtnTextoVerificar(String texto) {
		btnVerificar.setText(texto);
	}

	/** @return el botón para cerrar sesión. */
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	/** @param btnCerrarSesion el nuevo botón para cerrar sesión. */
	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	/**
	 * Asigna un texto al botón de cierre de sesión.
	 * 
	 * @param texto el texto que se mostrará en el botón.
	 */
	public void setBtnTextoCerrarSesion(String texto) {
		btnCerrarSesion.setText(texto);
	}

	/** @return la etiqueta del título del panel. */
	public JLabel getLbltitulo() {
		return lbltitulo;
	}

	/** @param lbltitulo la nueva etiqueta del título. */
	public void setLbltitulo(JLabel lbltitulo) {
		this.lbltitulo = lbltitulo;
	}

	/**
	 * Asigna un texto al título del panel.
	 * 
	 * @param texto el texto que se mostrará en la etiqueta de título.
	 */
	public void setLabelTextoTitulo(String texto) {
		lbltitulo.setText(texto);
	}

	/** @return la imagen de fondo actual del panel. */
	public Image getImagenFondo() {
		return imagenFondo;
	}

	/** @param imagenFondo la nueva imagen de fondo a establecer. */
	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

}
