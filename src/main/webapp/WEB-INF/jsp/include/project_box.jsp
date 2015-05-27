<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-3">
    <div class="thumbnail">
        <div class="box">
            <div class="box-gray aligncenter">
                <h4>
                    <a href="/project/<c:out value="${project.id}"/>"><c:out value="${project.name}"/></a>
                </h4>

                <div class="icon">
                    <c:choose>
                        <c:when test="${image == false}">
                        </c:when>
                        <c:otherwise>
                            <img src="/image/${project.id}" alt="projet_image"/>
                            <div><br></div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <p>
                    <a href="/project/<c:out value="${project.id}"/>"><c:out value="${project.name}"/></a>
                </p>
            </div>
            <div class="box-bottom">
                <a href="/project/<c:out value="${project.id}"/>">Go</a>
            </div>
        </div>
    </div>
</div>