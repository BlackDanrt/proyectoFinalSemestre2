package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Representa a una persona dentro del sistema.
 * <p>
 * Esta clase modela la información personal y de perfil de un usuario,
 * incluyendo sus datos básicos, configuración de visibilidad, preferencias de
 * edad y estado de verificación.
 * </p>
 * 
 * <p>
 * Implementa la interfaz {@link Serializable}, lo que permite que sus
 * instancias sean serializadas y almacenadas o transmitidas de forma
 * persistente.
 * </p>
 * 
 * <p>
 * Los atributos principales incluyen:
 * <ul>
 * <li>Datos personales: {@code id}, {@code nombre}, {@code apellido},
 * {@code alias}, {@code edad}</li>
 * <li>Información de cuenta: {@code correo}, {@code contrasenia},
 * {@code foto}</li>
 * <li>Configuración de perfil: {@code cantLike}, {@code esVisiblePefil},
 * {@code edadMinima}, {@code edadMaxima}, {@code estaVerificado}</li>
 * </ul>
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Persona implements Serializable {

	/**
	 * Identificador único de versión de la clase para serialización.
	 */
	private static final long serialVersionUID = 2605090105710016709L;

	/**
	 * Identificador único de la persona.
	 */
	private String id;

	/**
	 * Nombre de la persona.
	 */
	private String nombre;

	/**
	 * Apellido de la persona.
	 */
	private String apellido;

	/**
	 * Alias o nombre de usuario público.
	 */
	private String alias;

	/**
	 * Edad actual de la persona.
	 */
	private int edad;

	/**
	 * Correo electrónico asociado a la cuenta.
	 */
	private String correo;

	/**
	 * Contraseña del usuario (almacenada posiblemente en formato encriptado).
	 */
	private String contrasenia;

	/**
	 * Ruta o nombre del archivo de la foto de perfil.
	 */
	private String foto;

	/**
	 * Cantidad de "likes" o reacciones positivas que ha recibido la persona.
	 */
	private int cantLike;

	/**
	 * Indica si el perfil de la persona es visible para otros usuarios.
	 */
	private boolean esVisiblePefil;

	/**
	 * Edad mínima de preferencia establecida por el usuario para interacciones o
	 * coincidencias.
	 */
	private long edadMinima;

	/**
	 * Edad máxima de preferencia establecida por el usuario para interacciones o
	 * coincidencias.
	 */
	private long edadMaxima;

	/**
	 * Indica si la cuenta del usuario ha sido verificada.
	 */
	private boolean estaVerificado;

	/**
	 * Crea un objeto {@code Persona} vacío.
	 * <p>
	 * Este constructor no inicializa ningún atributo.
	 * </p>
	 */
	public Persona() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code Persona} con todos sus atributos inicializados.
	 * 
	 * @param id             identificador único de la persona
	 * @param nombre         nombre de la persona
	 * @param apellido       apellido de la persona
	 * @param alias          alias o nombre público de la persona
	 * @param edad           edad de la persona
	 * @param correo         dirección de correo electrónico
	 * @param contrasenia    contraseña asociada al perfil
	 * @param foto           ruta o nombre del archivo de la foto de perfil
	 * @param cantLike       cantidad de "likes" recibidos
	 * @param esVisiblePefil indicador de visibilidad del perfil
	 * @param edadMinima     edad mínima de preferencia
	 * @param edadMaxima     edad máxima de preferencia
	 * @param estaVerificado indicador de verificación del perfil
	 */
	public Persona(String id, String nombre, String apellido, String alias, int edad, String correo, String contrasenia,
			String foto, int cantLike, boolean esVisiblePefil, long edadMinima, long edadMaxima,
			boolean estaVerificado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.alias = alias;
		this.edad = edad;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.foto = foto;
		this.cantLike = cantLike;
		this.esVisiblePefil = esVisiblePefil;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.estaVerificado = estaVerificado;
	}

	/** @return el identificador de la persona */
	public String getId() {
		return id;
	}

	/** @param id el nuevo identificador de la persona */
	public void setId(String id) {
		this.id = id;
	}

	/** @return el nombre de la persona */
	public String getNombre() {
		return nombre;
	}

	/** @param nombre el nuevo nombre de la persona */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** @return el apellido de la persona */
	public String getApellido() {
		return apellido;
	}

	/** @param apellido el nuevo apellido de la persona */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/** @return el alias de la persona */
	public String getAlias() {
		return alias;
	}

	/** @param alias el nuevo alias de la persona */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/** @return la edad de la persona */
	public int getEdad() {
		return edad;
	}

	/** @param edad la nueva edad de la persona */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/** @return el correo electrónico de la persona */
	public String getCorreo() {
		return correo;
	}

	/** @param correo el nuevo correo electrónico de la persona */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/** @return la contraseña de la persona */
	public String getContrasenia() {
		return contrasenia;
	}

	/** @param contrasenia la nueva contraseña de la persona */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/** @return la ruta o nombre del archivo de la foto de perfil */
	public String getFoto() {
		return foto;
	}

	/** @param foto la nueva foto de perfil */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/** @return la cantidad de "likes" que ha recibido la persona */
	public int getCantLike() {
		return cantLike;
	}

	/** @param cantLike la nueva cantidad de "likes" */
	public void setCantLike(int cantLike) {
		this.cantLike = cantLike;
	}

	/**
	 * @return {@code true} si el perfil es visible; {@code false} en caso contrario
	 */
	public boolean isEsVisiblePefil() {
		return esVisiblePefil;
	}

	/** @param esVisiblePefil define si el perfil será visible o no */
	public void setEsVisiblePefil(boolean esVisiblePefil) {
		this.esVisiblePefil = esVisiblePefil;
	}

	/** @return la edad mínima de preferencia */
	public long getEdadMinima() {
		return edadMinima;
	}

	/** @param edadMinima la nueva edad mínima de preferencia */
	public void setEdadMinima(long edadMinima) {
		this.edadMinima = edadMinima;
	}

	/** @return la edad máxima de preferencia */
	public long getEdadMaxima() {
		return edadMaxima;
	}

	/** @param edadMaxima la nueva edad máxima de preferencia */
	public void setEdadMaxima(long edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	/**
	 * @return {@code true} si la cuenta está verificada; {@code false} en caso
	 *         contrario
	 */
	public boolean isEstaVerificado() {
		return estaVerificado;
	}

	/** @param estaVerificado define si la cuenta está verificada o no */
	public void setEstaVerificado(boolean estaVerificado) {
		this.estaVerificado = estaVerificado;
	}

	/** @return el identificador de versión de la clase */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Devuelve una representación en texto del objeto {@code Persona}.
	 * <p>
	 * Incluye todos los valores de los atributos.
	 * </p>
	 * 
	 * @return una cadena con la información de la persona
	 */
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", alias=" + alias + ", edad="
				+ edad + ", correo=" + correo + ", contrasenia=" + contrasenia + ", foto=" + foto + ", cantLike="
				+ cantLike + ", esVisiblePefil=" + esVisiblePefil + ", edadMinima=" + edadMinima + ", edadMaxima="
				+ edadMaxima + ", estaVerificado=" + estaVerificado + "]";
	}
}
