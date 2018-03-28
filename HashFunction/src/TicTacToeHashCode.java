
import java.io.*;
import java.util.*;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	int arraySize = (int) Math.pow(3, 9);
	boolean[] winners; // True if the hash string that maps to this index is a winner, false
						// otherwise

	TicTacToeHashCode(String s) {
		
		super(s);
		//System.out.println(s);
		Scanner input = openFile("TicTacToeWinners.txt");

		winners = new boolean[arraySize];

		while (input.hasNextLine()) {
			System.out.println(super.getBoardString());
			super.setBoardString(input.nextLine());
			System.out.println(super.getBoardString());
			// int winner = myHashCode();
			System.out.println(myHashCode());
			// winners[winner] = true;
			// System.out.println(winner);
		}

	}

	// TODO - write the myHashCode function. It must create a unique hashcode
	// for all of the
	// possible values the game board (3 ^ 9) and it MUST use the
	// super.charAt(row, col) function////
	@Override
	public int myHashCode() {
		int num = 0;
		int[][] pow3 = { { 1, 3, 9 }, { 27, 81, 243 }, { 729, 2187, 6561 } };

		for (int i = 0; i < TicTacToe.ROWS; i++) {
			for (int j = 0; j < TicTacToe.COLS; j++) {
				char ch = super.charAt(i, j);
				// System.out.print(ch);
				if (ch == 'x') {
					num += pow3[i][j];
				} else if (ch == 'o') {
					num += 2 * pow3[i][j];
				}
			}
		}
		// System.out.println(num);
		return num;
	}

	@Override
	public boolean isWin(String s) {
		// TODO return the value in the winner array for the hash chode of the board
		// string sent in.
		// return the value in the winner array for the hash code of the board
		// string sent in.
		// Scanner input = openFile("Winners.txt");

		
		//while()
		// while (input.hasNextLine()) {
		// if (input.next().equals(s)) {
		// return true;
		// }
		// }
		return false;

	}

	@Override
	public boolean isWin() {
		// TODO return the value in the winner array for the hash chode of the current
		// board string.
		return true;
	}

	public Scanner openFile(String fName) {

		File file = new File(fName);
		Scanner kb = null;
		try {
			kb = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file: " + fName);
			return null;
		}
		return kb;
	}

	/**
	 * This reads input to the output File
	 * 
	 * @param fName
	 *            name of the file
	 * @return the output
	 */
	public PrintWriter readToFile(String fName) {
		File file = new File(fName);
		PrintWriter input = null;
		try {
			input = new PrintWriter(file);
		} catch (FileNotFoundException ex) {
			System.out.println("Cant open file: " + fName);
			return null;
		}
		return input;
	}

	public static void main(String[] args) throws InterruptedException {

		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");

	}

}
