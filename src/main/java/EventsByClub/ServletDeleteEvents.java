package EventsByClub;

import NewsByClub.DBNewsByClub;
import NewsByClub.ServletNewsByClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteEvents")
public class ServletDeleteEvents extends HttpServlet {
    DBEventsByClub db = new DBEventsByClub();
    ServletEventsByClub ser = new ServletEventsByClub();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("delete"));

        db.DeleteEvents(id);
        ser.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
