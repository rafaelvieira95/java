package br.ufc.crateus.aps.Iterator;


public class Graph <T> implements GraphOperator<T>{

	  private int dimension;
	  private int current = 0; 
	  
      private static class Node{
    	  
    	  private Node next;
    	  private RelationShip r;
    	  
    	  public Node(RelationShip r,Node next) {
    		  this.next = next;
    		  this.r = r;
    	  }
    	  
      }
      
      private Node root[];
      
      public Graph(int dimension) {
		  
		  this.dimension = dimension;
		  this.root = new Node[dimension];
	  
	  }
	  
	  public Graph() {
	    this(100);
	}
	  
	@Override
	public boolean hasNext() {
		return current < dimension;
	}

	@Override
	public T next() {
		  
		Node p = root[current];
		
	      while(p != null) {
	          
	    	  T temp = (T) p.r;
	    	  
	          p = p.next;
	    	  
	    	  return temp != null? temp : null;   
	       }
	      if(p == null) current++;
	      
		return null;
	}

	
	@Override
	public boolean addFriend(RelationShip f,RelationShip f2) {
	
		if(f.getId() < dimension && f2.getId() < dimension) {
			
			for(Node p = this.root[f.getId()]; p != null; p = p.next) {    
				if(p.equals(f2)) return false;
			}
			
			this.root[f.getId()] = new Node(f2,this.root[f.getId()]);
			this.root[f2.getId()] = new Node(f,this.root[f2.getId()]);
			
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
