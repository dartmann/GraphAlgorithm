package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;

public class Adjacencymatrix {
	
	private boolean[][] matrix;
	private String owner;
	private ArrayList<Vertex> vertices;
	
	public Adjacencymatrix(int numberOfVertices, String owner, ArrayList<Vertex> vertices) {
		this.matrix = new boolean[numberOfVertices][numberOfVertices];
		this.setOwner(owner);
		this.vertices = vertices;
	}

	public boolean[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(boolean[][] matrix) {
		this.matrix = matrix;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Overwritten method, to display the {@link Adjacencymatrix} nicely in the console.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder("Adjacencymatrix of "+owner+":\n");
		for(Vertex vertex : vertices) {
			builder.append(vertex.getName()+"\t");
		}
		builder.append("\n");
		for(int i = 0; i < vertices.size(); i++) {
			int line = 0;
			for(int j = 0; j < vertices.size(); j++) {
				if (line < 3) {
					builder.append(matrix[i][j]+"\t");
				} else {
					builder.append(matrix[i][j]+"\t"+vertices.get(i).getName()+"\n");
				}
				line++;
			}
		}
		return builder.toString();
	}
}
