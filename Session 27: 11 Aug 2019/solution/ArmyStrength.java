import java.util.*;
import java.io.*;

// Ally Class 
class Ally {
    public int id; 
    public int strength; 
    public List<Integer> directAllies=new ArrayList<Integer>();
	public Ally(int id,int strength, List<Integer> dAllies)
	{
		this.id=id;
		this.strength=strength;
		directAllies.addAll(dAllies);
	}
}

class ArmyStrength{

    public int getArmyStrength(List<Ally> allies, int qAid) {
        HashMap<Integer, Ally> graph = new HashMap<>();
        for (Ally ally : allies) {
            graph.put(ally.id, ally);
        }

        Queue<Ally> queue = new LinkedList<>();
        queue.offer(graph.get(qAid));
        int sum = 0;
        while (!queue.isEmpty()) {
            Ally curr = queue.poll();
            sum += curr.strength;
            for (Integer sAlly : curr.sAllies) {
                queue.offer(graph.get(sAlly));
            }
        }
        return sum;
     }
	public static void main(String args[])
	{
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String[] input=new String[N];
        for(int i=0;i<N;i++)
            input[i]=br.readLine();
		List<Ally> alliesList=new ArrayList<Ally>();
		List<Integer> dAllies=new ArrayList<Integer>();
		for(String sin:input)
		{   
			String[] s = sin.split(" "); 
			int allyId=Integer.parseInt(s[0]);
			int strength=Integer.parseInt(s[1]);
			for(int i=2;i<s.length;i++)
				dAllies.add(Integer.parseInt(s[i]));
			Ally a=new Ally(allyId,strength,dAllies);
			alliesList.add(a);
			dAllies.clear();
		}
		ArmyStrength as=new ArmyStrength();

		int queryAid=Integer.parseInt(br.readLine());

		int sum=as.getArmyStrength(alliesList, queryAid);

		System.out.println(sum);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
