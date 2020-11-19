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

@WebServlet(name = "ServletEventsForMajor")
public class ServletEventsForMajor extends HttpServlet {
    DBSelectEventsForMajor db = new DBSelectEventsForMajor();
    GetCookieIdForMajor getCookieIdForMajor = new GetCookieIdForMajor();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(getCookieIdForMajor.GetIdCookie(request, response) == 0){
            Cookie[] cookies = request.getCookies();
            String cookieName = "Club_id";
            Cookie cookie = null;
            if(cookies !=null) {
                for(Cookie c: cookies) {
                    if(cookieName.equals(c.getName())) {
                        c.setValue(request.getParameter("EVENTS"));
                        response.addCookie(c);
                        c.setMaxAge(-1);
                    }
                }
            }
        }

        int Club_id = getCookieIdForMajor.GetIdCookie(request, response);
        Queue<SelectEventsForMajor> selectEventsForMajors = db.selectEventsForMajors(Club_id);
        request.setAttribute("EventForMajor", selectEventsForMajors);
        request.getRequestDispatcher("MajorAdmin/ListOfEvents.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
