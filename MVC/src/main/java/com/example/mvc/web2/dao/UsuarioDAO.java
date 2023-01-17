package com.example.mvc.web2.dao;

import com.example.mvc.web2.beans.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.mvc.web2.beans.Usuario;



public class UsuarioDAO implements IUsuarioDAO{

    private static final String USUARIO_INSERT = "insert into tb_usuario(login_usuario, nome_usuario ,senha_usuario) value (?, ?, ?)";
    private static final String USUARIO_SELECT_LOGIN = "select id_usuario, login_usuario, nome_usuario ,senha_usuario from tb_usuario where login_usuario=? AND senha_usuario=?";
    private static final String USUARIO_SELECT_ALL = "select id_usuario, login_usuario, nome_usuario ,senha_usuario from tb_usuario";
    private static final String USUARIO_UPDATE = "UPDATE tb_usuario SET login_usuario = ?, senha_usuario = ?, nome_usuario = ? WHERE id_usuario = ?";
    private static final String USUARIO_DELETE = "DELETE FROM tb_usuario WHERE id_usuario = ?";
    
    @Override
    public void insert(Usuario fc) throws Exception{
        PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(USUARIO_INSERT);
            consulta.setString(1, fc.getLogin());
            consulta.setString(2, fc.getNome());  
            consulta.setString(3, fc.getSenha());

            consulta.execute();
        } catch (SQLException e) {
            throw new Exception("ERRO NO INSERT DE USUARIO. " + e.getMessage());
        } finally {
            ConnectionFactory.desconectar();
        }
    }
    
    @Override
    public ArrayList<Usuario> selectByLoginSenha(String login, String senha)throws Exception {
            PreparedStatement consulta = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<>();
         
        try {
            consulta = ConnectionFactory.conectar().prepareStatement(USUARIO_SELECT_LOGIN);
            consulta.setString(1, login);
            consulta.setString(2, senha);
            rs = consulta.executeQuery();

            while(rs.next()){
                Usuario fc = new Usuario();
                fc.setId(rs.getInt("id_usuario"));
                fc.setLogin(rs.getString("login_usuario"));
                fc.setNome(rs.getString("nome_usuario"));
                fc.setSenha(rs.getString("senha_usuario"));
                
                lista.add(fc);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO NO SELECT DE USUARIO POR ID." + e.getMessage());
        }finally{
            ConnectionFactory.desconectar();
        }
        
        return lista; 
    }

    @Override
    public ArrayList<Usuario> selectAllUsuario()throws Exception {
        PreparedStatement consulta = null;
        ResultSet rs = null;
        ArrayList<Usuario> lista = new ArrayList<>();
         
        try {
            consulta = ConnectionFactory.conectar().prepareStatement(USUARIO_SELECT_ALL);
            rs = consulta.executeQuery();

            while(rs.next()){
                Usuario fc = new Usuario();
                fc.setId(rs.getInt("id_usuario"));
                fc.setLogin(rs.getString("login_usuario"));
                fc.setNome(rs.getString("nome_usuario"));
                fc.setSenha(rs.getString("senha_usuario"));
                
                lista.add(fc);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO NO SELECT DE USUARIO. " + e.getMessage());
        }finally{
            ConnectionFactory.desconectar();
        }
        
        return lista; 
    }

    @Override
    public void update(Usuario fc) throws Exception {
        PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(USUARIO_UPDATE);
            
            consulta.setString(1, fc.getLogin());
            consulta.setString(2, fc.getSenha());
            consulta.setString(3, fc.getNome());
            consulta.setInt(4, fc.getId());
            

            consulta.execute();
        } catch (SQLException e) {
            throw new Exception("ERRO NO UPDATE DO USUARIO." + e.getMessage());
        } finally {
            ConnectionFactory.desconectar();
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
    PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(USUARIO_DELETE);
            consulta.setInt(1, id);

            consulta.execute();
        } catch (SQLException e) {
            throw new Exception("ERRO NO DELETE DO USUARIO. " + e.getMessage());
        } finally {
            ConnectionFactory.desconectar();
        }    
    }

    
    
}
