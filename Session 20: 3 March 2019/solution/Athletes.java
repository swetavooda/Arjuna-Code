/*

Sample Input
10
1 3 7 2 5 1 4 2 1 5

Sample Output:
-1 2 2 1 1 -1 2 1 -1 -1


Approach:
--------
we use stack data structure here.
Initialize an empty answer array
repeat for all players
pick one by one player(i), check if he is in stack or not
	if no, push him to the stack
	else, 
	repeat loop till stack is empty or finds a break
		take top player from stack, 
			check medals of top player<medals of current player(i)
			if no, then break the loop
			if yes, replace top player code with current player code in answer array
				remove top player from stack
	end loop
	push current player into the stack
end of all players

repeat till stack is empty
	remove top player from stack
	assign -1 to top player in answer array
end of loop
print answer array

*/

import java.util.*;

public class Athlets {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int numOfAthlets = sc.nextInt();
		int codes[] = new int[numOfAthlets];
		int cntOfMedalsByCode[] = new int[100001];
		int ans[] = new int[numOfAthlets];
		for (int i = 0; i < numOfAthlets; i++) {
			codes[i] = sc.nextInt();
			cntOfMedalsByCode[codes[i]]++;
		}
		for (int i = 0; i < numOfAthlets; i++) {
			System.out.print(cntOfMedalsByCode[codes[i]]+" ");
		}
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < numOfAthlets; i++) {
			if (s.isEmpty())
				s.push(i);
			else {
				while (!s.isEmpty()) {
					int top = s.peek();
					if (cntOfMedalsByCode[codes[top]] < cntOfMedalsByCode[codes[i]]) {
						
						ans[top] = codes[i];
						s.pop();
					} else
						break;
				}
				s.push(i);
			}
		}
		while (!s.isEmpty()) {
			int top = s.pop();
			ans[top] = -1;
		}
		for (int i = 0; i < numOfAthlets; i++)
			sb.append(ans[i] + " ");
		System.out.println(sb);

	}
}
