<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.sda.kino.project.dto.ErrorMessages" %>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Your file css -->
    <link rel="stylesheet" href="css/cinema_style.css"/>

    <title>Zmiana Hasła</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index"><span class="cinema_name">(super nazwa)</span></a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Strona Główna</a></li>
            <li><a href="repertuar.html">Repertuar</a></li>
            <li><a href="kontakt.html">Kontakt</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Zarejestruj się</a></li>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
        </ul>
    </div>
</nav>

<h1 align="center">Zmiana Hasła</h1>
<c:if test="${errorMessage ne null}">
    <c:choose>
        <c:when test="${errorMessage eq ErrorMessages.VALIDATION_ERROR}">
            <span>Hasła nie są identyczne.</span>
        </c:when>
        <c:otherwise>
            <span>Wystąpił nieoczekiwany błąd</span>
        </c:otherwise>
    </c:choose>
</c:if>
<form name="changeForm" method="post" action="/change_password">

    <div class="container-fluid" id="loginContainer">
        <div class="input-group">
            <input id="password1" type="password" class="form-control" name="oldPassword" placeholder="Stare hasło">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        </div>
        <div class="input-group">
            <input id="password2" type="password" class="form-control" name="newPassword" placeholder="Wprowadź nowe hasło">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        </div>
        <div class="input-group">
            <input id="password3" type="password" class="form-control" name="repeatedNewPassword" placeholder="Powtórz nowe hasło.">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
        </div>
        <button id="changebutton" type="submit">Zmień hasło</button>
    </div>
</form>
</body>
</html>