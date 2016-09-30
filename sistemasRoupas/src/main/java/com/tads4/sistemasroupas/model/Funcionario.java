package com.tads4.sistemasroupas.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Funcionario extends Pessoa {

    @Column(name = "SENHA")
    private String senha;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "SALARIO")
    private Double salario;
    @Column(name = "FUNCAO")
    private String funcao;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="funcionario_has_email",  joinColumns = {@JoinColumn(name="id_funcionario")},inverseJoinColumns = {@JoinColumn(name="id_email")})
    private List<Email> emails;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="funcionario_has_enderecos",  joinColumns = {@JoinColumn(name="id_funcionario")},inverseJoinColumns = {@JoinColumn(name="id_endereco")})
    private List<Endereco> enderecos;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="funcionario_has_telefones",  joinColumns = {@JoinColumn(name="id_funcionario")},inverseJoinColumns = {@JoinColumn(name="id_telefone")})
    private List<Telefone> telefones;
    
    public Funcionario() {
    }

    public Funcionario(String senha, String usuario, Double salario, String funcao, List<Email> emails, List<Endereco> enderecos, List<Telefone> telefones, String nome, String rg, String cpf, char sexo, String dataDeNascimento) {
        super(nome, rg, cpf, sexo, dataDeNascimento);
        this.senha = senha;
        this.usuario = usuario;
        this.salario = salario;
        this.funcao = funcao;
        this.emails = emails;
        this.enderecos = enderecos;
        this.telefones = telefones;
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
        if (this.getSexo() != other.getSexo()) {
            return false;
        }
        if ((this.getNome() == null) ? (other.getNome() != null) : !this.getNome().equals(other.getNome())) {
            return false;
        }
        if ((this.getRg() == null) ? (other.getRg() != null) : !this.getRg().equals(other.getRg())) {
            return false;
        }
        if ((this.getCpf() == null) ? (other.getCpf() != null) : !this.getCpf().equals(other.getCpf())) {
            return false;
        }
        if ((this.getDataDeNascimento() == null) ? (other.getDataDeNascimento() != null) : !this.getDataDeNascimento().equals(other.getDataDeNascimento())) {
            return false;
        }
        return true;
    }
}