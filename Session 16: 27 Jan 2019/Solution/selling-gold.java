
/*
Sample Input 1:
3
5 10 3

Sample Output 1:
2

Explanation 1:
First line 3 – represents total number of months
Second line (5 10 3) – represents gold prices of next three months. 
Stored in an array say priceArray[5, 10, 3]
The merchant buys gold in month 1 priceArray[0]=5 and sells it in 
3rd month priceArray[2] =3
Minimum loss (5 -3) = 2

Sample Input 2:
5
20 7 8 2 5

Sample Output 2:
2

Explanation 2:
First line 5 – represents total number of months
Second line – represents priceArray [20, 7, 8, 2, 5]
The merchant buys in month-2 priceArray[1]=7 and sells it in month-5 priceArray[4]=5. 
So the minimum loss (7 – 5 = 2) .

 * 
 */

import java.util.*;

public class SellingGold {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int months = sc.nextInt();// read the number of months of gold bar data. 
        List<PriceIndex> priceIndices = new ArrayList<>(months);

        for (int i = 0; i < months; i++) {
            priceIndices.add(new PriceIndex(sc.nextLong(), i));
        }
        
        //sort the collection in descending order
        Collections.sort(priceIndices);
        
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < months - 1; i++) {

        //for each month, take two gold bars from descending ordered list
            PriceIndex priceIndex1 = priceIndices.get(i);
            PriceIndex priceIndex2 = priceIndices.get(i + 1);

            //check if the 1st gold bar index is less than second gold bar index
            // if yes, then calculate the loss
            if (priceIndex1.getIndex() < priceIndex2.getIndex()) {
                long loss = priceIndex1.getPrice() - priceIndex2.getPrice();
                if (loss >= 0 && loss < min) {
                    min = loss;
                }
            }
        }
        System.out.println(min);
    }

    static class PriceIndex implements Comparable<PriceIndex> {
        Long price;
        int index;

        public PriceIndex(long price, int index) {
            this.price = price;
            this.index = index;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public int compareTo(PriceIndex o) {
            return o.price.compareTo(this.price);
        }

        @Override
        public String toString() {
            return "PriceIndex{" +
                    "price=" + price +
                    '}';
        }
    }
}
