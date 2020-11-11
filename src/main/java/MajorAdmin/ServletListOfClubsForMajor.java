package MajorAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletListOfClubsForMajor")
public class ServletListOfClubsForMajor extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBSelectAllClubs db = new DBSelectAllClubs();
        ArrayList<SelectAllClubs> selectAllClubs = db.SelectAllClubs();
        request.setAttribute("AllClubs", selectAllClubs);
        request.getRequestDispatcher("MajorAdmin/ListOfClubs.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
