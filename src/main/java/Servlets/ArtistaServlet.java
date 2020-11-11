package Servlets;

import Beans.Artista;
import Beans.Cancion;
import Beans.Tour;
import Daos.ArtistaDao;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ArtistaServlet", urlPatterns = {"listarCancionesOrden"})
public class ArtistaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String order = request.getParameter("filter") == null?
                "listar" : request.getParameter("order");

        ArtistaDao ad = new ArtistaDao();

        if(order.equalsIgnoreCase("on")){
            ArrayList<Artista> listArtistas = ad.listarArtistasOrder();

            request.setAttribute("order", order);

            request.setAttribute("listArtistas", listArtistas);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaArtistas.jsp");
            requestDispatcher.forward(request, response);

        }

        ArrayList<Artista> listArtistas = ad.listarArtistas();

        request.setAttribute("listArtistas", listArtistas);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaArtistas.jsp");
        requestDispatcher.forward(request, response);

    }
}
