package br.ufc.crateus.aps.decorator;

public abstract class EquipmentDecorator {

	protected EquipmentDecorator otherEquipment;
	
	public EquipmentDecorator(EquipmentDecorator otherEquipment) {
		this.otherEquipment = otherEquipment;
	}
	
	public EquipmentDecorator() {
		
	}
	
	public abstract int cost(Character character) ;
	
	protected int totalCostWithOtherEquipment(Character character) {
		 if(otherEquipment == null) return 0;
		 return otherEquipment.cost(character);
	}
	
}
