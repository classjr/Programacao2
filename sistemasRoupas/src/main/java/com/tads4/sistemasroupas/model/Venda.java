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
@Table(name = "Venda")
public class Venda implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="ID")   
    private long id;
    @Temporal(TemporalType.TIMESTAMP )
    @Column(name="DATA_VENDA")
    private Calendar dataVenda;
    
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

    public Venda() {
    }

    public Venda(Calendar dataVenda, Set<Cliente> Cliente) {        
        this.dataVenda = dataVenda;
        this.Cliente = Cliente;
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

    public Set<Cliente> getCliente() {
        return Cliente;
    }

    public void setCliente(Set<Cliente> Cliente) {
        this.Cliente = Cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + (this.dataVenda != null ? this.dataVenda.hashCode() : 0);
        hash = 53 * hash + (this.Cliente != null ? this.Cliente.hashCode() : 0);
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
        if (this.Cliente != other.Cliente && (this.Cliente == null || !this.Cliente.equals(other.Cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", Cliente=" + Cliente + '}';
    }

  
    
}
