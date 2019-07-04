/*
 * 

Sample Input:
5 5
1 2 6
1 3 3
2 3 2
3 4 6
3 5 5
2 5
1 5

Sample Output:
4

QUICK EXPLANATION:
-----------------
This problem can be done using BFS or DFS.
This solution uses DFS.
Run a DFS from each reachable node. 
If any neighbour has edge weight ≤S, 
it is reachable and run a DFS from it. 
Maintain a visited array so that you visit each node utmost once. 
Print the number of nodes that were visited.

 * 
 * 
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiamondNecklace {
    List<int[]>[] graph;
    int N;
    int M;
    boolean[] visited;
    int total_number;
    int S;

    public DiamondNecklace(int N, int M){
        this.N = N;
        this.M = M;
        this.graph = new ArrayList[N];
        for(int i = 0; i< N; i++){
            this.graph[i] = new ArrayList<int[]>();
        }
        this.visited = new boolean[N];
        this.total_number = 0;
    }

    public void create_entry(int friend1, int friend2, int strength){
        int index_friend1 = friend1-1;
        int index_friend2 = friend2-1;
        int[] pair12 = {strength, index_friend2};
        int[] pair21 = {strength, index_friend1};
        this.graph[index_friend1].add(pair12);
        this.graph[index_friend2].add(pair21);
    }

    public void dfs(int friend){
        if(this.visited[friend]){
            return;
        }
        this.visited[friend] = true;
        this.total_number = this.total_number + 1;
        for(int[] friends: this.graph[friend]){
            if(friends[0] <= this.S){
                dfs(friends[1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        DiamondNecklace dn = new DiamondNecklace(N, M);
        for(int relation=0; relation<M; relation++){
          
            int friend1 = sc.nextInt();
            int friend2 = sc.nextInt();
            int strength = sc.nextInt();
            dn.create_entry(friend1, friend2, strength);
        }
        
        int K = sc.nextInt();
        int S = sc.nextInt();
        dn.S = S;
        
        for(int i =0; i<K; i++){
        	dn.dfs(sc.nextInt() - 1);
        }
        System.out.println(dn.total_number);
    }
}
