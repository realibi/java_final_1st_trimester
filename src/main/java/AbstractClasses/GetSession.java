package AbstractClasses;

import javax.servlet.http.*;
import java.util.Enumeration;

public class GetSession{

    public Integer GetIdSession(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();

        Integer Id = (Integer) session.getAttribute("Id");

        return Id;

    }

}
