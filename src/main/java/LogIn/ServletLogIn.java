package LogIn;

import LogIn.DBLogIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletLogIn")
public class ServletLogIn extends HttpServlet {
    DBLogIn logIn = new DBLogIn();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Email = request.getParameter("Student_Email");
        String Password = request.getParameter("Student_Password");
        HttpSession session = request.getSession();




        boolean checking = logIn.SelectPasswordAndEmail(Email, Password);
        boolean checkingAdmin = logIn.CheckingForMajorAdmin(Email, Password);

        if(checking) {


            Cookie cookieEmail = new Cookie("Email", Email);
            cookieEmail.setMaxAge(24 * 60 * 60);
            response.addCookie(cookieEmail);

            String StatusChecking = logIn.CheckingStatus(Email);

            switch (StatusChecking) {
                case ("User"):
                    request.getRequestDispatcher("User/User.jsp").forward(request, response);
                    break;

                case ("Admin"):
                    String ClubTitle = logIn.SelectClubTitle(Email);
                    Cookie cookieClubTitle = new Cookie("ClubTitle", ClubTitle);
                    cookieEmail.setMaxAge(24 * 60 * 60);
                    response.addCookie(cookieClubTitle);
                    request.getRequestDispatcher("Admin/Admin.jsp").forward(request, response);
                    break;

                case ("Moderator"):
                    request.getRequestDispatcher("Moderator/Moderator.jsp").forward(request, response);
                    break;
            }

        }

        else if(checkingAdmin){
            Cookie cookieEmail = new Cookie("Email", Email);
            cookieEmail.setMaxAge(24 * 60 * 60);
            response.addCookie(cookieEmail);

            request.getRequestDispatcher("MajorAdmin/MajorAdmin.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
