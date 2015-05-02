<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("category_name")%></title>
	<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="wrapper">
<%@include file='header.jsp' %>
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
</div>
<%@include file='footer.jsp' %>
</body>
</html>
