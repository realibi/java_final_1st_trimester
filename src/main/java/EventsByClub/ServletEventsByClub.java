package EventsByClub;

import AbstractClasses.GetSession;
import NewsByClub.NewsByClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletEventsByClub")
public class ServletEventsByClub extends HttpServlet {
    DBEventsByClub db = new DBEventsByClub();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int AdminId = db.SelectAdminId(gs.GetIdSession(request, response));
        int Club_id = db.SelectClubId(AdminId);
        ArrayList<EventsByClub> eventsByClubs = db.SelectEventsByClub(Club_id);

        request.setAttribute("eventsByClubs", eventsByClubs);
        request.getRequestDispatcher("Admin/EventsByClub.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
