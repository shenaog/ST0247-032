import java.util.Stack;
/* 
 * Lab 4 ~ Greedy Algorithms
 * Sarah Henao Gallego
 * 201420005101
 * September 30, 2018
 * Data Structures and Algorithms 2 - ST0247
 * Professor: Mauricio Toro Bermudez

 */
public class TSPNearestNeighbor {
	
	/*
	 * A Greedy Algorithm to solve this problem is the Nearest Neighbor Algorithm.
	 * This algorithm was taken from Laboratory 4 - Section 4 - Problem 2.
	 * The ownership of this algorithm is Mauricio Toro Bermudez.
	 */
	
	private int numberOfNodes;
	private Stack<Integer> stack;
	
	public TSPNearestNeighbor() {
		
		stack = new Stack<Integer>();
	}
	
	public void tsp(int adjacencyMatrix[][]) {
		
		numberOfNodes = adjacencyMatrix[1].length - 1;
		int[] visited = new int[numberOfNodes + 1];
		visited[1] = 1; 
		stack.push(1);
		int element, dst = 0, i;
		int min = Integer.MAX_VALUE;
		boolean minFlag = false;
		System.out.print(1 + "\t");
		
		while(!stack.isEmpty())
		{
			element = stack.peek();
			i = 1;
			min = Integer.MAX_VALUE;
			
			while (i <= numberOfNodes)
			{
				
				if (adjacencyMatrix[element][i] > 1 && visited[i] == 0)
				{
					
					if (min > adjacencyMatrix[element][i])
					{
						 min = adjacencyMatrix[element][i];
	                     dst = i;
	                     minFlag = true;
					}
				}
				i++;
			}
			
			if (minFlag)
            {
                visited[dst] = 1;
                stack.push(dst);
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
			
			stack.pop();
		}
	}

}
