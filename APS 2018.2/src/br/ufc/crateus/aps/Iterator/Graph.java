package br.ufc.crateus.aps.Iterator;

public class Graph  implements GraphOperator{

	  private int dimension;
	 private int first = 0;
	 private int current = 0;
	 private int last = 0;
	 
	  private int M[][];
      private RelationShip F [][];
	  
    		  public Graph(int dimension) {
		  
		  this.dimension = dimension;
		  this.M = new int[dimension][dimension];
		  this.F = new RelationShip[dimension][dimension];
	  
	  }
	  
	  public Graph() {
	 this(100);
	}
	@Override
	public boolean hasNext() {
			
		return false;
	}

	@Override
	public Object next() {
		RelationShip p = null;
		if(this.M[first][current] > 0 && first != current){
			   p = F[first][current];
			  current++;
		}else{
			current++;
		}
		
		return p;
	}

	@Override
	public boolean addFriend(RelationShip f,RelationShip f2) {
		
		if(f == null) return false;
		if(f2 == null) return false;
		if(first == 0) first = f.getId();
	
		if(this.M[f.getId()][f2.getId()] == 0) {
			this.M[f.getId()][f2.getId()]  = 1;
			this.M[f2.getId()][f.getId()]  = 1;
			
			this.F[f.getId()][f2.getId()] = f2;
			this.F[f2.getId()][f.getId()] = f;
			
			last = f.getId();
				return true; 
		}
		
		return false;
	}

	@Override
	public boolean deleteFriend(RelationShip f,RelationShip f2) {
		
		if(f == null) return false;
		if(f2 == null) return false;
		
		if(this.M[f.getId()][f2.getId()] == 1) {
			this.M[f.getId()][f2.getId()]  = 0;
			this.M[f2.getId()][f.getId()]  = 0; 
			return true;
		}
		
		
		return false;
	}

	
	public int getDimension() {return this.dimension;}
	
}
