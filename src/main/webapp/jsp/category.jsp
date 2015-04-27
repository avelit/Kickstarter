<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("category_name")%></title>
    <%@include file='header.jsp' %>
	<link href="/css/signin.css" rel="stylesheet">
	<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

<h3>Category: <c:out value="${category_name}"/>
<br>
Description: <c:out value="${category_description}"/>
</h3>
	<div class="row">
		<c:forEach var="c" items="${projects}">
			<div class="col-md-2">
				<div class="thumbnail">
					<a href="#">
						<div class="caption">
							<h3>
								<a href="/categories/<c:out value="${category_name}"/>/<c:out value="${c.name}"/>"><c:out value="${c.name}" /></a>
							</h3>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<h1>Add project:</h1>
			<hr>
			<div class="add_project">
				<form name="add_project" action="/categories/addProject" method="post">
					<h4>Project name:</h4>

					<input type="hidden" name="category_id" value="<c:out value="${category.id}"/>">
					<input type="text" name="project_name" class="form-control" id="project_name" placeholder="Name"
						   width="30%">
					<h4>Description:</h4>
					<input type="text" name="project_description" class="form-control" id="description"
						   placeholder="Description" width="30%">
					<br>
					<input type="submit" class="btn btn-success">
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
