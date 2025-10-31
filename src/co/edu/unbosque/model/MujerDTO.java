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
 * Esta clase puede utilizarse como un objeto de transferencia de datos (DTO)
 * para almacenar y manipular la información de una mujer dentro de una
 * aplicación, por ejemplo, en un sistema de emparejamiento o gestión de
 * perfiles.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class MujerDTO extends Persona {

	private static final long serialVersionUID = 4376781876057227158L;

	/** Indica si la mujer es divorciada. */
	private boolean esDivorciada;

	/** Estatura ideal de la pareja que busca, en centímetros. */
	private int estaturaIdeal;

	/** Estatura actual de la mujer en centímetros. */
	private int estatura;

	/**
	 * Constructor vacío. Crea un objeto {@code MujerDTO} sin inicializar sus
	 * atributos.
	 */
	public MujerDTO() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code MujerDTO} con los atributos específicos.
	 * 
	 * @param esDivorciada  Indica si la mujer es divorciada.
	 * @param estaturaIdeal Estatura ideal de la pareja que busca, en centímetros.
	 * @param estatura      Estatura actual de la mujer, en centímetros.
	 */
	public MujerDTO(boolean esDivorciada, int estaturaIdeal, int estatura) {
		super();
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code MujerDTO} con los atributos heredados de
	 * {@link Persona} y los específicos de la clase {@code MujerDTO}.
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
	public MujerDTO(String id, String nombre, String apellido, String alias, int edad, String correo,
			String contrasenia, String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado, boolean esDivorciada, int estaturaIdeal, int estatura) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code MujerDTO} solo con los atributos heredados de
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
	public MujerDTO(String id, String nombre, String apellido, String alias, int edad, String correo,
			String contrasenia, String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
	}

	/**
	 * Indica si la mujer es divorciada.
	 * 
	 * @return {@code true} si es divorciada; de lo contrario, {@code false}.
	 */
	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	/**
	 * Define si la mujer es divorciada.
	 * 
	 * @param esDivorciada {@code true} si es divorciada; de lo contrario,
	 *                     {@code false}.
	 */
	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	/**
	 * Obtiene la estatura ideal de la pareja que busca.
	 * 
	 * @return La estatura ideal en centímetros.
	 */
	public int getEstaturaIdeal() {
		return estaturaIdeal;
	}

	/**
	 * Establece la estatura ideal de la pareja que busca.
	 * 
	 * @param estaturaIdeal La estatura ideal a establecer, en centímetros.
	 */
	public void setEstaturaIdeal(int estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}

	/**
	 * Obtiene la estatura actual de la mujer.
	 * 
	 * @return La estatura en centímetros.
	 */
	public int getEstatura() {
		return estatura;
	}

	/**
	 * Establece la estatura actual de la mujer.
	 * 
	 * @param estatura La estatura a establecer, en centímetros.
	 */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/**
	 * Retorna una representación textual del objeto {@code MujerDTO}.
	 * 
	 * @return Una cadena con los valores de los atributos.
	 */
	@Override
	public String toString() {
		return "MujerDTO [esDivorciada=" + esDivorciada + ", estaturaIdeal=" + estaturaIdeal + ", estatura=" + estatura
				+ "]";
	}
}
