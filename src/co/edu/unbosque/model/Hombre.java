package co.edu.unbosque.model;

/**
 * Representa a un hombre dentro del sistema, extendiendo la clase
 * {@link Persona}.
 * <p>
 * Incluye información adicional como el ingreso mensual, la preferencia sobre
 * el divorcio y la estatura.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Hombre extends Persona {

	private static final long serialVersionUID = 1962898026481141517L;

	/** Ingreso mensual del hombre en pesos. */
	private long ingresoMensual;

	/** Indica si el hombre tiene preferencia por personas divorciadas. */
	private boolean preferenciaDivorcio;

	/** Estatura del hombre en centímetros. */
	private int estatura;

	/**
	 * Constructor vacío. Crea un objeto {@code Hombre} sin inicializar los
	 * atributos.
	 */
	public Hombre() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code Hombre} con los atributos específicos.
	 * 
	 * @param ingresoMensual      Ingreso mensual en pesos.
	 * @param preferenciaDivorcio Preferencia sobre el divorcio.
	 * @param estatura            Estatura en centímetros.
	 */
	public Hombre(long ingresoMensual, boolean preferenciaDivorcio, int estatura) {
		super();
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code Hombre} con los atributos heredados de {@link Persona}
	 * y los específicos de la clase.
	 * 
	 * @param id                  Identificador único del perfil.
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
	 * @param ingresoMensual      Ingreso mensual en pesos.
	 * @param preferenciaDivorcio Preferencia sobre el divorcio.
	 * @param estatura            Estatura en centímetros.
	 */
	public Hombre(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima, boolean estaVerificado,
			long ingresoMensual, boolean preferenciaDivorcio, int estatura) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
		this.ingresoMensual = ingresoMensual;
		this.preferenciaDivorcio = preferenciaDivorcio;
		this.estatura = estatura;
	}

	/**
	 * Crea un objeto {@code Hombre} solo con los atributos heredados de
	 * {@link Persona}.
	 * 
	 * @param id             Identificador único del perfil.
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
	public Hombre(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		super(id, nombre, apellido, alias, edad, correo, contrasenia, foto, cantLike, esVisiblePefil, edadMinima,
				edadMaxima, estaVerificado);
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
	 * Retorna una representación textual del objeto {@code Hombre}.
	 * 
	 * @return una cadena con los valores de los atributos.
	 */
	@Override
	public String toString() {
		return "Hombre [ingresoMensual=" + ingresoMensual + ", preferenciaDivorcio=" + preferenciaDivorcio
				+ ", estatura=" + estatura + "]";
	}
}
