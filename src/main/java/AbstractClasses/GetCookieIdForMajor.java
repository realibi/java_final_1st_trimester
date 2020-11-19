package AbstractClasses;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieIdForMajor {

    public Integer GetIdCookie(HttpServletRequest request, HttpServletResponse response){

        int Club_id = 0;

        Cookie[] cookies = request.getCookies();
        String cookieName = "Club_id";
        Cookie cookie = null;
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    Club_id = Integer.parseInt(c.getValue());
                    break;
                }
            }
        }

        return Club_id;
    }

    public void MakeZero(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        String cookieName = "Club_id";
        Cookie cookie = null;
        if(cookies !=null) {
            for(Cookie c: cookies) {
                if(cookieName.equals(c.getName())) {
                    c.setValue("0");
                    response.addCookie(c);
                    c.setMaxAge(-1);
                }else{Cookie cookieId = new Cookie("Club_id", "0");
                    response.addCookie(cookieId);
                    cookieId.setMaxAge(-1);
                }
            }
        }


    }

}
