package br.ufc.crateus.aps.prototype;

public class App {

	public static void main(String[] args) {
	
		Zombie zombie = new Zombie();
		EnemyPrototype zombieInjuried = zombie.clone();
		zombieInjuried.setName("Serra elétrica");
		zombieInjuried.setHealth(85);
       zombie.bioInfo();
       zombieInjuried.bioInfo();
       
	}

}
