
package com.example.mvc.web2.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Thiago
 */
public class Cliente implements Serializable{
    private Integer id;
    private String cpf;
    private String nome;
    private String email;
    private LocalDateTime data;
    private String rua;
    private Integer nr;
    private String cep;
    private String cidade;
    private String uf;

    /*
    public static void main(String[] args) {
        Date dt = new Date(2020, 03, 02);
        String st = new SimpleDateFormat("yyyy-MM-dd").format(dt);
        System.out.println(st);
        
        try {
            String k = "2020-02-01";
            Date dw = new SimpleDateFormat("yyyy-MM-dd").parse(k);
            System.out.println(dw);
            
        } catch (ParseException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }*/
    
    public Cliente() {
    }


    public String getDataString(){
        return data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    
    public String getDataStringBrFormat(){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNr() {
        return nr;
    }

    public void setNr(Integer nr) {
        this.nr = nr;
    }



    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public void setDataFromSqlDate(java.sql.Date dt){
        this.data = Instant.ofEpochMilli(dt.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    
    public long getDataInMili(){
     return data.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }   
    
}
