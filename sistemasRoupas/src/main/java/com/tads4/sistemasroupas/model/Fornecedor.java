package com.tads4.sistemasroupas.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@PrimaryKeyJoinColumn(name="idPessoa")
@Table(name = "FORNECEDOR")
public class Fornecedor {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CNPJ")
    private String cnpj;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="fornecedor_has_email",  joinColumns = {@JoinColumn(name="id_fornecedor")},inverseJoinColumns = {@JoinColumn(name="id_email")})
    private List<Email> emails;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="fornecedor_has_enderecos",  joinColumns = {@JoinColumn(name="id_fornecedor")},inverseJoinColumns = {@JoinColumn(name="id_endereco")})
    private List<Endereco> enderecos;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="fornecedor_has_telefones",  joinColumns = {@JoinColumn(name="id_fornecedor")},inverseJoinColumns = {@JoinColumn(name="id_telefone")})
    private List<Telefone> telefones;

    public Fornecedor(String nome, String cnpj, List<Telefone> telefones, List<Endereco> enderecos, List<Email> emails) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefones = telefones;
        this.enderecos = enderecos;
        this.emails = emails;
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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 13 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        hash = 13 * hash + (this.telefones != null ? this.telefones.hashCode() : 0);
        hash = 13 * hash + (this.enderecos != null ? this.enderecos.hashCode() : 0);
        hash = 13 * hash + (this.emails != null ? this.emails.hashCode() : 0);
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
        if (this.telefones != other.telefones && (this.telefones == null || !this.telefones.equals(other.telefones))) {
            return false;
        }
        if (this.enderecos != other.enderecos && (this.enderecos == null || !this.enderecos.equals(other.enderecos))) {
            return false;
        }
        if (this.emails != other.emails && (this.emails == null || !this.emails.equals(other.emails))) {
            return false;
        }
        return true;
    }

}
