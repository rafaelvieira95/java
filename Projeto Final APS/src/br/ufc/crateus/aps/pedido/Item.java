/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.pedido;

import br.ufc.crateus.aps.roupas.Roupa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class Item {
    
    int codigo;
    int codigoPedido;
    double preco;
    double valorDesconto;
    int quantidadeRoupas;
    
    
    List <Roupa> listaRoupas = new ArrayList<>();
    
    
    
}
