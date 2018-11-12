package br.ufc.crateus.aps.decorator;

public class Boots extends EquipmentDecorator {

	public Boots() {
	
	}
	
	public Boots(EquipmentDecorator newEquipment) {
		super(newEquipment);
	}
	@Override
	public int cost(Character character) {
		return 250 + totalCostWithOtherEquipment(character);
	}

}
