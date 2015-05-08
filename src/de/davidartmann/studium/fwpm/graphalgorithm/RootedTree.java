package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.ArrayList;

public class RootedTree {
	
	private ArrayList<RootedTree> children;
	
	public RootedTree() {
		//TODO
	}

	public ArrayList<RootedTree> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<RootedTree> children) {
		this.children = children;
	}

}
