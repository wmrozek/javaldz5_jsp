<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Your file css -->
    <link rel="stylesheet" href="css/cinema_style.css" />
    <title>Kino Prosiaczek</title>
</head>
<body>
<c:choose>
    <c:when test="${USERNAME eq null}">
        <%@ include file="navbar_not_logged.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="navbar_logged_user.jsp" %>
    </c:otherwise>
</c:choose>

<!--główny kontener tresci-->
<div class="container-fluid">
    <div class="jumbotron banner">
        <h1>Witaj w kinie <span class="cinema_name">(super nazwa)</span></h1>
        <p>projekt SDA, polskie literki: żźłóąęść</p>
    </div>


    <p>This is some text.</p>
    <p>This is another text.</p>




</div>


</body>
</html>