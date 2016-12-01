package com.tads4.sistemasroupas.control;

import com.tads4.sistemasroupas.model.Cliente;
import com.tads4.sistemasroupas.model.Email;
import com.tads4.sistemasroupas.model.Endereco;
import com.tads4.sistemasroupas.model.Telefone;
import com.tads4.sistemasroupas.model.persistence.Crud;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
                cliente.getTelefones().add(new Telefone(numero, ddd, operadora));
            } else {
                Set<Telefone> telefones = new HashSet<Telefone>();
                telefones.add(new Telefone(numero, ddd, operadora));
                cliente.setTelefones(telefones);
            }
        }
    }

    public void addEmail(String email) {
        if (cliente != null) {
            if (cliente.getEmails() != null) {
                cliente.getEmails().add(new Email(email));
            } else {
                Set<Email> emails = new HashSet<Email>();
                emails.add(new Email(email));
                cliente.setEmails(emails);
            }
        }
    }

    public void addEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        if (cliente != null) {
            if (cliente.getEnderecos() != null) {
                cliente.getEnderecos().add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
            } else {
                Set<Endereco> enderecos = new HashSet<Endereco>();
                enderecos.add(new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero));
                cliente.setEnderecos(enderecos);
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
        } else {
            return false;
        }
    }

    /**
     * Cria um cliente com os Sets de enderecos, emails e enderecos vazios.
     */
    public void criaCliente() {
        Cliente cliente = new Cliente();
        cliente.setTelefones(new HashSet<Telefone>());
        cliente.setEmails(new HashSet<Email>());
        cliente.setEnderecos(new HashSet<Endereco>());
        this.setCliente(cliente);
    }
    
    public void excluirCliente() {
        Crud crud = new Crud();
        crud.remove(this.cliente);
    }

    public void excluirEmail(String endereco) {
        Email email = new Email(endereco);
        cliente.getEmails().remove(email);
    }

    public void excluirEndereco(String pais, String estado, String cidade, String bairro, String cep, String rua, String complemento, String numero) {
        Endereco endereco = new Endereco(pais, estado, cidade, bairro, cep, rua, complemento, numero);
        cliente.getEnderecos().remove(endereco);
    }

    public void excluirTelefone(String numero, String ddd, String operadora) {
        Telefone telefone = new Telefone(numero, ddd, operadora);
        cliente.getTelefones().remove(telefone);
    }

    public void insereCliente() {
        Crud crud = new Crud();
        crud.insert(this.cliente);
    }
    
    public Set<Cliente> listCliente() {
        Crud crud = new Crud();
        Set<Cliente> clientes = new HashSet<Cliente>();
        //recebe um ArrayList e transforma em um Set
        for (Object cliente : crud.listCliente().toArray()) {
            clientes.add((Cliente)cliente);
        }
        return clientes;
    }
    
    public void salvarCliente() {
        Crud crud = new Crud();
        crud.update(this.cliente);
    }

}
