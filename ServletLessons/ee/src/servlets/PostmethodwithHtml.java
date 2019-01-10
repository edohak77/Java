package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/second")
public class PostmethodwithHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String one = req.getParameter("one");
        one = one == null ? "":one.replaceAll("<","&lt;").replaceAll(">","&gt;");
        String two = req.getParameter("two");
        two = two == null ? "":two.replaceAll("<","&lt;").replaceAll(">","&gt;");
        String html = "<html>" +
                            "<head></head>" +
                                    "<body>" +
                                        "one= " + one +
                                        "  two= " + two +
                                        "<form action='second' method='post'>"+
                                        "<input type='text' name='one'/>" +
                                        "<input type='text' name='two'/>" +
                                        "<input type='submit' name='submit'/>" +
                                        "</form>" +
                                    "</body>" +
                                "</html>";
        resp.getWriter().write(html);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}


