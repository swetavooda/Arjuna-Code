/*
Sample input :
3
3
-3 -5 -2
 4  5 -6   
 8  9 -9
Sample output :
4
Explanation :
* First line 3 indicates no of rows
* Second line 3 indicates no of columns
* Initially A at -3(0,0) he starts moving towards B i.e., -9(3,3)
* A's one  of the possible path to reach B is -3 -> 4 -> 8 -> 9 -> -9
* A needs a minimum of 4 chocolates to exit from cell (0,0) with at least one chocolate 
after that he will choose down and right to avoid loosing chocolates.

Sample input:
2  
2
1 2
3 -1
Sample output :
1

Explanation :
A must have at least 2 chocolates to meet B -1(1,1) with at least one chocolate left


/***************************************************************************
Sample Input/Outputs which were used againist your solution to evaluate:
------------------------------------------------------------------------

SAMPLE 1:
input =2
2
-10 3
5 -6
output =12 

SAMPLE 2:
input =3                                                                                                                 
3
-4 2 9
-3 -9 5
3 -7 7
output =5

SAMPLE 3:
input =2
3
-5 6 4
7 -8 3
output =6

SAMPLE 4:
input =3
2
6 5
14 -20
-23 18 
output =1

SAMPLE 5:
input =4                                                                                                                 
4                                                                                                                
-10 -5 10 8
-14 12 -8 6
5 4 -11 -8
7 2 -23 6
output =16

SAMPLE 6:
input =4 4
10 20 30 40
40 50 -100 -200
30 40 50 -1000
-100 -200 -300 -400
output =511


SAMPLE 7:
input =3 3
1 2 3
4 5 6
7 8 9
output =1
  
**************************************************************************




*/

import java.util.Scanner;

public class MagicKingdomPark {
	public int findMinimumChocolates(int[][] compartments, int m, int n) {

		/*
		 * if (compartments.length == 0 || compartments[0].length == 0) { return 0; }
		 */

		int[][] chocolates = new int[m][n];

		int tm = compartments.length - 1;
		int tn = compartments[0].length - 1;

		chocolates[tm][tn] = Math.max(1 - compartments[tm][tn], 1);

		for (int i = tm - 1; i >= 0; i--) {
			chocolates[i][tn] = Math.max(chocolates[i + 1][tn] - compartments[i][tn], 1);
		}

		for (int i = tn - 1; i >= 0; i--) {
			chocolates[tm][i] = Math.max(chocolates[tm][i + 1] - compartments[tm][i], 1);
		}

		for (int i = tm - 1; i >= 0; i--) {
			for (int j = tn - 1; j >= 0; j--) {
				int down = Math.max(chocolates[i + 1][j] - compartments[i][j], 1);
				int right = Math.max(chocolates[i][j + 1] - compartments[i][j], 1);
				chocolates[i][j] = Math.min(down, right);
			}
		}
		return chocolates[0][0];
	}

	public static void main(String args[]) {
		MagicKingdomPark mkp = new MagicKingdomPark();
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] compartments = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				compartments[i][j] = s.nextInt();
			}
		}

		System.out.print(mkp.findMinimumChocolates(compartments, m, n));
	}
}
