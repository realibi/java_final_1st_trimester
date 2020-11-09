package FindStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet(name = "ServletFindStudent")
public class ServletFindStudent extends HttpServlet {
    DBFindStudent db = new DBFindStudent();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<FindStudent> selectAllMajors = db.SelectAllMajors();
        Set<FindStudent> selectAllGroups = db.SelectAllGroups();
        Set<FindStudent> selectAllAcademicYears = db.SelectAllAcademicYears();

        request.setAttribute("selectAllMajors", selectAllMajors);
        request.setAttribute("selectAllAcademicYears", selectAllAcademicYears);
        request.setAttribute("selectAllGroups", selectAllGroups);


        request.getRequestDispatcher("Admin/AddingModerators.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
