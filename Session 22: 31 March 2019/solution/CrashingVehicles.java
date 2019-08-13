/*
 * 
We are given an array vehicles of integers representing vehicles in a row.

For each vehicle, the absolute value represents its size, and the sign represents its direction 
(positive meaning right, negative meaning left). Each vehicle moves at the same speed.

Find out the  vehicles which are not crashed after all collisions. If two vehicles meet, the smaller one will crash. 
If both are the same size, both will crash. Two vehicles moving in the same direction will never meet.

Sample Input: 
5 10 -5

Sample Output:
5 10

Explanation: 
The 10 and -5 collide and -5 will be crashed resulting in 10.  
The 5 and 10 never collide.

Sample Input: 
8 -8

Output: 
-1

Explanation: 
The 8 and -8 collide and crash each other. 
all vehicles will crash.so we will print -1.


Intuition
==========
A row of vehicles is stable if no further collisions will occur. 
After adding a new vehicle to the right, 
some more collisions may happen before it becomes stable again, 
and all of those collisions (if they happen) must occur right to left. 
This is the perfect situation for using a stack.

Algorithm
==========
Say we have our answer as a stack with rightmost vehicle top, and a new vehicle comes in. 
If new is moving right (new > 0), or if top is moving left (top < 0), no collision occurs.

Otherwise, if abs(new) < abs(top), then the new vehicle will blow up; 
if abs(new) == abs(top) then both vehicles will blow up; 
and if abs(new) > abs(top), then the top vehicle will blow up 
(and possibly more vehicles will, so we should continue checking.)



 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CrashingVehicle {

	public static int[] crashingVehicle(int[] asteroids) {
		Stack<Integer> stack = new Stack();
		for (int ast : asteroids) {
			collision: {
				while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
					if (stack.peek() < -ast) {
						stack.pop();
						continue;
					} else if (stack.peek() == -ast) {
						stack.pop();
					}
					break collision;
				}
				stack.push(ast);
			}
		}

		int[] ans = new int[stack.size()];
		for (int t = ans.length - 1; t >= 0; --t) {
			ans[t] = stack.pop();
		}
		return ans;
	}

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] numbers = str.split(" ");
		int[] asteroids = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		int[] remainingAsteroids = crashingVehicle(asteroids);

		Arrays.stream(remainingAsteroids).forEach(s -> System.out.print(s + " "));

	}

}
