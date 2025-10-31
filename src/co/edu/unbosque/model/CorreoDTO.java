package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para {@link Correo}.
 * <p>
 * Esta clase se utiliza para transportar información del correo entre distintas
 * capas del sistema (por ejemplo, entre la capa lógica y la capa de
 * presentación) sin exponer la lógica interna del modelo.
 * </p>
 * 
 * <p>
 * Contiene los mismos atributos que la clase {@code Correo}: el destinatario,
 * el alias y el código de verificación o identificación.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class CorreoDTO {

	/**
	 * Dirección del destinatario del correo.
	 */
	private String destinatario;

	/**
	 * Alias o nombre identificador asociado al correo.
	 */
	private String alias;

	/**
	 * Código numérico que puede representar un identificador o clave de
	 * verificación.
	 */
	private int codigo;

	/**
	 * Crea un objeto {@code CorreoDTO} vacío.
	 * <p>
	 * Este constructor no inicializa ningún atributo.
	 * </p>
	 */
	public CorreoDTO() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code CorreoDTO} con todos sus atributos inicializados.
	 * 
	 * @param destinatario la dirección de correo del destinatario
	 * @param alias        el alias o nombre identificador
	 * @param codigo       el código numérico asociado al correo
	 */
	public CorreoDTO(String destinatario, String alias, int codigo) {
		this.destinatario = destinatario;
		this.alias = alias;
		this.codigo = codigo;
	}

	/**
	 * Obtiene la dirección del destinatario.
	 * 
	 * @return la dirección del destinatario
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * Establece la dirección del destinatario.
	 * 
	 * @param destinatario la nueva dirección del destinatario
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * Obtiene el alias del correo.
	 * 
	 * @return el alias del correo
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Establece el alias del correo.
	 * 
	 * @param alias el nuevo alias del correo
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Obtiene el código asociado al correo.
	 * 
	 * @return el código del correo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Establece el código asociado al correo.
	 * 
	 * @param codigo el nuevo código del correo
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Devuelve una representación en texto del objeto {@code CorreoDTO}.
	 * <p>
	 * El formato incluye los valores de todos los atributos de la clase.
	 * </p>
	 * 
	 * @return una cadena con los datos del DTO
	 */
	@Override
	public String toString() {
		return "CorreoDTO [destinatario=" + destinatario + ", alias=" + alias + ", codigo=" + codigo + "]";
	}
}
