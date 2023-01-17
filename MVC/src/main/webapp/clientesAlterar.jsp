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
        <link rel="stylesheet" href="./main.css">
        <script src="./main.js" ></script>
    </head>
    <body>
        <div class="container">
            <div class="login">
                <h1>Alterar Cliente</h1>
                <br>
                <form action="./ClientesServlet?action=update" method="post">
                    <input style="display: none" type="hidden" name="id" value=${cl.getId()}>

                    <label for="login">Nome</label><br>
                    <input type="text" class="form-control" name="nome" placeholder="Nome" minlength="3" maxlength="100" value=${cl.getNome()}><br>
                    <p class="text-danger">${msgNome}</p><br><!-- comment -->

                    <label for="login">Email</label><br>
                    <input type="email" class="form-control" name="email" placeholder="Nome" minlength="3" maxlength="100" value=${cl.getEmail()}><br>                    
                    <p class="text-danger">${msgEmail}</p><br>

                    <label for="login">Data</label><br>
                    <input type="date" class="form-control" name="data" value=${cl.getDataString()}><br>
                    <p class="text-danger">${msgData}</p><br>

                    <label for="login">Rua</label><br>
                    <input type="text" class="form-control" name="rua" placeholder="Rua" minlength="3" maxlength="100" value=${cl.getRua()}><br>
                    <p class="text-danger">${msgRua}</p><br>

                    <label for="login">NR</label><br>
                    <input type="number" class="form-control" name="nr" placeholder="1" value=${cl.getNr()} ><br>
                    <p class="text-danger">${msgNr}</p><br>

                    <label for="login">CEP</label><br>
                    <input type="text" class="form-control" name="cep" value=${cl.getCep()}  placeholder="XXXXX-XXX" onkeypress="mascara(this, '#####-###')" maxlength="9" minlength="9"><br>  
                    <p class="text-danger">${msgCep}</p><br>

                    <label for="login">Cidade</label><br>
                    <input type="text" class="form-control" name="cidade" placeholder="Cidade" minlength="4" maxlength="100" value=${cl.getCidade()}><br>
                    <p class="text-danger">${msgCidade}</p><br>

                    <label for="login">UF</label><br>
                    <input type="text" class="form-control" name="uf" placeholder="Nome" minlength="2" maxlength="2" value=${cl.getUf()}><br> 
                    <p class="text-danger">${msgUf}</p><br>

                    <input type="submit" class="form-control btn btn-warning" value="Alterar">
                    <br><br>
                    </table>
                </form> 
                <a class="btn btn-lg active btn-danger" href="ClientesServlet" role="button" aria-pressed="true">Cancelar</a>
            </div>
        </div>
        <footer class="mt-auto">
            Em caso de problemas contactar o administrador:${admin.emailAdm}
        </footer>            
    </body>
    <script>
        function mascara(t, mask){
        
            var i = t.value.length;
            var saida = mask.substring(1,0);
            var texto = mask.substring(i);

            if (texto.substring(0,1) !== saida){
               t.value += texto.substring(0,1);
            }
         }
    </script>
</html>
