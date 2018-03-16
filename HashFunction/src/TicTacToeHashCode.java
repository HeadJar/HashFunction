import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//TODO Make sure you remove all of the TODO comments from this file before turning itin

public class TicTacToeHashCode extends Board {

	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
		// TODO Instantiate/fill winners array.
	}

	// TODO - write the myHashCode function. It must create a unique hashcode for
	// all of the
	// possible values the game board (3 ^ 9) and it MUST use the super.charAt(row,
	// col) function
	@Override
	public int myHashCode() {
		int pow3[][] = { { 1, 3, 9 }, { 27, 81, 243 }, { 729, 2187, 6561 } };

		int num = 0;

		for (int i = 0; i < TicTacToe.ROWS; i++) {
			for (int j = 0; i < TicTacToe.COLS; i++) {
				char ch = super.charAt(i, j);
				if (ch == ('X')) {
					num += pow3[i][j];
				} else if (ch == ('O')) {
					num += 2 * pow3[i][j];
				}
			}

		}

		return num;
	}

	public boolean isWin(String s) {
		// return the value in the winner array for the hash chode of the board string
		// sent in.
		return true;
	}

	public static void main(String[] args) throws InterruptedException {

		Scanner user = new Scanner(System.in);
		String inputFileName, outputFileName;
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
		
		

		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		while (true) {

			String currentBoard = board.boardValues[(int) (Math.random() * board.boardValues.length)];
			board.show(currentBoard);
			board.setHashCode(board.myHashCode());
			// TODO Update this line to call your isWin method.

			board.setWinner(TicTacToe.isWin(currentBoard));

			Thread.sleep(4000);
		}
	}
}