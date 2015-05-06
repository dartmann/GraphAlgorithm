package de.davidartmann.studium.fwpm.graphalgorithm;

import java.util.Date;


public class Vertex {
	
	private String name;
	
	/**
	 * Constructor without naming.
	 * The actual timestamp will be used as the name.
	 */
	public Vertex() {
		this.name = String.valueOf(new Date().getTime());
	}
	
	/**
	 * Constructor with given name.
	 * @param name
	 */
	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

}
