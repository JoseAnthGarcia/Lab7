package Servlets;

import Beans.Banda;
import Daos.BandaDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BandasServlet", urlPatterns = {"/listaBandas"})
public class BandasServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String filter = request.getParameter("filer") == null ? "y" : request.getParameter("filter");
        RequestDispatcher view;

        ArrayList<Banda> listaBandas = BandaDao.obtenerListaBandas("y");
        request.setAttribute("lista", listaBandas );

        view = request.getRequestDispatcher("listaBandas.jsp");
        view.forward(request, response);
    }
}
