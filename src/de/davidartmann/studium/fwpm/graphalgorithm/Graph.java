
package de.davidartmann.studium.fwpm.graphalgorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class of a simple undirected graph
 * @author david
 *
 */
public class Graph {
	
	private static final String FILEPATH = "resource/graphData.dot";
	private static final File FILE = new File(FILEPATH);
	
	private ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private String name;
	
	/**
	 * Constructor to add {@link Vertex}es, {@link Edge}s without a given name.
	 * The actual timestamp will be used as name.
	 * @param vertexes
	 */
	public Graph(ArrayList<Vertex> vertexes) {
		this.vertexes.addAll(vertexes);
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor to add {@link Vertex}es, {@link Edge}s and a given name.
	 * @param vertexes
	 */
	public Graph(ArrayList<Vertex> vertexes, String name) {
		this.vertexes.addAll(vertexes);
		this.name = name;
	}
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s without name.
	 * The actual timestamp will be used as name.
	 * @param vertexes
	 * @param edges
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
		this.vertexes.addAll(vertexes);
		this.edges.addAll(edges);
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s.
	 * @param vertexes
	 * @param edges
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges, String name) {
		this.vertexes.addAll(vertexes);
		this.edges.addAll(edges);
		this.name = name;
	}
	
	/**
	 * Method to retreive all neighbours of a specific vertice.
	 * @param vertex
	 * @return
	 */
	public ArrayList<Vertex> getNeighbours(Vertex vertex) {
		ArrayList<Vertex> neighbours = new ArrayList<Vertex>();
		for(Edge e : edges) {
			if (e.getVertex().getName().equals(vertex.getName())) {
				neighbours.add(e.getVertex2());
			}
		}
		return neighbours;
	}
	
	/**
	 * Method to count the amount of {@link Vertex}es.
	 * @return
	 */
	public int countVertices() {
		return vertexes.size();
	}
	
	/**
	 * Method to check if a specific {@link Vertex} exists.
	 * @param vertex
	 * @return
	 */
	public boolean containsVertex(Vertex vertex) {
		for(Vertex v : vertexes) {
			if (v.getName().equals(vertex.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to check if a specific {@link Edge} exists.
	 * @param edge
	 * @return
	 */
	public boolean containsEdge(Edge edge) {
		//TODO
		return false;
	}
	
	/**
	 * Method to get all edges of the graph.
	 * @return
	 */
	public int countEdges() {
		return edges.size();
	}
	
	/**
	 * Method to add a new Vertex to the {@link #vertexes}.
	 * @param vertex
	 */
	public boolean addVertex(Vertex vertex) {
		if (!containsVertex(vertex)) {
			vertexes.add(vertex);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to remove a vertex from the {@link #vertexes}.
	 * @param vertex
	 * @return
	 */
	public boolean removeVertex(Vertex vertex) {
		if (containsVertex(vertex)) {
			vertexes.remove(vertex);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to add a new Edge to the {@link #edges}.
	 * @param vertex
	 * @param vertex2
	 * @return
	 */
	public boolean addEdge(Edge edge) {
		if (edges.isEmpty()) {
			edges.add(edge);
			return true;
		} else {
			for(Edge e : edges) {
				// exactly identically
				if (edge.getVertex().getName().equals(e.getVertex().getName()) && 
						edge.getVertex2().getName().equals(e.getVertex2().getName())) {
					return false;
				}
				// switched positions
				if (edge.getVertex().getName().equals(e.getVertex2().getName()) &&
						edge.getVertex2().getName().equals(e.getVertex().getName())) {
					return false;
				}
			}
			edges.add(edge);
			return true;
		}
	}
	
	/**
	 * Method to remove an {@link Edge} from the {@link #edges}
	 * @param edge
	 * @return
	 */
	public boolean removeEdge(Edge edge) {
		if (edges.contains(edge)) {
			edges.remove(edge);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to check if two {@link Vertex}es have an relation due an common {@link Edge}.
	 * @param vertex
	 * @param vertex2
	 * @return
	 */
	public boolean checkAdjacency(Vertex vertex, Vertex vertex2) {
		for(Edge e : edges) {
			if (e.getVertex().getName().equals(vertex.getName()) 
					&& e.getVertex2().getName().equals(vertex2.getName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to add an existant {@link Graph} to another one.
	 * Here all {@link Vertex}es and {@link Edge}s got added.
	 * @param graph
	 * @return
	 */
	public Graph union(Graph graph) {
		Graph union = new Graph(this.vertexes, this.edges, "G_"+new Date().getTime());
		for(Edge edge : graph.edges) {
			union.addEdge(edge);
		}
		for(Vertex vertex : graph.vertexes) {
			union.addVertex(vertex);
		}
		return union;
	}
	
	/**
	 * Method to export this {@link Graph} into the format which is needed for the GraphViz
	 */
	public StringBuilder exportGraphToViz() {
		StringBuilder stringBuilder = new StringBuilder("graph "+this.getName()+" {\n");
		//TODO: maybe also the vertexes?
		for(Edge edge : this.edges) {
			stringBuilder.append("\t"+edge.getVertex().getName()+" -- "+edge.getVertex2().getName()+";\n");
		}
		stringBuilder.append("}");
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
			bufferedWriter.write(stringBuilder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder;
	}
	
	/**
	 * Method to check if the {@link Graph} contains a cycle.
	 * It uses topological sort to detect all cycles.
	 * @return
	 */
	public boolean containsCycle() {
		// first we reduce the amount of possible cycles
		ArrayList<Vertex> possibleCycleMembers = new ArrayList<Vertex>();
		for(Vertex vertex : vertexes) {
			if (getNeighbours(vertex).size() >= 2) {
				possibleCycleMembers.add(vertex);
			}
		}
		ArrayList<Vertex> stack = new ArrayList<Vertex>();
		for(Edge edge : edges) {
			// mark first edge target as visited
			stack.add(edge.getVertex2());
			
		}
		return false;
	}
	
	/**
	 * Method to create a Cycle with a given number of vertexes.
	 * A Cycle has only {@link Vertex}es with two neighbours.
	 * @param numberOfVertexes
	 * @return
	 */
	public static Graph cycle(int numberOfVertexes) {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < numberOfVertexes; i++) {
			vertexes.add(new Vertex(String.valueOf(i)));
		}
		for(int i = 0; i < vertexes.size()-1; i++) {
			edges.add(new Edge(new Vertex("v"+i), new Vertex("v"+(i+1))));
		}
		edges.add(new Edge(new Vertex(String.valueOf("v"+(vertexes.size()-1))), new Vertex("v0")));
		Graph graph = new Graph(vertexes, edges);
		return graph;
	}
	
	/**
	 * Method to generate a complete {@link Graph} with a given number of {@link Vertex}es.
	 * A complete Graph has only {@link Vertex}es with the maximal number of {@link Edge}s.
	 * @param i
	 * @return
	 */
	public static Graph getComplete(int numberOfVertexes) {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < numberOfVertexes-1; i++) {
			vertexes.add(new Vertex("v"+i));
		}
		for(Vertex vertex : vertexes) {
			Integer notAllowed = Integer.valueOf(vertex.getName().substring(1));
			for(int i = 0; i < numberOfVertexes; i++) {
				if (i != notAllowed) {
					//containsEdge(), when finished
					edges.add(new Edge(vertex, new Vertex("v"+i)));
				}
			}
					
		}
		
		Graph graph = new Graph(vertexes, edges);
		return graph;
	}
	
	/**
	 * Method to create a Path with the given number of {@link Vertex}es.
	 * A Path has no cycles and every {@link Vertex} has only never more than two neighbours.
	 * @param numberOfVertexes
	 * @return
	 */
	public static Graph createPath(int numberOfVertexes) {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < numberOfVertexes; i++) {
			vertexes.add(new Vertex(String.valueOf(i)));
		}
		for(int i = 0; i < vertexes.size()-1; i++) {
			edges.add(new Edge(new Vertex("v"+i), new Vertex("v"+(i+1))));
		}
		Graph graph = new Graph(vertexes, edges);
		return graph;
	}

	/**
	 * Getter for the {@link #name} of the {@link Graph}.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the {@link #name} of the {@link Graph}.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
