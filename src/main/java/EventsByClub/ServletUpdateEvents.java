package EventsByClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateEvents")
public class ServletUpdateEvents extends HttpServlet {
    DBEventsByClub db = new DBEventsByClub();
    ServletEventsByClub ser = new ServletEventsByClub();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("update"));

        db.UpdateEvents(title, description, id);
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
