package CreateRequestClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAddOrDeleteRequestedClubs")
public class ServletAddOrDeleteRequestedClubs extends HttpServlet {
    DBSelectRequestedClubsParametersForAdmin db = new DBSelectRequestedClubsParametersForAdmin();
    DBCreateClubRequest dbCreateClubRequest = new DBCreateClubRequest();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String submit = request.getParameter("Action");
        String Title = request.getParameter("RequestedClubTitle");
        String Email = request.getParameter("RequestedClubEmail");
        int Id = db.SelectIdByEmail(Email);
        int AdminId = dbCreateClubRequest.SelectAdminId(Id);

        String Description = request.getParameter("RequestedClubDescription");

        switch (submit){
            case "Delete":
                db.DeleteRequestedClub(AdminId);
                db.DeleteFromAdmin(Id);
                break;

            case "Add":
                db.InsertIntoListOfClubs(Title, Description, AdminId);
                db.ChangeStatus(Email);
                db.DeleteRequestedClub(AdminId);
                break;
        }

        ServletSelectRequestedClubsParameters ser = new ServletSelectRequestedClubsParameters();
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
