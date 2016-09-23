/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author junior
 * This class is resposable for storing data of objects
 */
@Entity
@Table(name="objects", schema="aula")
public class Objects implements java.io.Serializable{
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="codeBar", nullable=false, length=30, unique=true)
    private String codeBar;
    
    
    
}
