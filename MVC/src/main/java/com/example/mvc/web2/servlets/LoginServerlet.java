package com.example.mvc.web2.servlets;

import com.example.mvc.facade.UsuarioFacade;
import com.example.mvc.web2.beans.LoginBean;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import com.example.mvc.web2.beans.Usuario;


@WebServlet(urlPatterns = {"/login", "/home"})
public class LoginServerlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usu = request.getParameter("login");
        String sen = request.getParameter("senha");
        
        
        
        try {
            LoginBean bean = new LoginBean();
            bean = (LoginBean) request.getSession().getAttribute("login");
            if (bean != null) {
                ArrayList<Usuario> lista = UsuarioFacade.selectAll();
                request.setAttribute("lista", lista);
                getServletContext().getRequestDispatcher("/portal.jsp").forward(request, response);
                return;
            }
            
            Usuario usuario = UsuarioFacade.selectLogin(usu, sen);
            if (usuario != null) {
                HttpSession session = request.getSession(true);
                
                LoginBean lb = new LoginBean();
                lb.setId(usuario.getId());
                lb.setNome(usuario.getNome());
                session.setAttribute("login", lb);
                
                ArrayList<Usuario> lista = UsuarioFacade.selectAll();
                request.setAttribute("lista", lista);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/portal.jsp");
                rd.forward(request, response);
            } else {
                request.setAttribute("msg", "Usuário/Senha inválidos");

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");

                rd.forward(request, response);
            }
        } catch (Exception ex) {
                request.setAttribute("msg", ex.getMessage());
                request.setAttribute("page", "login");

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/erro.jsp");
                rd.forward(request, response);
                return;
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
