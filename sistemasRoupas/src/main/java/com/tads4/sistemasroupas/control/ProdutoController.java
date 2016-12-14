package com.tads4.sistemasroupas.control;


import com.tads4.sistemasroupas.model.Produto;
import com.tads4.sistemasroupas.model.persistence.Crud;

import java.util.HashSet;
import java.util.Set;

public class ProdutoController{
    
    private Produto produto;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
     
    public void excluirProduto() {
        Crud crud = new Crud();
        crud.remove(this.produto);
    }

    

    public void insereProduto() {
        Crud crud = new Crud();
        crud.insert(this.produto);
    }

    public void salvarProduto() {
        Crud crud = new Crud();
        crud.update(this.produto);
    }

    public void buscaProdutoId(String id) {
        Crud crud = new Crud();
        Produto produto = (Produto) crud.searchId(Integer.valueOf(id), Produto.class);
        if (produto != null) {
            this.setProduto(produto);
        }
    }

    public void buscaProdutoNome(String nome) {
        Crud crud = new Crud();
        Produto produto = (Produto) crud.searchProdutoNome(nome);
        if (produto != null) {
            this.setProduto(produto);
        }
    }

    public Set<Produto> listProduto() {
        Crud crud = new Crud();
        Set<Produto> produtos = new HashSet<Produto>();
        for (Object produto : crud.listProduto().toArray()) {
            produtos.add((Produto) produto);
        }
        return produtos;
    }
    
    
}

