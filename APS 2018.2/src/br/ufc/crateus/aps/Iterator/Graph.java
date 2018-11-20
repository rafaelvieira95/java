package br.ufc.crateus.aps.Iterator;

import java.util.LinkedList;
import java.util.List;

public class Graph <T> implements GraphOperator<T>{

	  private int dimension;
	  private int current = 0; 
	  private int init = 0;
	 
      RelationShip [][] R;
	  
      public Graph(int dimension) {
		  
		  this.dimension = dimension;
		  this.R = new RelationShip[dimension][dimension];
	  
	  }
	  
	  public Graph() {
	    this(100);
	}
	  
	@Override
	public boolean hasNext() {
		return init < dimension;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		
		current = 0;
		List<T> ll = null; 
		
		if(R[init][init] != null) {
		System.out.println("Amigos de "+R[init][init].getName()); 
		 ll = new LinkedList<T>();
		}
		   do {   

			if(R[init][current] != null && current != init) {
			  ll.add((T) R[init][current]);
		 }
			current++;
			
	  }while(current < dimension);
		 
		  init++;
		   
		  return ll != null ?(T) ll :(T) "";  
	}

	
	@Override
	public boolean addFriend(RelationShip f,RelationShip f2) {
	
	  if(R[f.getId()][f2.getId()] == null) {
		  
		  R[f.getId()][f.getId()] = f;
		  R[f2.getId()][f2.getId()] = f2;
		  
		  R[f.getId()][f2.getId()] = f2;
		  R[f2.getId()][f.getId()] = f;
		  return true;
	  }
			
	
		return false;
	}

	@Override
	public boolean deleteFriend(RelationShip f,RelationShip f2) {
		
	
		
		return false;
	}

	
	public int getDimension() {return this.dimension;}
	
}
