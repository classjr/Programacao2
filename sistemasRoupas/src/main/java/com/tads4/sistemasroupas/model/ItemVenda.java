/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import javax.persistence.*;
/**
 *
 * @author Robson
 */
@Entity
@Table(name="ItemVenda")
public class ItemVenda implements Serializable {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int codigoItemVenda;
    @Column(name="QUANTIDADE")
    private int quantidade;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="DATA_ALTERACAO")
    private Calendar dataItemVenda;
    @OneToMany(mappedBy = "Produtos")
    
    private Set<Produto> produto;

    public ItemVenda() {
    }

    public ItemVenda(int quantidade, Calendar dataItemVenda, Set<Produto> produto) {
        this.quantidade = quantidade;
        this.dataItemVenda = dataItemVenda;
        this.produto = produto;
    }

    

    public int getCodigoItemVenda() {
        return codigoItemVenda;
    }

    public void setCodigoItemVenda(int codigoItemVenda) {
        this.codigoItemVenda = codigoItemVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Calendar getDataItemVenda() {
        return dataItemVenda;
    }

    public void setDataItemVenda(Calendar dataItemVenda) {
        this.dataItemVenda = dataItemVenda;
    }

    public Set<Produto> getProduto() {
        return produto;
    }

    public void setProduto(Set<Produto> produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.codigoItemVenda;
        hash = 43 * hash + this.quantidade;
        hash = 43 * hash + (this.dataItemVenda != null ? this.dataItemVenda.hashCode() : 0);
        hash = 43 * hash + (this.produto != null ? this.produto.hashCode() : 0);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.codigoItemVenda != other.codigoItemVenda) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (this.dataItemVenda != other.dataItemVenda && (this.dataItemVenda == null || !this.dataItemVenda.equals(other.dataItemVenda))) {
            return false;
        }
        if (this.produto != other.produto && (this.produto == null || !this.produto.equals(other.produto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "quantidade=" + quantidade + ", dataItemVenda=" + dataItemVenda + ", produto=" + produto + '}';
    }
    
    

    }
