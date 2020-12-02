package TennisDatabase;

/**
 * 
 * @author Erin Saijan
 * @project Assignment - CS 102
 * @Date 10/7/2020
 * 
 *
 */

public class TennisMatch implements TennisMatchInterface {
	
	//instance variables
	private int dateYear;
	private int dateMonth;
	private int dateDay;
	private String idPlayer1;
	private String idPlayer2;
	private String matchScore;
	private String tournament;
	private int winner;
	
	//default constructor 
	
	//constructor with input
	public TennisMatch( String idPlayer1, String idPlayer2, int dateYear, int dateMonth, int dateDay, String tournament, String matchScore ) {
		
		this.dateYear = dateYear;
		this.dateMonth = dateMonth;
		this.dateDay = dateDay;
		this.idPlayer1 = idPlayer1;
		this.idPlayer2 = idPlayer2;
		this.matchScore = matchScore;
		this.tournament = tournament;
		
	}
	
	//getters
	public int getDateYear() {

		return this.dateYear;
	}

	public int getDateMonth() {

		return this.dateMonth;
	}

	public int getDateDay() {

		return this.dateDay;
	}

	public String getIdPlayer1() {

		return this.idPlayer1;
	}

	public String getIdPlayer2() {

		return this.idPlayer2;
	}

	public String getMatchScore() {
	
		return this.matchScore;
	}

	public String getTournament() {
		
		return this.tournament;
	}
	
	public int getWinner() {
		
		return this.winner;
	}

	@Override
	public int compareTo(TennisMatch other) {

		if(this.dateYear > other.dateYear) {
			
			return 1;
		}
		else if(this.dateYear < other.dateYear) {
			
			return -1;
		}
		else if(this.dateMonth > other.dateMonth) {
			
			return 1;
		}
		else if(this.dateMonth < other.dateMonth) {
			
			return -1;
		}
		else if(this.dateDay > other.dateDay) {
			
			return 1;
			
		}
		else if (this.dateDay < other.dateDay) {
			
			return -1;
		}
		else {
			
			return -1;
		}
		
	}
	
	public int findWinner(String scores){
	      
		if (scores.length() == 3){
	         
			if  (Integer.parseInt(scores.substring(0,1))  <  Integer.parseInt(scores.substring(2,3))) {
	      
	            return -1;   
	      
	         }
	      
	         else {
	      
	            return 1;
	            
	         }
	     }
	      
	     else {
	    	 
	         String set = scores.substring(0,3);
	         return findWinner(set) + findWinner(scores.substring(4));  
	   
	      }
	  
	  }
	public String toString() {
		return this.idPlayer1;
	}


}
