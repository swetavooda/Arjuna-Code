/*

Suggest Email Ids (Usernames)
An email company wants to have unique email ids for its users. As a policy, it wants to suggest
usernames to new users. If a username already exists, then the system must add an integer to
the end of the username to make it unique. The numbering begins with 1 and is incremented by
1 for each new instance per username.
As an example, if the username requests were for [raj, raj, seema, seema, seema], the system
should assign/suggest usernames [raj, raj1, seema, seema1, seema2]
Given the number of usernames and the list of usernames one in each row, write a program to
print the list of updated username one in each row.

input format:
no of usernames
list of usernames one in each row

output format:
list of updated usernames one in each row


input :
4
alex
xylos
alex
alan

output :
alex
xylos
alex1
alan

Explanation :

There are 4 usernames . Each of the usernames is unique with the exception of  “alex”.
so for first duplicate request for the username “alex” you need to update it with "alex1" 


Sample input 2:
6
alex
xylos
alex
alan
alan
alex

Sample output 2:
alex
xylos
alex1
alan
alan1
alex2

Approach:
---------
this problem can be solved using two lists.
read the username and add to username list.
check whether current username exists more than once in the usernames list or not
if no, then add this username to fusername list.
if yes, get the frequency count and append it to username
	add this to fusername list
print all names from fusername list.
*/


import java.util.*; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SuggestEmailIds { 
    public static void main(String args[])  throws IOException
    { 
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int nusers=0;String uname="";int freq=0;
        // create a ArrayList String type 
        // and Initialize an ArrayList with add() 
        ArrayList<String> usernames = new ArrayList<String>(); // original usernames array list
        ArrayList<String> fusernames = new ArrayList<String>(); // final usernames array list
	nusers = Integer.parseInt(br.readLine());// reading no of usernames
        for (int i =0; i < nusers; i++){
	      uname=br.readLine(); 
	      usernames.add(uname);
		if(Collections.frequency(usernames, uname)<=1)
			fusernames.add(uname);
		else {
			freq=Collections.frequency(usernames, uname)-1;
			fusernames.add(uname+""+freq);   
		}  		
	 }
               // print Final ArrayList 
           for (String fname: fusernames){
                System.out.println(fname);
	 } 
       
    } 
} 
