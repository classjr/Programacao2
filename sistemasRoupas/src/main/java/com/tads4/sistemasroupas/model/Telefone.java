package com.tads4.sistemasroupas.model;

@Entity
@Table (name= "TELEFONES")

public class Telefone {
    
    @Id 
    @GeneratedValue
    @Column (name= "ID", unique = true, nullable = false)
    private Integer id;
    @Column(name = "NUMERO")
    private String numero;
    @Column (name = "DDD")
    private String ddd;
    @Column (name = "OPERADORA")
    private String operadora;

    public Telefone() {
    }

    public Telefone(String numero, String ddd, String operadora) {
        this.numero = numero;
        this.ddd = ddd;
        this.operadora = operadora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + (this.numero != null ? this.numero.hashCode() : 0);
        hash = 43 * hash + (this.ddd != null ? this.ddd.hashCode() : 0);
        hash = 43 * hash + (this.operadora != null ? this.operadora.hashCode() : 0);
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
        final Telefone other = (Telefone) obj;
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if ((this.ddd == null) ? (other.ddd != null) : !this.ddd.equals(other.ddd)) {
            return false;
        }
        if ((this.operadora == null) ? (other.operadora != null) : !this.operadora.equals(other.operadora)) {
            return false;
        }
        return true;
    }
}
