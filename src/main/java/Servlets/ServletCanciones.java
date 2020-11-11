package Servlets;

import Beans.Cancion;
import Beans.Tour;
import Daos.CancionDao;
import Daos.TourDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletCanciones", urlPatterns = {"/listaCanciones"})
public class ServletCanciones extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String order = request.getParameter("order");

        CancionDao cd = new CancionDao();

        if(order.equalsIgnoreCase("on")){


        }else{
            ArrayList<Cancion> listCanciones = cd.listarCanciones();

            request.setAttribute("listCanciones", listCanciones);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("listaCanciones.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
