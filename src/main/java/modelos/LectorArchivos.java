// LectorArchivos.java
package modelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LectorArchivos {

	private BufferedReader lector;
	String[] partes;

	public ArrayList<Partido> leerArchivoResultados(String nombreArchivo) {
		try {
			ArrayList<Partido> alpart = new ArrayList<>();
			lector = new BufferedReader(new FileReader(nombreArchivo));
			Partido p;
			String linea;
			boolean primeraLinea = true;
			while ((linea = lector.readLine()) != null) {
				if (primeraLinea) { // Salto primera línea (encabezado)
					primeraLinea = false;
					continue;
				}
				partes = linea.split(";");
				Equipo equipo1 = new Equipo(partes[1], "");
				Equipo equipo2 = new Equipo(partes[4], "");
				p = new Partido(equipo1, equipo2, Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));

				alpart.add(p);
			}
			for (Partido partido : alpart) {
				System.out.print(partido.toString() + "\n");
			}
			lector.close();
			return alpart;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public HashMap<String, ArrayList<Pronostico>> leerArchivoPronosticoPorParticipante(String nombreArchivoPron, ArrayList<Partido> alres) {
		try {
			HashMap<String, ArrayList<Pronostico>> pronosticosPorParticipante = new HashMap<>();
			lector = new BufferedReader(new FileReader(nombreArchivoPron));
			Pronostico q;

			boolean primeraLinea = true;
			String linea = null;

			while ((linea = lector.readLine()) != null) {

				if (primeraLinea) {// Salto primera línea (encabezado)
					primeraLinea = false;
					continue;
				}
				partes = linea.split(";");
				Partido p = leerPartido(alres, 0);
				Equipo equipo = null;
				ResultadosEnum result = null;
				int xCount = 0; // contador x

				if (partes[2].equalsIgnoreCase("x")) {
					equipo = new Equipo(partes[1], "");
					result = ResultadosEnum.GANA_EQUIPO1;
					xCount++;

				}
				if (partes[3].equalsIgnoreCase("x")) {
					if (xCount == 0) {
						equipo = new Equipo(partes[1], "");
						result = ResultadosEnum.EMPATE;
						xCount++;
					} else {
						throw new RuntimeException("Error: Más de una 'x' en la misma línea.");
					}

				}
				if (partes[4].equalsIgnoreCase("x")) {
					if (xCount == 0) {
						equipo = new Equipo(partes[5], "");
						result = ResultadosEnum.GANA_EQUIPO2;
						xCount++;
					} else {
						throw new RuntimeException("Error: Más de una 'x' en la misma línea.");
					}
				}

				q = new Pronostico(p, equipo, result, null);
				// Obtener el nombre del participante
				String participante = partes[0];

				// Obtener o crear la lista de pronósticos para el participante
				ArrayList<Pronostico> pronosticos = pronosticosPorParticipante.getOrDefault(participante, new ArrayList<>());

				// Crear el pronóstico y agregarlo a la lista
				pronosticos.add(q);

				// Actualizar la lista de pronósticos para el participante
				pronosticosPorParticipante.put(participante, pronosticos);
			}

			for (ArrayList<Pronostico> pronostico : pronosticosPorParticipante.values()) {
				System.out.print(pronostico.toString() + "\n");
			}
			lector.close();
			return pronosticosPorParticipante;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Partido leerPartido(ArrayList<Partido> al, int i) {
		if (i >= 0 && i < al.size()) {
			return al.get(i);
		} else {
			return null;
		}
	}
}
