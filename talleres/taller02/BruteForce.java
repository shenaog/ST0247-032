import java.util.ArrayList;

/*
 * Student: Sarah Henao Gallego
 * Professor: Mauricio Toro Bermúdez
 * Thursday, July 26, 2018
 */

public class BruteForce {

	// ========================================

	// Main method
	// Combinations of length k for a String of length n (0 <= k <= n)
	public static ArrayList<String> combinations(String s) {
		ArrayList<String> subsets = new ArrayList<String>();
		combinations("", s, subsets);
		return subsets;
	}

	// Auxiliary method
	// Generate combinations recursively
	private static void combinations(String pre, String pos, ArrayList<String> list) {
		if (pos.length() == 0) {
			// Modify Object list (Object subsets in the Main method) to acknowledge new combination
			list.add(pre);
			return;
		}
		
		// Left (character included in the subset) and right branch
		combinations(pre + Character.toString(pos.charAt(0)), pos.substring(1, pos.length()), list);
		combinations(pre, pos.substring(1, pos.length()), list);
	}

	// ========================================

	// Main method
	public static ArrayList<String> permutations(String s) {
		ArrayList<String> subsets = new ArrayList<String>();
		permutations("", s, subsets);
		return subsets;
	}

	// Auxiliary method
	private static void permutations(String pre, String pos, ArrayList<String> list) {
		int n = pos.length();
		
		if (n == 0) {
			list.add(pre);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			permutations(pre + Character.toString(pos.charAt(i)), pos.substring(0, i) + pos.substring(i + 1), list);
		}
	}

	// ========================================

	// Main method
	// N-Queen Problem
	public static int queens(int n) {
		// Pending..
	}
	
	private static void queens(ArrayList<Integer> pre, ArrayList<Integer> pos, ArrayList<ArrayList<Integer>> list) {
		// Pending..
	}

	// Auxiliary method
	public static boolean esValido(int[] tablero) {
		int n = tablero.length;
	
		for (int i = 0; i < n - 1; i++) {
			
			for (int j = 1; i + j < n; j++) {
				// Checks the vertical and horizontal directions
				if (tablero[i] == tablero[i + j]) 
					return false;
				// Diagonal with direction \ 
				if (tablero[i] == tablero[i + j] - j)
					return false;
				// Diagonal with direction / 
				if (tablero[i] == tablero[i + j] + j)
					return false;
			}
		}
	return true;
	}

	// Print chess table
	public static void imprimirTablero(int[] tablero) {
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[i] == j ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}

	// ========================================

	// Main method
	public static ArrayList<String> permutationsWithRepetition(String s) {
		ArrayList<String> subsets = new ArrayList<String>();
		permutationsWithRepetition("", s, subsets);
		return subsets;
		
	}

	// Auxiliary method
	// 
	private static void permutationsWithRepetition(String pre, String pos, ArrayList<String> list) {
		int n = pos.length();
		int m = pre.length();
		
		if (n == m) {
			list.add(pre);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			permutationsWithRepetition(pre + Character.toString(pos.charAt(i)), pos, list);
		}
		
	}
	
	// ========================================

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Exercise 1
		String str1 = "abc";
		ArrayList <String> res1 = combinations(str1);
		System.out.println(res1);

		// Exercise 2
		String str2 = "abc";
		ArrayList <String> res2 = permutations(str2);
		System.out.println(res2);
		
		// Exercise 3
		// N-Queen Problem
		int[] tab = new int[] {2, 0, 3, 1};
		imprimirTablero(tab);
		System.out.println(esValido(tab));

		// Exercise 4
		String str4 = "abc";
		ArrayList <String> res4 = permutationsWithRepetition(str4);
		System.out.println(res4);
	}

}