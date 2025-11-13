package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Panel que representa la vista del perfil de usuario masculino.
 * 
 * <p>
 * Este panel permite visualizar y modificar la información personal,
 * configuración y preferencias del usuario hombre. Además, incluye la opción de
 * cargar una imagen de perfil desde el sistema de archivos.
 * </p>
 * 
 * <p>
 * Los componentes se dividen en columnas: una para los datos personales
 * (nombre, apellido, alias, etc.) y otra para la configuración (contraseña,
 * estatura, ingresos, edades y preferencias).
 * </p>
 * 
 * <p>
 * También dispone de botones para actualizar la información, cancelar los
 * cambios, cerrar sesión o eliminar la cuenta.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelPerfilHombre extends JPanel {

	/**
	 * Etiqueta de fondo del panel o ventana del administrador.
	 */
	private JLabel lblFondo;

	/**
	 * Etiqueta que muestra la foto de perfil del usuario administrador.
	 */
	private JLabel lblFotoPerfil;

	/**
	 * Botón que permite seleccionar una nueva foto de perfil desde el sistema de
	 * archivos.
	 */
	private JButton btnSeleccionarFoto;

	/**
	 * Archivo seleccionado por el usuario para cambiar la imagen de perfil.
	 */
	private File archivoImagenSeleccionada;

	/**
	 * Imagen actualmente mostrada en el perfil del usuario.
	 */
	private BufferedImage imagenActual;

	/**
	 * Etiqueta con el texto "Nombre".
	 */
	private JLabel lblNombre;

	/**
	 * Etiqueta que muestra el nombre del usuario.
	 */
	private JLabel lblNombreUsuario;

	/**
	 * Etiqueta con el texto "Apellido".
	 */
	private JLabel lblApellido;

	/**
	 * Etiqueta que muestra el apellido del usuario.
	 */
	private JLabel lblApellidoUsuario;

	/**
	 * Etiqueta con el texto "Alias".
	 */
	private JLabel lblAlias;

	/**
	 * Etiqueta con el texto "Correo electrónico".
	 */
	private JLabel lblEmail;

	/**
	 * Etiqueta que muestra el correo electrónico del usuario.
	 */
	private JLabel lblEmailUsuario;

	/**
	 * Etiqueta con el texto "Edad".
	 */
	private JLabel lblEdad;

	/**
	 * Etiqueta que muestra la edad del usuario.
	 */
	private JLabel lblEdadUsuario;

	/**
	 * Etiqueta con el texto "Contraseña".
	 */
	private JLabel lblContrasenia;

	/**
	 * Etiqueta con el texto "Confirmar contraseña".
	 */
	private JLabel lblConfirmarContrasenia;

	/**
	 * Etiqueta con el texto "Estatura".
	 */
	private JLabel lblEstatura;

	/**
	 * Etiqueta con el texto "Ingresos mensuales".
	 */
	private JLabel lblIngresosMensuales;

	/**
	 * Etiqueta con el texto "Edad mínima".
	 */
	private JLabel lblEdadMinima;

	/**
	 * Etiqueta con el texto "Edad máxima".
	 */
	private JLabel lblEdadMaxima;

	/**
	 * Campo de texto donde el usuario puede ingresar o modificar su alias.
	 */
	private JTextField txtAlias;

	/**
	 * Campo de contraseña donde el usuario ingresa su nueva contraseña.
	 */
	private JPasswordField jpfContrasenia;

	/**
	 * Campo de contraseña para confirmar la nueva contraseña ingresada.
	 */
	private JPasswordField jpfConfirmarContrasenia;

	/**
	 * Campo de texto donde el usuario ingresa su estatura.
	 */
	private JTextField txtEstatura;

	/**
	 * Campo de texto donde el usuario ingresa sus ingresos mensuales.
	 */
	private JTextField txtIngresosMensuales;

	/**
	 * Campo de texto donde el usuario establece su edad mínima de preferencia.
	 */
	private JTextField txtEdadMinima;

	/**
	 * Campo de texto donde el usuario establece su edad máxima de preferencia.
	 */
	private JTextField txtEdadMaxima;

	/**
	 * Casilla de verificación que indica si el perfil del usuario es visible o no.
	 */
	private JCheckBox chkVisibilidad;

	/**
	 * Casilla de verificación que indica si el usuario acepta personas divorciadas
	 * como preferencia.
	 */
	private JCheckBox chkDivorcioPreferencia;

	/**
	 * Botón para actualizar los datos del perfil.
	 */
	private JButton btnActualizar;

	/**
	 * Botón para cancelar los cambios realizados.
	 */
	private JButton btnCancelar;

	/**
	 * Botón para cerrar la sesión actual del usuario.
	 */
	private JButton btnCerrarSesion;

	/**
	 * Botón para eliminar la cuenta del usuario.
	 */
	private JButton btnEliminarCuenta;

	/**
	 * Selector de archivos usado para elegir imágenes del sistema.
	 */
	private JFileChooser fileChooser;

	/**
	 * Crea el panel de perfil masculino y establece su estructura visual.
	 * <p>
	 * Se configura el diseño, tamaño, visibilidad y se inicializan todos los
	 * componentes.
	 * </p>
	 */
	public PanelPerfilHombre() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa todos los componentes gráficos del panel.
	 * <p>
	 * Organiza etiquetas, campos de texto, botones, checkboxes y el área de imagen
	 * de perfil.
	 * </p>
	 */
	private void inicializarComponentes() {
		lblFondo = new JLabel();
		lblFondo.setBounds(440, 30, 400, 150);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 32));
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

		btnSeleccionarFoto = new JButton("Cambiar Foto");
		btnSeleccionarFoto.setBounds(50, 160, 120, 30);
		btnSeleccionarFoto.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 12));
		btnSeleccionarFoto.setBackground(Color.decode("#9B59B6"));
		btnSeleccionarFoto.setForeground(Color.WHITE);
		btnSeleccionarFoto.setFocusPainted(false);
		btnSeleccionarFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionarFoto.addActionListener(e -> seleccionarImagen());

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(200, 220, 340, 20);
		lblNombre.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);

		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(200, 245, 340, 35);
		lblNombreUsuario.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setOpaque(true);
		lblNombreUsuario.setBackground(new Color(255, 255, 255, 100));
		lblNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(200, 295, 340, 20);
		lblApellido.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);

		lblApellidoUsuario = new JLabel();
		lblApellidoUsuario.setBounds(200, 320, 340, 35);
		lblApellidoUsuario.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));
		lblApellidoUsuario.setForeground(Color.WHITE);
		lblApellidoUsuario.setOpaque(true);
		lblApellidoUsuario.setBackground(new Color(255, 255, 255, 100));
		lblApellidoUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(200, 370, 340, 20);
		lblAlias.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblAlias.setForeground(Color.WHITE);

		txtAlias = new JTextField();
		txtAlias.setBounds(200, 395, 340, 35);
		txtAlias.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(200, 445, 340, 20);
		lblEmail.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEmail.setForeground(Color.WHITE);

		lblEmailUsuario = new JLabel();
		lblEmailUsuario.setBounds(200, 470, 340, 35);
		lblEmailUsuario.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));
		lblEmailUsuario.setForeground(Color.WHITE);
		lblEmailUsuario.setOpaque(true);
		lblEmailUsuario.setBackground(new Color(255, 255, 255, 100));
		lblEmailUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(200, 520, 340, 20);
		lblEdad.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEdad.setForeground(Color.WHITE);

		lblEdadUsuario = new JLabel();
		lblEdadUsuario.setBounds(200, 545, 340, 35);
		lblEdadUsuario.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));
		lblEdadUsuario.setForeground(Color.WHITE);
		lblEdadUsuario.setOpaque(true);
		lblEdadUsuario.setBackground(new Color(255, 255, 255, 100));
		lblEdadUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		lblContrasenia = new JLabel("Nueva Contraseña:");
		lblContrasenia.setBounds(740, 220, 340, 20);
		lblContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblContrasenia.setForeground(Color.WHITE);

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(740, 245, 340, 35);
		jpfContrasenia.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblConfirmarContrasenia = new JLabel("Confirmar Contraseña:");
		lblConfirmarContrasenia.setBounds(740, 295, 340, 20);
		lblConfirmarContrasenia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblConfirmarContrasenia.setForeground(Color.WHITE);

		jpfConfirmarContrasenia = new JPasswordField();
		jpfConfirmarContrasenia.setBounds(740, 320, 340, 35);
		jpfConfirmarContrasenia.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblEstatura = new JLabel("Estatura (cm):");
		lblEstatura.setBounds(740, 370, 160, 20);
		lblEstatura.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEstatura.setForeground(Color.WHITE);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(740, 395, 160, 35);
		txtEstatura.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblIngresosMensuales = new JLabel("Ingresos ($):");
		lblIngresosMensuales.setBounds(920, 370, 160, 20);
		lblIngresosMensuales.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblIngresosMensuales.setForeground(Color.WHITE);

		txtIngresosMensuales = new JTextField();
		txtIngresosMensuales.setBounds(920, 395, 160, 35);
		txtIngresosMensuales.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblEdadMinima = new JLabel("Edad Mínima:");
		lblEdadMinima.setBounds(740, 445, 160, 20);
		lblEdadMinima.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEdadMinima.setForeground(Color.WHITE);

		txtEdadMinima = new JTextField();
		txtEdadMinima.setBounds(740, 470, 160, 35);
		txtEdadMinima.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		lblEdadMaxima = new JLabel("Edad Máxima:");
		lblEdadMaxima.setBounds(920, 445, 160, 20);
		lblEdadMaxima.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEdadMaxima.setForeground(Color.WHITE);

		txtEdadMaxima = new JTextField();
		txtEdadMaxima.setBounds(920, 470, 160, 35);
		txtEdadMaxima.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

		chkVisibilidad = new JCheckBox("Perfil visible para otros usuarios");
		chkVisibilidad.setBounds(740, 520, 340, 30);
		chkVisibilidad.setOpaque(false);
		chkVisibilidad.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		chkVisibilidad.setForeground(Color.WHITE);

		chkDivorcioPreferencia = new JCheckBox("Divorciadas");
		chkDivorcioPreferencia.setBounds(740, 560, 340, 30);
		chkDivorcioPreferencia.setOpaque(false);
		chkDivorcioPreferencia.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		chkDivorcioPreferencia.setForeground(Color.WHITE);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(220, 640, 180, 45);
		btnActualizar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnActualizar.setBackground(Color.decode("#4CAF50"));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFocusPainted(false);
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(440, 640, 180, 45);
		btnCancelar.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnCancelar.setBackground(Color.decode("#F44336"));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setBounds(660, 640, 180, 45);
		btnCerrarSesion.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnCerrarSesion.setBackground(Color.decode("#F44336"));
		btnCerrarSesion.setForeground(Color.WHITE);
		btnCerrarSesion.setFocusPainted(false);
		btnCerrarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnEliminarCuenta = new JButton("Eliminar Cuenta");
		btnEliminarCuenta.setBounds(880, 640, 180, 45);
		btnEliminarCuenta.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 16));
		btnEliminarCuenta.setBackground(Color.decode("#F44336"));
		btnEliminarCuenta.setForeground(Color.WHITE);
		btnEliminarCuenta.setFocusPainted(false);
		btnEliminarCuenta.setCursor(new Cursor(Cursor.HAND_CURSOR));

		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png"));

		this.add(lblFondo);

		this.add(lblFotoPerfil);
		this.add(btnSeleccionarFoto);

		this.add(lblNombre);
		this.add(lblNombreUsuario);
		this.add(lblApellido);
		this.add(lblApellidoUsuario);
		this.add(lblAlias);
		this.add(txtAlias);
		this.add(lblEmail);
		this.add(lblEmailUsuario);
		this.add(lblEdad);
		this.add(lblEdadUsuario);

		this.add(lblContrasenia);
		this.add(jpfContrasenia);
		this.add(lblConfirmarContrasenia);
		this.add(jpfConfirmarContrasenia);
		this.add(lblEstatura);
		this.add(txtEstatura);
		this.add(lblIngresosMensuales);
		this.add(txtIngresosMensuales);
		this.add(lblEdadMinima);
		this.add(txtEdadMinima);
		this.add(lblEdadMaxima);
		this.add(txtEdadMaxima);
		this.add(chkVisibilidad);
		this.add(chkDivorcioPreferencia);

		this.add(btnActualizar);
		this.add(btnCancelar);
		this.add(btnCerrarSesion);
		this.add(btnEliminarCuenta);
	}

	/**
	 * Abre un cuadro de diálogo para seleccionar una imagen desde el sistema de
	 * archivos.
	 * <p>
	 * Si el usuario selecciona una imagen válida, se muestra una vista previa en el
	 * panel.
	 * </p>
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
	 * @param archivo archivo de imagen seleccionado por el usuario
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
	 * Escala una imagen manteniendo su proporción para ajustarla al tamaño
	 * indicado.
	 * 
	 * @param img       la imagen original
	 * @param maxWidth  ancho máximo permitido
	 * @param maxHeight alto máximo permitido
	 * @return la imagen escalada para adaptarse al espacio disponible
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
	 * Devuelve el archivo de imagen seleccionado por el usuario.
	 * 
	 * @return archivo de imagen seleccionado
	 */
	public File getArchivoImagenSeleccionada() {
		return archivoImagenSeleccionada;
	}

	/**
	 * Devuelve la imagen actualmente cargada como perfil.
	 * 
	 * @return imagen actual del perfil
	 */
	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	/**
	 * Obtiene la etiqueta que muestra la foto de perfil del usuario.
	 * 
	 * @return JLabel correspondiente a la foto de perfil.
	 */
	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	/**
	 * Obtiene el botón que permite seleccionar una nueva foto de perfil.
	 * 
	 * @return JButton utilizado para seleccionar una foto de perfil.
	 */
	public JButton getBtnSeleccionarFoto() {
		return btnSeleccionarFoto;
	}

	/**
	 * Establece el archivo de imagen seleccionado por el usuario y actualiza la
	 * vista previa. Si el archivo no es nulo, se carga la imagen seleccionada en el
	 * componente visual correspondiente.
	 *
	 * @param archivo Archivo de imagen seleccionado por el usuario.
	 */
	public void setArchivoImagenSeleccionada(File archivo) {
		this.archivoImagenSeleccionada = archivo;
		if (archivo != null) {
			cargarVistaPrevia(archivo);
		}
	}

	/**
	 * Establece una nueva imagen de perfil y actualiza la vista previa.
	 * 
	 * @param imagen imagen a mostrar como foto de perfil
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
	 * Obtiene la etiqueta de fondo del panel o ventana.
	 * 
	 * @return JLabel correspondiente al fondo.
	 */
	public JLabel getLblFondo() {
		return lblFondo;
	}

	/**
	 * Establece la etiqueta de fondo del panel o ventana.
	 * 
	 * @param lblFondo JLabel que se usará como fondo.
	 */
	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	/**
	 * Obtiene la etiqueta del texto "Nombre".
	 * 
	 * @return JLabel del nombre.
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * Asigna la etiqueta del texto "Nombre".
	 * 
	 * @param lblNombre JLabel del nombre.
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * Obtiene la etiqueta que muestra el nombre del usuario.
	 * 
	 * @return JLabel con el nombre del usuario.
	 */
	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	/**
	 * Asigna la etiqueta que muestra el nombre del usuario.
	 * 
	 * @param lblNombreUsuario JLabel con el nombre del usuario.
	 */
	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	/**
	 * Obtiene la etiqueta del texto "Apellido".
	 * 
	 * @return JLabel del apellido.
	 */
	public JLabel getLblApellido() {
		return lblApellido;
	}

	/**
	 * Asigna la etiqueta del texto "Apellido".
	 * 
	 * @param lblApellido JLabel del apellido.
	 */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	/**
	 * Obtiene la etiqueta que muestra el apellido del usuario.
	 * 
	 * @return JLabel con el apellido del usuario.
	 */
	public JLabel getLblApellidoUsuario() {
		return lblApellidoUsuario;
	}

	/**
	 * Asigna la etiqueta que muestra el apellido del usuario.
	 * 
	 * @param lblApellidoUsuario JLabel con el apellido del usuario.
	 */
	public void setLblApellidoUsuario(JLabel lblApellidoUsuario) {
		this.lblApellidoUsuario = lblApellidoUsuario;
	}

	/**
	 * Obtiene la etiqueta del texto "Alias".
	 * 
	 * @return JLabel del alias.
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/**
	 * Asigna la etiqueta del texto "Alias".
	 * 
	 * @param lblAlias JLabel del alias.
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/**
	 * Obtiene la etiqueta del texto "Correo electrónico".
	 * 
	 * @return JLabel del correo.
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * Asigna la etiqueta del texto "Correo electrónico".
	 * 
	 * @param lblEmail JLabel del correo.
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * Obtiene la etiqueta que muestra el correo electrónico del usuario.
	 * 
	 * @return JLabel con el correo del usuario.
	 */
	public JLabel getLblEmailUsuario() {
		return lblEmailUsuario;
	}

	/**
	 * Asigna la etiqueta que muestra el correo electrónico del usuario.
	 * 
	 * @param lblEmailUsuario JLabel con el correo del usuario.
	 */
	public void setLblEmailUsuario(JLabel lblEmailUsuario) {
		this.lblEmailUsuario = lblEmailUsuario;
	}

	/**
	 * Obtiene la etiqueta del texto "Edad".
	 * 
	 * @return JLabel de la edad.
	 */
	public JLabel getLblEdad() {
		return lblEdad;
	}

	/**
	 * Asigna la etiqueta del texto "Edad".
	 * 
	 * @param lblEdad JLabel de la edad.
	 */
	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	/**
	 * Obtiene la etiqueta que muestra la edad del usuario.
	 * 
	 * @return JLabel con la edad del usuario.
	 */
	public JLabel getLblEdadUsuario() {
		return lblEdadUsuario;
	}

	/**
	 * Asigna la etiqueta que muestra la edad del usuario.
	 * 
	 * @param lblEdadUsuario JLabel con la edad del usuario.
	 */
	public void setLblEdadUsuario(JLabel lblEdadUsuario) {
		this.lblEdadUsuario = lblEdadUsuario;
	}

	/**
	 * Obtiene la etiqueta del texto "Contraseña".
	 * 
	 * @return JLabel de la contraseña.
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/**
	 * Asigna la etiqueta del texto "Contraseña".
	 * 
	 * @param lblContrasenia JLabel de la contraseña.
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/**
	 * Obtiene la etiqueta del texto "Confirmar contraseña".
	 * 
	 * @return JLabel de confirmación de contraseña.
	 */
	public JLabel getLblConfirmarContrasenia() {
		return lblConfirmarContrasenia;
	}

	/**
	 * Asigna la etiqueta del texto "Confirmar contraseña".
	 * 
	 * @param lblConfirmarContrasenia JLabel de confirmación de contraseña.
	 */
	public void setLblConfirmarContrasenia(JLabel lblConfirmarContrasenia) {
		this.lblConfirmarContrasenia = lblConfirmarContrasenia;
	}

	/**
	 * Obtiene la etiqueta del texto "Estatura".
	 * 
	 * @return JLabel de la estatura.
	 */
	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	/**
	 * Asigna la etiqueta del texto "Estatura".
	 * 
	 * @param lblEstatura JLabel de la estatura.
	 */
	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	/**
	 * Obtiene la etiqueta del texto "Ingresos mensuales".
	 * 
	 * @return JLabel de ingresos mensuales.
	 */
	public JLabel getLblIngresosMensuales() {
		return lblIngresosMensuales;
	}

	/**
	 * Asigna la etiqueta del texto "Ingresos mensuales".
	 * 
	 * @param lblIngresosMensuales JLabel de ingresos mensuales.
	 */
	public void setLblIngresosMensuales(JLabel lblIngresosMensuales) {
		this.lblIngresosMensuales = lblIngresosMensuales;
	}

	/**
	 * Obtiene la etiqueta del texto "Edad mínima".
	 * 
	 * @return JLabel de edad mínima.
	 */
	public JLabel getLblEdadMinima() {
		return lblEdadMinima;
	}

	/**
	 * Asigna la etiqueta del texto "Edad mínima".
	 * 
	 * @param lblEdadMinima JLabel de edad mínima.
	 */
	public void setLblEdadMinima(JLabel lblEdadMinima) {
		this.lblEdadMinima = lblEdadMinima;
	}

	/**
	 * Obtiene la etiqueta del texto "Edad máxima".
	 * 
	 * @return JLabel de edad máxima.
	 */
	public JLabel getLblEdadMaxima() {
		return lblEdadMaxima;
	}

	/**
	 * Asigna la etiqueta del texto "Edad máxima".
	 * 
	 * @param lblEdadMaxima JLabel de edad máxima.
	 */
	public void setLblEdadMaxima(JLabel lblEdadMaxima) {
		this.lblEdadMaxima = lblEdadMaxima;
	}

	/**
	 * Obtiene el campo de texto del alias del usuario.
	 * 
	 * @return JTextField del alias.
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * Asigna el campo de texto del alias del usuario.
	 * 
	 * @param txtAlias JTextField del alias.
	 */
	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	/**
	 * Obtiene el campo de la contraseña.
	 * 
	 * @return JPasswordField de la contraseña.
	 */
	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	/**
	 * Asigna el campo de la contraseña.
	 * 
	 * @param jpfContrasenia JPasswordField de la contraseña.
	 */
	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	/**
	 * Obtiene el campo de confirmación de contraseña.
	 * 
	 * @return JPasswordField de confirmación.
	 */
	public JPasswordField getJpfConfirmarContrasenia() {
		return jpfConfirmarContrasenia;
	}

	/**
	 * Asigna el campo de confirmación de contraseña.
	 * 
	 * @param jpfConfirmarContrasenia JPasswordField de confirmación.
	 */
	public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
		this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
	}

	/**
	 * Obtiene el campo de texto de la estatura.
	 * 
	 * @return JTextField de estatura.
	 */
	public JTextField getTxtEstatura() {
		return txtEstatura;
	}

	/**
	 * Asigna el campo de texto de la estatura.
	 * 
	 * @param txtEstatura JTextField de estatura.
	 */
	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	/**
	 * Obtiene el campo de texto de los ingresos mensuales.
	 * 
	 * @return JTextField de ingresos mensuales.
	 */
	public JTextField getTxtIngresosMensuales() {
		return txtIngresosMensuales;
	}

	/**
	 * Asigna el campo de texto de los ingresos mensuales.
	 * 
	 * @param txtIngresosMensuales JTextField de ingresos mensuales.
	 */
	public void setTxtIngresosMensuales(JTextField txtIngresosMensuales) {
		this.txtIngresosMensuales = txtIngresosMensuales;
	}

	/**
	 * Obtiene el campo de texto de edad mínima preferida.
	 * 
	 * @return JTextField de edad mínima.
	 */
	public JTextField getTxtEdadMinima() {
		return txtEdadMinima;
	}

	/**
	 * Asigna el campo de texto de edad mínima preferida.
	 * 
	 * @param txtEdadMinima JTextField de edad mínima.
	 */
	public void setTxtEdadMinima(JTextField txtEdadMinima) {
		this.txtEdadMinima = txtEdadMinima;
	}

	/**
	 * Obtiene el campo de texto de edad máxima preferida.
	 * 
	 * @return JTextField de edad máxima.
	 */
	public JTextField getTxtEdadMaxima() {
		return txtEdadMaxima;
	}

	/**
	 * Asigna el campo de texto de edad máxima preferida.
	 * 
	 * @param txtEdadMaxima JTextField de edad máxima.
	 */
	public void setTxtEdadMaxima(JTextField txtEdadMaxima) {
		this.txtEdadMaxima = txtEdadMaxima;
	}

	/**
	 * Obtiene la casilla de visibilidad del perfil.
	 * 
	 * @return JCheckBox de visibilidad.
	 */
	public JCheckBox getChkVisibilidad() {
		return chkVisibilidad;
	}

	/**
	 * Asigna la casilla de visibilidad del perfil.
	 * 
	 * @param chkVisibilidad JCheckBox de visibilidad.
	 */
	public void setChkVisibilidad(JCheckBox chkVisibilidad) {
		this.chkVisibilidad = chkVisibilidad;
	}

	/**
	 * Obtiene la casilla de preferencia sobre divorcio.
	 * 
	 * @return JCheckBox de divorcio.
	 */
	public JCheckBox getChkDivorcioPreferencia() {
		return chkDivorcioPreferencia;
	}

	/**
	 * Asigna la casilla de preferencia sobre divorcio.
	 * 
	 * @param chkDivorcioPreferencia JCheckBox de divorcio.
	 */
	public void setChkDivorcioPreferencia(JCheckBox chkDivorcioPreferencia) {
		this.chkDivorcioPreferencia = chkDivorcioPreferencia;
	}

	/**
	 * Obtiene el botón para actualizar los datos del perfil.
	 * 
	 * @return JButton de actualización.
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * Asigna el botón para actualizar los datos del perfil.
	 * 
	 * @param btnActualizar JButton de actualización.
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	/**
	 * Obtiene el botón para cancelar los cambios realizados.
	 * 
	 * @return JButton de cancelación.
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * Asigna el botón para cancelar los cambios realizados.
	 * 
	 * @param btnCancelar JButton de cancelación.
	 */
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/**
	 * Obtiene el selector de archivos usado para elegir imágenes.
	 * 
	 * @return JFileChooser de imágenes.
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * Asigna el selector de archivos usado para elegir imágenes.
	 * 
	 * @param fileChooser JFileChooser de imágenes.
	 */
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * Asigna la etiqueta que muestra la foto de perfil.
	 * 
	 * @param lblFotoPerfil JLabel de la foto de perfil.
	 */
	public void setLblFotoPerfil(JLabel lblFotoPerfil) {
		this.lblFotoPerfil = lblFotoPerfil;
	}

	/**
	 * Asigna el botón que permite seleccionar una foto de perfil.
	 * 
	 * @param btnSeleccionarFoto JButton de selección de foto.
	 */
	public void setBtnSeleccionarFoto(JButton btnSeleccionarFoto) {
		this.btnSeleccionarFoto = btnSeleccionarFoto;
	}

	/**
	 * Asigna la imagen actualmente mostrada en el perfil.
	 * 
	 * @param imagenActual BufferedImage de la imagen actual.
	 */
	public void setImagenActual(BufferedImage imagenActual) {
		this.imagenActual = imagenActual;
	}

	/**
	 * Obtiene el botón para cerrar sesión.
	 * 
	 * @return JButton de cierre de sesión.
	 */
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	/**
	 * Asigna el botón para cerrar sesión.
	 * 
	 * @param btnCerrarSesion JButton de cierre de sesión.
	 */
	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	/**
	 * Obtiene el botón para eliminar la cuenta.
	 * 
	 * @return JButton de eliminación de cuenta.
	 */
	public JButton getBtnEliminarCuenta() {
		return btnEliminarCuenta;
	}

	/**
	 * Asigna el botón para eliminar la cuenta.
	 * 
	 * @param btnEliminarCuenta JButton de eliminación de cuenta.
	 */
	public void setBtnEliminarCuenta(JButton btnEliminarCuenta) {
		this.btnEliminarCuenta = btnEliminarCuenta;
	}

}