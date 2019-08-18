import java.io.*;
import java.lang.Math;  
public class Strikeout{

    public static long findGrandSurvivalCount (long balls){
      
// probability of HIT (survival) on first throw of ball when 
// if balls=1, scount1=1; balls=2, scount2=2; balls=3, scount3=4    
	long scount1=1,scount2=2,scount3=4; 
	
	long total_scount;//total_scount of not hitting(N) trice

	long i=2; // calculating no of total_scount when balls morethan 2 
	    while(true){ // loop to find the possible ways for the value of balls
			
			 // sp(balls)=sp(balls-3)+sp(balls-2)+sp(balls-1)
			total_scount=scount1+scount2+scount3;
			i = i+1;
			if(i==balls)
				  break;
			scount1=scount2;// shifting scount vaules with their next scounts
			scount2=scount3;
			scount3=total_scount;
	    }
        return total_scount;
    }
 
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long balls = Long.parseLong(br.readLine());
			// total number of acceptable sequences when balls=1,balls=2,balls=3
            long  survivalProbability[] = {2,4,7}; 
            if(balls <= 3)
                System.out.println(survivalProbability[(int)balls - 1]);
            else
                System.out.println(findGrandSurvivalCount(balls));
    }
}
