/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.financeiro;

import br.ufc.crateus.aps.pedido.Pedido;

/**
 *
 * @author rafael
 */
public interface Pagamento {
    
    void pagar(double valor,Pedido pedido);
    
}
