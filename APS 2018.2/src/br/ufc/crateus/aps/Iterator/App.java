package br.ufc.crateus.aps.Iterator;

public class App {

	public static void main(String[] args) {
		
		GraphOperator gp = new Graph(10);
		
		RelationShip a = new Friend("Rafael",1);
		RelationShip b = new Friend("Carla",2);
		RelationShip c = new Friend("Maria",3);
		RelationShip d = new Friend("Fernando",4);
		RelationShip e = new Friend("Bianca",5);
		RelationShip f = new Friend("Josué",6);
		
		
		gp.addFriend(a, b);
		gp.addFriend(a, c);
		gp.addFriend(a, d);
		
		while(gp.hasNext()) {
			System.out.println(gp.next());
		}
     
	}

}
