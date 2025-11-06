package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Dislike;
import co.edu.unbosque.model.DislikeDTO;

/**
 * Clase {@code DislikeDAO} que gestiona las operaciones de persistencia
 * relacionadas con los objetos {@link Dislike}.
 * <p>
 * Esta clase actúa como un Data Access Object (DAO), permitiendo la creación,
 * carga y almacenamiento de registros de dislikes en un archivo serializado.
 * </p>
 * 
 * <p>
 * Se apoya en la clase {@link FileHandler} para la lectura y escritura de los
 * datos, y utiliza la clase {@link DataMapper} para convertir entre objetos
 * {@link DislikeDTO} y {@link Dislike}.
 * </p>
 * 
 * <h3>Ejemplo de uso:</h3>
 * 
 * <pre>{@code
 * DislikeDAO dislikeDAO = new DislikeDAO();
 * DislikeDTO nuevoDislike = new DislikeDTO("usuario1", "publicacion5");
 * dislikeDAO.crear(nuevoDislike);
 * }</pre>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class DislikeDAO {

	/** Nombre del archivo donde se almacenan los dislikes serializados. */
	private static String SERIAL_FILE_NAME = "Dislikes.bin";

	/** Lista de dislikes cargados o generados en la aplicación. */
	private ArrayList<Dislike> listaDislikes;

	/**
	 * Crea una nueva instancia de {@code DislikeDAO} e intenta cargar los dislikes
	 * previamente guardados desde el archivo serializado.
	 */
	public DislikeDAO() {
		listaDislikes = new ArrayList<Dislike>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	/**
	 * Crea un nuevo dislike a partir de un objeto {@link DislikeDTO}, lo convierte
	 * en entidad {@link Dislike}, lo agrega a la lista y actualiza el archivo
	 * serializado.
	 * 
	 * @param dto objeto de transferencia de datos que representa el dislike a crear
	 */
	public void crear(DislikeDTO dto) {
		Dislike entity = DataMapper.convertirDislikeDTOaDislike(dto);
		listaDislikes.add(entity);
		escribirEnArchivoSerializado();
	}

	/**
	 * Escribe la lista actual de dislikes en el archivo serializado definido.
	 */
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaDislikes);
	}

	/**
	 * Carga la lista de dislikes desde el archivo serializado indicado. Si el
	 * archivo no existe o no contiene una lista válida, se inicializa una lista
	 * vacía.
	 * 
	 * @param url ruta del archivo desde el cual se leerán los datos
	 */
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido instanceof ArrayList<?>) {
			listaDislikes = (ArrayList<Dislike>) contenido;
		} else {
			listaDislikes = new ArrayList<Dislike>();
		}
	}

	/**
	 * Obtiene el nombre del archivo serializado usado para almacenar los dislikes.
	 * 
	 * @return nombre del archivo serializado
	 */
	public static String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	/**
	 * Establece un nuevo nombre para el archivo serializado donde se guardan los
	 * dislikes.
	 * 
	 * @param sERIAL_FILE_NAME nuevo nombre de archivo
	 */
	public static void setSERIAL_FILE_NAME(String sERIAL_FILE_NAME) {
		SERIAL_FILE_NAME = sERIAL_FILE_NAME;
	}

	public boolean buscarDislike(String idEmisor, String idReceptor) {

		for (Dislike dis : listaDislikes) {
			if (dis.getIdEmisor().equals(idEmisor) && dis.getIdReceptor().equals(idReceptor)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Obtiene la lista actual de dislikes almacenados en memoria.
	 * 
	 * @return lista de objetos {@link Dislike}
	 */
	public ArrayList<DislikeDTO> getLista() {
		ArrayList<DislikeDTO> dtoList = DataMapper.convertirListaDislikeaListaDislikeDTO(listaDislikes);
		return dtoList;
	}

	/**
	 * Reemplaza la lista actual de dislikes por una nueva.
	 * 
	 * @param listaDislikes nueva lista de dislikes
	 */
	public void setLista(ArrayList<DislikeDTO> listaDtos) {
		ArrayList<Dislike> listaEntitys = DataMapper.convertirListaDislikeDTOaListaDislike(listaDtos);
		this.listaDislikes = listaEntitys;
	}

}
