

/*

Sample input :
5
10 20
25 50
60 75
20 80
30 90


Sample output :
4

Explanation :

    â€¢ First line 5 corresponds to number of coupons
    â€¢ Next four (5) lines has wait_hours and expiry_hour of every coupon
    â€¢ First, take the 1st coupon, it costs 10 hours so you will finish it on the 10th hour, and ready to take the next coupon on the 11th hour.
    â€¢ Second, take the 2nd coupon, it costs 25 hours so you will finish it on the 25th hour, and ready to take the next coupon on the 26th hour. 
    â€¢ Third, take the 4th coupon, it costs 20 hours so you will finish it on the 45th hour, and ready to take the next coupon on the 46th hour.
    â€¢ Fourth, take the 5th coupon, it costs 30 hours so you will finish it on the 75th hour, and ready to take the next coupon on the 76th hour.
    â€¢ The 3rd coupon cannot be taken now, since you will finish it on the 135th hour, which exceeds the expire hour 75.
    â€¢ So, the customer can take 4 coupons at most.


/*



input =3
2 5
3 4
1 2
output =2


input =5
20 30 
25 40
38 62
19 25
7 90
output =3


input =10
2 6
1 8
3 9
7 6
3 15
9 26
15 30
11 40
19 60
17 45
output =7


input =7
15 30
11 40
3 15
9 26
19 60
7 6
17 45
output =5


input =4
6 5
2 1
3 2
10 9
output =0


input =6
6 5
2 1
3 2
10 9
15 25
20 21
output =1


input =6
20 40
2 1
3 2
10 9
15 25
15 14
output =2


*/

import java.util.*;
import java.io.*;

public class AttractiveCoupons {
	public static int getMaxRedeemCount(int[][] coupons) {

		// sort coupons by expiry hours
		Arrays.sort(coupons, (a, b) -> a[1] - b[1]);

		int ccWaitHours = 0, redeemMaxCount = 0;

		for (int i = 0; i < coupons.length; i++) {
			if (ccWaitHours + coupons[i][0] <= coupons[i][1]) {
				ccWaitHours += coupons[i][0];
				redeemMaxCount++;
			} else {
				int curMaxWaitIndex = i;
				for (int j = 0; j < i; j++) {
					if (coupons[j][0] > coupons[curMaxWaitIndex][0])
						curMaxWaitIndex = j;
				}
				if (coupons[curMaxWaitIndex][0] > coupons[i][0]) {
					ccWaitHours += coupons[i][0] - coupons[curMaxWaitIndex][0];
				}
				coupons[curMaxWaitIndex][0] = -1;
			}
		}
		return redeemMaxCount;
	}

	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int[][] coupons = new int[n][2];
			for (int i = 0; i < n; i++) {
				String[] inputLine = br.readLine().split(" ");
				coupons[i][0] = Integer.parseInt(inputLine[0]);
				coupons[i][1] = Integer.parseInt(inputLine[1]);
			}
			System.out.println(getMaxRedeemCount(coupons));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
