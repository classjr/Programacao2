/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Email;
import com.tads4.sistemasroupas.model.Endereco;
import com.tads4.sistemasroupas.model.Fornecedor;
import com.tads4.sistemasroupas.model.Telefone;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Lucas
 */
public class FornecedorController {

    private Fornecedor fornecedor;

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void criaFornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setTelefones(new HashSet<Telefone>());
        fornecedor.setEmails(new HashSet<Email>());
        fornecedor.setEnderecos(new HashSet<Endereco>());
        this.setFornecedor(fornecedor);
    }

    public void addTelefone(String numero, String ddd, String operadora) {
        if (fornecedor != null) {
            if (fornecedor.getTelefones() != null) {
                fornecedor.getTelefones().add(new Telefone(numero, ddd, operadora));
            } else {
                Set<Telefone> telefones = new HashSet<Telefone>();
                telefones.add(new Telefone(numero, ddd, operadora));
                fornecedor.setTelefones(telefones);
            }
        }
    }

    public void addEmail(String email) {
        if (fornecedor != null) {
            if (fornecedor.getEmails() != null) {
                fornecedor.getEmails().add(new Email(email));
            } else {
                Set<Email> emails = new HashSet<Email>();
                emails.add(new Email(email));
                fornecedor.setEmails(emails);
            }
        }
    }

    public void addEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        if (fornecedor != null) {
            if (fornecedor.getEnderecos() != null) {
                fornecedor.getEnderecos().add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
            } else {
                Set<Endereco> enderecos = new HashSet<Endereco>();
                enderecos.add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
                fornecedor.setEnderecos(enderecos);
            }
        }
    }

    public void excluirFornecedor() {
        Crud crud = new Crud();
        crud.remove(this.fornecedor);
    }

    public void excluirEmail(String endereco) {
        Email email = new Email(endereco);
        fornecedor.getEmails().remove(email);
    }

    public void excluirEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        Endereco endereco = new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero);
        fornecedor.getEnderecos().remove(endereco);
    }

    public void excluirTelefone(String numero, String ddd, String operadora) {
        Telefone telefone = new Telefone(numero, ddd, operadora);
        fornecedor.getTelefones().remove(telefone);
    }

    public void insereFornecedor() {
        Crud crud = new Crud();
        crud.insert(this.fornecedor);
    }

    public void salvarFornecedor() {
        Crud crud = new Crud();
        crud.update(this.fornecedor);
    }

    public void buscaFornecedorId(String id) {
        Crud crud = new Crud();
        Fornecedor fornecedor = (Fornecedor) crud.searchId(Integer.valueOf(id), Fornecedor.class);
        if (fornecedor != null) {
            this.setFornecedor(fornecedor);
        }
    }

    public void buscaFornecedorNome(String nome) {
        Crud crud = new Crud();
        Fornecedor fornecedor = (Fornecedor) crud.searchFornecedorNome(nome);
        if (fornecedor != null) {
            this.setFornecedor(fornecedor);
        }
    }

    public Set<Fornecedor> listFornecedor() {
        Crud crud = new Crud();
        Set<Fornecedor> fornecedores = new HashSet<Fornecedor>();
        for (Object fornecedor : crud.listFornecedor().toArray()) {
            fornecedores.add((Fornecedor) fornecedores);
        }
        return fornecedores;
    }

}
