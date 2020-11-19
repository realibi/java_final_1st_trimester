package MajorAdmin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteNewsForMajor")
public class ServletDeleteNewsForMajor extends HttpServlet {
    DBSelectNewsForMajor db = new DBSelectNewsForMajor();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("delete"));
        db.DeleteNews(id);


        ServletSelectNewsForMajor ser = new ServletSelectNewsForMajor();
        ser.doPost(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
