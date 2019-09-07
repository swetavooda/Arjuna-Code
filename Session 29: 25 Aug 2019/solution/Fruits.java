/*



Algorithm



In every call of the function buying(cost,spl,needs), we do as follows:

   1) Determine the cost of buying items as per the needs array, without applying any offer. Store the result in res.

   2) Iterate over every offer in the special list. For every offer chosen, repeat steps 3 to 5.

   3) Create a copy of the current needs in a clone list(so that the original needs can be used again, while selecting the next offer).

   4) Try to apply the current offer. If possible, update the required number of items in clone.

   5) If the current offer could be applied, find the minimum cost out of res and offer_\current + buying(cost,spl,clone). Here, offer_\current refers to the price that needs to be paid for the current offer. Update the res with the minimum value.

   6) Return the res corresponding to the minimum cost.

We need to note that the clone needs to be updated afresh from needs(coming to the current function call) when we choose a new offer. This needs to be done, because solely applying the next offer could result in a lesser cost than the one resulting by using the previous offer first.




Sample input:

1 4
2
1 3 8
2 4 12
5 8


Sample output:

25

Explanation :

1, 4 are the prices of fruits X, Y
The plans: (1X 3Y = 8), (2X 4Y = 12)
Desired set (5X 8Y = ? )
Choose plan1 twice and buy 3X 2Y separately, cost is 27
Choose plan2 twice and buy 1X separately, cost will be 25




*/


import java.util.*;
import java.io.*;

public class Fruit_Plans {

    public int fruitplans(List < Integer > cost, ArrayList < ArrayList < Integer >> spl, List < Integer > needs) {

        return buying(cost, spl, needs);
    }

    public int buying(List < Integer > cost, ArrayList < ArrayList < Integer >> spl, List < Integer > needs) {
        int j = 0, res = dot(needs, cost); //initially buying fruits with original price 
        for (ArrayList < Integer > s: spl) { // going though all offers one by one
            ArrayList < Integer > clone = new ArrayList < Integer> (needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j); // diff of required fruits and fruits in offer
                if (diff < 0)
                    break; // if fruits in the offer is greater than required
                clone.set(j, diff); // updating the required fruits count after appying the offers for each fruit  
            }
            if (j == needs.size()) // checking offer is appicable or not
                res = Math.min(res, s.get(j) + buying(cost, spl, clone)); // min of previous cost and this cost 
        }
        return res;
    }

    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i); // needs * cost calculation for each fruit
        }
        return sum;
    }

	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Input Prices of products
		String str = br.readLine();
		String[] numbers = str.split(" ");
		
		int[] a = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		List<Integer> cost=new ArrayList<Integer>();
		
		for(int list:a)
			cost.add(list);
		
		//Input number of offers
		str = br.readLine();
		int n=Integer.parseInt(str);
		ArrayList < ArrayList < Integer > > spl=new ArrayList<ArrayList<Integer>>();
		
		//Input the 'N' Offers
		while(n>0)
		{
		str = br.readLine();
		numbers = str.split(" ");
		a = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		
		ArrayList<Integer> sample=new ArrayList<Integer>();
		for(int list:a)
			sample.add(list);

		spl.add(sample);
		n--;
		}

		//input Needs
		str = br.readLine();
		numbers = str.split(" ");
		a = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		List<Integer> needs=new ArrayList<Integer>();
		for(int list:a)
			needs.add(list);

		// Finding the Minimum cost for payment.
		Fruit_Plans fp_obj=new Fruit_Plans();
		System.out.println(fp_obj.fruitplans(cost,spl,needs));
	}
}
