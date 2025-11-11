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

public class Controlador implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties propIdioma;
	private Properties propConfig;

	public Controlador() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		propConfig = FileHandler.cargarArchivoDePropiedades("config.properties");
		FileHandler.cargarArchivoDePropiedades(propConfig.getProperty("proyectoFinalSemestre2.idioma"));
		vf.getpBan().getCmbIdioma().setSelectedItem(propConfig.getProperty("proyectoFinalSemestre2.idioma"));
		inicializarOyentes();
		inicializarConfig();
		cadenasTextoPaneles();
		idioma();
	}

	public void runGUI() {

		// Panel __iniciar__ __sesion__
		vf.getpInic().setBounds(360, 70, 560, 620);
		vf.getVen().getCapas().add(vf.getpInic(), JLayeredPane.PALETTE_LAYER);

		// Panel banner
		vf.getpBan().setBounds(0, 801, 1280, 80);
		vf.getVen().getCapas().add(vf.getpBan(), JLayeredPane.PALETTE_LAYER);

		vf.refrescarVista();
		vf.getVen().setVisible(true);

		// Panel __seleccionar__ __genero__
		vf.getpGen().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpGen(), JLayeredPane.PALETTE_LAYER);
		vf.getpGen().setVisible(false);

		// Panel __registrarse__
		vf.getpReg().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpReg(), JLayeredPane.PALETTE_LAYER);
		vf.getpReg().setVisible(false);

		// Panel __Codigo__ __Verificacion__
		vf.getpCV().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpCV(), JLayeredPane.PALETTE_LAYER);
		vf.getpCV().setVisible(false);

		// Panel Scroll (Principal)
		vf.getpScr().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpScr(), JLayeredPane.PALETTE_LAYER);
		vf.getpScr().setVisible(false);

		// Panel __Perfil__ __Hombre__
		vf.getpPH().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpPH(), JLayeredPane.PALETTE_LAYER);
		vf.getpPH().setVisible(false);

		// Panel __Perfil__ __Mujer__
		vf.getpPM().setBounds(0, 0, 1280, 800);
		vf.getVen().getCapas().add(vf.getpPM(), JLayeredPane.PALETTE_LAYER);
		vf.getpPM().setVisible(false);
	}

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

	}

	public void modoOscuro() {
		boolean modoOscuro = Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.modoOscuro"));
		try {
			if (modoOscuro) {
				// Si está en oscuro, cambia a claro
				propConfig.setProperty("proyectoFinalSemestre2.modoOscuro", "false");
				propConfig.store(new FileWriter("config.properties"), null);
				vf.modoClaro();
			} else {
				// Si está en claro, cambia a oscuro
				propConfig.setProperty("proyectoFinalSemestre2.modoOscuro", "true");
				propConfig.store(new FileWriter("config.properties"), null);
				vf.modoOscuro();
			}
			vf.refrescarVista();
		} catch (InputMismatchException | IOException e) {
			e.printStackTrace();
		}
	}

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
		vf.getpBan().getCmbIdioma().setSelectedItem(idioma);
		cadenasTextoPaneles();
		vf.refrescarVista();
	}

	public void iniciarSesion() {
		String correo = vf.getpInic().getTxtEmail().getText();
		String contrasenia = vf.getpInic().getJpfContrasenia().getText();

		if (correo.equals(mf.getAdmin().getCorreoAdmin()) && contrasenia.equals(mf.getAdmin().getContraseniaAdmin())) {

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
				JOptionPane.showMessageDialog(vf.getVen(), "¡El inicio de sesión ha sido exitoso!",
						"Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);

				boolean estaVerificado = false;
				if (esHombre) {
					HombreDTO hombre = mf.getHombreDao().buscarId(id);
					estaVerificado = hombre.isEstaVerificado();
				} else {
					MujerDTO mujer = mf.getMujerDao().buscarId(id);
					estaVerificado = mujer.isEstaVerificado();
					System.out.println(estaVerificado);
				}

				if (estaVerificado) {
					vf.getpInic().setVisible(false);
					vf.getpScr().setVisible(true);
					mostrarPersona(0);
					vf.getpBan().getBtnPerfil().setVisible(true);
					vf.getpBan().revalidate();
				} else {
					int codigoVerificacion = (int) (Math.random() * 900000) + 100000;

					CorreoDTO dto = new CorreoDTO(correo, alias, codigoVerificacion);
					mf.getCorreoDao().enviarCodigoVerificacion(dto);
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

				} catch (IOException e) {
				}
				vf.refrescarVista();

			} else {
				JOptionPane.showMessageDialog(vf.getVen(), "La contraseña o el correo son incorrectos",
						"Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);

			}

		}
	}

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

			if (mf.getCorreoDao().enviarRegistroExitoso(tempCorreo)) {

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
				JOptionPane.showMessageDialog(vf.getVen(), "Cuenta creada", "Proceso exitoso",
						JOptionPane.INFORMATION_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(vf.getVen(), "El correo no existe", "Registro fallido",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Formato de entrada inválido. Revisa los campos ingresados.",
					"Error de entrada", JOptionPane.ERROR_MESSAGE);

		} catch (FechaNacimientoInvalidaException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "La fecha de nacimiento ingresada no es válida.",
					"Fecha inválida", JOptionPane.ERROR_MESSAGE);

		} catch (StringInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Se ha detectado texto inválido en uno de los campos.",
					"Texto inválido", JOptionPane.ERROR_MESSAGE);

		} catch (CorreoInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "El formato del correo ingresado no es válido.",
					"Correo inválido", JOptionPane.ERROR_MESSAGE);

		} catch (CorreoExistenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					"El correo ingresado ya está registrado. Usa otro o inicia sesión.", "Correo existente",
					JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "El alias o nombre de usuario ya está en uso. Intenta con otro.",
					"Alias existente", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Las contraseñas no coinciden. Verifica e inténtalo de nuevo.",
					"Contraseña no coincide", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					"La contraseña es demasiado débil. Usa al menos 8 caracteres, con mayúsculas, minúsculas y números.",
					"Contraseña débil", JOptionPane.ERROR_MESSAGE);
		}

	}

	public String tomarRutaFoto() {

		File archivoSeleccionado = vf.getpReg().getArchivoImagenSeleccionada();

		// Verificar si hay una imagen seleccionada
		if (archivoSeleccionado == null) {
			// No se seleccionó ninguna imagen, retornar default
			return "files/default.png";
		}

		try {
			// Crear carpeta pfp si no existe
			File carpetaFiles = new File("pfp");

			// Crear archivo de destino dentro de esa carpeta
			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			// Copiar imagen seleccionada a la carpeta pfp
			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			// Retornar ruta relativa
			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Error al copiar la imagen: " + e.getMessage(),
					"Error al copiar la imagen", JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

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
			JOptionPane.showMessageDialog(vf.getVen(), "Error al verificar", "El codigo no ingresado no es correcto",
					JOptionPane.ERROR_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(vf.getVen(), "Verificacion completada", "El codigo ingresado es correcto",
					JOptionPane.INFORMATION_MESSAGE);
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
				System.err.println(mf.getMujerDao().getLista().get(indice).isEstaVerificado());
			}
			vf.getpCV().setVisible(false);
			vf.getpScr().setVisible(true);
			vf.getpBan().getBtnPerfil().setVisible(true);
			vf.getpBan().revalidate();
			vf.refrescarVista();
		}
	}

	public void mostrarPersona(int indice) {

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == false) {
			MujerDTO temp = mf.getMujerDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));

			if (false) {
				int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));
				aumentarContador();
			} else {
				vf.getpScr().mostrarAtributosHombre();
				HombreDTO dto = mf.getHombreDao().getLista().get(indice);

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
			}
		} else {
			HombreDTO temp = mf.getHombreDao().buscarId(propConfig.getProperty("proyectoFinalSemestre2.id"));

			if (false) {
				int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));
				aumentarContador();
			} else {
				MujerDTO dto = mf.getMujerDao().getLista().get(indice);
				if (dto.getEstatura() != 0) {
					vf.getpScr().mostrarAtributosMujer(true);
				} else {
					vf.getpScr().mostrarAtributosMujer(false);
				}
				ImageIcon img = new ImageIcon(dto.getFoto());
				Image redimension = img.getImage();
				Image imgRedimensionada = redimension.getScaledInstance(270, 360, Image.SCALE_SMOOTH);
				vf.getpScr().getLblFondo().setIcon(new ImageIcon(imgRedimensionada));
				vf.getpScr().getLblAlias().setText(dto.getAlias());
				vf.getpScr().getLblEdad().setText(String.valueOf(dto.getEdad()));
				vf.getpScr().getLblEdad().setText(String.valueOf(dto.isEsDivorciada()));
			}
		}
		vf.refrescarVista();
	}

	public void smash() {
		int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == false) {
			int cantLike = mf.getMujerDao().getLista().get(contador).getCantLike() + 1;
			mf.getMujerDao().getLista().get(contador).setCantLike(cantLike);
		} else {
			int cantLike = mf.getHombreDao().getLista().get(contador).getCantLike() + 1;
			mf.getHombreDao().getLista().get(contador).setCantLike(cantLike);
		}
		aumentarContador();
	}

	public void pass() {
		int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));
		aumentarContador();
	}

	public void aumentarContador() {
		int contador = Integer.parseInt(propConfig.getProperty("proyectoFinalSemestre2.indiceMostrar"));
		contador++;
		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == true) {
			contador = 0;
		} else {
			contador = 0;
		}
		propConfig.setProperty("proyectoFinalSemestre2.indiceMostrar", "" + contador + "");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}
	}

	public void generoSeleccionadoHombre(boolean esHombre) {
		propConfig.setProperty("proyectoFinalSemestre2.generoHombre", "" + esHombre + "");
		try {
			propConfig.store(new FileWriter("config.properties"), null);
		} catch (IOException e) {
		}
	}

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
		vf.getpPH().getTxtIngresosMensuales().setText("" + dto.getIngresoMensual());
		vf.getpPH().getTxtEdadMinima().setText("" + dto.getEdadMinima());
		vf.getpPH().getTxtEdadMaxima().setText("" + dto.getEdadMaxima());
		vf.getpPH().getChkVisibilidad().setSelected(dto.isEsVisiblePefil());

		String rutaFoto = dto.getFoto();
		File archivoImagen = new File(rutaFoto);
		vf.getpPH().setArchivoImagenSeleccionada(archivoImagen);
	}

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
			JOptionPane.showMessageDialog(vf.getVen(), "Proceso Exitoso", "Perfil actualizado",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (

		InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Formato de entrada inválido. Revisa los campos ingresados.",
					"Error de entrada", JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteActualizadoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "El alias o nombre de usuario ya está en uso. Intenta con otro.",
					"Alias existente", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Las contraseñas no coinciden. Verifica e inténtalo de nuevo.",
					"Contraseña no coincide", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					"La contraseña es demasiado débil. Usa al menos 8 caracteres, con mayúsculas, minúsculas y números.",
					"Contraseña débil", JOptionPane.ERROR_MESSAGE);
		} catch (NumeroInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Solo se permiten caracteres numericos",
					"Valor numerico invalido", JOptionPane.ERROR_MESSAGE);
		}

	}

	public String tomarRutaFotoHombre() {
		// Obtener el archivo seleccionado del panel
		File archivoSeleccionado = vf.getpPH().getArchivoImagenSeleccionada();

		// Verificar si hay una imagen seleccionada
		if (archivoSeleccionado == null) {
			// No se seleccionó ninguna imagen, retornar default
			return "files/default.png";
		}

		try {
			// Crear carpeta pfp si no existe
			File carpetaFiles = new File("pfp");

			// Crear archivo de destino dentro de esa carpeta
			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			// Copiar imagen seleccionada a la carpeta pfp
			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			// Retornar ruta relativa
			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Error al copiar la imagen: " + e.getMessage(),
					"Error al copiar la imagen", JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

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
			JOptionPane.showMessageDialog(vf.getVen(), "Proceso Exitoso", "Perfil actualizado",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (

		InputMismatchException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Formato de entrada inválido. Revisa los campos ingresados.",
					"Error de entrada", JOptionPane.ERROR_MESSAGE);

		} catch (AliasExistenteActualizadoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "El alias o nombre de usuario ya está en uso. Intenta con otro.",
					"Alias existente", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDiferenteException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Las contraseñas no coinciden. Verifica e inténtalo de nuevo.",
					"Contraseña no coincide", JOptionPane.ERROR_MESSAGE);

		} catch (ContraseniaDebilException e) {
			JOptionPane.showMessageDialog(vf.getVen(),
					"La contraseña es demasiado débil. Usa al menos 8 caracteres, con mayúsculas, minúsculas y números.",
					"Contraseña débil", JOptionPane.ERROR_MESSAGE);
		} catch (NumeroInvalidoException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Solo se permiten caracteres numericos",
					"Valor numerico invalido", JOptionPane.ERROR_MESSAGE);
		}

	}

	public String tomarRutaFotoMujer() {
		// Obtener el archivo seleccionado del panel
		File archivoSeleccionado = vf.getpPM().getArchivoImagenSeleccionada();

		// Verificar si hay una imagen seleccionada
		if (archivoSeleccionado == null) {
			// No se seleccionó ninguna imagen, retornar default
			return "files/default.png";
		}

		try {
			// Crear carpeta pfp si no existe
			File carpetaFiles = new File("pfp");

			// Crear archivo de destino dentro de esa carpeta
			String nombreArchivo = archivoSeleccionado.getName();
			File destino = new File(carpetaFiles, nombreArchivo);

			// Copiar imagen seleccionada a la carpeta pfp
			Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

			// Retornar ruta relativa
			return "pfp/" + nombreArchivo;

		} catch (IOException e) {
			JOptionPane.showMessageDialog(vf.getVen(), "Error al copiar la imagen: " + e.getMessage(),
					"Error al copiar la imagen", JOptionPane.ERROR_MESSAGE);
			return "files/default.png";
		}
	}

	public void eliminarCuenta() {

		if (Boolean.parseBoolean(propConfig.getProperty("proyectoFinalSemestre2.generoUsuarioHombre")) == true) {
			int eliminar = JOptionPane.showConfirmDialog(vf.getVen(), "Esta accion no es reversible",
					"Confirmar eliminacion", JOptionPane.WARNING_MESSAGE);
			if (eliminar == 0) {
				int indice = mf.getHombreDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				mf.getHombreDao().eliminar(indice);
				vf.getpPH().setVisible(false);
				vf.getpInic().setVisible(true);
				vf.getpBan().getBtnPerfil().setVisible(false);
				vf.getpScr().ocultarAtributos();
				vf.refrescarVista();
			}
		} else {
			int eliminar = JOptionPane.showConfirmDialog(vf.getVen(), "Esta accion no es reversible",
					"Confirmar eliminacion", JOptionPane.WARNING_MESSAGE);
			if (eliminar == 0) {
				int indice = mf.getMujerDao().buscarIdIndice(propConfig.getProperty("proyectoFinalSemestre2.id"));
				mf.getMujerDao().eliminar(indice);
				vf.getpPM().setVisible(false);
				vf.getpInic().setVisible(true);
				vf.getpBan().getBtnPerfil().setVisible(false);
				vf.getpScr().ocultarAtributos();
				vf.refrescarVista();
			}
		}
	}

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
			vf.getpCV().setVisible(false);
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
			vf.refrescarVista();
			break;
		}

		case "eliminar cuenta": {
			eliminarCuenta();
			break;
		}

		// Fin casos switch
		}
		// Fin switch
	}

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

	}

	public void cadenasTextoPaneles() {
		vf.getpAdmin().setBtnTextoDescPdf(propIdioma.getProperty("admin.btn.descPdf"));
		vf.getpAdmin().setBtnTextoElimUss(propIdioma.getProperty("admin.btn.elimUss"));

		vf.getpCV().setLabelTextoTitulo(propIdioma.getProperty("cv.lbl.titulo"));
		vf.getpCV().setBtnTextoCerrarSesion(propIdioma.getProperty("cv.btn.cerrarSesion"));
		vf.getpCV().setBtnTextoVerificar(propIdioma.getProperty("cv.btn.verificar"));

		vf.getpInic().getLblEmail().setText(propIdioma.getProperty("inic.lbl.email"));
		vf.getpInic().getLblContrasenia().setText(propIdioma.getProperty("inic.lbl.contra"));
		vf.getpInic().getBtnIniciarSesion().setText(propIdioma.getProperty("inic.btn.iniciarSesion"));
		vf.getpInic().getBtnRegistrar().setText(propIdioma.getProperty("inic.btn.registrar"));

		vf.getpPH().getLblAlias().setText(propIdioma.getProperty("perfil.lbl.alias"));
		vf.getpPH().getLblNombre().setText(propIdioma.getProperty("perfil.lbl.nombre"));
		vf.getpPH().getLblApellido().setText(propIdioma.getProperty("perfil.lbl.apellido"));
		vf.getpPH().getLblEmail().setText(propIdioma.getProperty("perfil.lbl.email"));
		vf.getpPH().getLblEstatura().setText(propIdioma.getProperty("perfil.lbl.estatura"));
		vf.getpPH().getLblEdadMinima().setText(propIdioma.getProperty("perfil.lbl.edadMinima"));
		vf.getpPH().getLblEdadMaxima().setText(propIdioma.getProperty("perfil.lbl.edadMaxima"));
		vf.getpPH().getLblIngresosMensuales().setText(propIdioma.getProperty("perfil.lbl.ingresos"));
		vf.getpPH().getChkDivorcioPreferencia().setText(propIdioma.getProperty("perfil.lbl.mostrarDivorcio"));
		vf.getpPH().getChkVisibilidad().setText(propIdioma.getProperty("perfil.lbl.visibilidad"));
		vf.getpPH().getBtnActualizar().setText(propIdioma.getProperty("perfil.btn.actualizar"));
		vf.getpPH().getBtnCancelar().setText(propIdioma.getProperty("perfil.btn.cancelar"));
		vf.getpPH().getBtnCerrarSesion().setText(propIdioma.getProperty("perfil.btn.cerrarSesion"));

		vf.getpPM().getLblAlias().setText(propIdioma.getProperty("perfil.lbl.alias"));
		vf.getpPM().getLblNombre().setText(propIdioma.getProperty("perfil.lbl.nombre"));
		vf.getpPM().getLblApellido().setText(propIdioma.getProperty("perfil.lbl.apellido"));
		vf.getpPM().getLblEmail().setText(propIdioma.getProperty("perfil.lbl.email"));
		vf.getpPM().getLblEstatura().setText(propIdioma.getProperty("perfil.lbl.estatura"));
		vf.getpPM().getLblEdadMinima().setText(propIdioma.getProperty("perfil.lbl.edadMinima"));
		vf.getpPM().getLblEdadMaxima().setText(propIdioma.getProperty("perfil.lbl.edadMaxima"));
		vf.getpPM().getLblEstaturaIdeal().setText(propIdioma.getProperty("perfil.lbl.estaIdeal"));
		vf.getpPM().getChkVisibilidad().setText(propIdioma.getProperty("perfil.lbl.visibilidad"));
		vf.getpPM().getBtnActualizar().setText(propIdioma.getProperty("perfil.btn.actualizar"));
		vf.getpPM().getBtnCancelar().setText(propIdioma.getProperty("perfil.btn.cancelar"));
		vf.getpPM().getBtnCerrarSesion().setText(propIdioma.getProperty("perfil.btn.cerrarSesion"));

		vf.getpScr().getLblEdadTexto().setText(propIdioma.getProperty("scroll.lbl.edad"));
		vf.getpScr().getLblIngresosTexto().setText(propIdioma.getProperty("scroll.lbl.ingresos"));
		vf.getpScr().getLblDivorcioTexto().setText(propIdioma.getProperty("scroll.lbl.divorciada"));
		vf.getpScr().getLblEstaturaTexto().setText(propIdioma.getProperty("scroll.lbl.estatura"));

		vf.getpReg().getLblNombre().setText(propIdioma.getProperty("reg.lbl.nombre"));
		vf.getpReg().getLblApellido().setText(propIdioma.getProperty("reg.lbl.apellido"));
		vf.getpReg().getLblAlias().setText(propIdioma.getProperty("reg.lbl.alias"));
		vf.getpReg().getLblEmail().setText(propIdioma.getProperty("reg.lbl.email"));
		vf.getpReg().getLblFechaNacimiento().setText(propIdioma.getProperty("reg.lbl.fechaNac"));
		vf.getpReg().getLblContrasenia().setText(propIdioma.getProperty("reg.lbl.contra"));
		vf.getpReg().getLblConfirmarContrasenia().setText(propIdioma.getProperty("reg.lbl.confirContra"));
		vf.getpReg().getBtnRegistrar().setText(propIdioma.getProperty("reg.btn.registrar"));
		vf.getpReg().getBtnCancelar().setText(propIdioma.getProperty("reg.btn.cancelar"));

		vf.getpScr().getBtnSmash().setText("<3");
		vf.getpScr().getBtnPass().setText("X");

		vf.getpGen().setLblTextoTitulo(propIdioma.getProperty("gen.lbl.titulo"));
		vf.getpGen().setLblTextoHombre(propIdioma.getProperty("gen.lbl.hombre"));
		vf.getpGen().setLblTextoMujer(propIdioma.getProperty("gen.lbl.mujer"));
		vf.getpGen().setBtnTextoVolver(propIdioma.getProperty("gen.btn.volver"));

	}

}
