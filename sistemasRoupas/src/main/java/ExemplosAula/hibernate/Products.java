/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author junior
 * This class is resposable for storing data of products
 */
@Entity
@Table(name="products")
public class Products implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="name", nullable=false, length=80)
    private String name;
    @Column(name="barcode", length=100)
    private String barcode;
    
    @Column(name="model", nullable=false, length=80)
    private String model;
    
    @Column(name="price", precision=20)
    private Double price;
    
    @Column(name="color", nullable=false, length=50)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_loan",insertable = true, updatable = true)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Loan loan;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="products_providers",  joinColumns = {@JoinColumn(name="id_products")},inverseJoinColumns = {@JoinColumn(name="id_provider")})
    private Collection<Provider> provider;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Collection<Provider> getProvider() {
        return provider;
    }

    public void setProvider(Collection<Provider> provider) {
        this.provider = provider;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 61 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 61 * hash + (this.barcode != null ? this.barcode.hashCode() : 0);
        hash = 61 * hash + (this.model != null ? this.model.hashCode() : 0);
        hash = 61 * hash + (this.price != null ? this.price.hashCode() : 0);
        hash = 61 * hash + (this.color != null ? this.color.hashCode() : 0);
      // hash = 61 * hash + (this.loan != null ? this.loan.hashCode() : 0);
        hash = 61 * hash + (this.provider != null ? this.provider.hashCode() : 0);
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
        final Products other = (Products) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.barcode == null) ? (other.barcode != null) : !this.barcode.equals(other.barcode)) {
            return false;
        }
        if ((this.model == null) ? (other.model != null) : !this.model.equals(other.model)) {
            return false;
        }
        if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.price != other.price && (this.price == null || !this.price.equals(other.price))) {
            return false;
        }
        if (this.loan != other.loan && (this.loan == null || !this.loan.equals(other.loan))) {
            return false;
        }
        if (this.provider != other.provider && (this.provider == null || !this.provider.equals(other.provider))) {
            return false;
        }
        return true;
    }
    
    
    
}
