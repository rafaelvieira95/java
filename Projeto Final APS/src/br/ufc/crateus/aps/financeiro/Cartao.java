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
public class Cartao implements Pagamento {

    protected int codigo;
    protected String descricao;

    public Cartao(int codigo,String descricao) {
      this.codigo = codigo;
      this.descricao = descricao;
    }
    
    public Cartao(){}
    
    @Override
    public void pagar(double valor,Pedido pedido) {
       
        double valorLiquido = (pedido.getValorTotal() + pedido.getValorFrete()) - pedido.getDescontoAcumulado();
        
        if(valor >= valorLiquido){
            double troco = (valor - valorLiquido);
            JOptionPane.showMessageDialog(null, "Valor Bruto (R$): "+ String.format("%,.2f", pedido.getValorTotal())+""
                    + "\nValor frete (R$)"+String.format("%,.2f",pedido.getValorFrete()) +""
                    + "\nDesconto total (R$): "+String.format("%,.2f",pedido.getDescontoAcumulado()) +
                    "\nValor Recebido (R$): "+String.format("%,.2f",valor) +
                    "\nTroco (R$): "+ String.format("%,.2f",troco));
            
            JOptionPane.showMessageDialog(null, "pagamento via Cartão de crédito!\nPagamento realizado com sucesso!");
            pedido.setValorTotal(0.0);
        }else{
            
            JOptionPane.showMessageDialog(null, "Valor insuficiente!");
        }
        
    }
    
}
