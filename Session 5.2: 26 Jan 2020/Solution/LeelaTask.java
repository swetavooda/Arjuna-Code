/*
 * 
 * 
 Leela is an award-winning Math teacher and on the occasion of Teacher's day she gave a task 
to her students. She has given N digits to the Students(1<N<10).

She then gave one magic number (M) the students. The task for the students is to find
the smallest possible number that can be formed with the digits given to them. 

And to find the number of times this number is of given number (M). If no such number 
is possible then output should be -1

Input Format:
The first line contain an Integer N, the number of digits.
The second line contains the N digits separated by blank space.
The third line is M, the given magical number.

Output Format:
Output contains the smallest number containing all digits at least once 
and is a multiple of M and 
how many times the smallest number is of the given number M separated by space, if possible
otherwise print -1

Sample 1:
input =
5           //N no.of digits
5 3 0 4 2   //N digits
10          //number M
output =
23450 2345  //23450 is least number formed which contains all n digits atleast once
            // and it is a multiple of 10 -> 2345 times

Sample 2:
input =
4
6 4 2 8
5
output =
-1

Explanation:
For Sample-0:-
    Given 5 digits are 2 3 0 4 5
    The least number that contains the digits, at least once and is a multiple of 10 is 23450 
    and is 2345 times of 10.

For Sample-1:-
    Given 4 digits are 2 4 6 8
    The least number that contains the digits, at least once is 2468,
    but it is not a multiple of 5. if a number has to be multiple of 5, the ending digit should
    be either '0' or '5'. We don't have such digit in the given set, So print -1.

 */

package ArjunaS5;

import java.util.*;
public class LeelaTask {
		public static boolean checkDigits(Map<Integer,Integer> map,int num) {
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer x = entry.getKey();
			int count = 0;
		for(String digit : Integer.toString(num).split("")) {
			if(!map.containsKey(Integer.parseInt(digit))) return false;
			if(x == Integer.parseInt(digit)) count++;
			
		}
		if(count < map.get(x)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {  
		Scanner sc = new Scanner(System.in);    
		int digits = sc.nextInt();
		int MAX = 0;
		// using treemap to store keys in reverse order
		 Map<Integer, Integer> map =  new TreeMap<Integer, Integer>(Collections.reverseOrder()); 
		for(int i=0;i<digits;i++) {
			int x = sc.nextInt();
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1);
			}
			else map.put(x, 1);               
		}
		int multiple = sc.nextInt();   
		Set<Integer> keys = map.keySet();
		// finding max possible value from given digits
        for(Integer num: keys){
            MAX=MAX*10 + num;

        }
    	//System.out.println(MAX);
		for(int i = multiple;i<=MAX;i += multiple) {
			if(checkDigits(map, i)) {    // Check whether all the digits are present for each number
				System.out.println(i);
				System.out.print((int)(i/multiple));
				System.exit(-1);
			}
		}
		System.out.println(-1);  
	}
}

