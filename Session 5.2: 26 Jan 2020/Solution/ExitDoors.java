/*
 * 
 A kingâ€™s palace has special rooms that form a 2D grid. 
Every room is labelled with different values. 
There are some rooms that you cannot enter, labelled as -1.
Rooms filled with gold are labelled as 500 and rooms that have exit points
to outside the palace are lablled as 0.
Write a program to read the grid of various types of rooms and 
replace the rooms  filled with gold with the distance to the nearest exit point. 
If an exit point cannot be reached from a gold room,
do not change it value.


Sample Input : 4
4
500  -1  0  500
500 500 500  -1
500  -1 500  -1
  0  -1 500 500
  
Sample Output :
3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4

Explantion : 

First line 4 represents total number of rows
â— First line 4 represents total number of cols
â— Next four lines represents the grid (G).
â— Values in each separated by a space
Explanation:
â— There are Exit Points at G(1,3) and G(4,1)
â— For the gold room at G(1,1), it takes 4 steps
to reach Exit Point (1, 3) due to wall at (1,2)
while it takes 3 steps to reach Exit Point
(4,1). Hence, G(1,1) is replaced with 3 in the
output.
â— For the gold room at G(4,4), it takes 7 steps
to reach G(4,1) due to walls in its path. It
takes 4 steps to reach G(1,3). Hence,
G(4,4) is replaced with 4 in the output.

Sample Input : 3
3
-1 0 500
500 -1 0
0 500 -1
  
Sample Output :
-1 0 1
1 -1 0
0 1 -1

Explantion : Grid with each empty room with the distance to its nearest gate.
  
 */

package ArjunaS5;

import java.util.*;

public class ExitDoors {
	
	    public static void wallsAndGates(int[][] rooms) {
	        if (rooms.length == 0 || rooms[0].length == 0) return;
	        Queue<int[]> queue = new LinkedList<>();
	        for (int i = 0; i < rooms.length; i++) {
	            for (int j = 0; j < rooms[0].length; j++) {
	                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
	            }
	        }
	        while (!queue.isEmpty()) {
	            int[] top = queue.remove();
	            int row = top[0], col = top[1];
	            if (row > 0 && rooms[row - 1][col] == 500) {
	                rooms[row - 1][col] = rooms[row][col] + 1;
	                queue.add(new int[]{row - 1, col});
	            }
	            if (row < rooms.length - 1 && rooms[row + 1][col] == 500) {
	                rooms[row + 1][col] = rooms[row][col] + 1;
	                queue.add(new int[]{row + 1, col});
	            }
	            if (col > 0 && rooms[row][col - 1] == 500) {
	                rooms[row][col - 1] = rooms[row][col] + 1;
	                queue.add(new int[]{row, col - 1});
	            }
	            if (col < rooms[0].length - 1 && rooms[row][col + 1] == 500) {
	                rooms[row][col + 1] = rooms[row][col] + 1;
	                queue.add(new int[]{row, col + 1});
	            }
	        }
	    }
	
	
	
	public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
			int R=scan.nextInt();
			int C=scan.nextInt();      

			int[][] rooms=new int[R][C];
		       for(int i=0; i<R; i++)
		       {
		           for(int j=0; j<C; j++)
		           {
		        	   rooms[i][j] = scan.nextInt();
		           }
		       }
		       wallsAndGates(rooms);
		       
		       
		       for(int i=0; i<R; i++)
		       {
		           for(int j=0; j<C; j++)
		           {
		        	   System.out.print(rooms[i][j]+" ");
		           }
		           System.out.println();
		       }
	}

}
