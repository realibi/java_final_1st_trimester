package MajorAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteEventsForMajor")
public class ServletDeleteEventsForMajor extends HttpServlet {
    DBSelectEventsForMajor db = new DBSelectEventsForMajor();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("delete"));
        db.DeleteEvents(id);

        ServletEventsForMajor ser = new ServletEventsForMajor();
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
