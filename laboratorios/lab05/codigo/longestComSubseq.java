/*
 * Lab 5 ~ Divide and Conquer & Dynamic Programming
 * Sarah Henao Gallego
 * 201420005101
 * October 12, 2018
 * Data Structures and Algorithms 2 - ST0247
 * Professor: Mauricio Toro Bermudez
 */
public class longestComSubseq {
	
	/*
	 * This is an implementation to the Longest Common Sub-sequence Problem.
	 * Code taken from : Exercise 2 of Section 4
	 * The ownership of this algorithm is Mauricio Toro Bermudez.
	 */
	public static int lcsdyn(String x, String y) {
		int i, j;
		int lenx = x.length();
		int leny = y.length();
		
		int[][] table = new int[lenx + 1][leny + 1];
		
		for (i = 0; i <= lenx; i++)
			table[i][0] = 0;
		
		for (j = 0; j <= leny; j++)
			table[0][j] = 0;
		
		for (i = 1; i <= lenx; i++) {						// n = lenx
			for (j = 1; j <= leny; j++) {					// m = leny
				if (x.charAt(i - 1) == y.charAt(j - 1))
					table[i][j] = 1 + table[i - 1][j - 1];
				else
					table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
		
		//
		return table[lenx][leny];							// Complexity is O(n * m)
	}
	
	// Tester
		public static void main(String[] args) {
			String a = new String("AGGTAB");
			String b = new String("GXTXAYB");
			
			int c = lcsdyn(a, b);
			System.out.println(c);

		}
	
}
