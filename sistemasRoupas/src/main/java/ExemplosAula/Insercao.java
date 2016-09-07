/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author junior
 * Esta classe é responsavel por inserir dados
 * SQL Necessario:
 * use teste;
 * create table pessoa( id integer primary key, nome varchar(80), cpf varchar(15), fone varchar(13));
 */
public class Insercao {
    private ConexaoDBRelacional conn = null;
    private Connection connection = null;
    public Insercao(){
        try{
            this.conn = new ConexaoDBRelacional();
            this.connection = this.conn.getConnection();
        }catch(Exception ex){
            System.out.println("Problemas ao conectar com o banco. "+ex.getMessage());
        }
    }
    public void running() throws SQLException{
        String sql = "insert into pessoa(id,nome,cpf,fone) values(?,?,?,?)";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setInt(1, 1);
        ps.setString(2, "Juliana");
        ps.setString(3, "000.000.000-00");
        ps.setString(4, "34567898");
        ps.execute();
        ps.close();
        this.connection.close();
    }
}
