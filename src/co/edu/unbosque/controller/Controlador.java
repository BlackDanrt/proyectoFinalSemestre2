package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Properties;

import co.edu.unbosque.model.ModelFacade;
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
		// FileHandler.cargarArchivoDePropiedades(propConfig.getProperty("proyectoFinalSemestre2.idioma"));
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
		vf.refrescarVista();
	}

	public void iniciarSesion() {

	}

	public void registrarse() {

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
		// vf.getpBan().getCmbIdioma().addActionListener(this);
		// vf.getpBan().getCmbIdioma().setActionCommand("idioma");

		// Panel Iniciar Sesion
		vf.getpInic().getBtnIniciarSesion().addActionListener(this);
		vf.getpInic().getBtnIniciarSesion().setActionCommand("iniciar sesion");
		vf.getpInic().getBtnIniciarSesion().addActionListener(this);
		vf.getpInic().getBtnIniciarSesion().setActionCommand("registrarse");

	}

}
