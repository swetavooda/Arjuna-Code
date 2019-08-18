import java.util.Scanner;
// A Dynamic Programming based Java 
import java.io.*; 
class DecodeWays  
{ 
      
// function to count Decoding Ways 
static int getDecodeWays(char digits[],int length) 
{ 
    // A table to store results of subproblems 
    int count[] = new int[length + 1];  
    count[0] = 1; 
    count[1] = 1; 
    if(digits[0]=='0')   //for base condition i.e., anything starting with 0, always return 0  
          return 0; 
    for (int i = 2; i <= length; i++) 
    { 
        count[i] = 0;   
        // If the last digit is not 0,  
        // then last digit must add to the number of words 
        
		if (digits[i - 1] > '0') 
            count[i] = count[i - 1]; 
  
        // If second last digit is smaller 
        // than 2 and last digit is smaller than 7, then last two digits form a valid character 
        if (digits[i - 2] == '1' || 
           (digits[i - 2] == '2' &&  
            digits[i - 1] < '7')) 
            count[i] += count[i - 2]; 
    } 
    return count[length]; 
} 
  
	// Code 
	public static void main (String[] args)  
	{ 
	   Scanner sc=new Scanner(System.in);
			String s=sc.next();
			char[] digits = s.toCharArray(); 
			int ways=getDecodeWays(digits,s.length());
			System.out.println(ways);
	} 
} 
  
