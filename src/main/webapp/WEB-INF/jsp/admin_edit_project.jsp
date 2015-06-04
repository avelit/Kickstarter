<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
  <title>Empty</title>
  <%@include file='include/head.jsp' %>

    <%--TinyMCE--%>
    <script type="text/javascript" src="/resource/js/tinymce/tinymce.min.js"></script>
    <script type="text/javascript">
        tinymce.init({
            selector: "textarea",
            theme: "modern",
            plugins: [
                "advlist autolink lists link image charmap print preview hr anchor pagebreak",
                "searchreplace wordcount visualblocks visualchars code fullscreen",
                "insertdatetime media nonbreaking save table contextmenu directionality",
                "emoticons template paste textcolor colorpicker textpattern"
            ],
            toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
            toolbar2: "print preview media | forecolor backcolor emoticons",
            image_advtab: true,
            templates: [
                {title: 'Test template 1', content: 'Test 1'},
                {title: 'Test template 2', content: 'Test 2'}
            ]
        });
    </script>
    <%--/TinyMCE--%>

</head>
<body>
<div id="wrapper">
  <%@include file='include/header.jsp' %>
    <div class="container">
      <%-- CONTENT --%>
          <div class="row">
              <div class="col-sm-6">
                  <c:choose>
                  <c:when test="${project == null}">
                  <h1>Add project:</h1>
                  <hr>
                  <form name="add_project" action="/project/add" method="post" enctype="multipart/form-data">
                      <h4>Category:</h4>
                      <select name="category_id" class="form-control">
                          <c:forEach var="category" items="${categories}">
                              <option value="<c:out value="${category.id}"/>">
                                  <c:out value="${category.name}"/></option>
                          </c:forEach>
                      </select>

                      <h4>Project name: </h4>
                      <input type="text" name="project_name" class="form-control"
                             placeholder="Name" width="30%" required>

                      <h4>Description:</h4>
                      <input type="text" name="project_description"
                             class="form-control" placeholder="Description"
                             width="30%">

                      <h4>Picture:</h4>
                      <input type="file" name="file">

                      <h4>Video:</h4>
                      <input type="text" name="video_url"
                             class="form-control" placeholder="Link to video"
                             width="30%">
                      </c:when>
                      <c:otherwise>
                      <h1>Edit project: ${project.name}, id: ${project.id}</h1>
                      <hr>
                      <form name="edit_project" action="/project/edit"
                            method="post" enctype="multipart/form-data">
                          <input type="hidden" name="project_id"
                                 value="<c:out value="${project.id}" />">
                          <h4>Category:</h4>
                          <select name="category_id" class="form-control">
                              <option value="<c:out value="${project.category.id}" />">
                                  <c:out value="${project.category.name}"/></option>
                              <c:forEach var="category" items="${categories}">
                                  <c:if test="${category.id != project.category.id}">
                                      <option value="<c:out value="${category.id}" />">
                                          <c:out value="${category.name}"/></option>
                                  </c:if>
                              </c:forEach>
                          </select>
                          <h4>Project name: </h4>
                          <input type="text" name="project_name"
                                 class="form-control"
                                 placeholder="Name" width="30%"
                                 value="<c:out value="${project.name}"/>" required>
                          <h4>Description:</h4>

                          <%--<input type="text" name="project_description"--%>
                                 <%--class="form-control" placeholder="Description"--%>
                                 <%--width="30%"--%>
                                 <%--value="${project.description}">--%>


                              <textarea name="project_description">${project.description}</textarea>


                          <h4>Picture:</h4>
                          <input type="file" name="file">
                          <h4>Video:</h4>
                          <input type="text" name="video_url"
                                 class="form-control" placeholder="Link to video"
                                 width="30%"
                                 value="<c:out value="${project.video}"/>">
                          </c:otherwise>
                          </c:choose>
                          <br>
                          <input type="submit" class="btn btn-success"
                                 value="Submit">
                      </form>
              </div>
          </div>
      <%-- /CONTENT --%>
    </div>
<%@include file='include/footer.jsp' %>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
 <%@include file='include/bottom_scripts.jsp' %>
 </body>
</html>