

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
		System.out.println("Iniciando prueba unitarias");
		dao = new MujerDAO();
		listaAntes = dao.getLista();
		if (listaAntes == null) {
			listaAntes = new ArrayList<>();
		}
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		dao.setLista(new ArrayList<MujerDTO>());
		System.out.println("Inciando prueba numero: " + contador);
	}

	@Test
	public void crear() {
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);

		int tamanioPost = dao.getLista().size();
		assertEquals(1, tamanioPost);
		assertEquals("Test", dao.getLista().get(0).getNombre());

	}

	@Test
	public void eliminar() {
		int tamanioPrevio = dao.getLista().size();
		MujerDTO dto = new MujerDTO("000000", "Test", "Archivo", "Prueba", 0, "test@gmail.com", "soyLaPasswrod",
				"files/default", 0, false, 0, 0, true, false, 0, 0);
		dao.crear(dto);

		assert (dao.eliminar(0));
		int tamanioPost = dao.getLista().size();
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

		assertEquals("TestActualizado", dao.getLista().get(0).getNombre());
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

	@Test
	public void menorAMayorInsercionEdad() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

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
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

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
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default",
				50, false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 20,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				80, false, 0, 0, true, false, 0, 0);

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
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default",
				50, false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 20,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				80, false, 0, 0, true, false, 0, 0);

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
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.menorAMayorSeleccionNombre();

		assertEquals("Ana", dao.getLista().get(0).getNombre());
		assertEquals("Laura", dao.getLista().get(1).getNombre());
		assertEquals("Maria", dao.getLista().get(2).getNombre());
	}

	@Test
	public void mayorAMenorSeleccionNombre() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.mayorAMenorSeleccionNombre();

		assertEquals("Maria", dao.getLista().get(0).getNombre());
		assertEquals("Laura", dao.getLista().get(1).getNombre());
		assertEquals("Ana", dao.getLista().get(2).getNombre());
	}

	@Test
	public void menorAMayorSeleccionAlias() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.menorAMayorSeleccionAlias();

		assertEquals("Annie", dao.getLista().get(0).getAlias());
		assertEquals("Lau", dao.getLista().get(1).getAlias());
		assertEquals("Mary", dao.getLista().get(2).getAlias());
	}

	@Test
	public void mayorAMenorSeleccionAlias() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.mayorAMenorSeleccionAlias();

		assertEquals("Mary", dao.getLista().get(0).getAlias());
		assertEquals("Lau", dao.getLista().get(1).getAlias());
		assertEquals("Annie", dao.getLista().get(2).getAlias());
	}

	@Test
	public void menorAMayorSeleccionApellido() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.menorAMayorSeleccionApellido();

		assertEquals("Gomez", dao.getLista().get(0).getApellido());
		assertEquals("Lopez", dao.getLista().get(1).getApellido());
		assertEquals("Martinez", dao.getLista().get(2).getApellido());
	}

	@Test
	public void mayorAMenorSeleccionApellido() {
		MujerDTO dto1 = new MujerDTO("001", "Maria", "Gomez", "Mary", 30, "maria@test.com", "pass1", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto2 = new MujerDTO("002", "Ana", "Lopez", "Annie", 25, "ana@test.com", "pass2", "files/default", 0,
				false, 0, 0, true, false, 0, 0);
		MujerDTO dto3 = new MujerDTO("003", "Laura", "Martinez", "Lau", 35, "laura@test.com", "pass3", "files/default",
				0, false, 0, 0, true, false, 0, 0);

		dao.crear(dto1);
		dao.crear(dto2);
		dao.crear(dto3);

		dao.mayorAMenorSeleccionApellido();

		assertEquals("Martinez", dao.getLista().get(0).getApellido());
		assertEquals("Lopez", dao.getLista().get(1).getApellido());
		assertEquals("Gomez", dao.getLista().get(2).getApellido());
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
