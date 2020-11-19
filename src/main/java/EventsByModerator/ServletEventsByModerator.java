package EventsByModerator;

import AbstractClasses.GetSession;
import NewsByModerator.DBNewsByModerator;
import NewsByModerator.NewsByModerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletEventsByModerator")
public class ServletEventsByModerator extends HttpServlet {
    DBEventsByModerator db = new DBEventsByModerator();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<EventsByModerator> eventsByModerators = db.SelectEventsByModerator(gs.GetIdSession(request,response));
        request.setAttribute("eventsByModerators", eventsByModerators);
        request.getRequestDispatcher("Moderator/EventsByModerator.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
