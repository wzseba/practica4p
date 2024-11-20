package television;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rating {

	private Map<Integer, List<Programa>> canales;

	public Rating() {
		this.canales = new TreeMap<Integer, List<Programa>>();
	}

	public void leerRatings(String archivo) throws IOException {

	}

	public void escribirRatingPorCanal(String salida) throws IOException {
	}

	public static void main(String[] args) throws IOException {
	}

}
