package com.tads4.sistemasroupas.model.persistence;

import com.tads4.sistemasroupas.model.Cliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author GiovanePerlin Classe Responsável por inserir/remover/atualizar/buscar
 * os "objetos" do banco.
 */
public class Crud {

    private static SessionFactory factory;//For working with hibernate

    static {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer insert(Object object) {
        Integer id = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            id = (Integer) session.save(object);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }

        return id;
    }

    public void remove(Object object) {
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
    }

    public void merge(Object object) {
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.merge(object);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
    }

    public void update(Object object) {
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(object);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
    }

    public Object searchId(Integer id, Class<?> nameClass) {
        Object result = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            result = session.get(nameClass, id);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        return result;
    }

    /*EXEMPLO DE COMO ENVIAR UM QUERY DIRETA
    public Object searchClienteNome(String nome) {
        List id = list("SELECT ID FROM Cliente WHERE NOME='".concat(nome).concat("' "));
        return searchId((Integer) id.get(0), Cliente.class);
    }*/
    
    public Object searchClienteNome(String nome) {
        List objects = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Criteria cr = session.createCriteria(Cliente.class);
            cr.add(Restrictions.like("nome", nome));
            objects = cr.list();
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        if (objects != null) {
            return objects.get(0);
        }
        else {
            return objects;
        }
    }

    public List list(String sql) {
        List object = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            object = session.createQuery(sql).list();
            tx.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        return object;
    }

    public List listQuery(String method, String type, String value) {
        List object = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            Query namedQuery = session.getNamedQuery(method).setString(type, value);
            tx.commit();
            object = namedQuery.list();
            session.close();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        return object;
    }
}
