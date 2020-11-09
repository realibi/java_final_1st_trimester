package ChangePassword;

import AbstractClasses.GetCookies;

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

        GetCookies gc = new GetCookies();
        DBChangePassword dbChangePassword = new DBChangePassword();

        String Email = gc.GetEmailCookies(request,response);
        boolean checkingOldPassword = dbChangePassword.SelectPasswordAndEmail(Email, OldPassword);

        if(checkingOldPassword && NewPassword.equals(RepeatedPassword)){dbChangePassword.ChangePassword(Email, NewPassword);}


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
