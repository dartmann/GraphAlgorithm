package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
//		ArrayList<Vertex> vertexes = new ArrayList<Vertex>();
//		vertexes.add(new Vertex("v1"));
//		vertexes.add(new Vertex("v2"));
//		vertexes.add(new Vertex("v3"));
//		
//		Graph graph = new Graph(vertexes);
//		System.out.println(graph.countVertices());
//		System.out.println(graph.countEdges());
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v2"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v1"))));
//		System.out.println(graph.countEdges());
//		error checking
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v2"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v1"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v1"), new Vertex("v3"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v1"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v2"), new Vertex("v3"))));
//		System.out.println(graph.addEdge(new Edge(new Vertex("v3"), new Vertex("v2"))));
//		
//		for(Vertex v : graph.getNeighbours(new Vertex("v1"))) {
//			System.out.println(v.getName());	
//		}
//		System.out.println(graph.checkAdjacency(new Vertex("v1"), new Vertex("v2")));
//		
//		graph2.addEdge(new Edge(new Vertex("v6"), new Vertex("v4")));
//		graph2.addEdge(new Edge(new Vertex("v4"), new Vertex("v5")));
//		Graph graphUnion = graph.union(graph2);
//		System.out.println(graphUnion.countEdges());
//		System.out.println(graphUnion.countVertices());
//		System.out.println(graphUnion.exportGraphToViz());
//		System.out.println(Graph.cycle(10).exportGraphToViz());
//		System.out.println(Graph.createPath(10).exportGraphToViz());
//		System.out.println(Graph.createComplete(4).exportGraphToViz());
		ArrayList<Vertex> vertexes2 = new ArrayList<Vertex>();
		vertexes2.add(new Vertex("v4"));
		vertexes2.add(new Vertex("v5"));
		vertexes2.add(new Vertex("v6"));
		vertexes2.add(new Vertex("v7"));
		Graph graph2 = new Graph(vertexes2);
		graph2.addEdge(new Edge(new Vertex("v4"), new Vertex("v5")));
		graph2.addEdge(new Edge(new Vertex("v5"), new Vertex("v6")));
		graph2.addEdge(new Edge(new Vertex("v6"), new Vertex("v4")));
		graph2.addEdge(new Edge(new Vertex("v4"), new Vertex("v7")));
//		System.out.println("Edges: "+graph2.countEdges()+" "+"Vertices: "+graph2.countVertices());
//		System.out.println("Contains Cycle: "+graph2.hasCycle());
//		graph2.getAdjacencyMatrix();
		System.out.println(Graph.createComplete(3).isComplete());
	}

}
