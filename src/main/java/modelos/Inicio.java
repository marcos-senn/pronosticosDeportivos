// Inicio.java
package modelos;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import datos.ConexionDB;
import negocios.ObtenerDatos;

public class Inicio {
    public static CalculadorPuntaje calculadorPuntaje = new CalculadorPuntaje(1);

    public static void actualizarConfiguracion(int nuevaConfiguracion) {
        calculadorPuntaje.setPuntosConfiguracion(nuevaConfiguracion);
        System.out.println("Usando puntos configurados: " + calculadorPuntaje.getPuntosConfiguracion());
    }
    public static Object[][] iniciar(String[] args) {
    	String url = "jdbc:mysql://localhost:3306/programa";
        String username = "root";
        String password = "admin";

        ArrayList<Object[]> puntajes = new ArrayList<>();

        try {
            ConexionDB conexion = new ConexionDB(url, username, password);
            ObtenerDatos servicio = new ObtenerDatos(conexion);

            ArrayList<Partido> resultados = servicio.consultarDatosResultados();
            HashMap<String, ArrayList<Pronostico>> pronosticosPorParticipante = servicio.consultarDatosPronosticos();

            if (resultados != null && pronosticosPorParticipante != null) {
                for (Map.Entry<String, ArrayList<Pronostico>> entry : pronosticosPorParticipante.entrySet()) {
                    ArrayList<Pronostico> pronosticos = entry.getValue();

                    Object[] puntaje = calculadorPuntaje.calcular(resultados, pronosticos);


                    puntajes.add(puntaje);
                }
            } else {
                System.out.println("Errores en la lectura de archivo de pronosticos no se puede dar un puntaje");
            }

            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        Object[][] arrayPuntajes = new Object[puntajes.size()][];
        for (int i = 0; i < puntajes.size(); i++) {
            Object[] row = puntajes.get(i);
            arrayPuntajes[i] = row;
        }

        return arrayPuntajes;
    }
}

