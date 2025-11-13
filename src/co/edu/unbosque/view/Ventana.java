package co.edu.unbosque.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * La clase {@code Ventana} representa la ventana principal de la aplicación
 * "BosTinder". Extiende {@link JFrame} y gestiona un panel con capas
 * ({@link JLayeredPane}) donde se pueden agregar diferentes componentes
 * gráficos.
 * <p>
 * La ventana tiene un tamaño fijo de 1280x920 píxeles, no es redimensionable, y
 * se centra automáticamente en la pantalla al iniciarse.
 * </p>
 * 
 * <h2>Características principales:</h2>
 * <ul>
 * <li>Título: "🔥BosTinder"</li>
 * <li>Contiene un {@code JLabel} de fondo que ocupa toda la ventana.</li>
 * <li>Permite agregar componentes en distintas capas del
 * {@code JLayeredPane}.</li>
 * </ul>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Ventana extends JFrame {

	/** Etiqueta que representa el fondo de la ventana. */
	private JLabel fondo;

	/** Panel con capas que permite organizar los componentes gráficos. */
	private JLayeredPane capas;

	/**
	 * Crea una nueva instancia de la ventana principal. Inicializa los componentes,
	 * define el tamaño, título, comportamiento de cierre y la disposición de capas.
	 */
	public Ventana() {
		setTitle("🔥BosTinder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(1280, 920);
		setLocationRelativeTo(null);
		setLayout(null);

		capas = getLayeredPane();

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1280, 920);

		capas.add(fondo, JLayeredPane.DEFAULT_LAYER);

		setVisible(true);
	}

	/**
	 * Obtiene la etiqueta del fondo.
	 * 
	 * @return el {@link JLabel} que actúa como fondo de la ventana.
	 */
	public JLabel getFondo() {
		return fondo;
	}

	/**
	 * Establece una nueva etiqueta de fondo.
	 * 
	 * @param fondo el nuevo {@link JLabel} que se usará como fondo.
	 */
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	/**
	 * Obtiene el panel de capas de la ventana.
	 * 
	 * @return el {@link JLayeredPane} usado para organizar los componentes.
	 */
	public JLayeredPane getCapas() {
		return capas;
	}

	/**
	 * Establece un nuevo panel de capas.
	 * 
	 * @param capas el {@link JLayeredPane} a asignar a la ventana.
	 */
	public void setCapas(JLayeredPane capas) {
		this.capas = capas;
	}
}