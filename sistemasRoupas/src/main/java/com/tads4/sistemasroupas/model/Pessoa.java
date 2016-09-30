package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "RG")
    private String rg;
    @Column(name = "CPF")
    private String cpf;
    @Column(name = "SEXO")
    private char sexo;
    @Column(name = "NASCIMENTO")
    private String dataDeNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String rg, String cpf, char sexo, String dataDeNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 67 * hash + (this.rg != null ? this.rg.hashCode() : 0);
        hash = 67 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 67 * hash + this.sexo;
        hash = 67 * hash + (this.dataDeNascimento != null ? this.dataDeNascimento.hashCode() : 0);
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
        return true;
    }
}
