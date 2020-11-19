package ListOfClubByAdmin;

import AbstractClasses.GetSession;
import ListOfClubs.ServletListOfClubs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateClubByAdmin")
public class ServletUpdateClubByAdmin extends HttpServlet {
    DBClubByAdmin db = new DBClubByAdmin();
    GetSession gs = new GetSession();
    ServletClubsByAdmin ser = new ServletClubsByAdmin();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int AdminId = db.SelectAdminId(gs.GetIdSession(request,response));


        String title = request.getParameter("title");
        String description = request.getParameter("description");

        db.UpdateClubByAdmin(title, description, AdminId);
        ser.doPost(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
