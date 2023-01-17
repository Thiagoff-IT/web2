package com.example.mvc.web2.dao;

import com.example.mvc.web2.beans.Cliente;
import java.util.ArrayList;

public interface IClienteDAO {
    public void insert(Cliente fc) throws Exception;
    
    public void update(Cliente cl) throws Exception;
    
    public void delete(Integer id) throws Exception;
    
    public ArrayList<Cliente> selectById(Integer id)throws Exception;
    
    public ArrayList<Cliente> selectAll()throws Exception;
}
