<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-4"><img src="/photo/${user.avatar}" width="200" height="200">
            </div>
            <div class="col-sm-8">
                <p>Имя:${user.name}</p>
                <p>Фамилия:${user.surname}</p>
                <p>Дата Рождения: ${dateBirth} </p>
                <p>E-mail:${user.e_mail}</p>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                        data-target="#myModal">Загрузить фото</button>
            </div>
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog modal-sm">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Загрузить фото</h4>
                        </div>
                        <div class="modal-body">
                            <c:forEach var="post" items="${user.userWall}">
                                <div class="row">
                                    <div class="col-lg-12 alert alert-info">
                                        <c:if test="${user.id == loggeduserId}">
                                            <a type="button" class="close" href="/post/delete/${post.id}">×</a>
                                        </c:if>

                                        <p><c:out value="${post.message_text}"/></p>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                        </div>
                    </div>

                </div>
            </div>
            <div>
            <div class="row">
            <div class="col-lg-12">
                <p class="page-header">Мои личные записи</p>
            </div>
        <div>
            <div class="col-lg-12">
                <c:if test="${user.id == loggeduserId}">
                <div class="panel panel-default">
                    <s:form role="form" method="post" action="/post/new" modelAttribute="posts">
                    <div class="form-group">
                        <label>Новая запись</label>
                        <form:input type="text" path="message_text" id="message_text" class="form-control" placeholder="Ваша умная мысля :)"/>
                    </div>
                        <input type="submit" value="Запостить" class="btn btn-primary btn-sm"/>
                </s:form>
                </div>
                    </c:if>
                    <c:forEach var="post" items="${user.userWall}">
                <div class="row">
                    <div class="col-lg-12 alert alert-info">
                        <c:if test="${user.id == loggeduserId}">
                            <a type="button" class="close" href="/post/delete/${post.id}">×</a>
                        </c:if>

                    <p><c:out value="${post.message_text}"/></p>
                </div>
            </div>
            </c:forEach>

        <script type="text/javascript">
            function confirm_click()
            {
                return confirm("Are you sure ?");
            }

        </script>
    </div>
</div>
</div>
</body>