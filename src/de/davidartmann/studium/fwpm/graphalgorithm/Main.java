package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		vertexes.add(new Vertex("v1"));
		vertexes.add(new Vertex("v2"));
		vertexes.add(new Vertex("v3"));
		
		Graph graph = new Graph(vertexes);
		System.out.println(graph.countVertices());
		System.out.println(graph.countEdges());
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3"))));
		System.out.println(graph.countEdges());
		/*error checking
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v1"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v1"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v2"))));
		*/
		for(Vertex v : graph.getNeighbours(new Vertex("v2"))) {
			System.out.println(v.getName());	
		}
	}

}
