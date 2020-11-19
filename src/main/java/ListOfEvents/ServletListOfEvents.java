package ListOfEvents;

import ListOfNews.ListOfNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ServletListOfEvents")
public class ServletListOfEvents extends HttpServlet {
    DBListOfEvents dbListOfEvents = new DBListOfEvents();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Set<ListOfEvents> SetList = new HashSet<>();
        int IdForEvents = Integer.parseInt(request.getParameter("EVENTS"));

        SetList = dbListOfEvents.SelectAllEventsByClubs(IdForEvents);
        request.setAttribute("ListOfEvents", SetList);
        request.getRequestDispatcher("General/ListOfEvents.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
