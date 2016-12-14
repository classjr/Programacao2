package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Produto;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.HashSet;

public class ProdutoController{
    
    private Produto produto;
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
     public void criaProduto() {
        Produto produto = new Produto();
        this.setProduto(produto);
    }
     
     public void insereProduto() {
         Crud crud = new Crud();
        crud.insert(this.produto);
    }

}
