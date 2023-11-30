import org.junit.Test;
import static org.junit.Assert.*;
import modelos.*;

import java.util.ArrayList;
import java.util.Arrays;

public class CalcularPuntajeTest {

    @Test
    public void PuntajeUnAcierto() {
        //ESTE TEST TESTEA SI ACIERTA UN PARTIDO DE DOS, TAMBIEN HACE PRINTS EN CONSOLA
        // instancio a persona
        Persona persona = new Persona("Marcos", "Apellido", new Ronda(), null, 0);

        // instancio equipos
        Equipo argentina = new Equipo("Argentina", "Arg");
        Equipo arabia = new Equipo("Arabia Saudita", "ArSau");

        // instancio dos partidos
        Partido partido1 = new Partido(argentina, arabia, 0, 1);
        Partido partido2 = new Partido(argentina, arabia, 1, 3);
        // instancio dos pronósticos y los seteo a la persona
        Pronostico pronostico1 = new Pronostico(partido1, argentina, ResultadosEnum.EMPATE, persona);
        persona.setPronost(pronostico1);
        Pronostico pronostico2 = new Pronostico(partido2, argentina, ResultadosEnum.GANA_EQUIPO2, persona);
        persona.setPronost(pronostico2);

        //Puntaje Inicial
        System.out.println("puntaje inicial primer test " + persona.getPuntaje());

        // calculo puntaje
        ArrayList<Partido> alResult1 = new ArrayList<>(Arrays.asList(partido1,partido2));
        ArrayList<Pronostico> alPronost1 = new ArrayList<>(Arrays.asList(pronostico1,pronostico2));
        Object[] resultadoCalculado1 = new CalculadorPuntaje().calcular(alResult1, alPronost1);

        System.out.println("puntaje calculado primer test " + resultadoCalculado1[1]);

        // suma puntaje primera ronda al puntaje total
        int puntajeTotal = (int) resultadoCalculado1[1];

        System.out.println("puntaje total primer test " + puntajeTotal);

        assertEquals(1, puntajeTotal); //SI ACIERTA UN PARTIDO

    }


    @Test
    public void PuntajeDosPartidos() {
        //ESTE TEST TESTEA SI ACIERTA LOS DOS PARTIDOS AMBOS CON EMPATE, TAMBIEN HACE PRINTS EN CONSOLA
        // instancio a persona
        Persona persona = new Persona("Marcos", "Apellido", new Ronda(), null, 0);

        // instancio equipos
        Equipo argentina = new Equipo("Argentina", "Arg");
        Equipo arabia = new Equipo("Arabia Saudita", "ArSau");

        // instancio dos partidos
        Partido partido1 = new Partido(argentina, arabia, 0, 0);
        Partido partido2 = new Partido(argentina, arabia, 1, 1);
        // instancio dos pronósticos y los seteo a la persona
        Pronostico pronostico1 = new Pronostico(partido1, argentina, ResultadosEnum.EMPATE, persona);
        persona.setPronost(pronostico1);
        Pronostico pronostico2 = new Pronostico(partido2, argentina, ResultadosEnum.EMPATE, persona);
        persona.setPronost(pronostico2);

        //Puntaje Inicial
        System.out.println("\n");
        System.out.println("puntaje inicial segundo test " + persona.getPuntaje());

        // calculo puntaje
        ArrayList<Partido> alResult1 = new ArrayList<>(Arrays.asList(partido1,partido2));
        ArrayList<Pronostico> alPronost1 = new ArrayList<>(Arrays.asList(pronostico1,pronostico2));
        Object[] resultadoCalculado1 = new CalculadorPuntaje().calcular(alResult1, alPronost1);

        System.out.println("puntaje calculado segundo test" + resultadoCalculado1[1]);

        // suma puntaje primera ronda al puntaje total
        int puntajeTotal = (int) resultadoCalculado1[1];

        System.out.println("puntaje Total segundo test " + puntajeTotal);

        assertEquals(2, puntajeTotal); //SI ACIERTA LOS DOS PARTIDOS

    }
}

