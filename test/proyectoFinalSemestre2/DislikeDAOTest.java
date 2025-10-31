package proyectoFinalSemestre2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Dislike;
import co.edu.unbosque.model.DislikeDTO;
import co.edu.unbosque.model.persistence.DislikeDAO;
import co.edu.unbosque.model.persistence.FileHandler;

public class DislikeDAOTest {

	static int contador;
	static DislikeDAO dao;
	static ArrayList<DislikeDTO> listaAntes;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Inciando prueba unitarias");
		listaAntes = dao.getLista();
		dao = new DislikeDAO();
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		dao.setLista(new ArrayList<DislikeDTO>());
		System.out.println("Inciando prueba numero: " + contador);
	}

	@Test
	public void crear() {
		int tamanioPrevio = dao.getLista().size();
		DislikeDTO dto = new DislikeDTO("000", "111");
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assertEquals(tamanioPost, tamanioPrevio);
		assertEquals("000", dao.getLista().get(0).getIdEmisor());

	}

	@Test
	public void escrituraYCargaDeArchivo() {
		String archivoTest = "testHombres.bin";

		ArrayList<Dislike> listaTest = new ArrayList<Dislike>();
		Dislike entity = new Dislike("000", "111");
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
