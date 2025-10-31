package co.edu.unbosque.model;

/**
 * Representa un objeto de transferencia de datos (DTO) para {@link Dislike}.
 * <p>
 * Esta clase se utiliza para transportar información de una acción de "dislike"
 * (no me gusta) entre distintas capas del sistema, sin exponer la lógica
 * interna del modelo.
 * </p>
 * 
 * <p>
 * Contiene los mismos atributos que la clase {@code Dislike}: el identificador
 * del emisor y el del receptor.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class DislikeDTO {

	/**
	 * Identificador del usuario que emite el dislike.
	 */
	private String idEmisor;

	/**
	 * Identificador del usuario que recibe el dislike.
	 */
	private String idReceptor;

	/**
	 * Crea un objeto {@code DislikeDTO} vacío.
	 * <p>
	 * Este constructor no inicializa ningún atributo.
	 * </p>
	 */
	public DislikeDTO() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code DislikeDTO} con los atributos especificados.
	 * 
	 * @param idEmisor   el identificador del usuario que emite el dislike
	 * @param idReceptor el identificador del usuario que recibe el dislike
	 */
	public DislikeDTO(String idEmisor, String idReceptor) {
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
	}

	/**
	 * Obtiene el identificador del usuario que emitió el dislike.
	 * 
	 * @return el identificador del emisor
	 */
	public String getIdEmisor() {
		return idEmisor;
	}

	/**
	 * Establece el identificador del usuario que emite el dislike.
	 * 
	 * @param idEmisor el nuevo identificador del emisor
	 */
	public void setIdEmisor(String idEmisor) {
		this.idEmisor = idEmisor;
	}

	/**
	 * Obtiene el identificador del usuario que recibió el dislike.
	 * 
	 * @return el identificador del receptor
	 */
	public String getIdReceptor() {
		return idReceptor;
	}

	/**
	 * Establece el identificador del usuario que recibe el dislike.
	 * 
	 * @param idReceptor el nuevo identificador del receptor
	 */
	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}

	/**
	 * Devuelve una representación en texto del objeto {@code DislikeDTO}.
	 * <p>
	 * Incluye los valores del emisor y receptor.
	 * </p>
	 * 
	 * @return una cadena con la información del dislike
	 */
	@Override
	public String toString() {
		return "DislikeDTO [idEmisor=" + idEmisor + ", idReceptor=" + idReceptor + "]";
	}

}
