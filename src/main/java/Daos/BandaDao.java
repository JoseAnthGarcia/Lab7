package Daos;

import Beans.Banda;

import java.sql.*;
import java.util.ArrayList;

public class BandaDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    //En este caso se usa preparedStatement
    public static ArrayList<Banda> obtenerListaBandas(String filter) {
        String sql = "SELECT idbanda, nombre_banda, artista_lider FROM banda\n" +
                "INNER JOIN artista ON banda.artista_lider=artista.idartista\n" +
                "WHERE lower(nombre_artista) LIKE ? or lower(nombre_banda) like ?;";
        ArrayList<Banda> listaBandas = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(url, user, pass);  // TRY with resources -> Cerrar la conexión de manera automática
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, "%"+filter); // se setea el attributo "usuario" para el primer "?" ingresado en el prepared statement
            pstmt.setString(2, "%"+filter);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Banda banda = new Banda(rs.getString(1), rs.getString(2), rs.getInt(3));
                    listaBandas.add(banda);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listaBandas;
    }
}


