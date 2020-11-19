package ListOfClubs;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet(name = "ServletListOfClubs")
public class ServletListOfClubs extends HttpServlet {
    DBListOfClubs dbListOfClubs = new DBListOfClubs();
    GetSession gs = new GetSession();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<ListOfClass> listOfClasses = dbListOfClubs.SelectAllClubs();
        String Status = dbListOfClubs.CheckingStatus(gs.GetIdSession(request, response));
        request.setAttribute("Clubs", listOfClasses);
        if(Status.equals("User")){request.setAttribute("Status", "User");}
        else if(Status.equals("Admin")){request.setAttribute("Status", "Admin");}
        else if(Status.equals("Moderator")){request.setAttribute("Status", "Moderator");}

        request.getRequestDispatcher("General/ListOfClubs.jsp").forward(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
