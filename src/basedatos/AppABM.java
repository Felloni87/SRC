package basedatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppABM {
    public static void main(String[] args) {


        Statement stmt;
        try {
            Connection conexion = AdminBD.obtenerConexion();
            stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery("select * from persona");
            while (rs.next()) {
                int ID = rs.getInt(1) ;
                System.out.println(
                        ID + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
            conexion.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    }

