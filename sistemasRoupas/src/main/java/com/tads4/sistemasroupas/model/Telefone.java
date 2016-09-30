package com.tads4.sistemasroupas.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name= "TELEFONES")

public class Telefone {
    
    @Id 
    @GeneratedValue
    @Column (name= "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NUMERO")
    private String numero;
    @Column (name = "DDD")
    private String ddd;
    @Column (name = "OPERADORA")
    private String operadora;
    @ManyToMany(mappedBy = "telefones")
    private List<Funcionario> funcionarios;
    @ManyToMany(mappedBy = "telefones")
    private List<Cliente> clientes;
    @ManyToMany(mappedBy = "telefones")
    private List<Fornecedor> fornecedores;

    public Telefone() {
    }

    public Telefone(String numero, String ddd, String operadora) {
        this.numero = numero;
        this.ddd = ddd;
        this.operadora = operadora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 43 * hash + (this.ddd != null ? this.ddd.hashCode() : 0);
        hash = 43 * hash + (this.operadora != null ? this.operadora.hashCode() : 0);
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
        final Telefone other = (Telefone) obj;
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.ddd == null) ? (other.ddd != null) : !this.ddd.equals(other.ddd)) {
            return false;
        }
        if ((this.operadora == null) ? (other.operadora != null) : !this.operadora.equals(other.operadora)) {
            return false;
        }
        return true;
    }
}
