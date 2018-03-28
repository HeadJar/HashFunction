
import java.io.*;
import java.util.*;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	int arraySize = (int) Math.pow(3, 9);
	boolean[] winners = new boolean[arraySize]; // True if the hash string that maps to this index is a winner, false
						// otherwise

	TicTacToeHashCode(String s) {
		
		super(s);
		//System.out.println(s);
		Scanner input = openFile("TicTacToeWinners.txt");

		

		while (input.hasNextLine()) {
		//System.out.println(input.);
			super.setBoardString(input.nextLine());
			int winner = myHashCode();
			 winners[winner] = true;
			 //System.out.println(winner);
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
	 *  name of the file
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

	@Override
	boolean isWin(String s) {
		// TODO Auto-generated method stub
		return false;
	}

}
