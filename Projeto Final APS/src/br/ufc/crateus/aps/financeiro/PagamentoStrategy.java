/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.financeiro;

/**
 *
 * @author rafael
 */
public class PagamentoStrategy implements Pagamento{

    private Pagamento pag;
    
    public PagamentoStrategy(Pagamento pag){
        this.pag = pag;
    }
    
    @Override
    public void pagar(double valor) {
        pag.pagar(valor);
    }
    
}
