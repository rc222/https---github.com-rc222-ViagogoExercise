import java.util.ArrayList;
import java.util.Collections;

/**
 * Class describes an Event in the world <br>
 * 
 * 
 * @author Robert Cobb <br>
 * Bath University<br>
 * Email: rbc31@bath.ac.uk
 *
 */
public class Event {
	
	
	/**
	 * Simple variable to make id's, incremented after each id,
	 * Note: Not necessarily a smart way of making id's but simple and 
	 * Usable for this scenario
	 */
	private static long idCounter = 0;
	
	/**
	 * Unique id of object
	 */
	private long   				id;
	
	/**
	 * Name of event, not required to be unique
	 */
	private String 				name;
	
	/**
	 * Location in 2d world of event
	 */
	private MyPoint 			location;
	
	/**
	 * List of tickets for the event, is sorted
	 */
	private ArrayList<Ticket>	tickets;
	
	/**
	 * Constructs an event with the given name, location id and set of tickets
	 * @param name - name of event created
	 * @param location - location in 2d world of event
	 * @param tickets
	 */
	public Event (String name, MyPoint location, ArrayList<Ticket> tickets) {

		if (tickets != null) {
			Collections.sort(tickets);
			this.tickets = tickets;
		}
		else 
			throw new NullPointerException("Tickets structure can not be null");
		
		setName(name);
		setLocation(location);
		this.id = Event.idCounter++;
	}
	
	/**
	 * Sets the name of the event
	 * @param name - The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the location of the event
	 * @param location - location of event
	 */
	public void setLocation(MyPoint location) {
		this.location = location;
	}
	
	/**
	 * Returns the name of the event
	 * @return The name of the event
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Returns the location of the event
	 * @return The location of the event
	 */
	public MyPoint getLocation() {
		return this.location;
	}
	
	
	/**
	 * Returns a String representation of the event
	 */
	@Override
	public String toString() {
		return getName() + " at " + 
			(location == null ? "(no recorded location)":this.location) + 
			" with " + 
			(tickets == null ? "0":tickets.size()) + 
			" tickets, cheapest ticket: " +
			getCheapestTicketPrice();
	}
	
	/**
	 * Returns the cheapest ticket, or null if no tickets exists
	 * @return The cheapest ticket, or null if no tickets exists
	 */
	public Ticket getCheapestTicket() {
		return tickets == null || tickets.size() == 0 ? null : tickets.get(0);
	}
	
	/**
	 * Returns price of the cheapest ticket available prefixed with a '$' symbol, or "no tickets" if none exist
	 * @return The price of the cheapest ticket available prefixed with a '$' symbol, or "no tickets" if none exist
	 */
	private String getCheapestTicketPrice() {
		return tickets == null || tickets.size() == 0 ? "no tickets" : "$" + tickets.get(0).price;
	}
	
	/**
	 * Returns the unique id of the object
	 * @return The unique id of the object
	 */
	public long getId() {
		return this.id;
	}
}
