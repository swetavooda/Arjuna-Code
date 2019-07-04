package session4;

/*
 * 
Sample Input:
3 5 4
1 5
2 4
3 4
5 4

Sample Output:
2

Explanation:
First line 3 5 4
3 – Number of trainees.
5 – Number of junctions points
4 – Number of narrow roads.
	5 – is the finishing point.
Three trainees positioned at 1, 2 and 3 junctions.
Trainee at junction-1 will finish the race in 1 unit time i.e., 1->5
Trainees 2 and 3 will take 2 units of time i.e., 2 -> 4 -> 5, 3 ->4 ->5
Hence, the answer is 2.

Approach:(Simple BFS Algorithm)
-------------------------------
The question requires a reversal of approach. 
Instead of trying to find the shortest distance to the finish line(node N) 
from each of the starting points(nodes 1 to S).this is general shortest path algorithm.

we will find the shortest distance from node N to nodes 1 to S.

This can be done using shortest path algorithms like Dijkstra's or by using a BFS, since the graph is unweighted.
Here, we are using BFS reversal approach.

Once the shortest distances to all nodes are found, 
it is just a matter of finding the count of the maximum distances.
In our problem ,we assume that the distance in the graph is time.

 * 
 */

import java.io.*;
import java.util.*;

public class CommandosTraining {

	static ArrayList<Integer> adj[];

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int N = sc.nextInt();
		int E = sc.nextInt();
		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		dis = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		bfs(N);
		// after BFS on N, find maximum time
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= S; i++) {
			if (dis[i] > max)
				max = dis[i];
		}
		// count the trainees whose time is equal to maximum
		int c = 0;
		for (int i = 1; i <= S; i++) {
			if (dis[i] == max)
				c++;
		}
		System.out.println(c);
	}

	static boolean visited[];
	static int dis[];

	public static void bfs(int n) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = true;
		while (!queue.isEmpty()) {
			int f = queue.poll();
			for (int i = 0; i < adj[f].size(); i++) {
				int x = adj[f].get(i);
				if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
					dis[x] = dis[f] + 1;
				}
			}
		} // end of while
	}// end of bfs
}
