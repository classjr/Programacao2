package com.tads4.sistemasroupas;

import ExemplosAula.Remocao;
import ExemplosAula.hibernate.HibernateUtils;
import ExemplosAula.hibernate.Person;
import com.tads4.sistemasroupas.views.Main;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Main mySystem = new Main();
        mySystem.setVisible(true); */ 
        
        HibernateUtils database = new HibernateUtils();
        Person person = new Person();
        person.setName("Juliana");
        person.setAge(20);
        person.setCpf("000.000.000-00");
        person.setGender(false);
        person.setDateBirth(new Date("20/08/1990"));
        
        database.save(person);
        database.close();
        
        System.out.println("Salvando no Banco !!!");
        
       
    }
}
