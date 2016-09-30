/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas
 */
@Entity
@Table(name = "EMAILS")
public class Email {
    /*mesmo que o email de um funcionario seja igual ao de um cliente, 
    na tabela EMAILS deve existir uma tupla para cada. Caso exista somente uma tupla, ao remover o email do funcionario
    removeria também o email de todos que usam aquele email. Ou seja, teremos tuplas com email repetido, porém com ID diferente.*/
    /*as tabelas '%%%%_HAS_EMAIL' são as responsáveis pelo relacionamento N:N
    /*no final das contas, a tabela EMAILS armazena todos os emails da aplicação, porém, existirão tuplas repetidas*/
    
    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "EMAIL") 
    private String email;
    

    public Email() {
    }

    public Email(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.email != null ? this.email.hashCode() : 0);
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
        final Email other = (Email) obj;
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }
}