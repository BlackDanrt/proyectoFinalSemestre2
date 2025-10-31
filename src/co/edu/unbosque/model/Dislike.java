package co.edu.unbosque.model;

/**
 * Representa una acción de "dislike" (no me gusta) entre dos usuarios del
 * sistema.
 * <p>
 * Esta clase modela la relación entre un emisor y un receptor cuando uno de
 * ellos expresa desaprobación o desinterés por el otro. Contiene los
 * identificadores de ambos usuarios involucrados en la interacción.
 * </p>
 * 
 * <p>
 * Puede emplearse en sistemas de recomendación, redes sociales o aplicaciones
 * donde se requiera registrar interacciones negativas entre usuarios.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class Dislike {

	/**
	 * Identificador del usuario que emite el dislike.
	 */
	private String idEmisor;

	/**
	 * Identificador del usuario que recibe el dislike.
	 */
	private String idReceptor;

	/**
	 * Crea un objeto {@code Dislike} vacío.
	 * <p>
	 * Este constructor no inicializa ningún atributo.
	 * </p>
	 */
	public Dislike() {
		// Constructor por defecto
	}

	/**
	 * Crea un objeto {@code Dislike} con los atributos especificados.
	 * 
	 * @param idEmisor   el identificador del usuario que emite el dislike
	 * @param idReceptor el identificador del usuario que recibe el dislike
	 */
	public Dislike(String idEmisor, String idReceptor) {
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
	 * Devuelve una representación en texto del objeto {@code Dislike}.
	 * <p>
	 * Incluye los valores del emisor y receptor.
	 * </p>
	 * 
	 * @return una cadena con la información del dislike
	 */
	@Override
	public String toString() {
		return "Dislike [idEmisor=" + idEmisor + ", idReceptor=" + idReceptor + "]";
	}

}
