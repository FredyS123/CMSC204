import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	final int NoEdge = Integer.MAX_VALUE;
	final int NoPath = Integer.MAX_VALUE;
	
	private ArrayList<String> shortestPath = new ArrayList<>();
	private Set<Town> towns = new HashSet<>();
	private Set<Road> roads = new HashSet<>();
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road road = null;
    	
		for(Road r: roads) {
    		if(r.getSource().equals(sourceVertex) && r.getDestination().equals(destinationVertex)) {
    			road = r;
    		}
    	}
    	return road;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road;
		
		if(sourceVertex == null || destinationVertex == null)
    		throw new NullPointerException("One vertice is null");
		
		road = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(road);
		return road;
	}

	@Override
	public boolean addVertex(Town v) {
		boolean tf = false;
		
		if(v == null)
			throw new NullPointerException("The specified vertex is null");
		
		if(!towns.contains(v)) {
			towns.add(v);
			tf =  true;
			}
		
		if(towns.contains(v))
			tf = false;
		
		return tf;
	}

	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		boolean tf = false;
		
		for(Road temp : roads) {
			if(temp.contains(sourceVertex) && temp.contains(destinationVertex))
				tf = true;
		}
		tf = false;
		
		return tf;
	}

	public boolean containsVertex(Town v) {
		boolean tf = false;
		
		for(Town temp : towns) {
			if(temp.getName().equals(v.getName()))
				tf = true;
		}
		tf = false;
		
		return tf;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		if(vertex == null)
    		throw new NullPointerException("Vertex is null");
		
		Set<Road> temp; 
		temp = new HashSet<>();
				for(Road r : roads) {
					if(r.contains(vertex)) 
						temp.add(r);
				}
		return temp;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(weight < 0) {
    		throw new RuntimeException("Weight is not valid");
    	}
    	if(description == null)
    		throw new RuntimeException("Description is null");
    	
    	Road road = null;
		for(Road r : roads) {
			if(r.contains(destinationVertex)&& r.contains(sourceVertex) 
					&&(weight >-1) && description !=null)
				road = r;
		}
		if (roads.remove(road))
			return road;
		else return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		return towns.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}
