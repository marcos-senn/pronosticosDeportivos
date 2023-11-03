package modelos;

import java.util.ArrayList;

public class CalculadorPuntaje {
    public int calcular(ArrayList<Partido> alResult, ArrayList<Pronostico> alPronost) {
        try {
            int puntaje = 0;
            for (int i = 0; i < alResult.size(); i++) { 
                ResultadosEnum resultado = null;
                if (alResult.get(i).getGolesEquipo1() == alResult.get(i).getGolesEquipo2()) {
                    resultado = ResultadosEnum.EMPATE;
                } else if (alResult.get(i).getGolesEquipo1() > alResult.get(i).getGolesEquipo2()) {
                    resultado = ResultadosEnum.GANA_EQUIPO1;
                } else if (alResult.get(i).getGolesEquipo1() < alResult.get(i).getGolesEquipo2()) {
                    resultado = ResultadosEnum.GANA_EQUIPO2;
                }
                if (resultado == (alPronost.get(i).getResultado())) {
                    puntaje += 1;
                }
            }
            return puntaje;
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        }
    }
}
