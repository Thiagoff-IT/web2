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
        <div class="container">
            <div class="login">
                <h1>Ver Cliente</h1>
                <br>
                <button type="button" class="btn btn-link"><a href="./ClientesServlet">Voltar</a></button>
                <br>
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
                        
                    </tr>
                    <tr>
                        <td>${cl.getId()}</td>
                        <td>${cl.getCpf()}</td>
                        <td>${cl.getNome()}</td>
                        <td>${cl.getEmail()}</td>
                        <td>${cl.getData()}</td>
                        <td>${cl.getRua()}</td>
                        <td>${cl.getNr()}</td>
                        <td>${cl.getCep()}</td>
                        <td>${cl.getCidade()}</td>
                        <td>${cl.getUf()}</td>
                    </tr>
                </table>
            </div>
        </div>       
        <footer class="mt-auto">
            Em caso de problemas contactar o administrador:${admin.emailAdm}
        </footer>
    </body>
</html>


