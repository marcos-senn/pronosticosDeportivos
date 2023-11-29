package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    private Connection conn;
    private Statement stmt;

    public ConexionDB(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection(url, username, password);
        this.stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return stmt.executeQuery(sql);
    }

    public void close() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
}


