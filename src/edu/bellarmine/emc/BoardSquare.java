package edu.bellarmine.emc;

/**
 * This class represents a square of the chessboard.
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

public class BoardSquare {
	
	private char file;//the square's file - in the range 'a' through 'h'
	private short rank;//the square's rank - in the range 1 through 8
	private int knightAccess;//the accessibility of the square to the knight
	private int moveNumber;//the move on which the knight landed on the square
	
	/**
	 * Empty-argument constructor - sets the file to 'a', the rank to 1, and the knightAccess to 2.
	 */
	public BoardSquare() {
		
		this.setFile('a');
		this.setRank((short)1);
		this.setKnightAccess(2);
		this.setMoveNumber(0);
		
	}// end empty-argument constructor
	
	/**
	 * Full-argument constructor
	 * @param f - the file to set
	 * @param r - the rank to set
	 * @param ka - the knightAccess to set
	 */
	public BoardSquare(char f, int r, int ka) {
		
		this.setFile(f);
		this.setRank((short)r);
		this.setKnightAccess(ka);
		this.setMoveNumber(0);
		
	}// end full-argument constructor
	
	/**
	 * Decreases the knightAccess by 1 if it is at least 1 - leaves it at alone otherwise
	 * @return whether we successfully decreased the knightAccess
	 */
	public boolean movedAround() {
		
		if (knightAccess >= 1) {
			knightAccess -= 1;
			return true;
		}
		
		return false;
	}// end "moveKnightTo" method
	
	/**
	 * @return the moveNumber
	 */
	public int getMoveNumber() {
		return moveNumber;
	}

	/**
	 * @param moveNumber - the moveNumber to set
	 */
	public void setMoveNumber(int moveNum) {
		moveNumber = moveNum;
	}

	/**
	 * @return the file
	 */
	public char getFile() {
		return file;
	}

	/**
	 * Bounds check - file passed has to be in the range 'a' through 'h'
	 * @param f - the file to set
	 */
	public void setFile(char f) {
		
		if (f < 'a' || f > 'h') {
			//file = 'a';
		}
		else {
			file = f;
		}
	}

	/**
	 * @return the rank
	 */
	public short getRank() {
		return rank;
	}

	/**
	 * Bounds check - rank passed has to be in the range 1 through 8
	 * @param r - the rank to set
	 */
	public void setRank(short r) {
		
		if (r < 1 || r > 8) {
			rank = 1;
		}
		else {
			rank = r;
		}
	}

	/**
	 * @return the knightAccess
	 */
	public int getKnightAccess() {
		return knightAccess;
	}

	/**
	 * @param ka - the knightAccess to set
	 */
	public void setKnightAccess(int ka) {
		knightAccess = ka;
	}
	
	/**
	 * @return the current values of file, rank, knightAccess, and moveNumber
	 */
	@Override
	public String toString() {
		return "BoardSquare [file = " + file + ", rank = " + rank + ", knightAccess = " + knightAccess + ", moveNumber = " + moveNumber + "]";
	}
	
}// end "BoardSpuare" class
