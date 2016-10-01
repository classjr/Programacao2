package com.tads4.sistemasroupas.model;

import javax.persistence.Column;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


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
}