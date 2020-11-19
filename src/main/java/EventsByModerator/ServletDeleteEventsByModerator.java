package EventsByModerator;

import NewsByModerator.ServletNewsByModerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteEventsByModerator")
public class ServletDeleteEventsByModerator extends HttpServlet {
    DBEventsByModerator db = new DBEventsByModerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete = Integer.parseInt(request.getParameter("delete"));
        db.DeleteEvents(delete);
        ServletEventsByModerator sev = new ServletEventsByModerator();
        sev.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
