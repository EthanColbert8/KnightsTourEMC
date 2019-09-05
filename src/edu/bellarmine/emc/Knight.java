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
	
	/**
	 * This method attempts to move the knight to a specified square.
	 * @param targetSquare - the square we want to move the knight to.
	 * @return whether the knight successfully moved to the square.
	 */
	public boolean move(BoardSquare targetSquare) {
		
		if (canMoveTo(targetSquare)) {
		  
		  	this.setCurrentSquare(targetSquare);
			return true;
			
		}
		
		return false;
		
	}// end "move" method
	
	/**
	 * This method checks to see whether a specified square can be legally moved to by the knight.
	 * @param candidate - the square we want to move the knight to.
	 * @return whether "candidate" is a legal move for the knight.
	 */
	private boolean canMoveTo(BoardSquare candidate) {
		
		if ((Math.abs(candidate.getFile() - currentSquare.getFile()) == 2 && Math.abs(candidate.getRank() - currentSquare.getRank()) == 1) ||
				(Math.abs(candidate.getFile() - currentSquare.getFile()) == 1 && Math.abs(candidate.getRank() - currentSquare.getRank()) == 2))
		{
			return true;
		}
		
		return false;
		
	}// end "canMoveTo" method
	
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
		return "Knight [currentSquare = " + currentSquare.toString() + "]";
	}
	
}// end "Knight" class
