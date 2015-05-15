package ua.goit.gojava32.kickstarter.test;

import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpTest {
  @Ignore
  @Test
  public void durationWhenHttpRequest() {
    Logger logger = Logger.getLogger(this.getClass());
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpSession httpSession = mock(HttpSession.class);
    RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

    when(request.getMethod()).thenReturn("post");
    when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    when(request.getSession()).thenReturn(httpSession);
    when(request.getRequestURI()).thenReturn("localhost:8080/categories/Music");

//    try {
      for (int i = 0; i < 10; i++) {
        long startTime = System.currentTimeMillis();
        //new KickstarterServlet().doPost(request, response);
        logger.info("duration: " + i + " " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println("duration: " + i + " " + (System.currentTimeMillis() - startTime) + " ms.");
      }
//    } catch (ServletException e) {
//      e.printStackTrace();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
  }
}
