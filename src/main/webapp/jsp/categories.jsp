<%@ page import="ua.goit.gojava32.kickstarter.model.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page  %>
<html>
<head>
    <title>Discover Projects</title>
</head>
<body>

<%
  List<Category> categories = (List<Category>)request.getAttribute("categories");
  for(Category category: categories) {
%>

  <div class="category-container">
      <%= category.getName() %>
  </div>

<%
    }
%>

</body>
</html>
