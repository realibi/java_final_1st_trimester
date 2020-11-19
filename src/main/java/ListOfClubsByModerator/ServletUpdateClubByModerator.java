package ListOfClubsByModerator;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateClubByModerator")
public class ServletUpdateClubByModerator extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBListOfClubsByModerator db = new DBListOfClubsByModerator();
        GetSession gs = new GetSession();
        ServletListOfClubsByModerator ser = new ServletListOfClubsByModerator();
        String Title = request.getParameter("title");
        String Description = request.getParameter("description");

        db.UpdateClubByModerator(Title, Description, gs.GetIdSession(request, response));
        ser.doPost(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
