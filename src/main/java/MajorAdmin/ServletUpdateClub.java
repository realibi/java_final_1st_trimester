package MajorAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateClub")
public class ServletUpdateClub extends HttpServlet {
    DBSelectAllClubs db = new DBSelectAllClubs();
    ServletListOfClubsForMajor ser = new ServletListOfClubsForMajor();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String title = request.getParameter("title");
       String description = request.getParameter("description");
       int Club_id = Integer.parseInt(request.getParameter("Update"));

       db.UpdateClubs(title, description, Club_id);
       ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
