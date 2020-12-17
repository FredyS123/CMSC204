import java.util.Objects;

public class Town implements Comparable<Town>{
	String name;
	
	public Town(String name) {
        this.name = name;
    }
	
	Town(Town templateTown){
		this.name = templateTown.name;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public int compareTo(Town o) {
		return 0;
	}
	
	public String toString() {
		return name;
	}
	
	public int hashcode() {
		return name.hashCode();
	}
	
	public boolean equals(Object o) {
		Town town = (Town) o;
        return Objects.equals(name, town.name);
	}
}
