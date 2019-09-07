package edu.bellarmine.emc;

/**
 * This class represents the chessboard using a 2d array of 64 BoardSquares (8x8).
 * 
 * @author Ethan Colbert
 * @version 1.0
 * Programming Project 1
 * Fall 2019
 */

 class Board {
	 
	 /* This array represents the chessboard. */
	 public final BoardSquare[][] boardArray = {
			 
			 {new BoardSquare('a', 8, 2), new BoardSquare('b', 8, 3), new BoardSquare('c', 8, 4), new BoardSquare('d', 8, 4), new BoardSquare('e', 8, 4), new BoardSquare('f', 8, 4), new BoardSquare('g', 8, 3), new BoardSquare('h', 8, 2)},
			 {new BoardSquare('a', 7, 3), new BoardSquare('b', 7, 4), new BoardSquare('c', 7, 6), new BoardSquare('d', 7, 6), new BoardSquare('e', 7, 6), new BoardSquare('f', 7, 6), new BoardSquare('g', 7, 4), new BoardSquare('h', 7, 3)},
			 {new BoardSquare('a', 6, 4), new BoardSquare('b', 6, 6), new BoardSquare('c', 6, 8), new BoardSquare('d', 6, 8), new BoardSquare('e', 6, 8), new BoardSquare('f', 6, 8), new BoardSquare('g', 6, 6), new BoardSquare('h', 6, 4)},
			 {new BoardSquare('a', 5, 4), new BoardSquare('b', 5, 6), new BoardSquare('c', 5, 8), new BoardSquare('d', 5, 8), new BoardSquare('e', 5, 8), new BoardSquare('f', 5, 8), new BoardSquare('g', 5, 6), new BoardSquare('h', 5, 4)},
			 {new BoardSquare('a', 4, 4), new BoardSquare('b', 4, 6), new BoardSquare('c', 4, 8), new BoardSquare('d', 4, 8), new BoardSquare('e', 4, 8), new BoardSquare('f', 4, 8), new BoardSquare('g', 4, 6), new BoardSquare('h', 4, 4)},
			 {new BoardSquare('a', 3, 4), new BoardSquare('b', 3, 6), new BoardSquare('c', 3, 8), new BoardSquare('d', 3, 8), new BoardSquare('e', 3, 8), new BoardSquare('f', 3, 8), new BoardSquare('g', 3, 6), new BoardSquare('h', 3, 4)},
			 {new BoardSquare('a', 2, 3), new BoardSquare('b', 2, 4), new BoardSquare('c', 2, 6), new BoardSquare('d', 2, 6), new BoardSquare('e', 2, 6), new BoardSquare('f', 2, 6), new BoardSquare('g', 2, 4), new BoardSquare('h', 2, 3)},
			 {new BoardSquare('a', 1, 2), new BoardSquare('b', 1, 3), new BoardSquare('c', 1, 4), new BoardSquare('d', 1, 4), new BoardSquare('e', 1, 4), new BoardSquare('f', 1, 4), new BoardSquare('g', 1, 3), new BoardSquare('h', 1, 2)}
			 
	 };
	 
	 /**
	  * Empty-argument constructor
	  */
	 public Board() {
		 
	 }// end empty-argument constructor

	@Override
	public String toString() {
		return "Board [Chess]";
	}
	
}// end "Board" class
