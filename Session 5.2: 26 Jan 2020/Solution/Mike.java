/*
 * 
 Mike and his Dad

Mike is a math whizz-kid. He and his father like to play with numbers. One day Mike's 
father took Mike on a walk and they started playing a new number game. In this one, 
Mike gives his father 2 numbers, P and Q. Mike's father gives Mike numbers from K1 to KP

Mike is now to assign unique numbers from 1 to Q (R1 to RQ) to the numbers his father gave,
let us say Ri be the integer assigned to Ki. He should assign them in such a way that maximum number of 
Ki are divisible by their Ri. And he is also to find the maximum number of Ki that could be divisible by Ri, 
in optimal assignment.  Help Mike in finding this.

Input:
First line of input consists of integer P and Q.
Next P lines consist of P integers with ith line containing integer Ai

Output:
Output maximum number of Ai that can be made divisible by Ci in optimal assignment.

Sample input 1:
5 5
6
4
5
15
18

Sample output 1:
5

Explanation :

As Q is 5, the numbers that can be assigned to the 5 integers are 1,2,3,4 and 5  (R1 to R5)
We should try and pair/assign the integers in such a way that  Ki%Ri will be zero
So,  for numbers from 6,4,5,15 and 18 in the input (K1 to K5) , 
[1,4,5,3,2] is the best possibility as 6%1 =0 , 4%4 =0 , 5 %5=0, 15%3, 18%2 = 0 .
Thus the output is 5  ( as we are able to assign number to all 5 numbers in the input)
Note: Number(Ri) cannot be repeated or reassigned.

Sample input 2:
5 6
12
14
21
27
9
Sample output 2:
4

Explanation :

As Q is 6, the numbers that can be assigned to the 5 integers are 1,2,3,4,5 and 6  (R1 to R6)
We should try and pair/assign the integers in such a way that  Ki%Ri will be zero
So,  for numbers from 6,4,5,15 and 18 in the input (K1 to K5) , 
[6,2,3,1,5] is the best possibility as 12%6, 14%2, 21%3, 27%1=0 , 9%5 = 4.
    OR
[6,2,3,5,1] is the best possibility as 12%6, 14%2, 21%3, 9%1=0 , 27%5 = 2.
Thus the output is 4  ( as we are able to assign divisible number to only 4 numbers in  the input)
Note: Number(Ri) cannot be repeated or reassigned.
 */

package ArjunaS5;

import java.util.*;
class Mike
{
    public static void main (String[] args) {
        Scanner s=new Scanner(System.in);
        int p=s.nextInt();
        int q=s.nextInt();
        int arr[]=new int[p];
        for(int i=0;i<p;i++)
        {
            arr[i]=s.nextInt();
        }
        int j = q,count = 0;
        while(j>0){
            for(int i=0;i<p;i++){
                if(arr[i]%j == 0 && arr[i] > 0){
                    count++;                  
                    arr[i] = -1;               
                    break;
                }
            }
            j--;
        }
        System.out.println(count);
    }
}
