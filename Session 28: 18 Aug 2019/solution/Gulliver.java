/*
From the liliput land,Gulliver the traveller is now in the land of Giants where everyone is atleast 20 times as tall as him.
He has now made one of the Giant's home as his home. And is now helping Giant in his chores. 
Every day the Giant makes a telephone call to his friend and Gulliver is supposed to connect the call.

Giant has a huge telephone box, with 0 to 9 digits.  Gulliver is to hop on each digit and make the call that the giant wants him to make.
Find the sequence of moves that Gulliver has to take, to make the call, in the minimum number of moves/jumps.
You can return any path that does so.

Here, dialPad = ["012", "345", "678", "9"], as shown in the diagram below

We may make the following moves (i.e., priority as follows):
'U' moves our position up one row, if the position exists on the dialPad;
'D' moves our position down one row, if the position exists on the dialPad;
'L' moves our position left one column, if the position exists on the dialPad;
'R' moves our position right one column, if the position exists on the dialPad;
'-' adds the character dialPad[r][c] at our current position (r, c) to the answer.

Sample - 0:
input:  0402221234   //String format
output:  -DR-UL-RR---L-R-DLL-R-

sample - 1:
input:  9876543210   //String format
output:  DDD-URR-L-L-URR-L-L-URR-L-L-
*/
import java.util.*;
class Gulliver {
    public static String dialPadPath(String target) {
        StringBuilder ans = new StringBuilder();
        int x = 0, y = 0; // current row and col positions
        for (char c : target.toCharArray()) {
            int i = ((int)c - 48)/3; //  req for row position
            int j = ((int)c - 48)%3;//	req for col position 
            if(i > x) { // req row position greater than current col position
                while(x != i) {      // move down until you reach the required                                 
                    if(x == 2 && y > 0 ) // boundary condition
                        break;                    
                    ans.append("D");  
                    x++;
                }
            } else {
                while (x != i) {
                    ans.append("U");  // move up until you reach the required       
                    x--;
                }
            }
            if(j > y) { // req col position greater than current row position
                while(y != j) { 
                    ans.append("R"); // move right until you reach the required 
                    y++;
                }
            } else {
                while(y != j) {
                    ans.append("L"); // move left until you reach the required 
                    y--;
                }
            }
            if(x != i) { // for digit 9 last number 
                ans.append("D");
                x++;
            }
            ans.append("-");
        }
        return ans.toString();
    }
    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String target=sc.next();
		System.out.println(dialPadPath(target));
	}
}
