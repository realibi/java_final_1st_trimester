package EventsByModerator;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCreateEventsByModerator")
public class ServletCreateEventsByModerator extends HttpServlet {
    DBEventsByModerator db = new DBEventsByModerator();
    GetSession gs= new GetSession();
    ServletEventsByModerator ser = new ServletEventsByModerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Title = request.getParameter("title");
        String Description = request.getParameter("description");
        int Club_id = db.GetClubIdByModerator(gs.GetIdSession(request, response));

        db.CreateEvents(Title, Description, Club_id);
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
