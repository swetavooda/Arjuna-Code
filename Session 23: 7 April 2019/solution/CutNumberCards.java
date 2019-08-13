
/*
 * 
Cut Number Cards
----------------
Assume a card contains a sequence of numbers, treated as string, s. That string s is beautiful if it 
can be split into a sequence of two or more positive integers, a[1],a[2],…,a[n], 
satisfying the following conditions:
1. a[i] – a[i-1] = 1 for any 1< i <= n (i.e., each element in the sequence is one more than the
previous element).
2. No a[i] contains a leading zero. For example, we can split s=10203 into the sequence {1, 02, 03},
but it is not beautiful because 02 and 03 have leading zeroes.
3. The contents of the sequence cannot be rearranged. For example, we can split s=312 into the
sequence {3, 1, 2}, but it is not beautiful because it breaks our first constraint (i.e., 1- 3 is not
equal to 1).
Samples of beautiful strings
1. “1234” = “1” + “2” + “3” + “4”
2. “91011” = “9” + “10” + “11”
3. “99100” = “99” + “100”
Given a card with integer string, write a program to print whether or not the integer string is beautiful
on a new line. If it is beautiful, print YES x, where x is the first number of the increasing sequence.
If there are multiple such values of x, choose the smallest. Otherwise, print NO

Input Format
------------
String S

Output Format
-------------
print its answer 
(i.e., either YES x where is the smallest first number of the increasing sequence, or NO).

Constraints
-----------
1<=|S|<=32
S[i] contains [0-9]

Sample Input 1
--------------
91011

Sample Output 1
---------------
YES 9

Explanation:
91011 can be split into the sequence of 9 10 11.

Sample Input 2
--------------
13

Sample Output 2
---------------
NO

Explanation:
the only possible split is {1,3}, which violates the first condition.

Sample Input 3
--------------
101103

Sample Output 3
---------------
NO

Explanation:
all possible splits violate the first and/or second conditions.



Algorithm:
----------
we can do this program by writing a simple recursive function.

Read the input string
split the string and call the recursive function
write a recursive function to validate
	check whether the current string is empty, if empty return "true"
	check whether the first character of current string is '0' , if yes return "false"
	loop through current string
		check (parameter val)+1 and current string starting number are equal.
		if yes, call the recursive function with the parameters of val+1,remaining string

	return false

	

 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutNumberCards {

	static boolean isValid(long val, String curr) {
		if (curr.equals(""))
			return true;
		if (curr.charAt(0) == '0')
			return false;
		for (int i = 0; i < Math.min(curr.length(), Long.toString(val).length() + 1); i++)
			if (Long.parseLong(curr.substring(0, i + 1)) == val)
				return isValid(val + 1, curr.substring(i + 1));
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String in = br.readLine();
		if (in.charAt(0) == '0') {
			System.out.println("NO");
		}
		long ans = Long.MAX_VALUE;
		for (int i = 0; i < in.length() / 2; i++) {
			long start = Long.parseLong(in.substring(0, i + 1));

			if (isValid(start + 1, in.substring(i + 1)))
				ans = Math.min(ans, start);

		}
		if (ans != Long.MAX_VALUE)
			System.out.println("YES " + ans);
		else
			System.out.println("NO");

		System.out.close();
	}



}
