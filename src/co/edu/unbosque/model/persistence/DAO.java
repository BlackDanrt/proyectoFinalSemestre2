package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

public interface DAO<E> {

	public void crear(E datoNuevo);

	public boolean eliminar(int indice);

	public boolean actualizar(int indice, E datoActualizado);

	public void cargarDesdeArchivoSerializado(String url);

	public void escribirEnArchivoSerializado();

	public ArrayList<E> getLista();
}
