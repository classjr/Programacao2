package com.tads4.sistemasroupas.model;

import java.sql.Date;
import java.util.Calendar;
import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;
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
    @JoinTable(name="cliente_has_emails",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_email")})
    private Set<Email> emails;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="cliente_has_enderecos",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_endereco")})
    private Set<Endereco> enderecos;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="cliente_has_telefones",  joinColumns = {@JoinColumn(name="id_cliente")},inverseJoinColumns = {@JoinColumn(name="id_telefone")})
    private Set<Telefone> telefones;
    
    public Cliente() {
    }

    public Cliente(Double renda, String dataDeCadastro, String nome, String rg, String cpf, char sexo, String dataDeNascimento, Set<Email> emails, Set<Endereco> enderecos, Set<Telefone> telefones) {
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

    public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Set<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
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
        Set<Email> emails = new HashSet<Email>();
        Email email = new Email("email@email");
        emails.add(email);
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Set<Telefone> telefones = new HashSet<Telefone>();
        Cliente clienta = new Cliente(5d, "2016-08-18", "nome", "rg", "cpf", 'm', "2016-09-18", emails, enderecos, telefones);

        /*Set<Email> emails2 = new HashSet<Email>();
        Email email2 = new Email("email@email");
        emails2.add(email2);
        Set<Endereco> enderecos2 = new HashSet<Endereco>();
        Endereco ender2 = new Endereco("brasil", "ms", "na", "centro", "79750-000", "avenida", "nada", "40");
        enderecos2.add(ender2);
        Set<Telefone> telefones2 = new HashSet<Telefone>();
        Telefone tele2 = new Telefone("4789-6456", "67", "claro");
        telefones2.add(tele2);
        Funcionario funcionario = new Funcionario("pwd", "user", 25d, "funcao", emails2, enderecos2, telefones2, "nome", "rg", "cpf", 'm', "2016-09-18");*/
        
        SessionFactory factory;

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }      
        

        clienta = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            clienta = (Cliente) session.get(Cliente.class, 1);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
              
        /*Produto pro1 = new Produto("roupa", 1d, "tam1", "cor1", 11111, "marca1");
        Produto pro2 = new Produto("calcado", 2d, "tam2", "cor2", 22222, "marca2");
        Produto pro3 = new Produto("seila", 3d, "tam3", "cor3", 33333, "marca3");
        System.out.println("eae/");*/
        
        Produto pro1 = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            pro1 = (Produto) session.get(Produto.class, 3);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }

        /*Produto pro2 = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            pro2 = (Produto) session.get(Produto.class, 30);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        
        Produto pro3 = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            pro3 = (Produto) session.get(Produto.class, 30);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }*/
        
        Venda venda = new Venda(Calendar.getInstance(), clienta);
        
        Set<ItemVenda> itens = new HashSet<ItemVenda>();
        ItemVenda item1 = new ItemVenda(1, 15d, Calendar.getInstance(), pro1, venda);
        /*ItemVenda item2 = new ItemVenda(2, 16d, Calendar.getInstance(), pro2);
        ItemVenda item3 = new ItemVenda(3, 17d, Calendar.getInstance(), pro3);
        itens.add(item3);
        itens.add(item2);*/
        itens.add(item1);
        
        venda.setItemVenda(itens);
        
        Long id3 = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            id3 = (Long) session.save(venda);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }
        
        
        /*
        
        
        
        Teacher t = new Teacher();
        Institute i = new Institute();
        
        i.setName("instituto");
        
        ArrayList<Loan> l = new ArrayList<Loan>();
        Loan loan = new Loan();
        loan.setDate(Date.valueOf("2016-08-07"));
        loan.setStatus(Boolean.TRUE);
        
        Collection p = new ArrayList<Products>();
        Products pro = new Products();
        pro.setBarcode("052645");
        pro.setColor("color");
        pro.setModel("model");
        pro.setName("name");
        pro.setPrice(2d);
        p.add(pro);

        
        Collection pv = new ArrayList<Provider>();
        Provider prov = new Provider();
        prov.setCnpj("456564");
        prov.setName("provider");
        prov.setPhone("phone");
        pv.add(prov);

        pro.setProvider(pv);
        
        loan.setProducts(p);

        l.add(loan);
        
        t.setInstitute(i);
        t.setDepartament("departament");
        t.setLoans(l);
        
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
            id = (Integer) session.save(t);
            tx.commit();
        } catch (Exception ex) {
            System.out.println("Problemas ao conectar no Banco de dados. Erro: " + ex.getMessage());
        }*/
    }
/*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*//*FIM DOTESTE DO CLIENTE*/
}