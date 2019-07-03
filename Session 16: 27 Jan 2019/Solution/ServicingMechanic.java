/*
 * 
Sample Input
3 4
1 3 5
1 4 3
1 1 3
2 6 22
3 5 8



Sample Output
16

Explanation:
Day-1 (1 4 3) (1 1 3)
First, TV of worth-1 will be exchanged with a TV of worth-3. 
His collection changes to 2 TVs of worth-3, and a TV of worth-5.
Second, he can exchange two TVs of worth-3 with two TVs of worth-4. 
Value of his collection at the end of Day-1 (4+4=8)
Day-2  (2 6 22) – Nothing to avail.
Day-3 (3 5 8)
Exchange one TV worth-5 with that of worth-8.
Total value of his collection of TVs would be 4 + 4 + 8 = 16
 
 * 
 */

import java.util.*;

public class ServicingMechanic {
	private static final int MAX = 1024;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int  nTvs = sc.nextInt();
		int nOffers = sc.nextInt();

		// Get nTvs
		int[] tvsWithMechanic = new int[nTvs];
		for (int j = 0; j < tvsWithMechanic.length; j++) {
			tvsWithMechanic[j] = sc.nextInt();
		}

		// Save listings
		List<Offer>[] offersByDay = new List[MAX];
		
		for (int j = 0; j < nOffers; j++) {
			int day = sc.nextInt();
			int tvWorthA = sc.nextInt();
			int tvWorthB = sc.nextInt();

			if (offersByDay[day] == null) {
				offersByDay[day] = new ArrayList<>();
			}
			offersByDay[day].add(new Offer(day, tvWorthA, tvWorthB));
		}

		int[] finalBestOffers = new int[MAX];
		int[] currDayBestOffers = new int[MAX];
		for (int j = 0; j < MAX; j++) {
			finalBestOffers[j] = j;
			currDayBestOffers[j] = j;
		}

		// iter over days in reverse order
		for (int j=0;j<offersByDay.length ; j++) {
			List<Offer> offers = offersByDay[j];
			if (offers != null) {
				// Map best offers
				for (Offer offer : offers) {
					int a = offer.a;
					int b = offer.b;

					if(a<b) {
						currDayBestOffers[a] = b;
					} else {
						currDayBestOffers[b] = a;
					}
				}

				// Take best offers
				for (Offer offer : offers) {
					int a = offer.a;
					int b = offer.b;
					
					int maxA = findBestValue(currDayBestOffers, a);
					finalBestOffers[a] = Math.max(finalBestOffers[a],maxA);
					
					int maxB = findBestValue(currDayBestOffers, b);
					finalBestOffers[b] = Math.max(finalBestOffers[b], maxB);
				}

				for (Offer offer : offers) {
					currDayBestOffers[offer.a] = offer.a;
					currDayBestOffers[offer.b] = offer.b;
				}
			}
		}

		
		// output
		int sum = 0;
		for (int j = 0; j <  nTvs; j++) {
			//find best among the better
			int maxA = findBestValue(finalBestOffers, tvsWithMechanic[j]);
			sum += maxA;
		}
		System.out.println(sum);

	}


	//finds the best offer
	private static int findBestValue(int[] parent, int start) {
		if (parent[start] != start) {
			return findBestValue(parent, parent[start]);
		}
		return parent[start];
	}

	private static class Offer {
		public int day;
		public int a;
		public int b;

		public Offer(int day, int a, int b) {
			this.day = day;
			this.a = a;
			this.b = b;
		}
	}
}

