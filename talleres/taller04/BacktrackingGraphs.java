import java.util.ArrayList;
import java.util.Arrays;

/*
 * Workshop 4 - Basic Backtracking for Graphs
 * Student: Sarah Henao
 * Professor: Mauricio Toro
 * Date: August 16, 2018
 */

public class BacktrackingGraphs {

	// =============== Exercise 1: Is there a path between Node i and Node j in the Directed Graph g ?
	public static boolean hayCamino(Digraph g, int i, int j){
		boolean[] visitados = new boolean[g.size()];
		return hayCamino(g, i, j, visitados);
	}
	
	private static boolean hayCamino(Digraph g, int i, int j, boolean[] v) {

		v[i] = true;

		if (i == j)
			return true;

		for (Integer vecino: g.getSuccessors(i))
			if(!v[vecino] && hayCamino(g, vecino, j, v))
				return true;
		return false;

	}

	// =============== Exercise 2: Find the shortest route between Node i and Node j in graph g and return the Cost of that route ?
	public static int shortestRoute(Digraph g, int i, int j){
		ArrayList<Integer> distance = new ArrayList<Integer>();
		for (int k = 0; k < g.size(); k++) {
			distance.add(Integer.MAX_VALUE);
		}

		distance.set(i, 0);		// distance from i to each other Node j
		int d = shortestRouteAux(g, i, j, distance);
		System.out.println(distance);
		return d;
	}
	
	private static int shortestRouteAux(Digraph g, int i, int j, ArrayList<Integer> distance) {

		if (i == j)
			return 0;

		for (Integer neighbor : g.getSuccessors(i)) {
			int d = g.getWeight(i, neighbor) + distance.get(i);

			if (d < distance.get(neighbor)) {
				distance.set(neighbor, d);
				shortestRouteAux(g, neighbor, j, distance);
			}
		}
		return distance.get(j);
	}

	// =============== Exercise 3: Find the shortest route that passes through all the Nodes exactly once and returns 
	// 							to the initial Node. Return the cost of this route.
	

	public static int shortestTotalRoute(Digraph g) {
		int[] visited = new int[] {0};
		int[] notVisited = new int[g.size() - 1];
		for (int i = 0; i < notVisited.length; i++)
			notVisited[i] = i + 1;
		
		return shortestTotalRoute(g, visited, notVisited, 0);
	}
	
	private static int shortestTotalRoute(Digraph g, int[] visited, int[] notVisited, int d) {
		if (notVisited.length == 0) {
			return d + g.getWeight(visited[g.size() - 1], 0);
		}
		
		int minDist = Integer.MAX_VALUE; 
		for (int i = 0; i < notVisited.length; i++) {
			int source = visited[visited.length - 1];
			int destination = notVisited[i];
			System.out.print(source);
			System.out.print("\t");
			System.out.println(destination);
			int dist = shortestTotalRoute(g, combine(visited, new int[] {notVisited[i]}),
					combine(Arrays.copyOfRange(notVisited, 0, i), Arrays.copyOfRange(notVisited, i + 1, notVisited.length)),
					d + g.getWeight(source, destination));
			
			if (dist < minDist)
				minDist = dist;
		}
		System.out.println("Backtracking!");
		return minDist;
	}
	
	// Taken from: https://www.logicbig.com/how-to/code-snippets/jcode-java-array-range.html
	public static int[] combine(int[] a, int[] b){
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// =============== Graph 1
		DigraphAL dgal = new DigraphAL(5);
		dgal.addArc(0,1,10); dgal.addArc(0,2,3); dgal.addArc(1,2,1); dgal.addArc(1,3,2); dgal.addArc(2,1,4);
		dgal.addArc(2,3,8); dgal.addArc(2,4,2); dgal.addArc(3,4,7); dgal.addArc(4,3,9);

		boolean[] v = new boolean[dgal.size()];
		System.out.println(hayCamino(dgal, 1, 2, v));

		ArrayList<Integer> neigh =dgal.getSuccessors(1);
		System.out.println(neigh);
		int sol = shortestRoute(dgal,0, 3);
		System.out.println(sol);

		// =============== Graph 2 Bipartite graph
		DigraphAL dga2 = new DigraphAL(4);
		int[] d = new int[] {1, 7, 2, 5, 6, 4};
		int k = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				dga2.addArc(i, j, d[k]);
				dga2.addArc(j, i, d[k++]);
			}
		}
		
		int r = shortestTotalRoute(dga2);
		System.out.print("Shortest Route Total Distance: ");
		System.out.println(r);
		
	}

}
