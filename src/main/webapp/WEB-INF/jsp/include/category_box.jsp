<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3">
    <div class="thumbnail">
        <div class="box">
            <div class="box-gray aligncenter">
                <h4>
                    <a href="/category/<c:out value="${c.id}"/>"><c:out value="${c.shortName}"/></a>
                </h4>

                <div class="icon">
                    <i class="fa fa-desktop fa-3x"></i>
                </div>
                <p>
                    <a href="/category/<c:out value="${c.id}"/>"><c:out value="${c.shortDescription}"/></a>
                </p>
            </div>
            <div class="box-bottom">
                <a href="/category/${c.id}">Go</a>
            </div>
        </div>
    </div>
</div>