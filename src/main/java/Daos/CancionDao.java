package Daos;

import Beans.Cancion;
import Beans.TourCiudad;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {

    public ArrayList<Cancion> listarCanciones(){
        ArrayList<Cancion> listCanciones = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        String sql = "SELECT * FROM cancion;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                int idCancion = rs.getInt(1);
                String cancionName = rs.getString(2);
                String bandaId = rs.getString(3);
                Cancion cancion = new Cancion(idCancion, cancionName, bandaId);
                listCanciones.add(cancion);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listCanciones;
    }
}
