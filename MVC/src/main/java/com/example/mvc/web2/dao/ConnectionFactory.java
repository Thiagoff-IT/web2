package com.example.mvc.web2.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static String status = "NAO CONECTADO";
    private static Connection con = null;
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVER = "localhost";
    private static final String BD = "WEBII";
    private static final String USUARIO_BD = "root";
    private static final String SENHA_BD = "1234";
    private static final String URL = "jdbc:mysql://" + SERVER + "/" + BD + 
            "?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    
    
    public static Connection conectar(){
        if(con != null){
            return con;
        }
        try{
           Class.forName(DRIVER);//Carrega o JDBC
           con = DriverManager.getConnection(URL, USUARIO_BD, SENHA_BD);//Estabelece a conexão
            if(con != null){
                status = "CONECTADO!";
                return con;
            }else{
                status = "CONEXAO NAO FOI POSSIVEL";
            }    
        }catch(ClassNotFoundException e){
            System.err.println("DRIVER NAO ENCONTRADO");
        }catch(SQLException e){
            System.err.println("CONEXAO NAO FOI POSSIVEL");
        }
        
        return null;
    }
    
    public static void desconectar(){
        try{
            if(con != null){
                con.close();
            }
            con = null;
        }catch (SQLException e){
            System.err.println("DESCONECTAR NAO FOI POSSIVEL");
        }
    }

    public static String getStatus() {
        return status;
    }
       
    
}
