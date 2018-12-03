/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.financeiro;

import br.ufc.crateus.aps.pedido.Pedido;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class Boleto implements Pagamento{
    
    protected int codigo;
    protected String descricao;
    
    @Override
    public void pagar(double valor,Pedido pedido) {
    
         if(valor >= pedido.getValorTotal()){
            pedido.setValorTotal(valor - pedido.getValorTotal());
            JOptionPane.showMessageDialog(null, "pagamento via Boleto Bancário!\n Pagamento realizado com sucesso!");
        }else{
            
            JOptionPane.showMessageDialog(null, "Valor insuficiente!");
        }
        
    }
    
}
