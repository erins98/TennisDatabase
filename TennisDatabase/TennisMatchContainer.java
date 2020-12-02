package TennisDatabase;
//Erin Saijan

import java.util.*;


//sorted array- based list of tennis matches(implemented with resizable array)
 class TennisMatchContainer implements TennisMatchContainerInterface {
	
	 private TennisMatch[] array; // internal array to implement the sorted list. 
	 private int currNumMatches; //logical size 
	 private int maxNumMatches; //physicial size 
	 
	 //default constructor 
	 public TennisMatchContainer() {
		 this.currNumMatches = 0;
		 this.maxNumMatches = 4;
		 this.array = new TennisMatch[this.maxNumMatches];
	 }
	
	   // Desc.: Insert a tennis match into this container.
	   // Input: A tennis match.
	   // Output: Throws a checked (critical) exception if the container is full.
	   public void insertMatch( TennisMatch m ) throws TennisDatabaseException{
		  
 
		   if (this.currNumMatches == this.maxNumMatches) {
			
			   //here array is full, resize it
			   //1.Create an empty bigger array
			   int newMaxNumMatches = this.maxNumMatches * 2;
			   TennisMatch[] newArray = new TennisMatch[newMaxNumMatches];
			   //2.transfer data from old smaller array to new bigger array 
			   for(int i = 0; i< this.currNumMatches; i++) {
				   
				   newArray [i] = this.array[i];
			   }
			   //3.switch between old smaller array and new bigger array
			   this.array = newArray;
			   this.maxNumMatches = newMaxNumMatches;
	   
		   }
		   
		   //sort properly 
		   int index = this.currNumMatches; // default to end of array
		   for(int i = 0; i < this.currNumMatches; i++) {
			   
			   if(m.compareTo(this.array[i]) > 0) {
				   
				   index = i;
				   break;
			   }
		   }
		   
		   //shift after insertion
		   for(int i = this.currNumMatches; i > index; i--) {
			   
			   this.array[i] = this.array [i-1];
		   }
		   
		   //insert new match
		   this.array[index] = m; //input match
		   this.currNumMatches++; //new number
		   
	   }
	   
	   // Desc.: Returns all matches in the database arranged in the output array (sorted by date, most recent first).
	   // Output: Throws an exception if there are no matches in this container.
	   public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException{
		   
		   TennisMatch[] newArray = new TennisMatch[this.currNumMatches];
		   
		   for(int i = 0; i < this.currNumMatches; i++) {
			   
			   newArray[i] = this.array[i];
		   }
		   
		   return newArray;
		   
	   }
	   
	   // Desc.: Returns all matches of input player (id) arranged in the output array (sorted by date, most recent first).
	   // Input: The id of the tennis player.
	   // Output: Throws an unchecked (non-critical) exception if there are no tennis matches in the list.
	   public TennisMatch[] getMatchesOfPlayer( String playerId ) throws TennisDatabaseRuntimeException{
		   
		   TennisMatch[] matches = new TennisMatch[this.currNumMatches];
		      for(int i = 0; i<this.currNumMatches; i++){
		         if (playerId.equals(this.array[i].getIdPlayer1()))
		         {
		            matches[i]= this.array[i];
		         }
		         if (playerId.equals(this.array[i].getIdPlayer2()))
		         {
		            matches[i]= this.array[i];
		         }

		      }
		      return matches;
	   }
	   

}
