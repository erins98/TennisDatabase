package TennisDatabase;

/**
 * 
 * @author Erin Saijan
 * @project Assignment - CS 102
 * @Date 10/7/2020
 * 
 *
 */

public class TennisPlayer implements TennisPlayerInterface{
	
	//instance variables 
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private String country;
	
	//default constructor
	public TennisPlayer() {
		this.id = "No ID";
		this.firstName = null;
		this.lastName = null;
		this.birthYear = 0;
		this.country = null;
	
	}
	public TennisPlayer(String id, String firstName, String lastName, int birthYear, String country) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.country = country;
		
	}
	
	public TennisPlayer(TennisPlayer other) {
		
		 this.id = other.getId();
		 this.firstName = other.getFirstName();
		 this.lastName = other.getLastName();
		 this.birthYear = other.getBirthYear();
		 this.country = other.getCountry();
		
	}

	public String getId() {
		
		return this.id;
	}

	public String getFirstName() { 
		
		return this.firstName;
	}

	public String getLastName() {
		
		return this.lastName;
	}

	public int getBirthYear() {
		
		return this.birthYear;
	}

	public String getCountry() {
	
		return this.country;
	}

	@Override
	public int compareTo(TennisPlayer other) {
		
		String s1 = this.id;
		String s2 = other.id;
		
		if(s1.equals(s2)) {
			return 0;
		}
		
		for(int i = 0; true; i++) {
			
			if(i > s1.length()) {
				
				return -1;
			}
			if(i > s2.length()) {
				
				return 1;
			}
			if(s1.charAt(i) > s2.charAt(i)) {
				
				return 1;
			}
			if(s1.charAt(i) < s2.charAt(i)) {
				
				return -1;
			}
		}

	}

}
