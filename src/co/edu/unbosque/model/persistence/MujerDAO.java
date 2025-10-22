package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;

public class MujerDAO implements DAO<MujerDTO> {

	private ArrayList<Mujer> listaMujeres;
	private static String SERIAL_FILE_NAME = "Mujeres.bin";

	@Override
	public void crear(MujerDTO datoNuevo) {
		Mujer entity = DataMapper.convertirMujerDTOaMujer(datoNuevo);
		listaMujeres.add(entity);
		escribirEnArchivoSerializado();
	}

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

	@Override
	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido instanceof ArrayList<?>) {
			listaMujeres = (ArrayList<Mujer>) contenido;
		} else {
			listaMujeres = new ArrayList<Mujer>();
		}
	}

	@Override
	public void escribirEnArchivoSerializado() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMujeres);

	}

}
