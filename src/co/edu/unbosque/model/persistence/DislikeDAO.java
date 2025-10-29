package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Dislike;
import co.edu.unbosque.model.DislikeDTO;

public class DislikeDAO {

	private static String SERIAL_FILE_NAME = "Dislikes.bin";
	private ArrayList<Dislike> listaDislikes;

	public DislikeDAO() {
		listaDislikes = new ArrayList<>();
	}

	public void crear(DislikeDTO dto) {
		Dislike entity = DataMapper.convertirDislikeDTOaDislike(dto);
		listaDislikes.add(entity);
	}

	public void escribirEnArchivoSerializado(String url) {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaDislikes);
	}

	public void cargarDesdeArchivoSerializado(String url) {
		Object contenido = FileHandler.leerDesdeArchivoSerializado(url);
		if (contenido instanceof ArrayList<?>) {
			listaDislikes = (ArrayList<Dislike>) contenido;
		} else {
			listaDislikes = new ArrayList<Dislike>();
		}
	}

	public static String getSERIAL_FILE_NAME() {
		return SERIAL_FILE_NAME;
	}

	public static void setSERIAL_FILE_NAME(String sERIAL_FILE_NAME) {
		SERIAL_FILE_NAME = sERIAL_FILE_NAME;
	}

	public ArrayList<Dislike> getListaDislikes() {
		return listaDislikes;
	}

	public void setListaDislikes(ArrayList<Dislike> listaDislikes) {
		this.listaDislikes = listaDislikes;
	}

}
