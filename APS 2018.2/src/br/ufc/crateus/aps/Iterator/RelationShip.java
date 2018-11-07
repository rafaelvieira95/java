package br.ufc.crateus.aps.Iterator;

public abstract class RelationShip {

	private int id;
	private String name;
	
	public RelationShip(String name,int id) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(int id) {this.id = id;}
	
	public int getId() {return this.id;}
	
	public void setName(String name) { 	this.name =name; }
	
	public String getName() {return this.name;}
	
	@Override
	public String toString() {
		return "Id: "+this.id +" Name: "+this.name+" \n";
	}
	
}
