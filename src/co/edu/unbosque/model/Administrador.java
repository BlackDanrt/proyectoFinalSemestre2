package co.edu.unbosque.model;

/**
 * Clase que representa un administrador del sistema BosTinder. Contiene las
 * credenciales estáticas para el acceso administrativo.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Administrador {

	/**
	 * Correo electrónico del administrador del sistema. Es una constante inmutable
	 * que identifica al usuario administrador.
	 */
	private static final String CORREO_ADMIN = "BosTinderAdmin@adminBTinder";

	/**
	 * Contraseña del administrador del sistema. Es una constante inmutable
	 * utilizada para la autenticación del administrador.
	 */
	private static final String CONTRASENIA_ADMIN = "JZc5VKkj27*231";

	/**
	 * Constructor por defecto de la clase Administrador. Crea una nueva instancia
	 * de Administrador sin realizar ninguna inicialización específica.
	 */
	public Administrador() {
		// Constructor vacío
	}

	/**
	 * Obtiene el correo electrónico del administrador del sistema.
	 * 
	 * @return String con el correo electrónico del administrador
	 */
	public static String getCorreoAdmin() {
		return CORREO_ADMIN;
	}

	/**
	 * Obtiene la contraseña del administrador del sistema.
	 * 
	 * @return String con la contraseña del administrador
	 */
	public static String getContraseniaAdmin() {
		return CONTRASENIA_ADMIN;
	}

}