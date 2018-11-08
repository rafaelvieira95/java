package br.ufc.crateus.aps.Iterator;

public class App {

	public static void main(String[] args) {
		
		GraphOperator<Object> gp = new Graph<Object>(10);
		
		RelationShip a = new Friend("Rafael",1);
		RelationShip b = new Friend("Carla",2);
		RelationShip c = new Friend("Maria",3);
		RelationShip d = new Friend("Fernando",4);
		RelationShip e = new Friend("Bianca",5);
		RelationShip f = new Friend("Josué",6);
		
		
		gp.addFriend(a, b); // a é amigo de b
		gp.addFriend(a, c);
		gp.addFriend(a, d);
		gp.addFriend(d, e);
		gp.addFriend(f, c);
		gp.addFriend(b, c);
		
		while(gp.hasNext()) {
			System.out.println(gp.next());
		}
     
	}

}
