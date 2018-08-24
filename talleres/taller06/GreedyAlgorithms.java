import java.util.ArrayList;
import java.util.Arrays;

/*
 * Workshop 6 - Greedy Algorithms
 * Student: Sarah Henao
 * Professor: Mauricio Toro
 * Date: August 23, 2018
 */

// Exercise 1
// A greedy algorithm does not always return the optimal solution.
public class GreedyAlgorithms {

	public static int[] calcChange(int[] coins, int change) {
		int[] res = new int[coins.length];

		int i = 0;

		while (change > 0 && i < coins.length) {

			if (change >= coins[i]) {
				change -= coins[i];
				res[i] += 1;
			} else {
				i += 1;
			}
		}
		return res;
	}

	// Exercise 2
	public static int[] minCost(Digraph g) {

		boolean[] visited = new boolean[g.size];

		visited[0] = true;

		int current = 0;

		int i = 0;

		int[] route = new int[g.size + 1];
		route[i++] = current;

		while (!all(visited)) {

			ArrayList<Integer> neighbors = g.getSuccessors(current);
			int next = current;
			int dist = Integer.MAX_VALUE;
			for (int j = 0; j < neighbors.size(); j++) {
				int nNeigh = neighbors.get(j);
				if (!visited[nNeigh] && g.getWeight(current, nNeigh) < dist) {
					next = nNeigh;
					dist = g.getWeight(current, nNeigh);
				}
			}
			visited[next] = true;
			current = next;
			route[i++] = current;
		}
		return route;
	}

	// Auxilary Method
	public static boolean all(boolean[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i])
				return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		int[] ret = calcChange(new int[] {1000, 500, 200, 100, 50}, 1750);
		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);

		}

		int n = 4;
		DigraphAL dgal = new DigraphAL(n);
		int[] dist = new int[] {2, 3, 1, 4, 5, 7};
		int k = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				dgal.addArc(i, j, dist[k]);
				dgal.addArc(j, i, dist[k++]);
			}
		}
		
		int[] route = minCost(dgal);
		for (int i = 0; i < n + 1; i++)
			System.out.println(route[i]);
	}

}
