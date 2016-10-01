package com.tads4.sistemasroupas.teste;

import com.tads4.sistemasroupas.model.Email;
import com.tads4.sistemasroupas.model.Endereco;
import com.tads4.sistemasroupas.model.Fornecedor;
import com.tads4.sistemasroupas.model.Telefone;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lucas
 */
public class FornecedorTest {
    
    public void addFornecedor(Integer i) {
        Set<Telefone> telefone = new HashSet<Telefone>();
        Set<Endereco> endereco = new HashSet<Endereco>();
        Set<Email> email = new HashSet<Email>();
        
        Telefone tel1 = new Telefone("00000-0000" + i, "67", "Vivo");
        telefone.add(tel1);
        
        Endereco end1 = new Endereco("pais" + i, "estado" + i, "cidade" + i, "bairro" + i, "cep" + i, "rua" + i, "complemento" + i, "numero" + i);
        endereco.add(end1);
        
        Email ema1 = new Email("email@email.com" + i);
        email.add(ema1);
        
        Fornecedor for1 = new Fornecedor("Fulano" + i, "000.000.000.0" + i, telefone, endereco, email);
        
        SessionFactory factory;
        
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable error) {
            throw new ExceptionInInitializerError();
        }
        
        try {
            Session session = factory.openSession();
            Transaction banco = session.beginTransaction();
            session.save(for1);
            banco.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Erro ao conectar com banco!: " + ex.getMessage());
        }
        
    }
    
    public static void main(String[] args) {
        FornecedorTest a = new FornecedorTest();
        a.criaFornecedor(5);
    }
}
