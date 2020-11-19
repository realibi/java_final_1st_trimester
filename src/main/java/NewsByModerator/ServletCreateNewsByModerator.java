package NewsByModerator;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCreateNewsByModerator")
public class ServletCreateNewsByModerator extends HttpServlet {
    DBNewsByModerator db = new DBNewsByModerator();
    GetSession gs = new GetSession();
    ServletNewsByModerator ser = new ServletNewsByModerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Title = request.getParameter("title");
        String Description = request.getParameter("description");
        int Club_id = db.GetClubIdByModerator(gs.GetIdSession(request, response));

        db.CreateNews(Title, Description, Club_id);
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
