package modelos;

import java.util.ArrayList;

public class CalculadorPuntaje {
	private int puntosPorAcierto;

	public CalculadorPuntaje(int puntosPorAcierto) {
		this.puntosPorAcierto = puntosPorAcierto;
	}

   public Object[] calcular(ArrayList<Partido> alResult, ArrayList<Pronostico> alPronost) {
	   System.out.println("Usando puntos configurados: " + puntosPorAcierto);
	   try {
		   int puntaje = 0;
		   String nombre = null;

		   // Verificamos que ambas listas tengan el mismo tamaño y al menos un elemento
		   if (alResult.size() == alPronost.size() && alResult.size() > 0) {
			   for (int i = 0; i < alResult.size(); i++) {
				   ResultadosEnum resultado = null;

				   if (alResult.get(i).getGolesEquipo1() == alResult.get(i).getGolesEquipo2()) {
					   resultado = ResultadosEnum.EMPATE;
				   } else if (alResult.get(i).getGolesEquipo1() > alResult.get(i).getGolesEquipo2()) {
					   resultado = ResultadosEnum.GANA_EQUIPO1;
				   } else if (alResult.get(i).getGolesEquipo1() < alResult.get(i).getGolesEquipo2()) {
					   resultado = ResultadosEnum.GANA_EQUIPO2;
				   }

				   if (resultado == alPronost.get(i).getResultado()) {
					   puntaje += puntosPorAcierto;
				   }

				   // Si es el primer pronóstico, asignamos el nombre
				   if (i == 0) {
					   nombre = alPronost.get(i).getPersona().getNombre();
				   }
			   }
			   return new Object[]{nombre, puntaje};
		   } else {
			   System.out.println("Error: Las listas de resultados y pronósticos no tienen el mismo tamaño o están vacías.");
			   return new Object[]{null, 0};
		   }
	   } catch (Exception e) {
		   e.printStackTrace();
		   return new Object[]{null, 0};
	   }
   }

	public void setPuntosConfiguracion(int puntosPorAcierto) {
		this.puntosPorAcierto = puntosPorAcierto;
	}

	public int getPuntosConfiguracion() {
		return puntosPorAcierto;
	}

}
