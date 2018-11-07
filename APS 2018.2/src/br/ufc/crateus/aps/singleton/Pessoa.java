package br.ufc.crateus.aps.singleton;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Pessoa {

	 private String nome;

	 private	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	 private static Calendar c = Calendar.getInstance();
	 
	 public SimpleDateFormat getDateFormat() { return sdf; }
	 
	 public Calendar getCalendar() {return c; }
	 
	  public abstract boolean validarDocumento(); 
	 
	  public  abstract int calcularIdade();
      	  
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	 
	@Override
	public String toString() {
		return nome;
	}

}

