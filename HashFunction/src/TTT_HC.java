import java.io.*;
import java.util.*;
public class TTT_HC extends Board{


	public TTT_HC(String title) {
		super(title);
		// TODO Auto-generated constructor stub
		
		int arraySize = (int) Math.pow(3, 9);
	
		for(int i = 0;i<)
		
		
	}

	public int myHasHCode() {
		int num = 0;
		int[][] pow3 = { { 0, 3, 6 }, { 9, 12, 15 }, { 18, 21, 24 } };
		
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
	int myHashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	boolean isWin(String s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean isWin() {
		// TODO Auto-generated method stub
		return false;
	}
}
