package co.edu.unbosque.model;

/**
 * Clase utilitaria para la conversión de divisas entre diferentes monedas y el
 * dólar estadounidense (USD). Proporciona métodos para convertir valores
 * monetarios desde y hacia USD utilizando tasas de cambio predefinidas.
 * 
 * <p>
 * Las divisas soportadas son:
 * </p>
 * <ul>
 * <li>ES - Peso Colombiano (COP)</li>
 * <li>BR - Real Brasileño (BRL)</li>
 * <li>RU - Rublo Ruso (RUB)</li>
 * <li>IL - Shekel Israelí (ILS)</li>
 * <li>CN - Yuan Chino (CNY)</li>
 * </ul>
 *
 * @author Juan Martinez
 * @version 1.0
 */
public class ConvertorDivisa {

	/**
	 * Constructor por defecto de la clase ConvertorDivisa. Crea una nueva instancia
	 * del conversor de divisas.
	 */
	public ConvertorDivisa() {
		// Constructor vacío
	}

	/**
	 * Convierte un valor en la moneda local especificada a dólares estadounidenses
	 * (USD).
	 * 
	 * <p>
	 * Tasas de cambio utilizadas:
	 * </p>
	 * <ul>
	 * <li>ES (COP): 3900 COP = 1 USD</li>
	 * <li>BR (BRL): 5.36 BRL = 1 USD</li>
	 * <li>RU (RUB): 8.35 RUB = 1 USD</li>
	 * <li>IL (ILS): 3.27 ILS = 1 USD</li>
	 * <li>CN (CNY): 7.13 CNY = 1 USD</li>
	 * </ul>
	 * 
	 * @param valor  el monto en la moneda local a convertir
	 * @param idioma código de idioma/país que representa la divisa origen: "ES"
	 *               (Colombia), "BR" (Brasil), "RU" (Rusia), "IL" (Israel), "CN"
	 *               (China)
	 * @return el valor convertido a dólares estadounidenses (USD). Si el idioma no
	 *         es reconocido, retorna el valor original sin conversión
	 */
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

	/**
	 * Convierte un valor en dólares estadounidenses (USD) a la moneda local
	 * especificada.
	 * 
	 * <p>
	 * Tasas de cambio utilizadas:
	 * </p>
	 * <ul>
	 * <li>ES (COP): 1 USD = 3900 COP</li>
	 * <li>BR (BRL): 1 USD = 5.36 BRL</li>
	 * <li>RU (RUB): 1 USD = 8.35 RUB</li>
	 * <li>IL (ILS): 1 USD = 3.27 ILS</li>
	 * <li>CN (CNY): 1 USD = 7.13 CNY</li>
	 * </ul>
	 * 
	 * @param valorUSD el monto en dólares estadounidenses (USD) a convertir
	 * @param idioma   código de idioma/país que representa la divisa destino: "ES"
	 *                 (Colombia), "BR" (Brasil), "RU" (Rusia), "IL" (Israel), "CN"
	 *                 (China)
	 * @return el valor convertido a la moneda local especificada. Si el idioma no
	 *         es reconocido, retorna el valor original sin conversión
	 */
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