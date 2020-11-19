package EventsByClub;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCreateEvents")
public class ServletCreateEvents extends HttpServlet {
    DBEventsByClub db = new DBEventsByClub();
    GetSession gs = new GetSession();
    ServletEventsByClub ser = new ServletEventsByClub();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        int AdminId = db.SelectAdminId(gs.GetIdSession(request, response));
        int Club_id = db.SelectClubId(AdminId);

        db.CreateEvents(title, description, Club_id);
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
