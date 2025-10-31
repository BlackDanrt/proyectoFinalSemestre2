package proyectoFinalSemestre2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Hombre;
import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.model.persistence.HombreDAO;

public class HombreDAOTest {

	static int contador;
	static HombreDAO dao;
	static ArrayList<HombreDTO> listaAntes;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Inciando prueba unitarias");
		listaAntes = dao.getLista();
		dao = new HombreDAO();
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		dao.setLista(new ArrayList<HombreDTO>());
		System.out.println("Inciando prueba numero: " + contador);
	}

	@Test
	public void crear() {
		int tamanioPrevio = dao.getLista().size();
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assertEquals(tamanioPost, tamanioPrevio);
		assertEquals("Test", dao.getLista().get(0).getNombre());

	}

	@Test
	public void eliminar() {
		int tamanioPrevio = dao.getLista().size();
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assert (dao.eliminar(0));
		assertEquals(tamanioPrevio, tamanioPost);

	}

	@Test
	public void actualizar() {
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);
		HombreDTO dtoActualizado = new HombreDTO("000000", "TestActualizado", "Archivo", "Prueba", 0, "test@gmail.com",
				"soyLaPasswrod", "files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.actualizar(0, dtoActualizado);

		assertEquals("TestAtualizado", dao.getLista().get(0).getNombre());
	}

	@Test
	public void buscarId() {
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);
		HombreDTO dtoEncontrado = dao.buscarId("000000");
		assertEquals(dto.getNombre(), dtoEncontrado.getNombre());
	}

	@Test
	public void escrituraYCargaDeArchivo() {
		String archivoTest = "testHombres.bin";

		ArrayList<Hombre> listaTest = new ArrayList<Hombre>();
		Hombre entity = new Hombre("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
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
