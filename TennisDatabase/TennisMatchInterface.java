


// Giuseppe Turini
// CS-102, Fall 2020
// Assignment 1

package TennisDatabase;

import java.lang.String;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

// Interface (package-private) providing the specifications for the TennisMatch class.
public interface TennisMatchInterface extends Comparable<TennisMatch> {      
   // Accessors (getters).
   public String getIdPlayer1();
   public String getIdPlayer2();
   public int getDateYear();
   public int getDateMonth();
   public int getDateDay();
   public String getTournament();
   public String getMatchScore();
   public int getWinner();
   
   // Desc.: Static method to process a tennis match score (format "6-3,6-7,6-2", no spaces), iteratively.
   // Output: An integer value that could be only 1 (player 1 won) or 2 (player 2 won).
   //         Throws an unchecked (non-critical) exception if the score is invalid (no winner).
   public static int processMatchScore( String matchScore ) throws TennisDatabaseRuntimeException {
      // Check if input match score is not empty.
      if( matchScore.length() == 0 ) { 
         // Error: input match score is empty, raise a runtime error (exception).
         throw new TennisDatabaseRuntimeException( "Match score processing: match score is empty!" );
      }
      else {
         // Input match score NOT empty: convert match score ("6-3,6-7,6-2") into sets won (2-1).
         try {
            // Init local variables.
            int setsWonByPlayer1 = 0; // Count sets won by player 1.
            int setsWonByPlayer2 = 0; // Count sets won by player 2.
            int currSetIndex = 0;
            // ...
            while( matchScore.length() > 0 ) {
               // ...
               Scanner scoreScanner = new Scanner(matchScore).useDelimiter(","); // Scanner to parse the input match score.
               currSetIndex++; // Index of current set (1, 2, 3 etc.).
               String currSetScore = scoreScanner.next(); // Current set score.
               Scanner currSetScanner = new Scanner( currSetScore).useDelimiter("-"); // Scanner to parse current set score.
               int gamesWonByPlayer1 = currSetScanner.nextInt(); // Count games won by player 1.
               int gamesWonByPlayer2 = currSetScanner.nextInt(); // Count games won by player 2.
               // Process current set data to determine current set winner.
               if( gamesWonByPlayer1 > gamesWonByPlayer2 ) { 
                  // Current set won by player 1.
                  setsWonByPlayer1++; 
               }
               else if( gamesWonByPlayer1 < gamesWonByPlayer2 ) { 
                  // Current set won by player 2.
                  setsWonByPlayer2++; 
               }
               else { 
                  // Current set is a draw, invalid result, raise a runtime error (exception).
                  throw new TennisDatabaseRuntimeException( "Match score processing: set " + currSetIndex + " score is invalid!" );
               }
               // Check if input match score includes only 1 set.
               if( currSetScore.length() == matchScore.length() ) { 
                  // Check sets won to determine match winner, and return it.
                  if( setsWonByPlayer1 > setsWonByPlayer2 ) { 
                     // Player 1 won this match.
                     return 1;
                  }
                  else if( setsWonByPlayer2 > setsWonByPlayer1 ) { 
                     // Player 2 won this match.
                     return 2;
                  }
                  else { 
                     // Current match is a draw, invalid result, raise a runtime error (exception).
                     throw new TennisDatabaseRuntimeException( "Match score processing: match score is invalid!" );
                  } 
               }
               else {
                  // Input match score includes multi sets, extract rest of score, and process it.
                  matchScore = matchScore.substring( currSetScore.length() + 1 );
               }
            }
         }
         catch( InputMismatchException e ) { throw new TennisDatabaseRuntimeException( "Match score processing: invalid score!" ); }
         catch( NoSuchElementException e ) { throw new TennisDatabaseRuntimeException( "Match score processing: invalid score!" ); }
      }
      return -1; // WARNING: this return statement should never be reached!
   }
   
}

