package br.ufc.crateus.aps.bota;

public class Bota {

	private int numero;
    private String lado;
    
    public void setLado(String lado) { this.lado = lado;}
        
    public String getLado() {return this.lado;}
    
    public void setNumero(int numero) { this.numero = numero; }
    
    public int getNumero() {return this.numero;}
    
    @Override
    public String toString() {
    	return this.numero + " "+this.lado;
    }
    
}
