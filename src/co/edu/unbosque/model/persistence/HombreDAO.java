package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

/**
 * Implementa el patrón DAO (Data Access Object) para la entidad {@link Hombre}.
 * <p>
 * Esta clase permite realizar las operaciones CRUD (Crear, Leer, Actualizar y
 * Eliminar) sobre una lista de objetos {@link Hombre}, además de encargarse de
 * su persistencia mediante archivos serializados.
 * </p>
 *
 * <p>
 * Utiliza la clase {@link DataMapper} para convertir entre objetos del modelo
 * ({@code Hombre}) y objetos de transferencia de datos ({@code HombreDTO}),
 * garantizando la separación entre la capa lógica y la capa de presentación.
 * </p>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class HombreDAO implements DAO<HombreDTO> {

	/**
	 * Lista que contiene los registros de {@link Hombre} cargados o creados en
	 * memoria.
	 */
	private ArrayList<Hombre> listaHombres;

	/**
	 * Nombre del archivo binario utilizado para almacenar los datos de los hombres
	 * de forma serializada.
	 */
	private static String SERIAL_FILE_NAME = "Hombres.bin";

	/**
	 * Crea una nueva instancia de {@code HombreDAO} e inicializa la lista de
	 * hombres.
	 * <p>
	 * Al instanciar el DAO, se cargan los registros existentes desde el archivo
	 * serializado, si está disponible.
	 * </p>
	 */
	public HombreDAO() {
		listaHombres = new ArrayList<Hombre>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	/**
	 * Crea un nuevo registro de {@link Hombre} a partir de un {@link HombreDTO} y
	 * lo agrega a la lista actual. Luego actualiza el archivo serializado.
	 *
	 * @param datoNuevo el objeto {@link HombreDTO} con los datos del nuevo registro
	 */
	@Override
	public void crear(HombreDTO datoNuevo) {
		Hombre entity = DataMapper.convertirHombreDTOaHombre(datoNuevo);
		listaHombres.add(entity);
		escribirEnArchivoSerializado();
	}

	/**
	 * Elimina un registro de {@link Hombre} según su índice dentro de la lista.
	 *
	 * @param indice posición del objeto a eliminar
	 * @return {@code true} si la eliminación fue exitosa, {@code false} si el
	 *         índice es inválido
	 */
	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice > listaHombres.size()) {
			return false;
		} else {
			listaHombres.remove(indice);
			escribirEnArchivoSerializado();
			return true;
		}
	}

	/**
	 * Actualiza un registro existente de {@link Hombre} en la lista, reemplazándolo
	 * por un nuevo objeto creado a partir del {@link HombreDTO} proporcionado.
	 *
	 * @param indice          posición del objeto a actualizar
	 * @param datoActualizado el DTO con los nuevos valores
	 * @return {@code true} si la actualización fue exitosa, {@code false} si el
	 *         índice es inválido
	 */
	@Override
	public boolean actualizar(int indice, HombreDTO datoActualizado) {
		Hombre entity = DataMapper.convertirHombreDTOaHombre(datoActualizado);
		if (indice < 0 || indice > listaHombres.size()) {
			return false;
		} else {
			listaHombres.set(indice, entity);
			escribirEnArchivoSerializado();
			return true;
		}
	}

	/**
	 * Guarda la lista actual de objetos {@link Hombre} en el archivo serializado
	 * definido por {@link #SERIAL_FILE_NAME}.
	 */
	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaHombres);
	}

	/**
	 * Carga los registros de {@link Hombre} desde un archivo serializado.
	 * <p>
	 * Si el archivo no contiene una lista válida, se inicializa una nueva lista
	 * vacía.
	 * </p>
	 *
	 * @param url ruta del archivo serializado
	 */
	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaHombres = (ArrayList<Hombre>) contenido;
		} else {
			listaHombres = new ArrayList<Hombre>();
		}
	}

	/**
	 * Busca un registro en la lista según el identificador especificado.
	 * <p>
	 * Recorre la lista interna de entidades {@link Hombre} y compara su
	 * identificador con el valor recibido. Si encuentra coincidencia, convierte la
	 * entidad a un {@link HombreDTO} y la retorna.
	 * </p>
	 *
	 * @param id el identificador único del {@link Hombre} que se desea buscar
	 * @return el {@link HombreDTO} correspondiente al identificador dado, o
	 *         {@code null} si no se encuentra ninguna coincidencia
	 */
	@Override
	public HombreDTO buscarId(String id) {
		for (Hombre entity : listaHombres) {
			if (entity.getId().equals(id)) {
				HombreDTO dtoEncontrado = DataMapper.convertirHombreaHombreDTO(entity);
				return dtoEncontrado;
			}
		}
		return null;
	}

	@Override
	public int buscarIdIndice(String id) {
		for (int i = 0; i < listaHombres.size(); i++) {
			if (listaHombres.get(i).getId().equals(id)) {
				return i;
			}
		}
		return (Integer) null;
	}

	/**
	 * Retorna una lista de objetos {@link HombreDTO} generada a partir de la lista
	 * actual de {@link Hombre}.
	 *
	 * @return lista de {@link HombreDTO} con los datos de los hombres actuales
	 */
	@Override
	public ArrayList<HombreDTO> getLista() {
		ArrayList<HombreDTO> dtoList = DataMapper.convertirListaHombreaHombreDTO(listaHombres);
		return dtoList;
	}

	/**
	 * Reemplaza la lista interna de entidades {@link Hombre} con una nueva lista, a
	 * partir de los objetos {@link HombreDTO} proporcionados.
	 * <p>
	 * Este método utiliza el {@link DataMapper} para convertir los objetos DTO en
	 * entidades del modelo antes de asignarlas a la lista interna.
	 * </p>
	 *
	 * @param listaDtos la lista de objetos {@link HombreDTO} que se desea convertir
	 *                  y establecer como la nueva lista de entidades
	 */
	public void setLista(ArrayList<HombreDTO> listaDtos) {
		ArrayList<Hombre> listaEntitys = DataMapper.convertirListaHombreDTOaHombre(listaDtos);
		this.listaHombres = listaEntitys;
	}

	/**
	 * Obtiene el nombre del archivo serializado donde se guardan los registros de
	 * {@link Hombre}.
	 *
	 * @return el nombre del archivo serializado
	 */
	public static String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	/**
	 * Establece un nuevo nombre para el archivo serializado que almacena los
	 * registros de {@link Hombre}.
	 *
	 * @param sERIAL_FILE_NAME el nuevo nombre del archivo serializado
	 */
	public static void setSERIAL_FILE_NAME(String sERIAL_FILE_NAME) {
		SERIAL_FILE_NAME = sERIAL_FILE_NAME;
	}

	@Override
	public void menorAMayorSeleccionAlias() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getAlias().compareTo(listaHombres.get(min_idx).getAlias()) < 0) {
					min_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(min_idx));
			listaHombres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionAlias() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getAlias().compareTo(listaHombres.get(max_idx).getAlias()) > 0) {
					max_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(max_idx));
			listaHombres.set(max_idx, temp);
		}
	}

	@Override
	public void menorAMayorSeleccionNombre() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getNombre().compareTo(listaHombres.get(min_idx).getNombre()) < 0) {
					min_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(min_idx));
			listaHombres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionNombre() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getNombre().compareTo(listaHombres.get(max_idx).getNombre()) > 0) {
					max_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(max_idx));
			listaHombres.set(max_idx, temp);
		}
	}

	@Override
	public void menorAMayorSeleccionApellido() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getApellido().compareTo(listaHombres.get(min_idx).getApellido()) < 0) {
					min_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(min_idx));
			listaHombres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionApellido() {
		int n = listaHombres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaHombres.get(j).getApellido().compareTo(listaHombres.get(max_idx).getApellido()) > 0) {
					max_idx = j;
				}
			}

			Hombre temp = listaHombres.get(i);
			listaHombres.set(i, listaHombres.get(max_idx));
			listaHombres.set(max_idx, temp);
		}
	}

	@Override
	public void mayorAMenorInsercionCantLike() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getCantLike() < key.getCantLike()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}

	@Override
	public void menorAMayorInsercionCantLike() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getCantLike() > key.getCantLike()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}

	@Override
	public void mayorAMenorInsercionEdad() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getEdad() < key.getEdad()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}

	@Override
	public void menorAMayorInsercionEdad() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getEdad() > key.getEdad()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}
	
	public void mayorAMenorInsercionIngreso() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getIngresoMensual() < key.getIngresoMensual()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}

	public void menorAMayorInsercionIngreso() {
		int n = listaHombres.size();
		for (int i = 1; i < n; ++i) {
			Hombre key = listaHombres.get(i);
			int j = i - 1;

			while (j >= 0 && listaHombres.get(j).getIngresoMensual() > key.getIngresoMensual()) {
				listaHombres.set(j + 1, listaHombres.get(j));
				j = j - 1;
			}
			listaHombres.set(j + 1, key);
		}
	}

}
