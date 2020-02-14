/*
 * 
 * 
In a palace, there were several rooms that form a 2D grid G with R rows and C columns. All
rooms have doors on all four sides i.e., east, west, north and south. The first room is assumed
to be at [0, 0] while the last room at [R-1, C-1]. In each room, there is a pot with some gold
coins. Starting from the first room, there is a way to reach the last room and get out of it as
well.
In order to reach the last room, one must always start from the first room collect the gold coins,
get into any unvisited room in either in south or east (down or right) directions and collect the
gold coins from it. One must choose a path that gives the minimum number of gold coins. From
each possible paths get the minimum number of gold coins excluding the gold coins of first and
last room.
Given a matrix of integers G with R rows and C columns, find the maximum gold coins of the
minimum gold coins found for the possible paths.

Sample Input 1:
2 2
5 1
4 5

Sample Output 1: 
4

Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.


Sample Input 2:
2 3
1 2 3
6 5 1

Sample Output 2: 
5

Explanation:
Possible paths:
1-> 2 -> 3 -> 1 => min value is 2
1-> 2 -> 5 -> 1 => min value is 2
1-> 6 -> 5 -> 1 => min value is 5
So min of all the paths = [2, 2, 5]. Note that we don't include the first and final entry.
Return the max of that, so 5.

==========================================================

input=3 3
6 7 8
5 4 9
8 7 6
output=7


input=5 5
6 5 6 1 2
1 2 1 3 5
2 5 8 4 7
1 2 1 3 5
6 5 6 1 2
output=2


input=3 4
5 7 6 8
3 4 2 1
9 8 4 6
output=4


input=3 4
3 5 1 6
1 3 7 8
6 3 1 9
output=3


input=6 5
6 5 6 1 2
1 2 5 7 5
2 5 8 4 9
1 5 8 7 4
9 5 1 7 5
2 2 1 8 9
output=5


input=2 2
8 9
10 11
output=10


input=2 5
9 5 1 7 5
2 2 1 8 9
output=1

 * 
 */


import java.util.Scanner;

public class MaximumGoldCoinsinMinimums {

	
	public static int minMaxScore(int[][] grid) {
	    // Assume there is at least one element
	    int r = grid.length, c = grid[0].length;
	    int[][] dp = new int[r][c];
	    // Init
	    dp[0][0] = Integer.MAX_VALUE; // first entry is not considered
	    for (int i = 1; i < r; ++i) dp[i][0] = Math.min(dp[i - 1][0], grid[i][0]);
	    for (int j = 1; j < c; ++j) dp[0][j] = Math.min(dp[0][j - 1], grid[0][j]);
	    // DP
	    for (int i = 1; i < r; ++i) { // row by row
	      for (int j = 1; j < c; ++j) {
	        if (i == r - 1 && j == c - 1) {
	          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // last entry is not considered
	        } else {
	          int score1 = Math.min(dp[i][j - 1], grid[i][j]); // left
	          int score2 = Math.min(dp[i - 1][j], grid[i][j]); // up
	          dp[i][j] = Math.max(score1, score2);
	        }
	      }
	    }
	    return dp[r - 1][c - 1];
	  }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int grid[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		System.out.println(minMaxScore(grid));
		
	}

}
