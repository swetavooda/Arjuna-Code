/* Biggest Integer 


The casino has introduced a new game in which there are M vertical chutes each containing N single digit (possibly zero) numbers. 
You can choose any chute and draw the bottom number and when you do this all the other numbers in the
chute descend by one slot. You need to build the largest integer using this process drawing all the 
numbers from the chutes. Given the number of chutes and the 
numbers in each chute, write a program to find the largest integer that could be formed using the 
above process.

Constraints
1 <= M <= 20, 1 <= N <= 50

Input Format :

First line contains M,N two comma separated integers giving the number of chutes and the number of digits in each chute
The next M lines each contain N comma separated digits, giving the digits from top to bottom in each of the chutes.

Output :

One line containing the largest integer that could be formed.


Sample Input/outputs

Input
2,3
1,2,3
2,4,6

Output
643221

Explanation
M is 2 and N is 3 (there are 2 chutes with 3 digits in each). The chutes look like this

The largest integer that can be formed is 643221

Sample input :
28,2
7,5
4,8

Sample output :
Invalid Input


Sample input
2,57
7,5
1,8

output
Invalid Input








*/


/*
Steps followed to solve the question
	1. Read all input values into multiple stacks
	2. Get the top elements from each stack
	3. Print and Pop the Biggest number
	4. Repeat 2 and 3 till all stacks are empty.
*/

import java.io.*;  
import java.util.*;

class BiggestInteger
{
    public static void main(String args[]) throws Exception
    {	   
	    InputStreamReader r=new InputStreamReader(System.in);    
	    BufferedReader br=new BufferedReader(r);           
	   // System.out.println("Sets,Items");    
	    String setitems=br.readLine(); 
        String setitemsarr[]= setitems.split(",");
	int mLines=Integer.parseInt(setitemsarr[0]); //number of chutes 
	int nDigits=Integer.parseInt(setitemsarr[1]); //number of digits in each chute
 		if(mLines<1 || mLines>20){
		    		System.out.println("Invalid Input");
		    		System.exit(0);
		}
			if(nDigits<1 || nDigits>50){
		    		System.out.println("Invalid Input");
		    		System.exit(0);
		}
		// reading input values into chutes (Stacks)
 	Stack[] chutes = new Stack[mLines];
	for(int si=0;si<mLines;si++){
          chutes[si] = new Stack();
	  String chuteNumberString = br.readLine(); 
          String chuteNumbers[]= chuteNumberString.split(",");
		for(int se=0;se<nDigits;se++){
			chutes[si].push(Integer.parseInt(chuteNumbers[se]));
		
		}
	}//	for(int si=0;si<mLines;si++)


    // Processing chutes (Stacks) for Biggest number
	for(int i=0;i<mLines*nDigits;i++){
		List<Integer> peekelements = new ArrayList<Integer>();
		for(int si=0;si<mLines;si++){
			
			if(!chutes[si].empty())
		    	peekelements.add((Integer)chutes[si].peek());
		}
		if(peekelements.size()==0)
		break;
		for(int se=0;se<nDigits;se++){
			if(!chutes[se].empty())
			if(Collections.max(peekelements,null)==(Integer)chutes[se].peek()){
				System.out.print((Integer)chutes[se].pop());
				break;
			}
		
		}//	for(int se=0;se<nDigits;se++)
	   } //for(int i=0;i<mLines*nDigits;i++)

    }
}
