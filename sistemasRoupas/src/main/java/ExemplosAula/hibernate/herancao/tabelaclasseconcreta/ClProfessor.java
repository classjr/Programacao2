/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate.herancao.tabelaclasseconcreta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author junior
 */
@Entity
@Table(name="clprofessor")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ClProfessor extends ClPessoa {
    
    @Column(name="departamento", length=80, nullable=false)
    private String departamento;

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.departamento != null ? this.departamento.hashCode() : 0);
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
        final ClProfessor other = (ClProfessor) obj;
        if ((this.departamento == null) ? (other.departamento != null) : !this.departamento.equals(other.departamento)) {
            return false;
        }
        return true;
    }
    
    
    
}
