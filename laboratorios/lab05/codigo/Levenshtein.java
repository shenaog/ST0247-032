import java.util.Arrays;

/*
 * Lab 5 ~ Divide and Conquer & Dynamic Programming
 * Sarah Henao Gallego
 * 201420005101
 * October 12, 2018
 * Data Structures and Algorithms 2 - ST0247
 * Professor: Mauricio Toro Bermudez
 */

public class Levenshtein {
	/*
	  * Code taken from : https://www.baeldung.com/java-levenshtein-distance 
	  * 
	  * Levenshtein Distance calculated by Recursive algorhtm and Dynamic Programming
	  * The complexity is compared and improved with Dynamic Programming.
	 */

	static int calcREC(String x, String y) {
		
		// Base Case : When one or both strings become empty
		if(x.isEmpty()) {
			return y.length();
		}
		
		if(y.isEmpty()) {
			return x.length();
		}
		
		// Recursion
		int substition = calcREC(x.substring(1), y.substring(1)) 
				+ costOfSubstition(x.charAt(0), y.charAt(0));
		
		int insertion = calcREC(x, y.substring(1)) + 1;
		
		int deletion = calcREC(x.substring(1), y) + 1;
		
		return min(substition, insertion, deletion);
		
	}
	
	public static int costOfSubstition(char a, char b) {
		
		if (a == b) {
			return 0;
		}
		else {
			return 1;

		}
	}
	// Auxiliary method
	public static int min(int... numbers) {
		
		return Arrays.stream(numbers)
		          .min().orElse(Integer.MAX_VALUE);
	}
	
// The complexity is O(3^n) because at each step we
	// branch-off into 3 recursive calls.
	
// ============================================

	static int calcDP(String x, String y) {
		
		int[][] dp = new int[x.length() + 1][y.length() + 1];
		
		for (int i = 0; i <= x.length(); i++) {
			for (int j = 0; j <= y.length(); j++) {
				//
				if (i == 0) {
					dp[i][j] = j;
				}
				else if (j == 0) {
					dp[i][j] = i;
				}
				else {
					
					dp[i][j] = min(dp[i - 1][j - 1]
							+ costOfSubstition(x.charAt(i - 1), y.charAt(j - 1)),
							dp[i - 1][j] + 1,
							dp[i][j - 1] + 1);
				}
			}
		}
		
		return dp[x.length()][y.length()];
		
	}
	
	// The complexity is O(m*n) because m*n will be the largest number of recursive calls.
	// M and n are the numbe rof suffixes of Strings x and y.
		
	// ============================================
	
	
	// Tester
	public static void main(String[] args) {
		String a = new String("carro");
		String b = new String("casa");
		
		int c = calcREC(a, b);
		System.out.println(c);
		
		int d = calcDP(a, b);
		System.out.println(d);
	}
}

