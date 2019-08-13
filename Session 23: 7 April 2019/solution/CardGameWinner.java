/*
 * 
Andrea and Maria each have a deck of numbered cards in a pile face down. 
They play a game where they each alternately discard and flip the cards on the pile from top to bottom. 

At the beginning of the game, someone will call out â€œEvenâ€ or â€œOddâ€. 
The first move depends on which is called. 
If â€œEvenâ€ is called, the players top cards are flipped so they can see the face value. 
If instead â€œOddâ€ is called, the top card is removed from each deck and discarded, 
then each flips her next card. 
Andrea subtracts the value of Mariaâ€™s card from her own and adds the result to her score. 
Likewise, Maria subtracts the value of Andreaâ€™s card from her own and adds the result to her score. 

From this point forward, each alternately discards then flips a card. Each time two cards are flipped, the 
players scores are computed as before. Once all the cards have been played, whoever has the most points wins. 

As an example, Mariaâ€™s cards, face down are [3,5,6] and Andreaâ€™s are [4,5,7]. 
After calling â€œEvenâ€ at random, they each compare their first cards. 
Mariaâ€™s points are 3-4 =-1, and Andreaâ€™s are 4-3=1. 
They discard the 5â€™s and turn over their third cards. 
Maria receives 6-7=-1 point and Andrea receives 7-6=1 point. Mariaâ€™s score is -2, Andreaâ€™s is +2 so Andrea wins. 

You must determine the name of the winner if there is one, otherwise they tie. Return Andrea,Maria or Tie. 

Input Format:
-------------
number of andrea cards
read all andrea cards
number of maria cards
read all maria cards
read the string either Odd or Even

Output Format:
--------------
Print a string denoting the outcome of the game. 
Print Andrea if Andrea won, or Print Maria if Maria won. If their scores are tied, Print Tie instead. 

Sample Input:
3
1
2
3
3
2
1
3
Even

Sample Output 
Maria

Explanation
In this game, andrea =[1,2,3] and maris=[2,1,3]. Because s=Even, the only cards flipped are at indexes 0 and 2. 

When i=0, Andrea gets a[0]-m[0]=1-2 =-1 point and Maria gets m[0]-a[0]=2-1 = 1 point.
When i=2, Andrea gets a[2]-m[2]=3-3=0 points and Maria gets m[2]-a[2]=3-3 = 0 points. 

At the end of play, Andreaâ€™s cumulative score is -1 and Mariaâ€™s is 1 so Maria wins. 

Approach:
---------
read the cards of andrea and maria
check for input string(Even or Odd)
if S=Even then only even index cards will be flipped
if S=Odd then only odd index cards will be flipped
Then we need to calculate Andrea and Maria scores as explained in the question.

 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class CardGameWinner {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int numOfCardsA = sc.nextInt();
		ArrayList<Integer> andreaCards = new ArrayList<>();
		for (int i = 0; i < numOfCardsA; i++) {
			andreaCards.add(sc.nextInt());
		}

		int numOfCardsM = sc.nextInt();

		ArrayList<Integer> mariaCards = new ArrayList<>();
		for (int i = 0; i < numOfCardsM; i++) {
			mariaCards.add(sc.nextInt());
		}
		String s = sc.next();
		int andreaScore = 0, mariaScore = 0;

		switch (s) {

		case "Even":
			for (int i = 0; i < numOfCardsA; i++) {
				if (i % 2 == 0) {
					andreaScore += andreaCards.get(i) - mariaCards.get(i);
					mariaScore += mariaCards.get(i) - andreaCards.get(i);
				}
			}
			break;
		case "Odd":
			for (int i = 0; i < numOfCardsA; i++) {
				if (i % 2 != 0) {
					andreaScore += andreaCards.get(i) - mariaCards.get(i);
					mariaScore += mariaCards.get(i) - andreaCards.get(i);
				}
			}
			break;
		}// end of switch
		
		if (andreaScore > mariaScore) {
			System.out.println("Andrea");
		} else if (mariaScore > andreaScore) {
			System.out.println("Maria");
		} else {
			System.out.println("Tie");
		}
	}
}
