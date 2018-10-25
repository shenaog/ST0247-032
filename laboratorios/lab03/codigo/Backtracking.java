/*
 * Workshop 3 - Backtracking
 * Student: Sarah Henao
 * Professor: Mauricio Toro
 * Date: August 3, 2018
 */
public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nQueens(10));
	}
	
	// Main function
	public static int nQueens(int n) {
		int[] tablero = new int[n];
		return nQueens(0, n, tablero);
	}

	// Auxiliary function (Recursion)
	private static int nQueens(int c, int n, int[] tablero) {
		int nSols = 0;
		
		if (c == n) { return 1; }
		
		for (int i = 0; i < n; i++) {
			if(puedoPonerReina(i, c, tablero)) {
				tablero[c] = i;
				nSols += nQueens(c + 1, n, tablero);
			}
		}
		
		return nSols;
	}

	// Auxiliary function (Check)
	private static boolean puedoPonerReina(int r, int c, int[] tablero) {
		int num1 = r;
		int num2 = r;
		for (int i = c - 1; i >= 0; i--) {
			num1 -= 1;
			num2 += 1;
			
			if (num1 == tablero[i] || num2 == tablero[i] || r == tablero[i]) { return false; } 
		}
		
		return true;
	}
}
