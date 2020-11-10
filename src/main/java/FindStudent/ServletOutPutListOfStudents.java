package FindStudent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletOutPutListOfStudents")
public class ServletOutPutListOfStudents extends HttpServlet {
    DBFindStudent db = new DBFindStudent();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String SelectMajors = request.getParameter("SelectMajors");
        String SelectGroups = request.getParameter("SelectGroups");
        String SelectYear = request.getParameter("SelectYear");
        String Search = request.getParameter("searchUser");


        ArrayList<FindStudent> KeyList;
        if(Search != null) {
            String SearchUser = Search.trim();

            String FirstWord = "";
            String SecondWord = "";

            for (int i = 0; i < SearchUser.length(); i++) {
                if (SearchUser.charAt(i) == ' ') {

                    for (int c = 0; c < i; c++) {
                        FirstWord += SearchUser.charAt(c);
                    }

                    if (SearchUser.charAt(i + 1) != ' ') {

                        for (int v = i + 1; v < SearchUser.length(); v++) {

                            SecondWord += SearchUser.charAt(v);

                        }

                    }
                    break;

                }
            }


            if (!SearchUser.contains(" ") && !SearchUser.contains("@")) {
                ArrayList<FindStudent> findStudentsByNameOrSurname = db.FindStudentByNameOrSurname(SearchUser);
                request.setAttribute("key", findStudentsByNameOrSurname);
            }

            if (SearchUser.contains("@")) {
                ArrayList<FindStudent> findStudentsByEmail = db.FindStudentByEmail(SearchUser);
                request.setAttribute("key", findStudentsByEmail);
            }

            if (SearchUser.contains(" ")) {

                ArrayList<FindStudent> findStudentsByNameAndSurname = db.FindStudentByNameAndSurname(FirstWord, SecondWord);
                ArrayList<FindStudent> findStudentsBySurnameAndName = db.FindStudentBySurnameAndName(FirstWord, SecondWord);

                if (findStudentsByNameAndSurname.size() != 0) {
                    request.setAttribute("key", findStudentsByNameAndSurname);
                } else {
                    request.setAttribute("key", findStudentsBySurnameAndName);
                }

            }
        }

        if(!SelectGroups.equals("Chose Group")){
            ArrayList<FindStudent> findStudentsByGroup =  db.FindStudentByGroup(SelectGroups);
            request.setAttribute("key", findStudentsByGroup);
        }
        else if (!SelectMajors.equals("Chose Major") && !SelectYear.equals("Chose Year")){
            ArrayList<FindStudent> findStudentsByMajorAndGroup =  db.FindStudentByMajorAndYear(SelectMajors, SelectYear);
            request.setAttribute("key", findStudentsByMajorAndGroup);
        }
        else if (!SelectMajors.equals("Chose Major")){
            ArrayList<FindStudent> findStudentsByMajor = db.FindStudentByMajor(SelectMajors);
            request.setAttribute("key", findStudentsByMajor);
        }
        else if (!SelectYear.equals("Chose Year")){
            ArrayList<FindStudent> findStudentsByYear = db.FindStudentByYear(SelectYear);
            request.setAttribute("key", findStudentsByYear);
        }
        ServletFindStudent sv = new ServletFindStudent();
        sv.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
