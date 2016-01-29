<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Registration</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<c:url value="/resources/css/plugins/metisMenu/metisMenu.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<c:url value="/resources/css/sb-admin-2.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<c:url value="/resources/font-awesome-4.1.0/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">


    <!-- Bootstrap Core CSS -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-md-offset-2">
            <div class="panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Форма регистрации</h3>
                </div>
                <div class="panel-body">
    <div class="col-lg-12">
        <div class="panel panel-default">
        <s:form role="form" method="post" action="/registration" modelAttribute="user">
        <div class="form-group">
        <label>Логин</label>
            <form:input type="text" path="username" id="username" class="form-control" placeholder="Мега логин"/>
        </div>
        <div class="form-group">
            <label>Пароль</label>
            <form:input type="password" path="password" id="password" class="form-control" placeholder="Важный пароль"/>
        </div>

        <div class="form-group">
        <label>E-mail</label>
           <form:input type="text" path="e_mail" id="e_mail" class="form-control" placeholder="Ваш e-mail"/>
        </div>
        <div class="form-group">
                <label>Имя</label>
                <form:input type="text" path="name" id="name" class="form-control" placeholder="Ваше имя"/>
        </div>
            <div class="form-group">
                <label>Дата рождения</label>
                <div class='input-group date' id='datetimepicker1'>
                    <form:input type="date" path="date_birth" id="date_birth" class="form-control" placeholder="Когда родился"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </div>
            <div class="form-group">
                <label>Surname</label>
                <form:input type="text" path="surname" id="surname" class="form-control" placeholder="Ваша Фамилия"/>
            </div>
            <input type="submit" value="Зарегаться" class="btn btn-primary btn-sm"/>
        </s:form>
            </div>
        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="/resources/js/plugins/metisMenu/metisMenu.min.js"/>"></script>

<!-- Custom Theme JavaScript -->
<script src="<c:url value="/resources/js/sb-admin-2.js"/>"></script>
<script src="<c:url value="/resources/js/moment.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js"/>"></script>


<script type="text/javascript">
    $(function () {
        $('#date_birth').datetimepicker({
            format: 'DD-MM-YYYY'
        });
    });
</script>
</body>
</html>
