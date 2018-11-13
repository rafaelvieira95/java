package br.ufc.crateus.aps.prototype;

public class Dragon  extends EnemyPrototype{

	protected Dragon(Dragon dragon) {
		this.name = dragon.getName();
		this.health = dragon.getHealth();
		this.damage = dragon.getDamage();
	}
	
	public Dragon() {
		
	}
	@Override
	public EnemyPrototype clone() {
		 return new Dragon(this);
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
