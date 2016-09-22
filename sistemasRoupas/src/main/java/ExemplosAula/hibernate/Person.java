/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author junior
 */
@Entity
@Table(name="person", schema="aula")
public class Person implements java.io.Serializable{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   
   @Column(name="name", nullable=false,length=80)
   private String name;
   
   @Column(name="age", nullable=false)
   private Integer age;
   
   @Column(name="gender", nullable=false)
   private Boolean gender;
   
   @Column(name="cpf", unique=true, nullable=false,length=15)
   private String cpf;
   
   @Column(name="dateBirth",nullable=false)
   @Temporal(TemporalType.DATE)
   private Date dateBirth;
   
   
   
    
}
