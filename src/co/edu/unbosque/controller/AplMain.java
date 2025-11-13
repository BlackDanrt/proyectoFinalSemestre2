package co.edu.unbosque.controller;

/**
 * Clase principal que inicia la ejecución del programa BosTinder.
 * <p>
 * Esta clase sirve como punto de entrada de la aplicación, encargándose de
 * crear una instancia del {@link co.edu.unbosque.controller.Controlador} y
 * ejecutar la interfaz gráfica de usuario.
 * </p>
 *
 * <p>
 * <b>Responsabilidades:</b>
 * </p>
 * <ul>
 * <li>Inicializar el controlador principal del sistema.</li>
 * <li>Ejecutar la interfaz gráfica mediante el método
 * {@link co.edu.unbosque.controller.Controlador#runGUI()}.</li>
 * </ul>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class AplMain {

	/**
	 * Método principal que da inicio al programa.
	 * <p>
	 * Crea un objeto {@link co.edu.unbosque.controller.Controlador} e invoca el
	 * método {@code runGUI()} para mostrar la interfaz.
	 * </p>
	 *
	 * @param args argumentos de línea de comandos (no utilizados)
	 */

	public static void main(String[] args) {
		Controlador c = new Controlador();
		c.runGUI();

	}

}
