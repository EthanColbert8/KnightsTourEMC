package edu.bellarmine.emc;

/**
 * This class represents a knight on the chessboard.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */
public class Knight {
	
	private BoardSquare currentSquare;//the square the knight is currently on.
	
	/**
	 * Empty-argument constructor - sets currentSquare to a new BoardSquare with file 'a' and rank 1.
	 */
	public Knight() {
		
		this.setCurrentSquare(new BoardSquare());
		
	}// end empty-argument constructor
	
	/**
	 * Full-argument constructor
	 * @param initialSquare - the square the knight starts on.
	 */
	public Knight(BoardSquare initialSquare) {
		
		this.setCurrentSquare(initialSquare);
		
	}// end full-argument constructor
	
	/* YOU STILL NEED TO WRITE THIS METHOD */
	/**
	 * This method attempts to move the knight to a specified square.
	 * @param targetSquare - the square you want to move the knight to.
	 * @return whether the knight successfully moved to the square.
	 */
	public boolean move(BoardSquare targetSquare) {
		
		
		return true;
	}// end "move" method
	
	/**
	 * @return the currentSquare
	 */
	public BoardSquare getCurrentSquare() {
		return currentSquare;
	}

	/**
	 * @param currentSquare - the currentSquare to set
	 */
	public void setCurrentSquare(BoardSquare newSquare) {
		this.currentSquare = newSquare;
	}

	@Override
	public String toString() {
		return "Knight [currentSquare = " + currentSquare + "]";
	}
	
}// end "Knight" class
