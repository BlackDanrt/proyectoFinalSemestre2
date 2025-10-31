package proyectoFinalSemestre2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Mujer;
import co.edu.unbosque.model.MujerDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.HombreDAO;
import co.edu.unbosque.model.persistence.MujerDAO;

public class MujerDAOTest {

	static int contador;
	static MujerDAO dao;
	static ArrayList<MujerDTO> listaAntes;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Inciando prueba unitarias");
		listaAntes = dao.getLista();
		dao = new MujerDAO();
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		dao.setLista(new ArrayList<MujerDTO>());
		System.out.println("Inciando prueba numero: " + contador);
	}

	@Test
	public void crear() {
		int tamanioPrevio = dao.getLista().size();
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assertEquals(tamanioPost, tamanioPrevio);
		assertEquals("Test", dao.getLista().get(0).getNombre());

	}

	@Test
	public void eliminar() {
		int tamanioPrevio = dao.getLista().size();
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assert (dao.eliminar(0));
		assertEquals(tamanioPrevio, tamanioPost);

	}

	@Test
	public void actualizar() {
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);
		MujerDTO dtoActualizado = new MujerDTO("000000", "TestActualizado", "Archivo", "Prueba", 0, "test@gmail.com",
				"soyLaPasswrod", "files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.actualizar(0, dtoActualizado);

		assertEquals("TestAtualizado", dao.getLista().get(0).getNombre());
	}

	@Test
	public void buscarId() {
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);
		MujerDTO dtoEncontrado = dao.buscarId("000000");
		assertEquals(dto.getNombre(), dtoEncontrado.getNombre());
	}

	@Test
	public void escrituraYCargaDeArchivo() {
		String archivoTest = "testHombres.bin";

		ArrayList<Mujer> listaTest = new ArrayList<Mujer>();
		Mujer entity = new Mujer("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		listaTest.add(entity);

		FileHandler.escribirEnArchivoSerializado(archivoTest, listaTest);
		dao.cargarDesdeArchivoSerializado(archivoTest);

		assertEquals(listaTest.size(), dao.getLista().size());
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando prueba numero: " + contador);
		contador++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias");
		dao.setLista(listaAntes);
	}
}
