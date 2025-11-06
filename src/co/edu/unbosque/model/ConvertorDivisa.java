package co.edu.unbosque.model;

public class ConvertorDivisa {

	public ConvertorDivisa() {
		// TODO Auto-generated constructor stub
	}

	public long convertirADolar(long valor, String idioma) {
		long temp = 0;
		if (idioma.equals("ES")) {
			temp = valor / 3900;
		} else if (idioma.equals("BR")) {
			temp = (long) (valor / 5.36);
		} else if (idioma.equals("RU")) {
			temp = (long) (valor / 8.35);
		} else if (idioma.equals("IL")) {
			temp = (long) (valor / 3.27);
		} else if (idioma.equals("CN")) {
			temp = (long) (valor / 7.13);
		} else {
			temp = valor;
		}
		return temp;
	}

	public long convertirAIdioma(long valorUSD, String idioma) {
		long temp = 0;
		if (idioma.equals("ES")) {
			temp = valorUSD * 3900;
		} else if (idioma.equals("BR")) {
			temp = (long) (valorUSD * 5.36);
		} else if (idioma.equals("RU")) {
			temp = (long) (valorUSD * 8.35);
		} else if (idioma.equals("IL")) {
			temp = (long) (valorUSD * 3.27);
		} else if (idioma.equals("CN")) {
			temp = (long) (valorUSD * 7.13);
		} else {
			temp = valorUSD;
		}
		return temp;
	}

}
