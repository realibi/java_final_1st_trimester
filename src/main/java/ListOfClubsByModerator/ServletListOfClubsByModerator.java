package ListOfClubsByModerator;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletListOfClubsByModerator")
public class ServletListOfClubsByModerator extends HttpServlet {
    DBListOfClubsByModerator db = new DBListOfClubsByModerator();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<ListOfClubsByModerator> listOfClubsByModerators = db.SelectAllClubs(gs.GetIdSession(request,response));
        request.setAttribute("ListOfClubsByModerator", listOfClubsByModerators);
        request.getRequestDispatcher("Moderator/ListOfClubsByModerator.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
