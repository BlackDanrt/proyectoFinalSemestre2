package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * La clase {@code PanelSeleccionarGenero} representa la vista gráfica en la
 * cual el usuario puede seleccionar su género dentro del proceso de registro en
 * la aplicación BosTinder.
 * <p>
 * Este panel presenta dos botones principales (Hombre y Mujer), un título
 * descriptivo, y un botón adicional para regresar a la pantalla anterior.
 * </p>
 * 
 * <h2>Características principales:</h2>
 * <ul>
 * <li>Diseño totalmente personalizado con posición absoluta.</li>
 * <li>Uso de íconos gráficos para representar las opciones de género.</li>
 * <li>Colores y tipografía adaptados al estilo visual general de la
 * aplicación.</li>
 * </ul>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class PanelSeleccionarGenero extends JPanel {
	/** Botón para seleccionar el género masculino. */
	private JButton btnHombre;

	/** Botón para seleccionar el género femenino. */
	private JButton btnMujer;

	/** Botón para volver a la vista anterior. */
	private JButton btnVolver;

	/** Etiqueta que muestra el título principal del panel. */
	private JLabel lblTitulo;

	/** Etiqueta descriptiva que acompaña el botón masculino. */
	private JLabel lblHombre;

	/** Etiqueta descriptiva que acompaña el botón femenino. */
	private JLabel lblMujer;

	/**
	 * Crea una nueva instancia del panel de selección de género.
	 * <p>
	 * Inicializa el diseño, define las propiedades visuales y llama al método
	 * {@link #inicializarComponentes()}.
	 * </p>
	 */
	public PanelSeleccionarGenero() {
		this.setLayout(null);
		this.setSize(1280, 860);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();

	}

	/**
	 * Inicializa todos los componentes gráficos del panel: botones, etiquetas e
	 * íconos representativos.
	 */
	public void inicializarComponentes() {
		lblTitulo = new JLabel();
		lblTitulo.setBounds(326, 120, 628, 69);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 36));
		lblTitulo.setForeground(Color.WHITE);

		btnHombre = new JButton();
		btnHombre.setBounds(326, 256, 261, 240);

		ImageIcon iconoHombre = new ImageIcon("files/hombre.png");
		Image imgHombre = iconoHombre.getImage().getScaledInstance(171, 176, Image.SCALE_SMOOTH);
		btnHombre.setIcon(new ImageIcon(imgHombre));

		btnMujer = new JButton();
		btnMujer.setBounds(693, 256, 261, 240);

		ImageIcon iconoMujer = new ImageIcon("files/mujer.png");
		Image imgMujer = iconoMujer.getImage().getScaledInstance(169, 176, Image.SCALE_SMOOTH);
		btnMujer.setIcon(new ImageIcon(imgMujer));

		btnVolver = new JButton();
		btnVolver.setBounds(90, 760, 120, 35);
		btnVolver.setBackground(Color.decode("#8F8B8B"));

		lblHombre = new JLabel();
		lblHombre.setBounds(420, 521, 153, 35);
		lblHombre.setForeground(Color.WHITE);
		lblHombre.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 20));

		lblMujer = new JLabel();
		lblMujer.setBounds(790, 521, 153, 35);
		lblMujer.setForeground(Color.WHITE);
		lblMujer.setFont(new Font("Noto Sans CJK SC", Font.BOLD, 20));

		this.add(lblTitulo);
		this.add(btnHombre);
		this.add(btnMujer);
		this.add(btnVolver);
		this.add(lblHombre);
		this.add(lblMujer);
	}

	/** @return el botón asociado al género masculino. */
	public JButton getBtnHombre() {
		return btnHombre;
	}

	/** @param btnHombre el nuevo botón asociado al género masculino. */
	public void setBtnHombre(JButton btnHombre) {
		this.btnHombre = btnHombre;
	}

	/** @param texto el texto que se mostrará en el botón de género masculino. */
	public void setBtnTextoHombre(String texto) {
		btnHombre.setText(texto);
	}

	/** @return el botón asociado al género femenino. */
	public JButton getBtnMujer() {
		return btnMujer;
	}

	/** @param btnMujer el nuevo botón asociado al género femenino. */
	public void setBtnMujer(JButton btnMujer) {
		this.btnMujer = btnMujer;
	}

	/** @param texto el texto que se mostrará en el botón de género femenino. */
	public void setBtnTextoMujer(String texto) {
		btnMujer.setText(texto);
	}

	/** @return el botón que permite volver a la pantalla anterior. */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/** @param btnVolver el nuevo botón de volver. */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	/** @param texto el texto que se mostrará en el botón de volver. */
	public void setBtnTextoVolver(String texto) {
		btnVolver.setText(texto);
	}

	/** @return la etiqueta del título principal. */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/** @param lblTitulo la nueva etiqueta del título principal. */
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	/** @param texto el texto que se mostrará en el título. */
	public void setLblTextoTitulo(String texto) {
		lblTitulo.setText(texto);
	}

	/** @return la etiqueta que acompaña el botón masculino. */
	public JLabel getLblHombre() {
		return lblHombre;
	}

	/** @param lblHombre la nueva etiqueta descriptiva para el botón masculino. */
	public void setLblHombre(JLabel lblHombre) {
		this.lblHombre = lblHombre;
	}

	/** @param texto el texto que se mostrará en la etiqueta de hombre. */
	public void setLblTextoHombre(String texto) {
		lblHombre.setText(texto);
	}

	/** @return la etiqueta que acompaña el botón femenino. */
	public JLabel getLblMujer() {
		return lblMujer;
	}

	/** @param lblMujer la nueva etiqueta descriptiva para el botón femenino. */
	public void setLblMujer(JLabel lblMujer) {
		this.lblMujer = lblMujer;
	}

	/** @param texto el texto que se mostrará en la etiqueta de mujer. */
	public void setLblTextoMujer(String texto) {
		lblMujer.setText(texto);
	}
}