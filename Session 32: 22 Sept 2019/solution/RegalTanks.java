

/*


Sample input 1:
5
2 4
3 6
4 5
2 3
1 2

Sample output 1:
3

Explanation :
 First line 5 indicates no of tanks
 Next 5 lines indicate each tank length and breadth

 The maximum number of Tanks placed inside another tanks is 3 
 Tank 1 2 can be placed inside tank 2 3
 Tank 2 3 can be placed inside tank 4 5 


Sample input 2:
3
5 4
3 6
4 5


Sample output 2:
0

Explanation :
 We can't place any of the tank one inside another because of their sizes
 The maximum number of Tanks placed inside another tanks is 0 

/***************************************************************************
Sample Input/Outputs which were used againist your solution to evaluate:
------------------------------------------------------------------------

SAMPLE 1:
input =6
2 3
4 5
1 2
6 4
2 8
5 3
output =3

SAMPLE 2:
input =3
1 1
1 1
1 1
output =1

SAMPLE 3:
input =5
1 2
2 3
3 4
4 5
5 6
output =5

SAMPLE 4:
input =6
1 2
2 3
3 4
4 5
5 6
6 7
output =6

SAMPLE 5:
input =8
1 2
2 3
3 4
4 5
5 6
6 7
8 9
7 11
output =7


SAMPLE 6:
input =9
1 2
2 3
3 4
4 5
5 6
6 7
8 9
7 11
10 15
output =8

SAMPLE 7:
input =12
1 2
2 3
3 4
4 5
5 6
6 7
8 9
7 11
10 15
20 30
40 50
60 70
output =11





*****************************************************************************

*/


import java.util.*;
import java.io.*;
class RegalTanks {

  public static int getMaxTankGroup(int[][] tanks) {
    Arrays.sort(tanks, (a, b) -> a[0] - b[0]);
    int max = 0;
    int tankGroups [] = new int [tanks.length];
    for(int i = 0; i < tanks.length; i++){
    	tankGroups[i] = 1;
        for(int j = 0; j < i; j++){
            if(tanks[j][0] < tanks[i][0] && tanks[j][1] < tanks[i][1])
            	tankGroups[i] = Math.max(tankGroups[i], tankGroups[j] + 1);
        }
        max = Math.max(tankGroups[i], max);
    }
    return max;
}


public static void main(String args[])
	{
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 
			int n=Integer.parseInt(br.readLine());

		int[][] tanksInfo= new int[n][2];
                for(int i=0;i<n;i++){
                        String sin =br.readLine();
			String[] s = sin.split(" "); 
			tanksInfo[i][0]=Integer.parseInt(s[0]);
			tanksInfo[i][1]=Integer.parseInt(s[1]);
			
		}
		System.out.println(getMaxTankGroup(tanksInfo));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
