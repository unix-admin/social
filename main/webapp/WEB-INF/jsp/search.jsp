<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 19.01.2016
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <s:form role="form" method="post" action="/search" modelAttribute="user">
                    <fieldset>
                        <div class="form-group">
                            <label>Поиск пользователей</label>
                            <form:input type="text" path="username" id="username" class="form-control" placeholder="Enter username"/>
                        </div>
                        <input name="submit" type="submit" class="btn btn-lg btn-success btn-block" value="Поиск"/>
                    </fieldset>
                </s:form>
            </div>
        </div>
    <c:forEach var="item" items="${users}">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-sm-4"><img src="/photo/${item.avatar}" width="50" height="50">
            </div>
            <a href="/user/id=${item.id}"> ${item.name} ${item.surname}</a>
        </div>
    </div>
    </c:forEach>


     </div>
</div>
</body>

