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
    @Column(name="quantidade")
    private int quantidade;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="DATA_ALTERACAO")
    private Calendar dataItemVenda;
    @OneToMany(mappedBy = "Produtos")
    private Set<Produto> produto;

    public ItemVenda() {
    }

    }
