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
	
	static Random random = new Random();
	static BoardSquare[] possibilities = new BoardSquare[8];
	static int[] coordinates = {random.nextInt(8), random.nextInt(8)};
	
	static Board board = new Board();
	static Knight knight = new Knight(board.boardArray[coordinates[0]][coordinates[1]]);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BoardSquare initialSquare = knight.getCurrentSquare();
		
		System.out.println(initialSquare.toString());
		
		int currentMove = 1;
		
		boolean finished = false;
		
		while(!(finished)) {
			
			BoardSquare lastSquare = knight.getCurrentSquare();
			
			runCircle();
			
			for (int i = 0; i < possibilities.length; i++) {
				
				try {
					
					knight.move(possibilities[i]);
					
					knight.getCurrentSquare().setMoveNumber(currentMove);
					
					updateCoordinates(i);
					
					i = possibilities.length;
					
					System.out.println(knight.getCurrentSquare().toString());
					
				}
				catch(NullPointerException e) {
					
				}
				
			}
			
			if (currentMove == 64 && knight.getCurrentSquare().getRank() != lastSquare.getRank()) {
				
				System.out.println("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + (currentMove - 1) + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]*");
				//In reality, we'd print out the info to the file.
				
				finished = true;
			}
			else if (knight.getCurrentSquare().getRank() == lastSquare.getRank()) {
				
				System.out.println("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + (currentMove - 1) + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]");
				//In reality, we'd print out the info to the file.
				
				finished = true;
			}
			else {
				currentMove++;
			}
			
		}
		
	}// end main
	
	/**
	 * SUPPORT METHOD - fills the "possibilities" array with all legal knight moves that are possible.
	 */
	private static void runCircle() {
		
		BoardSquare test;
		
		try {
			test = board.boardArray[coordinates[0] - 2][coordinates[1] + 1];
			
			if (test.getMoveNumber() == 0) {
				possibilities[0] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] - 1][coordinates[1] + 2];

			if (test.getMoveNumber() == 0) {
				possibilities[1] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] + 1][coordinates[1] + 2];
			
			if (test.getMoveNumber() == 0) {
				possibilities[2] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] + 2][coordinates[1] + 1];
			
			if (test.getMoveNumber() == 0) {
				possibilities[3] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] + 2][coordinates[1] - 1];
			
			if (test.getMoveNumber() == 0) {
				possibilities[4] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] + 1][coordinates[1] - 2];
			
			if (test.getMoveNumber() == 0) {
				possibilities[5] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] - 1][coordinates[1] - 2];
			
			if (test.getMoveNumber() == 0) {
				possibilities[6] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
		try {
			test = board.boardArray[coordinates[0] - 2][coordinates[1] - 1];
			
			if (test.getMoveNumber() == 0) {
				possibilities[7] = test;
			}
			
		}
		catch(ArrayIndexOutOfBoundsException e) {}
		
	}// end "runCircle" method
	
	/**
	 * SUPPORT METHOD - updates the coordinates field to the new square when the knight moves.
	 * @param numMove - the option label we used
	 */
	private static void updateCoordinates(int numMove) {
		
		if (numMove == 0) {
			coordinates[0] -= 2;
			coordinates[1] += 1;
		}
		else if (numMove == 1) {
			coordinates[0] -= 1;
			coordinates[1] += 2;
		}
		else if (numMove == 2) {
			coordinates[0] += 1;
			coordinates[1] += 2;
		}
		else if (numMove == 3) {
			coordinates[0] += 2;
			coordinates[1] += 1;
		}
		else if (numMove == 4) {
			coordinates[0] += 2;
			coordinates[1] -= 1;
		}
		else if (numMove == 5) {
			coordinates[0] += 1;
			coordinates[1] -= 2;
		}
		else if (numMove == 6) {
			coordinates[0] -= 1;
			coordinates[1] -= 2;
		}
		else if (numMove == 7) {
			coordinates[0] -= 2;
			coordinates[1] -= 1;
		}
		
	}// end "updateCoordinates" support method
	
}// end class
