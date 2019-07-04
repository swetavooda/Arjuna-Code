package session4;

/*
 * 

Sample Input:
5
1 4 3 2 5
1 2 3 4 5
11 5 2 1 9
1 2 1 4 5
2 115 3 4 5

Sample Output:
134



Approach:
start from 2nd floor,first room
step 1: currentFloor = 2,currentRoom = 1
step 2: find max gold coins among the lower left room,lower right room, lower room.
step 3: add this max gold coins to current room gold coins.
step 4: then goto next room on same floor. repeat Step 2 to Step 4. for all rooms in the current floor
step 5: increment currentFloor. repeat Step 2 to Step 5 till last floor.
Find max gold coins from all rooms of last floor.
this would be the desired result.

Intermediate operations

[131, 134, 133, 127, 128]
[129, 130, 125, 123, 122]
[128, 122, 119, 117, 19]
[116, 117, 116, 9, 10]
[2, 115, 3, 4, 5]


 * 
 */
import java.util.*;
class HuntingGoldCoins{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int grid[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		for (int i = n - 2; i >= 0; i--) {// start from 2nd Floor
			for (int j = 0; j < n; j++) {
				int x = 0;
				// it checks for lower left room of current room
				if (j > 0) {
					x = Math.max(x, grid[i + 1][j - 1]);
				}

				if (j < n - 1)
					x = Math.max(x, grid[i + 1][j + 1]);// checks for lower right room of current room
				x = Math.max(x, grid[i + 1][j]);// checks for lower room of current room

				grid[i][j] += x;// updates cumulative sum of chocolates which he collects in this position
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			if (grid[0][i] > max)// so, the maximum values will be in last row. get max value
				max = grid[0][i];
		System.out.println(max);
	}
}
