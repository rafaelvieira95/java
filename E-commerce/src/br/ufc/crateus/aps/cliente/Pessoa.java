/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

import br.ufc.crateus.aps.pedido.Pedido;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public abstract class Pessoa implements Cliente,Autenticacao{
    
    public Pessoa(){
    listaPedidos = new ArrayList<>();
    }
    
    private int codigo;
    private String nome;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private String telefone;
    private String email;
    
    public abstract String infoCliente();
    
    private List <Pedido> listaPedidos;

    @Override
    public List<Pedido> listaPedidos() {
        return listaPedidos;
    }

    @Override
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setNome(String nome) {
       this.nome = nome; 
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public void setCidade(String cidade) {
          this.cidade = cidade;      
    }

    @Override
    public void setEstado(String estado) {
       this.estado = estado;
    }

    @Override
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;       
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }  
}
