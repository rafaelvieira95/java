package br.ufc.crateus.aps.bota;

import java.util.HashMap;
import java.util.LinkedList;

public class Pares {

	private LinkedList<Bota> ll = new LinkedList<Bota>();
	private int quantidade;
	private int acc;
	
	public Pares(int quantidade) {
	  this.quantidade = quantidade;
	  this.acc = 0;
	}
	
	//por padrão inicia com 6 pares
	public Pares() {
		this(6);
	}
	
	public void inserePar(int numero,String lado) {

		if(this.quantidade % 2 != 0) {
			System.out.println("informe uma quantidade par de pares!..");
			
			return;
		}
		if(acc <= quantidade) {
		Bota b = new Bota();
		
		lado = lado.toUpperCase();
		
		if(lado.equals("E") || lado.equals("D")  && numero >= 30 && numero <= 60) {
		b.setLado(lado);
		b.setNumero(numero);
		ll.add(b);
		acc++;
		
		}else {
			System.out.println("Capacidade extrapolada!");
		}
		
		}
	}
	
	public int verificarPares() {
	
		HashMap <Integer,String>hash = new HashMap<Integer,String>();
		
		for(Bota b: ll) {
			for(Bota p: ll) {
				
				if(b.getNumero() == p.getNumero()) {
					if(!b.getLado().equals(p.getLado())) hash.put(p.getNumero(), p.getLado());
				}
			}
		}
		return hash.size();
	}
	
	@Override
	public String toString() {
		return this.ll.toString();
	}
	
}
