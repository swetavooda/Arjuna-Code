/*


Local Buses in SriLanka calls for regular strikes
some buses call strike on every 3rd day. some buses call strike on every 4th day and so on
Given the number of days and number of local buses and on which day the the strike goes on 
determine the number of working days among the given number of days

Note :- 
We always start the working day on a Sunday. 
There are no strikes on either Friday or Saturday.


Given the number of buses and total number of days N, determine
the number of working days lost in those N days.


input =
14
3
3
4
8
output = 5

Explanation
First Line of input contains the number of days following by number of buses and on which day the strike is 


Given the number of buses and 
                       1    2   3   4   5   6   7   8    9   10   11  12  13  14
Days                   Su  Mo  Tu   We Th   Fr Sa   Su   Mo  Tu   We  Th  Fr  Sa
LocalBus 1                  	x                        x             x
LocalBus 2                          x               x                  x
LocalBus 3                                          x
Strikes                         1   2       	    3    4   	       5



The First local bus strikes goes on every 3rd day i.e, Tue, Fri,Mon,Thur 
The Second Local bus strikes goes on every 4th day i.e., Wed,Sun,Thur 
The Third Local bus strikes goes on every 8th day i.e., Monday 

There will be exactly five strikes (on days 3, 4, 8, 9, and 12) over the 14 days. 
There is no strike on day 6 since it falls on Friday. 
Hence we lose five working days in two weeks.
so the output is 5 



case = 1
input =14
3
3
4
8
output = 5

case = 2
input =50
3
12
15
40
output = 7

case = 3
input =25
2
7
15
output = 1


case = 4
input = 17
2
5
6
output = 4


case = 5
input =35
4
5
2
3
4
output = 18


*/

import java.util.*; 
class  StrikeEffect
{
    public static void main(String[] args)  
    {
        Scanner sc =new Scanner(System.in);
         int totaldays = sc.nextInt();
         int size = sc.nextInt();
         int harray []=new int[size];          
         for(int i=0;i<size;i++)
             harray[i]=sc.nextInt(); 
         boolean offday = false;
         int strikes[]=new int[totaldays];
         for(int x : harray)
        {
        int i = x;
        while(x < totaldays)
            {
             offday = false;
             if( (x+1) % 7 == 0 || (x %7==0))  
                 offday = true;    
             if(!offday)
                 strikes[x]=x;
             x=x+i;
             }             
         }
         int c=0;
         for(int s : strikes)
        {
            if(s!=0)
            {
             c++;
            }
        }
        System.out.println(c);
    }
}

