package br.ufc.crateus.aps.Iterator;

public interface GraphOperator extends Iterator {
	
	boolean addFriend(RelationShip f,RelationShip f2);

	boolean deleteFriend(RelationShip f,RelationShip f2);
		

}
