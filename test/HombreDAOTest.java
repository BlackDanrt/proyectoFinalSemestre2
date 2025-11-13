

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
		System.out.println("Inciando pruebas unitarias");
		dao = new HombreDAO();
		listaAntes = dao.getLista();
		if (listaAntes == null) {
			listaAntes = new ArrayList<>();
		}
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		dao.setLista(new ArrayList<HombreDTO>());
		System.out.println("Inciando prueba numero: " + contador);
	}

	@Test
	public void crear() {
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assertEquals(1, tamanioPost);
		assertEquals("Test", dao.getLista().get(0).getNombre());

	}

	@Test
	public void eliminar() {
		int tamanioPrevio = dao.getLista().size();
		HombreDTO dto = new HombreDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		dao.crear(dto);

		assert (dao.eliminar(0));
		int tamanioPost = dao.getLista().size();
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

		assertEquals("TestActualizado", dao.getLista().get(0).getNombre());
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

	@Test
	public void menorAMayorInsercionEdad() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.menorAMayorInsercionEdad();
		
		assertEquals(25, dao.getLista().get(0).getEdad());
		assertEquals(30, dao.getLista().get(1).getEdad());
		assertEquals(35, dao.getLista().get(2).getEdad());
	}

	@Test
	public void mayorAMenorInsercionEdad() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.mayorAMenorInsercionEdad();
		
		assertEquals(35, dao.getLista().get(0).getEdad());
		assertEquals(30, dao.getLista().get(1).getEdad());
		assertEquals(25, dao.getLista().get(2).getEdad());
	}

	@Test
	public void menorAMayorInsercionCantLike() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 50, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 20, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 80, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.menorAMayorInsercionCantLike();
		
		assertEquals(20, dao.getLista().get(0).getCantLike());
		assertEquals(50, dao.getLista().get(1).getCantLike());
		assertEquals(80, dao.getLista().get(2).getCantLike());
	}

	@Test
	public void mayorAMenorInsercionCantLike() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 50, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 20, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 80, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.mayorAMenorInsercionCantLike();
		
		assertEquals(80, dao.getLista().get(0).getCantLike());
		assertEquals(50, dao.getLista().get(1).getCantLike());
		assertEquals(20, dao.getLista().get(2).getCantLike());
	}

	

	@Test
	public void menorAMayorSeleccionNombre() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.menorAMayorSeleccionNombre();
		
		assertEquals("Ana", dao.getLista().get(0).getNombre());
		assertEquals("Carlos", dao.getLista().get(1).getNombre());
		assertEquals("Pedro", dao.getLista().get(2).getNombre());
	}
	
	@Test
	public void menorAMayorInsercionIngreso() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 3000000L, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 1500000L, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 5000000L, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.menorAMayorInsercionIngreso();
		
		assertEquals(1500000L, dao.getLista().get(0).getIngresoMensual());
		assertEquals(3000000L, dao.getLista().get(1).getIngresoMensual());
		assertEquals(5000000L, dao.getLista().get(2).getIngresoMensual());
	}

	@Test
	public void mayorAMenorInsercionIngreso() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 3000000L, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 1500000L, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 5000000L, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.mayorAMenorInsercionIngreso();
		
		assertEquals(5000000L, dao.getLista().get(0).getIngresoMensual());
		assertEquals(3000000L, dao.getLista().get(1).getIngresoMensual());
		assertEquals(1500000L, dao.getLista().get(2).getIngresoMensual());
	}

	@Test
	public void mayorAMenorSeleccionNombre() {
		HombreDTO dto1 = new HombreDTO("001", "Carlos", "Gomez", "Charlie", 30, "carlos@test.com", "pass1",
				"files/default", 0, false, 0, 0, true, 0, false, 170);
		HombreDTO dto2 = new HombreDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2",
				"files/default", 0, false, 0, 0, true, 0, false, 160);
		HombreDTO dto3 = new HombreDTO("003", "Pedro", "Martinez", "Pete", 35, "pedro@test.com", "pass3",
				"files/default", 0, false, 0, 0, true, 0, false, 175);
		
		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);
		
		dao.mayorAMenorSeleccionNombre();
		
		assertEquals("Pedro", dao.getLista().get(0).getNombre());
		assertEquals("Carlos", dao.getLista().get(1).getNombre());
		assertEquals("Ana", dao.getLista().get(2).getNombre());
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
