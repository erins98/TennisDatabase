


// Giuseppe Turini
// CS-102, Fall 2020
// Assignment 1

package TennisDatabase;

// Interface (package-private) providing the specifications for the TennisPlayerNode class.
interface TennisPlayerContainerNodeInterface {
   
   // Accessors (getters).
   public TennisPlayer getPlayer();
   public TennisPlayerContainerNode getPrev();
   public TennisPlayerContainerNode getNext();
   
   // Modifiers (setters).
   public void setPrev( TennisPlayerContainerNode p );
   public void setNext( TennisPlayerContainerNode n );
   
   // Desc.: Insert a TennisMatch object (reference) into this node.
   // Input: A TennisMatch object (reference).
   // Output: Throws a checked (critical) exception if match cannot be inserted in this player list.
   public void insertMatch( TennisMatch m ) throws TennisDatabaseException;
   
   // Desc.: Returns all matches of this player arranged in the output array (sorted by date, most recent first).
   // Output: Throws an unchecked (non-critical) exception if there are no matches for this player.
   public TennisMatch[] getMatches() throws TennisDatabaseRuntimeException;
   
}


