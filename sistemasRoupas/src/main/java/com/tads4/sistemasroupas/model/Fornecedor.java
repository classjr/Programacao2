package com.tads4.sistemasroupas.model;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Fornecedor {

    private Integer id;
    private String nome;
    private String cnpj;
    private List<Telefone> telefone;
    private List<Endereco> endereco;
    private List<Email> email;

    public Fornecedor(String nome, String cnpj, List<Telefone> telefone, List<Endereco> endereco, List<Email> email) {

        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }

    public Fornecedor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Email> getEmail() {
        return email;
    }

    public void setEmail(List<Email> email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 13 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        hash = 13 * hash + (this.telefone != null ? this.telefone.hashCode() : 0);
        hash = 13 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 13 * hash + (this.email != null ? this.email.hashCode() : 0);
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
        final Fornecedor other = (Fornecedor) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.cnpj == null) ? (other.cnpj != null) : !this.cnpj.equals(other.cnpj)) {
            return false;
        }
        if (this.telefone != other.telefone && (this.telefone == null || !this.telefone.equals(other.telefone))) {
            return false;
        }
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        if (this.email != other.email && (this.email == null || !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

}
