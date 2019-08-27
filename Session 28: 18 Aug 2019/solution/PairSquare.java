/*

PairSquare


In an array Arr with positive integers , 
When two adjacent numbers form a perfect square 
you have found a pair square.

Given an array, find the number of ways in 
which the numbers in the array can be arranged 
such that all pairs form perfect squares.
Two permutations of Arr1 and Arr2 differ
if and only if there is one index j such that Arr1[j] != Arr2[j]

Note :
1 <= Arr.length <= 12


Sample Input :

6 15 10

Sample Output :

2

Explanation :

6+10 and 10+15 are valid Pairs when array values  are 6 10 15

15+10 and 10+6 are valid Pairs when array values  are 15 10 6
 
[6,10,15] and [15,10,6] are the valid permutations.




Sample Input :

1 3 5

Sample Output :

0

Explanation :

No Possible permutations found for array 1 3 5




*/

import java.util.*;
import java.io.*;

class PairSquare {
   static Map<Integer, Integer> count;
   static Map<Integer, List<Integer>> graph;
    public static int numSquarefulPerms(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : number of v's in A
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // graph.get(v) : values w in A for which v + w is a square
        //                (ie., "vw" is an edge)
        for (int x: count.keySet())
            graph.put(x, new ArrayList());

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                int r = (int) (Math.sqrt(x + y) + 0.5);
                if (r * r == x + y)
                    graph.get(x).add(y);
            }

        // Add the number of paths that start at x, for all possible x
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;
    }

    public static int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;  // default if todo == 0
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) if (count.get(y) != 0) {
                ans += dfs(y, todo - 1);
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

 public static void main(String []args) throws IOException {
      		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] numinstrings = str.split(" ");
		int[] numbers = Arrays.asList(numinstrings).stream().mapToInt(Integer::parseInt).toArray();
           System.out.print(numSquarefulPerms(numbers));
	 
    }


}
