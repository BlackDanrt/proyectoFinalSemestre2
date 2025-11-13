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

public class CreadorPdf {

	private static HombreDAO daoH;
	private static MujerDAO daoM;

	public CreadorPdf() {
		daoH = new HombreDAO();
		daoM = new MujerDAO();
	}

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

			// PÁGINA 1 - Portada y Media
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

			PDImageXObject imagen = PDImageXObject.createFromFile("grafico_media_likes.png", pdf);
			contenido.drawImage(imagen, 70, 400, 450, 300);

			PDImageXObject imagen2 = PDImageXObject.createFromFile("grafico_media_edades.png", pdf);
			contenido.drawImage(imagen2, 70, 100, 450, 300);
			contenido.close();

			// PÁGINA 2 - Moda
			PDPageContentStream contenido2 = new PDPageContentStream(pdf, pagina2);

			contenido2.beginText();
			contenido2.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido2.newLineAtOffset(50, pagina2.getMediaBox().getHeight() - 50); // ✅ CAMBIO: usa pagina2
			contenido2.showText("Graficas de Moda de likes y Edad");
			contenido2.endText();

			PDImageXObject imagenModa = PDImageXObject.createFromFile("grafico_moda_likes.png", pdf);
			contenido2.drawImage(imagenModa, 70, 400, 450, 300);

			PDImageXObject imagenModa2 = PDImageXObject.createFromFile("grafico_moda_edades.png", pdf);
			contenido2.drawImage(imagenModa2, 70, 100, 450, 300);
			contenido2.close();

			// PÁGINA 3 - Mediana
			PDPageContentStream contenido3 = new PDPageContentStream(pdf, pagina3);

			contenido3.beginText();
			contenido3.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido3.newLineAtOffset(50, pagina3.getMediaBox().getHeight() - 50); // ✅ CAMBIO: usa pagina3
			contenido3.showText("Graficas de Mediana de likes y Edad");
			contenido3.endText();

			PDImageXObject imagenMediana = PDImageXObject.createFromFile("grafico_mediana_likes.png", pdf);
			contenido3.drawImage(imagenMediana, 70, 400, 450, 300);

			PDImageXObject imagenMediana2 = PDImageXObject.createFromFile("grafico_mediana_edades.png", pdf);
			contenido3.drawImage(imagenMediana2, 70, 100, 450, 300);
			contenido3.close();

			// PÁGINA 4 - Varianza
			PDPageContentStream contenido4 = new PDPageContentStream(pdf, pagina4);

			contenido4.beginText();
			contenido4.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido4.newLineAtOffset(50, pagina4.getMediaBox().getHeight() - 50); // ✅ CAMBIO: usa pagina4
			contenido4.showText("Graficas de Varianza de likes y Edad");
			contenido4.endText();

			PDImageXObject imagenVarianza = PDImageXObject.createFromFile("grafico_varianza_likes.png", pdf);
			contenido4.drawImage(imagenVarianza, 70, 400, 450, 300);

			PDImageXObject imagenVarianza2 = PDImageXObject.createFromFile("grafico_varianza_edades.png", pdf);
			contenido4.drawImage(imagenVarianza2, 70, 100, 450, 300);
			contenido4.close();

			// PÁGINA 5 - Desviación
			PDPageContentStream contenido5 = new PDPageContentStream(pdf, pagina5);

			contenido5.beginText();
			contenido5.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido5.newLineAtOffset(50, pagina5.getMediaBox().getHeight() - 50); // ✅ CAMBIO: usa pagina5 y corrige
																					// variable
			contenido5.showText("Graficas de Desviacion estandar de likes y Edad");
			contenido5.endText();

			PDImageXObject imagenDesviacion = PDImageXObject.createFromFile("grafico_desviacion_likes.png", pdf);
			contenido5.drawImage(imagenDesviacion, 70, 400, 450, 300);

			PDImageXObject imagenDesviacion2 = PDImageXObject.createFromFile("grafico_desviacion_edades.png", pdf);
			contenido5.drawImage(imagenDesviacion2, 70, 100, 450, 300);
			contenido5.close();

			pdf.save("EstadisticasBosTinder.pdf");
			pdf.close();

		} catch (IOException e) {
		}
	}

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
			double h9 = calcularDesviacionEstandarEdadHombre(daoH.getLista());
			double h10 = calcularDesviacionEstandarEdadHombre(daoH.getLista());

			double m9 = calcularDesviacionEstandarEdadMujer(daoM.getLista());
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
					likeMediana);
			JFreeChart graficoEdadVarianza = ChartFactory.createBarChart("Varianza de Edades ", "Varianza", "Personas",
					edadMediana);

			JFreeChart graficoLikeDesviacion = ChartFactory.createBarChart("Desviacion estandar de Likes ",
					"Desviacion", "Personas", likeMediana);
			JFreeChart graficoEdadDesviacion = ChartFactory.createBarChart("Desviacion estandar de Edades ",
					"Desviacion", "Personas", edadMediana);

			ChartUtilities.saveChartAsPNG(new File("grafico_media_likes.png"), graficoLikeMedia, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_media_edades.png"), graficoEdadMedia, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_moda_likes.png"), graficoLikeModa, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_moda_edades.png"), graficoEdadModa, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_mediana_likes.png"), graficoLikeMediana, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_mediana_edades.png"), graficoEdadMediana, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_varianza_likes.png"), graficoLikeVarianza, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_varianza_edades.png"), graficoEdadVarianza, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_desviacion_likes.png"), graficoLikeDesviacion, 800, 600);
			ChartUtilities.saveChartAsPNG(new File("grafico_desviacion_edades.png"), graficoEdadDesviacion, 800, 600);

		} catch (IOException e) {
		}
	}

	public static double calcularMediaLikeHombre(ArrayList<HombreDTO> listaDto) {
		double suma = 0;
		for (HombreDTO dto : listaDto) {
			suma += dto.getCantLike();
		}
		return suma;
	}

	public static double calcularMediaEdadHombre(ArrayList<HombreDTO> listaDto) {
		double suma = 0;
		for (HombreDTO dto : listaDto) {
			suma += dto.getEdad();
		}
		return suma;
	}

	public static double calcularMediaLikeMujer(ArrayList<MujerDTO> listaDto) {
		double suma = 0;
		for (MujerDTO dto : listaDto) {
			suma += dto.getCantLike();
		}
		return suma;
	}

	public static double calcularMediaEdadMujer(ArrayList<MujerDTO> listaDto) {
		double suma = 0;
		for (MujerDTO dto : listaDto) {
			suma += dto.getEdad();
		}
		return suma;
	}

	public static double calcularModaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		// Contar frecuencias
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

		// Encontrar máxima frecuencia
		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		// Si todos tienen frecuencia 1, no hay moda
		if (maxFrecuencia == 1) {
			return 0;
		}

		// Encontrar el valor con máxima frecuencia
		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		// Si hay más de una moda, retornar -1
		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	public static double calcularModaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		// Contar frecuencias
		for (int i = 0; i < n; i++) {
			int likesActual = listaDto.get(i).getEdad();
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

		// Encontrar máxima frecuencia
		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		// Si todos tienen frecuencia 1, no hay moda
		if (maxFrecuencia == 1) {
			return 0;
		}

		// Encontrar el valor con máxima frecuencia
		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		// Si hay más de una moda, retornar -1
		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	public static double calcularModaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		// Contar frecuencias
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

		// Encontrar máxima frecuencia
		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		// Si todos tienen frecuencia 1, no hay moda
		if (maxFrecuencia == 1) {
			return 0;
		}

		// Encontrar el valor con máxima frecuencia
		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		// Si hay más de una moda, retornar -1
		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	public static double calcularModaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		int n = listaDto.size();
		int[] valoresUnicos = new int[n];
		int[] frecuencias = new int[n];
		int cantidadUnicos = 0;

		// Contar frecuencias
		for (int i = 0; i < n; i++) {
			int likesActual = listaDto.get(i).getEdad();
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

		// Encontrar máxima frecuencia
		int maxFrecuencia = 0;
		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] > maxFrecuencia) {
				maxFrecuencia = frecuencias[i];
			}
		}

		// Si todos tienen frecuencia 1, no hay moda
		if (maxFrecuencia == 1) {
			return 0;
		}

		// Encontrar el valor con máxima frecuencia
		int contadorModas = 0;
		int moda = 0;

		for (int i = 0; i < cantidadUnicos; i++) {
			if (frecuencias[i] == maxFrecuencia) {
				moda = valoresUnicos[i];
				contadorModas++;
			}
		}

		// Si hay más de una moda, retornar -1
		if (contadorModas > 1) {
			return 0;
		}
		return moda;

	}

	public static int calcularMedianaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}
		// Ordenar de menor a mayor usando el DAO
		daoH.menorAMayorInsercionCantLike();

		int n = listaDto.size();

		if (n % 2 == 0) {
			// Par: promedio de los dos centrales
			int medio1 = listaDto.get(n / 2 - 1).getCantLike();
			int medio2 = listaDto.get(n / 2).getCantLike();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			// Impar: el central
			return listaDto.get(n / 2).getCantLike();
		}
	}

	public static int calcularMedianaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}
		// Ordenar de menor a mayor usando el DAO
		daoH.menorAMayorInsercionEdad();

		int n = listaDto.size();

		if (n % 2 == 0) {
			// Par: promedio de los dos centrales
			int medio1 = listaDto.get(n / 2 - 1).getEdad();
			int medio2 = listaDto.get(n / 2).getEdad();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			// Impar: el central
			return listaDto.get(n / 2).getEdad();
		}
	}

	public static int calcularMedianaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}
		// Ordenar de menor a mayor usando el DAO
		daoM.menorAMayorInsercionCantLike();

		int n = listaDto.size();

		if (n % 2 == 0) {
			// Par: promedio de los dos centrales
			int medio1 = listaDto.get(n / 2 - 1).getCantLike();
			int medio2 = listaDto.get(n / 2).getCantLike();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			// Impar: el central
			return listaDto.get(n / 2).getCantLike();
		}
	}

	public static int calcularMedianaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}
		// Ordenar de menor a mayor usando el DAO
		daoM.menorAMayorInsercionEdad();

		int n = listaDto.size();

		if (n % 2 == 0) {
			// Par: promedio de los dos centrales
			int medio1 = listaDto.get(n / 2 - 1).getEdad();
			int medio2 = listaDto.get(n / 2).getEdad();
			return (int) ((medio1 + medio2) / 2.0);
		} else {
			// Impar: el central
			return listaDto.get(n / 2).getEdad();
		}
	}

	public static double calcularVarianzaLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// Paso 1: Calcular la media
		double media = calcularMediaLikeHombre(listaDto);

		// Paso 2: Calcular la suma de las diferencias al cuadrado
		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		// Paso 3: Dividir entre la cantidad de datos
		return sumaCuadrados / listaDto.size();
	}

	public static double calcularVarianzaEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// Paso 1: Calcular la media
		double media = calcularMediaEdadHombre(listaDto);

		// Paso 2: Calcular la suma de las diferencias al cuadrado
		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		// Paso 3: Dividir entre la cantidad de datos
		return sumaCuadrados / listaDto.size();
	}

	public static double calcularVarianzaLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// Paso 1: Calcular la media
		double media = calcularMediaLikeMujer(listaDto);

		// Paso 2: Calcular la suma de las diferencias al cuadrado
		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		// Paso 3: Dividir entre la cantidad de datos
		return sumaCuadrados / listaDto.size();
	}

	public static double calcularVarianzaEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// Paso 1: Calcular la media
		double media = calcularMediaEdadMujer(listaDto);

		// Paso 2: Calcular la suma de las diferencias al cuadrado
		double sumaCuadrados = 0;
		for (int i = 0; i < listaDto.size(); i++) {
			double diferencia = listaDto.get(i).getCantLike() - media;
			sumaCuadrados += diferencia * diferencia;
		}

		// Paso 3: Dividir entre la cantidad de datos
		return sumaCuadrados / listaDto.size();
	}

	public static double calcularDesviacionEstandarLikeHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// La desviación estándar es la raíz cuadrada de la varianza
		double varianza = calcularVarianzaLikeHombre(listaDto);
		return Math.sqrt(varianza);
	}

	public static double calcularDesviacionEstandarEdadHombre(ArrayList<HombreDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// La desviación estándar es la raíz cuadrada de la varianza
		double varianza = calcularVarianzaEdadHombre(listaDto);
		return Math.sqrt(varianza);
	}

	public static double calcularDesviacionEstandarLikeMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// La desviación estándar es la raíz cuadrada de la varianza
		double varianza = calcularVarianzaLikeMujer(listaDto);
		return Math.sqrt(varianza);
	}

	public static double calcularDesviacionEstandarEdadMujer(ArrayList<MujerDTO> listaDto) {
		if (listaDto == null || listaDto.isEmpty()) {
			return 0;
		}

		// La desviación estándar es la raíz cuadrada de la varianza
		double varianza = calcularVarianzaEdadMujer(listaDto);
		return Math.sqrt(varianza);
	}

}
