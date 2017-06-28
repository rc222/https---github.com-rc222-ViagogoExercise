/**
 * Class Represents a ticket in the scenario
 * 
 * Note: This is used for simplicity, in the real world
 * This class would hold more information such as id, seat location, etc.
 * 
 * @author Robert Cobb <br>
 * Bath University<br>
 * Email: rbc31@bath.ac.uk
 */
public class Ticket implements Comparable<Ticket>{

	/**
	 * Price of the ticket
	 */
	double price;
	
	/**
	 * Constructs a new ticket with the given price
	 * @param price - The price of the ticket to create
	 * @throws IllegalArgumentException Thrown if price <= 0
	 */
	public Ticket(double price) {
		if (price > 0)
			this.price = price;
		else
			throw new IllegalArgumentException("Tickets must have positive (non zero) price");
	}

	@Override
	public int compareTo(Ticket other) {
		return (int) (price - other.price);
	}
}
