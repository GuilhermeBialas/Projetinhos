/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Guilherme Bialas
 */
public class Conexao {
     private static String CLASS_NAME = "com.mysql.jdbc.driver";
     private static String HOST = "jdbc:mysql://localhost/produtos";
     private static String LOGIN = "root";
     private static String SENHA = "";
     private static Connection conexao;
     
     public static void main(String[] args){
         Conexao.obterConexao();
     }
public static  Connection obterConexao(){
    try {
        conexao = DriverManager.getConnection(HOST,LOGIN,SENHA);
    } catch (SQLException e) {e.printStackTrace();
    }

return conexao;
}

public static void fecharConexao(){
    try {
        if (conexao!=null) {
            conexao.close();
        }
    } catch (SQLException e) {
    e.printStackTrace();
    }
}
}
