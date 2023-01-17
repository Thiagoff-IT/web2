<%--
    Author  : Thiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page import="com.example.mvc.web2.beans.LoginBean, com.example.mvc.web2.beans.Cliente, java.util.ArrayList, com.example.mvc.web2.dao.UsuarioDAO, com.example.mvc.web2.beans.ConfigBean"%>
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
        <link rel="stylesheet" href="main.css">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <nav class="navbar navbar-light bg-light">
            <a class="nav-item nav-link text-success" href="./home">Portal</a>
            <a class="nav-item nav-link text-danger" href="./LogoutServerlet">Sair</a>
        </nav>
        
        <div class="container">
            <div class="login">
                <h1>Listar Cliente</h1>
                <br>
                <h3>
                <jsp:useBean id="bean1" scope="session" class="com.ufpr.tads.web2.beans.LoginBean" />
                <jsp:setProperty name="bean1" property="nome" value="${login.getNome()}"/>
                <jsp:getProperty name="bean1" property="nome" />
                </h3>
                <br>
                <a class="btn btn-lg active btn-info" href="./ClientesServlet?action=formNew">Novo</a>
                <br><br>
                <table class="table">
                    <tr>
                        <th scope="col"> ID</th>
                        <th scope="col"> CPF</th>
                        <th scope="col"> NOME</th>
                        <th scope="col"> EMAIL</th>
                        <th scope="col"> DATA</th>
                        <th scope="col"> RUA</th>
                        <th scope="col"> NR</th><!-- comment -->
                        <th scope="col"> CEP</th><!-- comment -->
                        <th scope="col"> CIDADE</th>
                        <th scope="col"> UF</th>
                        <th scope="col"> Ver</th>
                        <th scope="col"> Editar</th>
                        <th scope="col"> Remover</th>
                        
                    </tr>
                    <c:forEach var="item" items="${lista}">
                        <tr>
                            <td>${item.getId()}</td>
                            <td>${item.getCpf()}</td>
                            <td>${item.getNome()}</td>
                            <td>${item.getEmail()}</td>
                            <td>${item.getDataStringBrFormat()}</td>
                            <td>${item.getRua()}</td>
                            <td>${item.getNr()}</td>
                            <td>${item.getCep()}</td>
                            <td>${item.getCidade()}</td>
                            <td>${item.getUf()}</td>                           
                            <td><a href="./ClientesServlet?action=show&id=${item.getId()}"><i class="fa-solid fa-eye"></i></a></td>
                            <td><a href="./ClientesServlet?action=formUpdate&id=${item.getId()}"><i class="fa-solid fa-pen"></i></a></td>
                            <td><a href="./ClientesServlet?action=remove&id=${item.getId()}"><i class="fa-solid fa-x"></i></a></td>
                        </tr>  
                    </c:forEach>
                </table>
            </div>
        </div>
        
        <footer class="mt-auto">
            Em caso de problemas contactar o administrador:${admin.emailAdm}
        </footer>
    </body>
</html>

