package Daos;

import Beans.Artista;
import Beans.TourCiudad;

import java.sql.*;
import java.util.ArrayList;

public class ArtistaDao {

    public ArrayList<Artista> listarArtistas(){

        ArrayList<Artista> listArtistas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        String sql = "SELECT * FROM artista;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                int idArtista = rs.getInt(1);
                String artistName = rs.getString(2);
                String instrumento = rs.getString(3);
                String banda = rs.getString(4);
                Artista artista = new Artista(idArtista, artistName, instrumento,banda);
                listArtistas.add(artista);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listArtistas;
    }

    public ArrayList<Artista> listarArtistasOrder(){

        ArrayList<Artista> listArtistas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

        String sql = "";


        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                int idArtista = rs.getInt(1);
                String artistName = rs.getString(2);
                String instrumento = rs.getString(3);
                String banda = rs.getString(4);
                Artista artista = new Artista(idArtista, artistName, instrumento,banda);
                listArtistas.add(artista);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return listArtistas;
    }

}
