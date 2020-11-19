package ListOfClubByAdmin;

import AbstractClasses.GetConnection;
import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletClubsByAdmin")
public class ServletClubsByAdmin extends HttpServlet {
    DBClubByAdmin db = new DBClubByAdmin();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<ClubByAdmin> clubByAdmins = db.SelectAllClubs(gs.GetIdSession(request, response));
        request.setAttribute("ClubsByAdmin", clubByAdmins);
        request.getRequestDispatcher("Admin/MyClub.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
