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
public class Pedido implements PedidoIterator, ColecaoItem {

    public Pedido() {
        this.posicao = 0;
        this.posicaoAtual = 0;
        this.listaItem = new Item[100];

    }

    protected PagamentoStrategy pagamento;
    private int codigo;
    private String dataPedido;
    private String dataPagamento;
    private String enderecoEntrega;
    private double valorFrete;
    private double descontoAcumulado;
    private double valorTotal;
    private int posicao;
    private int posicaoAtual;

    private Item listaItem[];

    public void definirFormaPagamento(double valor, Pagamento pag) {
        this.pagamento = new PagamentoStrategy(pag);
        this.pagamento.pagar(valor, this);
    }

    @Override
    public boolean adicionarItem(Item... item) {

        if (item != null && posicao < listaItem.length) {

            for (int i = 0; i < item.length; i++) {
                listaItem[posicao] = item[i];
                valorTotal += item[i].getPreco();
                descontoAcumulado += item[i].getValorDesconto();
                posicao++;
                
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean apagarItem(int i) {
        if (listaItem[i] != null) {
            descontoAcumulado -= listaItem[i].getValorDesconto();
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
    public String imprimirColecao() {
        return listaDeItens();
    }

    @Override
    public boolean pesquisarItem(Item item) {

        if (item == null) {
            return false;
        }

        for (Item e : listaItem) {
            if (e.equals(item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean apagarItem() {

        if (posicao >= 0 && posicao < listaItem.length) {
            listaItem[posicao - 1] = null;
            --posicao;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return posicaoAtual < posicao || listaItem[posicaoAtual] != null;
    }

    @Override
    public Object next() {
        return listaItem[posicaoAtual++];
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

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDescontoAcumulado() {
        return this.descontoAcumulado;
    }

    private String listaDeItens() {

        StringBuilder sb = new StringBuilder();

        while (hasNext()) {
            Object it = next();
            if(null != it)
                sb.append(it);
        }
        
        posicaoAtual = 0;
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", dataPedido="
                + dataPedido + ", dataPagamento=" + dataPagamento + ", enderecoEntrega="
                + enderecoEntrega + ", valorFrete=" + valorFrete + "\n listaItem="
                + listaDeItens() + '}';
    }

}
