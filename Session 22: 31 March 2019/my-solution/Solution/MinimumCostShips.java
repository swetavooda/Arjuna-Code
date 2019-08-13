/*
 * 
There are n islands connected by m ships. 
Each ship starts from island u and arrives at v with a price w.

Now given all the islands and ships, 
together with starting island src and the destination dst, 
your task is to find the minimum price from src to dst with up to k stops. 
If there is no such route, output -1.

Note:
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of ships will be in range [0, n * (n - 1) / 2].
The format of each ship will be (src, dst, price).
The price of each ship will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated ships or self cycles.


Sample Input 1: 
3 3
0 1 100
1 2 100
0 2 500
0 2 1

Sample Output 1: 
200

Explanation: 
The graph looks like this:
	       0
	  100 / \ 500
	     /	 \
	    1-----2
	      100
The minimum price from island 0 to island 2 with at most 1 stop costs 200.

Sample Input 2: 
3 3
0 1 100
1 2 100
0 2 500
0 2 0

Sample Output 2: 
500

Explanation: 
The graph looks like this:
	       0
	  100 / \ 500
	     /	 \
	    1-----2
	      100

The minimum price from island 0 to island 2 with at most 0 stop costs 500.

Approach:
---------
Here we are using BFS.
and calculating minimum path distance by considering atmost K stops in between source and destination.

 * 
 * 
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MinimumCostShips {

	public static int findMinPrice(int n, int[][] adj, int src, int dst, int K) {
		if (src == dst) {
			return 0;
		}
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		dist[src] = 0;
		int layOffs = 0;
		//repeat the loop untill k stops or visiting all the islands.
		while (!queue.isEmpty() && layOffs <= K) {
			layOffs++;
			int size = queue.size();
			int[] distClone = Arrays.copyOf(dist, dist.length);

			for (int i = 0; i < size; i++) {
				int vertex = queue.poll();
				for (int j = 0; j < adj[vertex].length; j++) {
					if (adj[vertex][j] != 0) {
						if (dist[vertex] + adj[vertex][j] < distClone[j]) {
							distClone[j] = dist[vertex] + adj[vertex][j];
							queue.add(j);
						}
					}
				}
			}
			dist = distClone;
		}
		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int numOfIslands = sc.nextInt();
		int numOfShips = sc.nextInt();

		int[][] adj = new int[numOfIslands][numOfIslands];
		int u, v, price;
		for (int i = 0; i < numOfShips; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			price = sc.nextInt();
			adj[u][v] = price;
		}
		int src = sc.nextInt();
		int dst = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(findMinPrice(numOfIslands, adj, src, dst, K));
	}
}
