package br.ufc.crateus.aps.prototype;

public class Zombie extends EnemyPrototype{

	protected Zombie(Zombie zombie) {
		this.damage = zombie.getDamage();
		this.health = zombie.getHealth();
		this.name = zombie.getName();
	}
	
	public Zombie() {
		this.damage = 15;
		this.health = 100;
		this.name = "Zombie";
	}
	
	@Override
	public EnemyPrototype clone() {
		return new Zombie(this);
	}

	@Override
	public void bioInfo() {
		StringBuilder sb = new StringBuilder("Info:").append("\n");
		sb.append("Name: ").append(this.getName()).append("\n");
		sb.append("Health: ").append(this.getHealth()).append("\n");
		sb.append("Damage: ").append(this.getDamage()).append("\n");
		System.out.println(sb.toString());
	}

}
