// Inicio.java
package modelos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inicio {
	public static void iniciar(String args[]) {
		String rutaRelativaResult = "src/main/resources/resultados.csv";
		Path rutaPathResult = Paths.get(rutaRelativaResult);
		String rutaAbsolutaResult = rutaPathResult.toAbsolutePath().toString();
		String rutaRelativaPronost = "src/main/resources/pronosticos.csv";
		Path rutaPathPronost = Paths.get(rutaRelativaPronost); // no sé si es necesario poner la ruta absoluta
		// pero lo hago por las dudas
		String rutaAbsolutaPronost = rutaPathPronost.toAbsolutePath().toString();

		// System.setProperty("java.net.useSystemProxies", "true");
		LectorArchivos archivo = new LectorArchivos();
		System.out.println("Resultados: " + "\n");
		ArrayList<Partido> Resultados;
		Resultados = archivo.leerArchivoResultados(rutaAbsolutaResult);
		System.out.println("Pronósticos: " + "\n");

		// Leer pronósticos para cada participante
		HashMap<String, ArrayList<Pronostico>> PronosticosPorParticipante = archivo.leerArchivoPronosticoPorParticipante(
				rutaAbsolutaPronost, Resultados);

		if (Resultados != null && PronosticosPorParticipante != null) {
			// Calcular puntaje para cada participante
			for (Map.Entry<String, ArrayList<Pronostico>> entry : PronosticosPorParticipante.entrySet()) {
				String participante = entry.getKey();
				ArrayList<Pronostico> pronosticos = entry.getValue();
				System.out.println("Puntaje de " + participante + ": " + "\n");

				CalculadorPuntaje calculadorPuntaje = new CalculadorPuntaje();
				int puntaje = calculadorPuntaje.calcular(Resultados, pronosticos);
				System.out.println("[  " + puntaje + "  ]");
			}
		} else {
			System.out.println("errores en la lectura de archivo de pronosticos no se puede dar un puntaje");
		}
	}
}
