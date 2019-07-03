
/*

Sample Input: 
4 3
1 2
2 3
1 4
1

Sample Output:
3 1 2

Explanation:
		
Graph shown like below
 S
(1)-------(4)
 |
 |
(2)-------(3)

Here the source node is 1 (marked S).
The distance from 1 to 2 is 3. Path: 1 -> 3 -> 4 -> 2
The distance from 1 to 3 is 1. Path: 1 -> 3
The distance from 1 to 4 is 2. Path: 1 -> 3 -> 4 

 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ChambalDacoit {

	static ArrayList<Integer>[] roads;
	static private int[] distance;
	static private int[] state;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int numOfVillages = sc.nextInt();
		int numOfMainRoads = sc.nextInt();

		roads = new ArrayList[numOfVillages];

		// creating adjacency list
		for (int j = 0; j < numOfVillages; j++) {
			roads[j] = new ArrayList<Integer>();
		}

		// populate adjacency list
		for (int j = 0; j < numOfMainRoads; j++) {

			int village1 = sc.nextInt() - 1;
			int village2 = sc.nextInt() - 1;

			roads[village1].add(village2);
			roads[village2].add(village1);
		}

		int s = sc.nextInt() - 1;// current position of Rampur
		int shortDistance[] = breadthFirstSearch(s);

		for (int j = 0; j < shortDistance.length; j++) {
			if (j == s) {// skip distance to current position of Rampur
				continue;
			}
			System.out.print(shortDistance[j] + " ");
		}

	}

	static int[] breadthFirstSearch(int s) {

		java.util.LinkedList<Integer> q = new java.util.LinkedList<Integer>();
		distance = new int[roads.length];
		state = new int[roads.length];

		// Mark all nodes unvisited
		for (int i = 0; i < roads.length; i++) {
			state[i] = -1;
			distance[i] = -1;
		}
		// setup the traversal. Starting Node s (Rampur)
		q.add(s);
		state[s] = 0;
		distance[s] = 0;

		while (q.size() != 0) {
			int hold = q.removeFirst();
			// take the village(hold) and find the kutcha roads from village hold to other
			// villages
			// villages.
			for (int i = 0; i < roads.length; i++) {

				// check whether the current village(i) is already covered or not and
				// check whether the road is available or not
				// if village is not covered and has side lane to the village then
				if (state[i] == -1 && !roads[hold].contains(i)) {

					q.add(i);// add the village(i) to the queue, which has village road and not covered yet.
					state[i] = 0;
					distance[i] = distance[hold] + 1;// updated the distance of current village

				}
			}
			//
			state[hold] = 1;// mark the current village(hold) as 1
			for (int i = 0; i < distance.length; i++) {
				if (distance[i] == -1) {// need to calculate kutcha road to 'i'
					break;
				}
				if (i == distance.length - 1) {// if all village distances are calculated
					return distance;
				}
			}
		}
		return distance;
	}
}
