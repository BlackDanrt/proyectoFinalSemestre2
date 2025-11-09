package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class PanelPerfilMujer extends JPanel {

	// Componentes de visualización
	private JLabel lblFondo;

	// NUEVOS: Componentes para foto de perfil
	private JLabel lblFotoPerfil;
	private JButton btnSeleccionarFoto;
	private File archivoImagenSeleccionada;
	private BufferedImage imagenActual;

	// Columna Izquierda - Información personal
	private JLabel lblNombre;
	private JLabel lblNombreUsuario;
	private JLabel lblApellido;
	private JLabel lblApellidoUsuario;
	private JLabel lblAlias;
	private JLabel lblEmail;
	private JLabel lblEmailUsuario;
	private JLabel lblEdad;
	private JLabel lblEdadUsuario;

	// Columna Derecha - Configuración y preferencias
	private JLabel lblContrasenia;
	private JLabel lblConfirmarContrasenia;
	private JLabel lblEstatura;
	private JLabel lblEstaturaIdeal;
	private JLabel lblEdadMinima;
	private JLabel lblEdadMaxima;

	// Campos de entrada
	private JTextField txtAlias;
	private JPasswordField jpfContrasenia;
	private JPasswordField jpfConfirmarContrasenia;
	private JTextField txtEstatura;
	private JTextField txtEstaturaIdeal;
	private JTextField txtEdadMinima;
	private JTextField txtEdadMaxima;

	// Checkboxes
	private JCheckBox chkDivorciada;
	private JCheckBox chkVisibilidad;

	// Botones
	private JButton btnActualizar;
	private JButton btnCancelar;

	// FileChooser para cargar imagen de perfil
	private JFileChooser fileChooser;

	public PanelPerfilMujer() {
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
		lblFondo.setText("PERFIL MUJER");
		lblFondo.setFont(new Font("Arial", Font.BOLD, 32));
		lblFondo.setForeground(Color.WHITE);

		// ============ FOTO DE PERFIL (ARRIBA A LA IZQUIERDA) ============

		// Label para mostrar la foto
		lblFotoPerfil = new JLabel();
		lblFotoPerfil.setBounds(50, 30, 120, 120);
		lblFotoPerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblFotoPerfil.setVerticalAlignment(SwingConstants.CENTER);
		lblFotoPerfil.setText("<html><center>Click para<br>seleccionar<br>foto</center></html>");
		lblFotoPerfil.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFotoPerfil.setForeground(Color.WHITE);
		lblFotoPerfil.setOpaque(true);
		lblFotoPerfil.setBackground(new Color(255, 255, 255, 100));
		lblFotoPerfil.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		lblFotoPerfil.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// Hacer el label clickeable
		lblFotoPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				seleccionarImagen();
			}
		});

		// Botón para seleccionar foto
		btnSeleccionarFoto = new JButton("Cambiar Foto");
		btnSeleccionarFoto.setBounds(50, 160, 120, 30);
		btnSeleccionarFoto.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSeleccionarFoto.setBackground(Color.decode("#9B59B6"));
		btnSeleccionarFoto.setForeground(Color.WHITE);
		btnSeleccionarFoto.setFocusPainted(false);
		btnSeleccionarFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeleccionarFoto.addActionListener(e -> seleccionarImagen());

		// ============ COLUMNA IZQUIERDA ============

		// Nombre
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(200, 220, 340, 20);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
		lblNombre.setForeground(Color.WHITE);

		lblNombreUsuario = new JLabel();
		lblNombreUsuario.setBounds(200, 245, 340, 35);
		lblNombreUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombreUsuario.setForeground(Color.WHITE);
		lblNombreUsuario.setOpaque(true);
		lblNombreUsuario.setBackground(new Color(255, 255, 255, 100));
		lblNombreUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		// Apellido
		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(200, 295, 340, 20);
		lblApellido.setFont(new Font("Arial", Font.BOLD, 14));
		lblApellido.setForeground(Color.WHITE);

		lblApellidoUsuario = new JLabel();
		lblApellidoUsuario.setBounds(200, 320, 340, 35);
		lblApellidoUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblApellidoUsuario.setForeground(Color.WHITE);
		lblApellidoUsuario.setOpaque(true);
		lblApellidoUsuario.setBackground(new Color(255, 255, 255, 100));
		lblApellidoUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		// Alias
		lblAlias = new JLabel("Alias:");
		lblAlias.setBounds(200, 370, 340, 20);
		lblAlias.setFont(new Font("Arial", Font.BOLD, 14));
		lblAlias.setForeground(Color.WHITE);

		txtAlias = new JTextField();
		txtAlias.setBounds(200, 395, 340, 35);
		txtAlias.setFont(new Font("Arial", Font.PLAIN, 14));

		// Email
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(200, 445, 340, 20);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
		lblEmail.setForeground(Color.WHITE);

		lblEmailUsuario = new JLabel();
		lblEmailUsuario.setBounds(200, 470, 340, 35);
		lblEmailUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEmailUsuario.setForeground(Color.WHITE);
		lblEmailUsuario.setOpaque(true);
		lblEmailUsuario.setBackground(new Color(255, 255, 255, 100));
		lblEmailUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		// Edad
		lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(200, 520, 340, 20);
		lblEdad.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdad.setForeground(Color.WHITE);

		lblEdadUsuario = new JLabel();
		lblEdadUsuario.setBounds(200, 545, 340, 35);
		lblEdadUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEdadUsuario.setForeground(Color.WHITE);
		lblEdadUsuario.setOpaque(true);
		lblEdadUsuario.setBackground(new Color(255, 255, 255, 100));
		lblEdadUsuario.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		// ============ COLUMNA DERECHA ============

		// Contraseña
		lblContrasenia = new JLabel("Nueva Contraseña:");
		lblContrasenia.setBounds(740, 220, 340, 20);
		lblContrasenia.setFont(new Font("Arial", Font.BOLD, 14));
		lblContrasenia.setForeground(Color.WHITE);

		jpfContrasenia = new JPasswordField();
		jpfContrasenia.setBounds(740, 245, 340, 35);
		jpfContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));

		// Confirmar Contraseña
		lblConfirmarContrasenia = new JLabel("Confirmar Contraseña:");
		lblConfirmarContrasenia.setBounds(740, 295, 340, 20);
		lblConfirmarContrasenia.setFont(new Font("Arial", Font.BOLD, 14));
		lblConfirmarContrasenia.setForeground(Color.WHITE);

		jpfConfirmarContrasenia = new JPasswordField();
		jpfConfirmarContrasenia.setBounds(740, 320, 340, 35);
		jpfConfirmarContrasenia.setFont(new Font("Arial", Font.PLAIN, 14));

		// Estatura
		lblEstatura = new JLabel("Estatura (cm):");
		lblEstatura.setBounds(740, 370, 160, 20);
		lblEstatura.setFont(new Font("Arial", Font.BOLD, 14));
		lblEstatura.setForeground(Color.WHITE);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(740, 395, 160, 35);
		txtEstatura.setFont(new Font("Arial", Font.PLAIN, 14));

		// Estatura Ideal
		lblEstaturaIdeal = new JLabel("Estatura Ideal (cm):");
		lblEstaturaIdeal.setBounds(920, 370, 160, 20);
		lblEstaturaIdeal.setFont(new Font("Arial", Font.BOLD, 14));
		lblEstaturaIdeal.setForeground(Color.WHITE);

		txtEstaturaIdeal = new JTextField();
		txtEstaturaIdeal.setBounds(920, 395, 160, 35);
		txtEstaturaIdeal.setFont(new Font("Arial", Font.PLAIN, 14));

		// Edad Mínima
		lblEdadMinima = new JLabel("Edad Mínima:");
		lblEdadMinima.setBounds(740, 445, 160, 20);
		lblEdadMinima.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdadMinima.setForeground(Color.WHITE);

		txtEdadMinima = new JTextField();
		txtEdadMinima.setBounds(740, 470, 160, 35);
		txtEdadMinima.setFont(new Font("Arial", Font.PLAIN, 14));

		// Edad Máxima
		lblEdadMaxima = new JLabel("Edad Máxima:");
		lblEdadMaxima.setBounds(920, 445, 160, 20);
		lblEdadMaxima.setFont(new Font("Arial", Font.BOLD, 14));
		lblEdadMaxima.setForeground(Color.WHITE);

		txtEdadMaxima = new JTextField();
		txtEdadMaxima.setBounds(920, 470, 160, 35);
		txtEdadMaxima.setFont(new Font("Arial", Font.PLAIN, 14));

		// Checkbox Divorciada
		chkDivorciada = new JCheckBox("¿Divorciada?");
		chkDivorciada.setBounds(740, 520, 220, 30);
		chkDivorciada.setOpaque(false);
		chkDivorciada.setFont(new Font("Arial", Font.BOLD, 14));
		chkDivorciada.setForeground(Color.WHITE);

		// Checkbox Visibilidad
		chkVisibilidad = new JCheckBox("Perfil visible para otros usuarios");
		chkVisibilidad.setBounds(740, 560, 340, 30);
		chkVisibilidad.setOpaque(false);
		chkVisibilidad.setFont(new Font("Arial", Font.BOLD, 14));
		chkVisibilidad.setForeground(Color.WHITE);
		chkVisibilidad.setSelected(true);

		// ============ BOTONES CENTRADOS ============

		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(440, 640, 180, 45);
		btnActualizar.setFont(new Font("Arial", Font.BOLD, 16));
		btnActualizar.setBackground(Color.decode("#4CAF50"));
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFocusPainted(false);
		btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(660, 640, 180, 45);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancelar.setBackground(Color.decode("#F44336"));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

		// FileChooser
		fileChooser = new JFileChooser();
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png"));

		// ============ AGREGAR COMPONENTES AL PANEL ============

		this.add(lblFondo);

		// Foto de perfil
		this.add(lblFotoPerfil);
		this.add(btnSeleccionarFoto);

		// Columna Izquierda
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

		// Columna Derecha
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

		// Botones
		this.add(btnActualizar);
		this.add(btnCancelar);
	}

	// ============ MÉTODO PARA SELECCIONAR IMAGEN ============

	private void seleccionarImagen() {
		int resultado = fileChooser.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			archivoImagenSeleccionada = fileChooser.getSelectedFile();
			cargarVistaPrevia(archivoImagenSeleccionada);
		}
	}

	private void cargarVistaPrevia(File archivo) {
		try {
			imagenActual = ImageIO.read(archivo);

			if (imagenActual != null) {
				// Escalar la imagen para que quepa en el label (120x120)
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

	private Image escalarImagen(BufferedImage img, int maxWidth, int maxHeight) {
		int width = img.getWidth();
		int height = img.getHeight();

		// Calcular proporción manteniendo aspecto
		double ratio = Math.min((double) maxWidth / width, (double) maxHeight / height);

		int newWidth = (int) (width * ratio);
		int newHeight = (int) (height * ratio);

		return img.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
	}

	// ============ GETTERS Y SETTERS ============

	// NUEVOS getters para la imagen
	public File getArchivoImagenSeleccionada() {
		return archivoImagenSeleccionada;
	}

	public BufferedImage getImagenActual() {
		return imagenActual;
	}

	public JLabel getLblFotoPerfil() {
		return lblFotoPerfil;
	}

	public JButton getBtnSeleccionarFoto() {
		return btnSeleccionarFoto;
	}

	// Setters para cargar imagen desde el controlador
	public void setArchivoImagenSeleccionada(File archivo) {
		this.archivoImagenSeleccionada = archivo;
		if (archivo != null) {
			cargarVistaPrevia(archivo);
		}
	}

	public void setImagenPerfil(BufferedImage imagen) {
		if (imagen != null) {
			this.imagenActual = imagen;
			Image imagenEscalada = escalarImagen(imagen, 120, 120);
			lblFotoPerfil.setIcon(new ImageIcon(imagenEscalada));
			lblFotoPerfil.setText("");
		}
	}

	public JLabel getLblFondo() {
		return lblFondo;
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

	public JLabel getLblEdad() {
		return lblEdad;
	}

	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
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

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	public void setLblNombreUsuario(JLabel lblNombreUsuario) {
		this.lblNombreUsuario = lblNombreUsuario;
	}

	public void setLblApellidoUsuario(JLabel lblApellidoUsuario) {
		this.lblApellidoUsuario = lblApellidoUsuario;
	}

	public void setLblEmailUsuario(JLabel lblEmailUsuario) {
		this.lblEmailUsuario = lblEmailUsuario;
	}

	public void setLblEdadUsuario(JLabel lblEdadUsuario) {
		this.lblEdadUsuario = lblEdadUsuario;
	}

	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	public void setJpfContrasenia(JPasswordField jpfContrasenia) {
		this.jpfContrasenia = jpfContrasenia;
	}

	public void setJpfConfirmarContrasenia(JPasswordField jpfConfirmarContrasenia) {
		this.jpfConfirmarContrasenia = jpfConfirmarContrasenia;
	}

	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}

	public void setTxtEstaturaIdeal(JTextField txtEstaturaIdeal) {
		this.txtEstaturaIdeal = txtEstaturaIdeal;
	}

	public void setTxtEdadMinima(JTextField txtEdadMinima) {
		this.txtEdadMinima = txtEdadMinima;
	}

	public void setTxtEdadMaxima(JTextField txtEdadMaxima) {
		this.txtEdadMaxima = txtEdadMaxima;
	}

	public void setChkDivorciada(JCheckBox chkDivorciada) {
		this.chkDivorciada = chkDivorciada;
	}

	public void setChkVisibilidad(JCheckBox chkVisibilidad) {
		this.chkVisibilidad = chkVisibilidad;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public void setFileChooser(JFileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public JTextField getTxtAlias() {
		return txtAlias;
	}

	public JPasswordField getJpfContrasenia() {
		return jpfContrasenia;
	}

	public JPasswordField getJpfConfirmarContrasenia() {
		return jpfConfirmarContrasenia;
	}

	public JTextField getTxtEstatura() {
		return txtEstatura;
	}

	public JTextField getTxtEstaturaIdeal() {
		return txtEstaturaIdeal;
	}

	public JTextField getTxtEdadMinima() {
		return txtEdadMinima;
	}

	public JTextField getTxtEdadMaxima() {
		return txtEdadMaxima;
	}

	public JCheckBox getChkDivorciada() {
		return chkDivorciada;
	}

	public JCheckBox getChkVisibilidad() {
		return chkVisibilidad;
	}

	public JLabel getLblNombreUsuario() {
		return lblNombreUsuario;
	}

	public JLabel getLblApellidoUsuario() {
		return lblApellidoUsuario;
	}

	public JLabel getLblEmailUsuario() {
		return lblEmailUsuario;
	}

	public JLabel getLblEdadUsuario() {
		return lblEdadUsuario;
	}

	public JFileChooser getFileChooser() {
		return fileChooser;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}