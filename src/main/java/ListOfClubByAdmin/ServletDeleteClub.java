package ListOfClubByAdmin;

import AbstractClasses.GetSession;
import ListOfClubs.ServletListOfClubs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteClub")
public class ServletDeleteClub extends HttpServlet {
    DBClubByAdmin db = new DBClubByAdmin();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         int AdminId = db.SelectAdminId(gs.GetIdSession(request,response));
         int Club_id = db.SelectClubId(AdminId);

        db.DeleteAllInNews(Club_id);
        db.DeleteAllInEvents(Club_id);
        db.ChangeStatusToUsers(Club_id);
        db.DeleteAllModerators(Club_id);
        db.DeleteClub(AdminId);
        db.ChangeStatusOfAdmin(gs.GetIdSession(request,response));
        db.DeleteFromAdmin(gs.GetIdSession(request,response));

        ServletListOfClubs servletListOfClubs = new ServletListOfClubs();
        servletListOfClubs.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
