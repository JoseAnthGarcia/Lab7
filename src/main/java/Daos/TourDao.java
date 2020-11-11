package Daos;

import Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class TourDao {
    public ArrayList<Tour> listarTours(){
        ArrayList<Tour> listTours = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/hr?serverTimezone=America/Lima";

        String sql = "SELECT idtour, nombre_tour, nombre_banda FROM tour t\n" +
                "INNER JOIN banda b ON t.banda=b.idbanda\n" +
                "WHERE lower(nombre_tour) LIKE '%world%';";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(sql);) {

                while (rs.next()) {
                    int idTour = rs.getInt(1);
                    String tourName = rs.getString(2);
                    String bandName = rs.getString(3);
                    Tour tour = new Tour(idTour, tourName, bandName);
                    listTours.add(tour);
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listTours;
    }
}
