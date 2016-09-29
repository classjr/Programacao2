/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
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
    @Column(name="codigoItem")
    private int codigoItemVenda;
    @Column(name="quantidade")
    private int quantidade;
    @Column(name="totalItem")
    private double total;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="dataAlteracao")
    private Calendar dataItemVenda;
    @OneToMany(mappedBy = "Produtos")
    private List<Produto>Produtos;

    public ItemVenda() {
    }

    public ItemVenda(int codigoItemVenda, int quantidade, double total, Calendar dataItemVenda, List<Produto> Produtos) {
        this.codigoItemVenda = codigoItemVenda;
        this.quantidade = quantidade;
        this.total = total;
        this.dataItemVenda = dataItemVenda;
        this.Produtos = Produtos;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Calendar getDataItemVenda() {
        return dataItemVenda;
    }

    public void setDataItemVenda(Calendar dataItemVenda) {
        this.dataItemVenda = dataItemVenda;
    }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public void setProdutos(List<Produto> Produtos) {
        this.Produtos = Produtos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.codigoItemVenda;
        hash = 89 * hash + this.quantidade;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 89 * hash + (this.dataItemVenda != null ? this.dataItemVenda.hashCode() : 0);
        hash = 89 * hash + (this.Produtos != null ? this.Produtos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
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
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (this.dataItemVenda != other.dataItemVenda && (this.dataItemVenda == null || !this.dataItemVenda.equals(other.dataItemVenda))) {
            return false;
        }
        if (this.Produtos != other.Produtos && (this.Produtos == null || !this.Produtos.equals(other.Produtos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codigoItemVenda=" + codigoItemVenda + ", quantidade=" + quantidade + ", total=" + total + ", dataItemVenda=" + dataItemVenda + ", Produtos=" + Produtos + '}';
    }
    
    
   
            
    
}
