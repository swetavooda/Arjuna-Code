package session4;

/*
 * 

Sample Input:
4
8
HMHH
HHHH
HHHH
HHMH
MHHM
HHHH
HHHH
HHHH

Sample Output:
3

Explanation:
First line (4) â€“ Number of players
 Second line (8) â€“ Number of Rounds
 Next 8 lines â€“ Hit or Miss (by each player of the team)
 In 2nd and 3rd rounds, all members of the team, 
 hit perfect 10. Total consecutive Perfect 10â€™s = 2
 In 6th, 7th and 8th rounds, all members of the team, 
 hit perfect 10. Total consecutive Perfect 10â€™s = 3
Max between 2 and 3 is 3, Hence the answer is 3.

Approach:
---------
read the performances of all the players of each round and add them to a list( recordedPerformance )
declare two variables to hold current Perfect Tens value and maximum Perfect Tens value.
iterate through the list( recordedPerformance )
for each round repeat
	check if this round contains "M"(Miss).
		if yes
			assign curPerfectTen value to zero 
		else
			increment curPerfectTen value by one
	update the maxPerfectTen value

print the maxPerfectTen value


 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PerfectTens {

	static int maxPerfectTen(int m, List<String> recordedPerformance) {

		int curPerfectTen = 0;
		int maxPerfectTen = 0;
		// iterate through the list, if "M"(miss) found then reset the counter otherwise
		// increment the counter
		// then update maximum value
		for (String round : recordedPerformance) {
			if (round.contains("M")) {
				curPerfectTen = 0;
			} else {
				curPerfectTen += 1;
			}
			maxPerfectTen = Math.max(maxPerfectTen, curPerfectTen);
		}

		return maxPerfectTen;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());// Number of players
		int n = Integer.parseInt(br.readLine());// Number of Rounds
		List<String> recordedPerformance = new ArrayList<String>();

		for (int i = 0; i < n; i++)
			recordedPerformance.add(br.readLine());

		System.out.println(maxPerfectTen(m, recordedPerformance));

	}

}
