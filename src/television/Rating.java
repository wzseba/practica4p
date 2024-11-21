package television;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Rating {

	private Map<Integer, List<Programa>> canales;

	public Rating() {
		this.canales = new TreeMap<Integer, List<Programa>>();
	}

	public void leerRatings(String archivo) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
			String linea;

			while ((linea = br.readLine()) != null) {
				String[] datos;
				datos = linea.split(",");
				int canal = Integer.parseInt(datos[0]);
				String programa = datos[1];
				double rating = Double.parseDouble(datos[2]);

				// Crear programa
				Programa program = new Programa(canal, programa, rating);

				// Obtener una lista de programas o crear si no existe para el canal
				List<Programa> listaProgramas = canales.getOrDefault(canal, new ArrayList<>());

				// Agregar programa
				listaProgramas.add(program);

				// Actualizar el Map de canales
				canales.put(canal, listaProgramas);
			}

		} catch (IOException e) {
			System.err.println("Error al leer " + e.getMessage());
		} catch (Exception e1) {
			System.err.println("Error " + e1.getMessage());
		}

	}

	public void escribirRatingPorCanal(String salida) throws IOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(salida))) {

			for (Map.Entry<Integer, List<Programa>> entry : canales.entrySet()) {
				int canal = entry.getKey();
				List<Programa> programaTV = entry.getValue();

				double sumaRating = 0;

				for (Programa programa : programaTV) {

					sumaRating += programa.getRating();

				}

				double promedio = sumaRating / programaTV.size();

				bw.write(canal + " " + promedio + "\n");
			}

		} catch (IOException e) {
			System.err.println("Error de escritura " + e.getMessage());
		} catch (Exception e1) {
			System.err.println("Error " + e1.getMessage());
		}
	}

	public static void main(String[] args) throws IOException {

		Rating rating = new Rating();
		rating.leerRatings("ratings.in");
		rating.escribirRatingPorCanal("ratingPorCanal.out");
	}

}
