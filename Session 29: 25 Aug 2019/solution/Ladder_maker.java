/*



Sample input :
1 3 5 7 9 15 20 25 28 29

Sample output:

7

Explanation :

possible ladders (1,3,5),(3,5,7),(1,3,5,7),(5,7,9),(3,5,7,9),(1,3,5,7,9)(15,20,25)



*/


import java.util.*;
import java.io.*;
public class Ladder_maker
{
   public static void main(String[] args) throws IOException
   {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	String str = br.readLine();
	String[] steps = str.split(" ");
	int[] steps_arr = Arrays.asList(steps).stream().mapToInt(Integer::parseInt).toArray();
	
	int result=numberOfLadders(steps_arr);
	System.out.println(result);
   }

public static int numberOfLadders(int[] A) {
        int[] pSol = new int[A.length];
        int ladders = 0;
        for (int i = 2; i < pSol.length; i++) { // strating with 3rd step going through all steps for possible ladders 
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) { //checking current step - previous diff with next - current 
                pSol[i] = 1 + pSol[i - 1]; 
                ladders += pSol[i];// so minimum steps condition satisfies so updating ladders count
            }
        }
        return ladders;
    }


}


