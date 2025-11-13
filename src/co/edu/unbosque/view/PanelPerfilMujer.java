package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * La clase {@code PanelPerfilMujer} representa la interfaz gráfica del perfil
 * de una usuaria dentro de la aplicación. Permite visualizar y actualizar
 * información personal como nombre, apellido, alias, edad, estatura, correo
 * electrónico, preferencias de visibilidad, y estado civil. Además, ofrece la
 * opción de cambiar la foto de perfil.
 * <p>
 * Este panel forma parte del paquete {@code co.edu.unbosque.view} y utiliza
 * componentes de Swing para construir una interfaz amigable y personalizable.
 * </p>
 *
 * <h3>Características principales:</h3>
 * <ul>
 * <li>Permite cargar y mostrar una imagen de perfil desde el sistema de
 * archivos.</li>
 * <li>Contiene campos de texto y etiquetas para mostrar información del
 * usuario.</li>
 * <li>Incluye botones para actualizar, cancelar, cerrar sesión o eliminar la
 * cuenta.</li>
 * <li>Soporta validación de imagen y vista previa al seleccionar un
 * archivo.</li>
 * </ul>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelPerfilMujer extends JPanel {

	/** Etiqueta de fondo decorativo del panel. */
	private JLabel lblFondo;

	/** Etiqueta que muestra la foto de perfil de la usuaria. */
	private JLabel lblFotoPerfil;

	/** Botón que permite seleccionar una nueva foto de perfil. */
	private JButton btnSeleccionarFoto;

	/** Archivo de imagen seleccionado por la usuaria. */
	private File archivoImagenSeleccionada;

	/** Imagen cargada actualmente en memoria para mostrar en el perfil. */
	private BufferedImage imagenActual;

	/** Etiqueta que muestra el texto “Nombre:”. */
	private JLabel lblNombre;

	/** Etiqueta que muestra el nombre real de la usuaria. */
	private JLabel lblNombreUsuario;

	/** Etiqueta que muestra el texto “Apellido:”. */
	private JLabel lblApellido;

	/** Etiqueta que muestra el apellido real de la usuaria. */
	private JLabel lblApellidoUsuario;

	/** Etiqueta que muestra el texto “Alias:”. */
	private JLabel lblAlias;

	/** Etiqueta que muestra el texto “Email:”. */
	private JLabel lblEmail;

	/** Etiqueta que muestra el correo electrónico de la usuaria. */
	private JLabel lblEmailUsuario;

	/** Etiqueta que muestra el texto “Edad:”. */
	private JLabel lblEdad;

	/** Etiqueta que muestra la edad actual de la usuaria. */
	private JLabel lblEdadUsuario;

	/** Etiqueta que indica el campo de nueva contraseña. */
	private JLabel lblContrasenia;

	/** Etiqueta que indica el campo de confirmación de contraseña. */
	private JLabel lblConfirmarContrasenia;

	/** Etiqueta que muestra el texto “Estatura (cm):”. */
	private JLabel lblEstatura;

	/** Etiqueta que muestra el texto “Estatura ideal (cm):”. */
	private JLabel lblEstaturaIdeal;

	/** Etiqueta que muestra el texto “Edad mínima:”. */
	private JLabel lblEdadMinima;

	/** Etiqueta que muestra el texto “Edad máxima:”. */
	private JLabel lblEdadMaxima;

	/** Campo para editar el alias de la usuaria. */
	private JTextField txtAlias;

	/** Campo para ingresar una nueva contraseña. */
	private JPasswordField jpfContrasenia;

	/** Campo para confirmar la nueva contraseña. */
	private JPasswordField jpfConfirmarContrasenia;

	/** Campo de texto para registrar la estatura de la usuaria. */
	private JTextField txtEstatura;

	/** Campo de texto para registrar la estatura ideal deseada. */
	private JTextField txtEstaturaIdeal;

	/** Campo de texto para registrar la edad mínima deseada en coincidencias. */
	private JTextField txtEdadMinima;

	/** Campo de texto para registrar la edad máxima deseada en coincidencias. */
	private JTextField txtEdadMaxima;

	/** Casilla para indicar si la usuaria es divorciada. */
	private JCheckBox chkDivorciada;

	/** Casilla que permite activar o desactivar la visibilidad del perfil. */
	private JCheckBox chkVisibilidad;

	/** Botón para guardar los cambios realizados en el perfil. */
	private JButton btnActualizar;

	/** Botón para cancelar los cambios. */
	private JButton btnCancelar;

	/** Botón para cerrar sesión. */
	private JButton btnCerrarSesion;

	/** Botón para eliminar la cuenta de la usuaria. */
	private JButton btnEliminarCuenta;

	/** Selector de archivos utilizado para elegir imágenes de perfil. */
	private JFileChooser fileChooser;

	/**
	 * Crea una nueva instancia del panel de perfil femenino. Inicializa el panel
	 * con tamaño, opacidad y visibilidad, y llama a
	 * {@link #inicializarComponentes()} para construir los elementos visuales.
	 */
	public PanelPerfilMujer() {
		this.setLayout(null);
		this.setSize(1280, 800);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa y configura todos los componentes del panel, incluyendo etiquetas,
	 * campos de texto, botones, casillas y el selector de archivos.
	 * 
	 * <p>
	 * También define los estilos, posiciones y acciones asociadas (como seleccionar
	 * una imagen de perfil o actualizar los datos).
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

		lblEstaturaIdeal = new JLabel("Estatura Ideal (cm):");
		lblEstaturaIdeal.setBounds(920, 370, 160, 20);
		lblEstaturaIdeal.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		lblEstaturaIdeal.setForeground(Color.WHITE);

		txtEstaturaIdeal = new JTextField();
		txtEstaturaIdeal.setBounds(920, 395, 160, 35);
		txtEstaturaIdeal.setFont(new Font("Noto Sans CJK SC", Font.PLAIN, 14));

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

		chkDivorciada = new JCheckBox();
		chkDivorciada.setBounds(740, 520, 220, 30);
		chkDivorciada.setOpaque(false);
		chkDivorciada.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		chkDivorciada.setForeground(Color.WHITE);

		chkVisibilidad = new JCheckBox("Perfil visible para otros usuarios");
		chkVisibilidad.setBounds(740, 560, 340, 30);
		chkVisibilidad.setOpaque(false);
		chkVisibilidad.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 14));
		chkVisibilidad.setForeground(Color.WHITE);
		chkVisibilidad.setSelected(true);

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
		this.add(lblEstaturaIdeal);
		this.add(txtEstaturaIdeal);
		this.add(lblEdadMinima);
		this.add(txtEdadMinima);
		this.add(lblEdadMaxima);
		this.add(txtEdadMaxima);
		this.add(chkDivorciada);
		this.add(chkVisibilidad);

		this.add(btnActualizar);
		this.add(btnCancelar);
		this.add(btnCerrarSesion);
		this.add(btnEliminarCuenta);
	}

	/**
	 * Abre un cuadro de diálogo de selección de archivos para permitir a la usuaria
	 * elegir una nueva imagen de perfil.
	 * 
	 * <p>
	 * Si la usuaria selecciona un archivo válido, este se almacena en
	 * {@code archivoImagenSeleccionada} y se muestra una vista previa en el JLabel
	 * correspondiente.
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
	 * Carga una vista previa de la imagen seleccionada en el componente de foto de
	 * perfil.
	 * 
	 * <p>
	 * La imagen se escala automáticamente al tamaño del recuadro (120x120 píxeles)
	 * y se muestra en el JLabel {@code lblFotoPerfil}. Si ocurre un error, se
	 * muestra un mensaje al usuario.
	 * </p>
	 * 
	 * @param archivo el archivo de imagen seleccionado por la usuaria.
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
	 * Escala una imagen a un tamaño máximo especificado, manteniendo su proporción.
	 * 
	 * @param img       la imagen a escalar.
	 * @param maxWidth  el ancho máximo permitido.
	 * @param maxHeight la altura máxima permitida.
	 * @return la imagen escalada con suavizado de calidad.
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
	 * Obtiene el archivo de imagen actualmente seleccionado por la usuaria.
	 *
	 * @return el archivo de imagen seleccionado, o {@code null} si no se ha elegido
	 *         ninguno.
	 */
	public File getArchivoImagenSeleccionada() {
		return archivoImagenSeleccionada;
	}

	/**
	 * Obtiene la imagen actualmente cargada en memoria (la imagen de perfil
	 * visible).
	 *
	 * @return el objeto {@link BufferedImage} correspondiente a la imagen actual, o
	 *         {@code null} si no se ha cargado ninguna imagen.
	 */
	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	/**
	 * Obtiene el componente gráfico que muestra la foto de perfil.
	 *
	 * @return el {@link JLabel} que contiene la imagen de perfil o el texto por
	 *         defecto.
	 */
	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	/**
	 * Obtiene el botón que permite seleccionar o cambiar la foto de perfil.
	 *
	 * @return el {@link JButton} asociado a la acción de selección de imagen.
	 */
	public JButton getBtnSeleccionarFoto() {
		return btnSeleccionarFoto;
	}

	/**
	 * Establece el archivo de imagen seleccionado y actualiza la vista previa del
	 * perfil.
	 *
	 * <p>
	 * Si el archivo no es nulo, se carga automáticamente en el componente visual
	 * llamando al método {@link #cargarVistaPrevia(File)}.
	 * </p>
	 *
	 * @param archivo el archivo de imagen a establecer como imagen seleccionada.
	 */
	public void setArchivoImagenSeleccionada(File archivo) {
		this.archivoImagenSeleccionada = archivo;
		if (archivo != null) {
			cargarVistaPrevia(archivo);
		}
	}

	/**
	 * Establece directamente una imagen como foto de perfil en memoria.
	 *
	 * <p>
	 * Escala la imagen al tamaño del recuadro (120x120 píxeles) y la asigna al
	 * componente {@code lblFotoPerfil}. Si la imagen es nula, no realiza ninguna
	 * acción.
	 * </p>
	 *
	 * @param imagen la imagen que se mostrará en el perfil.
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
	 * Obtiene el JLabel que representa el fondo del panel.
	 * 
	 * @return JLabel del fondo.
	 */
	public JLabel getLblFondo() {
		return lblFondo;
	}

	/**
	 * Obtiene la etiqueta del nombre.
	 * 
	 * @return JLabel del nombre.
	 */
	public JLabel getLblNombre() {
		return lblNombre;
	}

	/**
	 * Establece la etiqueta del nombre.
	 * 
	 * @param lblNombre JLabel a asignar.
	 */
	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	/**
	 * Obtiene la etiqueta del apellido.
	 * 
	 * @return JLabel del apellido.
	 */
	public JLabel getLblApellido() {
		return lblApellido;
	}

	/**
	 * Establece la etiqueta del apellido.
	 * 
	 * @param lblApellido JLabel a asignar.
	 */
	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	/**
	 * Obtiene la etiqueta del alias.
	 * 
	 * @return JLabel del alias.
	 */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/**
	 * Establece la etiqueta del alias.
	 * 
	 * @param lblAlias JLabel a asignar.
	 */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/**
	 * Obtiene la etiqueta del correo electrónico.
	 * 
	 * @return JLabel del correo.
	 */
	public JLabel getLblEmail() {
		return lblEmail;
	}

	/**
	 * Establece la etiqueta del correo electrónico.
	 * 
	 * @param lblEmail JLabel a asignar.
	 */
	public void setLblEmail(JLabel lblEmail) {
		this.lblEmail = lblEmail;
	}

	/**
	 * Obtiene la etiqueta de la edad.
	 * 
	 * @return JLabel de la edad.
	 */
	public JLabel getLblEdad() {
		return lblEdad;
	}

	/**
	 * Establece la etiqueta de la edad.
	 * 
	 * @param lblEdad JLabel a asignar.
	 */
	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	/**
	 * Obtiene la etiqueta de la contraseña.
	 * 
	 * @return JLabel de la contraseña.
	 */
	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	/**
	 * Establece la etiqueta de la contraseña.
	 * 
	 * @param lblContrasenia JLabel a asignar.
	 */
	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	/**
	 * Obtiene la etiqueta para confirmar la contraseña.
	 * 
	 * @return JLabel de confirmación de contraseña.
	 */
	public JLabel getLblConfirmarContrasenia() {
		return lblConfirmarContrasenia;
	}

	/**
	 * Establece la etiqueta para confirmar la contraseña.
	 * 
	 * @param lblConfirmarContrasenia JLabel a asignar.
	 */
	public void setLblConfirmarContrasenia(JLabel lblConfirmarContrasenia) {
		this.lblConfirmarContrasenia = lblConfirmarContrasenia;
	}

	/**
	 * Obtiene la etiqueta de estatura.
	 * 
	 * @return JLabel de estatura.
	 */
	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	/**
	 * Establece la etiqueta de estatura.
	 * 
	 * @param lblEstatura JLabel a asignar.
	 */
	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	/**
	 * Obtiene la etiqueta de estatura ideal.
	 * 
	 * @return JLabel de estatura ideal.
	 */
	public JLabel getLblEstaturaIdeal() {
		return lblEstaturaIdeal;
	}

	/**
	 * Establece la etiqueta de estatura ideal.
	 * 
	 * @param lblEstaturaIdeal JLabel a asignar.
	 */
	public void setLblEstaturaIdeal(JLabel lblEstaturaIdeal) {
		this.lblEstaturaIdeal = lblEstaturaIdeal;
	}

	/**
	 * Obtiene la etiqueta de edad mínima.
	 * 
	 * @return JLabel de edad mínima.
	 */
	public JLabel getLblEdadMinima() {
		return lblEdadMinima;
	}

	/**
	 * Establece la etiqueta de edad mínima.
	 * 
	 * @param lblEdadMinima JLabel a asignar.
	 */
	public void setLblEdadMinima(JLabel lblEdadMinima) {
		this.lblEdadMinima = lblEdadMinima;
	}

	/**
	 * Obtiene la etiqueta de edad máxima.
	 * 
	 * @return JLabel de edad máxima.
	 */
	public JLabel getLblEdadMaxima() {
		return lblEdadMaxima;
	}

	/**
	 * Establece la etiqueta de edad máxima.
	 * 
	 * @param lblEdadMaxima JLabel a asignar.
	 */
	public void setLblEdadMaxima(JLabel lblEdadMaxima) {
		this.lblEdadMaxima = lblEdadMaxima;
	}

	/**
	 * Establece el JLabel que representa el fondo.
	 * 
	 * @param lblFondo JLabel a asignar.
	 */
	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	/**
	 * Establece la etiqueta que muestra el nombre del usuario.
	 * 
	 * @param lblNombreUsuario JLabel a asignar.
	 */
	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	/**
	 * Establece la etiqueta que muestra el apellido del usuario.
	 * 
	 * @param lblApellidoUsuario JLabel a asignar.
	 */
	public void setLblApellidoUsuario(JLabel lblApellidoUsuario) {
		this.lblApellidoUsuario = lblApellidoUsuario;
	}

	/**
	 * Establece la etiqueta que muestra el correo electrónico del usuario.
	 * 
	 * @param lblEmailUsuario JLabel a asignar.
	 */
	public void setLblEmailUsuario(JLabel lblEmailUsuario) {
		this.lblEmailUsuario = lblEmailUsuario;
	}

	/**
	 * Establece la etiqueta que muestra la edad del usuario.
	 * 
	 * @param lblEdadUsuario JLabel a asignar.
	 */
	public void setLblEdadUsuario(JLabel lblEdadUsuario) {
		this.lblEdadUsuario = lblEdadUsuario;
	}

	/**
	 * Asigna el campo de texto para el alias del usuario.
	 * 
	 * @param txtAlias JTextField a asignar.
	 */
	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	/**
	 * Asigna el campo de la contraseña.
	 * 
	 * @param jpfContrasenia JPasswordField a asignar.
	 */
	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	/**
	 * Asigna el campo para confirmar la contraseña.
	 * 
	 * @param jpfConfirmarContrasenia JPasswordField a asignar.
	 */
	public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
		this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
	}

	/**
	 * Asigna el campo de texto para la estatura.
	 * 
	 * @param txtEstatura JTextField a asignar.
	 */
	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	/**
	 * Asigna el campo de texto para la estatura ideal.
	 * 
	 * @param txtEstaturaIdeal JTextField a asignar.
	 */
	public void setTxtEstaturaIdeal(JTextField txtEstaturaIdeal) {
		this.txtEstaturaIdeal = txtEstaturaIdeal;
	}

	/**
	 * Asigna el campo de texto para la edad mínima.
	 * 
	 * @param txtEdadMinima JTextField a asignar.
	 */
	public void setTxtEdadMinima(JTextField txtEdadMinima) {
		this.txtEdadMinima = txtEdadMinima;
	}

	/**
	 * Asigna el campo de texto para la edad máxima.
	 * 
	 * @param txtEdadMaxima JTextField a asignar.
	 */
	public void setTxtEdadMaxima(JTextField txtEdadMaxima) {
		this.txtEdadMaxima = txtEdadMaxima;
	}

	/**
	 * Asigna la casilla de verificación "Divorciada".
	 * 
	 * @param chkDivorciada JCheckBox a asignar.
	 */
	public void setChkDivorciada(JCheckBox chkDivorciada) {
		this.chkDivorciada = chkDivorciada;
	}

	/**
	 * Asigna la casilla de visibilidad del perfil.
	 * 
	 * @param chkVisibilidad JCheckBox a asignar.
	 */
	public void setChkVisibilidad(JCheckBox chkVisibilidad) {
		this.chkVisibilidad = chkVisibilidad;
	}

	/**
	 * Asigna el botón de actualización.
	 * 
	 * @param btnActualizar JButton a asignar.
	 */
	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	/**
	 * Asigna el botón de cancelación.
	 * 
	 * @param btnCancelar JButton a asignar.
	 */
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	/**
	 * Asigna el selector de archivos (JFileChooser).
	 * 
	 * @param fileChooser JFileChooser a asignar.
	 */
	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	/**
	 * Obtiene el campo de texto del alias.
	 * 
	 * @return JTextField del alias.
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * Obtiene el campo de contraseña.
	 * 
	 * @return JPasswordField de la contraseña.
	 */
	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	/**
	 * Obtiene el campo para confirmar la contraseña.
	 * 
	 * @return JPasswordField de confirmación.
	 */
	public JPasswordField getJpfConfirmarContrasenia() {
		return jpfConfirmarContrasenia;
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
	 * Obtiene el campo de texto de la estatura ideal.
	 * 
	 * @return JTextField de estatura ideal.
	 */
	public JTextField getTxtEstaturaIdeal() {
		return txtEstaturaIdeal;
	}

	/**
	 * Obtiene el campo de texto de edad mínima.
	 * 
	 * @return JTextField de edad mínima.
	 */
	public JTextField getTxtEdadMinima() {
		return txtEdadMinima;
	}

	/**
	 * Obtiene el campo de texto de edad máxima.
	 * 
	 * @return JTextField de edad máxima.
	 */
	public JTextField getTxtEdadMaxima() {
		return txtEdadMaxima;
	}

	/**
	 * Obtiene la casilla de verificación "Divorciada".
	 * 
	 * @return JCheckBox de divorciada.
	 */
	public JCheckBox getChkDivorciada() {
		return chkDivorciada;
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
	 * Obtiene la etiqueta del nombre del usuario.
	 * 
	 * @return JLabel del nombre de usuario.
	 */
	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	/**
	 * Obtiene la etiqueta del apellido del usuario.
	 * 
	 * @return JLabel del apellido de usuario.
	 */
	public JLabel getLblApellidoUsuario() {
		return lblApellidoUsuario;
	}

	/**
	 * Obtiene la etiqueta del correo electrónico del usuario.
	 * 
	 * @return JLabel del correo de usuario.
	 */
	public JLabel getLblEmailUsuario() {
		return lblEmailUsuario;
	}

	/**
	 * Obtiene la etiqueta de la edad del usuario.
	 * 
	 * @return JLabel de la edad de usuario.
	 */
	public JLabel getLblEdadUsuario() {
		return lblEdadUsuario;
	}

	/**
	 * Obtiene el selector de archivos (JFileChooser).
	 * 
	 * @return JFileChooser actual.
	 */
	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	/**
	 * Obtiene el botón de actualización.
	 * 
	 * @return JButton de actualizar.
	 */
	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	/**
	 * Obtiene el botón de cancelación.
	 * 
	 * @return JButton de cancelar.
	 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	/**
	 * Obtiene el botón de cerrar sesión.
	 * 
	 * @return JButton de cerrar sesión.
	 */
	public JButton getBtnCerrarSesion() {
		return btnCerrarSesion;
	}

	/**
	 * Establece el botón de cerrar sesión.
	 * 
	 * @param btnCerrarSesion JButton a asignar.
	 */
	public void setBtnCerrarSesion(JButton btnCerrarSesion) {
		this.btnCerrarSesion = btnCerrarSesion;
	}

	/**
	 * Establece la etiqueta de la foto de perfil.
	 * 
	 * @param lblFotoPerfil JLabel a asignar.
	 */
	public void setLblFotoPerfil(JLabel lblFotoPerfil) {
		this.lblFotoPerfil = lblFotoPerfil;
	}

	/**
	 * Establece el botón para seleccionar una foto.
	 * 
	 * @param btnSeleccionarFoto JButton a asignar.
	 */
	public void setBtnSeleccionarFoto(JButton btnSeleccionarFoto) {
		this.btnSeleccionarFoto = btnSeleccionarFoto;
	}

	/**
	 * Establece la imagen actual cargada en memoria.
	 * 
	 * @param imagenActual BufferedImage a asignar.
	 */
	public void setImagenActual(BufferedImage imagenActual) {
		this.imagenActual = imagenActual;
	}

	/**
	 * Obtiene el botón para eliminar la cuenta del usuario.
	 * 
	 * @return JButton de eliminar cuenta.
	 */
	public JButton getBtnEliminarCuenta() {
		return btnEliminarCuenta;
	}

	/**
	 * Establece el botón para eliminar la cuenta del usuario.
	 * 
	 * @param btnEliminarCuenta JButton a asignar.
	 */
	public void setBtnEliminarCuenta(JButton btnEliminarCuenta) {
		this.btnEliminarCuenta = btnEliminarCuenta;
	}

}