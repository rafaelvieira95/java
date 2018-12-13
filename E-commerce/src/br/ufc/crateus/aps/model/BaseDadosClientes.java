package br.ufc.crateus.aps.model;

import br.ufc.crateus.aps.cliente.Cliente;

import java.util.HashMap;

public class BaseDadosClientes {


    private BaseDadosClientes(){

    }

    private static BaseDadosClientes base = new BaseDadosClientes();

    public static BaseDadosClientes getInstance(){
        return base;
    }
    public HashMap<Cliente,String> map = new HashMap<>();


}
