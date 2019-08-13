import java.util.*;

public class Meera_HomeMaker {

	public static void main(String[] args) {
		   Scanner sc=new Scanner(System.in);
		   //Number of days	   
		   int days=sc.nextInt();
		   //Number of shares that Meera can buy/sell
		   int shares=sc.nextInt();
		   //Initially the profit is zero
		   int profit=0,min=Integer.MAX_VALUE;
		   int temp;     
	       for(int i=0;i<days;i++)
	       {
	    	   //Input for the shares values that Meera can buy/sell for the days
	           int x=sc.nextInt();             
	           if(min>x) { min=x;} 
	           temp=shares*(x-min);
	           if(temp>profit) { profit=temp;}
	       }
	       System.out.println(profit);
	   }

}
