/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.crateus.aps.App;

import br.ufc.crateus.aps.cliente.ClienteProxy;
import br.ufc.crateus.aps.cliente.TipoCliente;
import br.ufc.crateus.aps.financeiro.Boleto;
import br.ufc.crateus.aps.financeiro.Cartao;
import br.ufc.crateus.aps.pedido.Item;
import br.ufc.crateus.aps.pedido.Pedido;
import br.ufc.crateus.aps.roupas.Estilista;
import br.ufc.crateus.aps.roupas.ModeloRoupa;
import br.ufc.crateus.aps.roupas.RoupaBuilder;
import br.ufc.crateus.aps.roupas.RoupaFactory;

/**
 *
 * @author rafael
 */
public class App {
    
    
    
    
    public static void main(String[] args) {
        
        ClienteProxy c = new ClienteProxy("000.000.000-58");
        c.criarCliente(TipoCliente.PESSOA_FISICA);
        c.instance().
                codigo(12321).
                nome("Rafael").
                email("rafaelimavieira@gmail.com").
                cep("63640-000").
                estado("Ceará").
                endereco("Rua 13 de maio - 658").
                telefone("40028922").
                cidade("Independencia").
                email("assadsada").
                Builder();
        
         ClienteProxy c2 = new ClienteProxy("02.858.369/6866-12");
         c2.criarCliente(TipoCliente.PESSOA_JURIDICA);
         c2.instance().
                codigo(15156).
                nome("Emporio dos Colchoes").
                email("rafaelimavieira@gmail.com").
                cep("63680-222").
                estado("Ceará").
                endereco("Rua olavo bilac - 789").
                telefone("08006581224").
                cidade("Crateús").
                email("emporio@zenir.com.br").
                Builder();
         
          ClienteProxy c3 = new ClienteProxy("BR286542");
         c3.criarCliente(TipoCliente.PESSOA_ESTRANGEIRA);
         c3.instance().
                codigo(15099).
                nome("Fausto").
                email("fausto@gmail.com").
                cep("63680-222").
                estado("São paulo").
                endereco("Bairro Morumbi - 1245A").
                telefone("01199873636737").
                cidade("São Paulo").
                Builder();
         
        Pedido p = new Pedido();
        p.setCodigo(123213);
        p.setDataPagamento("23/08/19");
        p.setEnderecoEntrega("Rua dos Alvinegros - GO");
        p.setValorFrete(95.00);
        
        Item it = new Item();
        
        it.setCodigo(11);
   
        it.setValorDesconto(15);
        it.setCodigoPedido(155);
        
        RoupaBuilder r = RoupaFactory.factoryMethod(ModeloRoupa.CAMISA);
       
                r.esgotado(false).
                anoColecao(2018).
                genero('F').
                tipo("Casual").
                valor(89.99).
                marca("Tommy").
                tamanho(2).
                estilista(Estilista.FredBauer).
                quantidadeEstoque(10).
                codido(1012);
        
        
   
       RoupaBuilder r2 = RoupaFactory.factoryMethod(ModeloRoupa.VESTIDO);
                r2.esgotado(false).
                anoColecao(2018).
                genero('F').
                tipo("Casamento").
                valor(589.99).
                marca("Aguia Bela").
                tamanho(2).
                estilista(Estilista.PaulVenetto).
                quantidadeEstoque(2).
                codido(1016);
                
        it.adicionarRoupa(r.builder());
        it.adicionarRoupa(r2.builder());
        p.adicionarItem(it);
        //p.apagarItem();
     //  System.out.println(p.imprimirColecao());      
      //  while(p.hasNext()){
       // System.out.println(p.next());
        //}
         c.adicionarPedido(p);
         c2.adicionarPedido(p);
         System.out.println(c.instance().toString());
         System.out.println(c2.instance().toString());
         System.out.println(c3.instance().toString());
        // c2.pagarPedido(0).definirFormaPagamento(780, new Boleto());
        // c2.pagarPedido(0).definirFormaPagamento(780, new Cartao());
          //System.out.println(c2.pagarPedido(0));
          
        
    }
}
