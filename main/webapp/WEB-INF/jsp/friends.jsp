<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

            <c:if test="${sessionScope.loggeduser.friendshipRequestCount > 0}">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="page-header">Запросы в друзья</p>
                    </div>
                </div>
                <c:forEach var="request" items="${sessionScope.loggeduser.friendshipRequests}">
                <div class="row">
                        <div class="col-lg-12">
                        <span>    <div class="col-sm-4"><img src="/photo/${request.fromUser.avatar}" width="50" height="50">
                            </div>

                            <a href="/user/id=${request.fromUser.id}"> ${request.fromUser.name} ${request.fromUser.surname}</a>
                            <a type="button" href="/friendshiprequest/accept/request=${request.id}"  class="btn btn-success glyphicon-ok btn-sm">Подружиться</a>
                            <a type="button" href="/friendshiprequest/reject/request=${request.id}"  class="btn btn-danger glyphicon-remove btn-sm">Отклонить</a>
                            </span>
                        </div>
                    </div>
                    </div>
                    </c:forEach>


            </c:if>

        <div class="row">
            <div class="col-lg-12">
                <p class="page-header">Мои Друзья</p>
            </div>
        </div>
    <c:forEach var="friend" items="${friends.friends}">
    <div class="row">
        <div class="col-lg-12">
            <div class="col-sm-4"><img src="/photo/${friend.user.avatar}" width="50" height="50">
            </div>
            <a href="/user/id=${friend.user.id}"> ${friend.user.name} ${friend.user.surname}</a>
            <a type="button" href="/friends/delete/user=${friend.user.id}"  class="btn btn-danger glyphicon-remove btn-sm">Прекратить дружбу</a>

        </div>
    </div>
    </c:forEach>


     </div>
</div>
</body>

