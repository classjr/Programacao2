/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




/**
 *
 * @author Robson
 */
@Entity
@Table(name = "Venda")
public class Venda implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="codigoVenda")   
    private long codigoVenda;
    @Temporal(TemporalType.TIMESTAMP )
    @Column(name="dataVenda")
    private Calendar dataVenda;

    public Venda() {
    }

    public long getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(long codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public Calendar getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.codigoVenda ^ (this.codigoVenda >>> 32));
        hash = 41 * hash + (this.dataVenda != null ? this.dataVenda.hashCode() : 0);
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
        final Venda other = (Venda) obj;
        if (this.codigoVenda != other.codigoVenda) {
            return false;
        }
        if (this.dataVenda != other.dataVenda && (this.dataVenda == null || !this.dataVenda.equals(other.dataVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigoVenda=" + codigoVenda + ", dataVenda=" + dataVenda + '}';
    }

    
    
    
    
    
    
}
