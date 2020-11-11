package Daos;

import Beans.Tour;
import Beans.TourCiudad;

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
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

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

    public ArrayList<TourCiudad> listarToursPorCiudad(){

        ArrayList<TourCiudad> listToursPorCiudad = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        String sql = "SELECT nombre_tour, nombre_ciudad, fecha FROM tour t\n" +
                "INNER JOIN tours_por_ciudad tpc ON t.idtour = tpc.tour\n" +
                "INNER JOIN ciudad c ON tpc.ciudad = c.idciudad;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                String tourName = rs.getString(1);
                String cityName = rs.getString(2);
                Date date = rs.getDate(3);
                TourCiudad tc = new TourCiudad(tourName, cityName, date);
                listToursPorCiudad.add(tc);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listToursPorCiudad;
    }
}
