import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * 
 * Class describes map for the viagogo interview exercise 
 * 
 * This file contains the main class as the main enterence of the program
 * 
 * For inquires please contact me on email below
 * 
 * @author Robert Cobb <br>
 * Bath University<br>
 * Email: rbc31@bath.ac.uk
 */
public class Map {
	
	/**
	 * List of events in map
	 */
	ArrayList<Event> events;
	
	/**
	 * Constructs a new map with random events
	 */
	public Map() {
		//limits map to 200 events
		this.events = generateEvents(200);
	}
	
	/**
	 * Creates a list of random events in a 20 by 20 area
	 * Number of events will be generated randomly between 1 and limit
	 * Each event has random ticket, with maximum of 10 tickets
	 * @param limit - The upper bound of number of events to create
	 * @return List of random events 
	 */
	private ArrayList<Event> generateEvents(int limit) {
		Random random = new Random();
		ArrayList<Event> toReturn = new ArrayList<Event>();
		//number of events to generate
		int numOfEvents = random.nextInt(limit)+1;
		
		//map keeps track of if there is an event generated at that local
		HashMap<MyPoint,Boolean> map = new HashMap<MyPoint,Boolean>();
		
		for (int i=0; i< numOfEvents;i++) {
			//get location
			int x = random.nextInt(20)-10;
			int y = random.nextInt(20)-10;
			MyPoint local = new MyPoint(x,y);
			
			//if no event there already
			if (map.get(local) == null) {
				toReturn.add(new Event("Dummy event "+i, local, generateTickets(random,10)));
				map.put(local, true);
			}else {//otherwise repeat iteration
				i--;
			}
		}
		return toReturn;
	}
	
	/**
	 * Generates a random number of tickets between 0 (inclusive and the limit)
	 * Each ticket is priced between 1(inclusive) and 101)
	 * @param rand - Underlying random object to generate data from
	 * @param limit - The upper limit of the number of events(exclusive)
	 * @return Random list of tickets
	 */
	private ArrayList<Ticket> generateTickets(Random rand, int limit) {
		int num = rand.nextInt(limit);
		ArrayList<Ticket> toReturn = new ArrayList<Ticket>(num);
		
		for (int i=0;i<num;i++) {
			double price = (100*rand.nextDouble())+1;//+1 to prevent 0 price tickets
			price = Math.round(price*100.0)/100.0; //round to 2d.p
			toReturn.add(new Ticket(price));
		}
		return toReturn;
	}
	
	/**
	 * Generates a random number of tickets between 0 (inclusive and the limit)
	 * Each ticket is priced between 1(inclusive) and 101)
	 * @param limit - The upper limit of the number of events(exclusive)
	 * @return Random list of tickets
	 */
	private ArrayList<Ticket> generateTickets(int limit) {
		return generateTickets(new Random(),limit);
	}
	
	/**
	 * Finds the closest events to the given points and returns them in sorted
	 * list (sorted descendingly by distance)
	 * If more events requested than exist, then all events are returned
	 * Implements very simple algorithm that runs in n log n time on the number of events in the
	 * world.
	 * @param point - The point to get closest location too
	 * @param numOfEvents - Number of events to find
	 * @return List of sorted events, closest to given point
	 */
	public ArrayList<Event> findnClosestEvents(MyPoint point, int numOfEvents) {
		
		//creates list of object that hold the indexes of events in the 
		//events list and holds the distance from the given point
		ArrayList<TwoVals> distAndIndexs = new ArrayList<TwoVals>(events.size());
		for (int i=0;i<events.size();i++) {
			distAndIndexs.add(new TwoVals(i,events.get(i).getLocation().manhattanDistance(point)));
		}
		
		//sorts based on distances
		Collections.sort(distAndIndexs);
		
		ArrayList<Event> toReturn = new ArrayList<Event>(numOfEvents);
		
		//get the events from the events array, using the distAndIndex
		//array to get indexes
		for (int i=0;i<Math.min(numOfEvents, this.events.size());i++) {
			toReturn.add(events.get(distAndIndexs.get(i).getA()));
		}
		return toReturn;
	}
	
	
	/**
	 * Main entrance to program, generates map then asks user to input a location
	 * and finds closest event to user
	 * @param args - command line arguments ignored
	 */
	public static void main(String [] args) {
		Map map = new Map();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter your location in the format x,y");
		
		int x,y;
		
		//get input
		//simple but should have quit mechanism
		do {
			String input;
			try {
				input = br.readLine();
			}catch (IOException e) {
				System.err.println("Encountered IO Exception, when reading from cmd");
				System.err.println("Exiting application");
				return;
			}
			//split on x and y
			String[] values = input.split(",");
			
			if (values.length > 1) {
				try {//try and parse values
					x = Integer.parseInt(values[0]);
					y = Integer.parseInt(values[1]);
					break; //exit loop
				}catch (NumberFormatException e) {
					System.err.println("Number informated incorrectly, try again");
				}
			}else {
				System.err.println("Not correctly formatted, please try again");
			}
		}while (true);
		
		
		ArrayList<Event> events = map.findnClosestEvents(new MyPoint(x,y), 5);
		for (int i=0;i<events.size();i++) {
			System.out.println(events.get(i));
		}
	}
	
}
