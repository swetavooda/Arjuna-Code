/*

Given number (N) of lines (extending to infinity) in both directions are drawn on a plane. The lines are specified by the angle (positive or negative) made with the x axis (in degrees). It may be assumed that the different lines are not coincident (they do nnot overlap each other) and that no three of them are concurrent (no three of them pass through the same point).
The objective is to determine the number of triangles formed by the a set of these lines
If the lines are given with an angle of 10, 70, 30 and 30.

L1 is at 10 degrees to the x axis, L2 is at 70 degrees to the x axis, L3 and L4 are at 30 degrees to the x axis. 
It can be seen that there are two triangles (L1,L2,L3 and L1,L2,L4). L3 and L4 do not meet as they are parallel.

Constraints
N<=50
-89 <= angle for any line <=90

Input Format
The first line of the input consists of a single integer, N.
The next line consists of a series of integers (positive, zero or negative), each corresponding to a separate line, 
and giving the angle that it makes with the x axis (measured in degrees and in anticlockwise direction).

Output
The output is a single integer giving the number of triangles formed by the lines


Sample input/output-1 
input
4
20,-20,40,106
output
Invalid Input Angles 20,-20,40,106

Sample Input : 2
5
20,-20,0,50,50

Output :
7

There are 5 lines, with angles at 20,-20,0, 50 and 50 degrees with the x axis. The figure looks like this

There are 7 triangles, those formed by (L1,L2,L3),(L1,L2,L5), (L1,L2,L4), (L1,L3,L4), (L1,L3,L5), (L2,L3,L5), (L2,L3,L4). Hence the output is 7.


Sample input
51
20,-20,0,40,40

Sample output
Invalid Input N


*/


/*
Steps followed to solve the problem
1. Read number of lines (N) and their corresponding angles 
2. Pick all subsets of size 3 and verify if they form a triangle. 
3. For a subset, verify if all angles are distinct. Because if all angles are distinct then they form triangle. 
4. Repeat (3) for all possible subsets and Increment counter 
5, Print counter
*/


import java.io.*;
import java.util.*;

class TrianglesCanForm
{
    
    static boolean verifyInputAngles(int[] angles, int lower, int upper) {
        boolean inrange=true;
        for (int i : angles){
            if ((i <= upper) && (i >= lower))
               continue;
               else
                inrange =false;
        }
       return inrange;
    }
	
	static int countTriangles(int line[],int n)
	{
		
		int i,j,k,c=0;

		for(i=0;i<n-2;i++)
		{
			for(j=i+1;j<n-1;j++)
			{
				for(k=j+1;k<n;k++)
				{
					// if we draw three lines on the plane with different angles
					//(-89 <= angle for any line <=90),
					// they will make a triangle for the following conditions
					// 1. lines are not coincident (they do not overlap each other)
					// 2. no three of them are concurrent (no three of them pass through the same point).
					if(line[i]!=line[j]&&line[i]!=line[k]&&line[k]!=line[j]){
						//System.out.println(line[i]+"-"+line[j]+"-"+line[k]);
						c++; 
					}//if(
				}//for
			}//for
		}//for
		return c;
	}
    

	public static void main(String[] args) throws Exception
	{
	   final int LOWER=-89,UPPER=90;
	   InputStreamReader r=new InputStreamReader(System.in);    
	   BufferedReader br=new BufferedReader(r);

	   String numberOflines=br.readLine(); 
		
	   //reading number of lines in plane
		int n=Integer.parseInt(numberOflines);
		
		if(n<1 || n>50){
		    		System.out.println("Invalid Input N");
		    		System.exit(0);
		}
	
		boolean isInRange=false;
		//reading line angles in the plane
		String secondLine=br.readLine(); 
        String secondLineAngles[]= secondLine.split(",");
        
        //converting string array to integer array
        int[] lineAngles = Arrays.asList(secondLineAngles).stream().mapToInt(Integer::parseInt).toArray();
		isInRange=verifyInputAngles(lineAngles,LOWER,UPPER);
    	if(!isInRange){
		    		System.out.println("Invalid Input Angles");
		    		System.exit(0);
		}
   		int count = countTriangles(lineAngles,n);
		System.out.println(count);
	}
}
