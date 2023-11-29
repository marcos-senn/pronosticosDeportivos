package org.example;

import modelos.Inicio;
import presentacion.VentanaPrincipal;

public class Main {
	
	public static String[] commandLineArgs;

    public static void main(String[] args) {
        commandLineArgs = args;
		VentanaPrincipal.main(args);
		Inicio.iniciar(args);

	}
}
    


