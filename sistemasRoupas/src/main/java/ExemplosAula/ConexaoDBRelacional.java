/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author junior
 * Esta é uma simples classe mostrando uma conexão com o banco de dados relacional
 */
public class ConexaoDBRelacional {
    
    private Connection connection = null;//Classe de conexão com o banco de dados
    
    public ConexaoDBRelacional() throws SQLException{
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/teste","root","root");
    }
    
    public Connection getConnection(){
        return this.connection;
    }
    
    public void closeConnection(){
        try{
            this.connection.close();
        }catch(Exception ex){
            System.out.println("Problemas ao fechar o banco de dados");
        }
    }
}
