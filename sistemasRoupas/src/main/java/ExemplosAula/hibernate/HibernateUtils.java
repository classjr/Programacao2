/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author junior
 * This class is responsable for open connectio with database using the hibernate
 */
public class HibernateUtils {
    
    private BuildSessionFactory sessionFactory;
   
    public HibernateUtils(){
        try {
             this.sessionFactory = new BuildSessionFactory();
        } catch (Exception ex) {
            System.out.println("Problems in Class 'Database' method 'Database'. Error: "+ ex.getMessage());
        }
    }
    
    public void save(Object objet){
        try{
            Session session = this.sessionFactory.getSessionFactory().openSession(); //This line open a session
            Transaction tx  = session.beginTransaction();
            session.save(objet);
            tx.commit();     //This line is responsable for commit
            session.close(); //This line is responsable for close
        }catch(Exception ex){
            System.out.println("Problems in Class 'Database' method 'save'. Error: "+ ex.getMessage());
        }
    } 
    public void close(){
        this.sessionFactory.getSessionFactory().close();
    }
    
   
}
