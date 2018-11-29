/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.financeiro.Pagamento;
import br.ufc.crateus.aps.financeiro.PagamentoStrategy;
import java.util.Arrays;

/**
 *
 * @author rafael
 */
public class Pedido implements PedidoIterator,ColecaoPedido{

    public Pedido(Pagamento pag){
        this.pagamento = new PagamentoStrategy(pag);
        this.posicao = 0;
    }
    
    public Pedido(){
    this.posicao = 0;
    }
    
    protected PagamentoStrategy pagamento;
    private int codigo;
    private String dataPedido;
    private String dataPagamento;
    private String enderecoEntrega;
    private double valorFrete;
    private int posicao;
    
    private final Item listaItem [] =  new Item[100];
    
    public void definirFormaPagamento(Pagamento pag){
        this.pagamento = new PagamentoStrategy(pag);
    }
      
        @Override
    public boolean adicionarItem(Item item){
        if(item != null && posicao < listaItem.length){
            listaItem[posicao] = item;
            posicao++;
            return true;
        }
        return false;
    }
    
     @Override
    public boolean apagarItem(int i) {
        if(listaItem[i] != null){
            listaItem[i] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean colecaoVazia() {
         return posicao == 0;            
    }

    @Override
    public void imprimirColecao() {
        System.out.println(Arrays.toString(listaItem));
    }

    @Override
    public boolean pesquisarItem(Item item) {
        
        if(item != null){
            
            for(Item e: listaItem){
                if(e.equals(item)) return true;
            }  
        }
        return false;
    }
    
     @Override
    public boolean apagarItem() {
        
       if(posicao >= 0 && posicao < listaItem.length){
           listaItem[posicao - 1] = null;
           --posicao;
           return true;
       }
       return false;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }
    
   
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", dataPedido=" + 
                dataPedido + ", dataPagamento=" + dataPagamento + ", enderecoEntrega=" + 
                enderecoEntrega + ", valorFrete=" + valorFrete + ", posicao=" + posicao + ", listaItem=" 
                + listaItem + '}';
    }

   

   
    
}