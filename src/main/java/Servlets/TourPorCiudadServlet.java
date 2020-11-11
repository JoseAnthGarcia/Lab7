package Servlets;

import Beans.Tour;
import Beans.TourCiudad;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "TourPorCiudadServlet", urlPatterns = {"/listaToursporCiudad"})
public class TourPorCiudadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TourDao td = new TourDao();
        ArrayList<TourCiudad> listToursPorCiudad = td.listarToursPorCiudad();

        request.setAttribute("listToursPorCiudad", listToursPorCiudad);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaTourCiudad.jsp");
        requestDispatcher.forward(request, response);
    }
}
