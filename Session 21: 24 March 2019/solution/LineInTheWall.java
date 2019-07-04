/*
 * 

Input: 
6
1 2 2 1
3 1 2
1 3 2
2 4
3 1 2
1 3 1 1

Output: 
2

Approach:
---------
We want to cut from the edge of the most common location among all the levels, 
hence using a map to record the locations and their corresponding occurrence. 

 * 
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LineIntheWall {

	public static int leastBricks(List<List<Integer>> wall) {
		if (wall.size() == 0)
			return 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (List<Integer> list : wall) {
			int length = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				length += list.get(i);
				map.put(length, map.getOrDefault(length, 0) + 1);
				count = Math.max(count, map.get(length));
			}
		}
		return wall.size() - count;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfRowsOfBricks = Integer.parseInt(br.readLine());
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		for (int i = 0; i < numOfRowsOfBricks; i++) {
			String str = br.readLine();
			String[] bricks = str.split(" ");
			List<Integer> brickRow = new ArrayList<Integer>(bricks.length);
			for (String brick : bricks) {
				brickRow.add(Integer.parseInt(brick));
			}
			wall.add(brickRow);
		}
		System.out.println(leastBricks(wall));

	}
}
