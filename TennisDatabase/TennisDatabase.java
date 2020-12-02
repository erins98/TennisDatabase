package TennisDatabase;

import java.io.*;
import java.lang.String;
import java.util.*;

/**
 * 
 * @author Erin Saijan
 * @project Assignment - CS 102
 * @Date 10/7/2020
 * 
 *
 */

 //class implementing the manager for a tennis database.
public class TennisDatabase implements TennisDatabaseInterface {
	
	private TennisPlayerContainer tpc; 
	private TennisMatchContainer tmc;
	
	//default constructor
	public TennisDatabase(){

		this.tpc = new TennisPlayerContainer(); 
		this.tmc = new TennisMatchContainer();
				
	}

	// Desc.: Loads data from file following the format described in the specifications.
	   // Output: Throws an unchecked (non-critical) exception if the loading is not fully successfull.
	   //         Throws a checked (critical) exception if the file (file name) does not exist.
	   
	public void loadFromFile( String fileName ) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		
		System.out.println("File being imported: " + fileName);
		File file = new File(fileName);
		Scanner scannerFile;
		
		//error checking for importing file
		try {
			scannerFile = new Scanner(file);
		}
		catch(Exception e) {
			throw new TennisDatabaseException("This file does not exist, good bye!");
		}
		
		//reading in file to insert match and insert player 
		while(scannerFile.hasNextLine()) {
			
			String [] str = scannerFile.nextLine().split("/");
			if(str[0].equals("MATCH")) {
				
				insertMatch( str[1], str[2], Integer.parseInt(str[3].substring(0,4)), Integer.parseInt(str[3].substring(4,6)), Integer.parseInt(str[3].substring(6)), str[4], str[5] );

			}
			else {
				
	            insertPlayer( str[1], str[2], str[3], Integer.parseInt(str[4]), str[5] );  

			}
		}
  
	}
	   
	   // Desc.: Search for a player in the database by input id, and returns a copy of that player (if found).
	   // Output: Throws an unchecked (non-critical) exception if there is no player with that input id.
	   
	public TennisPlayer getPlayer( String id ) throws TennisDatabaseRuntimeException {
		   
		   return tpc.getPlayer(id);
	}
	   
	   // Desc.: Returns copies (deep copies) of all players in the database arranged in the output array (sorted by id, alphabetically).
	   // Output: Throws an unchecked (non-critical) exception if there are no players in the database.
	   
	public TennisPlayer[] getAllPlayers() throws TennisDatabaseRuntimeException {
		
		return tpc.getAllPlayers();
	}
	   
	   // Desc.: Returns copies (deep copies) of all matches of input player (id) arranged in the output array (sorted by date, most recent first).
	   // Input: The id of a player.
	   // Output: Throws a checked (critical) exception if the player (id) does not exists.
	   //         Throws an unchecked (non-critical) exception if there are no matches (but the player id exists).
	   
	public TennisMatch[] getMatchesOfPlayer( String playerId  ) throws TennisDatabaseException, TennisDatabaseRuntimeException {
		
		return tpc.getMatchesOfPlayer(playerId);	
		}
	   
	   // Desc.: Returns copies (deep copies) of all matches in the database arranged in the output array (sorted by date, most recent first).
	   // Output: Throws an unchecked (non-critical) exception if there are no matches in the database.
	   
	public TennisMatch[] getAllMatches() throws TennisDatabaseRuntimeException {
		
		return tmc.getAllMatches();
	}
	   
	   // Desc.: Insert a player into the database.
	   // Input: All the data required for a player.
	   // Output: Throws a checked (critical) exception if player id is already in the database.
	   
	public void insertPlayer( String playerId, String firstName, String lastName, int birthYear, String country ) throws TennisDatabaseException {
		
	    TennisPlayer p = new TennisPlayer(playerId, firstName, lastName, birthYear, country);
	    tpc.insertPlayer( p );
	}

	   // Desc.: Insert a match into the database.
	   // Input: All the data required for a match.
	   // Output: Throws a checked (critical) exception if a player does not exist in the database.
	   //         Throws a checked (critical) exception if the match score is not valid.
	
	public void insertMatch( String idPlayer1, String idPlayer2, int dateYear, int dateMonth, int dateDay, String tournament, String matchScore ) throws TennisDatabaseException {
		
	     TennisMatch m = new TennisMatch( idPlayer1, idPlayer2, dateYear, dateMonth, dateDay, tournament, matchScore );
	     tmc.insertMatch(m);
	     tpc.insertMatch(m);
	}

	public int getWinsOfPlayer(String playerId) throws TennisDatabaseException{
	      
		   int wins = 0;
	       TennisMatch[] matches;
	       try{
	         
	    	   matches = tpc.getMatchesOfPlayer( playerId  ); 
	       
	       }
	      catch(Exception e){
	         throw new TennisDatabaseException("player does not exist");
	      }
	      
	      for( int i = 0; i < matches.length; i++){ 
	         
	         matches[i].getWinner();
	         
	         if( matches[i].getWinner()== 1 && matches[i].getIdPlayer1().equals(playerId)){
	         
	            wins++;
	          
	         }
	         if( matches[i].getWinner()== 2 && matches[i].getIdPlayer2().equals(playerId)){
	         
	            wins++;
	          
	         }


	         
	      }
	      
	      return wins;
	   
	}

}

