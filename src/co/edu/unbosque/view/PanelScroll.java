package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * La clase {@code PanelScroll} representa la vista de presentación de un perfil
 * dentro de la aplicación BosTinder. Este panel muestra la información del
 * usuario, su imagen de perfil y botones de interacción para decidir si se
 * desea conectar o no.
 * <p>
 * Se emplea principalmente dentro de la interfaz de exploración, donde los
 * usuarios pueden visualizar distintos perfiles y tomar acciones de "Smash" (me
 * gusta) o "Pass" (rechazar).
 * </p>
 *
 * <h2>Características:</h2>
 * <ul>
 * <li>Diseño con layout absoluto para control total del posicionamiento.</li>
 * <li>Soporte de modo claro/oscuro mediante fondo configurable.</li>
 * <li>Visualización condicional de atributos según el género del perfil.</li>
 * </ul>
 *
 * @author Juan Martinez
 * @version 1.0
 * 
 */
public class PanelScroll extends JPanel {

	/** Imagen de fondo o retrato del perfil mostrado. */
	private Image imagenFondo;

	/** Panel translúcido que sirve como fondo visual del área de información. */
	private JLabel lblFondo;

	/** Etiqueta que muestra el alias o nombre del perfil. */
	private JLabel lblAlias;

	/** Etiqueta con el texto "Edad:". */
	private JLabel lblEdadTexto;

	/** Etiqueta que muestra la edad del perfil. */
	private JLabel lblEdad;

	/** Etiqueta con el texto "Estatura:". */
	private JLabel lblEstaturaTexto;

	/** Etiqueta que muestra la estatura del perfil. */
	private JLabel lblEstatura;

	/** Etiqueta con el texto "Ingresos:". */
	private JLabel lblIngresosTexto;

	/** Etiqueta que muestra los ingresos del perfil. */
	private JLabel lblIngresos;

	/** Etiqueta con el texto "Divorcio:". */
	private JLabel lblDivorcioTexto;

	/** Etiqueta que muestra el estado civil del perfil (divorciado o no). */
	private JLabel lblDivorcio;

	/** Botón para indicar interés ("Me gusta" o "Smash"). */
	private JButton btnSmash;

	/** Botón para indicar rechazo ("Pass"). */
	private JButton btnPass;

	/**
	 * Crea una nueva instancia del panel de scroll de perfil.
	 * <p>
	 * Inicializa los componentes gráficos, ajusta su posición y estilo.
	 * </p>
	 */
	public PanelScroll() {
		this.setLayout(null);
		this.setSize(560, 700);
		this.setOpaque(false);
		this.setVisible(true);
		inicializarComponentes();
	}

	/**
	 * Inicializa todos los componentes gráficos del panel, incluyendo etiquetas,
	 * botones y su configuración visual.
	 */
	private void inicializarComponentes() {

		lblFondo = new JLabel();
		lblFondo.setBounds(505, 40, 270, 360);
		lblFondo.setOpaque(true);
		lblFondo.setBackground(new Color(255, 255, 255, 100));

		Font labelFont = new Font("Noto Sans CJK SC", Font.BOLD, 16);
		Color labelColor = Color.WHITE;

		lblAlias = new JLabel();
		lblAlias.setBounds(505, 425, 270, 30);
		lblAlias.setForeground(labelColor);

		lblEdadTexto = new JLabel();
		lblEdadTexto.setBounds(505, 468, 135, 30);
		lblEdadTexto.setFont(labelFont);
		lblEdadTexto.setForeground(labelColor);

		lblEdad = new JLabel();
		lblEdad.setBounds(670, 468, 105, 30);
		lblEdad.setFont(labelFont);
		lblEdad.setForeground(labelColor);

		lblEstaturaTexto = new JLabel();
		lblEstaturaTexto.setFont(labelFont);
		lblEstaturaTexto.setForeground(labelColor);
		lblEstaturaTexto.setVisible(false);

		lblEstatura = new JLabel();
		lblEstatura.setFont(labelFont);
		lblEstatura.setForeground(labelColor);
		lblEstatura.setVisible(false);

		lblIngresosTexto = new JLabel();
		lblIngresosTexto.setFont(labelFont);
		lblIngresosTexto.setForeground(labelColor);
		lblIngresosTexto.setVisible(false);

		lblIngresos = new JLabel();
		lblIngresos.setFont(labelFont);
		lblIngresos.setForeground(labelColor);
		lblIngresos.setVisible(false);

		lblDivorcioTexto = new JLabel();
		lblDivorcioTexto.setFont(labelFont);
		lblDivorcioTexto.setForeground(labelColor);
		lblDivorcioTexto.setVisible(false);

		lblDivorcio = new JLabel();
		lblDivorcio.setFont(labelFont);
		lblDivorcio.setForeground(labelColor);
		lblDivorcio.setVisible(false);

		Font buttonFont = new Font("Noto Sans CJK SC", Font.BOLD, 18);

		btnPass = new JButton();
		btnPass.setBackground(Color.decode("#F23C29"));
		btnPass.setForeground(Color.WHITE);
		btnPass.setFont(buttonFont);
		btnPass.setBounds(400, 610, 160, 50);
		btnPass.setFocusPainted(false);
		btnPass.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnSmash = new JButton();
		btnSmash.setBackground(Color.decode("#44F533"));
		btnSmash.setForeground(Color.WHITE);
		btnSmash.setFont(buttonFont);
		btnSmash.setBounds(700, 610, 160, 50);
		btnSmash.setFocusPainted(false);
		btnSmash.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.add(lblFondo);
		this.add(lblAlias);
		this.add(lblEdad);
		this.add(lblEdadTexto);
		this.add(lblEstatura);
		this.add(lblEstaturaTexto);
		this.add(lblIngresos);
		this.add(lblIngresosTexto);
		this.add(lblDivorcio);
		this.add(lblDivorcioTexto);
		this.add(btnPass);
		this.add(btnSmash);
	}

	/**
	 * Muestra los atributos correspondientes a un perfil masculino, habilitando las
	 * etiquetas de estatura e ingresos.
	 */
	public void mostrarAtributosHombre() {
		lblEstatura.setBounds(670, 511, 135, 30);
		lblEstaturaTexto.setBounds(505, 511, 105, 30);
		lblEstatura.setVisible(true);
		lblEstaturaTexto.setVisible(true);

		lblIngresos.setBounds(670, 554, 135, 30);
		lblIngresosTexto.setBounds(505, 554, 135, 30);
		lblIngresos.setVisible(true);
		lblIngresosTexto.setVisible(true);
	}

	/**
	 * Oculta todos los atributos adicionales del perfil (usado al refrescar o
	 * limpiar vista).
	 */
	public void ocultarAtributos() {
		lblEstatura.setVisible(false);
		lblEstaturaTexto.setVisible(false);

		lblIngresos.setVisible(false);
		lblIngresosTexto.setVisible(false);

		lblDivorcio.setVisible(false);
		lblDivorcioTexto.setVisible(false);

		lblEstatura.setVisible(false);
		lblEstaturaTexto.setVisible(false);
	}

	/**
	 * Muestra los atributos específicos de un perfil femenino. Si el parámetro
	 * {@code atributoExtra} es verdadero, también se muestran los datos de
	 * estatura.
	 *
	 * @param atributoExtra indica si se debe mostrar el atributo adicional
	 *                      (estatura).
	 */
	public void mostrarAtributosMujer(boolean atributoExtra) {
		lblDivorcio.setBounds(670, 511, 30, 30);
		lblDivorcioTexto.setBounds(505, 511, 135, 30);
		lblDivorcio.setVisible(true);
		lblDivorcioTexto.setVisible(true);
		if (atributoExtra) {
			lblEstatura.setBounds(670, 554, 135, 30);
			lblEstaturaTexto.setBounds(505, 554, 135, 30);
			lblEstatura.setVisible(true);
			lblEstaturaTexto.setVisible(true);
		}
	}

	/**
	 * Dibuja el fondo del panel, incluyendo la imagen del perfil si está definida.
	 *
	 * @param g el contexto gráfico utilizado para pintar el componente.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 440, 20, this);
		}
	}

	/** @return la imagen de fondo actual. */
	public Image getImagenFondo() {
		return imagenFondo;
	}

	/** @param imagenFondo establece la imagen de fondo del perfil. */
	public void setImagenFondo(Image imagenFondo) {
		this.imagenFondo = imagenFondo;
	}

	/** @return la etiqueta del fondo translúcido. */
	public JLabel getLblFondo() {
		return lblFondo;
	}

	/** @param lblFondo la nueva etiqueta de fondo. */
	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}

	/** @return la etiqueta del alias. */
	public JLabel getLblAlias() {
		return lblAlias;
	}

	/** @param lblAlias la nueva etiqueta del alias. */
	public void setLblAlias(JLabel lblAlias) {
		this.lblAlias = lblAlias;
	}

	/** @return la etiqueta del texto “Edad:”. */
	public JLabel getLblEdadTexto() {
		return lblEdadTexto;
	}

	/** @param lblEdadTexto la nueva etiqueta para el texto “Edad:”. */
	public void setLblEdadTexto(JLabel lblEdadTexto) {
		this.lblEdadTexto = lblEdadTexto;
	}

	/** @return la etiqueta que muestra la edad. */
	public JLabel getLblEdad() {
		return lblEdad;
	}

	/** @param lblEdad la nueva etiqueta para la edad. */
	public void setLblEdad(JLabel lblEdad) {
		this.lblEdad = lblEdad;
	}

	/** @return la etiqueta del texto “Estatura:”. */
	public JLabel getLblEstaturaTexto() {
		return lblEstaturaTexto;
	}

	/** @param lblEstaturaTexto la nueva etiqueta para el texto “Estatura:”. */
	public void setLblEstaturaTexto(JLabel lblEstaturaTexto) {
		this.lblEstaturaTexto = lblEstaturaTexto;
	}

	/** @return la etiqueta que muestra la estatura. */
	public JLabel getLblEstatura() {
		return lblEstatura;
	}

	/** @param lblEstatura la nueva etiqueta de estatura. */
	public void setLblEstatura(JLabel lblEstatura) {
		this.lblEstatura = lblEstatura;
	}

	/** @return la etiqueta del texto “Ingresos:”. */
	public JLabel getLblIngresosTexto() {
		return lblIngresosTexto;
	}

	/** @param lblIngresosTexto la nueva etiqueta para el texto “Ingresos:”. */
	public void setLblIngresosTexto(JLabel lblIngresosTexto) {
		this.lblIngresosTexto = lblIngresosTexto;
	}

	/** @return la etiqueta que muestra los ingresos. */
	public JLabel getLblIngresos() {
		return lblIngresos;
	}

	/** @param lblIngresos la nueva etiqueta de ingresos. */
	public void setLblIngresos(JLabel lblIngresos) {
		this.lblIngresos = lblIngresos;
	}

	/** @return la etiqueta del texto “Divorcio:”. */
	public JLabel getLblDivorcioTexto() {
		return lblDivorcioTexto;
	}

	/** @param lblDivorcioTexto la nueva etiqueta para el texto “Divorcio:”. */
	public void setLblDivorcioTexto(JLabel lblDivorcioTexto) {
		this.lblDivorcioTexto = lblDivorcioTexto;
	}

	/** @return la etiqueta que muestra el estado civil. */
	public JLabel getLblDivorcio() {
		return lblDivorcio;
	}

	/** @param lblDivorcio la nueva etiqueta del estado civil. */
	public void setLblDivorcio(JLabel lblDivorcio) {
		this.lblDivorcio = lblDivorcio;
	}

	/** @return el botón de acción "Smash". */
	public JButton getBtnSmash() {
		return btnSmash;
	}

	/** @param btnSmash el nuevo botón de acción "Smash". */
	public void setBtnSmash(JButton btnSmash) {
		this.btnSmash = btnSmash;
	}

	/** @return el botón de acción "Pass". */
	public JButton getBtnPass() {
		return btnPass;
	}

	/** @param btnPass el nuevo botón de acción "Pass". */
	public void setBtnPass(JButton btnPass) {
		this.btnPass = btnPass;
	}

}