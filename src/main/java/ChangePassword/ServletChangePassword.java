package ChangePassword;
import AbstractClasses.GetSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletChangePassword")
public class ServletChangePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String OldPassword = request.getParameter("OldPassword");
        String NewPassword = request.getParameter("NewPassword");
        String RepeatedPassword = request.getParameter("RepeatedPassword");

        GetSession getSession = new GetSession();
        DBChangePassword dbChangePassword = new DBChangePassword();

        int Id = getSession.GetIdSession(request,response);
        boolean checkingOldPassword = dbChangePassword.SelectPasswordAndEmail(Id, OldPassword);

        if(checkingOldPassword && NewPassword.equals(RepeatedPassword)){dbChangePassword.ChangePassword(Id, NewPassword);}

        request.getRequestDispatcher("General/ChangePassword.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
