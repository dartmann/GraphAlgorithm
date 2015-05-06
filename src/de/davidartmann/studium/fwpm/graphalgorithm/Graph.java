
package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;

/**
 * Class of a simple undirected graph
 * @author david
 *
 */
public class Graph {
	
	//private static final String FILEPATH = "resource/graphData";
	//private static final File FILE = new File(FILEPATH);
	
	private ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s
	 * @param vertexes
	 */
	public Graph(ArrayList<Vertex> vertexes) {
		this.vertexes.addAll(vertexes);
	}
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s.
	 * @param vertexes
	 * @param edges
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
		this.vertexes.addAll(vertexes);
		this.edges.addAll(edges);
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
	
	public int countVertices() {
		return vertexes.size();
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
		for(Vertex v : vertexes) {
			if (v.getName().equals(vertex.getName())) {
				return false;
			}
		}
		vertexes.add(vertex);
		return true;
	}
	
	/**
	 * Method to remove a vertex from the {@link #vertexes}.
	 * @param vertex
	 * @return
	 */
	public boolean removeVertex(Vertex vertex) {
		for(Vertex v : vertexes) {
			if (v.getName().equals(vertex.getName())) {
				vertexes.remove(vertex);
				return true;
			}
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
		//TODO
		return null;
	}
	
	/**
	 * Method to export this {@link Graph} into the format which is needed for the GraphViz
	 */
	public void exportGraphToViz() {
		//TODO
	}
	
	/**
	 * Method to check if the {@link Graph} contains a cycle.
	 * @return
	 */
	public boolean containsCycle() {
		return false;
	}
	
	/**
	 * Method to create a Cycle with a given number of vertexes.
	 * A Cycle has only {@link Vertex}es with two neighbours.
	 * @param numberOfVertexes
	 * @return
	 */
	public static Graph cycle(int numberOfVertexes) {
		//TODO
		return null;
	}
	
	/**
	 * Method to generate a complete {@link Graph} with a given number of {@link Vertex}es.
	 * A complete Graph has only {@link Vertex}es with the maximal number of {@link Edge}s.
	 * @param i
	 * @return
	 */
	public static Graph getComplete(int numberOfVertexes) {
		//TODO
		return null;
	}
	
	/**
	 * Method to create a Path with the given number of {@link Vertex}es.
	 * A Path has no cycles and every {@link Vertex} has only never more than two neighbours.
	 * @param numberOfVertexes
	 * @return
	 */
	public static Graph createPath(int numberOfVertexes) {
		//TODO
		return null;
	}

}
