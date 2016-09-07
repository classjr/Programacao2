package com.tads4.sistemasroupas;

import ExemplosAula.ConexaoDBRelacional;
import ExemplosAula.Insercao;
import com.tads4.sistemasroupas.views.Main;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* Main mySystem = new Main();
        mySystem.setVisible(true); */
        try{
            Insercao insercao = new Insercao();
            insercao.running();
        }catch(Exception ex){
            System.out.println("Problemas ao tentar conectar com o banco de dados!: "+ex.getMessage());
        }
    }
}
