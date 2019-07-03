/*

Sample Input: 
8 2
7 2 4 6 5 9 12 11

Sample Output:
3

Explanation:
		=================	================|====
<---------------*-------------------*-----------*------------------------>
	|	|	|	|	|	|	|	|	|	|	|	|	|	|	|
	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
	    -       -   -   -   -       -       -   -

We can cover the entire street by placing  3 LED lamps(*) on houses at locations 4, 9, and 12.

Approach:
--------
read the houses and sort them in ascending order of their position
initialise minLamps to 0
repeat for all the houses
    take first two houses,currentHouseIndex and nextHouseIndex
        step1:
            take the difference of currentHouse and nextHouse locations.
            check whether they are under the illuminateCapacity or not.
            if yes then increment nextHouseIndex , repeat step1
        step2:
            update the currentHouseIndex with nextHouseIndex-1. because we moved one step ahead.
        step3:
        repeat step1 & step2
    increment minLamps
print minLamps

 * 
 */

import java.util.*;

public class IlluminatingStreets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfHouses = sc.nextInt();
        int illuminateCapacity = sc.nextInt();
        int[] house = new int[numOfHouses];
        for(int i=0;i<numOfHouses;i++)
        	house[i] = sc.nextInt();
        
        Arrays.sort(house);
      
        int minLamps = 0;
        
       
        for (int currentHouseIndex = 0; currentHouseIndex < numOfHouses; currentHouseIndex++) {
        	
          int nextHouseIndex = currentHouseIndex+1;
          //find the position which covers till current position of nextHouseIndex-1
          while (nextHouseIndex  < numOfHouses && house[nextHouseIndex] - house[currentHouseIndex] <= illuminateCapacity) {
            nextHouseIndex++;
          }
          currentHouseIndex = nextHouseIndex-1;//update the current position
          //find the next index which covers from currentHouseIndex to nextHouseIndex,
          //which is right side of currentHouseIndex.
          //now if we place radio transmitter at currentHouseIndex, 
          //this will cover from previous currentHouseIndex to nextHouseIndex.  
          while (nextHouseIndex < numOfHouses && house[nextHouseIndex] - house[currentHouseIndex] <= illuminateCapacity){
            nextHouseIndex++;
          }
          currentHouseIndex = nextHouseIndex-1;//update the current position
          minLamps++;//two sides of the currentHouseIndex is covered so increment minLamps
        }
        
        System.out.println(minLamps);
    }

}