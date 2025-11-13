package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * La clase {@code PanelBanner} representa la barra superior del sistema
 * BosTinder, donde se encuentran los controles generales como el cambio de
 * idioma, el botón de perfil y el modo oscuro.
 * 
 * <p>
 * Este panel se utiliza como parte del encabezado de la interfaz gráfica para
 * permitir una navegación rápida y configuraciones generales del usuario.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelBanner extends JPanel {

	/**
	 * Botón que permite acceder al perfil del usuario.
	 */
	private JButton btnPerfil;

	/**
	 * Botón que activa o desactiva el modo oscuro.
	 */
	private JButton btnModoOscuro;

	/**
	 * Menú desplegable que permite seleccionar el idioma de la aplicación.
	 */
	private JComboBox<String> cmbIdioma;

	/**
	 * Crea un nuevo panel de banner e inicializa sus componentes.
	 */
	public PanelBanner() {
		inicializarComponentes();
	}

	/**
	 * Inicializa y configura los componentes gráficos del panel, incluyendo el
	 * botón de perfil, el botón de modo oscuro y el combo de idiomas.
	 */
	public void inicializarComponentes() {
		this.setLayout(null);
		this.setSize(1280, 80);
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#FF4458")));
		this.setVisible(true);

		cmbIdioma = new JComboBox<String>();
		cmbIdioma.addItem("Español ES");
		cmbIdioma.addItem("English US");
		cmbIdioma.addItem("Portugués BR");
		cmbIdioma.addItem("русский RU");
		cmbIdioma.addItem("中文 CN");
		cmbIdioma.addItem("עברית IL");
		cmbIdioma.setBounds(1000, 22, 245, 36);
		cmbIdioma.setLightWeightPopupEnabled(false);

		btnModoOscuro = new JButton();
		btnModoOscuro.setBounds(915, 15, 50, 50);
		btnModoOscuro.setFocusPainted(false);
		btnModoOscuro.setContentAreaFilled(false);
		btnModoOscuro.setBorderPainted(false);

		ImageIcon iconoOriginal = new ImageIcon("files/perfil.png");
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		btnPerfil = new JButton();
		btnPerfil.setIcon(new ImageIcon(imgEscalada));
		btnPerfil.setBounds(830, 15, 50, 50);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setVisible(false);

		this.add(cmbIdioma);
		this.add(btnModoOscuro);
		this.add(btnPerfil);

	}

	/**
	 * Obtiene el botón de perfil.
	 * 
	 * @return el botón que permite acceder al perfil del usuario.
	 */
	public JButton getBtnPerfil() {
		return btnPerfil;
	}

	/**
	 * Establece un nuevo botón de perfil.
	 * 
	 * @param btnPerfil el nuevo botón de perfil a asignar.
	 */
	public void setBtnPerfil(JButton btnPerfil) {
		this.btnPerfil = btnPerfil;
	}

	/**
	 * Obtiene el botón de modo oscuro.
	 * 
	 * @return el botón que permite alternar entre modo claro y oscuro.
	 */
	public JButton getBtnModoOscuro() {
		return btnModoOscuro;
	}

	/**
	 * Establece un nuevo botón de modo oscuro.
	 * 
	 * @param btnModoOscuro el botón de modo oscuro a asignar.
	 */
	public void setBtnModoOscuro(JButton btnModoOscuro) {
		this.btnModoOscuro = btnModoOscuro;
	}

	/**
	 * Obtiene el menú desplegable de idiomas.
	 * 
	 * @return el combo box de selección de idioma.
	 */
	public JComboBox<String> getCmbIdioma() {
		return cmbIdioma;
	}

	/**
	 * Establece un nuevo menú desplegable de idiomas.
	 * 
	 * @param cmbIdioma el combo box de idioma a asignar.
	 */
	public void setCmbIdioma(JComboBox<String> cmbIdioma) {
		this.cmbIdioma = cmbIdioma;
	}
}
