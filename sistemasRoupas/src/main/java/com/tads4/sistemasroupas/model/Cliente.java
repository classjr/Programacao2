package com.tads4.sistemasroupas.model;

public class Cliente extends Pessoa {

    private Double renda;
    private String dataDeCadastro;

    public Cliente() {
    }

    public Cliente(Double renda, String dataDeCadastro) {
        this.renda = renda;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(String dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.renda != null ? this.renda.hashCode() : 0);
        hash = 97 * hash + (this.dataDeCadastro != null ? this.dataDeCadastro.hashCode() : 0);
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
        final Cliente other = (Cliente) obj;
        if ((this.dataDeCadastro == null) ? (other.dataDeCadastro != null) : !this.dataDeCadastro.equals(other.dataDeCadastro)) {
            return false;
        }
        if (this.renda != other.renda && (this.renda == null || !this.renda.equals(other.renda))) {
            return false;
        }
        return true;
    }
}
