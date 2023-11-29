package negocios;

import datos.ConexionDB;
import modelos.Equipo;
import modelos.Partido;
import modelos.Persona;
import modelos.Pronostico;
import modelos.ResultadosEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ObtenerDatos {
    private ConexionDB conexion;

    public ObtenerDatos(ConexionDB conexion) {
        this.conexion = conexion;
    }

    public ArrayList<Partido> consultarDatosResultados() throws SQLException {
        String sql = "SELECT * FROM resultados";
        ResultSet rs = conexion.executeQuery(sql);

        ArrayList<Partido> partidos = new ArrayList<>();

        while (rs.next()) {
            Equipo equipo1 = new Equipo();
            equipo1.setNombre(rs.getString("equipo_1"));
            equipo1.setDescripcion("");

            Equipo equipo2 = new Equipo();
            equipo2.setNombre(rs.getString("equipo_2"));
            equipo2.setDescripcion("");

            Partido partido = new Partido();
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);
            partido.setGolesEquipo1(rs.getInt("goles_equipo_1"));
            partido.setGolesEquipo2(rs.getInt("goles_equipo_2"));

            partidos.add(partido);
        }

        return partidos;
    }

    public HashMap<String, ArrayList<Pronostico>> consultarDatosPronosticos() throws SQLException {
        String sql = "SELECT * FROM pronosticos";
        ResultSet rs = conexion.executeQuery(sql);

        HashMap<String, ArrayList<Pronostico>> pronosticosPorParticipante = new HashMap<>();

        while (rs.next()) {
            Persona persona = new Persona();
            persona.setNombre(rs.getString("nombre_participante"));
            persona.setApellido("");
            persona.setPuntaje(0);

            Equipo equipo1 = new Equipo();
            equipo1.setNombre(rs.getString("equipo_1"));
            equipo1.setDescripcion("");

            Equipo equipo2 = new Equipo();
            equipo2.setNombre(rs.getString("equipo_2"));
            equipo2.setDescripcion("");

            Partido partido = new Partido();
            partido.setEquipo1(equipo1);
            partido.setEquipo2(equipo2);

            ResultadosEnum resultado;
            if (rs.getBoolean("gana_equipo_1")) {
                resultado = ResultadosEnum.GANA_EQUIPO1;
            } else if (rs.getBoolean("empate")) {
                resultado = ResultadosEnum.EMPATE;
            } else {
                resultado = ResultadosEnum.GANA_EQUIPO2;
            }

            Pronostico pronostico = new Pronostico();
            pronostico.setPersona(persona);
            pronostico.setPartido(partido);
            pronostico.setResultado(resultado);

            String nombreParticipante = persona.getNombre();
            if (!pronosticosPorParticipante.containsKey(nombreParticipante)) {
                pronosticosPorParticipante.put(nombreParticipante, new ArrayList<>());
            }
            pronosticosPorParticipante.get(nombreParticipante).add(pronostico);
        }

        return pronosticosPorParticipante;
    }

}
