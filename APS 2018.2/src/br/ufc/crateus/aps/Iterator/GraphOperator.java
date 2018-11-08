package br.ufc.crateus.aps.Iterator;

public interface GraphOperator<T> extends Iterator <T> {
	
	boolean addFriend(RelationShip f,RelationShip f2);

	boolean deleteFriend(RelationShip f,RelationShip f2);
		

}
