package com.example.mvc.web2.servlets;

import com.example.mvc.facade.ClienteFacade;
import com.example.mvc.util.ValidaCampo;
import com.example.mvc.web2.beans.Cliente;
import com.example.mvc.web2.beans.LoginBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/ClientesServlet"})
public class ClientesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LoginBean usu = new LoginBean();
        usu = (LoginBean) request.getSession().getAttribute("login");
        if(usu == null){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuario Deve se Autenticar para acessar o sistema");
            rd.forward(request, response);
            return;
        }
        
        String action = request.getParameter("action");

        try {

            if ("show".equals(action)) {
                Integer id = Integer.valueOf(request.getParameter("id"));
                Cliente cl = ClienteFacade.buscar(id);
                request.setAttribute("cl", cl);
                getServletContext().getRequestDispatcher("/clientesVisualizar.jsp").forward(request, response);
            } else if ("formUpdate".equals(action)) {
                Integer id = Integer.valueOf(request.getParameter("id"));
                Cliente cl = ClienteFacade.buscar(id);
                request.setAttribute("cl", cl);
                getServletContext().getRequestDispatcher("/clientesAlterar.jsp").forward(request, response);
            } else if ("remove".equals(action)) {
                Integer id = Integer.valueOf(request.getParameter("id"));
                ClienteFacade.remover(id);
            }else if ("formNew".equals(action)) {
                getServletContext().getRequestDispatcher("/clientesNovo.jsp").forward(request, response);
            } else if ("new".equals(action) || "update".equals(action)) {
                Cliente cl = new Cliente();
                Integer flag = 0;
                
                cl.setId(ValidaCampo.validaInteger(request.getParameter("id"), Integer.MAX_VALUE));
                if(cl.getId() == null && "update".equals(action)){throw new Exception("PARA EXECUTAR UPDATE ID DO CLIENTE NÃO PODE ESTAR NULO");}
                
                cl.setCpf(ValidaCampo.validaCpf(request.getParameter("cpf")));
                if(cl.getCpf() == null && "new".equals(action)){flag++; request.setAttribute("msgCpf", "CPF INVÁLIDO");}
                
                cl.setNome(ValidaCampo.validaString(request.getParameter("nome"), 3, 100));
                if(cl.getNome() == null){flag++; request.setAttribute("msgNome", "NOME INVÁLIDO");}
                
                cl.setEmail(request.getParameter("email"));
                if(cl.getEmail() == null){flag++; request.setAttribute("msgEmail", "EMAIL INVÁLIDO");}
                
                cl.setData(ValidaCampo.validaData(request.getParameter("data")).atStartOfDay());
                if(cl.getData() == null){flag++; request.setAttribute("msgData", "DATA INVÁLIDA");}
                
                cl.setRua(ValidaCampo.validaString(request.getParameter("rua"), 3, 100));
                if(cl.getRua() == null){flag++; request.setAttribute("msgRua", "DATA INVÁLIDA");}
                
                cl.setNr(ValidaCampo.validaInteger(request.getParameter("nr"), 6));
                if(cl.getNr() == null){flag++; request.setAttribute("msgNr", "NÚMERO INVÁLIDO");}
                
                cl.setCep(ValidaCampo.validaCep(request.getParameter("cep")));
                if(cl.getCep() == null){flag++; request.setAttribute("msgCep", "CEP INVÁLIDO");}
                
                cl.setCidade(ValidaCampo.validaString(request.getParameter("cidade"), 3, 100));
                if(cl.getCidade() == null){flag++; request.setAttribute("msgCidade", "CAMPO INVÁLIDO");}
                
                cl.setUf(ValidaCampo.validaString(request.getParameter("uf"), 2, 2));
                if(cl.getUf() == null){flag++; request.setAttribute("msgUf", "CAMPO INVÁLIDO");}
            
                if(flag > 0){
                    request.setAttribute("cl", cl);
                    if("update".equals(action)){   
                        getServletContext().getRequestDispatcher("/clientesAlterar.jsp").forward(request, response);
                    }else{
                        getServletContext().getRequestDispatcher("/clientesNovo.jsp").forward(request, response);
                    }
                }else{
                    if("update".equals(action)){
                        ClienteFacade.alterar(cl);
                    }else{
                        ClienteFacade.inserir(cl);
                    }
                    response.sendRedirect("http://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/ClientesServlet");
                    return;
                }
            }

            List<Cliente> lista = ClienteFacade.buscarTodos();
            request.setAttribute("lista", lista);
            getServletContext().getRequestDispatcher("/clienteListar.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("msg", ex);
            request.setAttribute("page", "/");
            getServletContext().getRequestDispatcher("/erro.jsp").forward(request, response);
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
