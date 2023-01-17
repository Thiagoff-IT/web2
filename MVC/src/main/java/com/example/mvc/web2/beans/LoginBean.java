
package com.example.mvc.web2.beans;

import java.io.Serializable;

/**
 *
 * @author Thiago
 */
public class LoginBean implements Serializable{
 
    
    private Integer id;
    private String nome;

    public LoginBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    
}
