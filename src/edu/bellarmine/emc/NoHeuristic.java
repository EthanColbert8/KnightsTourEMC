package edu.bellarmine.emc;

import java.util.Random;

/**
 * This class executes the randomized version of the simulation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class NoHeuristic {
	
	private static Random random = new Random();
	private static TextWriter writer = new TextWriter("NoHeuristicRecord.txt");//writes to the file
	
	private static Board board = new Board();//represents the chessboard
	private static Knight knight = new Knight();//represents the knight
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		BoardSquare lastSquare, initialSquare;//they keep track of the square the knight starts on and the immediately previous one
		BoardSquare[] candidates;//an array to store all the knight's current legal moves
		
		for (int i = 1; i <= 1000; i++) {
			
			for (BoardSquare[] a : board.boardArray) {
				
				for (BoardSquare b : a) {
					b.setMoveNumber(0);
				}
				
			}
			
			knight.setCurrentSquare(board.boardArray[random.nextInt(8)][random.nextInt(8)]);
			initialSquare = knight.getCurrentSquare();
			initialSquare.setMoveNumber(64);
			
			int currentMove = 1;
			
			boolean done = false;
			while (!(done)) {
				
				lastSquare = knight.getCurrentSquare();
				candidates = selectMove();
				
				/* This loop moves the knight to a random square it can legally move to,
				 * or leaves it alone if it has no more moves. */
				for (int j = 0; j < candidates.length; j++) {
					
					try {
						
						if (candidates[j].getMoveNumber() == 0 || (candidates[j].getMoveNumber() == 64 && currentMove == 64)) {
							knight.move(candidates[j]);
							j = candidates.length;
						}
						
					}
					catch(NullPointerException e) {}
					
				}
				
				/* This bit decides whether to attempt another move or stop. */
				if (lastSquare.getRank() == knight.getCurrentSquare().getRank()) {
					done = true;
				}
				else {
					knight.getCurrentSquare().setMoveNumber(currentMove);
					currentMove++;
				}
				
			}
			
			/* This bit writes the results of the tour to the records. */
			if (knight.getCurrentSquare().getMoveNumber() == 64) {
				writer.writeRecord("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + 64 + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]*");
			}
			else {
				writer.writeRecord("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + knight.getCurrentSquare().getMoveNumber() + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]");
			}
			
		}
		
	}// end main
	
	/**
	 * SUPPORT METHOD - returns an array of all the knight's legal moves in a random order.
	 * @return an array of all the knight's legal moves in a random order
	 */
	private static BoardSquare[] selectMove() {
		
		int[] currentCoordinates = {(8 - knight.getCurrentSquare().getRank()), (knight.getCurrentSquare().getFile() - 97)};
		//stores the array indices of the knight's current square.
		
		BoardSquare[] moves = new BoardSquare[8];
		
		/* These blocks fill the array with all the squares the knight can legally move to,
		 * leaving the array slots set to null if the possibilities are outside the chessboard. */
		try {
			moves[0] = board.boardArray[currentCoordinates[0] - 2][currentCoordinates[1] + 1];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[1] = board.boardArray[currentCoordinates[0] - 1][currentCoordinates[1] + 2];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[2] = board.boardArray[currentCoordinates[0] + 1][currentCoordinates[1] + 2];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[3] = board.boardArray[currentCoordinates[0] + 2][currentCoordinates[1] + 1];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[4] = board.boardArray[currentCoordinates[0] + 2][currentCoordinates[1] - 1];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[5] = board.boardArray[currentCoordinates[0] + 1][currentCoordinates[1] - 2];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[6] = board.boardArray[currentCoordinates[0] - 1][currentCoordinates[1] - 2];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		try {
			moves[7] = board.boardArray[currentCoordinates[0] - 2][currentCoordinates[1] - 1];
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		shuffleArray(moves);
		
		return moves;
	}// end "selectMove" support method
	
	/**
	 * SUPPORT METHOD - shuffles an array of BoardSquare objects.
	 * @param array - the array to be shuffled
	 */
	private static void shuffleArray(BoardSquare[] array) {
		
		BoardSquare temporarySquare;
		int rand;
		
		for (int i = 0; i < array.length; i++) {
			
			rand = random.nextInt(array.length);
			
			//Switches the square at index i with that at index rand.
			temporarySquare = array[i];
			array[i] = array[rand];
			array[rand] = temporarySquare;
			
		}
		
	}// end "shuffleArray" support method
	
}// end class