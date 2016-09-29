/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;

import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author junior
 * This class is responsable for Loan
 */
@Entity
@Table(name="loan")
public class Loan implements java.io.Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="data",nullable=false)
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Column(name="status")
    private Boolean status;
    
    @OneToMany(mappedBy="loan", fetch= FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Collection<Products> products;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Teacher teacher;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Collection<Products> getProducts() {
        return products;
    }

    public void setProducts(Collection<Products> products) {
        this.products = products;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 31 * hash + (this.date != null ? this.date.hashCode() : 0);
        hash = 31 * hash + (this.status != null ? this.status.hashCode() : 0);
        hash = 31 * hash + (this.products != null ? this.products.hashCode() : 0);
        hash = 31 * hash + (this.teacher != null ? this.teacher.hashCode() : 0);
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
        final Loan other = (Loan) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.date != other.date && (this.date == null || !this.date.equals(other.date))) {
            return false;
        }
        if (this.status != other.status && (this.status == null || !this.status.equals(other.status))) {
            return false;
        }
        if (this.products != other.products && (this.products == null || !this.products.equals(other.products))) {
            return false;
        }
        if (this.teacher != other.teacher && (this.teacher == null || !this.teacher.equals(other.teacher))) {
            return false;
        }
        return true;
    }

    
    
    
}
