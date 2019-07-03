import java.util.Scanner;

public class ArrangeBoxes2 {
	public static void main(String arg[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int totalNumberOfBoxes = sc.nextInt();
		long rounds = 0;
		int boxes[] = new int[totalNumberOfBoxes];
		for (int j = 0; j < totalNumberOfBoxes; j++) {
			boxes[j] = sc.nextInt();
		}
		int flag = 0;
		while (flag != 1) {
			flag = 1;
			for (int j = 0; j < totalNumberOfBoxes - 1; j++) {
				/*
				 * if a ToyBox found beside a EmptyBox immediate right i.e. if a ToyBox is
				 * at ith position and a EmptyBox is at (i+1)th position then 
				 * their positions can be swapped.
				 */
				if ((boxes[j] == 0) && (boxes[j + 1] == 1)) {
					boxes[j + 1] = 0;
					boxes[j] = 1;
					flag = 0;
					j++;
				}

			}
			if (flag == 0) {
				rounds++;
			} else
				break;
		}
		System.out.println(rounds);
	}
}
