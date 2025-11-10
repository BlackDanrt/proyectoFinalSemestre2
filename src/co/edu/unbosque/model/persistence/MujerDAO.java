package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

/**
 * Implementa el patrón DAO (Data Access Object) para la entidad {@link Mujer}.
 * <p>
 * Esta clase se encarga de realizar las operaciones CRUD (Crear, Leer,
 * Actualizar, Eliminar) sobre una lista de objetos {@link Mujer}, además de
 * manejar la persistencia de los datos mediante archivos serializados.
 * </p>
 *
 * <p>
 * Se utiliza un {@link DataMapper} para convertir entre objetos del modelo
 * ({@code Mujer}) y objetos de transferencia de datos ({@code MujerDTO}), de
 * modo que se mantenga la separación entre la capa lógica y la de presentación.
 * </p>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class MujerDAO implements DAO<MujerDTO> {

	/**
	 * Lista de objetos {@link Mujer} que representa los registros almacenados en
	 * memoria.
	 */
	private ArrayList<Mujer> listaMujeres;

	/**
	 * Nombre del archivo serializado donde se guardan los datos de las mujeres.
	 */
	private static String SERIAL_FILE_NAME = "Mujeres.bin";

	/**
	 * Crea una nueva instancia del DAO para manejar datos de {@link Mujer}. La
	 * lista se inicializa al cargar los datos desde el archivo serializado.
	 */
	public MujerDAO() {
		listaMujeres = new ArrayList<Mujer>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);

	}

	/**
	 * Crea un nuevo registro de {@link Mujer} a partir de un {@link MujerDTO} y lo
	 * agrega a la lista en memoria, actualizando el archivo serializado.
	 *
	 * @param datoNuevo el objeto DTO que contiene los datos de la nueva mujer
	 */
	@Override
	public void crear(MujerDTO datoNuevo) {
		Mujer entity = DataMapper.convertirMujerDTOaMujer(datoNuevo);
		listaMujeres.add(entity);
		escribirEnArchivoSerializado();
	}

	/**
	 * Elimina un registro de {@link Mujer} según su índice dentro de la lista.
	 *
	 * @param indice posición del objeto a eliminar
	 * @return {@code true} si la eliminación fue exitosa, {@code false} si el
	 *         índice es inválido
	 */
	@Override
	public boolean eliminar(int indice) {
		if (indice < 0 || indice > listaMujeres.size()) {
			return false;
		} else {
			listaMujeres.remove(indice);
			escribirEnArchivoSerializado();
			return true;
		}
	}

	/**
	 * Actualiza los datos de una {@link Mujer} existente en la lista según su
	 * índice.
	 *
	 * @param indice          posición del objeto a actualizar
	 * @param datoActualizado objeto {@link MujerDTO} con los nuevos valores
	 * @return {@code true} si la actualización fue exitosa, {@code false} si el
	 *         índice es inválido
	 */
	@Override
	public boolean actualizar(int indice, MujerDTO datoActualizado) {
		Mujer entity = DataMapper.convertirMujerDTOaMujer(datoActualizado);
		if (indice < 0 || indice > listaMujeres.size()) {
			return false;
		} else {
			listaMujeres.set(indice, entity);
			escribirEnArchivoSerializado();
			return true;
		}
	}

	/**
	 * Carga los registros desde un archivo serializado en la ruta indicada. Si el
	 * archivo no contiene una lista válida, se crea una nueva lista vacía.
	 *
	 * @param url ruta del archivo serializado
	 */
	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido != null) {
			listaMujeres = (ArrayList<Mujer>) contenido;
		} else {
			listaMujeres = new ArrayList<Mujer>();
		}
	}

	/**
	 * Escribe la lista actual de {@link Mujer} en el archivo serializado.
	 */
	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMujeres);
	}

	/**
	 * Busca una {@link Mujer} en la lista según su identificador único.
	 * <p>
	 * Recorre la lista interna de entidades {@link Mujer} y compara su ID con el
	 * valor recibido. Si encuentra coincidencia, convierte la entidad encontrada a
	 * un {@link MujerDTO} y la retorna.
	 * </p>
	 *
	 * @param id el identificador único de la {@link Mujer} que se desea buscar
	 * @return el objeto {@link MujerDTO} correspondiente al ID dado, o {@code null}
	 *         si no se encuentra ninguna coincidencia
	 */
	@Override
	public MujerDTO buscarId(String id) {
		for (Mujer entity : listaMujeres) {
			if (entity.getId().equals(id)) {
				MujerDTO dtoEncontrado = DataMapper.convertirMujeraMujerDTO(entity);
				return dtoEncontrado;
			}
		}
		return null;
	}

	@Override
	public int buscarIdIndice(String id) {
		for (int i = 0; i < listaMujeres.size(); i++) {
			if (listaMujeres.get(i).getId().equals(id)) {
				return i;
			}
		}
		return (Integer) null;
	}

	/**
	 * Retorna la lista de mujeres convertida a objetos {@link MujerDTO}.
	 *
	 * @return una lista de {@link MujerDTO} con los datos actuales
	 */
	@Override
	public ArrayList<MujerDTO> getLista() {
		ArrayList<MujerDTO> dtoList = DataMapper.convertirListaMujeraMujerDTO(listaMujeres);
		return dtoList;
	}

	/**
	 * Reemplaza la lista interna de entidades {@link Mujer} con una nueva lista
	 * basada en los objetos {@link MujerDTO} proporcionados.
	 * <p>
	 * Este método convierte los DTO a entidades del modelo mediante el
	 * {@link DataMapper} antes de actualizar la lista interna.
	 * </p>
	 *
	 * @param listaDtos la lista de objetos {@link MujerDTO} que se desea convertir
	 *                  y establecer como la nueva lista de entidades
	 */
	public void setLista(ArrayList<MujerDTO> listaDtos) {
		ArrayList<Mujer> listaEntitys = DataMapper.convertirListaMujerDTOaMujer(listaDtos);
		this.listaMujeres = listaEntitys;
	}

	/**
	 * Obtiene el nombre del archivo serializado donde se almacenan los registros de
	 * {@link Mujer}.
	 *
	 * @return el nombre del archivo serializado
	 */
	public static String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	/**
	 * Establece un nuevo nombre para el archivo serializado que almacena los
	 * registros de {@link Mujer}.
	 *
	 * @param sERIAL_FILE_NAME el nuevo nombre del archivo serializado
	 */
	public static void setSERIAL_FILE_NAME(String sERIAL_FILE_NAME) {
		SERIAL_FILE_NAME = sERIAL_FILE_NAME;
	}

	@Override
	public void menorAMayorSeleccionAlias() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getAlias().compareTo(listaMujeres.get(min_idx).getAlias()) > 0) {
					min_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(min_idx));
			listaMujeres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionAlias() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getAlias().compareTo(listaMujeres.get(max_idx).getAlias()) < 0) {
					max_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(max_idx));
			listaMujeres.set(max_idx, temp);
		}
	}

	@Override
	public void menorAMayorSeleccionNombre() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getNombre().compareTo(listaMujeres.get(min_idx).getNombre()) > 0) {
					min_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(min_idx));
			listaMujeres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionNombre() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getNombre().compareTo(listaMujeres.get(max_idx).getNombre()) < 0) {
					max_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(max_idx));
			listaMujeres.set(max_idx, temp);
		}
	}

	@Override
	public void menorAMayorSeleccionApellido() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getApellido().compareTo(listaMujeres.get(min_idx).getApellido()) > 0) {
					min_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(min_idx));
			listaMujeres.set(min_idx, temp);
		}
	}

	@Override
	public void mayorAMenorSeleccionApellido() {
		int n = listaMujeres.size();
		for (int i = 0; i < n - 1; i++) {

			int max_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (listaMujeres.get(j).getApellido().compareTo(listaMujeres.get(max_idx).getApellido()) < 0) {
					max_idx = j;
				}
			}

			Mujer temp = listaMujeres.get(i);
			listaMujeres.set(i, listaMujeres.get(max_idx));
			listaMujeres.set(max_idx, temp);
		}
	}

	@Override
	public void mayorAMenorInsercionCantLike() {
		int n = listaMujeres.size();
		for (int i = 1; i < n; ++i) {
			Mujer key = listaMujeres.get(i);
			int j = i - 1;

			while (j >= 0 && listaMujeres.get(j).getCantLike() < key.getCantLike()) {
				listaMujeres.set(j + 1, listaMujeres.get(j));
				j = j - 1;
			}
			listaMujeres.set(j + 1, key);
		}
	}

	@Override
	public void menorAMayorInsercionCantLike() {
		int n = listaMujeres.size();
		for (int i = 1; i < n; ++i) {
			Mujer key = listaMujeres.get(i);
			int j = i - 1;

			while (j >= 0 && listaMujeres.get(j).getCantLike() > key.getCantLike()) {
				listaMujeres.set(j + 1, listaMujeres.get(j));
				j = j - 1;
			}
			listaMujeres.set(j + 1, key);
		}
	}

	@Override
	public void mayorAMenorInsercionEdad() {
		int n = listaMujeres.size();
		for (int i = 1; i < n; ++i) {
			Mujer key = listaMujeres.get(i);
			int j = i - 1;

			while (j >= 0 && listaMujeres.get(j).getEdad() < key.getEdad()) {
				listaMujeres.set(j + 1, listaMujeres.get(j));
				j = j - 1;
			}
			listaMujeres.set(j + 1, key);
		}
	}

	@Override
	public void menorAMayorInsercionEdad() {
		int n = listaMujeres.size();
		for (int i = 1; i < n; ++i) {
			Mujer key = listaMujeres.get(i);
			int j = i - 1;

			while (j >= 0 && listaMujeres.get(j).getEdad() > key.getEdad()) {
				listaMujeres.set(j + 1, listaMujeres.get(j));
				j = j - 1;
			}
			listaMujeres.set(j + 1, key);
		}
	}

}
