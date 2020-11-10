package AddModerators;

import AbstractClasses.GetSession;
import CreateRequestClub.DBCreateClubRequest;
import FindStudent.DBFindStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletAddModerators")
public class ServletAddModerators extends HttpServlet {

    DBAddModerators db = new DBAddModerators();
    GetSession gs = new GetSession();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Action = request.getParameter("Action");

        int Student_id =  db.SelectStudent_id(request.getParameter("UserEmail"));
        int Id = db.SelectAdminId(gs.GetIdSession(request,response));
        int Club_id = db.SelectClub_id(Id);

        if(db.CheckForCountOfModerators(Club_id)) {
            if(Action.equals("Make this User Moderator")) {
                boolean check = db.AddModerators(Club_id, Student_id);
                if (check) {
                    db.ChangeStatus(Student_id);
                }
            }
      }
      if(Action.equals("Delete this Moderator")){

          boolean check = db.DeleteModerator(Student_id);
          if(check){db.ChangeStatusToUser(Student_id);}
       }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
