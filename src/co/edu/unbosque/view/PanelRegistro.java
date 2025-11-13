package co.edu.unbosque.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * La clase {@code PanelRegistro} representa el panel gráfico utilizado para el
 * registro de nuevos usuarios en la aplicación "BosTinder".
 * <p>
 * Contiene campos de texto para ingresar información personal (nombre,
 * apellido, alias, correo, fecha de nacimiento, contraseña y confirmación de
 * contraseña), así como un selector de imagen para la foto de perfil.
 * </p>
 * 
 * <h2>Características principales:</h2>
 * <ul>
 * <li>Permite seleccionar una foto de perfil con vista previa.</li>
 * <li>Incluye campos de entrada validados visualmente con etiquetas
 * descriptivas.</li>
 * <li>Dispone de botones de acción para registrar o cancelar el proceso.</li>
 * </ul>
 * 
 * <p>
 * Este panel está diseñado para integrarse en la ventana principal
 * ({@link JFrame}) y emplea un diseño absoluto ({@code null layout}).
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelRegistro extends JPanel {

	/** Etiqueta que puede actuar como título o fondo decorativo del panel. */
	private JLabel lblFondo;

	/** Etiqueta donde se muestra la foto de perfil seleccionada. */
	private JLabel lblFotoPerfil;

	/** Botón alternativo para abrir el selector de imágenes. */
	private JButton btnSeleccionarFoto;

	/** Archivo de imagen actualmente seleccionado. */
	private File archivoImagenSeleccionada;

	/** Imagen cargada en memoria correspondiente a la foto de perfil. */
	private BufferedImage imagenActual;

	// Etiquetas descriptivas de campos
	private JLabel lblNombre, lblApellido, lblAlias, lblEmail, lblFechaNacimiento, lblContrasenia,
			lblConfirmarContrasenia;

	// Campos de texto y contraseñas
	private JTextField txtNombre, txtApellido, txtAlias, txtEmail, txtFechaNacimiento;
	private JPasswordField jpfContrasenia, jpfConfirmarContrasenia;

	/** Botón para registrar el usuario. */
	private JButton btnRegistrar;

	/** Botón para cancelar el registro. */
	private JButton btnCancelar;

	/** Selector de archivos usado para elegir la imagen de perfil. */
	private JFileChooser fileChooser;

	/**
	 * Crea un nuevo panel de registro, inicializando todos los componentes gráficos
	 * y configurando su estilo visual.
	 */
	public PanelRegistro() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa y configura todos los componentes del panel, incluyendo etiquetas,
	 * campos de texto, botones y el selector de imagen.
	 */
	private void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(440, 30, 400, 150);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 36));
		;
		lblFondo.setForeground(Color.WHITE);

		lblFotoPerfil = new JLabel();
		lblFotoPerfil.setBounds(50, 30, 120, 120);
		lblFotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoPerfil.setVerticalAlignment(SwingConstants.CENTER);
		lblFotoPerfil.setText("<html><center>Click para<br>seleccionar<br>foto</center></html>");
		lblFotoPerfil.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 11));
		lblFotoPerfil.setForeground(Color.WHITE);
		lblFotoPerfil.setOpaque(true);
		lblFotoPerfil.setBackground(new Color(255, 255, 255, 100));
		lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lblFotoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));

		lblFotoPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarImagen();
			}
		});

		btnSeleccionarFoto = new JButton();
		btnSeleccionarFoto.setBounds(50, 160, 120, 30);
		btnSeleccionarFoto.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 12));
		btnSeleccionarFoto.setBackground(Color.decode("#9B59B6"));
		btnSeleccionarFoto.setForeground(Color.WHITE);
		btnSeleccionarFoto.setFocusPainted(false);
		btnSeleccionarFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionarFoto.addActionListener(e -> seleccionarImagen());

		lblNombre = new JLabel();
		lblNombre.setBounds(200, 220, 340, 20);
		lblNombre.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);

		txtNombre = new JTextField();
		txtNombre.setBounds(200, 245, 340, 35);
		txtNombre.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblApellido = new JLabel();
		lblApellido.setBounds(200, 295, 340, 20);
		lblApellido.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);

		txtApellido = new JTextField();
		txtApellido.setBounds(200, 320, 340, 35);
		txtApellido.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblAlias = new JLabel();
		lblAlias.setBounds(200, 370, 340, 20);
		lblAlias.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblAlias.setForeground(Color.WHITE);

		txtAlias = new JTextField();
		txtAlias.setBounds(200, 395, 340, 35);
		txtAlias.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblEmail = new JLabel();
		lblEmail.setBounds(200, 445, 340, 20);
		lblEmail.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEmail.setForeground(Color.WHITE);

		txtEmail = new JTextField();
		txtEmail = new JTextField();
		txtEmail.setBounds(200, 470, 340, 35);
		txtEmail.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblFechaNacimiento = new JLabel();
		lblFechaNacimiento.setBounds(200, 520, 340, 20);
		lblFechaNacimiento.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblFechaNacimiento.setForeground(Color.WHITE);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(200, 545, 340, 35);
		txtFechaNacimiento.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));
		txtFechaNacimiento.setToolTipText("Formato: dd/mm/aaaa");

		lblContrasenia = new JLabel();
		lblContrasenia.setBounds(740, 220, 340, 20);
		lblContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblContrasenia.setForeground(Color.WHITE);

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(740, 245, 340, 35);
		jpfContrasenia.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblConfirmarContrasenia = new JLabel();
		lblConfirmarContrasenia.setBounds(740, 295, 340, 20);
		lblConfirmarContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblConfirmarContrasenia.setForeground(Color.WHITE);

		jpfConfirmarContrasenia = new JPasswordField();
		jpfConfirmarContrasenia.setBounds(740, 320, 340, 35);
		jpfConfirmarContrasenia.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		btnRegistrar = new JButton();
		btnRegistrar.setBounds(440, 640, 180, 45);
		btnRegistrar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.decode("#4CAF50"));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancelar = new JButton();
		btnCancelar.setBounds(660, 640, 180, 45);
		btnCancelar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnCancelar.setBackground(Color.decode("#F54927"));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png"));

		this.add(lblFondo);

		this.add(lblFotoPerfil);
		this.add(btnSeleccionarFoto);

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

		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(lblConfirmarContrasenia);
		this.add(jpfConfirmarContrasenia);

		this.add(btnRegistrar);
		this.add(btnCancelar);
	}

	/**
	 * Abre un cuadro de diálogo para seleccionar una imagen de perfil. Si el
	 * usuario confirma, se carga la vista previa de la imagen.
	 */
	private void seleccionarImagen() {
		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			archivoImagenSeleccionada = fileChooser.getSelectedFile();
			cargarVistaPrevia(archivoImagenSeleccionada);
		}
	}

	/**
	 * Carga y muestra una vista previa de la imagen seleccionada.
	 * 
	 * @param archivo archivo de imagen seleccionado por el usuario.
	 */
	private void cargarVistaPrevia(File archivo) {
		try {
			imagenActual = ImageIO.read(archivo);

			if (imagenActual != null) {

				Image imagenEscalada = escalarImagen(imagenActual, 120, 120);
				lblFotoPerfil.setIcon(new ImageIcon(imagenEscalada));
				lblFotoPerfil.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Escala una imagen manteniendo la proporción original dentro de los límites
	 * dados.
	 * 
	 * @param img       la imagen original.
	 * @param maxWidth  ancho máximo permitido.
	 * @param maxHeight alto máximo permitido.
	 * @return una versión escalada de la imagen.
	 */
	private Image escalarImagen(BufferedImage img, int maxWidth, int maxHeight) {
		int width = img.getWidth();
		int height = img.getHeight();

		double ratio = Math.min((double) maxWidth / width, (double) maxHeight / height);

		int newWidth = (int) (width * ratio);
		int newHeight = (int) (height * ratio);

		return img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	}

	/**
	 * Obtiene el archivo de imagen seleccionado por el usuario.
	 *
	 * @return el archivo de imagen actualmente seleccionado.
	 */
	public File getArchivoImagenSeleccionada() {
		return archivoImagenSeleccionada;
	}

	/**
	 * Obtiene la imagen cargada actualmente como foto de perfil.
	 *
	 * @return la imagen de perfil actual.
	 */
	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	/**
	 * Obtiene la etiqueta donde se muestra la foto de perfil.
	 *
	 * @return la etiqueta de la foto de perfil.
	 */
	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	/**
	 * Obtiene el botón que permite seleccionar una foto de perfil.
	 *
	 * @return el botón de selección de imagen.
	 */
	public JButton getBtnSeleccionarFoto() {
		return btnSeleccionarFoto;
	}

	/**
	 * Establece el archivo de imagen seleccionado y carga su vista previa.
	 *
	 * @param archivo el archivo de imagen a asignar.
	 */
	public void setArchivoImagenSeleccionada(File archivo) {
		this.archivoImagenSeleccionada = archivo;
		if (archivo != null) {
			cargarVistaPrevia(archivo);
		}
	}

	/**
	 * Establece la imagen del perfil y actualiza la vista previa.
	 *
	 * @param imagen la imagen a mostrar como foto de perfil.
	 */
	public void setImagenPerfil(BufferedImage imagen) {
		if (imagen != null) {
			this.imagenActual = imagen;
			Image imagenEscalada = escalarImagen(imagen, 120, 120);
			lblFotoPerfil.setIcon(new ImageIcon(imagenEscalada));
			lblFotoPerfil.setText("");
		}
	}

	/**
	 * Obtiene la etiqueta del fondo del panel.
	 *
	 * @return la etiqueta de fondo.
	 */
	public JLabel getLblFondo() {
		return lblFondo;
	}

	/**
	 * Asigna la etiqueta del fondo del panel.
	 *
	 * @param lblFondo la nueva etiqueta de fondo.
	 */
	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	/**
	 * Obtiene la etiqueta asociada al campo de nombre.
	 *
	 * @return la etiqueta de nombre.
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * Asigna la etiqueta asociada al campo de nombre.
	 *
	 * @param lblNombre la etiqueta de nombre a asignar.
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * Obtiene la etiqueta asociada al campo de apellido.
	 *
	 * @return la etiqueta de apellido.
	 */
	public JLabel getLblApellido() {
		return lblApellido;
	}

	/**
	 * Asigna la etiqueta asociada al campo de apellido.
	 *
	 * @param lblApellido la etiqueta de apellido a asignar.
	 */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	/**
	 * Obtiene la etiqueta asociada al campo de alias.
	 *
	 * @return la etiqueta de alias.
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/**
	 * Asigna la etiqueta asociada al campo de alias.
	 *
	 * @param lblAlias la etiqueta de alias a asignar.
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/**
	 * Obtiene la etiqueta asociada al campo de correo electrónico.
	 *
	 * @return la etiqueta de correo electrónico.
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * Asigna la etiqueta asociada al campo de correo electrónico.
	 *
	 * @param lblEmail la etiqueta de correo a asignar.
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * Obtiene la etiqueta del campo de fecha de nacimiento.
	 *
	 * @return la etiqueta de fecha de nacimiento.
	 */
	public JLabel getLblFechaNacimiento() {
		return lblFechaNacimiento;
	}

	/**
	 * Asigna la etiqueta del campo de fecha de nacimiento.
	 *
	 * @param lblFechaNacimiento la etiqueta a asignar.
	 */
	public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
		this.lblFechaNacimiento = lblFechaNacimiento;
	}

	/**
	 * Obtiene la etiqueta del campo de contraseña.
	 *
	 * @return la etiqueta de contraseña.
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/**
	 * Asigna la etiqueta del campo de contraseña.
	 *
	 * @param lblContrasenia la etiqueta de contraseña a asignar.
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/**
	 * Obtiene la etiqueta del campo de confirmación de contraseña.
	 *
	 * @return la etiqueta de confirmación de contraseña.
	 */
	public JLabel getLblConfirmarContrasenia() {
		return lblConfirmarContrasenia;
	}

	/**
	 * Asigna la etiqueta del campo de confirmación de contraseña.
	 *
	 * @param lblConfirmarContrasenia la etiqueta a asignar.
	 */
	public void setLblConfirmarContrasenia(JLabel lblConfirmarContrasenia) {
		this.lblConfirmarContrasenia = lblConfirmarContrasenia;
	}

	/**
	 * Obtiene el campo de texto del nombre.
	 *
	 * @return el campo de nombre.
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * Asigna el campo de texto del nombre.
	 *
	 * @param txtNombre el campo de nombre a asignar.
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	/**
	 * Obtiene el campo de texto del apellido.
	 *
	 * @return el campo de apellido.
	 */
	public JTextField getTxtApellido() {
		return txtApellido;
	}

	/**
	 * Asigna el campo de texto del apellido.
	 *
	 * @param txtApellido el campo de apellido a asignar.
	 */
	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	/**
	 * Obtiene el campo de texto del alias.
	 *
	 * @return el campo de alias.
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * Asigna el campo de texto del alias.
	 *
	 * @param txtAlias el campo de alias a asignar.
	 */
	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	/**
	 * Obtiene el campo de texto del correo electrónico.
	 *
	 * @return el campo de correo electrónico.
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * Asigna el campo de texto del correo electrónico.
	 *
	 * @param txtEmail el campo de correo a asignar.
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * Obtiene el campo de texto de la fecha de nacimiento.
	 *
	 * @return el campo de fecha de nacimiento.
	 */
	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}

	/**
	 * Asigna el campo de texto de la fecha de nacimiento.
	 *
	 * @param txtFechaNacimiento el campo de fecha de nacimiento a asignar.
	 */
	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}

	/**
	 * Obtiene el campo de contraseña.
	 *
	 * @return el campo de contraseña.
	 */
	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	/**
	 * Asigna el campo de contraseña.
	 *
	 * @param jpfContrasenia el campo de contraseña a asignar.
	 */
	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	/**
	 * Obtiene el campo de confirmación de contraseña.
	 *
	 * @return el campo de confirmación de contraseña.
	 */
	public JPasswordField getJpfConfirmarContrasenia() {
		return jpfConfirmarContrasenia;
	}

	/**
	 * Asigna el campo de confirmación de contraseña.
	 *
	 * @param jpfConfirmarContrasenia el campo de confirmación a asignar.
	 */
	public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
		this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
	}

	/**
	 * Obtiene el botón de registro.
	 *
	 * @return el botón de registrar usuario.
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	/**
	 * Asigna el botón de registro.
	 *
	 * @param btnRegistrar el botón de registro a asignar.
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}

	/**
	 * Obtiene el botón de cancelación del registro.
	 *
	 * @return el botón de cancelar.
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * Asigna el botón de cancelación del registro.
	 *
	 * @param btnCancelar el botón de cancelar a asignar.
	 */
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/**
	 * Obtiene el selector de archivos utilizado para las imágenes de perfil.
	 *
	 * @return el selector de archivos {@link JFileChooser}.
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * Asigna un nuevo selector de archivos para la selección de imágenes.
	 *
	 * @param fileChooser el nuevo selector de archivos a asignar.
	 */
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

}