package ua.goit.gojava32.kickstarter.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class Request {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String uri;
    private String method;

    public Request(HttpServletRequest request, HttpServletResponse response) {
      this.request = request;
      this.response = response;
      this.uri = request.getRequestURI();
      this.method = request.getMethod();
    }

    public Request(String uri, String method) {
        this.uri = uri;
        this.method = method;
    }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Request request = (Request) o;
    return Objects.equals(uri, request.uri) &&
            Objects.equals(method, request.method);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uri, method);
  }

}
