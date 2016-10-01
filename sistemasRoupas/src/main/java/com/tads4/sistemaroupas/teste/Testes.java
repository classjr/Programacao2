package com.tads4.sistemaroupas.teste;

import com.tads4.sistemasroupas.model.Email;
import com.tads4.sistemasroupas.model.Endereco;
import com.tads4.sistemasroupas.model.Fornecedor;
import com.tads4.sistemasroupas.model.Telefone;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Lucas
 */
public class Testes {

    public static void main(String[] args) {
        Set<Telefone> telefone = new HashSet<Telefone>();
        Set<Endereco> endereco = new HashSet<Endereco>();
        Set<Email> email = new HashSet<Email>();

        Telefone tel1 = new Telefone("99617-2234", "67", "Vivo");
        Telefone tel2 = new Telefone("99217-2235", "67", "Claro");
        telefone.add(tel1);
        telefone.add(tel2);

        Endereco end1 = new Endereco("Brasil", "Mato Grosso do Sul", "Nova Andradina", "São Vicente", "79750-000", "Avenida Ivinhema", "Esquina", "2003");
        Endereco end2 = new Endereco("Nigéria", "Niger", "Negrolândia", "Niggas", "66666-000", "Avenida João Negrão", "Senzala", "666");
        endereco.add(end1);
        endereco.add(end2);

        Email ema1 = new Email("lucas@bol.com.br");
        Email ema2 = new Email("nike@niggas.com.br");
        email.add(ema1);
        email.add(ema2);

        Fornecedor for1 = new Fornecedor("Lucas", "000.000.000.0", telefone, endereco, email);

        SessionFactory factory;

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable error) {
            throw new ExceptionInInitializerError();
        }

    }
}
