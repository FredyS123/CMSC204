
public class Road implements Comparable<Road>{

	Town source = null, destination = null;
	String name = "";
	int degrees = 0;
	
	Road(Town source, Town destination, int degrees, String name){
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
		this.name = name;
	}
	
	Road(Town source, Town destination, String name){
		this.source = source;
		this.destination = destination;
		this.degrees = 1;
		this.name = name;
	}
	
	public boolean contains(Town t) {
		return this.source.equals(t) || this.destination.equals(t);
	}

	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Town getDestination() {
		return this.destination;
	}
	
	public Town getSource() {
		return this.source;
	}
	
	public int getWeight() {
		return degrees;
	}
	
	@Override
	public int compareTo(Road o) {
		return this.getWeight() - o.getWeight();
	}
}
