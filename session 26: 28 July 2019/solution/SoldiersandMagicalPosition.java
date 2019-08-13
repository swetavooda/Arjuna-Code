/*
 * 
 * 

Sample Input:
0201 0101 0102 1212 2002
0202

Sample Output:
6

Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".


Sample Input:
8887 8889 8878 8898 8788 8988 7888 9888
8888

Sample Output:
-1

Explanation:
We can't reach the target without getting stuck.



 * 
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.*;

class SoldierPositions{

	public static int numOfSteps(String[] deadpoints, String target) {

		Set<String> deadpoint = new HashSet<String>();

		for (int i = 0; i < deadpoints.length; i++) {
			deadpoint.add(deadpoints[i]);//adding deadpoints
		}

		Set<String> seen = new HashSet<String>();
		Deque<String[]> q = new ArrayDeque<String[]>();
		
		//current position, and count of steps to reach current position
		q.addLast(new String[] { "0000", "0" });
		seen.add("0000");

		while (!q.isEmpty()) {
			String[] current = q.removeFirst();
			String state = current[0];//reading state from queue first element
			Integer count = Integer.parseInt(current[1]);
			if (!(deadpoint.contains(state))) {// not a deadpoint, generate next states
				if (state.equals(target))
					return count;//when current state is equal to target then return count
				count++;
				for (int i = 0; i < 4; i++) {//loop through all the soldiers
					char c = state.charAt(i);
					String s1 = state.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) 
																	+ state.substring(i + 1);

					String s2 = state.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) 
																	+ state.substring(i + 1);
					
					// not a deadend and not seen earlier, add to queue
					if (!deadpoint.contains(s1) && !seen.contains(s1)) {
						seen.add(s1);
						q.addLast(new String[] { s1, Integer.toString(count) });
					}
					if (!deadpoint.contains(s2) && !seen.contains(s2)) {
						seen.add(s2);
						q.addLast(new String[] { s2, Integer.toString(count) });
					}
				}

			}
		}
		return -1;
}

}

public class SoldiersandMagicalPosition {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] deadpoints = str.split(" ");
		String target = br.readLine();

		System.out.println(SoldierPositions.numOfSteps(deadpoints, target));

	}

}



