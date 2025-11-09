package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * La interfaz {@code DAO} (Data Access Object) define las operaciones básicas
 * que deben implementar las clases encargadas de gestionar la persistencia de
 * objetos de tipo genérico {@code E}.
 * <p>
 * Proporciona una estructura estándar para realizar operaciones CRUD (crear,
 * leer, actualizar y eliminar), además del manejo de archivos serializados para
 * almacenar los datos de manera persistente.
 * </p>
 * 
 * <h3>Ejemplo de implementación:</h3>
 * 
 * <pre>{@code
 * public class HombreDAO implements DAO<HombreDTO> {
 * 	// implementación de los métodos
 * }
 * }</pre>
 * 
 * @param <E> tipo de dato genérico que representa el objeto o DTO manejado por
 *            el DAO
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public interface DAO<E> {

	/**
	 * Crea un nuevo registro en la colección de datos a partir del objeto recibido.
	 * 
	 * @param datoNuevo objeto del tipo {@code E} que se desea agregar
	 */
	public void crear(E datoNuevo);

	/**
	 * Elimina un elemento de la colección según su posición en la lista.
	 * 
	 * @param indice posición del elemento a eliminar
	 * @return {@code true} si la eliminación fue exitosa, {@code false} en caso
	 *         contrario
	 */
	public boolean eliminar(int indice);

	/**
	 * Actualiza los datos de un elemento existente en la colección.
	 * 
	 * @param indice          índice del elemento a actualizar
	 * @param datoActualizado objeto del tipo {@code E} con los nuevos datos
	 * @return {@code true} si la actualización fue exitosa, {@code false} en caso
	 *         contrario
	 */
	public boolean actualizar(int indice, E datoActualizado);

	/**
	 * Carga los datos desde un archivo serializado en la ruta especificada.
	 * 
	 * @param url ruta del archivo serializado que contiene los datos
	 */
	public void cargarDesdeArchivoSerializado(String url);

	/**
	 * Escribe los datos actuales en un archivo serializado, preservando el estado
	 * de la colección.
	 */
	public void escribirEnArchivoSerializado();

	/**
	 * Busca un elemento dentro de la colección utilizando su identificador único.
	 * <p>
	 * Este método recorre la lista interna del DAO y retorna el objeto que coincida
	 * con el identificador proporcionado.
	 * </p>
	 * 
	 * @param id identificador único del objeto a buscar
	 * @return el objeto encontrado que coincide con el identificador, o
	 *         {@code null} si no existe coincidencia
	 */
	public Object buscarId(String id);

	public int buscarIdIndice(String id);

	/**
	 * Obtiene la lista completa de elementos gestionados por el DAO.
	 * 
	 * @return una lista de objetos del tipo {@code E}
	 */
	public ArrayList<E> getLista();
}
