<%-- 
    Document   : portal
    Created on : 27/11/2018, 00:12:15
    Author     : marc
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="beans.UserBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>Portal</title>
    </head>
    <body>
        <!--        <h1 class="text-center">Portal!</h1>
                <p>${requestScope}</p>
                <p>ID do Login: ${loginBean.ID}</p>
                <p>Login: ${loginBean.email}</p>
                <p>Nome: ${loginBean.nome}</p>-->

        <div class="alert alert-success" role="alert">
            <p class="text-center">Login efetuado com sucesso</p>
        </div>
        <br>
        <hr>
        <div class="card">
            <div class="card-header">
                <h1>Bem vind@ ${loginBean.nome}</h1>
            </div>
            <div class="card-body">
                <h5 class="card-title">Voce trabalha das:</h5>
                <p class="card-text">${loginBean.start} as: ${loginBean.end}</p>
                <button onclick="mostraAlterar()" class="btn btn-primary">Alterar</button>
            </div>
            <form class="form" action="alteraServlet" method="post">
                <div id="caixaDeAlterar" hidden="true" >
                    <p>Agora trabalho das: <input type="time" name="startTime" value="${loginBean.start}">
                        até as:   <input type="time" name="endTime"   value="${loginBean.end}">  
                    </p>
                    <input type="submit" class="btn btn-primary"></button>
                    
                </div>
            </form>
        </div>
        <p>  <a href="visualizaServlet"> Visualizar consultas agendadas </a></p>
        <p></p>
        <p><a href="sairServlet">Sair</a></p>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
     <script>
                    function mostraAlterar() {
                        var x = document.getElementById("caixaDeAlterar");
                        if (x.style.display === "none") {
                            x.style.display = "block";
                        } else {
                            x.style.display = "none";
                        }
                    }
    </script>
    </body>

   
</html>
