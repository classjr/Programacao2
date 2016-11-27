package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Cliente;
import com.tads4.sistemasroupas.model.Telefone;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.Set;

/**
 *
 * @author GiovanePerlin
 */
public class ClienteController {

    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @param numero numero do telefone a ser criado
     * @param ddd ddd do telefone a ser criado
     * @param operadora operadora do telefone a ser criado este metodo cria um
     * novo Objeto Telefone e adiciona ao Set de telefones do cliente
     */
    public void addTelefone(String numero, String ddd, String operadora) {
        if (cliente != null) {
            if (cliente.getTelefones() != null) {
                Set telefones = cliente.getTelefones();
                Telefone telefone = new Telefone(numero, ddd, operadora);
                telefones.add(telefone);
                cliente.setTelefones(telefones);
            }
        }
    }

    public void buscaClienteId(String id) {
        Crud crud = new Crud();
        Cliente cliente = (Cliente) crud.searchId(Integer.valueOf(id), Cliente.class);
        if (cliente != null) {
            this.setCliente(cliente);
        }
    }

    public void buscaClienteNome(String nome) {
        Crud crud = new Crud();
        Cliente cliente = (Cliente) crud.searchClienteNome(nome);
        if (cliente != null) {
            this.setCliente(cliente);
        }
    }
    
    public boolean clienteExiste() {
         if (cliente != null) {
             return true;
         }
         else {
             return false;
         }
    }
}
