package TennisDatabase;
//Erin Saijan

//class representing the plater container implemented as a circular doubly sorted linked list. 
class TennisPlayerContainer implements TennisPlayerContainerInterface{
	
	private TennisPlayerContainerNode head; //...
	private int numPlayers; //...
	
	//defualt constructor
	public TennisPlayerContainer () {
		
		this.head = null;
		this.numPlayers = 0;
		
	}
	

	   // Desc.: Search for a player in this container by input id, and returns a copy of that player (if found).
	   // Output: Throws an unchecked (non-critical) exception if there is no player with that input id.
	   public TennisPlayer getPlayer( String id ) throws TennisDatabaseRuntimeException{
		   
		 //check if container is empty
		 if(this.numPlayers == 0) {
			 //this container is  empty, search failed, throw exception 
			 throw new TennisDatabaseRuntimeException("Could not get players");
		 }
		 else {
			 //This container is not empty, start search for player
			 TennisPlayerContainerNode currNode = this.head;
			 int currNodeIndex = 0;
			 while((currNodeIndex < this.numPlayers) && (currNode.getPlayer().getId().compareTo(id) < 0)) {
				 currNode = currNode.getNext();
				 currNodeIndex++;
			 }
			 //Check if currNode stores the input id or not.
			 if(currNode.getPlayer().getId().compareTo(id) == 0) {
				 //Input id found at currNode, return a copy of player at currNode
				 return new TennisPlayer(currNode.getPlayer());
			 }
			 else {
				 //Input id not found, throw exception. 
				 throw new TennisDatabaseRuntimeException("Could not get players");
			 }
		 }
	   }

	   // Desc.: Insert a tennis player into this container.
	   // Input: A tennis player.
	   // Output: Throws a checked (critical) exception if player id is already in this container.
	   //         Throws a checked (critical) exception if the container is full.
	   public void insertPlayer( TennisPlayer p ) throws TennisDatabaseException{
		   
		   TennisPlayerContainerNode newNode = new TennisPlayerContainerNode( p );
		   //list is empty
		   if(this.numPlayers == 0) {
			   
			   this.head = newNode;
			   //connect new node properly
			   newNode.setNext(newNode);
			   newNode.setPrev(newNode);
			   
		   }
		   else {
			   
			   TennisPlayerContainerNode currNode = this.head;
			   TennisPlayerContainerNode prevNode = currNode.getPrev();

			   int index = 0;
			  
			  
			   //sort the list
			   while((index < this.numPlayers) && (p.compareTo(currNode.getPlayer()) > 0)) {
				   
				   prevNode = currNode;
				   currNode = currNode.getNext();
				   index++;
			   }
			   
			   prevNode.setNext(newNode);
			   newNode.setPrev(prevNode);
			   newNode.setNext(currNode);
			   currNode.setPrev(newNode);
			   
			   if(index == 0) {this.head = newNode;}

		   }
		   this.numPlayers++;
		         
	   }
	   
	   // Desc.: Insert a tennis match into the lists of both tennis players of the input match.
	   // Input: A tennis match.
	   // Output: Throws a checked (critical) exception if the insertion is not fully successful.
	   public void insertMatch( TennisMatch m ) throws TennisDatabaseException{
		   
		   TennisPlayerContainerNode currNode = this.head;
		   
		   for(int i = 0; i < this.numPlayers; i++) {
			   
			   if(currNode.getPlayer().getId().equals(m.getIdPlayer1())||currNode.getPlayer().getId().equals(m.getIdPlayer2())) {
				   
				   currNode.insertMatch(m);
			   }
			   
			   currNode = currNode.getNext();
		   }
	   }
	   
	   // Desc.: Returns all players in the database arranged in the output array (sorted by id, alphabetically).
	   // Output: Throws an unchecked (non-critical) exception if there are no players in this container.
	   public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException{
		    
		   if((this.numPlayers == 0)) {
			   throw new TennisDatabaseRuntimeException("Error in getAllPlayers, container is emptry");
		   }
		   else {
			   //container is not empty, build an array with all players and return it 
			   TennisPlayer [] p = new TennisPlayer[this.numPlayers];
			   TennisPlayerContainerNode tempHead = this.head;
			   int tempHeadIndex = 0; 
			   
			   while( tempHeadIndex < this.numPlayers) {
				   
				   TennisPlayer currPlayer = tempHead.getPlayer();
				   p [tempHeadIndex] = currPlayer;
				   
				   tempHeadIndex++;
				   tempHead = tempHead.getNext();
			   }
			   
			   return p;
		   }

	   }
	   
	   // Desc.: Returns copies (deep copies) of all matches of input player (id) arranged in the output array (sorted by date, most recent first).
	   // Input: The id of a player.
	   // Output: Throws a checked (critical) exception if the player (id) does not exists.
	   //         Throws an unchecked (non-critical) exception if there are no matches (but the player id exists).
	   public TennisMatch[] getMatchesOfPlayer( String playerId  ) throws TennisDatabaseException, TennisDatabaseRuntimeException{

		   TennisPlayerContainerNode tempHead = this.head;
		   for(int i = 0; i < this.numPlayers; i++) {
			   
			   if(playerId.equals(tempHead.getPlayer().getId())) {
				   
				   return tempHead.getMatches();
			   }
			   tempHead = tempHead.getNext();
		   }
		   throw new TennisDatabaseException("Player ID not found");
	   }

}
