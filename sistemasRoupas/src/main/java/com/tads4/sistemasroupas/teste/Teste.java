package com.tads4.sistemasroupas.teste;

import com.tads4.sistemasroupas.model.*;
import com.tads4.sistemasroupas.model.Produto;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GiovanePerlin Classe que armazenara os testes
 */
public class Teste {

    /**
     *
     * @param i Numero de telefones que serao criados
     * @return
     */
    public Set<Telefone> addTelefones(int i) {
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone telefone = null;

        for (int cont = 0; cont < i; cont++) {
            telefone = new Telefone("numero: " + cont, "67", "operadora");
            telefones.add(telefone);
        }

        return telefones;
    }

    /**
     *
     * @param i Numero de enderecos que serao criados
     * @return
     */
    public Set<Endereco> addEnderecos(int i) {
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Endereco endereco = null;

        for (int cont = 0; cont < i; cont++) {
            endereco = new Endereco("Brasil", "MS", "Nova Andradina", "Centro", "79750-000", "Rua", "complemento", "numero: " + cont);
            enderecos.add(endereco);
        }

        return enderecos;
    }

    /**
     *
     * @param i Numero de emails que serao criados
     * @return
     */
    public Set<Email> addEmails(int i) {
        Set<Email> emails = new HashSet<Email>();
        Email email = null;

        for (int cont = 0; cont < i; cont++) {
            email = new Email("email" + cont + "@email");
            emails.add(email);
        }

        return emails;
    }

    /**
     *
     * @param i numero de enderecos, emails e telefones que serao criados
     * (também sera o numero concatenado nos atributos do cliente)
     * @param cpf numero do cpf do cliente (atributo unico)
     * @return um Cliente com i enderecos, emails e telefones
     */
    public Cliente addCliente(int i /*numero de emails/telefones/enderecos*/, String cpf) {
        Set<Email> emails = addEmails(i);
        Set<Endereco> enderecos = addEnderecos(i);
        Set<Telefone> telefones = addTelefones(i);

        Cliente cliente = new Cliente(10d, "00/00/000" + i, "Nome" + i, "00" + i, cpf, 'M', "00/00/000" + i, emails, enderecos, telefones);
        Crud crud = new Crud();
        crud.insert(cliente);

        return cliente;
    }

    /**
     *
     * @param i numero de enderecos, emails e telefones que serao criados
     * (também sera o numero concatenado nos atributos do funcionario)
     * @param cpf numero do cpf do cliente (atributo unico)
     * @return um Funcionario com i enderecos, emails e telefones
     */
    public Funcionario addFuncionario(int i, String cpf) {
        Set<Email> emails = addEmails(i);
        Set<Endereco> enderecos = addEnderecos(i);
        Set<Telefone> telefones = addTelefones(i);

        Funcionario funcionario = new Funcionario("pwd" + i, "user" + i, 10d, "funcao" + i, emails, enderecos, telefones, "Nome" + i, "00" + i, cpf, 'M', "00/00/000" + i);
        Crud crud = new Crud();
        crud.insert(funcionario);

        return funcionario;
    }

    /**
     *
     * @param i codigo do cliente que sera buscado
     */
    public Cliente buscaCliente(int i) {
        Crud crud = new Crud();
        return (Cliente) crud.searchId(i, Cliente.class);
    }

    /**
     *
     * @param i codigo do funcionario que sera buscado
     */
    public Funcionario buscaFuncionario(int i) {
        Crud crud = new Crud();
        return (Funcionario) crud.searchId(i, Funcionario.class);
    }

    /**
     *
     * @param cliente recebe o cliente que sera removido
     */
    public void removeCliente(Cliente cliente) {
        Crud crud = new Crud();
        crud.remove(cliente);
    }

    /**
     *
     * @param i recebe o codigo do cliente que sera removido
     */
    public void removeCliente(int i) {
        Crud crud = new Crud();
        Cliente cliente = buscaCliente(i);
        crud.remove(cliente);
    }

    /**
     *
     * @param funcionario recebe o funcionario que sera removido
     */
    public void removeFuncionario(Funcionario funcionario) {
        Crud crud = new Crud();
        crud.remove(funcionario);
    }

    /**
     *
     * @param i recebe o codigo do funcionario que sera removido
     */
    public void removeFuncionario(int i) {
        Crud crud = new Crud();
        Funcionario funcionario = buscaFuncionario(i);
        crud.remove(funcionario);
    }

    /**
     *
     * @param numero recebe o numero do(s) telefone(s) que sera(o) removido(s)
     * @param telefones recebe o Set de telefones de um
     * Cliente/Fornecedor/Funcionario
     * @return
     */
    public Set<Telefone> removeTelefone(String numero, Set<Telefone> telefones) {
       ArrayList<Telefone> telefone_remove = new ArrayList<Telefone>();

        for (Telefone telefone : telefones) {
            if (telefone.getNumero().equals(numero)) {
                telefone_remove.add(telefone);
            }
        }
        for (Telefone telefone : telefone_remove) {
            telefones.remove(telefone);
        }

        return telefones;
    }

    /**
     *
     * @param numero recebe o numero do(s) endereco(s) que sera(o) removido(s)
     * @param enderecos recebe o Set de enderecos de um
     * Cliente/Fornecedor/Funcionario
     * @return
     */
    public Set<Endereco> removeEndereco(String numero, Set<Endereco> enderecos) {
       ArrayList<Endereco> endereco_remove = new ArrayList<Endereco>();

        for (Endereco endereco : enderecos) {
            if (endereco.getNumero().equals(numero)) {
                endereco_remove.add(endereco);            }
        }
        for (Endereco endereco : endereco_remove) {
            enderecos.remove(endereco);
        }

        return enderecos;
    }

    /**
     *
     * @param endereco_email recebe o email do(s) email(s) que sera(o)
     * removido(s)
     * @param emails recebe o Set de emails de um Cliente/Fornecedor/Funcionario
     * @return
     */
    public Set<Email> removeEmail(String endereco_email, Set<Email> emails) {
        ArrayList<Email> email_remove = new ArrayList<Email>();

        for (Email email : emails) {
            if (email.getEmail().equals(endereco_email)) {
                email_remove.add(email);
            }
        }
        for (Email email : email_remove) {
            emails.remove(email);
        }

        return emails;
    }

    /**
     *
     * @param cliente recebe o cliente que sera atualizado
     */
    public void atualizarCliente(Cliente cliente) {
        Crud crud = new Crud();
        crud.update(cliente);
    }

    /**
     *
     * @param funcionario recebe o cliente que sera atualizado
     */
    public void atualizarFuncionario(Funcionario funcionario) {
        Crud crud = new Crud();
        crud.update(funcionario);
    }

    /**
     *
     * @param i Número qualquer, para ser concatenado com conteúdo default do
     * método.
     * @return Retorna um objeto do tipo Fornecedor com conteúdo default do
     * método concatenado com o Integer do parâmetro.
     */
    public Fornecedor addFornecedor(Integer i) {
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

        return for1;

    }

    /**
     * *
     *
     * @param tipo para gravar o tipo do produto ex: calça jeans, blusa, e etc;
     * @param valor para preço do produto;
     * @param tamanho para gravar as medidas do produto ex: P/M/G...;
     * @param cor do produto ex: Azul, preto, cinza...;
     * @param codigoBarra codigo de barra do produto;
     * @param marca para gravar marca ex: Nike, Adidas, Hering...
     * @return objeto do tipo Produto.
     */
    public void addProduto(String tipo, Double valor, String tamanho, String cor, String codigoBarra, String marca) {
        Produto produto = new Produto();
        Crud crud = new Crud();
        produto.setTipo(tipo);
        produto.setValor(valor);
        produto.setTamanho(tamanho);
        produto.setCor(cor);
        produto.setCodigoBarra(codigoBarra);
        produto.setMarca(marca);

        crud.insert(produto);

    }
}
