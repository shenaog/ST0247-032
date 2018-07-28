import java.util.*;

/*
 * Student: Sarah Henao Gallego
 * Professor: Mauricio Toro Bermúdez
 * Thursday, July 19, 2018
 */

public class DigraphAL extends Digraph {

	//LinkedList<LinkedList<Pair>> adjList = LinkedList<LinkedList<Pair>>();
	
	LinkedList<Vertex> adjList;
	
	public class Pair {
		public int pWeight;
		public Vertex destination;
		
		public Pair(Vertex dest, int pW) {
			destination = dest;
			pWeight = pW;
		}
		
		public int getName() {
			return destination.name;
		}
	}
	
	public class Vertex {
		public int name;
		public LinkedList<Pair> neighbors;
		
		public Vertex(int v) {
			name = v;
			neighbors = new LinkedList<Pair>();
		}
		
		public Pair getNeighbors(int ind) {
			return neighbors.get(ind);
		}
	}
	
	public DigraphAL(int size) {
		super(size);
		adjList = new LinkedList<Vertex>();

		for (int i = 0; i < size; i++) {
			Vertex tempV = new Vertex(i);
			adjList.add(tempV);
		}
		
	}

	public void addArc(int source, int destination, int weight) {
		Pair tempP = new Pair(adjList.get(destination), weight);
		adjList.get(source).neighbors.add(tempP);
	}
	
	public void showList(DigraphAL graph) {
		for (int i = 0; i < size; i++) {
			Vertex tempV = adjList.get(i);
			System.out.print(tempV.name);
			
			for (int j = 0; j < tempV.neighbors.size(); j++) {
				Pair tempP = tempV.getNeighbors(j);
				int tempNum = tempP.destination.name;
				int temWeight = tempP.pWeight;
				System.out.print("\n" + tempNum + "\n" + temWeight + "\n");
			}	
		}
	}
	
	public int getWeight(int source, int destination) {
			
			Vertex tempV = adjList.get(source);
			
			for (int i = 0; i < tempV.neighbors.size(); i++) {
				Pair tempNeigh = tempV.getNeighbors(i);
				if (tempNeigh.destination.name == destination) {
					return tempNeigh.pWeight;
				}
			} 
			return 0;	// Retorna 0 si : el destino no hace parte de los vecinos 
	}

	public ArrayList<Integer> getSuccessors(int vertice) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Vertex indV = adjList.get(vertice);
		for (int i = 0; i < indV.neighbors.size(); i++) {
			int tempDest = indV.neighbors.get(i).destination.name;
			res.add(tempDest);
		}
		return res;
	}
	
	public static void main(String args[]) {
		DigraphAL g = new DigraphAL(3);
		g.addArc(0, 1, 3);
		g.addArc(1, 2, 4);
		g.addArc(1, 0, 5);
		g.showList(g);
		
		ArrayList<Integer> s = g.getSuccessors(1);
		System.out.println(s);
	}
}