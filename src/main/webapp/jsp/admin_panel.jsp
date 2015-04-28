<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <div class="col-sm-3">
      <h3>Admin menu</h3>
      <hr>
      <ul class="nav nav-stacked">
        <li><a href="/admin/edit_category"><h4>Edit category</h4></a> </li>
        <li><a href="/admin/edit_project"><h4>Edit project</h4></a> </li>
      </ul>
    </div>
<c:out value="${param.test}"/>
<jsp:include page="category.jsp">
    <jsp:param name="test" value="Guest Ltd." />
    </jsp:include>

