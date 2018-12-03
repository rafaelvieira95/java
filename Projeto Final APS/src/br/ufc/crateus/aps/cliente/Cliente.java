/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

import br.ufc.crateus.aps.pedido.Pedido;
import java.util.List;

/**
 *
 * @author rafael
 */
public interface Cliente extends Autenticacao{
        
    void setCodigo(int codigo);

    void setNome(String nome);
    
    void setEndereco(String endereco);
    
    void setCidade(String cidade);
    
    void setEstado(String estado);
    
    void setCep(String cep);
    
    void setTelefone(String telefone);
    
    void setEmail(String email);
    
    void setCpf(String cpf);
    
    void setCnpj(String cnpj);
    
    void setPassaporte(String passaporte);
    
    void setNomeFantasia(String nomeFantasia);
    
    List<Pedido> listaPedidos();
}
