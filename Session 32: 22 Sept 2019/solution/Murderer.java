
/*
Sample input :
 
4  5
1  3
1  4
2  3
2  4
4  3
Sample output :
4
Explanation :


/***************************************************************************
Sample Input/Outputs which were used againist your solution to evaluate:
------------------------------------------------------------------------


SAMPLE 1:
input =5 5
1 5
1 4
2 5
3 5
4 5
output =5

SAMPLE 2:
input =3 3
1 2
2 3
3 1
output =-1

SAMPLE 3:
input =4 3
2 1
3 1
4 1
output =1

SAMPLE 4:
input =5 4
1 2
3 2
4 2
5 2
output =2

SAMPLE 5:
input =6 6
1 3
2 3
2 4
4 3
5 3
6 3
output =3

SAMPLE 6:
input =6 6
1 6
2 6
2 4
4 6
5 6
3 6
output =6

SAMPLE 7:
input =7 6
1 7
2 7
3 7
4 7
5 7
6 7
output =7



*****************************************************************************
*/

import java.util.*;
import java.io.*;

class Murderer {

	public static int findMurderer(int N, int[][] talkingInfo) {
		int[] talkInstances = new int[N + 1];
		for (int[] t : talkingInfo) {
			talkInstances[t[0]]--;
			talkInstances[t[1]]++;
		}
		for (int i = 1; i <= N; ++i) {
			if (talkInstances[i] == N - 1)
				return i;
		}
		return -1;
	}

	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			String[] input = line.split(" ");
			int nSuspects = Integer.parseInt(input[0]);
			int nInstances = Integer.parseInt(input[1]);
			int[][] talkingInfo = new int[nInstances][2];
			for (int i = 0; i < nInstances; i++) {
				String sin = br.readLine();
				String[] s = sin.split(" ");
				talkingInfo[i][0] = Integer.parseInt(s[0]);
				talkingInfo[i][1] = Integer.parseInt(s[1]);
			}
			System.out.println(findMurderer(nSuspects, talkingInfo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
