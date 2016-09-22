package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name= "PESSOAS")
public class Pessoa implements Serializable{

    @Id @GeneratedValue
    @Column (name= "ID", unique = true, nullable = false)
    private Integer id;
    @Column (name = "NOME")
    private String nome;
    @Column (name = "RG")
    private String rg;
    @Column (name = "CPF", unique= true)
    private String cpf;
    @Column (name = "SEXO")
    private char sexo;
    @Column (name = "NASCIMENTO")
    private String dataDeNascimento;
    @OneToMany(mappedBy = "PESSOAS")
    private List<Email> emails;
    @OneToMany(mappedBy = "PESSOAS")
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "PESSOAS")
    private List<Telefone> telefones;

    public Pessoa() {
    }

    public Pessoa(String nome, String rg, String cpf, char sexo, String dataDeNascimento, List<Email> emails, List<Endereco> enderecos, List<Telefone> telefones) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.emails = emails;
        this.enderecos = enderecos;
        this.telefones = telefones;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.rg != null ? this.rg.hashCode() : 0);
        hash = 67 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 67 * hash + this.sexo;
        hash = 67 * hash + (this.dataDeNascimento != null ? this.dataDeNascimento.hashCode() : 0);
        hash = 67 * hash + (this.emails != null ? this.emails.hashCode() : 0);
        hash = 67 * hash + (this.enderecos != null ? this.enderecos.hashCode() : 0);
        hash = 67 * hash + (this.telefones != null ? this.telefones.hashCode() : 0);
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
        final Pessoa other = (Pessoa) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.rg == null) ? (other.rg != null) : !this.rg.equals(other.rg)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if ((this.dataDeNascimento == null) ? (other.dataDeNascimento != null) : !this.dataDeNascimento.equals(other.dataDeNascimento)) {
            return false;
        }
        if (this.emails != other.emails && (this.emails == null || !this.emails.equals(other.emails))) {
            return false;
        }
        if (this.enderecos != other.enderecos && (this.enderecos == null || !this.enderecos.equals(other.enderecos))) {
            return false;
        }
        if (this.telefones != other.telefones && (this.telefones == null || !this.telefones.equals(other.telefones))) {
            return false;
        }
        return true;
    }
}
