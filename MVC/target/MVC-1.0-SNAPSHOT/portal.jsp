

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="com.example.mvc.web2.beans.LoginBean,
                com.example.mvc.web2.beans.Usuario,
                java.util.ArrayList,
                com.example.mvc.web2.dao.UsuarioDAO,
                com.example.mvc.web2.beans.ConfigBean
"%>
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
    <body class="d-flex flex-column min-vh-100">
        <nav class="navbar navbar-light bg-light">
            <a class="nav-item nav-link text-success" href="ClientesServlet">Cadastro de Clientes</a>
            <a class="nav-item nav-link text-danger" href="LogoutServerlet">Sair</a>
        </nav>
        
        
        
        <div class="container">
            <div class="login">
                <h1>Portal Serverlet</h1>
                <br>
                <h3>Bem Vindo! 
                <jsp:useBean id="bean1" scope="session" class="com.example.mvc.web2.beans.LoginBean" />
                <jsp:setProperty name="bean1" property="nome" value="${login.getNome()}"/>
                <jsp:getProperty name="bean1" property="nome" />
                </h3>
                <br>
                <br><a href="inserir.jsp">Página Inserir Usuario</a>
                <br><br>
                <table class="table">
                    <tr>
                        <th scope="col"> Nome</th>
                        <th scope="col"> Login</th>
                        <th scope="col"> Senha</th>
                    </tr>
                    <c:forEach var="item" items="${lista}">
                        <tr>
                            <td>${item.getNome()}</td>
                            <td>${item.getLogin()}</td>
                            <td>${item.getSenha()}</td>
                        </tr>            
                    </c:forEach>
                </table>
            </div>
        </div>

    </body>
</html>
