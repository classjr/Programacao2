package com.tads4.sistemasroupas.model;

public class Funcionario {

    @Column(name = "SENHA")
    private String senha;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "SALARIO")
    private Double salario;
    @Column(name = "FUNCAO")
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(String senha, String usuario, Double salario, String funcao) {
        this.senha = senha;
        this.usuario = usuario;
        this.salario = salario;
        this.funcao = funcao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 37 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        hash = 37 * hash + (this.salario != null ? this.salario.hashCode() : 0);
        hash = 37 * hash + (this.funcao != null ? this.funcao.hashCode() : 0);
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
        final Funcionario other = (Funcionario) obj;
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if ((this.usuario == null) ? (other.usuario != null) : !this.usuario.equals(other.usuario)) {
            return false;
        }
        if ((this.funcao == null) ? (other.funcao != null) : !this.funcao.equals(other.funcao)) {
            return false;
        }
        if (this.salario != other.salario && (this.salario == null || !this.salario.equals(other.salario))) {
            return false;
        }
        return true;
    }
}
