/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.roupas.ModeloRoupa;
import br.ufc.crateus.aps.roupas.Roupa;
import br.ufc.crateus.aps.roupas.RoupaBuilder;
import br.ufc.crateus.aps.roupas.RoupaFactory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class Item implements ColecaoRoupa {

    private int codigo;
    private int codigoPedido;
    private double preco;
    private double valorDesconto;
    private int quantidadeRoupas;
    private RoupaBuilder novaRoupa;
    private final List<Roupa> listaRoupas;

    public Item() {
        listaRoupas = new ArrayList<>();
    }

    @Override
    public void gerarRoupa(ModeloRoupa modelo) {
         novaRoupa = RoupaFactory.factoryMethod(modelo);
    }

    @Override
    public boolean adicionarRoupa(Roupa r) {
        if (r == null) return false;
        listaRoupas.add(r);
      
        return true;
    }

    @Override
    public boolean apagarRoupa(Roupa r) {

        if (r == null) {
            return false;
        }

        for (Roupa roupa : listaRoupas) {
            if (roupa.equals(r)) {
                listaRoupas.remove(r);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean colecaoVazia() {
        return listaRoupas.isEmpty();
    }

    @Override
    public boolean pesquisarRoupa(Roupa r) {
        if (r == null) {
            return false;
        }

        for (Roupa roupa : listaRoupas) {
            if (roupa.equals(r)) {
                return true;
            }
        }

        return false;
    }

     @Override
    public RoupaBuilder obterRoupa() {
        return novaRoupa;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public double getPreco() {
        return preco;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public int getQuantidadeRoupas() {
        return quantidadeRoupas;
    }

    public void setQuantidadeRoupas(int quantidadeRoupas) {
        this.quantidadeRoupas = quantidadeRoupas;
    }

    
   
    
    @Override
    public String toString() {
        return "Item{" + "codigo=" + codigo + ", codigoPedido="
                + codigoPedido + ", preco=" + preco + ", valorDesconto=" + valorDesconto
                + ", quantidadeRoupas=" + quantidadeRoupas + ", listaRoupas=" + listaRoupas.toString() + '}';
    }

   

}
