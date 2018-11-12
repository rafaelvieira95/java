package br.ufc.crateus.aps.decorator;

public class App {

	public static void main(String[] args) {
		
		    Character person = new Character(KindCharacter.SOLDIER);
		    
		    EquipmentDecorator bpv = new BulletProofVest();
		    EquipmentDecorator flash = new FlashLight();
		    EquipmentDecorator weapon = new Weapon();
		    EquipmentDecorator boots = new Boots();
		    EquipmentDecorator complete = new Boots(new BulletProofVest(new Weapon(new FlashLight())));
		    
		    System.out.println("Cost Bullet Proof vest : "+bpv.cost(person) );
		    System.out.println("Cost FlashLight : "+ flash.cost(person));
		    System.out.println("Cost Weapn : "+ weapon.cost(person));
		    System.out.println("Cost Boots: "+ boots.cost(person));
		    System.out.println("complete Kit: "+complete.cost(person));
	}

}
