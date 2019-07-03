/*
 * 
 
Input Format
------------
First line of the input contains 3 integers N, S and E. 
N is the number of checkpoints that the Indian Army has on the border.
Then N lines follow. ith line contains 2 integers, xi and pi.

Output Format
-------------
Print the total distance of the x-axis from S to E, that is not protected by the armed forces.

Sample Input:
5 229 8419
1795 95
4873 720
3149 81
6101 2325
3674 629

Sample Output:
2626

Explanation:
From Starting position (s)  to  End position(E), the total area 
which is not covered by any of the security teams is 2626.


ALGORITHM:
1) Find all the segments which are secured in ascending order of their distance from origin 
(if distance from origin is same, sort acc. to lengths).
2) start scanning all segments sorted in step 1 and add the unsecured area to the total count
3) total count is the required answer.

 * 
 */

import java.util.*;

public class ShippingGoldContainer
{
	
	static class pair implements Comparable<pair>
	{
		Long x, y;
		pair(long x,long y)
		{
			this.x=x;
			this.y=y;
		}
		public int compareTo(pair o) {
			return x.compareTo(o.x);
		}  
	}
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
		int numCheckPoints =sc.nextInt();
		long startPos = sc.nextLong();
		long endPos = sc.nextLong();
		
		pair[] areaDefended = new pair[numCheckPoints];
		for(int i=0;i<numCheckPoints;i++)
		{
			long x = sc.nextLong();
			long p = sc.nextLong();
			areaDefended[i] = new pair(x-p,x+p);
		}
		
		Arrays.sort(areaDefended);
		ArrayList<pair> b = new ArrayList<pair>();
		
		long c = areaDefended[0].x;
		long d = areaDefended[0].y;
		
		//merging the defended segments if any
		for(int i=1;i<numCheckPoints;i++)
		{
			if(areaDefended[i].x<=d)
				d = Math.max(d, areaDefended[i].y);
			else
			{
				b.add(new pair(c,d));
				c = areaDefended[i].x;
				d = areaDefended[i].y;
			}
		}
		b.add(new pair(c,d));
		int i;
		long ans = 0;
		for(i=0;i<b.size();i++)
		{
			if(startPos>=endPos)
			{
				startPos = endPos;
				break;
			}
			//if starting position is in between current segment
			if(b.get(i).x<=startPos && startPos<=b.get(i).y)
				startPos = b.get(i).y;
			//if current segment is in between starting position & ending position
			else if(startPos<=b.get(i).x && endPos>=b.get(i).y)
			{
				ans+=b.get(i).x-startPos;
				startPos = b.get(i).y;
				
			}//if ending position lies between current segment
			else if(startPos<=b.get(i).x && endPos>=b.get(i).x &&  endPos<=b.get(i).y)
			{
				ans+=b.get(i).x-startPos;
				startPos = endPos;
			}
			//if starting position & ending position are before the current segment
			else if(startPos<=b.get(i).x && endPos<=b.get(i).x)
			{
				ans+=endPos-startPos;
				startPos = endPos;
			}
		}
		//add the distance which is not covered in above segments
		if(startPos<endPos)
			ans+=endPos-startPos;
		System.out.println(ans);
		
	}
}
