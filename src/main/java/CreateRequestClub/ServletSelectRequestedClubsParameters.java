package CreateRequestClub;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.ArrayList;

@WebServlet(name = "ServletSelectRequestedClubsParameters")
public class ServletSelectRequestedClubsParameters extends HttpServlet {
    DBSelectRequestedClubsParametersForAdmin db = new DBSelectRequestedClubsParametersForAdmin();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<RequestedClubsParameters> rcp = db.SelectRequestedClubParametersForAdmin();
        request.setAttribute("Parameters", rcp);

        request.getRequestDispatcher("MajorAdmin/ListOfRequestedClubs.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
