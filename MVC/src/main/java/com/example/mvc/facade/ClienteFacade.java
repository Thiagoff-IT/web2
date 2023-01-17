
package com.example.mvc.facade;

import com.example.mvc.web2.beans.Cliente;
import com.example.mvc.web2.dao.ClienteDAO;

import java.util.ArrayList;
public class ClienteFacade {
  
    public static void inserir(Cliente c) throws Exception{
        try {
            new ClienteDAO().insert(c);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public static void alterar(Cliente c) throws Exception{
        try {
            new ClienteDAO().update(c);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    } 
    
    public static Cliente buscar(Integer id) throws Exception{
        try {
           return new ClienteDAO().selectById(id).get(0);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public static ArrayList<Cliente> buscarTodos() throws Exception{
        try{
           return new ClienteDAO().selectAll();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void remover(Integer id) throws Exception {
        try {
            new ClienteDAO().delete(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
