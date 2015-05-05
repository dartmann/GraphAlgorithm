
package de.davidartmann.studium.fwpm.graphalgorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Class of a simple undirected graph
 * @author david
 *
 */
public class Graph {
	
	private static final String FILEPATH = "resource/graphData";
	private static final File FILE = new File(FILEPATH);
	
	public Graph() {
		//init();
	}
	
	/*
	private void init() {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void write() {
		if (Files.exists(Paths.get(FILEPATH), LinkOption.NOFOLLOW_LINKS)) {
			
		}
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
			
		} catch (IOException e) {
			
		}
	}
	*/
	
	/**
	 * Method to retreive all neighbours of a specific vertice.
	 * @param vertice the specific vertice
	 * @return {@link List} with the neighbours
	 */
	public ArrayList<String> neighbours(String vertice) {
		ArrayList<String> neighbours = new ArrayList<String>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String delimiter = vertice+"--";
				if (line.contains(delimiter)) {
					neighbours.add(line.substring(3));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return neighbours;
	}
	
	/**
	 * Method to retreive the number of edges a specific vertice has.
	 * @param vertice the specific vertice
	 * @return number of edges
	 */
	public int numEdges(String vertice) {
		int edges = 0;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String delimiter = vertice+"--";
				if (line.contains(delimiter)) {
					edges++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return edges;
	}
	
	/**
	 * Method to check if two vertives are adjacent to each other.
	 * In other words: vertice1 and vertice2 are bound due one edge.
	 * @param vertice1
	 * @param vertice2
	 * @return true if those two vertices have a common edge, false otherwise
	 */
	public boolean adjacent(String vertice1, String vertice2) {
		boolean adjacent = false;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				if (line.contains(vertice1+"--"+vertice2)) {
					adjacent = true;
				}
				if (line.contains(vertice2+"--"+vertice1)) {
					adjacent = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adjacent;
	}
	
	/**
	 * Method to add a vertice to the graphData file.
	 * @param nameOfVertice
	 * @return true if successful written to the file, false otherwise
	 */
	public boolean addVertice(String nameOfVertice) {
		boolean success = false;
		// if file does not exist
		if (!Files.exists(Paths.get(FILEPATH), LinkOption.NOFOLLOW_LINKS)) {
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
				bufferedWriter.write(nameOfVertice+"\n");
				bufferedWriter.write(" \n");
				success = true;
			} catch (IOException e) {
				e.printStackTrace();
				success = false;
			}
		// file does exist
		} else {
			// vertice name is free
			if (!containsVertice(nameOfVertice)) {
				StringBuilder cache;
				try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
					// do a temporary cache
					String line;
					cache = new StringBuilder();
					while((line = bufferedReader.readLine()) != null) {
						if (line.isEmpty()) {
							cache.append(nameOfVertice);
							cache.append("\n\n");
						} else {
							cache.append(line);
							cache.append("\n");
						}
					}
					// store cache into file
					try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
						System.out.println(cache);
						bufferedWriter.write(cache.toString());
						success = true;
					} catch (IOException e) {
						e.printStackTrace();
						success = false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}
	
	/**
	 * Method to check if graphData contains a vertice with the given name.
	 * @param nameOfVertice
	 * @return
	 */
	public boolean containsVertice(String nameOfVertice) {
		boolean contains = false;
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				if (line.equals(nameOfVertice)) {
					contains = true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contains;
	}
	
	public boolean containsEdge(String vertice1, String vertice2) {
		boolean contains = false;
		//TODO
		return contains;
	}
	
	/**
	 * Method to add an edge for two vertices.
	 * @param vertice1
	 * @param vertice2
	 * @return true if edge could be added, false otherwise
	 */
	public boolean addEdge(String vertice1, String vertice2) {
		boolean success = false;
		// check if both vertices exist
		if (containsVertice(vertice1)) {
			if (containsVertice(vertice2)) {
				// unfortunately we need to sort the listing of edges, so first read, then write...
				StringBuilder cache;
				try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
					// do a temporary cache
					String line;
					cache = new StringBuilder();
					while((line = bufferedReader.readLine()) != null) {
						cache.append(line);
						cache.append("\n");
					}
					// search for the last index of an edge with vertice1
					cache.insert(cache.lastIndexOf(vertice1)+4, "\n"+vertice1+"--"+vertice2);
					// store cache into file
					try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
						System.out.println(cache);
						bufferedWriter.write(cache.toString());
						success = true;
					} catch (IOException e) {
						e.printStackTrace();
						success = false;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return success;
	}

}
