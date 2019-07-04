/*
 * 
 * 
Sample Input
6 5
0 1 1 0 1
1 1 0 1 0
0 1 1 1 0
1 1 1 1 0
1 1 1 1 1
0 0 0 0 0

Sample Output:
3

Explanation:
-> The first line 6 5
    o 6 – Represents the total number of rows.
    o 5 – represents the total number of columns
-> There are three square matrices with all 1’s
        o 2 x 2
        o 2 x 2
        o 3 x 3
-> Maximum size is 3 X 3, hence the answer is 3

Approach:
---------
1) Construct a L matrix L[R][C] for the given M[R][C].
     a)    Copy first row and first columns as it is from M[][] to L[][]
     b)    For other entries, use following expressions to construct L[][]
         If M[i][j] is 1 then
            L[i][j] = min(L[i][j-1], L[i-1][j], L[i-1][j-1]) + 1
         Else //If M[i][j] is 0
            L[i][j] = 0
2) Find the maximum entry in L[R][C]
3) Using the value and coordinates of maximum entry in L[i], print 
   sub-matrix of M[][]
 * 
 */
import java.util.Scanner;

public class ScottsLandHunt {
	public static void maxSubSquareMatrixWith1s(int[][] M) {
		final int n = M.length;
		final int m = M[0].length;

		// will hold the size of the largest square sub-matrix with all 1s including
		// L[i][j]
		// where L[i][j] is the rightmost and "bottom most" cell of the sub-matrix.
		int[][] L = new int[n][m];

		// L[:][0] = M[:][0]
		for (int i = 0; i < n; i++) {
			L[i][0] = M[i][0];
		}
		// L[0][:] = M[0][:]
		for (int j = 0; j < m; j++) {
			L[0][j] = M[0][j];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (M[i][j] == 1) {
					L[i][j] = Math.min(Math.min(L[i][j - 1], L[i - 1][j]), L[i - 1][j - 1]) + 1;
				} else {
					L[i][j] = 0;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, L[i][j]);
			}
		}
		System.out.print(max);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfRows = sc.nextInt();
		int numOfCols = sc.nextInt();
		int[][] Map = new int[numOfRows][numOfCols];
		for (int i = 0; i < numOfRows; i++)
			for (int j = 0; j < numOfCols; j++)
				Map[i][j] = sc.nextInt();

		maxSubSquareMatrixWith1s(Map);
	}
}
