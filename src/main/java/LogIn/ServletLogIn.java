package LogIn;

import AbstractClasses.GetSession;
import ListOfClubs.ServletListOfClubs;
import LogIn.DBLogIn;
import MajorAdmin.ServletListOfClubsForMajor;

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
            Integer Id = logIn.SelectId(Email, Password);
            Integer MajorsId = logIn.SelectIdForMajorAdmin(Email, Password);
            ServletListOfClubs servletListOfClubs = new ServletListOfClubs();

            boolean checking = logIn.SelectPasswordAndEmail(Email, Password);
            boolean checkingAdmin = logIn.CheckingForMajorAdmin(Email, Password);

            if (checking) {

                HttpSession session = request.getSession();
                session.setAttribute("Id", Id);
                session.setMaxInactiveInterval(-1);

                String StatusChecking = logIn.CheckingStatus(Email);

                switch (StatusChecking) {
                    case ("User"):
                        servletListOfClubs.doPost(request, response);
                        break;

                    case ("Admin"):
                        servletListOfClubs.doPost(request, response);
                        break;

                    case ("Moderator"):
                        servletListOfClubs.doPost(request, response);
                        break;
                }

            } else if (checkingAdmin) {
                HttpSession session = request.getSession();
                session.setAttribute("Id", MajorsId);
                session.setMaxInactiveInterval(-1);

                ServletListOfClubsForMajor ser = new ServletListOfClubsForMajor();
                ser.doPost(request, response);
            }
            else {

                request.getRequestDispatcher("General/LogIn.jsp").forward(request, response);

            }


        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
