package EventsByModerator;

import NewsByModerator.ServletNewsByModerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateEventsByModerator")
public class ServletUpdateEventsByModerator extends HttpServlet {
    DBEventsByModerator db = new DBEventsByModerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int update = Integer.parseInt(request.getParameter("update"));
        db.UpdateEvents(title, description, update);
        ServletEventsByModerator ser = new ServletEventsByModerator();
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
