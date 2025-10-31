package co.edu.unbosque.model;

/**
 * Representa a una mujer dentro del sistema, extendiendo la clase
 * {@link Persona}.
 * <p>
 * Incluye información adicional como su estado civil (divorciada o no), su
 * estatura actual y la estatura ideal que prefiere en una pareja.
 * </p>
 * 
 * <p>
 * Esta clase puede usarse para modelar perfiles de usuario en una aplicación de
 * emparejamiento o base de datos de personas, permitiendo almacenar y manipular
 * datos personales junto con sus preferencias.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Mujer extends Persona {

	private static final long serialVersionUID = 4376781876057227158L;

	/** Indica si la mujer es divorciada. */
	private boolean esDivorciada;

	/** Estatura ideal de la pareja que busca, en centímetros. */
	private int estaturaIdeal;

	/** Estatura actual de la mujer en centímetros. */
	private int estatura;

	/**
	 * Constructor vacío. Crea un objeto {@code Mujer} sin inicializar sus
	 * atributos.
	 */
	public Mujer() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code Mujer} con los atributos específicos.
	 * 
	 * @param esDivorciada  Indica si la mujer es divorciada.
	 * @param estaturaIdeal Estatura ideal de la pareja que busca, en centímetros.
	 * @param estatura      Estatura actual de la mujer, en centímetros.
	 */
	public Mujer(boolean esDivorciada, int estaturaIdeal, int estatura) {
		super();
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code Mujer} con los atributos heredados de {@link Persona} y
	 * los específicos de la clase {@code Mujer}.
	 * 
	 * @param id             Identificador único del perfil.
	 * @param nombre         Nombre de la mujer.
	 * @param apellido       Apellido de la mujer.
	 * @param alias          Alias del perfil.
	 * @param edad           Edad de la mujer.
	 * @param correo         Correo electrónico.
	 * @param contrasenia    Contraseña del perfil.
	 * @param foto           Ruta o URL de la foto de perfil.
	 * @param cantLike       Cantidad de "likes" recibidos.
	 * @param esVisiblePefil Indica si el perfil es visible.
	 * @param edadMinima     Edad mínima de preferencia de pareja.
	 * @param edadMaxima     Edad máxima de preferencia de pareja.
	 * @param estaVerificado Indica si el perfil está verificado.
	 * @param esDivorciada   Indica si la mujer es divorciada.
	 * @param estaturaIdeal  Estatura ideal de la pareja, en centímetros.
	 * @param estatura       Estatura actual de la mujer, en centímetros.
	 */
	public Mujer(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima, boolean estaVerificado,
			boolean esDivorciada, int estaturaIdeal, int estatura) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code Mujer} solo con los atributos heredados de
	 * {@link Persona}.
	 * 
	 * @param id             Identificador único del perfil.
	 * @param nombre         Nombre de la mujer.
	 * @param apellido       Apellido de la mujer.
	 * @param alias          Alias del perfil.
	 * @param edad           Edad de la mujer.
	 * @param correo         Correo electrónico.
	 * @param contrasenia    Contraseña del perfil.
	 * @param foto           Ruta o URL de la foto de perfil.
	 * @param cantLike       Cantidad de "likes" recibidos.
	 * @param esVisiblePefil Indica si el perfil es visible.
	 * @param edadMinima     Edad mínima de preferencia de pareja.
	 * @param edadMaxima     Edad máxima de preferencia de pareja.
	 * @param estaVerificado Indica si el perfil está verificado.
	 */
	public Mujer(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
	}

	/**
	 * @return {@code true} si la mujer es divorciada; de lo contrario,
	 *         {@code false}.
	 */
	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	/** @param esDivorciada define si la mujer es divorciada. */
	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	/** @return la estatura ideal de la pareja que busca, en centímetros. */
	public int getEstaturaIdeal() {
		return estaturaIdeal;
	}

	/** @param estaturaIdeal la estatura ideal a establecer, en centímetros. */
	public void setEstaturaIdeal(int estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}

	/** @return la estatura actual de la mujer en centímetros. */
	public int getEstatura() {
		return estatura;
	}

	/** @param estatura la estatura a establecer, en centímetros. */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/**
	 * Retorna una representación textual del objeto {@code Mujer}.
	 * 
	 * @return una cadena con los valores de los atributos.
	 */
	@Override
	public String toString() {
		return "Mujer [esDivorciada=" + esDivorciada + ", estaturaIdeal=" + estaturaIdeal + ", estatura=" + estatura
				+ "]";
	}

}
