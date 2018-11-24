/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.financeiro.Pagamento;
import br.ufc.crateus.aps.financeiro.PagamentoStrategy;

/**
 *
 * @author rafael
 */
public class Pedido implements PedidoIterator{

    public Pedido(Pagamento pag){
        this.pagamento = new PagamentoStrategy(pag);
    }
    
    public Pedido(){}
    
    protected PagamentoStrategy pagamento;
    int codigo;
    String dataPedido;
    String dataPagamento;
    String enderecoEntrega;
    double valorFrete;
    //Item listaItem [] =  new Item[100];
    
    public void definirFormaPagamento(Pagamento pag){
        this.pagamento = new PagamentoStrategy(pag);
    }
    
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
