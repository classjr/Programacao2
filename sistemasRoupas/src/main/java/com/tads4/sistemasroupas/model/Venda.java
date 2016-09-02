/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author Robson
 */
@Entity
@Table(name = "Venda")
public class Venda {
    @codigoVenda 
    @GeneratedValue
    @Column(name=codigoVenda)
    private long codigoVenda;
    @TemporalType.TIMESTAMP
    @Column(name=dataVenda)
    private Calendar dataVenda;
    
    
    
    
    
}
