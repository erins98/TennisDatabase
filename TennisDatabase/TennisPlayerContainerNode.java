package TennisDatabase;

//class (package - private) implementing the node for the circular doubly sorted linked list for the player container
class TennisPlayerContainerNode implements TennisPlayerContainerNodeInterface{
	
	private TennisPlayer player; //player stored in this node
	private SortedLinkedList<TennisMatch> listMatches; //list of matches of the plater stored in this node
	
	private TennisPlayerContainerNode next; //link to next list node
	private TennisPlayerContainerNode prev; //like to previous list node
	
	//constructor
	public TennisPlayerContainerNode(TennisPlayer p){
		
		this.player = p;
		this.listMatches = new SortedLinkedList<TennisMatch>();
		this.next = null;
		this.prev = null;
		
	}
	
	  // Accessors (getters).
	   public TennisPlayer getPlayer() {return this.player;}
	   public TennisPlayerContainerNode getPrev() {return this.prev;}
	   public TennisPlayerContainerNode getNext() {return this.next;}
	   
	   // Modifiers (setters).
	   public void setPrev( TennisPlayerContainerNode p ) {this.prev = p;}
	   public void setNext( TennisPlayerContainerNode n ) {this.next = n;}
	   
	   // Desc.: Insert a TennisMatch object (reference) into this node.
	   // Input: A TennisMatch object (reference).
	   // Output: Throws a checked (critical) exception if match cannot be inserted in this player list.
	   public void insertMatch( TennisMatch m ) throws TennisDatabaseException{
		   
		   try{
			      
		       this.listMatches.insert(m);
		      }
		      catch(Exception e){
		      
		         throw new TennisDatabaseException("Linked list insertion of a match failed!");
		      }
	   }
	   
	   // Desc.: Returns all matches of this player arranged in the output array (sorted by date, most recent first).
	   // Output: Throws an unchecked (non-critical) exception if there are no matches for this player.
	   public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException{
		   
		   TennisMatch[] matches = new TennisMatch[this.listMatches.size()];
		      for(int i = 0; i<this.listMatches.size(); i++){
		      
		         matches[i]= this.listMatches.get(i);
		      }
		      return matches;
	   }
	   

}
