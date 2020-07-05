import java.util.*;
class S02_02
{
    public static void main(String args[])
    {
        int n,d,m;
        Scanner sc = new Scanner(System.in);
        d=sc.nextInt();
        n=sc.nextInt();
        int bus[]= new int[n];
        for(int i=0;i<n;i++)
        {
            bus[i]=sc.nextInt();
        }
        Set<Integer> s = new HashSet<>();
        for(int i:bus)
        {
            m=1;
            
            while(i*m<=d)
            {
                if((i*m)%7!=6 && (i*m)%7!=0)
                {
                    s.add(i*m);
                }
                m++;
            }
        }
        
        System.out.println(s.size());
        
    }
}
