package org.example;

import modelos.LectorArchivos;
import modelos.Partido;
import modelos.Pronostico;
import modelos.CalculadorPuntaje;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {

		String rutaRelativaResult = "src/main/resources/resultados.csv"; 
		Path rutaPathResult = Paths.get(rutaRelativaResult);             
		String rutaAbsolutaResult = rutaPathResult.toAbsolutePath().toString();
		String rutaRelativaPronost = "src/main/resources/pronosticos.csv";
		Path rutaPathPronost = Paths.get(rutaRelativaPronost);                    //no sé si es necesario poner la ruta absoluta 
		String rutaAbsolutaPronost = rutaPathPronost.toAbsolutePath().toString(); //pero lo hago por las dudas
		
		//System.setProperty("java.net.useSystemProxies", "true");
LectorArchivos archivo = new LectorArchivos();
System.out.println("Resultados: "+"\n");
ArrayList<Partido> Resultados = archivo.leerArchivoPartidos(rutaAbsolutaResult);
System.out.println("Pronósticos: "+"\n");
ArrayList<Pronostico> Pronosticos = archivo.leerArchivoPronostico(rutaAbsolutaPronost,Resultados);

if(Resultados != null && Pronosticos !=null){
	System.out.println("Puntaje Persona 1: "+"\n");
	CalculadorPuntaje persona1 = new CalculadorPuntaje();
	int puntajePersona1;
	puntajePersona1 = persona1.calcular(Resultados, Pronosticos);
	System.out.println("[  "+puntajePersona1+"  ]");
} else{
	System.out.println("errores en la lectura de archivo de pronosticos no se puede dar un puntaje");
}
	}
}
    


