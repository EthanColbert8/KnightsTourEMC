package edu.bellarmine.emc;

/**
 * This class executes the randomized version of the simulation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class Heuristic {
	
	private static TextWriter writer = new TextWriter("HeuristicRecord.txt");//writes to the file
	
	private static Board board = new Board();//represents the chessboard
	private static Knight knight = new Knight();//represents the knight
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		BoardSquare lastSquare, initialSquare;//they keep track of the square the knight starts on and the immediately previous one
		BoardSquare[] candidates, otherSquares;//an array to store all the knight's current legal moves,
		//and one to tell us what squares to decrease the accessibility of after we move
		
		int currentMove;//how many moves the knight's taken up to the current point in the tour
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				
				board = new Board();//this is needed to reset all the moveNumber and knightAccessibility values
				
				initialSquare = board.boardArray[i][j];
				knight.setCurrentSquare(initialSquare);
				initialSquare.setMoveNumber(64);//this lets us make sure we don't jump back to the starting square before finishing the tour
				
				currentMove = 1;
				
				boolean done = false;
				while (!(done)) {
					
					lastSquare = knight.getCurrentSquare();
					candidates = selectMove();
					
					for (int k = 0; k < candidates.length; k++) {
						
						try {
							
							if (candidates[k].getMoveNumber() == 0 || (candidates[k].getMoveNumber() == 64 && currentMove == 64)) {
								knight.move(candidates[k]);
								k = candidates.length;
							}
							
						}
						catch(NullPointerException e) {}
						
					}
					
					/* This bit decides whether to attempt another move or stop,
					 * then takes care of some housekeeping if we keep going. */
					if (lastSquare.getRank() == knight.getCurrentSquare().getRank()) {
						done = true;
					}
					else {
						knight.getCurrentSquare().setMoveNumber(currentMove);
						
						/* This bit decreases the accessibility of the necessary squares after we move. */
						otherSquares = selectMove();
						for (BoardSquare e : otherSquares) {
							
							try {
								e.movedAround();
							}
							catch(NullPointerException g) {}
							
						}
						
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
				
			}//end inner main for loop
			
		}

	}// end main
	
	/**
	 * SUPPORT METHOD - returns an array of the knight's legal moves, in order of lowest accessibility
	 * @return the knight's legal moves in preferred order
	 */
	private static BoardSquare[] selectMove() {
		
		int[] currentCoordinates = {(8 - knight.getCurrentSquare().getRank()), (knight.getCurrentSquare().getFile() - 97)};
		//stores the array indices of the knight's current square.
		
		BoardSquare[] moves = new BoardSquare[8], movesNoNulls;
		
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
		
		movesNoNulls = trimNulls(moves);
		
		sortArray(movesNoNulls);
		
		return movesNoNulls;
	}// end "selectMove" support method
	
	/**
	 * SUPPORT METHOD - sorts the given array from low to high knight accessibility
	 * @param array - the array to be sorted
	 */
	private static void sortArray(BoardSquare[] array) {
		
		BoardSquare temporarySquare;
		
		for (int i = 0; i < (array.length - 1); i++) {
			
			if (array[i].getKnightAccess() > array[i + 1].getKnightAccess()) {
				
				//Switches the two squares in the array
				temporarySquare = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temporarySquare;
				
				i = 0;
			}
			
		}
		
	}// end "sortArray" support method
	
	/**
	 * SUPPORT METHOD - trims nulls out of an array of BoardSquares
	 * @param toTrim - the array to be trimmed
	 * @return a shorter array containing all non-null elements of toTrim
	 */
	private static BoardSquare[] trimNulls(BoardSquare[] toTrim) {
		
		int countNulls = 0, count;
		
		for (BoardSquare a : toTrim) {
			if (a == null) {
				countNulls++;
			}
		}
		
		BoardSquare[] newArray = new BoardSquare[toTrim.length - countNulls];
		
		count = 0;
		for (int i = 0; i < newArray.length; i++) {
			
			boolean found = false;
			while (!(found)) {
				
				if (toTrim[count] != null) {
					newArray[i] = toTrim[count];
					found = true;
				}
				
				count++;
			}
			
		}
		
		return newArray;
	}// end "trimNulls" support method
	
}// end class
