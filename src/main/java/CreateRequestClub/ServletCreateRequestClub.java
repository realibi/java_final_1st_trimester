package CreateRequestClub;

import AbstractClasses.GetCookies;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String TitleOfClub = request.getParameter("TitleOfClub");
        String Description = request.getParameter("DescriptionOfClub");

        GetCookies gc = new GetCookies();

        String Email = gc.GetEmailCookies(request, response);
        HashMap<String, String> hashMap = (HashMap<String, String>) dbCreateClubRequest.SelectNameAndSurname(Email);

        dbCreateClubRequest.InsertInfoToRequestClub(TitleOfClub, Email, hashMap.get("Name"), hashMap.get("Surname"), Description);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
