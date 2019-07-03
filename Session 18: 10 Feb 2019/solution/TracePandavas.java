/*
 * 

Sample Input :
5 2
2 5 3 4 8
1 4
4 5

Sample Output :
10

Explanation:
the first line 5 2

5 represents total number of allies
2 represents pairs of allies.

The next line 2 5 3 4 8 represents amount of gold
demanded by each ally

The next two lines represent ally/friend pairs
 1 4
 4 5

1st receives gold then he seek help from 4th for
free and 4th can seek help from 5th for free. So, no
need to pay 4th and 5th. 

Need to pay to 2nd and 3rd allies.
So the total gold that must be paid is
 2 + 5 + 3 = 10
 
Approach(DFS):
--------------
In this problem you are given an undirected graph with weighted vertices. 
Store the pair of weight of the vertex and its position in a vector V or a List allies. 
Then create adjacency representation for all edges. 
Sort the vector V or List allies ,in ascending order, 
so that we get vertex with minimum weights.
Now for each connected component run DFS and 
simultaneously add the minimum weight vertex to final answer. 


 
 * 
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Pair implements Comparable<Pair> 
{
	private int index,value;
	Pair(int index,int value){
		this.index = index;
		this.value = value;
	}
	int getIndex() {
		return this.index;
	}
	int getValue() {
		return this.value;
	}
	// Used to sort values in ascending order
    public int compareTo(Pair p) 
    { 
        return this.value - p.value; 
    } 

}
public class TracePandavas {

	private boolean visited[];
	private int V;
	// Array of lists for Adjacency List Representation 
	private LinkedList<Integer> adj[]; 

		
		// Constructor 
		TracePandavas(int v) 
		{ 
			V = v; 
			adj = new LinkedList[v]; 
			for (int i=0; i<v; ++i) 
				adj[i] = new LinkedList(); 
		} 
		
		//Function to add an edge into the graph 
		void addEdge(int v, int w) 
		{ 
			adj[v].add(w); // Add w to v's list. 
			adj[w].add(v); // Add v to w's list. 
 
		} 
	
		// A function used by DFS 
		void dfs(int v,boolean visited[]) 
		{ 
			// Mark the current node as visited and print it 
			visited[v] = true; 
			
			// Recur for all the vertices adjacent to this vertex 
			Iterator<Integer> i = adj[v].listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next(); 
				if (!visited[n]) 
					dfs(n, visited); 
			} 
		} 
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		int numOfAllies = sc.nextInt();
		int numOfFriendShips = sc.nextInt();
		List allies = new ArrayList<Pair>();
		
		for(int i = 0 ; i < numOfAllies ; i++){
			Pair p = new Pair(i,sc.nextInt());
	        allies.add(p);
	    }
		
		Collections.sort(allies);
		
		TracePandavas g = new TracePandavas(numOfAllies); 

		for(int i=0;i<numOfFriendShips;i++) {
			g.addEdge(sc.nextInt()-1,sc.nextInt()-1); 
		}
		
		int minAmountOfGold = 0;
		
		// Mark all the vertices as not visited(set as false by default in java) 
		boolean visited[] = new boolean[numOfAllies]; 
		
	    for(int i = 0 ; i < numOfAllies ; ++i){
	    	Pair curr = (Pair) allies.get(i);
	        if(!visited[curr.getIndex()]){
	        	minAmountOfGold += curr.getValue();
	            g.dfs(curr.getIndex(),visited);
	        }
	    }
	    
	    System.out.println(minAmountOfGold);
					
		
	}
	
}
