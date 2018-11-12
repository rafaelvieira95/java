package br.ufc.crateus.aps.decorator;

public class FlashLight extends EquipmentDecorator{

    public FlashLight() {
	
    }

    public FlashLight(EquipmentDecorator newEquipment){
    	super(newEquipment);
    }
	@Override
	public int cost(Character character) {
		return 90 + totalCostWithOtherEquipment(character);
	}

}
