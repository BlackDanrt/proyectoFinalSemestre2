package co.edu.unbosque.model.persistence;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

/**
 * La clase {@code FileHandler} proporciona métodos estáticos para manejar
 * archivos en diferentes formatos:
 * <ul>
 * <li>Archivos de texto plano</li>
 * <li>Archivos serializados (binarios)</li>
 * <li>Archivos de propiedades</li>
 * </ul>
 * 
 * <p>
 * Esta clase simplifica las operaciones comunes de lectura y escritura de
 * archivos mediante el uso de flujos de entrada y salida de Java.
 * </p>
 * 
 * <p>
 * Todas las operaciones son estáticas, por lo que no es necesario instanciar la
 * clase para usar sus métodos.
 * </p>
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class FileHandler {

	/** Archivo sobre el cual se realizan las operaciones. */
	public static File archivo;

	/** Escribe contenido en archivos de texto plano. */
	public static PrintWriter escritor;

	/** Permite leer archivos de texto línea por línea. */
	public static Scanner lector;

	/** Flujo de entrada para archivos serializados. */
	public static FileInputStream fis;

	/** Objeto para leer datos serializados desde un archivo. */
	public static ObjectInputStream ois;

	/** Flujo de salida para archivos serializados. */
	public static FileOutputStream fos;

	/** Objeto para escribir datos serializados en un archivo. */
	public static ObjectOutputStream oos;

	/** Maneja archivos de tipo propiedades (.properties). */
	public static Properties prop;

	/**
	 * Escribe el contenido dado dentro de un archivo de texto.
	 * 
	 * <p>
	 * Si el archivo no existe, se crea automáticamente.
	 * </p>
	 * 
	 * @param url       Ruta del archivo donde se escribirá el contenido.
	 * @param contenido Texto a escribir dentro del archivo.
	 */
	public static void escribirEnArchivoDeTexto(String url, String contenido) {
		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritor = new PrintWriter(archivo);
			escritor.println(contenido);
			escritor.close();

		} catch (IOException e) {
			System.out.println("Error al crear y escribir el archivo de texto");
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Lee el contenido completo de un archivo de texto y lo devuelve como una
	 * cadena.
	 * 
	 * <p>
	 * Si el archivo no existe, se crea vacío.
	 * </p>
	 * 
	 * @param url Ruta del archivo a leer.
	 * @return El contenido del archivo como {@code String}, o {@code null} si
	 *         ocurre un error.
	 */
	public static String leerDesdeArchivoDeTexto(String url) {
		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lector = new Scanner(archivo);
			String contenido = "";
			while (lector.hasNext()) {
				contenido += lector.nextLine() + "\n";
			}
			lector.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al leer el archivo de texto");
			System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Escribe un objeto en un archivo serializado.
	 * 
	 * <p>
	 * El objeto debe implementar la interfaz {@link java.io.Serializable}.
	 * </p>
	 * 
	 * @param url       Ruta del archivo donde se almacenará el objeto.
	 * @param contenido Objeto que se desea serializar.
	 */
	public static void escribirEnArchivoSerializado(String url, Object contenido) {
		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(contenido);
			oos.close();
			fos.close();

		} catch (IOException e) {
			System.out.println("Error al escribir en el archivo serializado");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Lee un objeto desde un archivo serializado.
	 * 
	 * <p>
	 * El archivo debe contener un objeto previamente serializado compatible con el
	 * tipo esperado.
	 * </p>
	 * 
	 * @param url Ruta del archivo serializado.
	 * @return El objeto leído desde el archivo, o {@code null} si ocurre un error.
	 */
	public static Object leerDesdeArchivoSerializado(String url) {
		File archivo = new File(url);

		try {
			if (!archivo.exists() || archivo.length() == 0) {
				return null;
			}

			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object contenido = ois.readObject();
			ois.close();
			fis.close();
			return contenido;

		} catch (EOFException e) {
			System.out.println("Archivo vacío o final de archivo alcanzado: " + url);
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println("Error al deserializar los datos del archivo serializado");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("Error al leer el archivo serializado: " + url);
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Carga un archivo de propiedades (.properties) y lo devuelve como un objeto
	 * {@link Properties}.
	 * 
	 * <p>
	 * Si el archivo no existe, se crea uno vacío.
	 * </p>
	 * 
	 * @param url Ruta del archivo de propiedades.
	 * @return Un objeto {@link Properties} con las claves y valores cargados, o
	 *         {@code null} si ocurre un error.
	 */
	public static Properties cargarArchivoDePropiedades(String url) {
		try {
			archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			prop = new Properties();
			prop.load(new FileInputStream(archivo));
			return prop;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
