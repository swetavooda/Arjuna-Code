/*
 * 
Sample Input

3 2
2 5 6

Sample Output

15

Explanation


The first line 3 2 – Total Frames (F=3) and Friends(N=2)
Second line 2 5 6 – Prices of Frames


First person 
purchases Frame of 5 so its cost is (0+1)*5 = 5
Purchases Frame of 2 so its cost is (1+1)*2 = 4

Second Persono Purchases Frame of 6 so its cost is (0+1)*6 = 6

Total Cost of Frames = 5 + 4 + 6 = 15

Approach:
---------
Strategy: Each person should buy most expensive frame available and continue doing so until none are left

read the price of frames in a list.
sort price list in decending order.
initialise moneySpent variable to zero.
for each frame,
repeat till end of the frames
calculate costMultiplier(= framePriceIndex/N + 1)
multiply the currentPrice of frame with costMultiplier and add to moneySpent
end repeat
display moneySpent



 * 
 */

import java.util.*;

public class SellingPhotoFrames {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int framesCount = sc.nextInt();
        int friendsCount = sc.nextInt();
        
        //read in all the frame prices
        List<Integer> framesPrices = new ArrayList<Integer>();
        for(int currFrame = 0; currFrame < framesCount; currFrame++){
            framesPrices.add(new Integer(sc.nextInt()));
        }
        
        /*
        * Strategy: Each person should buy most expensive frame available and continue doing so until none are left
        */
        
        //sort the frame prices so we always know which is the most expensive frame
        Collections.sort(framesPrices,Collections.reverseOrder());
        
        int moneySpent = 0;
       
        //buy each frame, starting with the most expensive one first
        for(int framePriceIndex = 0; framePriceIndex<framesCount; framePriceIndex++){
        	int costMultiplier = (framePriceIndex / friendsCount) + 1;
            moneySpent += framesPrices.get(framePriceIndex) * costMultiplier;
        }
        
        System.out.println(moneySpent);
    }
    
}