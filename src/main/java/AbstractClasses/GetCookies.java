package AbstractClasses;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookies{

    public String GetEmailCookies(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        String Email = null;

        for (Cookie cookie : cookies){if (cookie.getName().equals("Email")){Email = cookie.getValue();} }

        return Email;

    }

    public String GetClubTitleCookies(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        String ClubTitle = null;

        for (Cookie cookie : cookies){if (cookie.getName().equals("ClubTitle")){ClubTitle = cookie.getValue();} }

        return ClubTitle;

    }

}
