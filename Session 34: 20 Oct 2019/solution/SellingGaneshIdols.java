

/* Selling Ganesh Idols
Sample input :
6 3 1
4 8
2 10 16

Sample output :
29

Explanation :
* The first line 6 3 1 corresponds to the number of idols, the maximum possible level of decoration, and the initial number of coins. 
* The second line 4 8 corresponds to the prices of levels of decorations.
* The third line corresponds to 2 10 16 corresponds to the selling prices (in coins) for every level of decoration.
* Initially there is one (1) coin. 

strategy 1:
Sell 2 in level 1 and upgrade 3 to level2(sell) and upgrade 1 to level3(sell) : Total coins is 27
step 1 : sell 2 idols coins left 5(1+4) idols left 4
step 2 : upgrade 1 idol to level 2 by spending 4 coins and sell that idol. coins left is 11(1+10) and idols left is 3
step 3 : upgrade 2 idols to level 2 by spending 8(2*4) coins and sell 2 idols for 20. coins left is 23(3+20) and idols left is 1
step 4 : upgrade 1 idol to level 3 by spending 12(4+8) coins and sell that idol for 16. coins left is 27(11+16) and idols left is 0

strategy 2 :
sell 2 in level 1 and upgrade 2 to level2(sell) and upgrade 2 to level3(sell) : Total coins is 25

strategy 3:
Sell 2 idols in level 1 and upgrade 4 to level2 and sell: Total coins is 29

optimal way we can get a maximum of 29 coins

Sample input :
10 4 5
30 50 60
1 50 80 100

Sample output :
15

Explanation :
He can't upgrade to next level because to upgrade he require 30 coins. He has the initial number of coins 5 and if he sells all idols at level 1 he will get 20, put together 25 to upgrade he require 30 coins and at least one idol to sell.
*/

// Java program to illustrate 
// Java.util.HashMap 

/*

Test cases :



input =5 4 1
3 2 10
2 3 10 16
output =20


input =4 3 2
5 10
20 30 40 50
output =97


input =6 4 10
10 20 30
20 60 100 500
output =2260


input =10 5 100
5 10 15 20    
5 15 25 50 100
output =600


input =3 3 20
5 15
5 25 200
output =560


input =4 2 100
50
50 200
output =700


input =10 8 5
2 4 6 8 10 12 15        
4 8 12 16 20 24 28 32
output =65

*/

import java.util.*;
import java.io.*;

public class SellingGaneshIdols {

	public void getMaxCoinsRemaining(int idols, int maxLevel, int initCoins, HashMap<Integer, Integer> levelCost,
			HashMap<Integer, Integer> sellPrice) {
		
		int coinsRemain = initCoins;
		HashMap<Integer, Integer> optimalSelling = new HashMap<>();
		optimalSelling.put(1, sellPrice.get(1));

		for (int i = 2; i <= maxLevel; i++) {
			optimalSelling.put(i, Math.max(optimalSelling.get(i - 1), sellPrice.get(i) - levelCost.get(i)));
		}
		int curLevel = 1;
		while (curLevel < maxLevel && idols > 0) {
			while ((levelCost.containsKey(curLevel + 1)) && coinsRemain >= levelCost.get(curLevel + 1)
					&& curLevel < maxLevel) {
				curLevel++;
			}
			coinsRemain += optimalSelling.get(curLevel);
			idols--;
		}
		coinsRemain += idols * optimalSelling.get(maxLevel);
		System.out.println(coinsRemain);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// reading number of idols, maximum level of decoration, initial number of coins
		String[] numbers = br.readLine().split(" ");
		int idols = Integer.parseInt(numbers[0]);
		int maxLevel = Integer.parseInt(numbers[1]);
		int initCoins = Integer.parseInt(numbers[2]);

		HashMap<Integer, Integer> levelCost = new HashMap<>();
		HashMap<Integer, Integer> sellPrice = new HashMap<>();
		levelCost.put(1, 0); // default cost of level 1

		// reading costs of levels of decoration theme
		numbers = br.readLine().split(" ");
		for (int i = 2; i <= maxLevel; i++) {
			levelCost.put(i, Integer.parseInt(numbers[i - 2]));
			levelCost.put(i, levelCost.get(i) + levelCost.get(i - 1));
		}

		// reading selling prices of idols for each level of decoration
		numbers = br.readLine().split(" ");
		for (int i = 1; i <= maxLevel; i++) {
			sellPrice.put(i, Integer.parseInt(numbers[i - 1]));
		}
		SellingGaneshIdols sdi = new SellingGaneshIdols();
		sdi.getMaxCoinsRemaining(idols, maxLevel, initCoins, levelCost, sellPrice);

	}// end of main
}
