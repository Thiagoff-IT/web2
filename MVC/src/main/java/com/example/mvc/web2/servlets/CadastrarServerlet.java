package com.example.mvc.web2.servlets;

import com.example.mvc.facade.UsuarioFacade;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.example.mvc.web2.beans.LoginBean;
import com.example.mvc.web2.beans.Usuario;


@WebServlet(urlPatterns = {"/CadastrarServerlet"})
public class CadastrarServerlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(true);
        LoginBean usua = null;
        usua = (LoginBean) session.getAttribute("login");
        if (usua == null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Você não está logado");
            request.setAttribute("page", "index.html");
            rd.forward(request, response);
            return;
        }
        
        String usu = request.getParameter("login");
        String nom = request.getParameter("nome");
        String sen = request.getParameter("senha");
        
        try {
            UsuarioFacade.inserir(new Usuario(nom, usu, sen));
        
            response.sendRedirect("http://" + request.getServerName() + ":" + request.getServerPort()
                    + request.getContextPath() + "/home");              
        } catch (Exception ex) {
            request.setAttribute("msg", ex);
            request.setAttribute("page", "home");
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
