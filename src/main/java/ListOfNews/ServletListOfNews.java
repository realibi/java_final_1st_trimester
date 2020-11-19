package ListOfNews;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "ServletListOfNews")
public class ServletListOfNews extends HttpServlet {
    DBListOfNews dbListOfNews = new DBListOfNews();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Set<ListOfNews> SetList = new HashSet<>();
        int IdForNews = Integer.parseInt(request.getParameter("NEWS"));

        SetList = dbListOfNews.SelectAllNewsByClubs(IdForNews);
        request.setAttribute("ListOfNews", SetList);
        request.getRequestDispatcher("General/ListOfNews.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
