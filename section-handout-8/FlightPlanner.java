import java.io.*;
import java.util.*;
import acm.program.*;


public class FlightPlanner extends ConsoleProgram {
	
	public void run() {
		
		/* Initialise the instance variables */
		dataStructure = new HashMap<String,ArrayList<String>>();
		flightPlan = new ArrayList<String>();
		
		/* Create a data structure (a HashMap of ArrayLists) of the possible 
		 * flight routes, as read in from the text file */
		readFileAndPopulateDataStructure("flights.txt");
		
		/* Display the welcome message and list of departure cities, then make 
		 * the user pick a starting city from the list */
		displayWelcomeAndCompleteCityList();
		String startCity = getUserStartCity();
		
		/* Get the user to pick the stops on the round trip */
		planRoute(startCity);
		
		/* Print the user selected route for the round trip */
		printRoute();		
	}
	
	
	/* Method: printRoute() */
	/** 
	 * Creates and prints a String consisting of each City the user has selected
	 * (as stored in the flightPlan Array List), separated by arrows
	 */
	private void printRoute() {
		
		/* Initialise the route String to be printed */
		String route = "";
		
		/* Create the String to be printed by concatenating all user selected
		 * cities (as stored in the flightPlan ArrayList) */
		for(int i = 0; i < flightPlan.size(); i++) {
			route += flightPlan.get(i) + " -> ";
		}
		route += flightPlan.get(0);
		
		/* Print the route */
		println("The route you've chosen is:");
		println(route);	
	}
	
	
	/* Method: getUserStartCity() */
	/**
	 * Retrieves the starting the starting city from the user, ensuring it is a valid
	 * choice (i.e. from the list of possibles in the text file)
	 */
	private String getUserStartCity() {
		
		/* Prompt the user to enter the starting city */
		String startCity = readLine("Enter the starting city: ");
		
		/* Iterate over the potential starting cities as read from the text file,
		 * returning the city if it matches the user's selection. If the end is reached
		 * and no city matched, prompt the user to choose again */
		while(true) {
			for (String key: dataStructure.keySet()) {
				if ( key.toLowerCase().equals( startCity.toLowerCase() ) ) {
					return key;
				}
			}
			startCity = readLine("Please enter a starting city from the list: ");
		}
	}

	
	/* Method: planRoute(String) */
	/**
	 * Plans a round-trip route starting from the city passed in as a parameter,
	 * by making the user select subsequent destinations (from a list of possibles
	 * each time, based on the text file) until the destination equals the starting city. 
	 * Each valid destination the user enters (including the start city) is stored in an 
	 * Array List.
	 */
	private void planRoute(String startCity) {
		
		/* Set the first departure city to the city passed in as a parameter */
		String departureCity = startCity;
		
		/* Continue prompting the user to select from the list of possible destinations
		 * until the destination selected is the same as the starting city (i.e. round
		 * trip is complete), adding each selection to an Array List */
		while(true) {
			
			/* Add the current departure city to the Array List */
			flightPlan.add(departureCity);
			
			/* Print the list of possible destinations for the current departure city */
			println("From " + departureCity + " you can fly directly to:");
			for (String destination: dataStructure.get(departureCity)) {
				println(destination);
			}
			
			/* Get the user to select a destination from the list of possibles, and set
			 * the departure city to this */
			departureCity = getUserSelectedDestination(departureCity);
			
			/* Break out of the while loop if the selected city is the same as the city 
			 * passed in as a parameter (the start city) */
			if( departureCity.equals(startCity) ) {
				break;
			}
		}
	}
	
	
	/* Method: getUserSelectedDestination(String) */
	/**
	 * Returns a user selected city from a list of possible destinations generated from
	 * the departure city passed in as a parameter.
	 */
	private String getUserSelectedDestination(String departureCity) {
		
		/* Prompt the user to make a selection */
		String userSelectedDestination = readLine("Where do you want to go from " + departureCity + "? ");	
		
		/* Return the user's selection if it matches any of the possible destinations of the
		 * city passed in as a parameter, or prompt the user to make the selection again if
		 * no match */
		while(true) {
			for (String destination: dataStructure.get(departureCity)) {
				if(destination.toLowerCase().equals(userSelectedDestination.toLowerCase())) {
					return destination;
				}
			}
			userSelectedDestination = readLine("Please enter a destination from the list: ");
		}
		
	}

	
	/* Method: displayWelcomeAndCompleteCityList() */
	/**
	 * Displays the welcome message and prints out the full list of cities the user can
	 * start their trip from
	 */
	private void displayWelcomeAndCompleteCityList() {
		println("Welcome to Flight Planner!");
		println("Here's a list of all the cities in our database:");
		for(String key: dataStructure.keySet()) {
			println(key);
		}
		println("Let's plan a round-trip route!");
	}

	
	/* Method: readFileAndPopulateDataStructure(String) */
	/**
	 * Reads in the file given by the filename passed in as a parameter, storing the departure 
	 * cities in it as keys in a HashMap, with an Array List of possible destinations for each
	 * as the items
	 */
	private void readFileAndPopulateDataStructure(String fileName) {
		try {
			/* Create a BufferedReader object for the file with name given by the parameter */
			BufferedReader rd = new BufferedReader(new FileReader(fileName));
			
			/* Continue reading lines and storing in the data structure until no lines left */
			while(true) {
				
				/* Get the next line from the text file, break if there is none */
				String line = rd.readLine();
				if(line == null)
					break;
				
				/* Split the line into a key (departure city) and a destination */
				String key = line.substring( 0, line.indexOf(" -> ") );
				String destination = line.substring( line.indexOf(" -> ") + 4 );
				
				/* If the Hash Map already contains the key (departure city), add the destination 
				 * to its existing ArrayList of destinations. If not, create the key and its 
				 * ArrayList, with the destination being the first entry */
				if( dataStructure.containsKey(key) ) {
					dataStructure.get(key).add(destination);
				} else {
					ArrayList<String> aList = new ArrayList<String>();
					aList.add(destination);
					dataStructure.put(key, aList);
				}
			}		
		} catch (IOException ex) {
			println("Can't find that file");
		}
	}
	
	
	/* Instance variable for the dataStructure used to store the potential departure city and 
	 * destinations */
	private HashMap<String,ArrayList<String>> dataStructure;
	
	
	/* Instance variable for the Array List used to store the user's selected route */
	private ArrayList<String> flightPlan;
	
}
