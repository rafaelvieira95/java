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
public class Cartao implements Pagamento {

    protected int codigo;
    protected String descricao;
    
    @Override
    public void pagar(double valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
