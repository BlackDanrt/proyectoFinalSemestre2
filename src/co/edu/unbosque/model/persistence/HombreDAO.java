package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;

public class HombreDAO implements DAO<HombreDTO> {

	private ArrayList<Hombre> listaHombres;
	private static String SERIAL_FILE_NAME = "Hombres.bin";

	public HombreDAO() {
		listaHombres = new ArrayList<Hombre>();
		cargarDesdeArchivoSerializado(SERIAL_FILE_NAME);
	}

	@Override
	public void crear(HombreDTO datoNuevo) {
		Hombre entity = DataMapper.convertirHombreDTOaHombre(datoNuevo);
		listaHombres.add(entity);
		escribirEnArchivoSerializado();
	}

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

	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaHombres);

	}

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido instanceof ArrayList<?>) {
			listaHombres = (ArrayList<Hombre>) contenido;
		} else {
			listaHombres = new ArrayList<Hombre>();
		}
	}

}
