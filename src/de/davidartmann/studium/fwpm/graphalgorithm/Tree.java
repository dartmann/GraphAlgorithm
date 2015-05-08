package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;

public class Tree extends Graph {
	
	private ArrayList<Tree> children;

	public Tree(ArrayList<Vertex> vertexes, String name) {
		if (!this.hasCycle()) {
			//TODO: check for cycles while instantiation, to be avoid tree with cycle 
		}
	}

	public ArrayList<Tree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Tree> children) {
		this.children = children;
	}

	
}
