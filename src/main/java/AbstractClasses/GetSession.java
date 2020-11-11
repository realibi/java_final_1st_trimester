package AbstractClasses;

import javax.servlet.http.*;
import java.util.Enumeration;

public class GetSession{

    public Integer GetIdSession(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        Integer Id = 0;
        Id = (Integer) session.getAttribute("Id");

        return Id;

    }

}
