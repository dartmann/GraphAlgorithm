package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
		vertexes.add(new Vertex("v1"));
		vertexes.add(new Vertex("v2"));
		vertexes.add(new Vertex("v3"));
		
		Graph graph = new Graph(vertexes);
		//System.out.println(graph.countVertices());
		//System.out.println(graph.countEdges());
		graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2")));
		graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3")));
		graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3")));
		//System.out.println(graph.countEdges());
		/*error checking
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v1"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v1"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3"))));
		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v2"))));
		
		for(Vertex v : graph.getNeighbours(new Vertex("v1"))) {
			System.out.println(v.getName());	
		}
		System.out.println(graph.checkAdjacency(new Vertex("v1"), new Vertex("v2")));
		*/
		ArrayList<Vertex> vertexes2 = new ArrayList<Vertex>();
		vertexes2.add(new Vertex("v4"));
		vertexes2.add(new Vertex("v5"));
		vertexes2.add(new Vertex("v6"));
		Graph graph2 = new Graph(vertexes2);
		//graph2.addEdge(new Edge(new Vertex("v4"), new Vertex("v5")));
		Graph graphUnion = graph.union(graph2);
		System.out.println(graphUnion.countEdges());
		System.out.println(graphUnion.countVertices());
		System.out.println(graphUnion.exportGraphToViz());
		/*
		System.out.println(Graph.cycle(10).exportGraphToViz());
		System.out.println(Graph.createPath(10).exportGraphToViz());
		System.out.println(Graph.getComplete(5).exportGraphToViz());
		*/
	}

}
