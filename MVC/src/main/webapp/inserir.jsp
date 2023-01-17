<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.mvc.web2.beans.LoginBean, com.example.mvc.web2.beans.Usuario, java.util.ArrayList"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<c:if test="${empty login}">
    <c:set var="msg" value="Você não está logado" scope="request" />
    <c:set var="page" value="index.jsp" scope="request" />
    <jsp:forward page="index.jsp" />
</c:if>

<html>
    <head>
        <title>Cadastro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="main.css">
    </head>
    <body>
        <div class="container">
            <div class="login">
                <h1>Cadastrar</h1>
                <br>
                <form action="./CadastrarServerlet">
                    <%--@declare id="login"--%><%--@declare id="senha"--%><label for="login">Login</label><br>
                    <input type="text" class="form-control" name="login" placeholder="Login" minlength="1"><br>

                    <label for="login">Nome</label><br>
                    <input type="text" class="form-control" name="nome" placeholder="Nome" minlength="1"><br>

                    <label for="senha">Senha</label><br>
                    <input type="password" class="form-control" name="senha" placeholder="1234" minlength="1"><br>
                    <br>
                    <input type="submit" class="form-control btn-warning" value="Cadastrar">
                    <br><br>
                    </table>
                </form> 
                <a class="btn btn-lg active btn-danger" btn btn-lg active btn-dangerhref="./home" role="button" aria-pressed="true">Cancelar</a>
            </div>
        </div>
    </body>
</html>
