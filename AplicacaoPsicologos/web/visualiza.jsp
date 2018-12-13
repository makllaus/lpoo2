<%-- 
    Document   : Visualiza
    Created on : 27/11/2018, 14:20:43
    Author     : marc
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.CalendarioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Visualiza</title>
    </head>
    <body>
        <div class="card">
            <div class="card-header">
                CONSULTAS
            </div>
            <div class="card-body">
                <blockquote class="blockquote mb-0">
                    <table class="table table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th scope="col">Video</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">Pontuação</th>
                                <th scope="col">Hora de inicio</th>
                                <!--                <td>ID (Remover depois)</td>-->
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="evento" items="${lista}">
                                <tr>
                                    <td scope="row">${evento.video}</th>
                                    <td>${evento.description}</td>
                                    <td>${evento.score}</td>
                                    <td>${evento.start_time}</td>
                <!--                    <td>${evento.id}</td>-->
                                </tr>
                            </c:forEach>
                        </tbody>    
                    </table>
                    <footer class="blockquote-footer">As informações são alteradas em <cite title="Source Title">Tempo Real</cite></footer>
                </blockquote>
            </div>
        </div>






        <a href="portal.jsp"> Voltar</a>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
