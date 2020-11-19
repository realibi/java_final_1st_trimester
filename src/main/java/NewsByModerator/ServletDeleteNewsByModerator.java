package NewsByModerator;

import ListOfClubsByModerator.ServletListOfClubsByModerator;
import NewsByClub.ServletNewsByClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteNewsByModerator")
public class ServletDeleteNewsByModerator extends HttpServlet {
    DBNewsByModerator db = new DBNewsByModerator();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int delete = Integer.parseInt(request.getParameter("delete"));
        db.DeleteNews(delete);
        ServletNewsByModerator sev = new ServletNewsByModerator();
        sev.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
