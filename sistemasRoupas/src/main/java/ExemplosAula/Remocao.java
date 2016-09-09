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
 * Esta classe é responsável pela remoção de dados
 */
public class Remocao {
    private ConexaoDBRelacional conn = null;
    private Connection connection = null;
    public Remocao(){
        try{
            this.conn = new ConexaoDBRelacional();
            this.connection = this.conn.getConnection();
        }catch(Exception ex){
            System.out.println("Problemas ao conectar com o banco. "+ex.getMessage());
        }
    }
    public void running() throws SQLException{
        String sql = "delete from pessoa where pessoa.nome = ?";
        PreparedStatement ps = this.connection.prepareStatement(sql);
        ps.setString(1, "Juliana");
        ps.execute();
        ps.close();
        this.connection.close();
        System.out.println("Ok");
    }
}
