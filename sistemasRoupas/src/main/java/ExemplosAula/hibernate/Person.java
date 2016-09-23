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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (this.age != null ? this.age.hashCode() : 0);
        hash = 67 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        hash = 67 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        hash = 67 * hash + (this.dateBirth != null ? this.dateBirth.hashCode() : 0);
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
        final Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.age != other.age && (this.age == null || !this.age.equals(other.age))) {
            return false;
        }
        if (this.gender != other.gender && (this.gender == null || !this.gender.equals(other.gender))) {
            return false;
        }
        if (this.dateBirth != other.dateBirth && (this.dateBirth == null || !this.dateBirth.equals(other.dateBirth))) {
            return false;
        }
        return true;
    }
   
   
   
    
}
