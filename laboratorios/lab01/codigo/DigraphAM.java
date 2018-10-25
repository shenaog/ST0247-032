import java.util.ArrayList;

/*
 * Student: Sarah Henao Gallego
 * Professor: Mauricio Toro Bermúdez
 * Thursday, July 19, 2018
 */

public class DigraphAM extends Digraph {
	private int[][] adjMat;
	
	public DigraphAM(int size) {
		super(size);
		adjMat = new int[size][size];
	}

	// Fills up the Adjacency Matrix in order to represent the specific directed graph
	public void addArc(int source, int destination, int weight) {
		adjMat[source][destination] = weight;
	}
	
	// Method to print out the Adjacency Matrix
	public void showMatrix() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(adjMat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	// Method to find the connected neighbors of a specific vertex
	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> successors = new ArrayList<>();
		for (int j = 0; j < size; j++) {
			if (adjMat[vertex][j] != 0) {
				successors.add(j);
			}
		}
		return successors;
	}

	// Method to get the weight of the arc
	public int getWeight(int source, int destination) {
		return adjMat[source][destination]; 
	}
	
	// Main for testing
	public static void main(String args[]) {
		DigraphAM g = new DigraphAM(3);
		g.addArc(0, 1, 3);
		g.addArc(1, 2, 4);
		g.addArc(1, 0, 5);
		g.showMatrix();
		
		ArrayList<Integer> succ1 = g.getSuccessors(1);
		System.out.println(succ1);
		
		int weight1 = g.getWeight(0, 1);
		System.out.println(weight1);
		int weight2 = g.getWeight(1, 2);
		System.out.println(weight2);
		int weight3 = g.getWeight(1, 0);
		System.out.println(weight3);
	}
}