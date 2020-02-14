/*
 * 
 * 

A fictitious gold mining company, make some bars with the gold ore, places marks at equal
lengths so the ore bar can be cut into blocks. Each piece of the bar has a number indicating the
gold available in that particular piece.
Assume that Rohan is given such a gold bar and asked to cut the bar into blocks of different
sizes and distribute amongst his F friends. Rohan would cut the bar into F+1 blocks using F
number of cuts. Each block shall have consecutive pieces from the bar. Rohan is not so greedy
so he decides to take piece or block (among F+1) blocks with the minimum total gold and give
the rest to his friends.
Given an array of probable gold available in each piece of ore gold bar, find the maximum total
gold that Rohan can get by cutting the bar into pieces optimally.


Sample Input:
1 2 3 4 5 6 7 8 9
5

Sample Output:
6

Explanation: 
 First Line 1 2 3 4 5 6 7 8 9 represent the probable weights
of gold that can be found in each piece. i.e., 1 st piece has
1 unit of gold, 2 nd piece has 2 units, 3 rd piece has 3 units
of gold, ..., 9 th unit has 9 units of gold
 Second Line 5 represents the number of friends
 Rohan has 5 friends so he must cut the bar into 5+1=6
blocks
 He can divide the bar into the 6 blocks [1,2,3], [4,5], [6], [7],
[8], [9]. The minimum sum of gold amongst those 6 blocks is 6.

===========================================================================================



input=1 5 7 8 9 4 6
3
output=8


input=899 187 144 196 157 144 123 357 186 258 755
10
output=123


input=899 187 144 196 157 144 123 357 186 258 755
4
output=444


input=2 187 6 196 8 144 123 357 1 258 3
6
output=8


input=2 187 6 196 80 144 123 357 1 258 3
2
output=347


input=2 187 6 196 80 144 123 357 1 258 3
1
output=619


input=2 187 6 196 80 144 123 357 1 258 3
0
output=1357


 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldQualityAndQuantity {

	public static int maximizeGold(int[] A, int K) {
        int left = 1, right = (int)1e9 / (K + 1);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int cur = 0, cuts = 0;
            for (int a : A) {
                if ((cur += a) >= mid) {
                    cur = 0;
                    if (++cuts > K) break;
                }
            }
            if (cuts > K)
                left = mid;
            else
                right = mid - 1;
        }
        return left;
    }
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] numbers = str.split(" ");
		int[] A = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		int K = Integer.parseInt(br.readLine());
		System.out.println(maximizeGold(A,K));

	}
}
