

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.Correo;
import co.edu.unbosque.model.CorreoDTO;
import co.edu.unbosque.model.persistence.CorreoDAO;

public class CorreoDAOTest {

	static int contador;
	static CorreoDAO dao;

	@BeforeClass
	public static void antesDeTodo() {
		System.out.println("Iniciando prueba unitarias");
		dao = new CorreoDAO();
		contador = 1;
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Inciando  prueba numero: " + contador);
	}

	@Test
	public void enviarCorroRegistro() {
		CorreoDTO temp = new CorreoDTO("estehernandz2003@gmail.com", "Danrt", 123456);
		dao.enviarRegistroExitoso(temp);
	}

	@Test
	public void enviarCorreoCodigo() {
		CorreoDTO temp = new CorreoDTO("estehernandz2003@gmail.com", "Danrt", 123456);
		dao.enviarCodigoVerificacion(temp);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando prueba numero: " + contador);
		contador++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando pruebas unitarias");
	}
}
