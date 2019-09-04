package edu.bellarmine.emc;

/**
 * This class executes the simulation.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class Application {
	
	/**
	 * Execution starts here.
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Board chessBoard = new Board();
		
		//Knight knight = new Knight(chessBoard.boardArray[3][3]);
		
		TextWriter recordWriter = new TextWriter("test.txt");
		
		for (short i = 1; i <= 10; i++) {
			
			recordWriter.writeRecord("This is line " + i);
			
		}
		
	}// end main

}// end class
