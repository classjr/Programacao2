/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Cliente;
import com.tads4.sistemasroupas.model.Venda;
import java.util.ArrayList;

/**
 *
 * @author robson
 */
public class VendaController {

    Venda venda = null;
    Cliente cliente = null;

    public VendaController() {
        venda = new Venda();
        cliente = new Cliente();

    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda() {

    }
}
