
package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import co.edu.unbosque.model.HombreDTO;
import co.edu.unbosque.model.MujerDTO;

/**
 * Clase encargada de crear un archivo PDF con estadísticas generadas a partir
 * de los datos de hombres y mujeres almacenados en DAOs. El PDF incluye
 * gráficos de media, moda, mediana, varianza y desviación estándar para las
 * cantidades de likes y edades, diferenciando entre hombres y mujeres.
 * 
 * @author Juan Martinez
 * @version 1.0
 */
public class CreadorPdf {

	private static HombreDAO daoH;
	private static MujerDAO daoM;

	/**
	 * Constructor de la clase. Inicializa los objetos DAO para hombres y mujeres.
	 */
	public CreadorPdf() {
		daoH = new HombreDAO();
		daoM = new MujerDAO();
	}

	/**
	 * Genera y guarda un archivo PDF llamado "EstadisticasBosTinder.pdf" que
	 * contiene gráficos estadísticos y metadatos como la fecha y hora de
	 * generación. El PDF tiene 5 páginas, cada una dedicada a un tipo diferente de
	 * estadístico: media, moda, mediana, varianza y desviación estándar.
	 * <p>
	 * Antes de crear el PDF, se llaman a los métodos para generar los gráficos
	 * correspondientes.
	 * </p>
	 *
	 * @throws RuntimeException si ocurre un error de E/S durante la creación del
	 *                          PDF.
	 */
	public void crearPDF() {
		try {
			crearGraficos();
			LocalDateTime base = LocalDateTime.now();
			DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

			String fecha = base.format(formatoFecha);
			String hora = base.format(formatoHora);

			PDDocument pdf = new PDDocument();
			PDPage pagina = new PDPage(PDRectangle.A4);
			PDPage pagina2 = new PDPage(PDRectangle.A4);
			PDPage pagina3 = new PDPage(PDRectangle.A4);
			PDPage pagina4 = new PDPage(PDRectangle.A4);
			PDPage pagina5 = new PDPage(PDRectangle.A4);
			pdf.addPage(pagina);
			pdf.addPage(pagina2);
			pdf.addPage(pagina3);
			pdf.addPage(pagina4);
			pdf.addPage(pagina5);

			PDPageContentStream contenido = new PDPageContentStream(pdf, pagina);

			contenido.beginText();
			contenido.setFont(PDType1Font.TIMES_BOLD, 18);
			contenido.newLineAtOffset(100, pagina.getMediaBox().getHeight() - 50);
			contenido.showText("PDF DE ESTADISTICAS APLICATIVO BOSTINDER");
			contenido.endText();

			contenido.beginText();
			contenido.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido.newLineAtOffset(50, pagina.getMediaBox().getHeight() - 80);
			contenido.showText("Fecha de generacion: " + fecha);
			contenido.endText();

			contenido.beginText();
			contenido.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido.newLineAtOffset(50, pagina.getMediaBox().getHeight() - 100);
			contenido.showText("Hora de generacion: " + hora);
			contenido.endText();

			contenido.beginText();
			contenido.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido.newLineAtOffset(50, pagina.getMediaBox().getHeight() - 140);
			contenido.showText("Graficas de Media de likes y Edad");
			contenido.endText();

			PDImageXObject imagen = PDImageXObject.createFromFile("estadisticas/grafico_media_likes.png", pdf);
			contenido.drawImage(imagen, 70, 400, 450, 300);

			PDImageXObject imagen2 = PDImageXObject.createFromFile("estadisticas/grafico_media_edades.png", pdf);
			contenido.drawImage(imagen2, 70, 100, 450, 300);
			contenido.close();

			// Moda
			PDPageContentStream contenido2 = new PDPageContentStream(pdf, pagina2);

			contenido2.beginText();
			contenido2.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido2.newLineAtOffset(50, pagina2.getMediaBox().getHeight() - 50);
			contenido2.showText("Graficas de Moda de likes y Edad");
			contenido2.endText();

			PDImageXObject imagenModa = PDImageXObject.createFromFile("estadisticas/grafico_moda_likes.png", pdf);
			contenido2.drawImage(imagenModa, 70, 400, 450, 300);

			PDImageXObject imagenModa2 = PDImageXObject.createFromFile("estadisticas/grafico_moda_edades.png", pdf);
			contenido2.drawImage(imagenModa2, 70, 100, 450, 300);
			contenido2.close();

			// Mediana
			PDPageContentStream contenido3 = new PDPageContentStream(pdf, pagina3);

			contenido3.beginText();
			contenido3.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido3.newLineAtOffset(50, pagina3.getMediaBox().getHeight() - 50);
			contenido3.showText("Graficas de Mediana de likes y Edad");
			contenido3.endText();

			PDImageXObject imagenMediana = PDImageXObject.createFromFile("estadisticas/grafico_mediana_likes.png", pdf);
			contenido3.drawImage(imagenMediana, 70, 400, 450, 300);

			PDImageXObject imagenMediana2 = PDImageXObject.createFromFile("estadisticas/grafico_mediana_edades.png",
					pdf);
			contenido3.drawImage(imagenMediana2, 70, 100, 450, 300);
			contenido3.close();

			// Varianza
			PDPageContentStream contenido4 = new PDPageContentStream(pdf, pagina4);

			contenido4.beginText();
			contenido4.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido4.newLineAtOffset(50, pagina4.getMediaBox().getHeight() - 50);
			contenido4.showText("Graficas de Varianza de likes y Edad");
			contenido4.endText();

			PDImageXObject imagenVarianza = PDImageXObject.createFromFile("estadisticas/grafico_varianza_likes.png",
					pdf);
			contenido4.drawImage(imagenVarianza, 70, 400, 450, 300);

			PDImageXObject imagenVarianza2 = PDImageXObject.createFromFile("estadisticas/grafico_varianza_edades.png",
					pdf);
			contenido4.drawImage(imagenVarianza2, 70, 100, 450, 300);
			contenido4.close();

			// Desviación
			PDPageContentStream contenido5 = new PDPageContentStream(pdf, pagina5);

			contenido5.beginText();
			contenido5.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido5.newLineAtOffset(50, pagina5.getMediaBox().getHeight() - 50);

			contenido5.showText("Graficas de Desviacion estandar de likes y Edad");
			contenido5.endText();

			PDImageXObject imagenDesviacion = PDImageXObject.createFromFile("estadisticas/grafico_desviacion_likes.png",
					pdf);
			contenido5.drawImage(imagenDesviacion, 70, 400, 450, 300);

			PDImageXObject imagenDesviacion2 = PDImageXObject
					.createFromFile("estadisticas/grafico_desviacion_edades.png", pdf);
			contenido5.drawImage(imagenDesviacion2, 70, 100, 450, 300);
			contenido5.close();

			pdf.save("EstadisticasBosTinder.pdf");
			pdf.close();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Genera gráficos de barras en formato PNG para las estadísticas de likes y
	 * edades de hombres y mujeres. Los gráficos se guardan en la carpeta
	 * "estadisticas/". Se generan gráficos para Media, Moda, Mediana, Varianza y
	 * Desviación Estándar.
	 * <p>
	 * Utiliza métodos estáticos de esta clase para calcular los valores
	 * estadísticos.
	 * </p>
	 */
	public static void crearGraficos() {

		try {
			DefaultCategoryDataset likeMedia = new DefaultCategoryDataset();
			DefaultCategoryDataset edadMedia = new DefaultCategoryDataset();

			DefaultCategoryDataset likeModa = new DefaultCategoryDataset();
			DefaultCategoryDataset edadModa = new DefaultCategoryDataset();

			DefaultCategoryDataset likeMediana = new DefaultCategoryDataset();
			DefaultCategoryDataset edadMediana = new DefaultCategoryDataset();

			DefaultCategoryDataset likeVarianza = new DefaultCategoryDataset();
			DefaultCategoryDataset edadVarianza = new DefaultCategoryDataset();

			DefaultCategoryDataset likeDesviacion = new DefaultCategoryDataset();
			DefaultCategoryDataset edadDesviacion = new DefaultCategoryDataset();

			// Media
			double h1 = calcularMediaLikeHombre(daoH.getLista());
			double h2 = calcularMediaEdadHombre(daoH.getLista());

			double m1 = calcularMediaLikeMujer(daoM.getLista());
			double m2 = calcularMediaEdadMujer(daoM.getLista());

			likeMedia.setValue(h1, "Likes Hombres", "Hombres");
			likeMedia.setValue(m1, "Likes Mujeres", "Mujeres");

			edadMedia.setValue(h2, "Edad Hombres", "Hombres");
			edadMedia.setValue(m2, "Edad Mujeres", "Mujeres");

			// Moda
			double h3 = calcularModaLikeHombre(daoH.getLista());
			double h4 = calcularModaEdadHombre(daoH.getLista());

			double m3 = calcularModaLikeMujer(daoM.getLista());
			double m4 = calcularModaEdadMujer(daoM.getLista());

			likeModa.setValue(h3, "Likes Hombres", "Hombres");
			likeModa.setValue(m3, "Likes Mujeres", "Mujeres");

			edadModa.setValue(h4, "Edad Hombres", "Hombres");
			edadModa.setValue(m4, "Edad Mujeres", "Mujeres");

			// Mediana
			int h5 = calcularMedianaLikeHombre(daoH.getLista());
			int h6 = calcularMedianaEdadHombre(daoH.getLista());

			int m5 = calcularMedianaLikeMujer(daoM.getLista());
			int m6 = calcularMedianaEdadMujer(daoM.getLista());

			likeMediana.setValue(h5, "Likes Hombres", "Hombres");
			likeMediana.setValue(m5, "Likes Mujeres", "Mujeres");

			edadMediana.setValue(h6, "Edad Hombres", "Hombres");
			edadMediana.setValue(m6, "Edad Mujeres", "Mujeres");

			// Varianza
			double h7 = calcularVarianzaLikeHombre(daoH.getLista());
			double h8 = calcularVarianzaEdadHombre(daoH.getLista());

			double m7 = calcularVarianzaLikeMujer(daoM.getLista());
			double m8 = calcularVarianzaEdadMujer(daoM.getLista());

			likeVarianza.setValue(h7, "Likes Hombres", "Hombres");
			likeVarianza.setValue(m7, "Likes Mujeres", "Mujeres");

			edadVarianza.setValue(h8, "Edad Hombres", "Hombres");
			edadVarianza.setValue(m8, "Edad Mujeres", "Mujeres");

			// Desviacion estandar
			double h9 = calcularDesviacionEstandarLikeHombre(daoH.getLista());
			double h10 = calcularDesviacionEstandarEdadHombre(daoH.getLista());

			double m9 = calcularDesviacionEstandarLikeMujer(daoM.getLista());
			double m10 = calcularDesviacionEstandarEdadMujer(daoM.getLista());

			likeDesviacion.setValue(h9, "Likes Hombres", "Hombres");
			likeDesviacion.setValue(m9, "Likes Mujeres", "Mujeres");

			edadDesviacion.setValue(h10, "Edad Hombres", "Hombres");
			edadDesviacion.setValue(m10, "Edad Mujeres", "Mujeres");

			JFreeChart graficoLikeMedia = ChartFactory.createBarChart("Media de Likes ", "Media", "Personas",
					likeMedia);
			JFreeChart graficoEdadMedia = ChartFactory.createBarChart("Media de Edades ", "Media", "Personas",
					edadMedia);

			JFreeChart graficoLikeModa = ChartFactory.createBarChart("Moda de Likes ", "Moda", "Personas", likeModa);
			JFreeChart graficoEdadModa = ChartFactory.createBarChart("Moda de Edades ", "Moda", "Personas", edadModa);

			JFreeChart graficoLikeMediana = ChartFactory.createBarChart("Mediana de Likes ", "Mediana", "Personas",
					likeMediana);
			JFreeChart graficoEdadMediana = ChartFactory.createBarChart("Mediana de Edades ", "Mediana", "Personas",
					edadMediana);

			JFreeChart graficoLikeVarianza = ChartFactory.createBarChart("Varianza de Likes ", "Varianza", "Personas",
					likeVarianza); //
			JFreeChart graficoEdadVarianza = ChartFactory.createBarChart("Varianza de Edades ", "Varianza", "Personas",
					edadVarianza);

			JFreeChart graficoLikeDesviacion = ChartFactory.createBarChart("Desviacion estandar de Likes ",
					"Desviacion", "Personas", likeDesviacion);
			JFreeChart graficoEdadDesviacion = ChartFactory.createBarChart("Desviacion estandar de Edades ",
					"Desviacion", "Personas", edadDesviacion);

			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_media_likes.png"), graficoLikeMedia, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_media_edades.png"), graficoEdadMedia, 800,
					600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_moda_likes.png"), graficoLikeModa, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_moda_edades.png"), graficoEdadModa, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_mediana_likes.png"), graficoLikeMediana, 800,
					600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_mediana_edades.png"), graficoEdadMediana, 800,
					600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_varianza_likes.png"), graficoLikeVarianza, 800,
					600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_varianza_edades.png"), graficoEdadVarianza,
					800, 600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_desviacion_likes.png"), graficoLikeDesviacion,
					800, 600);
			ChartUtilities.saveChartAsPNG(new File("estadisticas/grafico_desviacion_edades.png"), graficoEdadDesviacion,
					800, 600);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Calcula la media (promedio) de la cantidad de likes de una lista de hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La media de los likes.
	 */
	public static double calcularMediaLikeHombre(ArrayList<HombreDTO> listaDto) {
		double suma = 0;
		for (HombreDTO dto : listaDto) {
			suma += dto.getCantLike();
		}
		return suma / listaDto.size();
	}

	/**
	 * Calcula la media (promedio) de la edad de una lista de hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La media de las edades.
	 */
	public static double calcularMediaEdadHombre(ArrayList<HombreDTO> listaDto) {
		double suma = 0;
		for (HombreDTO dto : listaDto) {
			suma += dto.getEdad();
		}
		return suma / listaDto.size();
	}

	/**
	 * Calcula la media (promedio) de la cantidad de likes de una lista de mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La media de los likes.
	 */
	public static double calcularMediaLikeMujer(ArrayList<MujerDTO> listaDto) {
		double suma = 0;
		for (MujerDTO dto : listaDto) {
			suma += dto.getCantLike();
		}
		return suma / listaDto.size();
	}

	/**
	 * Calcula la media (promedio) de la edad de una lista de mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La media de las edades.
	 */
	public static double calcularMediaEdadMujer(ArrayList<MujerDTO> listaDto) {
		double suma = 0;
		for (MujerDTO dto : listaDto) {
			suma += dto.getEdad();
		}
		return suma / listaDto.size();
	}

	/**
	 * Calcula la moda de la cantidad de likes de una lista de hombres. Si no hay un
	 * valor que se repita más que otros, o si hay empate, devuelve 0.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La moda de los likes o 0 si no hay una moda clara.
	 */
	public static double calcularModaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		for (int i = 0; i < n; i++) {
			int likesActual = listaDto.get(i).getCantLike();
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == likesActual) {
					frecuencias[j]++;
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = likesActual;
				frecuencias[cantidadUnicos] = 1;
				cantidadUnicos++;
			}
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return 0;
		}

		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	/**
	 * Calcula la moda de la edad de una lista de hombres. Si no hay un valor que se
	 * repita más que otros, o si hay empate, devuelve 0.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La moda de las edades o 0 si no hay una moda clara.
	 */
	public static double calcularModaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		for (int i = 0; i < n; i++) {
			int edadActual = listaDto.get(i).getEdad();
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == edadActual) {
					frecuencias[j]++;
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = edadActual;
				frecuencias[cantidadUnicos] = 1;
				cantidadUnicos++;
			}
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return 0;
		}

		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	/**
	 * Calcula la moda de la cantidad de likes de una lista de mujeres. Si no hay un
	 * valor que se repita más que otros, o si hay empate, devuelve 0.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La moda de los likes o 0 si no hay una moda clara.
	 */
	public static double calcularModaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		for (int i = 0; i < n; i++) {
			int likesActual = listaDto.get(i).getCantLike();
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == likesActual) {
					frecuencias[j]++;
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = likesActual;
				frecuencias[cantidadUnicos] = 1;
				cantidadUnicos++;
			}
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return 0;
		}

		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	/**
	 * Calcula la moda de la edad de una lista de mujeres. Si no hay un valor que se
	 * repita más que otros, o si hay empate, devuelve 0.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La moda de las edades o 0 si no hay una moda clara.
	 */
	public static double calcularModaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		for (int i = 0; i < n; i++) {
			int edadActual = listaDto.get(i).getEdad();
			boolean encontrado = false;

			for (int j = 0; j < cantidadUnicos; j++) {
				if (valoresUnicos[j] == edadActual) {
					frecuencias[j]++;
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				valoresUnicos[cantidadUnicos] = edadActual;
				frecuencias[cantidadUnicos] = 1;
				cantidadUnicos++;
			}
		}

		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		if (maxFrecuencia == 1) {
			return 0;
		}

		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	/**
	 * Calcula la mediana de la cantidad de likes de una lista de hombres.
	 * <p>
	 * <b>Advertencia:</b> Este método llama a un método de ordenamiento en el DAO
	 * que podría alterar el orden original de la lista de manera externa.
	 * </p>
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La mediana de los likes.
	 */
	public static int calcularMedianaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		daoH.menorAMayorInsercionCantLike();

		int n = listaDto.size();

		if (n % 2 == 0) {
			int medio1 = listaDto.get(n / 2 - 1).getCantLike();
			int medio2 = listaDto.get(n / 2).getCantLike();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			return listaDto.get(n / 2).getCantLike();
		}
	}

	/**
	 * Calcula la mediana de la edad de una lista de hombres.
	 * <p>
	 * <b>Advertencia:</b> Este método llama a un método de ordenamiento en el DAO
	 * que podría alterar el orden original de la lista de manera externa.
	 * </p>
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La mediana de las edades.
	 */
	public static int calcularMedianaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		daoH.menorAMayorInsercionEdad();

		int n = listaDto.size();

		if (n % 2 == 0) {
			int medio1 = listaDto.get(n / 2 - 1).getEdad();
			int medio2 = listaDto.get(n / 2).getEdad();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			return listaDto.get(n / 2).getEdad();
		}
	}

	/**
	 * Calcula la mediana de la cantidad de likes de una lista de mujeres.
	 * <p>
	 * <b>Advertencia:</b> Este método llama a un método de ordenamiento en el DAO
	 * que podría alterar el orden original de la lista de manera externa.
	 * </p>
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La mediana de los likes.
	 */
	public static int calcularMedianaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		daoM.menorAMayorInsercionCantLike();

		int n = listaDto.size();

		if (n % 2 == 0) {
			int medio1 = listaDto.get(n / 2 - 1).getCantLike();
			int medio2 = listaDto.get(n / 2).getCantLike();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			return listaDto.get(n / 2).getCantLike();
		}
	}

	/**
	 * Calcula la mediana de la edad de una lista de mujeres.
	 * <p>
	 * <b>Advertencia:</b> Este método llama a un método de ordenamiento en el DAO
	 * que podría alterar el orden original de la lista de manera externa.
	 * </p>
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La mediana de las edades.
	 */
	public static int calcularMedianaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		daoM.menorAMayorInsercionEdad();

		int n = listaDto.size();

		if (n % 2 == 0) {
			int medio1 = listaDto.get(n / 2 - 1).getEdad();
			int medio2 = listaDto.get(n / 2).getEdad();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			return listaDto.get(n / 2).getEdad();
		}
	}

	/**
	 * Calcula la varianza de la cantidad de likes de una lista de hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La varianza de los likes.
	 */
	public static double calcularVarianzaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double media = calcularMediaLikeHombre(listaDto);

		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		return sumaCuadrados / listaDto.size();
	}

	/**
	 * Calcula la varianza de la edad de una lista de hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La varianza de las edades.
	 */
	public static double calcularVarianzaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double media = calcularMediaEdadHombre(listaDto);

		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getEdad() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		return sumaCuadrados / listaDto.size();
	}

	/**
	 * Calcula la varianza de la cantidad de likes de una lista de mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La varianza de los likes.
	 */
	public static double calcularVarianzaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double media = calcularMediaLikeMujer(listaDto);

		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		return sumaCuadrados / listaDto.size();
	}

	/**
	 * Calcula la varianza de la edad de una lista de mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La varianza de las edades.
	 */
	public static double calcularVarianzaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double media = calcularMediaEdadMujer(listaDto);

		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getEdad() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		return sumaCuadrados / listaDto.size();
	}

	/**
	 * Calcula la desviación estándar de la cantidad de likes de una lista de
	 * hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La desviación estándar de los likes.
	 */
	public static double calcularDesviacionEstandarLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double varianza = calcularVarianzaLikeHombre(listaDto);
		return Math.sqrt(varianza);
	}

	/**
	 * Calcula la desviación estándar de la edad de una lista de hombres.
	 *
	 * @param listaDto Lista de objetos HombreDTO.
	 * @return La desviación estándar de las edades.
	 */
	public static double calcularDesviacionEstandarEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double varianza = calcularVarianzaEdadHombre(listaDto);
		return Math.sqrt(varianza);
	}

	/**
	 * Calcula la desviación estándar de la cantidad de likes de una lista de
	 * mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La desviación estándar de los likes.
	 */
	public static double calcularDesviacionEstandarLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double varianza = calcularVarianzaLikeMujer(listaDto);
		return Math.sqrt(varianza);
	}

	/**
	 * Calcula la desviación estándar de la edad de una lista de mujeres.
	 *
	 * @param listaDto Lista de objetos MujerDTO.
	 * @return La desviación estándar de las edades.
	 */
	public static double calcularDesviacionEstandarEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		double varianza = calcularVarianzaEdadMujer(listaDto);
		return Math.sqrt(varianza);
	}

}
