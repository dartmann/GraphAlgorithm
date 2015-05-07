
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
	
	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	private String name;
	
	/**
	 * empty constructor
	 */
	public Graph() {
		this.edges = new ArrayList<Edge>();
		this.vertices = new ArrayList<Vertex>();
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor to add {@link Vertex}es, {@link Edge}s without a given name.
	 * The actual timestamp will be used as name.
	 * @param vertexes
	 */
	public Graph(ArrayList<Vertex> vertexes) {
		this.vertices = new ArrayList<Vertex>();
		for(Vertex vertex : vertexes) {
			this.addVertex(vertex);
		}
		this.edges = new ArrayList<Edge>();
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor to add {@link Vertex}es, {@link Edge}s and a given name.
	 * @param vertexes
	 */
	public Graph(ArrayList<Vertex> vertexes, String name) {
		for(Vertex vertex : vertexes) {
			this.addVertex(vertex);
		}
		this.edges = new ArrayList<Edge>();
		this.name = name;
	}
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s without name.
	 * The actual timestamp will be used as name.
	 * @param vertexes
	 * @param edges
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges) {
		for(Vertex vertex : vertexes) {
			this.addVertex(vertex);
		}
		for(Edge edge : edges) {
			this.addEdge(edge);
		}
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor to add {@link Vertex}es and {@link Edge}s.
	 * @param vertexes
	 * @param edges
	 */
	public Graph(ArrayList<Vertex> vertexes, ArrayList<Edge> edges, String name) {
		for(Vertex vertex : vertexes) {
			this.addVertex(vertex);
		}
		for(Edge edge : edges) {
			this.addEdge(edge);
		}
		this.name = name;
	}
	
	/**
	 * Constructor for a given {@link Graph}.
	 * @param graph
	 */
	public Graph(Graph graph) {
		this.edges = graph.getEdges();
		this.vertices = graph.getVertices();
		this.name = graph.getName();
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
				neighbours.add(e.getVertex());
			}
			if (e.getVertex2().getName().equals(vertex.getName())) {
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
		return vertices.size();
	}
	
	/**
	 * Method to check if a specific {@link Vertex} exists.
	 * @param vertex
	 * @return
	 */
	public boolean containsVertex(Vertex vertex) {
		for(Vertex v : vertices) {
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
		for(Edge e : edges) {
			if ((e.getVertex().getName().equals(edge.getVertex().getName()) && 
					e.getVertex2().getName().equals(edge.getVertex2().getName())) 
				|| 
				(e.getVertex().getName().equals(edge.getVertex2().getName()) && 
						e.getVertex2().getName().equals(edge.getVertex().getName()))) {
				return true;			
			}
		}
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
	 * Method to add a new Vertex to the {@link #vertices}.
	 * @param vertex
	 */
	public boolean addVertex(Vertex vertex) {
		if (!containsVertex(vertex)) {
			vertices.add(vertex);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to remove a vertex from the {@link #vertices}.
	 * @param vertex
	 * @return
	 */
	public boolean removeVertex(Vertex vertex) {
		if (containsVertex(vertex)) {
			vertices.remove(vertex);
			removeEdgesByVertice(vertex);
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
		if (!edge.getVertex().getName().equals(edge.getVertex2().getName())) {
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
		return false;
	}
	
	/**
	 * Method to remove an {@link Edge} from the {@link #edges}.
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
	 * Method to remove all {@link Edge}s in dependency of a given {@link Vertex}.
	 * @param vertex
	 * @return
	 */
	private ArrayList<Edge> removeEdgesByVertice(Vertex vertex) {
		ArrayList<Edge> removedEdges = new ArrayList<Edge>();
		for(Edge edge : edges) {
			if (edge.getVertex().getName().equals(vertex.getName()) || 
					edge.getVertex2().getName().equals(vertex.getName())) {
				edges.remove(vertex);
				removedEdges.add(edge);
			}
		}
		return removedEdges;
		
	}
	
	/**
	 * Method to check if two {@link Vertex}es have an relation due an common {@link Edge}.
	 * @param vertex
	 * @param vertex2
	 * @return
	 */
	public boolean checkAdjacency(Vertex vertex, Vertex vertex2) {
		return containsEdge(new Edge(vertex, vertex2));
	}
	
	/**
	 * Method to add an existant {@link Graph} to another one.
	 * Here all {@link Vertex}es and {@link Edge}s got added.
	 * @param graph
	 * @return
	 */
	public Graph union(Graph graph) {
		Graph union = new Graph(this.vertices, this.edges, "G_"+new Date().getTime());
		for(Edge edge : graph.edges) {
			union.addEdge(edge);
		}
		for(Vertex vertex : graph.vertices) {
			union.addVertex(vertex);
		}
		return union;
	}
	
	/**
	 * Method to export this {@link Graph} into the format which is needed for the GraphViz
	 */
	public StringBuilder exportGraphToViz() {
		StringBuilder stringBuilder = new StringBuilder("graph "+this.getName()+" {\n");
		// maybe also the vertexes?
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
	public boolean hasCycle() {
		Graph save = new Graph(this);
		save.checkCycle();
		return save.countEdges() > 1;
	}
	
	/**
	 * helper method for {@link #hasCycle()}.
	 */
	private void checkCycle() {
		for(int i = 0; i < vertices.size(); i++) {
			Vertex v = vertices.get(i);
			if(getNeighbours(v).size() <= 1) {
				// remove vertex from every edge
				for(int j = 0; j < edges.size(); j++) {
					if (edges.get(j).getVertex().getName().equals(v.getName()) || 
							edges.get(j).getVertex2().getName().equals(v.getName())) {
						edges.remove(j);
					}
				}
			} else {
				System.out.println(vertices.get(i).getName()+" hat Nachbarn: "+getNeighbours(vertices.get(i)).size());
			}
		}
		System.out.println("Zum Ende: "+countEdges());
	}
	
	/**
	 * Method to check if the {@link Graph} is bipartite.
	 * This means, it has two partitions. 
	 * The Vertices in those partitions do not have a common edge inside their partition.
	 * @return
	 */
	public boolean isBipartite() {
		return false;
	}
	
	/**
	 * Method to check if the {@link Graph} is complete.
	 * This is done by checking, if it contains (n*(n-1))/2 edges,
	 * where n represents the amount of edges.
	 * @return
	 */
	public boolean isComplete() {
		return ((vertices.size()*(vertices.size()-1))/2) == edges.size();
	}
	
	/**
	 * Method to return an adjacency matrix in form of an two dimensional int array.
	 * each column and row has either 1 or 0 standing for an edge between those two vertices.
	 * @return
	 */
	public Adjacencymatrix getAdjacencyMatrix() {
		int numberOfVertives = vertices.size();
		Adjacencymatrix adjacencymatrix = new Adjacencymatrix(numberOfVertives, getName(), getVertices());
		boolean[][] cache = adjacencymatrix.getMatrix();
		for(int i = 0; i < numberOfVertives; i++) {
			for(int j = 0; j < numberOfVertives; j++) {
				boolean isAdjacent = checkAdjacency(vertices.get(i), vertices.get(j));
				cache[i][j] = isAdjacent;
			}
		}
		adjacencymatrix.setMatrix(cache);
		return adjacencymatrix;
	}
	
	/**
	 * Method for returning a complemented version of this {@link Graph}.
	 * This means, all edges which exists, get destroyed and all not existing get created.
	 * In other words, my adjency matrix gets inverted.
	 * @return
	 */
	public Graph getComplement() {
		boolean[][] cache = getAdjacencyMatrix().getMatrix();
		for(int i = 0; i < cache.length; i++) {
			for(int j = 0; j < cache[i].length; j++) {
				if (cache[i][j] == true) {
					cache[i][j] = false;
				} else {
					cache[i][j] = true;
				}
			}
		}
		getAdjacencyMatrix().setMatrix(cache);
		return null;
	}
	
	/**
	 * Simple getter for {@link #edges}.
	 * @return
	 */
	public ArrayList<Edge> getEdges() {
		return this.edges;
	}
	
	/**
	 * Simple getter for {@link #vertices}.
	 * @return
	 */
	public ArrayList<Vertex> getVertices() {
		return this.vertices;
	}
	
	/**
	 * Method to create a Cycle with a given number of vertexes.
	 * A Cycle has only {@link Vertex}es with two neighbours.
	 * @param numberOfVertexes
	 * @return
	 */
	public static Graph createCycle(int numberOfVertices) {
		ArrayList<Vertex> vertexes = createVerticesByNumber(numberOfVertices);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < vertexes.size()-1; i++) {
			edges.add(new Edge(new Vertex("v"+i), new Vertex("v"+(i+1))));
		}
		edges.add(new Edge(new Vertex(String.valueOf("v"+(vertexes.size()-1))), 
				new Vertex("v0")));
		Graph graph = new Graph(vertexes, edges);
		return graph;
	}
	
	/**
	 * Method to generate a complete {@link Graph} with a given number of {@link Vertex}es.
	 * A complete Graph has only {@link Vertex}es with the maximal number of {@link Edge}s.
	 * @param i
	 * @return
	 */
	public static Graph createComplete(int numberOfVertices) {
		Graph graph = new Graph();
		for(int i = 0; i < numberOfVertices; i++) {
			graph.addVertex(new Vertex("v"+i));
			for(int j = 0; j < graph.getVertices().size(); j++) {
				Edge edge = new Edge(graph.getVertices().get(j), new Vertex("v"+i));
				if (!graph.containsEdge(edge)) {
					graph.addEdge(edge);
				}
			}
		}
		return graph;
	}
	
	/**
	 * Method to create a Path with the given number of {@link Vertex}es.
	 * A Path has no cycles and every {@link Vertex} has only never more than two neighbours.
	 * @param numberOfVertices
	 * @return
	 */
	public static Graph createPath(int numberOfVertices) {
		ArrayList<Vertex> vertexes = createVerticesByNumber(numberOfVertices);
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int i = 0; i < vertexes.size()-1; i++) {
			edges.add(new Edge(new Vertex("v"+i), new Vertex("v"+(i+1))));
		}
		Graph graph = new Graph(vertexes, edges);
		return graph;
	}
	
	private static ArrayList<Vertex> createVerticesByNumber(int numberOfVertices) {
		ArrayList<Vertex> list = new ArrayList<Vertex>();
		for(int i = 0; i < numberOfVertices; i++) {
			list.add(new Vertex(String.valueOf("v"+i)));
		}
		return list;
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
