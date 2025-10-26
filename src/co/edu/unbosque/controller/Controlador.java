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

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.FileHandler;
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

	/*
	 * NO SE ESTAN LEYENDO BIEN LOS SIGUIENTES ALL ESPANOL E INGLES POR SUS
	 * CARACTERES
	 */

	public void idioma() {

		String idioma = String.valueOf(vf.getpBan().getCmbIdioma().getSelectedItem());
		if (idioma.equals("Español ES")) {
			propIdioma = FileHandler.cargarArchivoDePropiedades("ES.properties");
			try {
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "Español ES");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("English US")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("US.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "English US");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("Portugués BR")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("BR.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "Portugués BR");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("русский RU")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("RU.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "русский RU");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("中文 CN")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("CN.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "中文 CN");
				propConfig.store(new FileWriter("config.properties"), null);
			} catch (InputMismatchException | IOException e) {
			}
		} else if (idioma.equals("עברית IL")) {
			try {
				propIdioma = FileHandler.cargarArchivoDePropiedades("IL.properties");
				propConfig.setProperty("proyectoFinalSemestre2.idioma", "עברית IL");
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

		boolean sesionExitosa = false;

		for (HombreDTO dto : hombres) {
			if (dto.getCorreo().equals(correo) && dto.getContrasenia().equals(contrasenia)) {
				sesionExitosa = true;
				break;
			}
		}

		if (!sesionExitosa) {
			for (MujerDTO dto : mujeres) {
				if (dto.getCorreo().equals(correo) && dto.getContrasenia().equals(contrasenia)) {
					sesionExitosa = true;
					break;
				}
			}
		}

		if (sesionExitosa) {
			JOptionPane.showMessageDialog(vf.getVen(), "¡El inicio de sesión ha sido exitoso!",
					"Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(vf.getVen(), "La contraseña o el correo son incorrectos",
					"Inicio de sesión fallido", JOptionPane.ERROR_MESSAGE);

		}
	}

	public void registrarse() {
		/*
		 * String nombre; String apellido; String alias; int edad; String correo; String
		 * contrasenia; String foto; int cantLike; boolean esVisiblePefil; long
		 * edadMinima; long edadMaxima; boolean estaVerificado;
		 */

		try {
			/*
			 * String id = UUID.randomUUID().toString(); String nombre = vf ;
			 * LanzadorDeExcepcion.verificarString(nombre); String apellido = vf ;
			 * LanzadorDeExcepcion.verificarString(apellido); String alias = vf ;
			 * LanzadorDeExcepcion.verificarAliasExistente(alias);
			 * 
			 * String fechaNacimiento = vf ; 
			 * int edad = LanzadorDeExcepcion.verificarFechaNacimiento(fechaNacimiento);
			 * 
			 * String correo = vf ; LanzadorDeExcepcion.verificarCorreoInvalido(correo);
			 * LanzadorDeExcepcion.verificarCorreoExistente(correo);
			 * 
			 * String ruta = tomarRutaFoto;
			 * String contrasenia = vf ;
			 *ACORDARME DE CREAR UN VERIFICADOR DE FOTALEZA DE CONTRASENIA
			 *int edadMinima = 0;
			 *int edadMaxima = 0;
			 *boolean estVerificado = false;
			 */
			

		} catch (InputMismatchException e) {

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
			registrarse();
			break;
		}

		// Fin casos swtich
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

		vf.getpInic().getBtnIniciarSesion().addActionListener(this);
		vf.getpInic().getBtnIniciarSesion().setActionCommand("registrarse");

	}

}
