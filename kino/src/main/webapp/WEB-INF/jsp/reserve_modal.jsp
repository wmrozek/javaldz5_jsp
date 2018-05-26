<%--
  Created by IntelliJ IDEA.
  User: zaleski
  Date: 23.05.2018
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h2 class="modal-title" id="movieTitle"></h2>
                <h4 class="modal-title" id="movieStartDate"></h4>
                <h4 class="modal-title" id="movieStartTime"></h4>
            </div>
            <div class="modal-body">
                <p id="movieDescription"></p>
                <br>
                <br>
                <p>--------------------------------------</p>
                <p id="movieActors"></p>
            </div>
            <div class="modal-footer">
                <h4 id="moviePrice"></h4>

                <form action="/reservation" method="get">
                    <input type="hidden" name="seanceId" id="inputId" value="1"/>
                    <button class="btn btn-default" type="submit" id="loginbutton">Rezerwuj</button>
                </form>

                <button type="button" class="btn btn-default" data-dismiss="modal" >Zamknij</button>
            </div>
        </div>

    </div>
</div>
<script>
    $(document).ready(function(){
        $(".announce").click(function(){ // Click to only happen on announce links
            // $("#movieTitle").val($(this).data('title'));
            document.getElementById("movieTitle").innerHTML = $(this).data('title');
            document.getElementById("movieDescription").innerHTML = $(this).data('description');
            document.getElementById("movieActors").innerHTML = $(this).data('actors');
            document.getElementById("movieStartTime").innerHTML = "Godzina:" + $(this).data('start');
            document.getElementById("moviePrice").innerHTML = $(this).data('price')+ " zł";
            document.getElementById("movieStartDate").innerHTML = "Data: " + $(this).data('date');
            var x = document.getElementById("inputId");
            x.value = $(this).data('seanceid');
            // document.getElementById("loginbutton").setAttribute("value", $(this).data('seanceId').toString() );

            // (value="$(this).data('seanceId')));
            $('#myModal').modal('show');
        });
    });


</script>
