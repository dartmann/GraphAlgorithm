package de.davidartmann.studium.fwpm.graphalgorithm;

public class Edge {
	
	private Vertex vertex;
	
	private Vertex vertex2;
	
	public Edge(Vertex vertex, Vertex vertex2) {
		this.vertex = vertex;
		this.vertex2 = vertex2;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public Vertex getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

}
