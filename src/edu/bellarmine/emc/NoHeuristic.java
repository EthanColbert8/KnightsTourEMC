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
	private static TextWriter writer = new TextWriter("NoHeuristicRecord.txt");
	
	private static Board board = new Board();
	private static Knight knight = new Knight();
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		BoardSquare candidate, lastSquare, initialSquare;
		
		for (int i = 1; i <= 10; i++) {
			
			knight.setCurrentSquare(board.boardArray[random.nextInt(8)][random.nextInt(8)]);
			initialSquare = knight.getCurrentSquare();
			initialSquare.setMoveNumber(64);
			
			int currentMove = 1;
			
			boolean done = false;
			while (!(done)) {
				
				lastSquare = knight.getCurrentSquare();
				
				int count = 0;
				boolean moved = false;
				do {
					
					candidate = selectMove();
					
					if (candidate.getMoveNumber() == 0 || candidate.getMoveNumber() == 64) {
						
						if (currentMove == 64 || candidate.getMoveNumber() == 0) {
							knight.move(candidate);
							moved = true;
						}
						
					}
					
					count++;
					if (count >= 10000) {
						moved = true;
					}
					
				} while (!(moved));
				
				if (lastSquare.getRank() == knight.getCurrentSquare().getRank()) {
					done = true;
				}
				else {
					knight.getCurrentSquare().setMoveNumber(currentMove);
					currentMove++;
				}
				
				if (currentMove >= 65) {
					done = true;
				}
				
			}//
			
			if (knight.getCurrentSquare().getMoveNumber() == 64) {
				writer.writeRecord("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + 64 + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]*");
			}
			else {
				writer.writeRecord("[" + initialSquare.getFile() + initialSquare.getRank() + ", " + knight.getCurrentSquare().getMoveNumber() + ", " + knight.getCurrentSquare().getFile() + knight.getCurrentSquare().getRank() + "]");
			}
			
		}
		
	}// end main
	
	/**
	 * SUPPORT METHOD - randomly selects a legal move for the knight.
	 * @return a randomly selected square the knight can legally move to.
	 */
	private static BoardSquare selectMove() {
		
		int[] currentCoordinates = {(8 - knight.getCurrentSquare().getRank()), (knight.getCurrentSquare().getFile() - 97)};
		int[] newCoordinates = new int[2];
		
		boolean legal = false;
		do {
			
			boolean xSelected = false;
			do {
				newCoordinates[0] = currentCoordinates[0] + (random.nextInt(5) - 2);
				
				if (newCoordinates[0] != currentCoordinates[0]) {
					xSelected = true;}
				
			} while (!(xSelected));
			
			boolean posOrNeg = random.nextBoolean();
			if (Math.abs(newCoordinates[0] - currentCoordinates[0]) == 1) {
				
				if (posOrNeg) {
					newCoordinates[1] = currentCoordinates[1] + 2;
				}
				else {
					newCoordinates[1] = currentCoordinates[1] - 2;
				}
				
			}
			else {
				
				if (posOrNeg) {
					newCoordinates[1] = currentCoordinates[1] + 1;
				}
				else {
					newCoordinates[1] = currentCoordinates[1] - 1;
				}
				
			}
			
			try {
				return board.boardArray[newCoordinates[0]][newCoordinates[1]];
				//legal = true;
			}
			catch(ArrayIndexOutOfBoundsException e) {}
			
		} while (!(legal));
		
		return new BoardSquare();//Needed to add this line to prevent compile-time error, should never run.
	}// end "selectMove" support method
	
}// end class