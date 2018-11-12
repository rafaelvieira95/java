package br.ufc.crateus.aps.decorator;

public class BulletProofVest extends EquipmentDecorator {

   public BulletProofVest() {
	   
  }
   
   public BulletProofVest(EquipmentDecorator newEquipment){
	        super(newEquipment);
   }
   
	@Override
	public int cost(Character character) {
		return 4000 + totalCostWithOtherEquipment(character);
	}
	

}
