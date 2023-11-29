package datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseDeDatos {
	String url = "jdbc:mysql://localhost:3306/programa";
	String usuario = "root";
	String contraseña = "laracovid19";

	Connection conexión = DriverManager.getConnection(url, usuario, contraseña);
}
