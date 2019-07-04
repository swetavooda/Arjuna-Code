
/*
 * 

Sample Input1
4 - Number of children and lunch boxes
0 0 1 0 - Types of lunch boxes
1 0 0 0 - Preferences of a student 

Output1
0

Sample Input2
6
0 1 1 0 1 0
1 1 1 0 1 0

output2
1

Approach:
--------
store lunch boxes in one list and student preferences in one list.
loop start:
take one box(a) from list and take one student preference(b) from student preferences list
	check if both are match
	if yes,
		decrement the students count
		remove the box and student from the lists
	if no,
		remove the current student preference from list and add it to the end of the list
loop end till 
the two lists are empty(st.size() > 0 && box.size() > 0 && n)
and 
the preferences of student donot match even after checking entire list(i < st.size())

Print the number of student who are not able to eat lunch

 * 
 */

import java.util.*;

public class WhoMissedLunch {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> box = new ArrayList<>();
		ArrayList<Integer> st = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			box.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			st.add(sc.nextInt());
		}

		int i = 0;
		while (st.size() > 0 && box.size() > 0 && n > 0 && i < st.size()) {
			int a = st.get(0);
			int b = box.get(0);

			if (a == b) {
				n--;
				st.remove(0);
				box.remove(0);
				i = 0;
			} else {
				int c = st.remove(0);
				st.add(c);
				i++;
			}
		}
		System.out.print(n);

	}		
}
