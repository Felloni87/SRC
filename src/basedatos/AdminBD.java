package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminBD {

    public static Connection obtenerConexion() throws ClassNotFoundException {
        Connection con = null;
        //	try {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }
        return con;
    }
}

