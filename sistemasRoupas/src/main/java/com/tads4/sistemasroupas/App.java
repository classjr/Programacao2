package com.tads4.sistemasroupas;

import ExemplosAula.Aula;
import ExemplosAula.hibernate.HibernateUtils;
import ExemplosAula.hibernate.Institute;
import ExemplosAula.hibernate.Loan;
import ExemplosAula.hibernate.Products;
import ExemplosAula.hibernate.Provider;
import ExemplosAula.hibernate.Teacher;
import ExemplosAula.hibernate.herancao.tabelaclasseconcreta.ClAluno;
import ExemplosAula.hibernate.herancao.tabelaclasseconcreta.ClProfessor;
import ExemplosAula.hibernate.herancao.tabelaporhierarquia.ClAlunoh;
import com.tads4.sistemasroupas.model.Cliente;
import com.tads4.sistemasroupas.teste.Teste;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        /*Main mySystem = new Main();
        mySystem.setVisible(true); */

        //onetomay();
        //manytomany();
        //Teste teste = new Teste();
        //Cliente cliente = teste.addCliente(5, "000.000.000.01");
        //teste.addFornecedor(Integer.SIZE);
        //teste.addFuncionario(0, cpf);
        //teste.addCliente(0, cpf);
        //teste.addEmails(0);
        //teste.addEnderecos(0);
        //teste.addTelefones(0);
        //teste.buscaCliente(0);
        //teste.buscaFuncionario(0);
        //teste.removeCliente(cliente);
        //teste.removeCliente(0);
        //teste.removeEmail("email1@email", cliente.getEmails());
        //teste.removeEndereco("numero: 1", cliente.getEnderecos());
        //teste.removeFuncionario(funcionario);
        //teste.removeFuncionario(0);
        //teste.removeTelefone("numero: 1", cliente.getTelefones());
        //teste.atualizarCliente(cliente);
        //teste.atualizarFuncionario(funcionario);

        //teste.addProduto("Calca", 50.00, "PP", "Azul", "000.000.120", "rangler");
        //onetoone();
        //inheritancePerClass();
        //inheritancePerUniqueTable();
        Aula aula = new Aula();
        aula.setVisible(true);
        System.out.println("Salvando no Banco !!!");

    }

    public static void onetomay() {

        HibernateUtils database = new HibernateUtils();
        Loan loan = new Loan();
        Teacher teacher = new Teacher();
        Collection<Products> products = new HashSet<Products>();
        Collection<Loan> loans = new HashSet<Loan>();

        // Criando um objeto emprestimo ****************************************
        loan.setDate(new Date("20/08/2016"));
        loan.setStatus(false);

        //Criando lista de produtos ********************************************
        Products pr1 = new Products();
        Products pr2 = new Products();

        pr1.setName("Projetor");
        pr1.setColor("black");
        pr1.setModel("small");
        pr1.setPrice(500.50);
        pr1.setBarcode("000.000.01");
        pr1.setLoan(loan);
        pr1.setProvider(null);

        pr2.setName("spreedPlan");
        pr2.setColor("black");
        pr2.setModel("bigest");
        pr2.setPrice(54.50);
        pr2.setBarcode("300.000.21");
        pr2.setLoan(loan);
        pr2.setProvider(null);

        products.add(pr2);
        products.add(pr1);
        loan.setProducts(products);

        //Criando um usuario para o emprestimo *********************************
        teacher.setDepartament("Ciencia da Computacao");
        loan.setTeacher(teacher);
        loans.add(loan);

        teacher.setLoans(loans);

        //Salvado no Banco (Na verdade, estamos transformando estes objetos transientes em persistentes)
        database.save(teacher);
        database.close();

    }

    public static void manytomany() {

        HibernateUtils database = new HibernateUtils();
        Products product = new Products();
        Collection<Provider> providers = new HashSet<Provider>();

        //Preenchendo produto **************************************************
        product.setBarcode("400.000.12");
        product.setColor("Green");
        product.setLoan(null);
        product.setModel("bluePrint");
        product.setPrice(100.00);
        product.setName("TableDigital");

        //Preenchendo fornecedores *********************************************
        Provider pro1 = new Provider();
        Provider pro2 = new Provider();

        pro1.setCnpj("000.0001.0002.000-1");
        pro1.setName("ComercialAndroid");
        pro1.setPhone("+5005634567869");

        pro2.setCnpj("222.0001.0442.000-4");
        pro2.setName("FullOptimazed");
        pro2.setPhone("+50056345673547");

        providers.add(pro1);
        providers.add(pro2);

        product.setProvider(providers);
        //Salvando no Banco de Dados *******************************************
        database.save(pro1);
        database.save(pro2);

        database.save(product);
        database.close();

    }

    public static void onetoone() {

        HibernateUtils database = new HibernateUtils();
        Institute institute = new Institute();
        Teacher teacher = new Teacher();

        //Salvar teacher
        teacher.setDepartament("Ciencias Exatas e da Terra");
        teacher.setLoans(null);

        //Salvar institute
        institute.setName("Ciencia da Computacao");
        institute.setTeacher(teacher);
        teacher.setInstitute(institute);

        database.save(teacher);
        database.close();

    }
    
    public static void inheritancePerClass(){
        
        HibernateUtils database = new HibernateUtils();
        ClAluno aluno = new ClAluno();
        ClProfessor professor = new ClProfessor();
        
        //Salvando  um aluno
        aluno.setNome("Mariana Carla");
        aluno.setCpf("000.000.000-00");
        aluno.setRegistroAcademico("000001");
        
        database.save(aluno);
        
        //Salvanco um professor
        professor.setNome("Juliana Alcantara");
        professor.setCpf("111.111.111-11");
        professor.setDepartamento("Ciencia da Computacao");
        database.save(professor); 
        database.close();
    }
    
    public static void inheritancePerUniqueTable(){
        HibernateUtils database = new HibernateUtils();
        ClAlunoh aluno = new ClAlunoh();
        
        aluno.setNome("Dayana Marques");
        aluno.setCpf("222.222.222-22");
        aluno.setRegistroAcademico("1111.11");
        
        database.save(aluno);
        database.close();
        
    }
}
