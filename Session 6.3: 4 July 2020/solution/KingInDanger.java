/*

Which King In Danger? 


Imagine a chessboard in which white pieces (always at the bottom) and black pieces (always at the top)
are represented by capital and small letters respectively. 
So, the King, the Queen, the Bishop, the Knight, 
the Rook and Pawns are represented as K or k, Q or q, B or b, N or n, R or r and P or p.
Upper case white and lower case black.
These pieces follow movements as per the standard rules of chess game. 
The chessboard is configured with hyphens (-) to represent empty squares and 
different pieces (upper case or lower case letters).
Write a program to read the final state of a board configuration and probe if King (either White or Black)
under threat- If the either kings are not in threat then print all is well.
For board configuration you must output one of the following ans:
white king in danger
black king in danger
all is well

Sample input :
---k----
ppp-pppp
-----b--
---R----
--------
--------
P-PPPPPP
K-------

Sample output :
white king in danger

Sample input :
--k-----
ppp-pppp
------b-
---R----
--------
--------
P-PPPPPP
K-------

Sample output :
all is well

*/

import java.util.Scanner;

public class KingInDanger {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		char[][] board;
		int gameNumber = 0;
		boolean endGame;

		while (s.hasNext()) {
			endGame = true;
			gameNumber++;
			board = new char[8][8];
			for (int i = 0; i < 8; i++) {
				String a = s.next();
				for (int j = 0; j < 8; j++) {
					board[i][j] = a.charAt(j);
					if (board[i][j] != '-')
						endGame = false;
				}
			}
			if (endGame)
				break;

			switch (checkBoard(board)) {
			case 0:
				System.out.println("all is well");
				break;
			case 1:
				System.out.println("black king in danger");
				break;
			case 2:
				System.out.println("white king in danger");
				break;
			}

		}

	}

	private static int checkBoard(char[][] board) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == 'k') {

					if (lookForn(board, 'N', i, j))
						return 1;

					if (lookForp(board, 'P', i, j)) // Pawn
						return 1;

					if (lookForr(board, 'R', i, j)) // Rook
						return 1;

					if (lookForb(board, 'B', i, j))// Bishop
						return 1;

					if (lookForq(board, 'Q', i, j))// Queen
						return 1;

					if (lookFork(board, 'K', i, j))// King
						return 1;

				}
				if (board[i][j] == 'K') {

					if (lookForn(board, 'n', i, j))
						return 2;

					if (lookForp(board, 'p', i, j)) // Pawn
						return 2;

					if (lookForr(board, 'r', i, j)) // Rook
						return 2;

					if (lookForb(board, 'b', i, j))// Bishop
						return 2;

					if (lookForq(board, 'q', i, j))// Queen
						return 2;

					if (lookFork(board, 'k', i, j))// King
						return 2;
				}
			}
		}
		return 0;
	}

	private static boolean lookFork(char[][] board, char c, int i, int j) {

		if (inBounds(i - 1, j - 1) && board[i - 1][j - 1] == c) {
			return true;
		}
		if (inBounds(i - 1, j) && board[i - 1][j] == c) {
			return true;
		}
		if (inBounds(i - 1, j + 1) && board[i - 1][j + 1] == c) {
			return true;
		}

		if (inBounds(i, j - 1) && board[i][j - 1] == c) {
			return true;
		}
		if (inBounds(i, j + 1) && board[i][j + 1] == c) {
			return true;
		}

		if (inBounds(i + 1, j - 1) && board[i + 1][j - 1] == c) {
			return true;
		}
		if (inBounds(i + 1, j) && board[i + 1][j] == c) {
			return true;
		}
		if (inBounds(i + 1, j + 1) && board[i + 1][j + 1] == c) {
			return true;
		}

		return false;
	}

	private static boolean lookForq(char[][] board, char c, int i, int j) {
		if (lookForb(board, c, i, j) || lookForr(board, c, i, j))
			return true;
		return false;
	}

	private static boolean lookForb(char[][] board, char c, int i, int j) {

		int k = 0;
		while (inBounds(i + ++k, j + k)) {
			if (board[i + k][j + k] == c)
				return true;
			if (board[i + k][j + k] != '-')
				break;
		}
		k = 0;
		while (inBounds(i + ++k, j - k)) {
			if (board[i + k][j - k] == c)
				return true;
			if (board[i + k][j - k] != '-')
				break;
		}
		k = 0;
		while (inBounds(i - ++k, j + k)) {
			if (board[i - k][j + k] == c)
				return true;
			if (board[i - k][j + k] != '-')
				break;
		}
		k = 0;
		while (inBounds(i - ++k, j - k)) {
			if (board[i - k][j - k] == c)
				return true;
			if (board[i - k][j - k] != '-')
				break;
		}

		return false;

	}

	private static boolean lookForr(char[][] board, char c, int i, int j) {

		int k = 0;

		while (inBounds(i + ++k, j)) {
			if (board[i + k][j] == c)
				return true;
			if (board[i + k][j] != '-')
				break;
		}
		k = 0;
		while (inBounds(i + --k, j)) {
			if (board[i + k][j] == c)
				return true;
			if (board[i + k][j] != '-')
				break;
		}
		k = 0;
		while (inBounds(i, j + ++k)) {
			if (board[i][j + k] == c)
				return true;
			if (board[i][j + k] != '-')
				break;
		}
		k = 0;
		while (inBounds(i, j + --k)) {
			if (board[i][j + k] == c)
				return true;
			if (board[i][j + k] != '-')
				break;
		}
		return false;

	}

	private static boolean lookForn(char[][] board, char c, int i, int j) {

		char lookFor;
		if (Character.isUpperCase(c))
			lookFor = 'N';
		else
			lookFor = 'n';

		if (inBounds(i + 2, j + 1) && board[i + 2][j + 1] == lookFor)
			return true;
		if (inBounds(i + 2, j - 1) && board[i + 2][j - 1] == lookFor)
			return true;
		if (inBounds(i - 2, j + 1) && board[i - 2][j + 1] == lookFor)
			return true;
		if (inBounds(i - 2, j - 1) && board[i - 2][j - 1] == lookFor)
			return true;

		if (inBounds(i + 1, j + 2) && board[i + 1][j + 2] == lookFor)
			return true;
		if (inBounds(i + 1, j - 2) && board[i + 1][j - 2] == lookFor)
			return true;
		if (inBounds(i - 1, j + 2) && board[i - 1][j + 2] == lookFor)
			return true;
		if (inBounds(i - 1, j - 2) && board[i - 1][j - 2] == lookFor)
			return true;

		return false;
	}

	private static boolean lookForp(char[][] board, char c, int i, int j) {

		char lookFor;
		if (Character.isUpperCase(c)) {
			lookFor = 'P';
			if (inBounds(i + 1, j - 1) && board[i + 1][j - 1] == lookFor)
				return true;
			if (inBounds(i + 1, j + 1) && board[i + 1][j + 1] == lookFor)
				return true;
		} else {
			lookFor = 'p';
			if (inBounds(i - 1, j - 1) && board[i - 1][j - 1] == lookFor)
				return true;
			if (inBounds(i - 1, j + 1) && board[i - 1][j + 1] == lookFor)
				return true;
		}

		return false;
	}

	private static boolean inBounds(int i, int j) {

		if (i >= 0 && i < 8 && j >= 0 && j < 8)
			return true;

		return false;
	}

}

