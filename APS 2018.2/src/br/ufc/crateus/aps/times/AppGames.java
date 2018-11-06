package br.ufc.crateus.aps.times;

public class AppGames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
		HeapSort h = new HeapSort(10);
		h.put(4);
		h.put(1);
		h.put(3);
		h.put(2);
		h.put(16);
		h.put(9);
		h.put(10);
		h.put(14);
		h.put(8);
		h.put(7);
		
		h.heapSort();
		
		h.array();
		
		  */
     Games j1 = new Games(4,6);
     j1.put("Brasil", 2);
     j1.put("México",2);
     j1.put("Croácia",5);
     j1.put("Camarões",6);
     
  System.out.println(j1.toString());
  System.out.println( j1.checkDraws());
     Games j2 = new Games(2,3);
     j2.put("Brasil", 5);
     j2.put("Japao",1);
     j2.put("Australia",1);
     
    System.out.println(j2.toString());
    System.out.println(j2.checkDraws());
	
	}

}
