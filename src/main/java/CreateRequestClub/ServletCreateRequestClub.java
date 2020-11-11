package CreateRequestClub;

import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "ServletCreateRequestClub")
public class ServletCreateRequestClub extends HttpServlet {
    DBCreateClubRequest dbCreateClubRequest = new DBCreateClubRequest();
    GetSession gs = new GetSession();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String TitleOfClub = request.getParameter("TitleOfClub");
        String Description = request.getParameter("DescriptionOfClub");
        dbCreateClubRequest.InsertToAdmin(gs.GetIdSession(request,response));

        int Id = dbCreateClubRequest.SelectAdminId(gs.GetIdSession(request, response));
        dbCreateClubRequest.InsertInfoToRequestClub(TitleOfClub, Description, Id);

        request.getRequestDispatcher("General/ListOfClubs.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
