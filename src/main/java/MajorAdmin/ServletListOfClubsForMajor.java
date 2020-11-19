package MajorAdmin;

import AbstractClasses.GetCookieIdForMajor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

@WebServlet(name = "ServletListOfClubsForMajor")
public class ServletListOfClubsForMajor extends HttpServlet {
    GetCookieIdForMajor getCookieIdForMajor = new GetCookieIdForMajor();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getCookieIdForMajor.MakeZero(request, response);

        DBSelectAllClubs db = new DBSelectAllClubs();
        Queue<SelectAllClubs> selectAllClubs = db.SelectAllClubs();
        request.setAttribute("AllClubs", selectAllClubs);
        request.getRequestDispatcher("MajorAdmin/ListOfClubs.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
