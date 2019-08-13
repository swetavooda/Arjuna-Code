/*
 * 
The i-th package has weight package[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 packages at the same time, 
provided the sum of the weight of those packages is at most limit.

Return the minimum number of boats to carry every given package.  
(It is guaranteed each package can be carried by a boat.)

Note:

1 <= package.length <= 50000
1 <= package[i] <= limit <= 30000
==============================================
Sample Input 1:
1 2
3

Sample Output 1: 
1

Explanation: 
we need 1 boat to carry all these packages (1, 2)
==============================================
Sample Input 2: 
3 2 2 1
3

Sample Output 2: 
3

Explanation:
The first line 3 2 2 1
represents the weights of packages.
The second line 3
maximum weight limit of a boat
we need 3 boats to carry all these packages
      (1, 2), (2) and (3)

==============================================

Approach:
---------
assign boat count to zero.
Sort the package list
repeat the following till all the packages are done
	take smallest package and largest package 
	increment the boat count
	check if sum of smallest and largest is less than or equal to limit
		if yes
		take next smallest
	take next largest

print boatcount
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PackageTransport {

	public static int minNumOfBoats(int[] packageList, int limit) {
		Arrays.sort(packageList);
		int i = 0, j = packageList.length - 1;
		int ans = 0;
	
		while (i <= j) {
		    ans++;
		    if (packageList[i] + packageList[j] <= limit)
		        i++;
		    j--;
		}
	
		return ans;
    	}
	public static void main(String[] args) throws IOException {
    	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] weights =input.split(" "); 
		int[] packageList = Arrays.asList(weights).stream().mapToInt(Integer::parseInt).toArray();
		int limit = Integer.parseInt(br.readLine());
	
		System.out.println(minNumOfBoats(packageList,limit));
        
    	}
}
