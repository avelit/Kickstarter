<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<%@tag description="Simple Template" pageEncoding="UTF-8"%>

<%@attribute name="title"%>
<%@attribute name="head" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="content" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="bottom_scripts" fragment="true" %>
<html>
<head>
    <title>${title}</title>
    <jsp:invoke fragment="head"/>
</head>
<body>
<div id="wrapper">
    <jsp:invoke fragment="header"/>
    <div class="container">
        <%-- CONTENT --%>
            <jsp:invoke fragment="content"/>
        <%-- /CONTENT --%>
    </div>
    <jsp:invoke fragment="footer"/>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<jsp:invoke fragment="bottom_scripts"/>
</body>
</html>