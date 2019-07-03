
/*
Sample Input 1:
4
1 2 1 1
1 3

Sample Output 1:
2

Explanation 1:

Mihika's walk starts with node 1. She goes to node 4 by incurring a cost of 1. 
Then from node 4, she goes to node 3 by incurring a cost of 1 more. 
Total cost incurred is 2.

Sample Input 2:
5
-5 100 100 100 2
1 5

Sample Output 2:
-    8

Explanation 2:

Mihika goes from 1 to 2 by incurring a cost of -5. 
Then from 2 to 1 using the edge second time and incurring cost of -5 again. 
Now, she can not use the edge between 1 and 2 again, as he has traversed the edge already twice. 
Now he will go from node 1 to node 5 by paying a cost of 2. 
Total sum of costs incurred is -5 + -5 + 2 = -8. 
This is the minimum possible cost that Mihika can have.

 * 
 */

import java.util.*;

public class CircularPaths {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R[] = new int[N];
		for (int i = 0; i < N; i++) {
			R[i] = sc.nextInt();
		}
		int start = sc.nextInt() - 1;
		int end = sc.nextInt() - 1;

		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();
	
		// left side index of an edge
		for (int i = start; i < end; i++) {
			left.add(R[i]);
		}
	
		// right side index of an edge
		for (int i = end;; i = (i + 1) % N) {
			if (i == start)
				break;
			right.add(R[i]);
		}
		
		System.out.println(findMinCost(left, right));

	}

	private static long findMinCost(ArrayList<Integer> left, ArrayList<Integer> right) {
		long sumLeftPaths = 0, sumRightPaths = 0, maxLeftPath = 0, sumsofar = 0;
		// calculate total left side distance, from start to end
		// and , maximum left side distance from start to end
		
		for (int i = 0; i < left.size(); i++) {
			sumLeftPaths += left.get(i);
			sumsofar = Math.max(sumsofar + left.get(i), left.get(i));
			maxLeftPath = Math.max(maxLeftPath, sumsofar);
		}
		
		// calculate total right side distance, from start to end
		// and , maximum right side distance from start to end

		long maxRightPath = 0;
		sumsofar = 0;
		for (int i = 0; i < right.size(); i++) {
			sumRightPaths += right.get(i);
			sumsofar = Math.max(sumsofar + right.get(i), right.get(i));
			maxRightPath = Math.max(maxRightPath, sumsofar);
		}
		// calculate the cost for left side path and right side path
		long path1 = sumLeftPaths + 2 * (sumRightPaths - maxRightPath);
		long path2 = sumRightPaths + 2 * (sumLeftPaths - maxLeftPath);
		
		System.out.println("Path1=" + path1 + ", Path2=" + path2);
		// find the minimum cost between two paths and return
		return Math.min(path1, path2);
	}
}
