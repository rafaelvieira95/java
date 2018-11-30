/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.App;

import br.ufc.crateus.aps.cliente.Cliente;
import br.ufc.crateus.aps.cliente.PessoaFisica;
import br.ufc.crateus.aps.pedido.Item;
import br.ufc.crateus.aps.pedido.Pedido;
import br.ufc.crateus.aps.roupas.Estilista;
import br.ufc.crateus.aps.roupas.ModeloRoupa;

/**
 *
 * @author rafael
 */
public class App {
    
    public static void main(String[] args) {
        
        Cliente c = new PessoaFisica.PFBuilder().
                codigo(20132).
                nome("Rafael").
                estado("Ceará").
                cpf("068.090.753-05").
                email("rafaelimavieira@gmail.com").
                cidade("Independecia").
                cep("63640-000").
                endereco("Rua Tenente Falcão").
                telefone("88 993278922").
                builder();
        
        Pedido p = new Pedido();
        
        Item it = new Item();
        it.gerarRoupa(ModeloRoupa.CAMISA);
        it.obterRoupa().
                esgotado(false).
                anoColecao(2018).
                genero('F').
                tipo("Causal").
                valor(89.99).marca("Tommy").
                tamanho(2).
                estilista(Estilista.FredBauer).
                quantidadeEstoque(15).
                codido(1012);
        
        it.adicionarRoupa(it.obterRoupa().builder());
        
        Item it2 = new Item();
        it2.setCodigo(14);
        it2.setQuantidadeRoupas(1);
        it2.setValorDesconto(15);
        it2.setCodigoPedido(155);
      
        it2.gerarRoupa(ModeloRoupa.VESTIDO);
        it2.obterRoupa().
                esgotado(false).
                anoColecao(2018).
                genero('F').
                tipo("Casamento").
                valor(589.99).marca("Aguia Bela").
                tamanho(2).
                estilista(Estilista.PaulVenetto).
                quantidadeEstoque(2).
                codido(1016);
        it2.adicionarRoupa(it2.obterRoupa().builder());
        
        p.adicionarItem(it);
        p.adicionarItem(it2);
        
        while(p.hasNext()){
        System.out.println(p.next());
        }
        //p.adicionarItem();
        
        //c.infoCliente();
        
       
        
    }
}
