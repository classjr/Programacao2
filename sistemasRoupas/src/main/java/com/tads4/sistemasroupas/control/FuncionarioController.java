package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Funcionario;
import com.tads4.sistemasroupas.model.Email;
import com.tads4.sistemasroupas.model.Endereco;
import com.tads4.sistemasroupas.model.Telefone;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GiovanePerlin
 */
public class FuncionarioController {

    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     *
     * @param numero numero do telefone a ser criado
     * @param ddd ddd do telefone a ser criado
     * @param operadora operadora do telefone a ser criado este metodo cria um
     * novo Objeto Telefone e adiciona ao Set de telefones do funcionario
     */
    public void addTelefone(String numero, String ddd, String operadora) {
        if (funcionario != null) {
            if (funcionario.getTelefones() != null) {
                funcionario.getTelefones().add(new Telefone(numero, ddd, operadora));
            } else {
                Set<Telefone> telefones = new HashSet<Telefone>();
                telefones.add(new Telefone(numero, ddd, operadora));
                funcionario.setTelefones(telefones);
            }
        }
    }

    public void addEmail(String email) {
        if (funcionario != null) {
            if (funcionario.getEmails() != null) {
                funcionario.getEmails().add(new Email(email));
            } else {
                Set<Email> emails = new HashSet<Email>();
                emails.add(new Email(email));
                funcionario.setEmails(emails);
            }
        }
    }

    public void addEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        if (funcionario != null) {
            if (funcionario.getEnderecos() != null) {
                funcionario.getEnderecos().add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
            } else {
                Set<Endereco> enderecos = new HashSet<Endereco>();
                enderecos.add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
                funcionario.setEnderecos(enderecos);
            }
        }
    }

    public void buscaFuncionarioId(String id) {
        Crud crud = new Crud();
        Funcionario funcionario = (Funcionario) crud.searchId(Integer.valueOf(id), Funcionario.class);
        if (funcionario != null) {
            this.setFuncionario(funcionario);
        }
    }

    public void buscaFuncionarioNome(String nome) {
        Crud crud = new Crud();
        Funcionario funcionario = (Funcionario) crud.searchFuncionarioNome(nome);
        if (funcionario != null) {
            this.setFuncionario(funcionario);
        }
    }

    public boolean funcionarioExiste() {
        if (funcionario != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Cria um funcionario com os Sets de enderecos, emails e enderecos vazios.
     */
    public void criaFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setTelefones(new HashSet<Telefone>());
        funcionario.setEmails(new HashSet<Email>());
        funcionario.setEnderecos(new HashSet<Endereco>());
        this.setFuncionario(funcionario);
    }
    
    public void excluirFuncionario() {
        Crud crud = new Crud();
        crud.remove(this.funcionario);
    }

    public void excluirEmail(String endereco) {
        Email email = new Email(endereco);
        funcionario.getEmails().remove(email);
    }

    public void excluirEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        Endereco endereco = new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero);
        funcionario.getEnderecos().remove(endereco);
    }

    public void excluirTelefone(String numero, String ddd, String operadora) {
        Telefone telefone = new Telefone(numero, ddd, operadora);
        funcionario.getTelefones().remove(telefone);
    }

    public void insereFuncionario() {
        Crud crud = new Crud();
        crud.insert(this.funcionario);
    }
    
    public Set<Funcionario> listFuncionario() {
        Crud crud = new Crud();
        Set<Funcionario> funcionarios = new HashSet<Funcionario>();
        //recebe um ArrayList e transforma em um Set
        for (Object funcionario : crud.listFuncionario().toArray()) {
            funcionarios.add((Funcionario)funcionario);
        }
        return funcionarios;
    }
    
    public void salvarFuncionario() {
        Crud crud = new Crud();
        crud.update(this.funcionario);
    }

}