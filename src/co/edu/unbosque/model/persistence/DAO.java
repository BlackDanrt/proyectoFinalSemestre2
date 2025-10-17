package co.edu.unbosque.model.persistence;

public interface DAO<E> {

	public void crear(E datoNuevo);

	public String mostrar();

	public boolean eliminar(int indice);

	public boolean actualizar(int indice, E datoActualizado);

	public void cargarDesdeArchivSerializado(String url);

	public void cargarDesdeArchivSerializado();

}
