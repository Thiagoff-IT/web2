<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.mvc.web2.beans.ConfigBean,
                com.example.mvc.web2.beans.Usuario,
                java.util.ArrayList,
                com.example.mvc.web2.beans.Cliente
"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Erro</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">          
    </head>
    <body class="d-flex flex-column min-vh-100">
        <div class="m-auto" style="width: 50%">            

            <h1 class="text-danger">Mensagem: ${msg}</h1>
            <a style="font-size: 1.5rem" href="./${page}">Link: ${page}</a>

        </div>
    </body>
</html>