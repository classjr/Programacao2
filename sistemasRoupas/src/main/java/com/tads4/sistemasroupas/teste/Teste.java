package com.tads4.sistemasroupas.teste;

import com.tads4.sistemasroupas.model.*;
import com.tads4.sistemasroupas.model.Produto;
import com.tads4.sistemasroupas.persistence.Crud;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author GiovanePerlin Classe que armazenara os testes
 */
public class Teste {

    public static Cliente addCliente(int i /*numero de emails/telefones/enderecos*/, String cpf) {
        Set<Email> emails = new HashSet<Email>();
        Email[] email = new Email[i];
        Set<Endereco> enderecos = new HashSet<Endereco>();
        Endereco[] endereco = new Endereco[i];
        Set<Telefone> telefones = new HashSet<Telefone>();
        Telefone[] telefone = new Telefone[i];

        for (int cont = 0; cont < i; cont++) {
            email[cont] = new Email("email" + cont + "@email");
            endereco[cont] = new Endereco("Brasil", "MS", "Nova Andradina", "Centro", "79750-000", "Rua", "complemento", "numero: " + cont);
            telefone[cont] = new Telefone("numero: " + cont, "67", "operadora");
            emails.add(email[cont]);
            enderecos.add(endereco[cont]);
            telefones.add(telefone[cont]);
        }

        Cliente cliente = new Cliente(10d, "00/00/000" + i, "Nome" + i, "00" + i, cpf, 'M', "00/00/000" + i, emails, enderecos, telefones);

        return cliente;
    }

    public static Funcionario addFuncionario (int i /*numero de emails/telefones/enderecos*/, String cpf) {
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
        
        Funcionario funcionario = new Funcionario("pwd"+i, "user"+i, 10d, "funcao"+i, emails, enderecos, telefones, "Nome"+i, "00"+i, cpf, 'M', "00/00/000"+i);
        Crud crud = new Crud();
        crud.insert(funcionario);
        
        return funcionario;
    }
    
    /**
     *
     * @param i Número qualquer, para ser concatenado com conteúdo default do
     * método.
     * @return Retorna um objeto do tipo Fornecedor com conteúdo default do
     * método concatenado com o Integer do parâmetro.
     */
    public static Fornecedor addFornecedor(Integer i) {
        Set<Telefone> telefone = new HashSet<Telefone>();
        Set<Endereco> endereco = new HashSet<Endereco>();
        Set<Email> email = new HashSet<Email>();

        Telefone tel1 = new Telefone("00000-0000" + i, "67", "Vivo");
        telefone.add(tel1);

        Endereco end1 = new Endereco("pais" + i, "estado" + i, "cidade" + i, "bairro" + i, "cep" + i, "rua" + i, "complemento" + i, "numero" + i);
        endereco.add(end1);

        Email ema1 = new Email("email@email.com" + i);
        email.add(ema1);

        Fornecedor for1 = new Fornecedor("Fulano" + i, "000.000.000.0" + i, telefone, endereco, email);

        return for1;

    }

    public static Produto addProduto(String tipo, Double valor, String tamanho, String cor, String codigoBarra, String marca) {
        Produto produto = new Produto();

        produto.setTipo(tipo);
        produto.setValor(valor);
        produto.setTamanho(tamanho);
        produto.setCor(cor);
        produto.setCodigoBarra(codigoBarra);
        produto.setMarca(marca);

        return produto;
    }

}
