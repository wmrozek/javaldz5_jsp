<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<%@ include file="head.jsp"%>
    <title>Potwierdzenie Rezerwacji</title>
    <script src="http://code.jquery.com/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<c:choose>
    <c:when test="${USERNAME eq null}">
        <%@ include file="navbar_not_logged.jsp" %>
    </c:when>
    <c:otherwise>
        <%@ include file="navbar_logged_user.jsp" %>
    </c:otherwise>
</c:choose>
<%@ include file="reserve_modal.jsp" %>


<form method="post" action="/makeReservation">

    <div class="container-fluid" id="loginContainer">
        <div class="input-group">
            <input id="userid" type="hidden" value="${Reservation.userId}">
            <input id="firstname" type="text" class="form-control" name="firstname" placeholder="${Reservation.userFirstName}" readonly>
            <input id="lastname" type="text" class="form-control" name="lastname" placeholder="${Reservation.userLastName}" readonly>
            <input id="email" type="text" class="form-control" name="email" placeholder="${Reservation.userEmail}" readonly>
        </div>

        <div class="input-group">
            <input id="title" type="text" class="form-control" name="title" placeholder="${Reservation.movieTitle}" readonly>
            <input id="description" type="text" class="form-control" name="description" placeholder="${Reservation.movieDescription}" readonly>
            <input id="year" type="text" class="form-control" name="description" placeholder="${Reservation.yearOfMovieProduction}" readonly>
        </div>

        <div class="input-group">
            Data:
            <input id="seancedate" type="text" class="form-control" name="loseancedategin" placeholder="${Reservation.seanceDataStart}" readonly>
            <input id="seancetime" type="text" class="form-control" name="seancetime" placeholder="${Reservation.seanceDataStartTime}" readonly>
            <input id="seanceprice" type="text" class="form-control" name="seanceprice" placeholder="${Reservation.seancePrice}" readonly>
        </div>
        <p>ILOSC:</p>
        <div class="input-group">
            <select name="category" class="form-control">
                <c:forEach var = "i" begin = "1" end = "10">
                    <option VALUE="i">
                            ${i}
                    </option>
                </c:forEach>
            </select>
        </div>

        <button id="loginbutton" type="submit">REZERWUJ</button>
    </div>
</form>

</body>
</html>
