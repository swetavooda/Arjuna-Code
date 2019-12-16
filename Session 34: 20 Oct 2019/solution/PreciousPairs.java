

/*
Pick Precious Pairs


Sample input :
2 3
10 9

Sample output :
7

Explanation :
We will get 3 pairs of if we pick 7 stones from the box

Possible cases :
6 stones of type-1 and 1 stone of type-2 : we will get 3 pairs of type-1 stones
4 stones of type-1 and 3 stone of type-2 : we will get 2 pairs of type-1 and 1 pair of type-2
2 stones of type-1 and 5 stone of type-2 : we will get 1 pair of type-1 and 2 pairs of type-2
7 stones of type-1 : we will get 3 pairs of type-1


Sample input :
3 5
3 3 4

Sample output :
-1

Explanation :
There is no possibility to pick 5 pairs from the given set of stones we can get stones_arr max of 4 pairs(1 pair of type-1 + 1 pair of type-2 + 2 pairs of type-3)

/*

Test Cases :


input =5 8
10 20 30 40 50
output =20


input =4 3
5 6 2 1
output =9



input =6 4
5 9 13 15 2 1
output =13


input =10 15
4 10 6 7 2 3 6 9 12 13
output =39


input =3 5
2 4 3
output =-1


input =7 9
5 7 9 14 3 6 4
output =24



input =8 25
6 12 50 24 7 9 11 13
output =57

*/

import java.util.*;
import java.io.*;

public class PreciousPairs {
	public static void main(String args[]) {
		try {
			int stoneTypes, requiredPairs;
			int availablePairs = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String[] inputline = br.readLine().split(" ");
			stoneTypes = Integer.parseInt(inputline[0]);
			requiredPairs = Integer.parseInt(inputline[1]);

			int[] stonesArray = new int[stoneTypes];
			inputline = br.readLine().split(" ");

			// read total number of stones for each stone type and
			// find out the total number of pairs for each stone type
			for (int i = 0; i < stoneTypes; i++) {
				stonesArray[i] = Integer.parseInt(inputline[i]);
				availablePairs += stonesArray[i] / 2;
				stonesArray[i] -= 1;
			}

			if (availablePairs < requiredPairs) {
				System.out.println("-1");
			} else {
				int requiredStones = stoneTypes;
				int pairsByStoneType = 0;
				for (int i = 0; i < stoneTypes; i++) {
					if (stonesArray[i] >= 2) {
						requiredStones += stonesArray[i] / 2 * 2;
						pairsByStoneType += stonesArray[i] / 2;
					}
				}
				if (pairsByStoneType >= requiredPairs) {
					System.out.println(requiredPairs * 2 + stoneTypes - 1);
					System.exit(0);
				}
				System.out.println(requiredStones + requiredPairs - pairsByStoneType);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
