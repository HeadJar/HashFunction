
import java.io.*;
import java.util.*;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	/**
	 * name of the file with the winning tic tac toe setups
	 */
	public static final String WINNERS_FILE_NAME = "TicTacToeWinners.txt";
	
	
	int arraySize = (int) Math.pow(3, 9);
	boolean[] winners ; // True if the hash string that maps to this index is a winner, false
												// otherwise

	TicTacToeHashCode(String s) {
		super(s);
		// TODO Instantiate/fill winners array.
		Scanner input = openFile(WINNERS_FILE_NAME);

		winners = new boolean[arraySize];
		
		while (input.hasNextLine()) {

			super.setBoardString(input.next());
			int winner = myHashCode();

			winners[winner] = true;
			System.out.println(winners[winner]);
		}

	}

	// TODO - write the myHashCode function. It must create a unique hashcode
	// for all of the
	// possible values the game board (3 ^ 9) and it MUST use the
	// super.charAt(row, col) function
	@Override
	public int myHashCode() {
		int num = 0;
		int[][] pow3 = { { 1, 3, 9 }, { 27, 81, 243 }, { 729, 2187, 6561 } };

		for (int i = 0; i < TicTacToe.ROWS; i++) {
			for (int j = 0; j < TicTacToe.COLS; j++) {
				char ch = super.charAt(i, j);
				if (ch == 'x') {
					num += pow3[i][j];
				} else if (ch == 'o') {
					num += 2 * pow3[i][j];
				}

			}
		}
		return num;
	}

	@Override
	public boolean isWin(String s) {
		// TODO return the value in the winner array for the hash chode of the board
		// string sent in.
		// return the value in the winner array for the hash code of the board
		// string sent in.
		Scanner input = openFile("Winners.txt");

		while (input.hasNextLine()) {
			if (input.next().equals(s)) {
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean isWin() {
		// TODO return the value in the winner array for the hash chode of the current
		// board string.
		return true;
	}

	/**
	 * Opens file for reading
	 * 
	 * @param fName
	 *            name of file
	 * @return returns the scanner ready for testing
	 */

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
/*
		Scanner user = new Scanner(System.in);
		String inputFileName;
		File input = null;
		Scanner scan = null;
		if (args.length < 1) {
			System.out.print("Input File Name: ");
			inputFileName = user.nextLine().trim();
			input = new File(inputFileName);

		} else {

			input = new File(args[0]);
			try {
				scan = new Scanner(input);
			} catch (FileNotFoundException ex) {
				System.out.println("Please enter file");

			}

		}

		// prepare the input file

		try {
			scan = new Scanner(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		//while (true) {

			// TODO this line no longer works
			// String currentBoard = board.boardValues[(int)(Math.random()*
			// board.boardValues.length)];

		//	board.displayRandomString();
		//	board.setHashCodeLabel(board.myHashCode());
			// TODO Update this line to call your isWin method.
			// board.setWinner(TicTacToe.isWin(currentBoard));

		//	Thread.sleep(4000);
		//}
	}

}
