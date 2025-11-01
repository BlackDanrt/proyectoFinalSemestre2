package co.edu.unbosque.controller;

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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.CorreoDTO;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.AliasExistenteException;
import co.edu.unbosque.util.exception.ContraseniaDebilException;
import co.edu.unbosque.util.exception.ContraseniaDiferenteException;
import co.edu.unbosque.util.exception.CorreoExistenteException;
import co.edu.unbosque.util.exception.CorreoInvalidoException;
import co.edu.unbosque.util.exception.FechaNacimientoInvalidaException;
import co.edu.unbosque.util.exception.IntInvalidoException;
import co.edu.unbosque.util.exception.LanzadorDeExcepcion;
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
		idioma();
	}

	public void runGUI() {

		// Panel iniciar sesion
		vf.getpInic().setBounds(360, 70, 560, 620);
		vf.getVen().add(vf.getpInic());
		vf.getVen().add(vf.getpBan());

		// Panel banner
		vf.getpBan().setBounds(0, 801, 1280, 80);
		vf.getVen().add(vf.getpBan());

		vf.refrescarVista();
		vf.getVen().setVisible(true);

		// Panel seleccionar genero
		vf.getpGen().setBounds(0, 0, 1280, 800);
		vf.getVen().add(vf.getpGen());
		vf.getpGen().setVisible(false);

		// Panel registrarse
		vf.getpReg().setBounds(0, 0, 1280, 800);
		vf.getVen().add(vf.getpReg());
		vf.getpReg().setVisible(false);

		// Panel Codigo Verificacion
		vf.getpCV().setBounds(0, 0, 1280, 800);
		vf.getVen().add(vf.getpCV());
		vf.getpCV().setVisible(false);
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
		vf.refrescarVista();
	}

	public void iniciarSesion() {
		String correo = vf.getpInic().getTxtEmail().getText();
		String contrasenia = vf.getpInic().getJpfContrasenia().getText();

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
					alias = dto.getId();
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
			}

			if (estaVerificado) {
			} else {
				int codigoVerificacion = (int) (Math.random() * 900000) + 100000;

				CorreoDTO dto = new CorreoDTO(correo, alias, codigoVerificacion);
				mf.getCorreoDao().enviarCodigoVerificacion(dto);
				try {
					propConfig.setProperty("proyectoFinalSemestre2.cddvf", "" + codigoVerificacion + "");
					propConfig.store(new FileWriter("config.properties"), null);
				} catch (IOException e) {
				}
			}

			try {
				propConfig.setProperty("proyectoFinalSemestre2.id", "" + id + "");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (IOException e) {
			}

		} else {
			JOptionPane.showMessageDialog(vf.getVen(), "La contraseña o el correo son incorrectos",
					"Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);

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
			LanzadorDeExcepcion.verificarAliasExistente(alias);

			String fechaNacimiento = vf.getpReg().getTxtFechaNacimiento().getText();
			int edad = LanzadorDeExcepcion.verificarFechaNacimiento(fechaNacimiento);

			String correo = vf.getpReg().getTxtEmail().getText();
			LanzadorDeExcepcion.verificarCorreoInvalido(correo);
			LanzadorDeExcepcion.verificarCorreoExistente(correo);

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

			} else {
				// JPanel de error
			}

		} catch (InputMismatchException e) {
		} catch (FechaNacimientoInvalidaException e) {
		} catch (StringInvalidoException e) {
		} catch (CorreoInvalidoException e) {
		} catch (CorreoExistenteException e) {
		} catch (AliasExistenteException e) {
		} catch (ContraseniaDiferenteException e) {
		} catch (ContraseniaDebilException e) {
		}

	}

	public String tomarRutaFoto() {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Selecciona tu foto de perfil");

		// Solo permitir imágenes
		fileChooser.setFileFilter(
				new javax.swing.filechooser.FileNameExtensionFilter("Imágenes (JPG, PNG, JPEG)", "jpg", "jpeg", "png"));

		int resultado = fileChooser.showOpenDialog(null);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivoSeleccionado = fileChooser.getSelectedFile();

			try {
				// Carpeta de destino (ya existente)
				File carpetaFiles = new File("files");

				// Crear archivo de destino dentro de esa carpeta
				String nombreArchivo = archivoSeleccionado.getName();
				File destino = new File(carpetaFiles, nombreArchivo);

				// Copiar imagen seleccionada a la carpeta files
				Files.copy(archivoSeleccionado.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING);

				// Ruta relativa (adaptada al proyecto)
				return "files/" + nombreArchivo;

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error al copiar la imagen: " + e.getMessage());
				// Si ocurre un error, también devolvemos la imagen por defecto
				return "files/default.png";
			}
		} else {
			// Si no se seleccionó nada, devolvemos la imagen por defecto
			return "files/default.png";
		}
	}

	public void verificarCodigo() {
		String codigo = propConfig.getProperty("proyectoFInalSemestre2.cddvf");
		StringBuilder sb = new StringBuilder();
		sb.append(vf.getpCV().getTxtfnum1().getText());
		sb.append(vf.getpCV().getTxtfnum2().getText());
		sb.append(vf.getpCV().getTxtfnum3().getText());
		sb.append(vf.getpCV().getTxtfnum4().getText());
		sb.append(vf.getpCV().getTxtfnum5().getText());
		sb.append(vf.getpCV().getTxtfnum6().getText());

		if (!codigo.equals(sb.toString())) {
			// Tirar error
		} else {
			// Tirar aprobacion
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
			vf.refrescarVista();
			break;
		}
		case "registrarse mujer": {
			vf.getpGen().setVisible(false);
			vf.getpReg().setVisible(true);
			vf.refrescarVista();
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
		case "cerrar sesion": {
			vf.getpCV().setVisible(false);
			vf.getpInic().setVisible(true);
			vf.refrescarVista();
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
		vf.getpReg().getBtnCancelar().addActionListener(this);
		vf.getpReg().getBtnCancelar().setActionCommand("volver seleccionar genero");

		// Panel Codigo Verificacion
		vf.getpCV().getBtnCerrarSesion().addActionListener(this);
		vf.getpCV().getBtnCerrarSesion().setActionCommand("cerrar sesion");

		vf.getpCV().getBtnVerificar().addActionListener(this);
		vf.getpCV().getBtnVerificar().setActionCommand("verificar");
	}
	
	public void cadenasTextoPaneles() {
		vf.getpAdmin().setBtnTextoDescPdf(propIdioma.getProperty("admin.btn.descPdf"));
		vf.getpAdmin().setBtnTextoElimUss(propIdioma.getProperty("admin.btn.elimUss"));
		
		vf.getpCV().setLabelTextoTitulo(propIdioma.getProperty("cv.lbl.titulo"));
		vf.getpCV().setBtnTextoCerrarSesion(propIdioma.getProperty("cv.btn.cerrarSesion"));
		vf.getpCV().setBtnTextoVerificar(propIdioma.getProperty("cv.btn.verificar"));
				
		vf.getpInic().setLblTextoEmail(propIdioma.getProperty("inic.lbl.email"));
		vf.getpInic().setLblTextoContra(propIdioma.getProperty("inic.lbl.contra"));
		vf.getpInic().setBtnTextoIniciarSesion(propIdioma.getProperty("inic.btn.iniciarSesion"));
		vf.getpInic().setBtnTextoRegistrar(propIdioma.getProperty("inic.btn.registrar"));
		
		vf.getpPerfil().setLblTextoTitulo(propIdioma.getProperty("perfil.lbl.titulo"));
		vf.getpPerfil().setLblTextoFotoPerf(propIdioma.getProperty("perfil.lbl.fotoPerf"));
		vf.getpPerfil().setLblTextoNombre(propIdioma.getProperty("perfil.lbl.nombre"));
		vf.getpPerfil().setLblTextoApellido(propIdioma.getProperty("perfil.lbl.apellido"));
		vf.getpPerfil().setLblTextoAlias(propIdioma.getProperty("perfil.lbl.alias"));
		vf.getpPerfil().setLblTextoEstatura(propIdioma.getProperty("perfil.lbl.estatura"));
		vf.getpPerfil().setLblTextoVisible(propIdioma.getProperty("perfil.lbl.visible"));
		vf.getpPerfil().setLblTextoEstaIdeal(propIdioma.getProperty("perfil.lbl.estaIdeal"));
		vf.getpPerfil().setLblTextoEdadMinima(propIdioma.getProperty("perfil.lbl.edadMinima"));
		vf.getpPerfil().setLblTextoEdadMaxima(propIdioma.getProperty("perfil.lbl.edadMaxima"));
		vf.getpPerfil().setLblTextoIngresos(propIdioma.getProperty("perfil.lbl.ingresos"));
		vf.getpPerfil().setLblTextoDivorcio(propIdioma.getProperty("perfil.lbl.divorcio"));
		
		vf.getpReg().setLblTextoNombre(propIdioma.getProperty("reg.lbl.nombre"));
		vf.getpReg().setLblTextoApellido(propIdioma.getProperty("reg.lbl.apellido"));
		vf.getpReg().setLblTextoAlias(propIdioma.getProperty("reg.lbl.alias"));
		vf.getpReg().setLblTextoEmail(propIdioma.getProperty("reg.lbl.email"));
		vf.getpReg().setLblTextoFechaNacimiento(propIdioma.getProperty("reg.lbl.fechaNac"));
		vf.getpReg().setLblTextoContra(propIdioma.getProperty("reg.lbl.contra"));
		vf.getpReg().setLblTextoConfirContra(propIdioma.getProperty("reg.lbl.confirContra"));
		vf.getpReg().setLblTextoEstatura(propIdioma.getProperty("reg.lbl.estatura"));
		vf.getpReg().setLblTextoIngresosMensuales(propIdioma.getProperty("reg.lbl.ingresosMensuales"));
		vf.getpReg().setChkTextoDivorciada(propIdioma.getProperty("reg.chk.divorciada"));
		vf.getpReg().setBtnTextoRegistrar(propIdioma.getProperty("reg.btn.registrar"));
		vf.getpReg().setBtnTextoCancelar(propIdioma.getProperty("reg.btn.cancelar"));
		
		vf.getpScr().setLblTextoAlias(null);
		vf.getpScr().setLblTextoEdad(null);
		vf.getpScr().setLblTextoEstatura(null);
		vf.getpScr().setLblTextoIngresos(null);
		vf.getpScr().setLblTextoDivorcios(null);
		vf.getpScr().setBtnTextoSmash("<3");
		vf.getpScr().setBtnTextoPass("X");
		
		vf.getpGen().setLblTextoTitulo(propIdioma.getProperty("gen.lbl.titulo"));
		vf.getpGen().setLblTextoHombre(propIdioma.getProperty("gen.lbl.hombre"));
		vf.getpGen().setLblTextoMujer(propIdioma.getProperty("gen.lbl.mujer"));
		vf.getpGen().setBtnTextoVolver(propIdioma.getProperty("gen.btn.volver"));
			
	}

}
