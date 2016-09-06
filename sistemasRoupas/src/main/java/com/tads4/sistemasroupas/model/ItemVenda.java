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
    
   
            
    
}
