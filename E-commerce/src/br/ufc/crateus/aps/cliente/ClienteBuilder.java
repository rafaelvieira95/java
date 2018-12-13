/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

/**
 *
 * @author rafael
 */
public interface ClienteBuilder {
    
    ClienteBuilder codigo(int codigo);

    ClienteBuilder nome(String nome);
    
    ClienteBuilder endereco(String endereco);
    
    ClienteBuilder cidade(String cidade);
    
    ClienteBuilder estado(String estado);
    
    ClienteBuilder cep(String cep);
    
    ClienteBuilder telefone(String telefone);
    
    ClienteBuilder email(String email);
    
    ClienteBuilder cpf(String cpf);
    
    ClienteBuilder cnpj(String cnpj);
    
    ClienteBuilder passaporte(String passaporte);
    
    ClienteBuilder nomeFantasia(String nomeFantasia);
    
    Cliente Builder();  
    
}
