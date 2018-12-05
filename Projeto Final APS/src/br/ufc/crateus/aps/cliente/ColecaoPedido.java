/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.cliente;

import br.ufc.crateus.aps.pedido.Pedido;

/**
 *
 * @author rafael
 */
public interface ColecaoPedido {
    
    boolean adicionarPedido(Pedido ... pedido);
    
    boolean removerPedido(Pedido pedido);
    
    boolean pesquisarPedido(Pedido pedido);
    
    boolean colecaoVazia();
    
    Pedido pagarPedido(int i);
    
}
