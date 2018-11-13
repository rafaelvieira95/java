package br.ufc.crateus.aps.prototype;

public abstract class EnemyPrototype {

	protected String name;
	protected int damage;
	protected int health;
	
	public void setDamage(int damage) {this.damage = damage;}
	
	public void setHealth(int health) { this.health = health;}
	
	public int getDamage() {return this.damage;}
	
	public int getHealth() {return this.health;}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {return this.name;}
	
	public abstract EnemyPrototype clone();
	
	public abstract void bioInfo();
	
}
