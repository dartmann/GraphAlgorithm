package de.davidartmann.studium.fwpm.graphalgorithm;


public class Main {

	public static void main(String[] args) {
		Graph graph = new Graph();
		/*
		System.out.println("Neighbours Test");
		for (String s : graph.neighbours("d")) {
			System.out.println(s);
		}
		System.out.println("\nCounting edges Test");
		System.out.println(graph.numEdges("a"));
		
		System.out.println("\nAdjacent Test");
		System.out.println(graph.adjacent("a", "e"));
		
		System.out.println("\nAddVertice Test");
		System.out.println(graph.addVertice("e"));
		*/
		System.out.println("\nAddEdge Test");
		System.out.println(graph.addEdge("b", "e"));
	}

}
