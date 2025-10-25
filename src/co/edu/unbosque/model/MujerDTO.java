package co.edu.unbosque.model;

/**
 * La clase {@code MujerDTO} representa una mujer dentro del sistema, heredando
 * las características generales de {@link Persona}. Incluye información
 * específica como su estado civil, estatura actual y estatura ideal.
 * 
 * <p>
 * Esta clase sigue el patrón de objeto de transferencia de datos (DTO) para
 * facilitar el manejo y transporte de información entre diferentes capas del
 * programa.
 * </p>
 * 
 * @author Jaun Martinez
 * @version 1.0
 */
public class MujerDTO extends Persona {

	private static final long serialVersionUID = 4376781876057227158L;

	/** Identificador único de la mujer. */
	private String id;

	/** Indica si la mujer es divorciada. */
	private boolean esDivorciada;

	/** Estatura ideal que la mujer considera adecuada (en centímetros). */
	private int estaturaIdeal;

	/** Estatura actual de la mujer (en centímetros). */
	private int estatura;

	/**
	 * Constructor vacío de la clase {@code MujerDTO}.
	 * <p>
	 * Se utiliza principalmente para instanciar el objeto sin asignar valores
	 * iniciales.
	 * </p>
	 */
	public MujerDTO() {
		// Constructor por defecto
	}

	/**
	 * Constructor que inicializa los atributos propios de {@code MujerDTO}.
	 * 
	 * @param id            Identificador único.
	 * @param esDivorciada  Estado civil de la mujer.
	 * @param estaturaIdeal Estatura ideal deseada.
	 * @param estatura      Estatura actual.
	 */
	public MujerDTO(String id, boolean esDivorciada, int estaturaIdeal, int estatura) {
		super();
		this.id = id;
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Constructor completo que inicializa tanto los atributos heredados de
	 * {@link Persona} como los propios de {@code MujerDTO}.
	 * 
	 * @param nombre         Nombre de la persona.
	 * @param apellido       Apellido de la persona.
	 * @param alias          Alias o nombre de usuario.
	 * @param edad           Edad de la persona.
	 * @param correo         Correo electrónico.
	 * @param contrasenia    Contraseña.
	 * @param foto           Ruta o URL de la foto de perfil.
	 * @param cantLike       Cantidad de "me gusta" recibidos.
	 * @param esVisiblePefil Indica si el perfil es visible para otros usuarios.
	 * @param edadMinima     Edad mínima de preferencia.
	 * @param edadMaxima     Edad máxima de preferencia.
	 * @param estaVerificado Indica si el perfil está verificado.
	 * @param id             Identificador único.
	 * @param esDivorciada   Estado civil de la mujer.
	 * @param estaturaIdeal  Estatura ideal deseada.
	 * @param estatura       Estatura actual.
	 */
	public MujerDTO(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima, boolean estaVerificado,
			String id, boolean esDivorciada, int estaturaIdeal, int estatura) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
		this.id = id;
		this.esDivorciada = esDivorciada;
		this.estaturaIdeal = estaturaIdeal;
		this.estatura = estatura;
	}

	/**
	 * Constructor que inicializa únicamente los atributos heredados de
	 * {@link Persona}.
	 * 
	 * @param nombre         Nombre de la persona.
	 * @param apellido       Apellido de la persona.
	 * @param alias          Alias o nombre de usuario.
	 * @param edad           Edad de la persona.
	 * @param correo         Correo electrónico.
	 * @param contrasenia    Contraseña.
	 * @param foto           Ruta o URL de la foto de perfil.
	 * @param cantLike       Cantidad de "me gusta" recibidos.
	 * @param esVisiblePefil Indica si el perfil es visible para otros usuarios.
	 * @param edadMinima     Edad mínima de preferencia.
	 * @param edadMaxima     Edad máxima de preferencia.
	 * @param estaVerificado Indica si el perfil está verificado.
	 */
	public MujerDTO(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
	}

	/**
	 * Obtiene el identificador único de la mujer.
	 * 
	 * @return El identificador {@code id}.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único de la mujer.
	 * 
	 * @param id Identificador a asignar.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Indica si la mujer es divorciada.
	 * 
	 * @return {@code true} si es divorciada, {@code false} en caso contrario.
	 */
	public boolean isEsDivorciada() {
		return esDivorciada;
	}

	/**
	 * Define el estado civil de la mujer.
	 * 
	 * @param esDivorciada {@code true} si es divorciada, {@code false} en caso
	 *                     contrario.
	 */
	public void setEsDivorciada(boolean esDivorciada) {
		this.esDivorciada = esDivorciada;
	}

	/**
	 * Obtiene la estatura ideal de la mujer.
	 * 
	 * @return La estatura ideal en centímetros.
	 */
	public int getEstaturaIdeal() {
		return estaturaIdeal;
	}

	/**
	 * Establece la estatura ideal de la mujer.
	 * 
	 * @param estaturaIdeal Valor en centímetros.
	 */
	public void setEstaturaIdeal(int estaturaIdeal) {
		this.estaturaIdeal = estaturaIdeal;
	}

	/**
	 * Obtiene la estatura actual de la mujer.
	 * 
	 * @return La estatura actual en centímetros.
	 */
	public int getEstatura() {
		return estatura;
	}

	/**
	 * Establece la estatura actual de la mujer.
	 * 
	 * @param estatura Valor en centímetros.
	 */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/**
	 * Devuelve una representación en texto de los atributos de la mujer.
	 * 
	 * @return Una cadena con los valores de los campos.
	 */
	@Override
	public String toString() {
		return "MujerDTO [id=" + id + ", esDivorciada=" + esDivorciada + ", estaturaIdeal=" + estaturaIdeal
				+ ", estatura=" + estatura + "]";
	}

}
