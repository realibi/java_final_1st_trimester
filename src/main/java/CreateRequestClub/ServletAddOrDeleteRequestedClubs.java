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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String submit = request.getParameter("Action");
        String Title = request.getParameter("RequestedClubTitle");
        String Email = request.getParameter("RequestedClubEmail");
        String Name = request.getParameter("RequestedClubName");
        String Surname = request.getParameter("RequestedClubSurname");
        String Description = request.getParameter("RequestedClubDescription");

        switch (submit){
            case "Delete":
                db.DeleteRequestedClub(Title);
                break;

            case "Add":
                db.InsertIntoListOfClubs(Title,Email,Name,Surname, Description);
                db.ChangeStatus(Email);
                db.DeleteRequestedClub(Title);
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
