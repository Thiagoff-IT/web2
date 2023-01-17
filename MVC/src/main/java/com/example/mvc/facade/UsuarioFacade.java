/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mvc.facade;

import com.example.mvc.web2.beans.Usuario;
import com.example.mvc.web2.dao.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class UsuarioFacade {
    
    public static void inserir(Usuario us) throws Exception{
        try {
            new UsuarioDAO().insert(us);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public static void update(Usuario us) throws Exception{
        try {
            new UsuarioDAO().update(us);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public static void delete(Integer id) throws Exception{
        try {
            new UsuarioDAO().delete(id);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }   
    
    public static Usuario selectLogin(String us, String sen) throws Exception{
        try {
            ArrayList<Usuario> ls = new UsuarioDAO().selectByLoginSenha(us, sen);
            if(ls.isEmpty() || ls == null){return null;}
            return ls.get(0);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
    
    public static ArrayList<Usuario> selectAll() throws Exception{
        try {
            return new UsuarioDAO().selectAllUsuario();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
