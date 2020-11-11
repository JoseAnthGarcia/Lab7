package Servlets;

import Beans.Tour;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletTour", urlPatterns = {"/ServletTour"})
public class ServletTour extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TourDao td = new TourDao();
        ArrayList<Tour> listTours = td.listarTours();

        request.setAttribute("listTours", listTours);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaTours.jsp");
        requestDispatcher.forward(request, response);
    }
}
