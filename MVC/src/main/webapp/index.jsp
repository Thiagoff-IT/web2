
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.example.mvc.web2.ConfigBean"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous"
        >
        <link rel="stylesheet" href="main.css">
    </head>
    <body class="d-flex flex-column min-vh-100">
        <div class="container">
            <div class="login">
                <h1>Login</h1>
                <br>
                <form action="./login">
                    <%--@declare id="login"--%><%--@declare id="senha"--%><label for="login">Login</label><br>
                    <input type="text" class="form-control" name="login" value="Login"><br>
                    <label for="senha">Senha</label><br>
                    <input type="password" class="form-control" name="senha" value="1234"><br>
                    <br>
                    <input type="submit" class="form-control" value="Confirmar">

                </form>
                 <p class="text-danger">${msg}</p>
            </div>

        </div>
        <footer class="mt-auto">
            Em caso de problemas contactar o administrador:${admin.emailAdm}
        </footer>
    </body>
</html>

