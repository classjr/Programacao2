/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author junior
 * 
 * This class is responsable for open conectio and create a SessionFactory
 */

public class BuildSessionFactory {
    
    private SessionFactory cfg = null;                                        //This is property from  
    public BuildSessionFactory() throws Exception{
        try{
            this.cfg = new Configuration().configure().buildSessionFactory();
        }catch(Exception ex){
            throw new Exception("Class 'BuildSessionFactory' method 'Connection'Problems: "+ex.getMessage());
        }
    }
    
    public BuildSessionFactory(String arg) throws Exception{
        try{
            
            this.cfg = new Configuration().configure(arg).buildSessionFactory();
        }catch(Exception ex){
            throw new Exception("Class 'BuildSessionFactory' method 'Connection'Problems: "+ex.getMessage());
        }
    }
    
    /**
     * This method is responsable for return a SessionFactory
     * @return 
     */
    public SessionFactory getSessionFactory(){
        return this.cfg;
    }
    
}
