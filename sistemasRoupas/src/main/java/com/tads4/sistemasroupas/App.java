package com.tads4.sistemasroupas;

import ExemplosAula.Remocao;
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
            Remocao rm = new Remocao();
            rm.running();
        }catch(Exception ex){
            System.out.println("Problemas ao remover linha de banco de dados.: "+ex.getMessage());
        }
    }
}
