<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("category_name")%></title>
    <%@include file='header.jsp' %>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/signin.css" rel="stylesheet">
</head>
<body>
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


<br>
Add project:
<%@include file='/jsp/adminpanel/admin_edit_project.jsp'%>

</body>
</html>
