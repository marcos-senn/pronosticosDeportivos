package modelos;


import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class LectorArchivos {
	
	private BufferedReader lector;
	String[] partes;
	public ArrayList<Partido> leerArchivoPartidos(String nombreArchivo) {
		try {
			ArrayList<Partido> alpart = new ArrayList<Partido>();
			lector = new BufferedReader(new FileReader(nombreArchivo));
			Partido p;
			String linea;
			boolean primeraLinea = true;
			while ((linea = lector.readLine()) != null) {
				if (primeraLinea) {// Salto primera línea (encabezado)                
	                primeraLinea = false;
	                continue;
	            }
				partes = linea.split(";");
				Equipo equipo1 = new Equipo(partes[0], "");
				Equipo equipo2 = new Equipo(partes[3], "");
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

				if(partes[1].equalsIgnoreCase("x")) {
					equipo = new Equipo(partes[0], "");
					result = ResultadosEnum.GANA_EQUIPO1;
					xCount++;

				} if(partes[2].equalsIgnoreCase("x")){
					if(xCount == 0){
						equipo = new Equipo(partes[0], "");
						result = ResultadosEnum.EMPATE;
						xCount++;
					} else {
						throw new RuntimeException("Error: Más de una 'x' en la misma línea.");
					}

				} if (partes[3].equalsIgnoreCase("x")) {
					if(xCount == 0) {
						equipo = new Equipo(partes[4], "");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public static void main(String[] args) {

	
	String rutaRelativaResult = "src/main/resources/resultados.csv"; //Ruta relativa
	Path rutaPathResult = Paths.get(rutaRelativaResult);
	String rutaAbsolutaResult = rutaPathResult.toAbsolutePath().toString();// Obtengo la ruta absoluta
	String rutaRelativaPronost = "src/main/resources/pronosticos.csv";
	Path rutaPathPronost = Paths.get(rutaRelativaPronost);
	String rutaAbsolutaPronost = rutaPathPronost.toAbsolutePath().toString();

	List<String[]> resultadosData = leerArchivoCSV(rutaAbsolutaResult);
    List<String[]> pronosticosData = leerArchivoCSV(rutaAbsolutaPronost);

    // Procesar los datos de resultados
    List<Partido> resultados = new ArrayList<>();
    for (String[] resultado : resultadosData) {
        String equipo1Nombre = resultado[0];
        int golesEquipo1 = Integer.parseInt(resultado[1]);
        int golesEquipo2 = Integer.parseInt(resultado[2]);
        String equipo2Nombre = resultado[3];
        Equipo equipo1 = new Equipo(equipo1Nombre, "");
        Equipo equipo2 = new Equipo(equipo2Nombre, "");
        Partido partido = new Partido(equipo1, equipo2);
        for (int i = 0; i < golesEquipo1; i++) {
            partido.agregarGolEquipo1();
        }
        for (int i = 0; i < golesEquipo2; i++) {
            partido.agregarGolEquipo2();
        }
        resultados.add(partido);
    }

    // Procesar los datos de pronósticos
    List<Pronostico> pronosticos = new ArrayList<>();
    for (String[] pronostico : pronosticosData) {
        String equipoNombre = pronostico[0];
        ResultadosEnum resultadoEnum = ResultadosEnum.valueOf(pronostico[1]);
        Equipo equipo = new Equipo(equipoNombre, "");
        Partido partido = null; // Aquí debes encontrar el partido correspondiente en resultados
        Pronostico pronosticoObj = new Pronostico(partido, equipo, resultadoEnum);
        pronosticos.add(pronosticoObj);}
        }
    

    // Ahora tienes las listas de resultados y pronósticos para trabajar con ellas



	public static List<String[]> leerArchivoCSV(String archivo) {
	    FileReader fileReader = null;
	    try {
	        fileReader = new FileReader(archivo);
	        CsvToBean<String[]> csvToBean = new CsvToBeanBuilder<String[]>(fileReader)
	            .withType(String[].class)
	            .withSeparator(';')
	            .withSkipLines(1) // Saltar la primera línea si es un encabezado
	            .build();
	        List<String[]> data = csvToBean.parse();
	        return data;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    } finally {
	        try {
	            if (fileReader != null) {
	                fileReader.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	  */
}

