package AddModerators;

import FindStudent.ServletFindStudent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteModerator")
public class ServletDeleteModerator extends HttpServlet {
    DBAddModerators db = new DBAddModerators();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Delete = request.getParameter("delete");
        int Student_id =  db.SelectStudent_id(request.getParameter("Email"));
        if(Delete.equals("delete")){
        db.DeleteModerator(Student_id);
        db.ChangeStatusToUser(Student_id);}

        ServletFindStudent findStudent = new ServletFindStudent();
        findStudent.doPost(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
