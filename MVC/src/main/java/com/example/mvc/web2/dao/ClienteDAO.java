
package com.example.mvc.web2.dao;

import com.example.mvc.web2.beans.Cliente;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO implements IClienteDAO{
    
    private final String CLIENTE_INSERT = "INSERT INTO tb_cliente(cpf_cliente,nome_cliente,email_cliente,data_cliente,rua_cliente,nr_cliente,cep_cliente,cidade_cliente,uf_cliente)VALUES(?,?,?,?,?,?,?,?,?)";
    private final String CLIENTE_UPDATE = "UPDATE tb_cliente SET nome_cliente = ?, email_cliente = ?, data_cliente = ?, rua_cliente = ?, nr_cliente = ?, cep_cliente = ?, cidade_cliente = ?, uf_cliente = ? WHERE id_cliente = ?";
    private final String CLIENTE_DELETE = "DELETE FROM tb_cliente WHERE id_cliente = ?";
    private final String CLIENTE_SELECT_ALL = "SELECT id_cliente, cpf_cliente,nome_cliente, email_cliente,data_cliente,rua_cliente,nr_cliente,cep_cliente,cidade_cliente,uf_cliente FROM tb_cliente";
    private final String CLIENTE_SELECT_BY_ID = "SELECT id_cliente, cpf_cliente,nome_cliente, email_cliente,data_cliente,rua_cliente,nr_cliente,cep_cliente,cidade_cliente,uf_cliente FROM tb_cliente WHERE id_cliente = ?";
    
    @Override
    public void insert(Cliente cl) throws Exception{
    PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(CLIENTE_INSERT);
            consulta.setString(1, cl.getCpf());
            consulta.setString(2, cl.getNome());
            consulta.setString(3, cl.getEmail());
            consulta.setDate(4, new Date(cl.getDataInMili()));
            consulta.setString(5, cl.getRua());
            consulta.setInt(6, cl.getNr());
            consulta.setString(7, cl.getCep());
            consulta.setString(8, cl.getCidade());
            consulta.setString(9, cl.getUf());

            consulta.execute();
        } catch (SQLException e) {
            System.err.println("ERRO NO INSERT DE CLIENTE. " + e.getMessage());
            throw new Exception();
        } finally {
            ConnectionFactory.desconectar();
        }
    }
    
    @Override
    public void update(Cliente cl) throws Exception{
    PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(CLIENTE_UPDATE);
            consulta.setString(1, cl.getNome());
            consulta.setString(2, cl.getEmail());
            consulta.setDate(3, new Date(cl.getDataInMili()));
            consulta.setString(4, cl.getRua());
            consulta.setInt(5, cl.getNr());
            consulta.setString(6, cl.getCep());
            consulta.setString(7, cl.getCidade());
            consulta.setString(8, cl.getUf());
            consulta.setInt(9, cl.getId());

            consulta.execute();
        } catch (SQLException e) {
            throw new Exception("ERRO NO UPDATE DO CLIENTE. " + e.getMessage());
        } finally {
            ConnectionFactory.desconectar();
        }
    }

    @Override
    public void delete(Integer id) throws Exception{
    PreparedStatement consulta;

        try {
            consulta = ConnectionFactory.conectar().prepareStatement(CLIENTE_DELETE);
            consulta.setInt(1, id);

            consulta.execute();
        } catch (SQLException e) {
            throw new Exception("ERRO NO DELETE DO CLIENTE. " + e.getMessage());
        } finally {
            ConnectionFactory.desconectar();
        }
    }

    @Override
    public ArrayList<Cliente> selectById(Integer id)throws Exception {
        PreparedStatement consulta = null;
        ResultSet rs = null;
        ArrayList<Cliente> lista = new ArrayList<>();
         
        try {
            consulta = ConnectionFactory.conectar().prepareStatement(CLIENTE_SELECT_BY_ID);
            consulta.setInt(1, id);
            rs = consulta.executeQuery();

            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id_cliente"));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome(rs.getString("nome_cliente"));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setDataFromSqlDate(rs.getDate("data_cliente"));
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNr(rs.getInt("nr_cliente"));
                cl.setCep(rs.getString("cep_cliente"));
                cl.setCidade(rs.getString("cidade_cliente"));
                cl.setUf(rs.getString("uf_cliente"));      
                
                lista.add(cl);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO NO SELECT DE USUARIO POR ID." + e.getMessage());
        }finally{
            ConnectionFactory.desconectar();
        }
        
        return lista; 
    } 
    
    @Override
    public ArrayList<Cliente> selectAll()throws Exception {
        PreparedStatement consulta = null;
        ResultSet rs = null;
        ArrayList<Cliente> lista = new ArrayList<>();
         
        try {
            consulta = ConnectionFactory.conectar().prepareStatement(CLIENTE_SELECT_ALL);
            rs = consulta.executeQuery();

            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id_cliente"));
                cl.setCpf(rs.getString("cpf_cliente"));
                cl.setNome(rs.getString("nome_cliente"));
                cl.setEmail(rs.getString("email_cliente"));
                cl.setDataFromSqlDate(rs.getDate("data_cliente"));
                cl.setRua(rs.getString("rua_cliente"));
                cl.setNr(rs.getInt("nr_cliente"));
                cl.setCep(rs.getString("cep_cliente"));
                cl.setCidade(rs.getString("cidade_cliente"));
                cl.setUf(rs.getString("uf_cliente"));      
                
                lista.add(cl);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO NO SELECT DE TODOS OS USUARIOS." + e.getMessage());
        }finally{
            ConnectionFactory.desconectar();
        }
        
        return lista; 
    } 
    
}
