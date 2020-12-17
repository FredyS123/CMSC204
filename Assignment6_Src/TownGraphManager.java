import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{

	private Graph graph = new Graph();

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		boolean added = false;
		Town T1, T2;
		T1 = new Town(town1);
		T2 = new Town(town2);
		
		while( graph.addEdge(T1, T2, weight, roadName) != null)
			added = true;
		return added;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town T1, T2;
		T1 = new Town(town1); 
		T2 = new Town(town2);
		
		return graph.getEdge(T1, T2).getName();
	}

	@Override
	public boolean addTown(String v) {
		Town t1 = new Town(v); 
		
		return graph.addVertex(t1);
	}

	@Override
	public Town getTown(String name) {
		Town t = new Town(name);
		while(Graph.containsVertex(t)) {
			return t;
		}
		return t;
	}

	@Override
	public boolean containsTown(String v) {
		Town t = new Town(v);
		return Graph.containsVertex(t);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town T1 = new Town(town1);
		Town T2 = new Town(town2);
		return Graph.containsEdge(T1,T2);
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> temp = new ArrayList<>();
		for(Road r : graph.edgeSet())
			temp.add(r.getName());
		Collections.sort(temp);
		return temp;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town T1 = new Town(town1);
		Town T2 = new Town(town2);
		
		Road removed = Graph.removeEdge(T1, T2, 0, road);
		if(removed != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteTown(String v) {
		Town t1 = new Town(v); 
		
		return graph.removeVertex(t1);
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> temp = new ArrayList<>();
		for(Town t : graph.vertexSet())
			temp.add(t.getName());
		Collections.sort(temp);
		return temp;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town T1 = new Town(town1); 
		Town T2 = new Town(town2);
		return graph.shortestPath(T1, T2) ;
	}

}
