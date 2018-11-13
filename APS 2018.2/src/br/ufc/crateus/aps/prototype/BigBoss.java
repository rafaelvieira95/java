package br.ufc.crateus.aps.prototype;

public class BigBoss extends EnemyPrototype {

	protected BigBoss(BigBoss bigBoss) {
		this.damage = bigBoss.getDamage();
		this.health = bigBoss.getHealth();
		this.name = bigBoss.getName();
	}
	
	public BigBoss() {
		
	}
	
	@Override
	public EnemyPrototype clone() {
		return new BigBoss(this);
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
