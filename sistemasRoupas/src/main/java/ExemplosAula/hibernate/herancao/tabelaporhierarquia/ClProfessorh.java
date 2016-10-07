/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemplosAula.hibernate.herancao.tabelaporhierarquia;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author junior
 */
@Entity
@DiscriminatorValue("R")
@Table(name="cpprofessorperhierarquia")
public class ClProfessorh extends ClPessoah {
    
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
        int hash = 3;
        hash = 43 * hash + (this.departamento != null ? this.departamento.hashCode() : 0);
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
        final ClProfessorh other = (ClProfessorh) obj;
        if ((this.departamento == null) ? (other.departamento != null) : !this.departamento.equals(other.departamento)) {
            return false;
        }
        return true;
    }
    
    
}
