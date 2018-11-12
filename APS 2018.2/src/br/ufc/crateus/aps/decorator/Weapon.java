package br.ufc.crateus.aps.decorator;

public class Weapon extends EquipmentDecorator{

	public Weapon() {
	
	}
	
	public Weapon(EquipmentDecorator newEquipment) {
		super(newEquipment);
	}
	@Override
	public int cost(Character character) {
		return 8000 + totalCostWithOtherEquipment(character);
	}

}
