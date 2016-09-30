/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "ENDERECOS")

public class Endereco {

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "NUMERO")
    private String numero;
    @ManyToMany(mappedBy = "enderecos")
    private List<Funcionario> funcionarios;
    @ManyToMany(mappedBy = "enderecos")
    private List<Cliente> clientes;
    @ManyToMany(mappedBy = "enderecos")
    private List<Fornecedor> fornecedores;

    public Endereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
    }

    public Endereco() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        int hash = 7;
        hash = 23 * hash + (this.pais != null ? this.pais.hashCode() : 0);
        hash = 23 * hash + (this.estado != null ? this.estado.hashCode() : 0);
        hash = 23 * hash + (this.cidade != null ? this.cidade.hashCode() : 0);
        hash = 23 * hash + (this.bairro != null ? this.bairro.hashCode() : 0);
        hash = 23 * hash + (this.cep != null ? this.cep.hashCode() : 0);
        hash = 23 * hash + (this.rua != null ? this.rua.hashCode() : 0);
        hash = 23 * hash + (this.complemento != null ? this.complemento.hashCode() : 0);
        hash = 23 * hash + (this.numero != null ? this.numero.hashCode() : 0);
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
        final Endereco other = (Endereco) obj;
        if ((this.pais == null) ? (other.pais != null) : !this.pais.equals(other.pais)) {
            return false;
        }
        if ((this.estado == null) ? (other.estado != null) : !this.estado.equals(other.estado)) {
            return false;
        }
        if ((this.cidade == null) ? (other.cidade != null) : !this.cidade.equals(other.cidade)) {
            return false;
        }
        if ((this.bairro == null) ? (other.bairro != null) : !this.bairro.equals(other.bairro)) {
            return false;
        }
        if ((this.cep == null) ? (other.cep != null) : !this.cep.equals(other.cep)) {
            return false;
        }
        if ((this.rua == null) ? (other.rua != null) : !this.rua.equals(other.rua)) {
            return false;
        }
        if ((this.complemento == null) ? (other.complemento != null) : !this.complemento.equals(other.complemento)) {
            return false;
        }
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        return true;
    }
}
