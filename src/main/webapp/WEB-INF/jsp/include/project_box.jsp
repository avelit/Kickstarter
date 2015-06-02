<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-3">
    <div class="thumbnail">
        <div class="box">
            <div class="box-gray aligncenter">
                <h4>
                    <a href="/project/${project.id}">${project.name}</a>
                </h4>
                <div class="icon">
                      <img src="/image/${project.id}" alt="projet_image" width="100%" height="100%"/>
                </div>
                <p>
                    <a href="/project/${project.id}"> ${project.name}</a>
                </p>
            </div>
            <div class="box-bottom">
                <a href="/project/${project.id}">Go</a>
            </div>
        </div>
    </div>
</div>