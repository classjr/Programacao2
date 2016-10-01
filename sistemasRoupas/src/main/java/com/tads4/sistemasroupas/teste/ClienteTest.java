/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.teste;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GiovanePerlin
 */
public class ClientTest {
    

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
        
       // Venda venda = new Venda(Calendar.getInstance(), clienta);
        
        Set<ItemVenda> itens = new HashSet<ItemVenda>();
       // ItemVenda item1 = new ItemVenda(1, 15d, Calendar.getInstance(), pro1, venda);
        /*ItemVenda item2 = new ItemVenda(2, 16d, Calendar.getInstance(), pro2);
        ItemVenda item3 = new ItemVenda(3, 17d, Calendar.getInstance(), pro3);
        itens.add(item3);
        itens.add(item2);*/
     //   itens.add(item1);
        
     //   venda.setItemVenda(itens);
        
        Long id3 = null;
        try {
            Session session = factory.openSession();
            Transaction tx = session.beginTransaction();
//            id3 = (Long) session.save(venda);
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
