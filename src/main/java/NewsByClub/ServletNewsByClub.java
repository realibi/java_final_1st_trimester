package NewsByClub;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletNewsByClub")
public class ServletNewsByClub extends HttpServlet {
    DBNewsByClub db = new DBNewsByClub();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int AdminId = db.SelectAdminId(gs.GetIdSession(request, response));
      int Club_id = db.SelectClubId(AdminId);
      ArrayList<NewsByClub> newsByClubs = db.SelectNewsByClub(Club_id);

      request.setAttribute("NewByClub", newsByClubs);
      request.getRequestDispatcher("Admin/NewsByClub.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
