package NewsByModerator;


import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletNewsByModerator")
public class ServletNewsByModerator extends HttpServlet {
    DBNewsByModerator db = new DBNewsByModerator();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<NewsByModerator> newsByModerators = db.SelectNewsByModerator(gs.GetIdSession(request,response));
        request.setAttribute("NewsByModerator", newsByModerators);
        request.getRequestDispatcher("Moderator/NewsByModerator.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
