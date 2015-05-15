<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${category.name}"/></title>
	<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
<%@include file='header.jsp' %>
<div class="container">
<h3>
  Id: <c:out value="${category.id}"/>
  <br>
  Category: <c:out value="${category.name}"/>
  <br>
  Description: <c:out value="${category.description}"/>
</h3>
	<div class="row">
		<c:forEach var="c" items="${projects}">
			<div class="col-md-2">
				<div class="thumbnail">
					<a href="#">
						<div class="caption">
							<h3>
								<a href="/project/<c:out value="${c.id}"/>" ><c:out value="${c.name}" /></a>
							</h3>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
</div>
<%@include file='footer.jsp' %>
</body>
</html>
