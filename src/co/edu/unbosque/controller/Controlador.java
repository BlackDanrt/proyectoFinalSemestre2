package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.UUID;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.CorreoDTO;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.AliasExistenteActualizadoException;
import co.edu.unbosque.util.exception.AliasExistenteException;
import co.edu.unbosque.util.exception.ContraseniaDebilException;
import co.edu.unbosque.util.exception.ContraseniaDiferenteException;
import co.edu.unbosque.util.exception.CorreoExistenteException;
import co.edu.unbosque.util.exception.CorreoInvalidoException;
import co.edu.unbosque.util.exception.FechaNacimientoInvalidaException;
import co.edu.unbosque.util.exception.LanzadorDeExcepcion;
import co.edu.unbosque.util.exception.NumeroInvalidoException;
import co.edu.unbosque.util.exception.StringInvalidoException;
import co.edu.unbosque.view.ViewFacade;

/**
 * Clase principal del controlador del sistema BosTinder.
 * <p>
 * Esta clase implementa el patrón de diseño <b>MVC</b>
 * (Modelo-Vista-Controlador) y actúa como intermediario entre la vista
 * ({@link co.edu.unbosque.view.ViewFacade}) y el modelo
 * ({@link co.edu.unbosque.model.ModelFacade}).
 * </p>
 *
 * <p>
 * <b>Responsabilidades principales:</b>
 * </p>
 * <ul>
 * <li>Escuchar y gestionar los eventos de la interfaz gráfica implementando
 * {@link java.awt.event.ActionListener}.</li>
 * <li>Coordinar las operaciones entre la vista y el modelo.</li>
 * <li>Manejar la lógica de registro, autenticación, idioma, y modo oscuro.</li>
 * <li>Controlar el flujo entre los distintos paneles de la aplicación.</li>
 * </ul>
 *
 * <p>
 * <b>Componentes principales:</b>
 * </p>
 * <ul>
 * <li>{@link co.edu.unbosque.model.ModelFacade}: Manejo de los datos del
 * sistema (usuarios, correos, archivos, etc.).</li>
 * <li>{@link co.edu.unbosque.view.ViewFacade}: Representación visual de la
 * interfaz y sus paneles.</li>
 * </ul>
 *
 * <p>
 * <b>Excepciones manejadas:</b>
 * </p>
 * <ul>
 * <li>{@link co.edu.unbosque.util.exception.CorreoInvalidoException}</li>
 * <li>{@link co.edu.unbosque.util.exception.AliasExistenteException}</li>
 * <li>{@link co.edu.unbosque.util.exception.ContraseniaDebilException}</li>
 * <li>{@link co.edu.unbosque.util.exception.ContraseniaDiferenteException}</li>
 * <li>{@link co.edu.unbosque.util.exception.NumeroInvalidoException}</li>
 * <li>{@link co.edu.unbosque.util.exception.StringInvalidoException}</li>
 * <li>{@link co.edu.unbosque.util.exception.FechaNacimientoInvalidaException}</li>
 * </ul>
 *
 * <p>
 * Además, el controlador se encarga de mantener sincronizados los textos de la
 * interfaz según el idioma seleccionado y de gestionar la personalización
 * visual del usuario (foto de perfil, alias, etc.).
 * </p>
 *
 * @author
 * @version Juan Martinez
 */
public class Controlador implements ActionListener {

	/** Fachada que centraliza la lógica del modelo. */
	private ModelFacade mf;

	/** Fachada que gestiona la interfaz gráfica del usuario. */
	private ViewFacade vf;

	/**
	 * Archivo de propiedades que contiene las cadenas de texto del idioma actual.
	 */
	private Properties propIdioma;

	/** Archivo de propiedades con la configuración general del programa. */
	private Properties propConfig;

	/**
	 * Crea un nuevo controlador del sistema BosTinder.
	 * <p>
	 * Este constructor inicializa las fachadas del modelo y la vista, carga los
	 * archivos de configuración e idioma, establece el idioma actual en la interfaz
	 * y configura los oyentes y textos de los paneles.
	 * </p>
	 */
	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		propConfig = FileHandler.cargarArchivoDePropiedades("config.properties");
		FileHandler.cargarArchivoDePropiedades(propConfig.getProperty("proyectoFinalSemestre2.idioma"));
		vf.getpBan().getCmbIdioma().setSelectedItem(propConfig.getProperty("proyectoFinalSemestre2.idioma"));
		inicializarOyentes();
		inicializarConfig();
		cadenasTextoPaneles();
	}

	/**
	 * Inicializa y muestra la interfaz gráfica principal del sistema BosTinder.
	 * <p>
	 * Este método configura los distintos paneles de la aplicación, definiendo su
	 * posición, tamaño y visibilidad inicial dentro del {@code JLayeredPane}.
	 * Además, se encarga de refrescar la vista y hacer visible la ventana
	 * principal.
	 * </p>
	 *
	 * <p>
	 * Los paneles gestionados incluyen:
	 * </p>
	 * <ul>
	 * <li>Panel de inicio de sesión</li>
	 * <li>Panel de banner</li>
	 * <li>Panel de selección de género</li>
	 * <li>Panel de registro</li>
	 * <li>Panel de código de verificación</li>
	 * <li>Panel principal con scroll</li>
	 * <li>Panel de perfil (hombre y mujer)</li>
	 * <li>Panel de administración</li>
	 * </ul>
	 *
	 * <p>
	 * Cada panel se agrega a la capa de paleta ({@code JLayeredPane.PALETTE_LAYER})
	 * y, excepto los de inicio y banner, se mantienen ocultos hasta que sean
	 * requeridos.
	 * </p>
	 */
	public void runGUI() {

		// Panel iniciar sesion
		vf.getpInic().setBounds(360, 70, 560, 620);
		vf.getVen().getCapas().add(vf.getpInic(), JLayeredPane.PALETTE_LAYER);

		// Panel banner
		vf.getpBan().setBounds(0, 801, 1280, 80);
		vf.getVen().getCapas().add(vf.getpBan(), JLayeredPane.PALETTE_LAYER);

		vf.refrescarVista();
		vf.getVen().setVisible(true);

		// Panel seleccionar genero
		vf.getpGen().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpGen(), JLayeredPane.PALETTE_LAYER);
		vf.getpGen().setVisible(false);

		// Panel registrarse
		vf.getpReg().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpReg(), JLayeredPane.PALETTE_LAYER);
		vf.getpReg().setVisible(false);

		// Panel Codigo Verificacion
		vf.getpCV().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpCV(), JLayeredPane.PALETTE_LAYER);
		vf.getpCV().setVisible(false);

		// Panel Scroll (Principal)
		vf.getpScr().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpScr(), JLayeredPane.PALETTE_LAYER);
		vf.getpScr().setVisible(false);

		// Panel Perfil Hombre
		vf.getpPH().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpPH(), JLayeredPane.PALETTE_LAYER);
		vf.getpPH().setVisible(false);

		// Panel Perfil Mujer
		vf.getpPM().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpPM(), JLayeredPane.PALETTE_LAYER);
		vf.getpPM().setVisible(false);

		// Panel administrador
		vf.getpAdmin().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpAdmin(), JLayeredPane.PALETTE_LAYER);
		vf.getpAdmin().setVisible(false);

	}

	/**
	 * Inicializa la configuración general de la aplicación BosTinder.
	 * <p>
	 * Este método aplica el modo visual (oscuro o claro) y el idioma guardado en el
	 * archivo {@code config.properties}. También establece valores por defecto para
	 * ciertos parámetros, como el índice mostrado y el estado de inicio de sesión.
	 * </p>
	 *
	 * <p>
	 * Los posibles idiomas configurables son:
	 * </p>
	 * <ul>
	 * <li>Español (ES)</li>
	 * <li>Inglés (US)</li>
	 * <li>Portugués (BR)</li>
	 * <li>Ruso (RU)</li>
	 * <li>Chino (CN)</li>
	 * <li>Hebreo (IL)</li>
	 * </ul>
	 *
	 * <p>
	 * Después de aplicar los cambios, la configuración se guarda nuevamente en el
	 * archivo de propiedades.
	 * </p>
	 *
	 */
	public void inicializarConfig() {
		boolean modoOscuro = Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoOscuro"));
		if (modoOscuro) {
			vf.modoOscuro();
			vf.refrescarVista();
		} else {
			vf.modoClaro();
			vf.refrescarVista();
		}

		String idiomaGuardado = propConfig.getProperty("proyectoFinalSemestre2.idioma");
		if (idiomaGuardado.equals("ES")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("Español ES");

		} else if (idiomaGuardado.equals("US")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("English US");

		} else if (idiomaGuardado.equals("BR")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("Portugués BR");

		} else if (idiomaGuardado.equals("RU")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("русский RU");

		} else if (idiomaGuardado.equals("CN")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("中文 CN");

		} else if (idiomaGuardado.equals("IL")) {
			vf.getpBan().getCmbIdioma().setSelectedItem("עברית IL");

		}

		propConfig.setProperty("proyectoFinalSemestre2.indiceMostrar", "0");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}

		propConfig.setProperty("proyectoFinalSemestre2.usuarioInicioSesion", "false");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException a) {
		}

	}

	/**
	 * Alterna entre el modo oscuro y el modo claro de la interfaz.
	 * <p>
	 * Este método verifica el valor actual del modo visual en el archivo
	 * {@code config.properties}, cambia su valor (de verdadero a falso o
	 * viceversa), actualiza el archivo y aplica el nuevo tema visual en la
	 * interfaz.
	 * </p>
	 *
	 * <p>
	 * Si ocurre un error al leer o escribir en el archivo de configuración, se
	 * captura y muestra la excepción en la consola.
	 * </p>
	 *
	 * @throws InputMismatchException Si el valor del modo oscuro en el archivo de
	 *                                propiedades no es válido para conversión
	 *                                booleana.
	 * @throws IOException            Si ocurre un error al guardar los cambios en
	 *                                el archivo de configuración.
	 */
	public void modoOscuro() {
		boolean modoOscuro = Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoOscuro"));
		try {
			if (modoOscuro) {

				propConfig.setProperty("proyectoFinalSemestre2.modoOscuro", "false");
				propConfig.store(new FileWriter("config.properties"), null);
				vf.modoClaro();
			} else {

				propConfig.setProperty("proyectoFinalSemestre2.modoOscuro", "true");
				propConfig.store(new FileWriter("config.properties"), null);
				vf.modoOscuro();
			}
			vf.refrescarVista();
		} catch (InputMismatchException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cambia el idioma de la interfaz según la opción seleccionada en el combo box
	 * de idiomas. Carga el archivo de propiedades correspondiente, actualiza el
	 * archivo de configuración con el nuevo código de idioma y refresca todos los
	 * textos visibles en la interfaz.
	 * <p>
	 * Además, si un usuario tiene sesión iniciada, vuelve a mostrar la persona
	 * correspondiente y actualiza el panel de perfil si está visible.
	 * </p>
	 *
	 * <p>
	 * Idiomas soportados:
	 * </p>
	 * <ul>
	 * <li>Español (ES)</li>
	 * <li>Inglés (US)</li>
	 * <li>Portugués (BR)</li>
	 * <li>Ruso (RU)</li>
	 * <li>Chino (CN)</li>
	 * <li>Hebreo (IL)</li>
	 * </ul>
	 *
	 */
	public void idioma() {

		String idioma = String.valueOf(vf.getpBan().getCmbIdioma().getSelectedItem());
		if (idioma.equals("Español ES")) {
			propIdioma = FileHandler.cargarArchivoDePropiedades("ES.properties");
			try {
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "ES");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("English US")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("US.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "US");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("Portugués BR")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("BR.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "BR");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("русский RU")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("RU.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "RU");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("中文 CN")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("CN.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "CN");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("עברית IL")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("IL.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "IL");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		}
		boolean inicioSesion = Boolean
				.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.usuarioInicioSesion"));
		if (inicioSesion) {
			mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
		}
		if (vf.getpPH().isVisible()) {
			perfilHombre();
		}

		vf.getpBan().getCmbIdioma().setSelectedItem(idioma);
		cadenasTextoPaneles();
		vf.refrescarVista();
	}

	/**
	 * Inicia el proceso de inicio de sesión de un usuario o del administrador.
	 * <p>
	 * Verifica las credenciales ingresadas en el panel de inicio de sesión. Si las
	 * credenciales corresponden al administrador, se muestra el panel
	 * administrativo con el modo de orden configurado (ascendente o descendente).
	 * En caso contrario, se validan las credenciales contra las listas de usuarios
	 * (hombres y mujeres) registradas en el sistema.
	 * </p>
	 *
	 * <p>
	 * Si el inicio de sesión es exitoso:
	 * <ul>
	 * <li>Se muestra un mensaje de confirmación.</li>
	 * <li>Si el usuario está verificado, se abre el panel principal.</li>
	 * <li>Si el usuario no está verificado, se genera un código de verificación de
	 * 6 dígitos y se envía por correo electrónico.</li>
	 * <li>Se actualiza el archivo <code>config.properties</code> con los datos del
	 * usuario, como su ID, género, estado de sesión e índice mostrado.</li>
	 * </ul>
	 * </p>
	 *
	 * <p>
	 * Si el inicio de sesión falla, se muestra un mensaje de error con el idioma
	 * actualmente seleccionado.
	 * </p>
	 *
	 */
	public void iniciarSesion() {
		String correo = vf.getpInic().getTxtEmail().getText();
		String contrasenia = vf.getpInic().getJpfContrasenia().getText();

		if (correo.equals(mf.getAdmin().getCorreoAdmin()) && contrasenia.equals(mf.getAdmin().getContraseniaAdmin())) {
			vf.getpInic().setVisible(false);
			vf.getpBan().getCmbIdioma().setVisible(false);
			vf.refrescarVista();
			vf.getpAdmin().setVisible(true);
			if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoAscendente"))) {
				vf.ordenAscendente();
			} else {
				vf.ordenDescendente();
			}
		} else {

			ArrayList<MujerDTO> mujeres = mf.getMujerDao().getLista();
			ArrayList<HombreDTO> hombres = mf.getHombreDao().getLista();

			String alias = "";
			String id = "";
			boolean sesionExitosa = false;
			boolean esHombre = true;
			for (HombreDTO dto : hombres) {
				if (dto.getCorreo().equals(correo) && dto.getContrasenia().equals(contrasenia)) {
					sesionExitosa = true;
					alias = dto.getAlias();
					id = dto.getId();
					break;
				}
			}

			if (!sesionExitosa) {
				for (MujerDTO dto : mujeres) {
					if (dto.getCorreo().equals(correo) && dto.getContrasenia().equals(contrasenia)) {
						sesionExitosa = true;
						alias = dto.getAlias();
						id = dto.getId();
						esHombre = false;
						break;
					}
				}
			}

			if (sesionExitosa) {
				JOptionPane.showMessageDialog(vf.getVen(),
						propIdioma.getProperty("panel.info.mensaje.InicioSesionExitoso"),
						propIdioma.getProperty("panel.info.nombre.InicioSesionExitoso"),
						JOptionPane.INFORMATION_MESSAGE);

				boolean estaVerificado = false;
				if (esHombre) {
					HombreDTO hombre = mf.getHombreDao().buscarId(id);
					estaVerificado = hombre.isEstaVerificado();
				} else {
					MujerDTO mujer = mf.getMujerDao().buscarId(id);
					estaVerificado = mujer.isEstaVerificado();
				}

				if (estaVerificado) {
					vf.getpInic().setVisible(false);
					vf.getpScr().setVisible(true);
					vf.getpBan().getBtnPerfil().setVisible(true);
					vf.getpBan().revalidate();
				} else {
					int codigoVerificacion = (int) (Math.random() * 900000) + 100000;

					CorreoDTO dto = new CorreoDTO(correo, alias, codigoVerificacion);
					mf.getCorreoDao().enviarCodigoVerificacion(dto,
							propConfig.getProperty("proyectoFinalSemestre2.idioma"));
					try {
						propConfig.setProperty("proyectoFinalSemestre2.cddvf", "" + codigoVerificacion + "");
						propConfig.store(new FileWriter("config.properties"), null);
					} catch (IOException e) {
					}
					vf.getpInic().setVisible(false);
					vf.getpCV().setVisible(true);
				}

				try {
					propConfig.setProperty("proyectoFinalSemestre2.id", "" + id + "");
					propConfig.store(new FileWriter("config.properties"), null);

					propConfig.setProperty("proyectoFinalSemestre2.generoUsuarioHombre", "" + esHombre + "");
					propConfig.store(new FileWriter("config.properties"), null);

					propConfig.setProperty("proyectoFinalSemestre2.indiceMostrar", "0" + "");
					propConfig.store(new FileWriter("config.properties"), null);

					propConfig.setProperty("proyectoFinalSemestre2.usuarioInicioSesion", "true");
					propConfig.store(new FileWriter("config.properties"), null);

					mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
					vf.getpInic().getTxtEmail().setText("");
					vf.getpInic().getJpfContrasenia().setText("");
				} catch (IOException e) {
				}
				vf.refrescarVista();

			} else {
				JOptionPane.showMessageDialog(vf.getVen(),
						propIdioma.getProperty("panel.error.mensaje.InicioSesionFallido"),
						propIdioma.getProperty("panel.error.nombre.InicioSesionFallido"), JOptionPane.ERROR_MESSAGE);

			}

		}
	}

	/**
	 * Registra un nuevo usuario (hombre o mujer) en el sistema.
	 * <p>
	 * Este método recopila la información ingresada en el panel de registro, valida
	 * los datos mediante la clase {@link LanzadorDeExcepcion}, y crea un objeto
	 * {@link HombreDTO} o {@link MujerDTO} dependiendo del parámetro
	 * {@code esHombre}.
	 * </p>
	 *
	 * <p>
	 * El proceso de registro incluye:
	 * <ul>
	 * <li>Validar los campos de texto: nombre, apellido, alias, correo y
	 * contraseña.</li>
	 * <li>Verificar la fecha de nacimiento y calcular la edad del usuario.</li>
	 * <li>Comprobar que el alias y el correo no estén registrados previamente.</li>
	 * <li>Enviar un correo de confirmación usando {@link CorreoDTO} para verificar
	 * la validez del correo electrónico.</li>
	 * <li>Registrar al usuario en la base de datos si el correo fue enviado
	 * exitosamente.</li>
	 * <li>Mostrar mensajes informativos o de error en función del resultado.</li>
	 * </ul>
	 * </p>
	 *
	 * <p>
	 * Si el registro se completa correctamente, el panel de registro se oculta, se
	 * muestra el panel de inicio de sesión y se actualiza la interfaz con
	 * {@link ViewFacade#refrescarVista()}.
	 * </p>
	 *
	 * @param esHombre {@code true} si el registro corresponde a un hombre,
	 *                 {@code false} si corresponde a una mujer.
	 * 
	 * @throws StringInvalidoException          Si alguno de los textos ingresados
	 *                                          es inválido o está vacío.
	 * @throws FechaNacimientoInvalidaException Si la fecha de nacimiento no tiene
	 *                                          un formato válido o la edad no es
	 *                                          coherente.
	 * @throws CorreoInvalidoException          Si el formato del correo electrónico
	 *                                          es incorrecto.
	 * @throws CorreoExistenteException         Si el correo electrónico ya está
	 *                                          registrado en el sistema.
	 * @throws AliasExistenteException          Si el alias ingresado ya existe en
	 *                                          la base de datos.
	 * @throws ContraseniaDiferenteException    Si las contraseñas ingresadas no
	 *                                          coinciden.
	 * @throws ContraseniaDebilException        Si la contraseña no cumple los
	 *                                          criterios mínimos de seguridad.
	 *
	 */

	public void registrarse(boolean esHombre) {
		/*
		 * String nombre; String apellido; String alias; int edad; String correo; String
		 * contrasenia; String foto; int cantLike; boolean esVisiblePefil; long
		 * edadMinima; long edadMaxima; boolean estaVerificado;
		 */

		try {

			String id = UUID.randomUUID().toString();
			String nombre = vf.getpReg().getTxtNombre().getText();
			LanzadorDeExcepcion.verificarString(nombre);

			String apellido = vf.getpReg().getTxtApellido().getText();
			LanzadorDeExcepcion.verificarString(apellido);

			String alias = vf.getpReg().getTxtAlias().getText();
			LanzadorDeExcepcion.verificarAliasExistente(alias, this.mf);

			String fechaNacimiento = vf.getpReg().getTxtFechaNacimiento().getText();
			int edad = LanzadorDeExcepcion.verificarFechaNacimiento(fechaNacimiento);

			String correo = vf.getpReg().getTxtEmail().getText();
			LanzadorDeExcepcion.verificarCorreoInvalido(correo);
			LanzadorDeExcepcion.verificarCorreoExistente(correo, this.mf);

			String foto = tomarRutaFoto();
			String contrasenia = vf.getpReg().getJpfContrasenia().getText();
			String confirmarContrasenia = vf.getpReg().getJpfContrasenia().getText();
			LanzadorDeExcepcion.verificarContrasenias(contrasenia, confirmarContrasenia);
			String contraseniaAprobada = contrasenia;
			LanzadorDeExcepcion.verificarFortalezaContrasenia(contraseniaAprobada);

			int cantLike = 0;
			int edadMinima = 0;
			int edadMaxima = 0;
			boolean esVisible = false;
			boolean estaVerificado = false;

			CorreoDTO tempCorreo = new CorreoDTO(correo, alias, 0);

			if (mf.getCorreoDao().enviarRegistroExitoso(tempCorreo,
					propConfig.getProperty("proyectoFinalSemestre2.idioma"))) {

				if (esHombre) {
					long ingresoMensual = 0;
					boolean preferenciaDivorcio = false;
					int estatura = 0;
					HombreDTO temp = new HombreDTO(id, nombre, apellido, alias, edad, correo, contraseniaAprobada, foto,
							cantLike, esVisible, edadMinima, edadMaxima, estaVerificado, ingresoMensual,
							preferenciaDivorcio, estatura);
					mf.getHombreDao().crear(temp);
				} else {
					boolean esDivorciada = false;
					int estaturaIdeal = 0;
					int estatura = 0;
					MujerDTO temp = new MujerDTO(id, nombre, apellido, alias, edad, correo, contraseniaAprobada, foto,
							cantLike, esVisible, edadMinima, edadMaxima, estaVerificado, esDivorciada, estaturaIdeal,
							estatura);
					mf.getMujerDao().crear(temp);
				}
				vf.getpReg().setVisible(false);
				vf.getpInic().setVisible(true);
				vf.refrescarVista();
				JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.info.mensaje.cuentaCreada"),
						propIdioma.getProperty("panel.info.nombre.cuentaCreada"), JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(vf.getVen(),
						propIdioma.getProperty("panel.error.mensaje.correoInexistente"),
						propIdioma.getProperty("panel.error.nombre.correoInexistente"), JOptionPane.ERROR_MESSAGE);
			}

		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.formatoInvalido"),
					propIdioma.getProperty("panel.error.nombre.formatoInvalido"), JOptionPane.ERROR_MESSAGE);

		} catch (FechaNacimientoInvalidaException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.fechaNacimientoInvalida"),
					propIdioma.getProperty("panel.error.nombre.fechaNacimientoInvalida"), JOptionPane.ERROR_MESSAGE);

		} catch (StringInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.textoInvalido"),
					propIdioma.getProperty("panel.error.nombre.textoInvalido"), JOptionPane.ERROR_MESSAGE);

		} catch (CorreoInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.formatoCorreo"),
					propIdioma.getProperty("panel.error.nombre.formatoCorreo"), JOptionPane.ERROR_MESSAGE);

		} catch (CorreoExistenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.correoRepetido"),
					propIdioma.getProperty("panel.error.nombre.correoRepetido"), JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.aliasExistente"),
					propIdioma.getProperty("panel.error.nombre.aliasExistente"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.contraseniasNoCoinciden"),
					propIdioma.getProperty("panel.error.nombre.contraseniasNoCoinciden"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.contraseniaDebil"),
					propIdioma.getProperty("panel.error.nombre.contraseniaDebil"), JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Obtiene la ruta de la imagen seleccionada por el usuario en el formulario de
	 * registro.
	 * <p>
	 * Si el usuario no selecciona ninguna imagen, retorna la ruta por defecto
	 * <code>"files/default.png"</code>. En caso de que haya una imagen
	 * seleccionada, esta se copia a la carpeta <code>pfp</code> (creándola si no
	 * existe) y se retorna la ruta relativa del nuevo archivo.
	 * </p>
	 *
	 * @return La ruta relativa de la imagen guardada, o
	 *         <code>"files/default.png"</code> si no se seleccionó ninguna imagen o
	 *         ocurrió un error.
	 *
	 * @throws IOException Si ocurre un error al copiar la imagen seleccionada a la
	 *                     carpeta <code>pfp</code>.
	 *
	 */
	public String tomarRutaFoto() {

		File archivoSeleccionado = vf.getpReg().getArchivoImagenSeleccionada();

		if (archivoSeleccionado == null) {

			return "files/default.png";
		}

		try {
			File carpetaFiles = new File("pfp");

			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.copiasImagen") + e.getMessage(),
					propIdioma.getProperty("panel.error.nombre.copiasImagen"), JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

	/**
	 * Verifica el código de confirmación ingresado por el usuario tras el registro.
	 * <p>
	 * Compara el código ingresado en los campos del panel de verificación con el
	 * valor almacenado en <code>config.properties</code>. Si el código es correcto,
	 * actualiza el estado de verificación del usuario (hombre o mujer) en su
	 * respectiva lista dentro del DAO y muestra la interfaz principal.
	 * </p>
	 *
	 * <p>
	 * Si el código no coincide, muestra un mensaje de error indicando que la
	 * verificación falló.
	 * </p>
	 *
	 * @throws IOException Si ocurre un error al acceder o modificar los archivos de
	 *                     configuración.
	 *
	 */
	public void verificarCodigo() {
		String codigo = propConfig.getProperty("proyectoFinalSemestre2.cddvf");
		StringBuilder sb = new StringBuilder();
		sb.append(vf.getpCV().getTxtfnum1().getText());
		sb.append(vf.getpCV().getTxtfnum2().getText());
		sb.append(vf.getpCV().getTxtfnum3().getText());
		sb.append(vf.getpCV().getTxtfnum4().getText());
		sb.append(vf.getpCV().getTxtfnum5().getText());
		sb.append(vf.getpCV().getTxtfnum6().getText());

		if (!codigo.equals(sb.toString())) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.verificarInvalido"),
					propIdioma.getProperty("panel.error.nombre.verificarInvalido"), JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.info.mensaje.verificar"),
					propIdioma.getProperty("panel.info.nombre.verificar"), JOptionPane.INFORMATION_MESSAGE);
			int indice = 0;
			if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == true) {
				indice = mf.getHombreDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				HombreDTO dto = mf.getHombreDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
				dto.setEstaVerificado(true);
				mf.getHombreDao().getLista().get(indice).setEstaVerificado(true);
				mf.getHombreDao().actualizar(indice, dto);

			} else {
				indice = mf.getMujerDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				MujerDTO dto = mf.getMujerDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
				dto.setEstaVerificado(true);
				mf.getMujerDao().getLista().get(indice).setEstaVerificado(true);
				mf.getMujerDao().actualizar(indice, dto);

			}
			vf.getpCV().setVisible(false);
			vf.getpScr().setVisible(true);
			vf.getpBan().getBtnPerfil().setVisible(true);
			vf.getpBan().revalidate();
			vf.refrescarVista();
		}
	}

	/**
	 * Muestra en la interfaz la información de la persona correspondiente al índice
	 * indicado, según las preferencias del usuario actualmente autenticado.
	 * <p>
	 * Si el usuario es una mujer, se muestra un perfil de hombre que cumpla con sus
	 * preferencias de edad y estatura. Si el usuario es un hombre, se muestra un
	 * perfil de mujer que cumpla con sus preferencias de edad y estado civil.
	 * </p>
	 *
	 * <p>
	 * Si la persona en la posición indicada no cumple con las condiciones de
	 * compatibilidad, el método incrementa el índice (mediante
	 * {@link #aumentarContador()}) y vuelve a intentar mostrar el siguiente perfil
	 * disponible.
	 * </p>
	 *
	 * <p>
	 * Además, este método se encarga de ajustar las imágenes (perfil y atributos),
	 * convertir los valores de ingresos según el idioma configurado, y actualizar
	 * la vista principal del programa.
	 * </p>
	 *
	 * @param indice índice en la lista de usuarios a mostrar.
	 *
	 */

	public void mostrarPersona(int indice) {
		vf.getpScr().ocultarAtributos();

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == false) {
			MujerDTO temp = mf.getMujerDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));

			vf.getpScr().mostrarAtributosHombre();

			HombreDTO dto = mf.getHombreDao().getLista().get(indice);

			if (dto.getEdad() >= temp.getEdadMinima() && dto.getEdad() <= temp.getEdadMaxima()
					&& dto.getEstatura() >= (temp.getEstaturaIdeal() - 5)
					&& dto.getEstatura() <= (temp.getEstaturaIdeal() + 5)) {
				ImageIcon img = new ImageIcon(dto.getFoto());
				Image redimension = img.getImage();
				Image imgRedimensionada = redimension.getScaledInstance(270, 360, Image.SCALE_SMOOTH);
				vf.getpScr().getLblFondo().setIcon(new ImageIcon(imgRedimensionada));
				vf.getpScr().getLblAlias().setText(dto.getAlias());
				vf.getpScr().getLblEdad().setText(String.valueOf(dto.getEdad()));
				vf.getpScr().getLblEstatura().setText(String.valueOf(dto.getEstatura()));
				long ingresos = mf.getConDiv().convertirAIdioma(dto.getIngresoMensual(),
						propConfig.getProperty("proyectoFinalSemestre2.idioma"));
				vf.getpScr().getLblIngresos().setText(String.valueOf(ingresos));

			} else {
				aumentarContador();
				mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
			}

		} else {
			HombreDTO temp = mf.getHombreDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));

			MujerDTO dto = mf.getMujerDao().getLista().get(indice);

			if (dto.isEsDivorciada() == temp.isPreferenciaDivorcio() && dto.getEdad() >= temp.getEdadMinima()
					&& dto.getEdad() <= temp.getEdadMaxima()) {

				if (dto.getEstatura() != 0) {
					vf.getpScr().mostrarAtributosMujer(true);
					vf.getpScr().getLblEstatura().setText(String.valueOf(dto.getEstatura()));
				} else {
					vf.getpScr().mostrarAtributosMujer(false);
				}
				ImageIcon img = new ImageIcon(dto.getFoto());
				Image redimension = img.getImage();
				Image imgRedimensionada = redimension.getScaledInstance(270, 360, Image.SCALE_SMOOTH);
				vf.getpScr().getLblFondo().setIcon(new ImageIcon(imgRedimensionada));
				vf.getpScr().getLblAlias().setText(dto.getAlias());
				vf.getpScr().getLblEdad().setText(String.valueOf(dto.getEdad()));
				boolean esDivorciada = dto.isEsDivorciada();

				String rutaImagen = "";
				if (esDivorciada) {
					rutaImagen = "files/divorciada.jpg";
				} else {
					rutaImagen = "files/noDivorciada.jpg";
				}

				ImageIcon imgDivorcio = new ImageIcon(rutaImagen);
				Image redimensionDivorcio = imgDivorcio.getImage();
				Image imgRedimensionadaDivorcio = redimensionDivorcio.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				vf.getpScr().getLblDivorcio().setIcon(new ImageIcon(imgRedimensionadaDivorcio));

			} else {
				aumentarContador();
				mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
			}
		}

		vf.getpScr().repaint();
		vf.refrescarVista();
	}

	/**
	 * Registra un "me gusta" (smash) sobre la persona actualmente mostrada,
	 * dependiendo del género del usuario configurado.
	 * <p>
	 * Si el usuario es mujer, incrementa el contador de "likes" del
	 * {@link HombreDTO} actual; si el usuario es hombre, lo hace en el
	 * {@link MujerDTO}.
	 * </p>
	 * Tras registrar el "me gusta", el método avanza al siguiente perfil
	 * disponible.
	 */
	public void smash() {
		int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == false) {
			HombreDTO dto = mf.getHombreDao().getLista().get(contador);
			dto.setCantLike(dto.getCantLike() + 1);

			mf.getHombreDao().actualizar(contador, dto);
		} else {
			MujerDTO dto = mf.getMujerDao().getLista().get(contador);
			dto.setCantLike(dto.getCantLike() + 1);
			mf.getMujerDao().actualizar(contador, dto);

		}
		aumentarContador();
	}

	/**
	 * Omite (pasa) el perfil actual y muestra el siguiente disponible.
	 * <p>
	 * Este método no realiza ninguna acción sobre los datos del perfil actual;
	 * simplemente avanza el índice de visualización.
	 * </p>
	 */

	public void pass() {
		aumentarContador();
	}

	/**
	 * Incrementa el índice del perfil mostrado actualmente y lo guarda en el
	 * archivo de configuración.
	 * <p>
	 * Si se alcanza el final de la lista de perfiles del género correspondiente, el
	 * contador se reinicia a 0.
	 * </p>
	 * <p>
	 * Este valor se almacena en el archivo <code>config.properties</code> bajo la
	 * clave <code>proyectoFinalSemestre2.indiceMostrar</code>.
	 * </p>
	 */
	public void aumentarContador() {
		int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));
		contador++;
		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == true
				&& contador >= mf.getHombreDao().getLista().size()) {
			contador = 0;
		} else if (contador >= mf.getMujerDao().getLista().size()) {
			contador = 0;
		}
		propConfig.setProperty("proyectoFinalSemestre2.indiceMostrar", "" + contador + "");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}
	}

	/**
	 * Establece el género del usuario en el archivo de configuración.
	 * <p>
	 * Este valor determina si el usuario es considerado hombre o mujer en el
	 * contexto de la aplicación, y se guarda en el archivo
	 * <code>config.properties</code> bajo la clave
	 * <code>proyectoFinalSemestre2.generoHombre</code>.
	 * </p>
	 *
	 * @param esHombre {@code true} si el usuario es hombre, {@code false} si es
	 *                 mujer.
	 */
	public void generoSeleccionadoHombre(boolean esHombre) {
		propConfig.setProperty("proyectoFinalSemestre2.generoHombre", "" + esHombre + "");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}
	}

	/**
	 * Carga los datos del perfil del usuario hombre desde el modelo y los muestra
	 * en la interfaz gráfica correspondiente.
	 * <p>
	 * Obtiene la información del {@link HombreDTO} asociado al ID guardado en las
	 * propiedades de configuración y actualiza todos los campos visibles del panel
	 * de perfil de hombre, incluyendo nombre, alias, edad, estatura, ingresos,
	 * preferencias de edad y visibilidad del perfil.
	 * </p>
	 * <p>
	 * Además, carga la foto de perfil asociada al usuario y la establece en el
	 * componente visual correspondiente.
	 * </p>
	 */
	public void perfilHombre() {
		HombreDTO dto = mf.getHombreDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
		vf.getpPH().getLblNombreUsuario().setText(dto.getNombre());
		vf.getpPH().getLblApellidoUsuario().setText(dto.getApellido());
		vf.getpPH().getTxtAlias().setText(dto.getAlias());
		vf.getpPH().getLblEmailUsuario().setText(dto.getCorreo());
		vf.getpPH().getLblEdadUsuario().setText("" + dto.getEdad());
		vf.getpPH().getJpfContrasenia().setText(dto.getContrasenia());
		vf.getpPH().getJpfConfirmarContrasenia().setText(dto.getContrasenia());
		vf.getpPH().getTxtEstatura().setText("" + dto.getEstatura());
		long ingreso = mf.getConDiv().convertirAIdioma(dto.getIngresoMensual(),
				propConfig.getProperty("proyectoFinalSemestre2.idioma"));
		vf.getpPH().getTxtIngresosMensuales().setText("" + ingreso);
		vf.getpPH().getTxtEdadMinima().setText("" + dto.getEdadMinima());
		vf.getpPH().getTxtEdadMaxima().setText("" + dto.getEdadMaxima());
		vf.getpPH().getChkVisibilidad().setSelected(dto.isEsVisiblePefil());

		String rutaFoto = dto.getFoto();
		File archivoImagen = new File(rutaFoto);
		vf.getpPH().setArchivoImagenSeleccionada(archivoImagen);
	}

	/**
	 * Carga los datos del perfil del usuario mujer desde el modelo y los muestra en
	 * la interfaz gráfica correspondiente.
	 * <p>
	 * Obtiene la información del {@link MujerDTO} asociada al ID guardado en las
	 * propiedades de configuración y actualiza todos los campos visibles del panel
	 * de perfil de mujer, incluyendo nombre, alias, edad, estatura, estatura ideal,
	 * rango de edad preferido, visibilidad y estado civil (divorciada o no).
	 * </p>
	 * <p>
	 * Además, carga la foto de perfil asociada al usuario y la establece en el
	 * componente visual correspondiente.
	 * </p>
	 */
	public void perfilMujer() {
		MujerDTO dto = mf.getMujerDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
		vf.getpPM().getLblNombreUsuario().setText(dto.getNombre());
		vf.getpPM().getLblApellidoUsuario().setText(dto.getApellido());
		vf.getpPM().getTxtAlias().setText(dto.getAlias());
		vf.getpPM().getLblEmailUsuario().setText(dto.getCorreo());
		vf.getpPM().getLblEdadUsuario().setText("" + dto.getEdad());
		vf.getpPM().getJpfContrasenia().setText(dto.getContrasenia());
		vf.getpPM().getJpfConfirmarContrasenia().setText(dto.getContrasenia());
		vf.getpPM().getTxtEstatura().setText("" + dto.getEstatura());
		vf.getpPM().getTxtEstaturaIdeal().setText("" + dto.getEstaturaIdeal());
		vf.getpPM().getTxtEdadMinima().setText("" + dto.getEdadMinima());
		vf.getpPM().getTxtEdadMaxima().setText("" + dto.getEdadMaxima());
		vf.getpPM().getChkVisibilidad().setSelected(dto.isEsVisiblePefil());
		vf.getpPM().getChkDivorciada().setSelected(dto.isEsDivorciada());

		String rutaFoto = dto.getFoto();
		File archivoImagen = new File(rutaFoto);
		vf.getpPM().setArchivoImagenSeleccionada(archivoImagen);
	}

	/**
	 * Actualiza la información del perfil de un usuario hombre con los nuevos datos
	 * ingresados en el panel de perfil.
	 * <p>
	 * Este método obtiene los valores actuales del formulario, realiza
	 * verificaciones de validez (como coincidencia de contraseñas, formato
	 * numérico, fortaleza de contraseña y existencia del alias), y luego crea un
	 * nuevo {@link HombreDTO} con los datos actualizados.
	 * </p>
	 * <p>
	 * Finalmente, actualiza el registro correspondiente en el DAO, muestra un
	 * mensaje de éxito al usuario y cambia la vista al panel principal.
	 * </p>
	 *
	 * @throws InputMismatchException             si se ingresan valores no válidos
	 *                                            en campos numéricos.
	 * @throws AliasExistenteActualizadoException si el alias ingresado ya está en
	 *                                            uso por otro usuario.
	 * @throws ContraseniaDiferenteException      si las contraseñas no coinciden.
	 * @throws ContraseniaDebilException          si la contraseña no cumple con los
	 *                                            requisitos mínimos de seguridad.
	 * @throws NumeroInvalidoException            si los valores numéricos no
	 *                                            cumplen con el formato o rango
	 *                                            esperado.
	 *
	 */
	public void actualizarHombre() {

		try {
			HombreDTO dto = mf.getHombreDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
			int indice = mf.getHombreDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));

			String id = dto.getId();
			String nombre = dto.getNombre();
			String apellido = dto.getApellido();
			String correo = dto.getCorreo();
			int cantLike = dto.getCantLike();
			boolean estaVerificado = dto.isEstaVerificado();

			String alias = vf.getpPH().getTxtAlias().getText();
			LanzadorDeExcepcion.verificarAliasExistenteActualizado(dto.getAlias(), alias, this.mf);

			int edad = dto.getEdad();

			String contrasenia = vf.getpPH().getJpfContrasenia().getText();
			String confirmarContrasenia = vf.getpPH().getJpfContrasenia().getText();
			LanzadorDeExcepcion.verificarContrasenias(contrasenia, confirmarContrasenia);
			String contraseniaAprobada = contrasenia;
			LanzadorDeExcepcion.verificarFortalezaContrasenia(contraseniaAprobada);

			long edadMinima = Integer.parseInt(vf.getpPH().getTxtEdadMinima().getText());
			LanzadorDeExcepcion.verificarNumero(edadMinima);

			long edadMaxima = Integer.parseInt(vf.getpPH().getTxtEdadMaxima().getText());
			LanzadorDeExcepcion.verificarNumero(edadMaxima);

			boolean esVisible = vf.getpPH().getChkVisibilidad().isSelected();

			long ingresoMensual = Integer.parseInt(vf.getpPH().getTxtIngresosMensuales().getText());
			LanzadorDeExcepcion.verificarNumero(ingresoMensual);
			ingresoMensual = mf.getConDiv().convertirADolar(ingresoMensual,
					propConfig.getProperty("proyectoFinalSemestre2.idioma"));

			boolean preferenciaDivorcio = vf.getpPH().getChkDivorcioPreferencia().isSelected();

			int estatura = Integer.parseInt(vf.getpPH().getTxtEstatura().getText());
			LanzadorDeExcepcion.verificarNumero(estatura);

			String foto = tomarRutaFotoHombre();

			HombreDTO dtoActualizado = new HombreDTO(id, nombre, apellido, alias, edad, correo, contraseniaAprobada,
					foto, cantLike, esVisible, edadMinima, edadMaxima, estaVerificado, ingresoMensual,
					preferenciaDivorcio, estatura);
			mf.getHombreDao().actualizar(indice, dtoActualizado);

			vf.getpPH().setVisible(false);
			vf.getpScr().setVisible(true);
			vf.refrescarVista();
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.info.mensaje.exito"),
					propIdioma.getProperty("panel.info.nombre.exito"), JOptionPane.INFORMATION_MESSAGE);
		} catch (

		InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.formatoInvalido"),
					propIdioma.getProperty("panel.error.nombre.formatoInvalido"), JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteActualizadoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.aliasExistente"),
					propIdioma.getProperty("panel.error.nombre.aliasExistente"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.contraseniasNoCoinciden"),
					propIdioma.getProperty("panel.error.nombre.contraseniasNoCoinciden"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.contraseniaDebil"),
					propIdioma.getProperty("panel.error.nombre.contraseniaDebil"), JOptionPane.ERROR_MESSAGE);
		} catch (NumeroInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.caracterInvalido"),
					propIdioma.getProperty("panel.error.nombre.caracterInvalido"), JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Copia la imagen seleccionada por el usuario en la carpeta "pfp" del proyecto
	 * y devuelve la ruta donde se almacenó la imagen.
	 * <p>
	 * Si el usuario no selecciona ninguna imagen, se devuelve la ruta por defecto
	 * {@code "files/default.png"}.
	 * </p>
	 *
	 * @return la ruta de la imagen copiada dentro de la carpeta "pfp", o la ruta
	 *         por defecto si no se seleccionó ninguna imagen o si ocurre un error.
	 */
	public String tomarRutaFotoHombre() {

		File archivoSeleccionado = vf.getpPH().getArchivoImagenSeleccionada();

		if (archivoSeleccionado == null) {
			return "files/default.png";
		}

		try {

			File carpetaFiles = new File("pfp");

			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.copiasImagen") + e.getMessage(),
					propIdioma.getProperty("panel.error.nombre.copiasImagen"), JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

	/**
	 * Actualiza la información de una mujer registrada en el sistema utilizando los
	 * datos ingresados en la interfaz gráfica.
	 * <p>
	 * Se validan los datos antes de ser actualizados, incluyendo alias,
	 * contraseñas, números y valores booleanos. Si ocurre algún error de validación
	 * o formato, se muestra un mensaje de error al usuario.
	 * </p>
	 * <p>
	 * Si la actualización es exitosa, la vista de perfil se oculta y se muestra la
	 * vista principal.
	 * </p>
	 *
	 * @throws InputMismatchException             si algún campo numérico contiene
	 *                                            caracteres inválidos.
	 * @throws AliasExistenteActualizadoException si el alias ingresado ya existe en
	 *                                            otro registro.
	 * @throws ContraseniaDiferenteException      si las contraseñas no coinciden.
	 * @throws ContraseniaDebilException          si la contraseña no cumple con los
	 *                                            requisitos mínimos.
	 * @throws NumeroInvalidoException            si algún número ingresado no es
	 *                                            válido.
	 */
	public void actualizarMujer() {

		try {
			MujerDTO dto = mf.getMujerDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));
			int indice = mf.getMujerDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));

			String id = dto.getId();
			String nombre = dto.getNombre();
			String apellido = dto.getApellido();
			String correo = dto.getCorreo();
			int cantLike = dto.getCantLike();
			boolean estaVerificado = dto.isEstaVerificado();

			String alias = vf.getpPM().getTxtAlias().getText();
			LanzadorDeExcepcion.verificarAliasExistenteActualizado(dto.getAlias(), alias, this.mf);

			int edad = dto.getEdad();

			String contrasenia = vf.getpPM().getJpfContrasenia().getText();
			String confirmarContrasenia = vf.getpPM().getJpfContrasenia().getText();
			LanzadorDeExcepcion.verificarContrasenias(contrasenia, confirmarContrasenia);
			String contraseniaAprobada = contrasenia;
			LanzadorDeExcepcion.verificarFortalezaContrasenia(contraseniaAprobada);

			long edadMinima = Integer.parseInt(vf.getpPM().getTxtEdadMinima().getText());
			LanzadorDeExcepcion.verificarNumero(edadMinima);

			long edadMaxima = Integer.parseInt(vf.getpPM().getTxtEdadMaxima().getText());
			LanzadorDeExcepcion.verificarNumero(edadMaxima);

			boolean esVisible = vf.getpPM().getChkVisibilidad().isSelected();

			int estaturaIdeal = Integer.parseInt(vf.getpPM().getTxtEstaturaIdeal().getText());
			LanzadorDeExcepcion.verificarNumero(estaturaIdeal);

			boolean esDivorciada = vf.getpPM().getChkDivorciada().isSelected();

			int estatura = Integer.parseInt(vf.getpPM().getTxtEstatura().getText());
			LanzadorDeExcepcion.verificarNumero(estatura);

			String foto = tomarRutaFotoMujer();

			MujerDTO dtoActualizado = new MujerDTO(id, nombre, apellido, alias, edad, correo, contraseniaAprobada, foto,
					cantLike, esVisible, edadMinima, edadMaxima, estaVerificado, esDivorciada, estaturaIdeal, estatura);
			mf.getMujerDao().actualizar(indice, dtoActualizado);

			vf.getpPM().setVisible(false);
			vf.getpScr().setVisible(true);
			vf.refrescarVista();
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.info.mensaje.exito"),
					propIdioma.getProperty("panel.info.nombre.exito"), JOptionPane.INFORMATION_MESSAGE);
		} catch (

		InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.formatoInvalido"),
					propIdioma.getProperty("panel.error.nombre.formatoInvalido"), JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteActualizadoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.aliasExistente"),
					propIdioma.getProperty("panel.error.nombre.aliasExistente"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.contraseniasNoCoinciden"),
					propIdioma.getProperty("panel.error.nombre.contraseniasNoCoinciden"), JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.contraseniaDebil"),
					propIdioma.getProperty("panel.error.nombre.contraseniaDebil"), JOptionPane.ERROR_MESSAGE);
		} catch (NumeroInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.error.mensaje.caracterInvalido"),
					propIdioma.getProperty("panel.error.nombre.caracterInvalido"), JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Copia la imagen seleccionada por el usuario en la carpeta {@code "pfp"} del
	 * proyecto y devuelve la ruta donde se almacenó la imagen.
	 * <p>
	 * Si el usuario no selecciona ninguna imagen, se devuelve la ruta por defecto
	 * {@code "files/default.png"}.
	 * </p>
	 *
	 * @return la ruta de la imagen copiada dentro de la carpeta {@code "pfp"}, o la
	 *         ruta por defecto si no se seleccionó ninguna imagen o si ocurre un
	 *         error.
	 */
	public String tomarRutaFotoMujer() {

		File archivoSeleccionado = vf.getpPM().getArchivoImagenSeleccionada();

		if (archivoSeleccionado == null) {

			return "files/default.png";
		}

		try {

			File carpetaFiles = new File("pfp");

			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					propIdioma.getProperty("panel.error.mensaje.copiasImagen") + e.getMessage(),
					propIdioma.getProperty("panel.error.nombre.copiasImagen"), JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

	/**
	 * Elimina la cuenta del usuario actualmente autenticado, ya sea hombre o mujer,
	 * previa confirmación del usuario mediante un cuadro de diálogo.
	 * <p>
	 * Si el usuario confirma la eliminación, se elimina el registro correspondiente
	 * del DAO y se restablece la interfaz gráfica al estado inicial de inicio de
	 * sesión. Además, se actualiza el archivo de configuración para indicar que no
	 * hay sesión activa.
	 * </p>
	 *
	 * <p>
	 * En caso de error de escritura del archivo {@code config.properties}, se
	 * ignora la excepción.
	 * </p>
	 */
	public void eliminarCuenta() {

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == true) {
			int eliminar = JOptionPane.showConfirmDialog(vf.getVen(),
					propIdioma.getProperty("panel.advertencia.mensaje.borrarCuenta"),
					propIdioma.getProperty("panel.advertencia.nombre.borrarCuenta"), JOptionPane.WARNING_MESSAGE);
			if (eliminar == 0) {
				int indice = mf.getHombreDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				mf.getHombreDao().eliminar(indice);
				vf.getpPH().setVisible(false);
				vf.getpInic().getTxtEmail().setText("");
				vf.getpInic().getJpfContrasenia().setText("");
				vf.getpInic().setVisible(true);
				vf.getpBan().getBtnPerfil().setVisible(false);
				vf.getpScr().ocultarAtributos();
				vf.refrescarVista();
			}
		} else {
			int eliminar = JOptionPane.showConfirmDialog(vf.getVen(),
					propIdioma.getProperty("panel.advertencia.mensaje.borrarCuenta"),
					propIdioma.getProperty("panel.advertencia.nombre.borrarCuenta"), JOptionPane.WARNING_MESSAGE);
			if (eliminar == 0) {
				int indice = mf.getMujerDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				mf.getMujerDao().eliminar(indice);
				vf.getpPM().setVisible(false);
				vf.getpInic().getTxtEmail().setText("");
				vf.getpInic().getJpfContrasenia().setText("");
				vf.getpInic().setVisible(true);
				vf.getpBan().getBtnPerfil().setVisible(false);
				vf.getpScr().ocultarAtributos();
				vf.refrescarVista();
			}
		}
		try {
			propConfig.setProperty("proyectoFinalSemestre2.usuarioInicioSesion", "false");
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}
	}

	/**
	 * Alterna el modo de ordenamiento (ascendente o descendente) de los datos en la
	 * vista principal.
	 * <p>
	 * Si el modo actual es ascendente, cambia al modo descendente y viceversa. El
	 * nuevo estado se almacena en el archivo de configuración
	 * {@code config.properties} bajo la propiedad
	 * {@code "proyectoFinalSemestre2.modoAscendente"}.
	 * </p>
	 *
	 * <p>
	 * Este método invoca las funciones {@link vf#ordenAscendente()} y
	 * {@link vf#ordenDescendente()} según el estado actual del modo de
	 * ordenamiento.
	 * </p>
	 */
	public void filtrarOrden() {
		boolean modoAscendente = Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoAscendente"));
		if (modoAscendente) {
			vf.ordenDescendente();
			modoAscendente = false;
		} else {
			vf.ordenAscendente();
			modoAscendente = true;
		}

		propConfig.setProperty("proyectoFinalSemestre2.modoAscendente", "" + modoAscendente + "");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}

	}

	/**
	 * Aplica los filtros y el ordenamiento seleccionados por el administrador en la
	 * interfaz.
	 * <p>
	 * Dependiendo de la opción seleccionada en el combo {@code CmbFiltro}, el
	 * método muestra los resultados filtrados o ordenados en el panel de
	 * administración.
	 * </p>
	 *
	 * <ul>
	 * <li><b>Alias, Nombre, Apellido, Likes, Edad:</b> Aplica orden ascendente o
	 * descendente según configuración.</li>
	 * <li><b>Top 10 Likes:</b> Muestra los 10 usuarios (hombres o mujeres) con más
	 * likes.</li>
	 * <li><b>Ingresos:</b> Muestra los hombres con ingresos mensuales mayores o
	 * iguales a 245.</li>
	 * </ul>
	 *
	 * <p>
	 * También controla la visibilidad de los botones y combos de filtro del panel
	 * de administrador según la selección actual. Los cambios se reflejan
	 * visualmente en la interfaz mediante los métodos {@code mostrarHombre()} y
	 * {@code mostrarMujer()}.
	 * </p>
	 */
	public void filtrarAdministrador() {
		vf.getpAdmin().getBtnOrden().setVisible(true);
		vf.getpAdmin().getCmbGenero().setVisible(true);
		boolean ordenAscendente = Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoAscendente"));

		if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Top 10 Likes")
				|| vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Ingresos")) {
			vf.getpAdmin().getBtnOrden().setVisible(false);

		} else {
			if (ordenAscendente) {
				if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Alias")) {
					mf.getHombreDao().menorAMayorSeleccionAlias();
					mf.getMujerDao().menorAMayorSeleccionAlias();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Nombre")) {
					mf.getHombreDao().menorAMayorSeleccionNombre();
					mf.getMujerDao().menorAMayorSeleccionNombre();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Apellido")) {
					mf.getHombreDao().menorAMayorSeleccionApellido();
					mf.getMujerDao().menorAMayorSeleccionApellido();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Likes")) {
					mf.getHombreDao().menorAMayorInsercionCantLike();
					mf.getMujerDao().menorAMayorInsercionCantLike();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Edad")) {
					mf.getHombreDao().menorAMayorInsercionEdad();
					mf.getMujerDao().menorAMayorInsercionEdad();
				}

			} else {
				if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Alias")) {
					mf.getHombreDao().mayorAMenorSeleccionAlias();
					mf.getMujerDao().mayorAMenorSeleccionAlias();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Nombre")) {
					mf.getHombreDao().mayorAMenorSeleccionNombre();
					mf.getMujerDao().mayorAMenorSeleccionNombre();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Apellido")) {
					mf.getHombreDao().mayorAMenorSeleccionApellido();
					mf.getMujerDao().mayorAMenorSeleccionApellido();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Likes")) {
					mf.getHombreDao().mayorAMenorInsercionCantLike();
					mf.getMujerDao().mayorAMenorInsercionCantLike();
				} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Edad")) {
					mf.getHombreDao().mayorAMenorInsercionEdad();
					mf.getMujerDao().mayorAMenorInsercionEdad();
				}
			}
		}

		if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Ingresos")) {
			vf.getpAdmin().getCmbGenero().setVisible(false);
			ArrayList<HombreDTO> listaFiltrada = new ArrayList<HombreDTO>();
			for (int i = 0; i < mf.getHombreDao().getLista().size(); i++) {
				if (mf.getHombreDao().getLista().get(i).getIngresoMensual() >= 245) {
					listaFiltrada.add(mf.getHombreDao().getLista().get(i));
				}
			}
			vf.getpAdmin().mostrarHombre(listaFiltrada, this);
		} else if (vf.getpAdmin().getCmbFiltro().getSelectedItem().equals("Top 10 Likes")) {

			if (vf.getpAdmin().getCmbGenero().getSelectedItem().equals("Hombre")) {
				mf.getHombreDao().mayorAMenorInsercionCantLike();
				ArrayList<HombreDTO> listaFiltrada = new ArrayList<HombreDTO>();
				for (int i = 0; i < 10; i++) {
					listaFiltrada.add(mf.getHombreDao().getLista().get(i));
				}
				vf.getpAdmin().mostrarHombre(listaFiltrada, this);

			} else {
				mf.getMujerDao().mayorAMenorInsercionCantLike();
				ArrayList<MujerDTO> listaFiltrada = new ArrayList<MujerDTO>();
				for (int i = 0; i < 10; i++) {
					listaFiltrada.add(mf.getMujerDao().getLista().get(i));
				}
				vf.getpAdmin().mostrarMujer(listaFiltrada, this);

			}

		} else {
			if (vf.getpAdmin().getCmbGenero().getSelectedItem().equals("Hombre")) {
				vf.getpAdmin().mostrarHombre(mf.getHombreDao().getLista(), this);
			} else {
				vf.getpAdmin().mostrarMujer(mf.getMujerDao().getLista(), this);
			}
		}

	}

	/**
	 * Maneja los eventos de acción generados por los distintos componentes de la
	 * interfaz gráfica.
	 * <p>
	 * Este método se ejecuta automáticamente cuando ocurre una acción asociada a un
	 * botón, menú u otro componente con un comando específico. Según el comando
	 * recibido, se invocan diferentes métodos del controlador o se actualiza la
	 * interfaz.
	 * </p>
	 *
	 * <p>
	 * <b>Principales funcionalidades:</b>
	 * </p>
	 * <ul>
	 * <li>Alternar entre modo oscuro y claro.</li>
	 * <li>Cambiar el idioma de la aplicación.</li>
	 * <li>Manejar el proceso de inicio de sesión y registro de usuarios.</li>
	 * <li>Controlar la visibilidad de los paneles según el flujo de
	 * navegación.</li>
	 * <li>Realizar acciones como “smash”, “pass”, y mostrar perfiles.</li>
	 * <li>Actualizar o eliminar usuarios.</li>
	 * <li>Filtrar y ordenar la información del panel de administrador.</li>
	 * <li>Generar reportes PDF con estadísticas.</li>
	 * </ul>
	 *
	 * <p>
	 * Además, maneja comandos dinámicos como <code>"eliminarX"</code>, donde
	 * <code>X</code> representa el índice del elemento a eliminar.
	 * </p>
	 *
	 * @param e el evento de acción que contiene el comando ejecutado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		// Inicio switch
		switch (comando) {
		case "modo oscuro": {
			modoOscuro();
			break;
		}

		case "idioma": {
			idioma();
			break;
		}

		case "iniciar sesion": {
			iniciarSesion();
			break;
		}

		case "registrarse": {
			vf.getpInic().setVisible(false);
			vf.getpGen().setVisible(true);
			vf.refrescarVista();
			break;
		}

		case "registrarse hombre": {
			vf.getpGen().setVisible(false);
			vf.getpReg().setVisible(true);
			generoSeleccionadoHombre(true);
			vf.refrescarVista();
			break;
		}

		case "registrarse mujer": {
			vf.getpGen().setVisible(false);
			vf.getpReg().setVisible(true);
			generoSeleccionadoHombre(false);
			vf.refrescarVista();
			break;
		}

		case "registro completo": {
			registrarse(Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoHombre")));
			break;
		}

		case "volver inicio sesion": {
			vf.getpGen().setVisible(false);
			vf.getpInic().setVisible(true);
			vf.refrescarVista();
			break;
		}

		case "volver seleccionar genero": {
			vf.getpReg().setVisible(false);
			vf.getpGen().setVisible(true);
			vf.refrescarVista();
			break;
		}

		case "verificar": {
			verificarCodigo();
			break;
		}

		case "cerrar sesion": {
			vf.getpBan().getCmbIdioma().setVisible(true);
			vf.getpAdmin().setVisible(false);
			vf.getpCV().setVisible(false);
			vf.getpInic().getTxtEmail().setText("");
			vf.getpInic().getJpfContrasenia().setText("");
			vf.getpInic().setVisible(true);
			vf.refrescarVista();
			break;
		}

		case "smash": {
			smash();
			mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
			vf.refrescarVista();
			break;
		}

		case "pass": {
			pass();
			mostrarPersona(Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar")));
			vf.refrescarVista();
			break;
		}

		case "volver panel principal": {
			vf.getpPH().setVisible(false);
			vf.getpPM().setVisible(false);
			vf.getpScr().setVisible(true);
			break;
		}

		case "perfil": {
			if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre"))) {
				vf.getpScr().setVisible(false);
				vf.getpPH().setVisible(true);
				perfilHombre();
			} else {
				perfilMujer();
				vf.getpScr().setVisible(false);
				vf.getpPM().setVisible(true);
			}
			vf.refrescarVista();
			break;
		}

		case "actualizar hombre": {
			actualizarHombre();
			break;
		}

		case "actualizar mujer": {
			actualizarMujer();
			break;
		}

		case "cerrar sesion perfil": {
			vf.getpPH().setVisible(false);
			vf.getpPM().setVisible(false);
			vf.getpInic().setVisible(true);
			vf.getpBan().getBtnPerfil().setVisible(false);
			vf.getpScr().ocultarAtributos();
			propConfig.setProperty("proyectoFinalSemestre2.usuarioInicioSesion", "false");
			try {
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (IOException s) {
			}
			JOptionPane.showMessageDialog(vf.getVen(), propIdioma.getProperty("panel.info.mensaje.cerrarSesion"),
					propIdioma.getProperty("panel.info.nombre.cerrarSesion"), JOptionPane.INFORMATION_MESSAGE);
			vf.refrescarVista();
			break;
		}

		case "eliminar cuenta": {
			eliminarCuenta();
			break;
		}

		case "filtrar orden": {
			filtrarOrden();
			filtrarAdministrador();
			break;
		}

		case "filtrar": {
			filtrarAdministrador();
			break;
		}

		case "crear pdf": {
			mf.getcPdf().crearPDF();
			JOptionPane.showMessageDialog(vf.getVen(), "El pdf de estadisticas ha sido creado con exito",
					"Creacion PDF", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
		// Fin casos switch
		}
		// Fin switch
		if (comando.startsWith("eliminar")) {
			String ind = comando.replace("eliminar", "").trim();
			int indice = Integer.parseInt(ind);
			int retorno = JOptionPane.showConfirmDialog(vf.getVen(),
					propIdioma.getProperty("panel.advertencia.mensaje.borrarCuenta"),
					propIdioma.getProperty("panel.advertencia.nombre.borrarCuenta"), JOptionPane.WARNING_MESSAGE);

			if (retorno == 0) {
				if (vf.getpAdmin().getCmbGenero().getSelectedItem().equals("Hombre")
						|| vf.getpAdmin().getCmbGenero().getSelectedItem().equals("Ingresos")) {
					mf.getHombreDao().eliminar(indice);
				} else {
					mf.getMujerDao().eliminar(indice);
				}

				filtrarAdministrador();
			}
		}

	}

	/**
	 * Inicializa los oyentes de acción (ActionListener) para todos los componentes
	 * interactivos de la interfaz gráfica.
	 * <p>
	 * Este método asocia cada botón, combo box u otro elemento de la vista con el
	 * controlador, definiendo además un comando de acción específico que permitirá
	 * identificar el evento dentro del método
	 * {@code actionPerformed(ActionEvent e)}.
	 * </p>
	 *
	 * <p>
	 * <b>Responsabilidades principales:</b>
	 * </p>
	 * <ul>
	 * <li>Asignar ActionListeners a los botones y elementos de los distintos
	 * paneles.</li>
	 * <li>Definir los comandos de acción que determinan el comportamiento de cada
	 * evento.</li>
	 * <li>Conectar la interfaz gráfica (vista) con la lógica del controlador.</li>
	 * </ul>
	 *
	 * <p>
	 * Paneles afectados:
	 * </p>
	 * <ul>
	 * <li>Banner (modo oscuro, idioma, perfil)</li>
	 * <li>Inicio de sesión</li>
	 * <li>Selección de género</li>
	 * <li>Registro de usuario</li>
	 * <li>Código de verificación</li>
	 * <li>Panel principal (scroll)</li>
	 * <li>Perfiles (hombre y mujer)</li>
	 * <li>Administrador</li>
	 * </ul>
	 */
	public void inicializarOyentes() {
		// Panel Banner
		vf.getpBan().getBtnModoOscuro().addActionListener(this);
		vf.getpBan().getBtnModoOscuro().setActionCommand("modo oscuro");

		vf.getpBan().getCmbIdioma().addActionListener(this);
		vf.getpBan().getCmbIdioma().setActionCommand("idioma");

		vf.getpBan().getBtnPerfil().addActionListener(this);
		vf.getpBan().getBtnPerfil().setActionCommand("perfil");

		// Panel Iniciar Sesion
		vf.getpInic().getBtnIniciarSesion().addActionListener(this);
		vf.getpInic().getBtnIniciarSesion().setActionCommand("iniciar sesion");

		vf.getpInic().getBtnRegistrar().addActionListener(this);
		vf.getpInic().getBtnRegistrar().setActionCommand("registrarse");

		// Panel Seleccionar Genero
		vf.getpGen().getBtnHombre().addActionListener(this);
		vf.getpGen().getBtnHombre().setActionCommand("registrarse hombre");

		vf.getpGen().getBtnMujer().addActionListener(this);
		vf.getpGen().getBtnMujer().setActionCommand("registrarse mujer");

		vf.getpGen().getBtnVolver().addActionListener(this);
		vf.getpGen().getBtnVolver().setActionCommand("volver inicio sesion");

		// Panel registrarse
		vf.getpReg().getBtnRegistrar().addActionListener(this);
		vf.getpReg().getBtnRegistrar().setActionCommand("registro completo");

		vf.getpReg().getBtnCancelar().addActionListener(this);
		vf.getpReg().getBtnCancelar().setActionCommand("volver seleccionar genero");

		// Panel Codigo Verificacion
		vf.getpCV().getBtnCerrarSesion().addActionListener(this);
		vf.getpCV().getBtnCerrarSesion().setActionCommand("cerrar sesion");

		vf.getpCV().getBtnVerificar().addActionListener(this);
		vf.getpCV().getBtnVerificar().setActionCommand("verificar");

		// Panel Principal (Panel Scroll)
		vf.getpScr().getBtnSmash().addActionListener(this);
		vf.getpScr().getBtnSmash().setActionCommand("smash");

		vf.getpScr().getBtnPass().addActionListener(this);
		vf.getpScr().getBtnPass().setActionCommand("pass");

		// Panel perfil Hombre
		vf.getpPH().getBtnActualizar().addActionListener(this);
		vf.getpPH().getBtnActualizar().setActionCommand("actualizar hombre");

		vf.getpPH().getBtnCancelar().addActionListener(this);
		vf.getpPH().getBtnCancelar().setActionCommand("volver panel principal");

		vf.getpPH().getBtnCerrarSesion().addActionListener(this);
		vf.getpPH().getBtnCerrarSesion().setActionCommand("cerrar sesion perfil");

		vf.getpPH().getBtnEliminarCuenta().addActionListener(this);
		vf.getpPH().getBtnEliminarCuenta().setActionCommand("eliminar cuenta");

		// Panel perfil Mujer
		vf.getpPM().getBtnActualizar().addActionListener(this);
		vf.getpPM().getBtnActualizar().setActionCommand("actualizar mujer");

		vf.getpPM().getBtnCancelar().addActionListener(this);
		vf.getpPM().getBtnCancelar().setActionCommand("volver panel principal");

		vf.getpPM().getBtnCerrarSesion().addActionListener(this);
		vf.getpPM().getBtnCerrarSesion().setActionCommand("cerrar sesion perfil");

		vf.getpPM().getBtnEliminarCuenta().addActionListener(this);
		vf.getpPM().getBtnEliminarCuenta().setActionCommand("eliminar cuenta");

		// Panel administrador
		vf.getpAdmin().getCmbFiltro().addActionListener(this);
		vf.getpAdmin().getCmbFiltro().setActionCommand("filtrar");

		vf.getpAdmin().getCmbGenero().addActionListener(this);
		vf.getpAdmin().getCmbGenero().setActionCommand("filtrar");

		vf.getpAdmin().getBtnOrden().addActionListener(this);
		vf.getpAdmin().getBtnOrden().setActionCommand("filtrar orden");

		vf.getpAdmin().getBtnCerrarSesion().addActionListener(this);
		vf.getpAdmin().getBtnCerrarSesion().setActionCommand("cerrar sesion");

		vf.getpAdmin().getBtnCrearPdf().addActionListener(this);
		vf.getpAdmin().getBtnCrearPdf().setActionCommand("crear pdf");

		vf.getpPa().getBtnDarDeBaja().addActionListener(this);
	}

	/**
	 * Asigna los textos correspondientes a cada componente visible de los distintos
	 * paneles, utilizando las propiedades cargadas desde el archivo de idioma
	 * actual.
	 * <p>
	 * Este método permite cambiar el idioma de todos los textos mostrados en la
	 * interfaz gráfica (botones, etiquetas, títulos, etc.) sin modificar el código
	 * fuente.
	 * </p>
	 *
	 * <p>
	 * <b>Responsabilidades principales:</b>
	 * </p>
	 * <ul>
	 * <li>Actualizar las etiquetas, botones y títulos de todos los paneles.</li>
	 * <li>Utilizar las claves definidas en el archivo de propiedades de
	 * idioma.</li>
	 * <li>Garantizar la coherencia visual del idioma seleccionado por el
	 * usuario.</li>
	 * </ul>
	 *
	 * <p>
	 * Paneles afectados:
	 * </p>
	 * <ul>
	 * <li>Administrador</li>
	 * <li>Código de verificación</li>
	 * <li>Inicio de sesión</li>
	 * <li>Perfiles (hombre y mujer)</li>
	 * <li>Panel principal (scroll)</li>
	 * <li>Registro de usuario</li>
	 * <li>Selección de género</li>
	 * </ul>
	 */
	public void cadenasTextoPaneles() {
		// vf.getpAdmin().setBtnTextoDescPdf(propIdioma.getProperty("admin.btn.descPdf"));
		// vf.getpAdmin().setBtnTextoElimUss(propIdioma.getProperty("admin.btn.elimUss"));

		vf.getpCV().setLabelTextoTitulo(propIdioma.getProperty("cv.lbl.titulo"));
		vf.getpCV().setBtnTextoCerrarSesion(propIdioma.getProperty("cv.btn.cerrarSesion"));
		vf.getpCV().setBtnTextoVerificar(propIdioma.getProperty("cv.btn.verificar"));

		vf.getpInic().getLblEmail().setText(propIdioma.getProperty("inic.lbl.email"));
		vf.getpInic().getLblContrasenia().setText(propIdioma.getProperty("inic.lbl.contra"));
		vf.getpInic().getBtnIniciarSesion().setText(propIdioma.getProperty("inic.btn.iniciarSesion"));
		vf.getpInic().getBtnRegistrar().setText(propIdioma.getProperty("inic.btn.registrar"));

		vf.getpPH().getLblFondo().setText(propIdioma.getProperty("perfil.lbl.tituloHombre"));
		vf.getpPH().getLblAlias().setText(propIdioma.getProperty("perfil.lbl.alias"));
		vf.getpPH().getLblNombre().setText(propIdioma.getProperty("perfil.lbl.nombre"));
		vf.getpPH().getLblApellido().setText(propIdioma.getProperty("perfil.lbl.apellido"));
		vf.getpPH().getLblEmail().setText(propIdioma.getProperty("perfil.lbl.email"));
		vf.getpPH().getLblContrasenia().setText(propIdioma.getProperty("perfil.lbl.NuevaContraseña"));
		vf.getpPH().getLblConfirmarContrasenia().setText(propIdioma.getProperty("perfil.lbl.ConfirmarContraseña"));
		vf.getpPH().getLblEstatura().setText(propIdioma.getProperty("perfil.lbl.estatura"));
		vf.getpPH().getLblEdad().setText(propIdioma.getProperty("perfil.lbl.edad"));
		vf.getpPH().getLblEdadMinima().setText(propIdioma.getProperty("perfil.lbl.edadMinima"));
		vf.getpPH().getLblEdadMaxima().setText(propIdioma.getProperty("perfil.lbl.edadMaxima"));
		vf.getpPH().getLblIngresosMensuales().setText(propIdioma.getProperty("perfil.lbl.ingresos"));
		vf.getpPH().getChkDivorcioPreferencia().setText(propIdioma.getProperty("perfil.lbl.mostrarDivorcio"));
		vf.getpPH().getChkVisibilidad().setText(propIdioma.getProperty("perfil.lbl.visibilidad"));
		vf.getpPH().getBtnCancelar().setText(propIdioma.getProperty("perfil.btn.cancelar"));
		vf.getpPH().getBtnSeleccionarFoto().setText(propIdioma.getProperty("perfil.lbl.fotoPerf"));
		vf.getpPH().getBtnCerrarSesion().setText(propIdioma.getProperty("perfil.btn.cerrarSesion"));
		vf.getpPH().getBtnEliminarCuenta().setText(propIdioma.getProperty("perfil.btn.EliminarCuenta"));

		vf.getpPM().getLblAlias().setText(propIdioma.getProperty("perfil.lbl.tituloMujer"));
		vf.getpPM().getLblAlias().setText(propIdioma.getProperty("perfil.lbl.alias"));
		vf.getpPM().getLblNombre().setText(propIdioma.getProperty("perfil.lbl.nombre"));
		vf.getpPM().getLblApellido().setText(propIdioma.getProperty("perfil.lbl.apellido"));
		vf.getpPM().getLblEmail().setText(propIdioma.getProperty("perfil.lbl.email"));
		vf.getpPM().getLblContrasenia().setText(propIdioma.getProperty("perfil.lbl.NuevaContraseña"));
		vf.getpPM().getLblConfirmarContrasenia().setText(propIdioma.getProperty("perfil.lbl.ConfirmarContraseña"));
		vf.getpPM().getLblEstatura().setText(propIdioma.getProperty("perfil.lbl.estatura"));
		vf.getpPM().getLblEdad().setText(propIdioma.getProperty("perfil.lbl.edad"));
		vf.getpPM().getLblEdadMinima().setText(propIdioma.getProperty("perfil.lbl.edadMinima"));
		vf.getpPM().getLblEdadMaxima().setText(propIdioma.getProperty("perfil.lbl.edadMaxima"));
		vf.getpPM().getLblEstaturaIdeal().setText(propIdioma.getProperty("perfil.lbl.estaIdeal"));
		vf.getpPM().getChkVisibilidad().setText(propIdioma.getProperty("perfil.lbl.visibilidad"));
		vf.getpPM().getChkDivorciada().setText(propIdioma.getProperty("perfil.lbl.divorcio"));
		vf.getpPM().getBtnSeleccionarFoto().setText(propIdioma.getProperty("perfil.lbl.fotoPerf"));
		vf.getpPM().getBtnCancelar().setText(propIdioma.getProperty("perfil.btn.cancelar"));
		vf.getpPM().getBtnActualizar().setText(propIdioma.getProperty("perfil.btn.actualizar"));
		vf.getpPM().getBtnCerrarSesion().setText(propIdioma.getProperty("perfil.btn.cerrarSesion"));
		vf.getpPM().getBtnEliminarCuenta().setText(propIdioma.getProperty("perfil.btn.EliminarCuenta"));

		vf.getpScr().getLblEdadTexto().setText(propIdioma.getProperty("scroll.lbl.edad"));
		vf.getpScr().getLblIngresosTexto().setText(propIdioma.getProperty("scroll.lbl.ingresos"));
		vf.getpScr().getLblDivorcioTexto().setText(propIdioma.getProperty("scroll.lbl.divorciada"));
		vf.getpScr().getLblEstaturaTexto().setText(propIdioma.getProperty("scroll.lbl.estatura"));

		vf.getpReg().getLblFondo().setText(propIdioma.getProperty("reg.lbl.titulo"));
		vf.getpReg().getLblFotoPerfil().setText(" ");
		vf.getpReg().getLblNombre().setText(propIdioma.getProperty("reg.lbl.nombre"));
		vf.getpReg().getLblApellido().setText(propIdioma.getProperty("reg.lbl.apellido"));
		vf.getpReg().getLblAlias().setText(propIdioma.getProperty("reg.lbl.alias"));
		vf.getpReg().getLblEmail().setText(propIdioma.getProperty("reg.lbl.email"));
		vf.getpReg().getLblFechaNacimiento().setText(propIdioma.getProperty("reg.lbl.fechaNac"));
		vf.getpReg().getLblContrasenia().setText(propIdioma.getProperty("reg.lbl.contra"));
		vf.getpReg().getLblConfirmarContrasenia().setText(propIdioma.getProperty("reg.lbl.confirContra"));
		vf.getpReg().getBtnSeleccionarFoto().setText(propIdioma.getProperty("reg.btn.SeleccionarFoto"));
		vf.getpReg().getBtnRegistrar().setText(propIdioma.getProperty("reg.btn.registrar"));
		vf.getpReg().getBtnCancelar().setText(propIdioma.getProperty("reg.btn.cancelar"));

		vf.getpScr().getBtnSmash().setText(propIdioma.getProperty("scroll.lbl.smash"));
		vf.getpScr().getBtnPass().setText("X");

		vf.getpGen().setLblTextoTitulo(propIdioma.getProperty("gen.lbl.titulo"));
		vf.getpGen().setLblTextoHombre(propIdioma.getProperty("gen.lbl.hombre"));
		vf.getpGen().setLblTextoMujer(propIdioma.getProperty("gen.lbl.mujer"));
		vf.getpGen().setBtnTextoVolver(propIdioma.getProperty("gen.btn.volver"));

	}

}
