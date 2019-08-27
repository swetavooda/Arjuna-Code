/*

/*

KensBlocks

Little Ken is playing building blocks.As he is too young to play he ends up dropping the blocks than actually building. Assuming all blocks are  cubes. Assuming the floor to be the number line (x-axis) , he drops the blocks in the order they are given(by us)

The j-th square dropped (positions[j] = (left,length_of_side) ) is a cube with left-most point being positions[j][0] and sidelength positions[j][1].

The block is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed blocks. We wait for each block to stick before dropping the next.


The blocks are sticky on their bottom surface and will remain fixed to any positive length surface they touch (either the number line or another block). Blocks dropped adjacent to each other will not stick together prematurely.

Return a list hts of heights. Each height hts[k] represents the current highest height of any block we have dropped, after dropping  blocks represented by hts[0],hts[1], so on ..hts[k].



Sample Input : 
3  
1 2
2 4
8 3

Sample output :
2 6 6

Explanation : 
when a block dropped at position 1 of width and height 2 then max_height = 2
when a block dropped at position 2 of width and height 3 then max_height = 6 (becuase it falls on block of height 2 at position 2 so max_height=2+4)
when a block dropped at position 8 of width and height 3 then max_height = 6 (the block falls at position 8 and height of the block is 1 so max_height remains 6)


Sample Input : 
2
1 5
4 3


Sample output :
5 8


*/


import java.util.*;
class KensBlocks {
    public static List<Integer> droppingBlocks(int[][] positions) {
        int[] qans = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            qans[i] += size;
            for (int j = i+1; j < positions.length; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left2 < right && left < right2) { //intersect
                    qans[j] = Math.max(qans[j], qans[i]);
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        int cur = -1;
        for (int x: qans) {
            cur = Math.max(cur, x);
            ans.add(cur);
        }
        return ans;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		List<Integer> answer=new ArrayList<Integer>();
		int pos[][]=new int[n][2];
		for(int i=0;i<n;i++)
			for(int j=0;j<2;j++)
				pos[i][j]=sc.nextInt();
		answer.addAll(droppingBlocks(pos));
		for(Integer ans: answer)
		{
				System.out.print(ans+" ");
		}
	}
}
