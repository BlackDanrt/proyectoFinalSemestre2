package co.edu.unbosque.model;

/**
 * Clase de transferencia de datos (DTO) que representa a un hombre dentro del
 * sistema.
 * <p>
 * Extiende la clase {@link Persona} e incluye atributos específicos como el
 * identificador, ingreso mensual, preferencia sobre el divorcio y la estatura.
 * </p>
 * 
 * <p>
 * Esta clase se utiliza para transportar información entre la capa de modelo y
 * la capa de vista sin exponer la lógica de negocio.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class HombreDTO extends Persona {

	private static final long serialVersionUID = 1962898026481141517L;

	/** Identificador único del hombre. */
	private String id;

	/** Ingreso mensual del hombre en pesos. */
	private long ingresoMensual;

	/** Indica si el hombre tiene preferencia por personas divorciadas. */
	private boolean preferenciaDivorcio;

	/** Estatura del hombre en centímetros. */
	private int estatura;

	/**
	 * Constructor vacío. Crea un objeto {@code HombreDTO} sin inicializar los
	 * atributos.
	 */
	public HombreDTO() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code HombreDTO} con los atributos específicos.
	 * 
	 * @param id                  Identificador único del hombre.
	 * @param ingresoMensual      Ingreso mensual en pesos.
	 * @param preferenciaDivorcio Indica si tiene preferencia por personas
	 *                            divorciadas.
	 * @param estatura            Estatura en centímetros.
	 */
	public HombreDTO(String id, long ingresoMensual, boolean preferenciaDivorcio, int estatura) {
		super();
		this.id = id;
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code HombreDTO} con los atributos heredados de
	 * {@link Persona} y los específicos de la clase {@code HombreDTO}.
	 * 
	 * @param nombre              Nombre del hombre.
	 * @param apellido            Apellido del hombre.
	 * @param alias               Alias del perfil.
	 * @param edad                Edad del hombre.
	 * @param correo              Correo electrónico.
	 * @param contrasenia         Contraseña del perfil.
	 * @param foto                Ruta o URL de la foto de perfil.
	 * @param cantLike            Cantidad de "likes" recibidos.
	 * @param esVisiblePefil      Indica si el perfil es visible.
	 * @param edadMinima          Edad mínima de preferencia de pareja.
	 * @param edadMaxima          Edad máxima de preferencia de pareja.
	 * @param estaVerificado      Indica si el perfil está verificado.
	 * @param id                  Identificador único.
	 * @param ingresoMensual      Ingreso mensual.
	 * @param preferenciaDivorcio Preferencia sobre el divorcio.
	 * @param estatura            Estatura en centímetros.
	 */
	public HombreDTO(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima, boolean estaVerificado,
			String id, long ingresoMensual, boolean preferenciaDivorcio, int estatura) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
		this.id = id;
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code HombreDTO} con los atributos heredados de
	 * {@link Persona}.
	 * 
	 * @param nombre         Nombre del hombre.
	 * @param apellido       Apellido del hombre.
	 * @param alias          Alias del perfil.
	 * @param edad           Edad del hombre.
	 * @param correo         Correo electrónico.
	 * @param contrasenia    Contraseña del perfil.
	 * @param foto           Ruta o URL de la foto de perfil.
	 * @param cantLike       Cantidad de "likes" recibidos.
	 * @param esVisiblePefil Indica si el perfil es visible.
	 * @param edadMinima     Edad mínima de preferencia de pareja.
	 * @param edadMaxima     Edad máxima de preferencia de pareja.
	 * @param estaVerificado Indica si el perfil está verificado.
	 */
	public HombreDTO(String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super(nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
	}

	/** @return el identificador único del hombre. */
	public String getId() {
		return id;
	}

	/** @param id el identificador único a establecer. */
	public void setId(String id) {
		this.id = id;
	}

	/** @return el ingreso mensual del hombre. */
	public long getIngresoMensual() {
		return ingresoMensual;
	}

	/** @param ingresoMensual el ingreso mensual a establecer. */
	public void setIngresoMensual(long ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	/**
	 * @return {@code true} si tiene preferencia por personas divorciadas; de lo
	 *         contrario, {@code false}.
	 */
	public boolean isPreferenciaDivorcio() {
		return preferenciaDivorcio;
	}

	/**
	 * @param preferenciaDivorcio define si tiene preferencia por personas
	 *                            divorciadas.
	 */
	public void setPreferenciaDivorcio(boolean preferenciaDivorcio) {
		this.preferenciaDivorcio = preferenciaDivorcio;
	}

	/** @return la estatura del hombre en centímetros. */
	public int getEstatura() {
		return estatura;
	}

	/** @param estatura la estatura a establecer, en centímetros. */
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	/**
	 * Retorna una representación textual del objeto {@code HombreDTO}.
	 * 
	 * @return una cadena con los valores de los atributos del objeto.
	 */
	@Override
	public String toString() {
		return "HombreDTO [id=" + id + ", ingresoMensual=" + ingresoMensual + ", preferenciaDivorcio="
				+ preferenciaDivorcio + ", estatura=" + estatura + "]";
	}
}
