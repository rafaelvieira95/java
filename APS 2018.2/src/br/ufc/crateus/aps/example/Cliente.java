/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.example;

/**
 *
 * @author rafael
 */
public abstract class Cliente {
    
    protected String nome;
    protected String cep;
    protected String endereco;
   
    public abstract String infoCliente();
    
}
