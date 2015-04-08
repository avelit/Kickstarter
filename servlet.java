
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter pw = response.getWriter();
    pw.println("<B>projects</B>");
    pw.println("<table border=1>");
    pw.println(request.getContextPath());
    pw.println("</table>");
  }
}