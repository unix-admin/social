<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 19.01.2016
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <p class="page-header">Отправить запрос?</p>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <input type="button" id="friendship" value="Подружиться" class="btn btn-primary btn-sm"/>
                <input type="button" onclick="history.back();" value="Назад"  class="btn btn-primary btn-sm" />
            </div>
        </div>
    </div>
</div>
<script>
    $(function(){
        $("#friendship").click(function(){
            $.get("/friendshiprequest/addrequest/user=${user.id}", function(data, status){
                if (status =="success") {
                    alert("Ваш запрос принят!");
                }
                else
                {
                    alert("Что-то пошло не так");
                }
                history.back();
            });
        });

    })
</script>
</body>
</html>
