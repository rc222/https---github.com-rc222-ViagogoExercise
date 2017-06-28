import java.awt.Point;

/**
 * Class represents a point in the scenario
 * 
 * Class overrides the Point class providing a comprehensible 
 * {@link #toString()} method and a {@link #manhattanDistance(MyPoint)} method to calculate 
 * the distance between 2 points.
 * 
 * @author Robert Cobb <br>
 * Bath University<br>
 * Email: rbc31@bath.ac.uk
 *
 */
public class MyPoint extends Point {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a point at the given x and y coordinates
	 * @param x - The x coordinate of the constructed point
	 * @param y - The Y coordinate of the constructed point
	 */
	public MyPoint(int x, int y) {
		super(x,y);
	}
	
	/**
	 * Returns string of coordinates in brackets
	 */
	@Override
	public String toString() {
		return "(" + this.getX() + ',' + this.getY() + ')';
	}
	
	/**
	 * Calculates the Manhattan distance between this point and the given point
	 * more on Manhattan distance: https://en.wiktionary.org/wiki/Manhattan_distance
	 * @param otherPoint - The point to calculate the distance between
	 * @return the Manhattan distance between this point and the given point
	 */
	public int manhattanDistance(MyPoint otherPoint) {
		return Math.abs(otherPoint.x - this.x) +  Math.abs(otherPoint.y - this.y); 
	}
}
