package MajorAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteClubForMajor")
public class ServletDeleteClubForMajor extends HttpServlet {
    DBSelectAllClubs db = new DBSelectAllClubs();
    ServletListOfClubsForMajor ser = new ServletListOfClubsForMajor();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int Club_id = Integer.parseInt(request.getParameter("Delete"));
        int Student_id = db.SelectStudent_id(Club_id);

        db.DeleteAllInNews(Club_id);
        db.DeleteAllInEvents(Club_id);
        db.ChangeStatusToUsers(Club_id);
        db.DeleteAllModerators(Club_id);
        db.DeleteClub(Club_id);
        db.ChangeStatusOfAdmin(Student_id);
        db.DeleteFromAdmin(Student_id);

        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
