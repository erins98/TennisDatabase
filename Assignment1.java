
import java.util.*;

import TennisDatabase.*;

/**
 * @author Erin Saijan
 * @project Assignment 1 - CS 102 
 * @date 10/7/2020 
 */
//Assignment 1 class to manage the user input-output
public class Assignment1 {

	//main function (entry point) of our Assignment 1 program for CS-102
	public static void main (String [] args){
		
		TennisDatabase tdb = new TennisDatabase(); // create an empty tennis database
		
		String fileName = (args[0]);
		
			try {
				
				//loading file
				tdb.loadFromFile( fileName );
				
			} catch (TennisDatabaseRuntimeException e) {
				
				System.out.println("Could not find the file");
				
			} catch (TennisDatabaseException e) {
				
				System.out.println("Could not find the file");
			}
		
		
		Scanner in = new Scanner(System.in); 
		int choice = 0;
	     
		//console choices
		while(choice != 6){
	         
	         System.out.println("\n\nCS-102 Tennis Manager - Available commands:");
	         System.out.println("1 --> Print all tennis players");
	         System.out.println("2 --> Print all tennis matches of a player");
	         System.out.println("3 --> Print all tennis matches");
	         System.out.println("4 --> Insert a new tennis player");
	         System.out.println("5 --> Insert a new tennis match");
	         System.out.println("6 --> Exit");
	         System.out.print("Your choice? ");
	         
	         
	         //catches incorrect input
	         try {
	        	
		         choice = Integer.parseInt(in.nextLine());
		         
	         }
	         catch(Exception e){
	        	
	        	
	         }

	         System.out.println(choice);
	         TennisMatch[] ms = null;
	         switch(choice){
	            
	         //gets all players
	         case 1:
	               
	               TennisPlayer[] ps = tdb.getAllPlayers();
	               for( int i = 0; i < ps.length; i++){
	                   
						try {
							System.out.println(ps[i].getId() + ": " + ps[i].getFirstName() + " " + ps[i].getLastName() + " , " +  
							  
							ps[i].getBirthYear() + " , " + ps[i].getCountry() +  " , " + tdb.getWinsOfPlayer(ps[i].getId()) + " / " + 
							  
							  (tdb.getMatchesOfPlayer( ps[i].getId()).length - tdb.getWinsOfPlayer(ps[i].getId())));
						} catch (Exception e) {
							
							System.out.println("Could not list players, try again!");
							choice = 0;
						}
	               }
	            
	               break;
	               
	         //gets all matches of a certain player   
	         case 2:
	              System.out.print("Enter Player Id: ");
	              String id = ""; 
	              
	              try {
	            	  
	            	  id = in.nextLine().toUpperCase();
	            	  System.out.println(id);
	              }
	              catch(NullPointerException e){
	            	  
	            	  System.out.println("That player could not be found");
	              }
	               
				try {
					
					ms = tdb.getMatchesOfPlayer( id );
				} catch (Exception e) {
				
					
					choice = 0;
				}
				
	            try { 
					for( int i = 0; i < ms.length; i++){
		                   System.out.println(ms[i].getDateYear() + "/ " + ms[i].getDateMonth() + " / " + ms[i].getDateDay() + " , " + 
		                  
		                  tdb.getPlayer(ms[i].getIdPlayer1()).getFirstName().substring(0,1) + " . " + tdb.getPlayer(ms[i].getIdPlayer1()).getLastName() + " - " +
		                  tdb.getPlayer(ms[i].getIdPlayer2()).getFirstName().substring(0,1) + " . " + tdb.getPlayer(ms[i].getIdPlayer2()).getLastName() + ", " +
		                  ms[i].getTournament()+ " , " + ms[i].getMatchScore());  
		                  
		              }
	            } catch(NullPointerException e ){
	            	
	            	System.out.println("Cannot find that player, try again");
	            	choice = 0;
	            }
	            
	   
	   
	            
	            
	              break;
	               
	         //prints all tennis matches   
	         case 3:
	            
	            	ms = tdb.getAllMatches();
	                for( int i = 0; i < ms.length; i++){
	                	
	                	System.out.println(ms[i].getDateYear() + "/ " + ms[i].getDateMonth() + " / " + ms[i].getDateDay() + " , " + 
	                  
	                  	tdb.getPlayer(ms[i].getIdPlayer1()).getFirstName().substring(0,1) + " . " + tdb.getPlayer(ms[i].getIdPlayer1()).getLastName() + " - " +
	                  	tdb.getPlayer(ms[i].getIdPlayer2()).getFirstName().substring(0,1) + " . " + tdb.getPlayer(ms[i].getIdPlayer2()).getLastName() + ", " +
	                  	ms[i].getTournament()+ " , " + ms[i].getMatchScore());
	                  
	                }
	            
	              
	   
	                break;
	               
	         //inserts a new tennis player  
	         case 4:
	              
	            	System.out.print("Enter Player Id: ");
	            	String pid = in.nextLine().toUpperCase();
	            	System.out.print("Enter Player First Name: ");
	            	String firstName = in.nextLine().toUpperCase();
	            	System.out.print("Enter Player Last Name: ");
	            	String lastName = in.nextLine().toUpperCase();
	            	System.out.print("Enter Player Birth Year: ");
	            	String year = in.nextLine().toUpperCase();
	            	System.out.print("Enter Player Country: ");
	            	String country = in.nextLine().toUpperCase();
	   
				try {
					tdb.insertPlayer( pid, firstName, lastName,Integer.parseInt(year), country );
				} catch (NumberFormatException e) {
					System.out.println("Could not insert that player");
				} catch (TennisDatabaseException e) {
					
					System.out.println("Could not insert that player");
				}
	               
	            
	            	break;
	               
	         //inserts a new tennis match  
	         case 5:
	               
	              
	            	System.out.print("Enter Player Id1: ");
	            	String pid1 = in.nextLine().toUpperCase();
	            	System.out.print("Enter Player Id2: ");
	            	String pid2 = in.nextLine().toUpperCase();
	            	System.out.print("Enter Match Year: ");
	            	String mYear = in.nextLine().toUpperCase();
	            	System.out.print("Enter Match Month: ");
	            	String mMonth = in.nextLine().toUpperCase();
	            	System.out.print("Enter Match Day: ");
	            	String mDay = in.nextLine().toUpperCase();
	            	System.out.print("Enter Tournament: ");
	            	String tournament = in.nextLine().toUpperCase();
	            	System.out.print("Enter Scores: ");
	            	String scores = in.nextLine().toUpperCase();

	   
	            
				try {
					tdb.insertMatch( pid1, pid2, Integer.parseInt(mYear), Integer.parseInt(mMonth), Integer.parseInt(mDay),  tournament, scores );
				} catch (NumberFormatException e) {
					
					System.out.println("Could not insert match");
				} catch (TennisDatabaseException e) {
					
					System.out.println("Could not insert match");
				}
	               
	            
	            	break;
	               
	         //exits program  
	         case 6:
	            	break;
	               
	            default: 
	            	System.out.println("Invalid Choice!\n");
	               
	            	break;
	               
	         	}
	      	}
   
	}

}
