package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IngresarDatos {
	    private String url = "jdbc:mysql://localhost:3306/programa";
	    private String username = "root";
	    private String password = "admin";

	    public void guardarPronostico(String nombre_participante, String equipo_1, boolean gana_equipo_1, boolean empate, boolean gana_equipo_2, String equipo_2, int codigo_partido) {
	        String sql = "INSERT INTO programa.pronosticos (nombre_participante, equipo_1, gana_equipo_1, empate, gana_equipo_2, equipo_2, codigo_partido) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DriverManager.getConnection(url, username, password);
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, nombre_participante);
	            pstmt.setString(2, equipo_1);
	            pstmt.setBoolean(3, gana_equipo_1);
	            pstmt.setBoolean(4, empate);
	            pstmt.setBoolean(5, gana_equipo_2);
	            pstmt.setString(6, equipo_2);
	            pstmt.setInt(7, codigo_partido);

	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	    }
}

