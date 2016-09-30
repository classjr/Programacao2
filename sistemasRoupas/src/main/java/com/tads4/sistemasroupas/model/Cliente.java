package com.tads4.sistemasroupas.model;

import java.util.List;
import javax.persistence.Column;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Cliente extends Pessoa {

    @Column(name = "RENDA")
    private Double renda;
    @Column(name = "DATADECADASTRO")
    private String dataDeCadastro;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="cliente_has_email",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_email")})
    private List<Email> emails;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="cliente_has_enderecos",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_endereco")})
    private List<Endereco> enderecos;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="cliente_has_telefones",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_telefone")})
    private List<Telefone> telefones;
    
    public Cliente() {
    }

    public Cliente(Double renda, String dataDeCadastro, String nome, String rg, String cpf, char sexo, String dataDeNascimento, List<Email> emails, List<Endereco> enderecos, List<Telefone> telefones) {
        super(nome, rg, cpf, sexo, dataDeNascimento);
        this.renda = renda;
        this.dataDeCadastro = dataDeCadastro;
        this.emails = emails;
        this.enderecos = enderecos;
        this.telefones = telefones;
    }

    public Cliente(Double renda, String dataDeCadastro) {
        this.renda = renda;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.renda != null ? this.renda.hashCode() : 0);
        hash = 97 * hash + (this.dataDeCadastro != null ? this.dataDeCadastro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if ((this.dataDeCadastro == null) ? (other.dataDeCadastro != null) : !this.dataDeCadastro.equals(other.dataDeCadastro)) {
            return false;
        }
        if (this.renda != other.renda && (this.renda == null || !this.renda.equals(other.renda))) {
            return false;
        }
        if (this.getSexo() != other.getSexo()) {
            return false;
        }
        if ((this.getNome() == null) ? (other.getNome() != null) : !this.getNome().equals(other.getNome())) {
            return false;
        }
        if ((this.getRg() == null) ? (other.getRg() != null) : !this.getRg().equals(other.getRg())) {
            return false;
        }
        if ((this.getCpf() == null) ? (other.getCpf() != null) : !this.getCpf().equals(other.getCpf())) {
            return false;
        }
        if ((this.getDataDeNascimento() == null) ? (other.getDataDeNascimento() != null) : !this.getDataDeNascimento().equals(other.getDataDeNascimento())) {
            return false;
        }
        return true;
    }


/*TESTE DO CLIENTE*//*TESTE DO CLIENTE*//*TESTE DO CLIENTE*//*TESTE DO CLIENTE*//*TESTE DO CLIENTE*//*TESTE DO CLIENTE*/
    public static void main(String[] args) throws Exception {
        ArrayList<Email> emails = new ArrayList<Email>();
        Email email = new Email("email@email");
        emails.add(email);
        ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
        ArrayList<Telefone> telefones = new ArrayList<Telefone>();
        Cliente clienta = new Cliente(5d, "2016-08-18", "nome", "rg", "cpf", 'm', "2016-09-18", emails, enderecos, telefones);

        SessionFactory factory;

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }

        Integer id = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            id = (Integer) session.save(clienta);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
    }
/*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*/
}