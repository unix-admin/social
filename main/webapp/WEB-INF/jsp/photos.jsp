<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 22.01.2016
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-12">
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
                                data-target="#myModal">Загрузить фото</button>
                    </div>
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog modal-sm">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Загрузить фото</h4>
                                </div>
                                <div class="modal-body">
                                    <form method="post" action="/upload"  enctype="multipart/form-data">
                                        <input type="file" name="file" id="file" /><br/><br/>
                                        <input type="submit" value="Загрузить" class="btn btn-sm"/>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <c:forEach var="photo" items="${user.userPhotos}">
        <div class="col-lg-12">
            <div class="row">
                <img src="${photo.path}" width="200" height="200">
            </div>
        </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
