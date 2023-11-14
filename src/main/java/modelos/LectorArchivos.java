package modelos;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class LectorArchivos {
	
	private BufferedReader lector;
	String[] partes;
	public ArrayList<Partido> leerArchivoResultados(String nombreArchivo) {
		try {
			ArrayList<Partido> alpart = new ArrayList<Partido>();
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
				p = new Partido(equipo1, equipo2, Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
				alpart.add(p);
			}
				for(Partido partido: alpart) {             //se puede sacar este print despues
			System.out.print(partido.toString()+"\n");}
			lector.close();
			linea = null;
			partes= null;
			return alpart;
		} catch (Exception e) {
			
			e.printStackTrace();
		  return null;
		 }
		
		
	}
	public Partido leerPartido(ArrayList<Partido> al, int i) {
	    if (i >= 0 && i < al.size()) {
	        return al.get(i);
	    } else {
	        return null; 
	    }

	}
	
	public ArrayList<Pronostico> leerArchivoPronostico(String nombreArchivoPron, ArrayList<Partido> alres){
		try {
			ArrayList<Pronostico> alpron = new ArrayList<Pronostico>();
			lector = new BufferedReader(new FileReader(nombreArchivoPron));
			Pronostico q;
			
			boolean primeraLinea = true;
			String linea = null;
			int i = 0;
			while((linea = lector.readLine()) != null) {
				
				if (primeraLinea) {// Salto primera línea (encabezado)                
	                primeraLinea = false;
	                continue;
	            }
				partes = linea.split(";");
				Partido p = leerPartido(alres, i);
				Equipo equipo = null;
				ResultadosEnum result = null;
				int xCount = 0; //contador x

				if(partes[2].equalsIgnoreCase("x")) {
					equipo = new Equipo(partes[1], "");
					result = ResultadosEnum.GANA_EQUIPO1;
					xCount++;

				} if(partes[3].equalsIgnoreCase("x")){
					if(xCount == 0){
						equipo = new Equipo(partes[1], "");
						result = ResultadosEnum.EMPATE;
						xCount++;
					} else {
						throw new RuntimeException("Error: Más de una 'x' en la misma línea.");
					}

				} if (partes[4].equalsIgnoreCase("x")) {
					if(xCount == 0) {
						equipo = new Equipo(partes[5], "");
						result = ResultadosEnum.GANA_EQUIPO2;
						xCount++;
					} else{
						throw new RuntimeException("Error: Más de una 'x' en la misma línea.");
					}
				}

				
				q = new Pronostico(p,equipo,result);
				alpron.add(q);
				i += 1;
				}
			
			for(Pronostico pronostico: alpron) {                 //se puede sacar este print despues
				System.out.print(pronostico.toString()+"\n");}
			lector.close();
			linea = null;
			partes= null;
			return alpron;
		} catch(Exception e) {
				e.printStackTrace();
			  return null;
		}
		
	}
}
	
	
	
	

