/**
 * Simple class that holds two associated values at the same time
 * 
 * values are a and b
 * 
 * Implements Comparable with itself <B> based off the second value b </B>
 * @author Robert Cobb <br>
 * Bath University<br>
 * Email: rbc31@bath.ac.uk
 *
 */
public class TwoVals implements Comparable<TwoVals> {
		private int a;
		private int b;
		
		TwoVals(int a, int b) {
			setA(a);
			setB(b);
		}
		
		public void setA(int a) {
			this.a = a;
		}
		
		public void setB(int b) {
			this.b = b;
		}
		
		public int getA() {
			return a;
		}
		
		public int getB() {
			return b;
		}

		@Override
		public int compareTo(TwoVals other) {
			return b - other.getB();
		}
}