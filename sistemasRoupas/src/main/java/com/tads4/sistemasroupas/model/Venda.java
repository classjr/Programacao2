/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;





/**
 *
 * @author Robson
 */
@Entity
@Table(name = "VENDAS")
public class Venda implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="ID")   
    private long id;
    @Temporal(TemporalType.TIMESTAMP )
    @Column(name="DATA_VENDA")
    private Calendar dataVenda;
    /*
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "CLIENTES", joinColumns = {
        @JoinColumn(name = "ID_CLIENTE")}, inverseJoinColumns = {
        @JoinColumn(name = "ID")})
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "FUNCIONARIOS", joinColumns = {
        @JoinColumn(name = "ID_FUNCIONARIO")}, inverseJoinColumns = {
        @JoinColumn(name = "ID")})
    private Funcionario funcionario;
*/
    public Venda() {
    }
/*
    public Venda(Calendar dataVenda, Cliente cliente, Funcionario funcionario) {
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 59 * hash + (this.dataVenda != null ? this.dataVenda.hashCode() : 0);
        hash = 59 * hash + (this.cliente != null ? this.cliente.hashCode() : 0);
        hash = 59 * hash + (this.funcionario != null ? this.funcionario.hashCode() : 0);
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.dataVenda != other.dataVenda && (this.dataVenda == null || !this.dataVenda.equals(other.dataVenda))) {
            return false;
        }
        if (this.cliente != other.cliente && (this.cliente == null || !this.cliente.equals(other.cliente))) {
            return false;
        }
        if (this.funcionario != other.funcionario && (this.funcionario == null || !this.funcionario.equals(other.funcionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "dataVenda=" + dataVenda + ", cliente=" + cliente + ", funcionario=" + funcionario + '}';
    }
    */
    

    }
