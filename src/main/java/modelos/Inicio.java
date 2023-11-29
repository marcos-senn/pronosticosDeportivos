// Inicio.java
package modelos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import datos.ConexionDB;
import negocios.ObtenerDatos;

/*public class Inicio {
	public static void iniciar(String args[]) {
		String rutaRelativaResult = "src/main/resources/resultados.csv";
		Path rutaPathResult = Paths.get(rutaRelativaResult);
		String rutaAbsolutaResult = rutaPathResult.toAbsolutePath().toString();
		String rutaRelativaPronost = "src/main/resources/pronosticos.csv";
		Path rutaPathPronost = Paths.get(rutaRelativaPronost); // no sé si es necesario poner la ruta absoluta		
		String rutaAbsolutaPronost = rutaPathPronost.toAbsolutePath().toString();// pero lo hago por las dudas

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
}*/
public class Inicio {
    public static void iniciar(String args[]) {
        String url = "jdbc:mysql://localhost:3306/programa";
        String username = "root";
        String password = "laracovid19";

        try {
            ConexionDB conexion = new ConexionDB(url, username, password);
            ObtenerDatos servicio = new ObtenerDatos(conexion);

            ArrayList<Partido> resultados = servicio.consultarDatosResultados();
            HashMap<String, ArrayList<Pronostico>> pronosticosPorParticipante = servicio.consultarDatosPronosticos();

            if (resultados != null && pronosticosPorParticipante != null) {
                for (Map.Entry<String, ArrayList<Pronostico>> entry : pronosticosPorParticipante.entrySet()) {
                    String participante = entry.getKey();
                    ArrayList<Pronostico> pronosticos = entry.getValue();

                    CalculadorPuntaje calculadorPuntaje = new CalculadorPuntaje();
                    int puntaje = calculadorPuntaje.calcular(resultados, pronosticos);

                    System.out.println("Puntaje de " + participante + ": " + puntaje);
                }
            } else {
                System.out.println("Errores en la lectura de archivo de pronosticos no se puede dar un puntaje");
            }

            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

