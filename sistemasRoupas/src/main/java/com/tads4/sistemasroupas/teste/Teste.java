package com.tads4.sistemasroupas.teste;

import com.tads4.sistemasroupas.model.*;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GiovanePerlin Classe que armazenara os testes
 */
public class Teste {
    
     public static Cliente addCliente (int i /*numero de emails/telefones/enderecos*/, String cpf) {
        Set<Email> emails = new HashSet<Email>();
        Email[] email = new Email[i];
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Endereco[] endereco = new Endereco[i];
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone[] telefone = new Telefone[i];
                
        for (int cont = 0; cont < i; cont++) {
            email[cont] = new Email("email"+cont+"@email");
            endereco[cont] = new Endereco("Brasil", "MS", "Nova Andradina", "Centro", "79750-000", "Rua", "complemento", "numero: " + cont);
            telefone[cont] = new Telefone("numero: " + cont, "67", "operadora");
            emails.add(email[cont]);
            enderecos.add(endereco[cont]);
            telefones.add(telefone[cont]);
        }
        
        Cliente cliente = new Cliente(10d, "00/00/000"+i, "Nome"+i, "00"+i, cpf, 'M', "00/00/000"+i, emails, enderecos, telefones);

        return cliente;
    }   
}
