package AddModerators;

import AbstractClasses.GetCookies;
import FindStudent.DBFindStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletAddModerators")
public class ServletAddModerators extends HttpServlet {
    GetCookies gs = new GetCookies();
    DBAddModerators db = new DBAddModerators();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Action = request.getParameter("Action");
        String Moderators_Email = request.getParameter("UserEmail");
        String Moderators_Name = request.getParameter("UserName");
        String Moderators_Surname = request.getParameter("UserSurname");
        String ClubTitle = gs.GetClubTitleCookies(request,response);

      if(Action.equals("Make this User Moderator")) {
        boolean check = db.AddModerators(Moderators_Email, Moderators_Name, Moderators_Surname, ClubTitle);
        if (check) {
        db.ChangeStatus(Moderators_Email);
        }
      }
      else if(Action.equals("Delete this Moderator")){

          boolean check = db.DeleteModerator(Moderators_Email);
          if(check){db.ChangeStatusToUser(Moderators_Email);}
      }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
