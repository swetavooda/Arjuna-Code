/*
*

Sample Input
11 2

Sample Output:
6

Explanation:

-> First line 11 2
   o 11 – represents the target gold coins (N)
   o 2 – represents the waste gold coins (P) to make a gold coin 
   
-> Peter initially makes 6 gold coins. From the waste pieces,
Peter makes 3 new coins with waster pieces left over.

-> From the waste pieces of the new coins, Peter makes 1
new coin and have waste pieces left from one coin.

-> From the new coin, Peter gets more waste pieces. He adds
the pieces and gets one (1) last coin. After making that,
There are not enough waste pieces left to make a new
coin. So a total of 11 coins are made.


Approach:
---------
we need n gold coins.
we can make k gold coins initially. the k is between 1 to n.
so, here we need to pick appropriate k between 1 to n.
to solve this kind of problem, we generally use binary search.

Binary Search Algorithm:
We basically ignore half of the elements just after one comparison.

Compare x with the middle element.
If x matches with middle element, we return the mid index.
Else If x is greater than the mid element, then x can only lie in right half subarray after the mid element. 
So we recur for right half.
Else (x is smaller) recur for the left half.

In our case , 
repeat 1 to n.
step 1. we pick middle element between 1 to n and check whether we can make n gold coins.
step 2. if yes, we print the middle element.
step 3. else if middle element is less than what we needed. then we need to pick element between middle_element+1 to n.
so, we repeat from step 1
step 5: if middle element is greater than what we needed. then we need to pick element between 1 to middle_element.
so, we repeat from step 1

at the end we print middle_element.
* 
*/

import java.util.Scanner;

public class Craftsman {

	static int initialGoldCoins(int k, int p) {
		int made = 0;
		int wastepieces = 0;

		while (k > 0) {
			made += k;
			wastepieces += k;

			k = wastepieces / p;
			wastepieces %= p;
		}

		return made;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int p = sc.nextInt();

		int lo = 1;
		int hi = n;
		// we use binary search here to pick appropriate number between a range.
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			int c = initialGoldCoins(mid, p);

			if (c < n)
				lo = mid + 1;
			else
				hi = mid;
		}

		System.out.println(hi);
	}

}
