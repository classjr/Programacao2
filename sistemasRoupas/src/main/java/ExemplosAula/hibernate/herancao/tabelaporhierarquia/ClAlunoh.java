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
@DiscriminatorValue("A")
@Table(name="clalunoperhierarquia")
public class ClAlunoh extends ClPessoah{
    
    @Column(name="registroAcademico", length=80, nullable= false)
    private String registroAcademico;

    public String getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(String registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.registroAcademico != null ? this.registroAcademico.hashCode() : 0);
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
        final ClAlunoh other = (ClAlunoh) obj;
        if ((this.registroAcademico == null) ? (other.registroAcademico != null) : !this.registroAcademico.equals(other.registroAcademico)) {
            return false;
        }
        return true;
    }
    
    

}
